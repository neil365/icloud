package com.usersauth.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.spr.contents.msg.Results;
import com.usersauth.entity.SysRolePermission;
import com.usersauth.service.RolePermissionDaoService;
import com.usersauth.service.RolePermissionRedisService;
import com.usersauth.service.RolePermissionService;
import com.usersauth.vo.AuthToken;


@Service
public class RolePermissionImpl implements RolePermissionService {

	Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	RolePermissionDaoService rolePermissionDaoService;
	
	@Autowired
	RolePermissionRedisService rolePermissionRedisService;


	/**
	 * @描述: 更新角色权限
	 * @方法名: updateRoelPermission
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年4月23日上午10:05:30
	 * @修改人：王靓
	 * @修改时间：2018年4月23日上午10:05:30
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	@Transactional
	public Results<SysRolePermission> updateRoelPermission(AuthToken at) {
		List<SysRolePermission> listRolePermissions =JSON.parseArray(at.getJsonObject(), SysRolePermission.class);
		if(listRolePermissions!=null) {
			logger.info("==>Update Role Permission Size:"+listRolePermissions.size());
		}
		Integer role_id = listRolePermissions.get(0).getRole_id();
		//删除指定角色权限
		rolePermissionDaoService.deleteRolePermissionByRoleId(role_id);
		if(listRolePermissions.size()==1) {
			Integer permission_id=listRolePermissions.get(0).getPermission_id();
			if(permission_id!=null && permission_id.intValue()!=-1) {
				//新增指定角色权限
				rolePermissionDaoService.addRolePermissionByRole(listRolePermissions);
			}
		}else {
			//新增指定角色权限
			rolePermissionDaoService.addRolePermissionByRole(listRolePermissions);
		}
		
		
		//更新缓存
		rolePermissionRedisService.updateRoelPermission();
		Results<SysRolePermission> r=new Results<SysRolePermission>();
		return r;
	}
}
