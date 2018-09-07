package com.usersauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import com.usersauth.aop.Permission;
import com.usersauth.entity.SysUser;
import com.usersauth.service.UsersService;
import com.usersauth.vo.AuthToken;
import com.usersauth.vo.SysUserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户管理")
public class UserController {

	@Autowired
	UsersService usersService;
	
	@PostMapping("/listUsers")
	@Permission(menu="user",value="list")
	@ApiOperation(value="分页返回用户列表信息，jsonObject必填属性：auth_token")
	public Results<ListVO<SysUserVO>> listUsers(@RequestBody AuthToken at){
		return usersService.listUsers(at);
	}
	
	@PostMapping("/listUsersByRoleIDHasEmpty")
	@Permission(menu="user",value="list")
	@ApiOperation(value="指定角色的全部用户及未选择角色的用户列表,返回新增的用户信息，jsonObject必填属性：role_id=角色ID")
	public Results<List<SysUser>> listUsersByRoleIDHasEmpty(@RequestBody AuthToken at){
		return usersService.listUsersByRoleIDHasEmpty(at);
	}
	
	@PostMapping("/listSubUsers")
	@Permission(menu="user",value="list")
	@ApiOperation(value="部分用户列表,返回部分用户列表信息，"
			+ "jsonObject必填属性：[{id:111},{id:222},{...}]")

	public Results<List<SysUser>> listSubUsers(@RequestBody AuthToken at){
		return usersService.listSubUsers(at);
	}
	
	@PostMapping("/addUser")
	@Permission(menu="user",value="add")
	@ApiOperation(value="新增用户,返回新增的用户信息。jsonObject必填属性：username=登录名，password=密码，repassword=重复密码，nickname=昵称，role_id=角色ID，login_count=登录次数，telephone=电话，email=邮件地址，reserve1=预留1，reserve2=预留2，reserve3=预留3，delete_status=是否有效  0有效  1无效，status_code=状态码0启用，1禁用")
	public Results<SysUser> addUser(@RequestBody AuthToken at){
		return usersService.addUser(at);
	}
	
	@PostMapping("/updateUser")
	@Permission(menu="user",value="update")
	@ApiOperation(value="修改用户信息,返回更新的用户信息。jsonObject必填属性：id=账号ID，username=登录名，password=密码，repassword=重复密码，nickname=昵称，role_id=角色ID，login_count=登录次数，telephone=电话，email=邮件地址，reserve1=预留1，reserve2=预留2，reserve3=预留3，delete_status=是否有效  0有效  1无效，status_code=状态码0启用，1禁用")
	public Results<SysUser> updateUser(@RequestBody AuthToken at){
		return usersService.updateUser(at);
	}
	
	@PostMapping("/updateUserRoleId")
	@Permission(menu="user",value="update")
	@ApiOperation(value="修改用户信息,返回更新的用户信息。jsonObject必填属性：[{id=账号ID，role_id=角色ID(已选)},{id=账号ID，role_id=0((未选))},{...}]")
	public Results<SysUser> updateUserRoleId(@RequestBody AuthToken at){
		return usersService.updateUserRoleId(at);
	}
	
	@PostMapping("/delUser")
	@Permission(menu="user",value="delete")
	@ApiOperation(value="删除用户信息，返回删除的用户信息。jsonObject必填属性：id=账号ID")
	public Results<SysUser> delUser(@RequestBody AuthToken at){
		return usersService.delUser(at);
	}
	
	
	@PostMapping("/delUserCache")
	@Permission(menu="user",value="delete")
	@ApiOperation(value="删除用户信息，返回删除的用户信息")
	public Results<SysUser> delUserCache(@RequestBody AuthToken at){
		return usersService.delUserCache(at);
	}
	
}
