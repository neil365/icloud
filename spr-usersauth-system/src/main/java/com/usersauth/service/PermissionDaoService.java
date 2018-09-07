package com.usersauth.service;

import java.util.List;
import java.util.Map;

import com.spr.contents.msg.Page;
import com.usersauth.entity.SysPermission;
import com.usersauth.entity.SysRolePermission;
import com.usersauth.entity.SysUser;
import com.usersauth.vo.PermissionTree;
import com.usersauth.vo.SysPermissionVO;
import com.usersauth.vo.SysUserVO;


public interface PermissionDaoService {

	List<SysPermission> listSysPermissionBySysUserID(SysUser u);
	
	List<SysPermissionVO> listSysPermissionTree(String service_token);
	
	List<SysPermissionVO> listSysPermissionVOByParentIdAndRoleID(SysPermissionVO vo);
	
	//检查用户是否有指定权限
	boolean checkUserVoPermission(SysUserVO vo,String permission_code);

	List<SysPermission> listSysPermissionBySysUserID(Integer id);
	
	List<SysPermission> listAllSysPermissionByPage(Page page,SysPermissionVO vo);
	
	Map<String,String> buildMapRolePermissionsByRole(List<PermissionTree> roletree);
	
	void setPermissionTree(List<SysPermissionVO> permissions,List<PermissionTree> tree,Map<String,String> mapRolePermissions);
	
	void addSysPermission(SysPermission permission);
	
	void updateSysPermission(SysPermission permission);
	
	void delSysPermission(SysPermission permission);
	
	List<SysPermission> getSysPermissionByCodeAndName(SysPermission permission);
	
	List<SysPermission> getSysPermissionByCodeAndNameNotSelf(SysPermission permission);
	
	SysPermission getSysPermission(Integer id);
	
	List<SysPermissionVO> buildSysPermissionTree(Integer id,SysPermissionVO vo);
	
	List<SysPermissionVO> permissionsubtree(Integer id,List<SysPermission> listSysPermission);
	
	void permissionHasStatus(List<SysPermissionVO> tree,List<SysRolePermission> listSysRolePermission);
	
	List<SysPermission> listSysPermissionDeleteStatus0OrderByVO(SysPermissionVO vo);
	
	
}