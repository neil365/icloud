package base.bill.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }   
    /**
     * HTTP-8种请求方式
     */
    public static interface Http {
//    	1	GET	请求指定的页面信息，并返回实体主体。
    	String GET = "GET";
//    	2	HEAD	类似于get请求，只不过返回的响应中没有具体的内容，用于获取报头
    	String HEAD = "HEAD";
//    	3	POST	向指定资源提交数据进行处理请求（例如提交表单或者上传文件）。数据被包含在请求体中。POST请求可能会导致新的资源的建立和/或已有资源的修改。
    	String POST = "POST";
//    	4	PUT	从客户端向服务器传送的数据取代指定的文档的内容。
    	String PUT = "PUT";
//    	5	DELETE	请求服务器删除指定的页面。
    	String DELETE = "DELETE";
//    	6	CONNECT	HTTP/1.1协议中预留给能够将连接改为管道方式的代理服务器。
        String CONNECT = "CONNECT";
//    	7	OPTIONS	允许客户端查看服务器的性能。
        String OPTIONS = "OPTIONS";
//    	8	TRACE	回显服务器收到的请求，主要用于测试或诊断。
        String TRACE = "TRACE";
    }
    /**
     * Http 请求方式(已测试：GET,POST,PUT)
     * URL
     * @return 
     */
	public static String sendHttp(String http, String path, String json) throws IOException{
		// 创建连接
		URL url = new URL(path);
		HttpURLConnection connection;
		StringBuffer sbuffer = new StringBuffer("");
			// 添加 请求内容
			connection = (HttpURLConnection) url.openConnection();
			// 设置http连接属性
			connection.setDoOutput(true);// http正文内，因此需要设为true, 默认情况下是false;
			connection.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
			// 可以根据需要 提交
			// GET、POST、DELETE、PUT等http提供的功能
			connection.setRequestMethod(http);
			// connection.setUseCaches(false);//设置缓存，注意设置请求方法为post不能用缓存
			// connection.setInstanceFollowRedirects(true);

			connection.setRequestProperty("Host", "localhost"); // 设置请
																// 求的服务器网址，域名，例如***.**.***.***
			connection.setRequestProperty("Content-Type", " application/json");// 设定
																				// 请求格式
																				// json，也可以设定xml格式的
			connection.setRequestProperty("Accept-Charset", "utf-8"); // 设置编码语言
			connection.setRequestProperty("X-Auth-Token", "token"); // 设置请求的token
			connection.setRequestProperty("Connection", "keep-alive"); // 设置连接的状态
			connection.setRequestProperty("Transfer-Encoding", "chunked");// 设置传输编码
			connection.setRequestProperty("Content-Length", json.toString()
					.getBytes().length
					+ ""); // 设置文件请求的长度

			connection.setReadTimeout(10000);// 设置读取超时时间
			connection.setConnectTimeout(10000);// 设置连接超时时间
			connection.connect();
			OutputStream out = connection.getOutputStream();// 向对象输出流写出数据，这些数据将存到内存缓冲区中
			out.write(json.toString().getBytes()); // out.write(new
													// String("测试数据").getBytes());
													// //刷新对象输出流，将任何字节都写入潜在的流中
			out.flush();
			// 关闭流对象,此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中
			out.close();
//			System.out.println("connection.getResponseCode():"+connection.getResponseCode());
			// 读取响应
			if (connection.getResponseCode() == 200) {
				// 从服务器获得一个输入流
				InputStreamReader inputStream = new InputStreamReader(
						// 调用HttpURLConnection连接对象的getInputStream()函数,
						connection.getInputStream()
						);
				// 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
				BufferedReader reader = new BufferedReader(inputStream);

				String lines;
				sbuffer = new StringBuffer("");
				while ((lines = reader.readLine()) != null) {
					lines = new String(lines.getBytes(), "utf-8");
					sbuffer.append(lines);
				}
				reader.close();
			} else {
				// Log.i(TAG,"请求失败"+connection.getResponseCode());
				return connection.getResponseCode()+"";
			}
			// 断开连接
			connection.disconnect();
		return sbuffer.toString();
	}
}