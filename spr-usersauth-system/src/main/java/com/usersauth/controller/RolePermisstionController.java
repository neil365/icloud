
/**
 * @标题: RolePermisstionController.java
 * @包名： com.usersauth.controller
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年4月23日 上午9:27:42
 */

package com.usersauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.Results;
import com.usersauth.aop.Permission;
import com.usersauth.entity.SysRolePermission;
import com.usersauth.service.RolePermissionService;
import com.usersauth.vo.AuthToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.controller
 * @类名称：RolePermisstionController
 * @创建人：王靓
 * @创建时间：2018年4月23日上午9:27:42
 * @修改人：王靓
 * @修改时间：2018年4月23日上午9:27:42
 * @修改备注：
 */
@RestController
@Api(value="角色权限服务")
public class RolePermisstionController extends BaseController {

	@Autowired
	RolePermissionService rolePermissionService;
	
	
	@PostMapping("/updateRoelPermission")
	@Permission(menu="permission",value="updateRoelPermission")
	@ApiOperation(value="更新角色权限，返回更新状态，jsonObject必填属性：[{role_id=角色ID，permission_id=权限ID},{...}]")
	public Results<SysRolePermission> updateRoelPermission(@RequestBody AuthToken at){
		return rolePermissionService.updateRoelPermission(at);
	}
}
