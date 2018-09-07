package com.usersauth.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.Results;
import com.usersauth.service.PermissionService;
import com.usersauth.service.RoleService;
import com.usersauth.service.UsersService;
import com.usersauth.vo.AuthToken;
import com.usersauth.vo.SysUserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value="用户登录服务")
public class LoginController extends BaseController{
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	UsersService usersService;
	@Autowired
	RoleService roleService;
	@Autowired
	PermissionService permissionService;
	
	
	@PostMapping("/login")
	@ApiOperation(value="用户登录验证，返回登录成功用户信息,"
			+ "必填属性：username，password，service_token。")
	public Results<SysUserVO> login(@RequestBody AuthToken at) throws Exception{
		SysUserVO vo =new SysUserVO();
		vo.setService_token(at.getService_token());
		vo.setUsername(at.getUsername());
		vo.setPassword(at.getPassword());
		
		return usersService.login(vo);
	}
	
	
	@PostMapping("/logout")
	@ApiOperation(value="用户登出，注销用户信息")
    public Results<SysUserVO> logout(@RequestBody AuthToken at){
		return usersService.logout(at.getAuth_token());
	}
	
	@PostMapping("/checkLogin")
	@ApiOperation(value="验证用户是否登录，返回登录状态")
    public Results<SysUserVO> checkLogin(@RequestBody AuthToken at){
		return usersService.checkLogin(at.getAuth_token());
	}
	
	@PostMapping("/getLoginUserInfo")
	@ApiOperation(value="查询用户信息，返回用户信息")
    public Results<SysUserVO> getLoginUserInfo(@RequestBody AuthToken at){
		return usersService.getSysUserVO(at.getAuth_token());
	}
	
	@PostMapping("/modifySelfPass")
	@ApiOperation(value="修改密码，返回用户信息，auth_token=验证码，password=旧密码，"
			+ "jsonObject必填属性：repassword=新密码")
    public Results<SysUserVO> modifySelfPass(@RequestBody AuthToken at){
		return usersService.modifySelfPass(at);
	}
}
