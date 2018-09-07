
/**
 * @标题: RolePermissionDaoService.java
 * @包名： com.usersauth.service
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月29日 上午10:52:43
 */

package com.usersauth.service;

import java.util.List;

import com.usersauth.entity.SysRolePermission;
import com.usersauth.vo.PermissionTree;

/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service
 * @类名称：RolePermissionDaoService
 * @创建人：王靓
 * @创建时间：2018年5月29日上午10:52:43
 * @修改人：王靓
 * @修改时间：2018年5月29日上午10:52:43
 * @修改备注：
 */

public interface RolePermissionDaoService {

	void deleteRolePermissionByRoleId(Integer roleid);
	
	void deleteRolePermissionByPermissionId(Integer permission_id);
	
	void addRolePermissionByRole(List<SysRolePermission> list);
	
	List<SysRolePermission> listRolePermissionByRoleID(Integer role_id);
	
	List<PermissionTree> listPermissionTreeByRoleId(Integer role_id);
	
}
