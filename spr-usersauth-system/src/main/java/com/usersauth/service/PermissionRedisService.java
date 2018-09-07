
/**
 * @标题: PermissionRedisService.java
 * @包名： com.usersauth.service
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月15日 下午9:45:55
 */

package com.usersauth.service;

import com.usersauth.vo.SysPermissionVO;

/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service
 * @类名称：PermissionRedisService
 * @创建人：王靓
 * @创建时间：2018年5月15日下午9:45:55
 * @修改人：王靓
 * @修改时间：2018年5月15日下午9:45:55
 * @修改备注：
 */

public interface PermissionRedisService extends RedisService {

	//存储权限记录数据
	public final static String PERMISSIONS="PERMISSIONS";
	//存储权限记录数据
	public final static String PERMISSIONSTREE="PERMISSIONSTREE";
	//存储权限分页数据
	public final static String PERMISSIONS_PAGES="PERMISSIONS_PAGES";
	
	public final static String TREEROLE="TREE-ROLE";
	
	public final static String TREE="TREE";
	
	public final static String NODE="NODE";
	
	
	String getPermissionCurrentRoleList(String auth_token,String service_token);
	
	String getPermissionCurrentRoleTree(String auth_token,String service_token);
	
	void putPermissionCurrentRoleList(String auth_token, String json,String service_token);
	
	void putPermissionCurrentRoleTree(String auth_token, String json,String service_token);
	
	String getPermissiontree(String role_id,String service_token);
	
	void putPermissiontree(String role_id,String json,String service_token);
	
	String getPermissiontreenostate(String service_token);
	
	void putPermissiontreenostate(String json,String service_token);
	
	String getPermissionTreeNodeByRole(String role_id,String parent_id,String service_token);
	
	void putPermissionTreeNodeByRole(String role_id,String parent_id,String json,String service_token);
	
	String getPermissionTreeByID(String id,SysPermissionVO vo,String service_token);
	
	void putPermissionTreeByID(String id,String json,String service_token);
	
	String getPermissionTreeHasStatusByID(String id,String role_id,SysPermissionVO vo,String service_token);
	
	void putPermissionTreeHasStatusByID(String id,String role_id,String json,SysPermissionVO vo,String service_token);
}
