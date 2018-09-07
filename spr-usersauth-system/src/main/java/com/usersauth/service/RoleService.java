package com.usersauth.service;

import java.util.List;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import com.usersauth.entity.SysRole;
import com.usersauth.vo.AuthToken;

public interface RoleService {

	Results<ListVO<SysRole>> listRoles(AuthToken at);
	
	Results<List<SysRole>> listSubRoles(AuthToken at);
	
	Results<SysRole>addRole(AuthToken at);
	
	Results<SysRole> updateRole(AuthToken at);
	
	Results<SysRole> delRole(AuthToken at);
	
	Results<SysRole> delRoleCache(AuthToken at);
}