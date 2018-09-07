package com.usersauth.service;

import java.util.List;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import com.usersauth.entity.SysUser;
import com.usersauth.vo.AuthToken;
import com.usersauth.vo.SysUserVO;

public interface UsersService {

	
	Results<SysUserVO> login(SysUserVO vo);
	
	Results<SysUserVO> logout(String auth_token);
	
	Results<SysUserVO> checkLogin(String auth_token);
	
	Results<SysUserVO> getSysUserVO(String auth_token);
	
	String findCurrentServiceToken(String auth_token);
	
	Results<ListVO<SysUserVO>> listUsers(AuthToken at);
	
	Results<List<SysUser>> listUsersByRoleIDHasEmpty(AuthToken at);
	
	Results<List<SysUser>> listSubUsers(AuthToken at);
	
	Results<SysUser> addUser(AuthToken at);
	
	Results<SysUser> updateUser(AuthToken at);
	
	Results<SysUser> updateUserRoleId(AuthToken at);
	
	Results<SysUser> delUser(AuthToken at);

	Results<SysUserVO> modifySelfPass(AuthToken at);
	
	Results<SysUser> delUserCache(AuthToken at);
}