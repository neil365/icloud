package com.usersauth.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.spr.contents.msg.Page;
import com.usersauth.entity.SysRole;

public interface RoleDaoService {

	List<SysRole> listAllSysRoleByPage(Page page,String service_token);

	List<SysRole> listAllSysRoles();
	
	SysRole getSysRoles(Integer id);
	
	@Transactional
	void addSysRole(SysRole role);
	
	@Transactional
	void updateSysRole(SysRole role);
	
	void delRole(SysRole role);
	
	List<SysRole> listSubRoles(List<Integer> roleIDs);
	
	List<SysRole> getSysRoleByRoleName(SysRole role);
	
	List<SysRole> getSysRoleByRoleCode(SysRole role);
	
	List<SysRole> getSysRoleByRoleNameNotSelf(SysRole role);
	
	List<SysRole> getSysRoleByRoleCodeNotSelf(SysRole role);
}