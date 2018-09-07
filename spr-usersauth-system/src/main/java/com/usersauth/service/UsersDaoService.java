package com.usersauth.service;

import java.util.List;
import java.util.Map;

import com.spr.contents.msg.Page;
import com.usersauth.entity.SysUser;
import com.usersauth.vo.SysUserVO;

public interface UsersDaoService {

	List<SysUser> listAllSysUserByPage(Page page,SysUserVO vo);

	void addSysUser(SysUser u);

	void updateSysUser(SysUser u);

	void deleteSysUser(Integer id);
	
	void updateUserRoleId(List<Integer>  selectIDs,List<Integer> unselectIDs,Integer role_id);

	SysUser getSysUser(Integer id);
	
	List<SysUser> getSysUserByUsername(SysUser u);
	
	List<SysUser> getSysUserByUsernameNotSelf(SysUser u);
	
	List<SysUser> getSysUserByUsernameAndPassword(SysUser u);

	SysUser checkLogin(SysUser u);

	Map<String, String> mapSysPermissionBySysUser(SysUser u);
	
	void SysUserToVO(SysUser u,SysUserVO vo);
	
	void VOToSysUser(SysUser u,SysUserVO vo);
	
	void clearPassWord(List<SysUser> listSysUser);
	
	List<SysUser> listSubUsers(List<Integer> userIDs);
	
	boolean modifySelfPass(Integer id,String oldpassword,String newpassword);
	
	List<SysUser> listUsersByRoleIDHasEmpty(Integer role_id);
	
	int updateLoginCount(Integer id,int login_cout);
}