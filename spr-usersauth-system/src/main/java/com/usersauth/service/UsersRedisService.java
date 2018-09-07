
/**
 * @标题: UsersRedisService.java
 * @包名： com.usersauth.service
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月15日 下午7:20:16
 */

package com.usersauth.service;

/**
 * @类描述：操作Redis用户数据服务
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service
 * @类名称：UsersRedisService
 * @创建人：王靓
 * @创建时间：2018年5月15日下午7:20:16
 * @修改人：王靓
 * @修改时间：2018年5月15日下午7:20:16
 * @修改备注：
 */

public interface UsersRedisService extends RedisService {

	//存储用户记录数据
	public final static String USERS="USERS";
	//存储用户分页数据
	public final static String USERS_PAGES="USERS_PAGES";
	
	String searchSubList(String ids,String service_token);
	
	void putSubList(String ids,String json,String service_token);
}
