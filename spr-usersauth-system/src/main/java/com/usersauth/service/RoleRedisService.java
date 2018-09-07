
/**
 * @标题: RoleRedisService.java
 * @包名： com.usersauth.service
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月15日 下午9:45:04
 */

package com.usersauth.service;


/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service
 * @类名称：RoleRedisService
 * @创建人：王靓
 * @创建时间：2018年5月15日下午9:45:04
 * @修改人：王靓
 * @修改时间：2018年5月15日下午9:45:04
 * @修改备注：
 */

public interface RoleRedisService extends RedisService {

	//存储角色记录数据
	public final static String ROLES="ROLES";
	//存储角色分页数据
	public final static String ROLES_PAGES="ROLES_PAGES";
	
	String searchSubList(String ids,String service_token);
	
	void putSubList(String ids,String json,String service_token);
	
}
