
/**
 * @标题: RolePermissionDaoServiceImpl.java
 * @包名： com.usersauth.service.impl
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月29日 上午10:53:43
 */

package com.usersauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usersauth.entity.SysRolePermission;
import com.usersauth.entity.SysRolePermissionExample;
import com.usersauth.mapper.SysRolePermissionMapper;
import com.usersauth.service.RolePermissionDaoService;
import com.usersauth.vo.PermissionTree;

/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service.impl
 * @类名称：RolePermissionDaoServiceImpl
 * @创建人：王靓
 * @创建时间：2018年5月29日上午10:53:43
 * @修改人：王靓
 * @修改时间：2018年5月29日上午10:53:43
 * @修改备注：
 */
@Service
public class RolePermissionDaoServiceImpl implements RolePermissionDaoService {

	@Autowired
	SysRolePermissionMapper sysRolePermissionMapper;
	
	@Transactional
	public void deleteRolePermissionByRoleId(Integer roleid) {
		SysRolePermissionExample example = new SysRolePermissionExample();
		example.createCriteria()
		.andRole_idEqualTo(roleid);
		
		sysRolePermissionMapper.deleteByExample(example);
	}
	
	@Transactional
	public void deleteRolePermissionByPermissionId(Integer permission_id) {
		SysRolePermissionExample example = new SysRolePermissionExample();
		example.createCriteria()
		.andPermission_idEqualTo(permission_id);
		
		sysRolePermissionMapper.deleteByExample(example);
	}
	
	@Transactional
	public void addRolePermissionByRole(List<SysRolePermission> list) {
		for(SysRolePermission srp:list) {
			sysRolePermissionMapper.insert(srp);
		}
	}

	@Override
	public List<SysRolePermission> listRolePermissionByRoleID(Integer role_id) {
		SysRolePermissionExample example = new SysRolePermissionExample();
		example.createCriteria()
		.andRole_idEqualTo(role_id);
		
		return sysRolePermissionMapper.selectByExample(example);
	}

	@Override
	public List<PermissionTree> listPermissionTreeByRoleId(Integer role_id) {
		return sysRolePermissionMapper.listSysRolePermissionByRoleId(role_id);
	}

}
