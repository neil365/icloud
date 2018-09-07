const log4js = require('log4js')
var express = require('express');
var zookeeper = require('node-zookeeper-client');
var httpProxy = require('http-proxy');
var cluster = require('cluster');
var os = require('os');

//日志配置
const logger = log4js.getLogger('gateway');
logger.level = 'info';
//端口
var PORT = 8084;
//Zookeeper集群配置
var CONNECTION_STRING = '192.168.1.210:2181,192.168.1.211:2181,192.168.1.212:2181';
//微服务Zookeeper节点位置
var REGISTRY_ROOT = '/services';
//定义当前应用
var app = express();
//
//集群配置
var CPUS = os.cpus().length;
if (cluster.isMaster) {
    for (var i = 0; i < CPUS; i++) {
        cluster.fork();
    }
}
else 
{
    //连接zookeeper
    var zk = zookeeper.createClient(CONNECTION_STRING);
    zk.connect();

    //创建代理服务器对象并监听错误事件
    var proxy = httpProxy.createProxyServer();
    proxy.on('error', function (err, req, res) {
        logger.error(err.stack);
        res.end();//输出空白响应数据
        return;
    });

    //启动web服务器
    app.use(express.static('public'));
    app.all('*', function (req, res) {        
        
        //处理跨域
        //设置允许跨域的域名，*代表允许任意域名跨域
        res.header("Access-Control-Allow-Origin","*");
        //允许的header类型
        res.header("Access-Control-Allow-Headers","*");
        //跨域允许的请求方式 
        res.header("Access-Control-Allow-Methods","DELETE,PUT,POST,GET,OPTIONS");
        
        //处理图标
        if (req.path == '/favicon.ico') {
            res.end();
            return;
        }
        //处理首页
        if(req.path == '/'){
            res.send('欢迎使用NodeJS！');
            return;
        }
        //忽略静态数据
        if(ms_name == 'static')
        {
            logger.error('Ignore Service:'+ms_name);
            res.end();
            return;
        }
        var ms=req.path.substring(1);
        var ms_name=ms.substring(0,ms.indexOf('/'));
        var ms_path=ms.substring(ms.indexOf('/'));
        var servicePath = REGISTRY_ROOT+'/'+ms_name;
        logger.info('req.path:'+req.path);
        logger.info('ms:'+ms);
        logger.info('ms_name:'+ms_name);
        logger.info('ms_path:'+ms_path);
        //验证服务路径
        if(ms_name == ''){
            var e = '访问的服务出错！【'+req.path+'】';
            logger.error(e);
            res.send(e);
            return;
        }

        logger.info('Service path:'+servicePath);

        //获取服务路径下的地址节点
        zk.getChildren(servicePath, function (error, addressNodes) {
            if (error) {
                logger.error(error.stack);
                res.send('服务注册信息错误！【'+req.path+'】');
                return;
            }
            logger.info('Address Nodes list:');
            logger.info(addressNodes);
            var addressPath = servicePath + "/";
            var size = addressNodes.length;
            if (size == 1) {
                //若只有唯一地址，则获取该地址
                addressPath += addressNodes[0];
            } else {
                //若存在多个地址，则随机获取一个地址
                addressPath += addressNodes[parseInt(Math.random() * size)];
            }
            logger.info('addressPath:%s', addressPath);
            //获取服务地址
            zk.getData(addressPath, function (err, serviceAddress) {
                if (err) {
                    logger.error(error.stack);
                    res.end();
                    return;
                }
                logger.info('serviceAddress:%s', serviceAddress);
                if (!serviceAddress) {
                    logger.error('serviceAddress is not exist');
                    res.end();
                    return;
                }
                var service_json = JSON.parse(serviceAddress);
                var target_host = 'http://'+ service_json.address+':' + service_json.port
                logger.info('===>target_host:'+target_host);      
                delete req.headers.host;

                //重写URL
                req.url = target_host + ms_path;

                //执行反向代理
                proxy.web(req, res, {
                    //target: 'http://' + serviceAddress //目标地址
                    target: target_host 
                });

            });

        });

    });
    //服务器监听
    app.listen(PORT, function () {
        logger.info('server is running at %d', PORT);
    });
}

