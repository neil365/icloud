package com.usersauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import com.usersauth.aop.Permission;
import com.usersauth.entity.SysUserLog;
import com.usersauth.service.impl.UsersLogServiceImpl;
import com.usersauth.vo.SysUserLogVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="用户日志管理")
public class UserLogController {

	@Autowired
	UsersLogServiceImpl usersLogService;
	
	@PostMapping("/userLogList")
	@Permission(menu="user",value="list")
	@ApiOperation(value="用户列表，分页返回用户列表信息")
	public Results<ListVO<SysUserLog>> userLogList(@RequestBody SysUserLogVO at){
		return usersLogService.selectUserLog(at);
	}
}
