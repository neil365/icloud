package com.usersauth.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spr.contents.msg.Page;
import com.usersauth.entity.SysRole;
import com.usersauth.entity.SysRoleExample;
import com.usersauth.exception.RoleException;
import com.usersauth.mapper.SysRoleMapper;
import com.usersauth.service.RoleDaoService;

@Service
public class RoleDaoServiceImpl implements RoleDaoService {

	@Autowired
	SysRoleMapper sysRoleMapper;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	/* (non-Javadoc)
	 * @see com.nontax.service.RoleService#listAllSysRoleByPage(com.spr.contents.msg.Page)
	 */
	@Override
	public List<SysRole> listAllSysRoleByPage(Page page,String service_token){
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andDelete_statusEqualTo(0)
		.andService_tokenEqualTo(service_token);
		if(page!=null && page.getPageNo()>0 && page.getPageSize()>0) {
			page.setTotalCount(sysRoleMapper.countByExample(example));
			example.setOrderByClause(" id desc limit "+page.getCurrentResult()+","+page.getPageSize());
		}
		
		return sysRoleMapper.selectByExample(example);
	}
	
	@Transactional
	@Override
	public void addSysRole(SysRole role) {
		List<SysRole>  rolenames=this.getSysRoleByRoleName(role);
		List<SysRole>  rolecodes=this.getSysRoleByRoleCode(role);
		
		if(rolenames.size()==0 && rolecodes.size()==0) {
			role.setDelete_status(0);
			sysRoleMapper.insert(role);
		}else {
			throw new RoleException();
		}
	}
	
	@Transactional
	@Override
	public void updateSysRole(SysRole role) {
		List<SysRole>  rolenames=this.getSysRoleByRoleNameNotSelf(role);
		List<SysRole>  rolecodes=this.getSysRoleByRoleCodeNotSelf(role);
		
		if(rolenames.size()==0 && rolecodes.size()==0) {
			sysRoleMapper.updateByPrimaryKeySelective(role);
		}else {
			throw new RoleException();
		}
	}

	@Override
	public List<SysRole> listAllSysRoles() {
		SysRoleExample example = new SysRoleExample();
		return sysRoleMapper.selectByExample(example);
	}

	@Override
	public SysRole getSysRoles(Integer id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	
	/**
	 * @描述:
	 * @方法名: delRole
	 * @param role
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午4:28:30
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午4:28:30
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void delRole(SysRole role) {
		role.setDelete_status(1);
		sysRoleMapper.updateByPrimaryKeySelective(role);
		
	}

	
	/**
	 * @描述:
	 * @方法名: listSubRoles
	 * @param roleIDs
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午4:32:11
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午4:32:11
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysRole> listSubRoles(List<Integer> roleIDs) {
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andIdIn(roleIDs)
		.andDelete_statusEqualTo(0);
		
		return sysRoleMapper.selectByExample(example);
	}

	
	/**
	 * @描述:
	 * @方法名: getSysRoleByRoleName
	 * @param role
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午5:19:40
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午5:19:40
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysRole> getSysRoleByRoleName(SysRole role) {
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andRole_nameEqualTo(role.getRole_name())
		.andDelete_statusEqualTo(0);
		
		return sysRoleMapper.selectByExample(example);
	}

	
	/**
	 * @描述:
	 * @方法名: getSysRoleByRoleCode
	 * @param role
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午5:19:40
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午5:19:40
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysRole> getSysRoleByRoleCode(SysRole role) {
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andRole_codeEqualTo(role.getRole_code())
		.andDelete_statusEqualTo(0);
		
		return sysRoleMapper.selectByExample(example);
	}

	
	/**
	 * @描述:
	 * @方法名: getSysRoleByRoleNameNotSelf
	 * @param role
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午5:56:10
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午5:56:10
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysRole> getSysRoleByRoleNameNotSelf(SysRole role) {
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andRole_nameEqualTo(role.getRole_name())
		.andDelete_statusEqualTo(0)
		.andIdNotEqualTo(role.getId());
		
		return sysRoleMapper.selectByExample(example);
	}

	
	/**
	 * @描述:
	 * @方法名: getSysRoleByRoleCodeNotSelf
	 * @param role
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午5:56:10
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午5:56:10
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysRole> getSysRoleByRoleCodeNotSelf(SysRole role) {
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andRole_codeEqualTo(role.getRole_code())
		.andDelete_statusEqualTo(0)
		.andIdNotEqualTo(role.getId());
		
		return sysRoleMapper.selectByExample(example);
	}

	
}
