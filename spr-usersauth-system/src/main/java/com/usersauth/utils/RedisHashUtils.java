
/**
 * @标题: RedisHashUtils.java
 * @包名： com.usersauth.utils
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月15日 下午4:38:44
 */

package com.usersauth.utils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @类描述：操作Redis Hash数据工具类
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.utils
 * @类名称：RedisHashUtils
 * @创建人：王靓
 * @创建时间：2018年5月15日下午4:38:44
 * @修改人：王靓
 * @修改时间：2018年5月15日下午4:38:44
 * @修改备注：
 */
@Component
public class RedisHashUtils {

	@Autowired  
    RedisTemplate<String,String> redisTemplate; 
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * 
	 * @描述:添加key-value对象
	 * @方法名: put
	 * @param entries_key
	 * @param kk
	 * @param vv
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午5:13:11
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午5:13:11
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void put(String entries_key,String kk,String vv) {
		HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
		hashOperations.put(entries_key, kk, vv);
	}
	
	/**
	 * 
	 * @描述:查询指定Hash数据中的key对象
	 * @方法名: get
	 * @param entries_key
	 * @param kk
	 * @return
	 * @返回类型 String
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午5:13:49
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午5:13:49
	 * @修改备注
	 * @since
	 * @throws
	 */
	public String get(String entries_key,String kk) {
		logger.info("==>redis get key=>"+kk);
		HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
		return hashOperations.entries(entries_key).get(kk);
	}
	
	/**
	 * 
	 * @描述:查询指定Hash数据中的Map集合
	 * @方法名: get
	 * @param entries_key
	 * @return
	 * @返回类型 Map<String,String>
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午6:18:08
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午6:18:08
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Map<String,String> get(String entries_key){
		HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
		return hashOperations.entries(entries_key);
	}
	
	/**
	 * 
	 * @描述:删除指定Hash数据中的key对象
	 * @方法名: remove
	 * @param entries_key
	 * @param kk
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午5:14:29
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午5:14:29
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void delete(String entries_key,String kk) {
		HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
		hashOperations.delete(entries_key, kk);
	}
	
	/**
	 * 
	 * @描述:删除指定Redis key对象
	 * @方法名: remove
	 * @param entries_key
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午6:13:37
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午6:13:37
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void delete(String entries_key) {
		redisTemplate.delete(entries_key);
	}
	
	/**
	 * 
	 * @描述:添加key-value对象，有过期时间，单位为秒。
	 * @方法名: putExpireSECONDS
	 * @param entries_key
	 * @param kk
	 * @param vv
	 * @param expires
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午5:20:46
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午5:20:46
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void putExpireSECONDS(String entries_key,String kk,String vv,int expires) {
		HashOperations<String,String,String> hashOperations=redisTemplate.opsForHash();
		hashOperations.put(entries_key, kk, vv);
		redisTemplate.expire(entries_key, expires, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @描述:延长Hash数据有效期时间
	 * @方法名: expireDelay
	 * @param entries_key
	 * @param kk
	 * @param expires
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午6:08:25
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午6:08:25
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void expireDelay(String entries_key,int expires) {
		redisTemplate.boundValueOps(entries_key).expire(expires, TimeUnit.SECONDS);
	}
}
