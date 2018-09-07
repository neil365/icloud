
/**
 * @标题: RedisService.java
 * @包名： com.usersauth.service
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月15日 下午7:25:33
 */

package com.usersauth.service;

/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service
 * @类名称：RedisService
 * @创建人：王靓
 * @创建时间：2018年5月15日下午7:25:33
 * @修改人：王靓
 * @修改时间：2018年5月15日下午7:25:33
 * @修改备注：
 */

public interface RedisService {

	public final static String PRE="PAGE-";
	public final static String PREALL="PAGE-ALL";
	
	<T> String searchPage(int pageSize,int currentPage,T o,String service_token);
	
	<T> String searchAll(T o,String service_token);
	
	<T> void putPage(int pageSize,int currentPage,String json,T o,String service_token);
	
	<T> void putALLPage(String json,T o,String service_token);
	
	String get(int id,String service_token);
	
	void add(int id,String json,String service_token);
	
	void update(int id,String json,String service_token);
	
	void del(int id,String service_token);
	
	void delAll(String service_token);
	
}
