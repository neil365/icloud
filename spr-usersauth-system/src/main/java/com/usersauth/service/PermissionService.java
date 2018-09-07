package com.usersauth.service;

import java.util.List;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import com.usersauth.entity.SysPermission;
import com.usersauth.vo.AuthToken;
import com.usersauth.vo.PermissionTree;
import com.usersauth.vo.SysPermissionVO;


public interface PermissionService {

	//有状态权限树结构
	Results<List<PermissionTree>> permissiontree(String auth_token);
	//无状态权限树结构
	Results<List<PermissionTree>> permissiontreenostate(String auth_token);
	
	Results<?>  checkUserPermission(String auth_token,String permission_code);
	//获取用户权限列表信息
	Results<List<SysPermission>> permissionCurrentRoleList(String auth_token);
	//获取用户权限树信息
	Results<List<SysPermissionVO>> permissionCurrentRoleTree(AuthToken at);
	//获取用户权限列表信息
	Results<ListVO<SysPermission>> permissionList(AuthToken at);
	
	Results<SysPermission> addPermission(AuthToken at);
	
	Results<SysPermission> updatePermission(AuthToken at);
	
	Results<SysPermission> deletePermission(AuthToken at);
	
	Results<SysPermission> deletePermissionCache(AuthToken at);
	
	Results<List<SysPermissionVO>> permissiontreenode(AuthToken at);

	Results<List<SysPermissionVO>> permissionTree(AuthToken at);
	
	Results<List<SysPermissionVO>> permissionTreeHasStatus(AuthToken at);
	
}