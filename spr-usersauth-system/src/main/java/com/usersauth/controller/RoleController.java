package com.usersauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import com.usersauth.aop.Permission;
import com.usersauth.entity.SysRole;
import com.usersauth.service.RoleService;
import com.usersauth.vo.AuthToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="角色服务")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@PostMapping("/listRoles")
	@Permission(menu="role",value="list")
	@ApiOperation(value="角色列表，分页返回角色列表信息，jsonObject必填属性：auth_token")
	public Results<ListVO<SysRole>> listRoles(@RequestBody AuthToken at){
		return roleService.listRoles(at);
	}
	
	@PostMapping("/listSubRoles")
	@Permission(menu="role",value="list")
	@ApiOperation(value="部分角色列表，返回部分角色列表信息，"
			+ "，jsonObject必填属性：[{id:111},{id:222},{...}]")
	public Results<List<SysRole>> listSubRoles(@RequestBody AuthToken at){
		return roleService.listSubRoles(at);
	}
	
	@PostMapping("/addRole")
	@Permission(menu="role",value="add")
	@ApiOperation(value="新增角色，返回新增的角色信息，"
			+ "jsonObject：{\"delete_status\":是否有效  0有效  1无效,\"description\":\"备注\",\"role_code\":\"角色编码\",\"role_name\":\"角色\",\"status_code\":状态码0启用，1禁用,\"delete_status\":是否有效  0有效  1无效}")
	public Results<SysRole> addRole(@RequestBody AuthToken at){
		return roleService.addRole(at);
	}
	
	@PostMapping("/updateRole")
	@Permission(menu="role",value="update")
	@ApiOperation(value="修改角色信息，返回更新的角色信息，"
			+ "jsonObject：{\"delete_status\":是否有效  0有效  1无效,\"description\":\"备注\",\"id\":角色ID,\"role_code\":\"角色编码\",\"role_name\":\"角色\",\"status_code\":状态码0启用，1禁用,\"delete_status\":是否有效  0有效  1无效}")
	public Results<SysRole> updateRole(@RequestBody AuthToken at){
		return roleService.updateRole(at);
	}
	
	@PostMapping("/delRole")
	@Permission(menu="role",value="delete")
	@ApiOperation(value="删除角色信息，返回删除的角色信息，jsonObject必填属性：id=角色ID")
	public Results<SysRole> delRole(@RequestBody AuthToken at){
		return roleService.delRole(at);
	}
	
	@PostMapping("/delRoleCache")
	@Permission(menu="role",value="delete")
	@ApiOperation(value="删除角色缓存信息，返回删除的角色信息")
	public Results<SysRole> delRoleCache(@RequestBody AuthToken at){
		return roleService.delRoleCache(at);
	}
	
	
}
