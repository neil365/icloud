package com.usersauth.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.spr.contents.msg.Page;
import com.usersauth.entity.SysPermission;
import com.usersauth.entity.SysRole;
import com.usersauth.entity.SysUser;
import com.usersauth.entity.SysUserExample;
import com.usersauth.entity.SysUserExample.Criteria;
import com.usersauth.exception.UsersException;
import com.usersauth.mapper.SysUserMapper;
import com.usersauth.service.PermissionDaoService;
import com.usersauth.service.PermissionService;
import com.usersauth.service.RoleDaoService;
import com.usersauth.service.UsersDaoService;
import com.usersauth.vo.SysUserVO;

/**
 * 
 * @类描述：用户数据操作对象
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service.impl
 * @类名称：UsersDaoServiceImpl
 * @创建人：王靓
 * @创建时间：2018年5月15日下午6:48:39
 * @修改人：王靓
 * @修改时间：2018年5月15日下午6:48:39
 * @修改备注：
 */
@Service
public class UsersDaoServiceImpl implements UsersDaoService {
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	PermissionService permissionService;
	@Autowired
	RoleDaoService roleDaoService;
	@Autowired
	PermissionDaoService permissionDaoService;
	

	
	/* (non-Javadoc)
	 * @see com.nontax.service.UsersService#listAllSysUserByPage(com.spr.contents.msg.Page)
	 */
	@Override
	public List<SysUser> listAllSysUserByPage(Page page,SysUserVO vo){
		SysUserExample example = new SysUserExample();
		Criteria criteriaUser = example.createCriteria();
		criteriaUser.andDelete_statusEqualTo(0)
		.andService_tokenEqualTo(vo.getService_token());
		
		buildSysUserExample(criteriaUser,vo);
		
		if(page!=null && page.getPageNo()>0 && page.getPageSize()>0) {
			page.setTotalCount(sysUserMapper.countByExample(example));
			example.setOrderByClause(" id desc limit "+page.getCurrentResult()+","+page.getPageSize());
		}
		return sysUserMapper.selectByExample(example);
	}
	
	private void buildSysUserExample(Criteria criteriaUser,SysUserVO vo) {
		if(vo!=null) {
			//添加Username条件
			if(!StringUtils.isEmpty(vo.getUsername())) {
				criteriaUser.andUsernameLike("%"+vo.getUsername()+"%");
			}
			//添加Role_id条件
			if(!StringUtils.isEmpty(vo.getRole_id())) {
				criteriaUser.andRole_idEqualTo(vo.getRole_id());
			}
			//添加Nickname条件
			if(!StringUtils.isEmpty(vo.getNickname())) {
//				logger.info("==>"+vo.getPermission_code());
				criteriaUser.andNicknameLike("%"+vo.getNickname()+"%");
			}
			//添加Email条件
			if(!StringUtils.isEmpty(vo.getEmail())) {
				criteriaUser.andEmailLike("%"+vo.getEmail()+"%");
			}
			//添加Reserve1条件
			if(!StringUtils.isEmpty(vo.getReserve1())) {
				criteriaUser.andReserve1Like("%"+vo.getReserve1()+"%");
			}
			//添加Reserve2条件
			if(!StringUtils.isEmpty(vo.getReserve2())) {
				criteriaUser.andReserve2Like("%"+vo.getReserve2()+"%");
			}
			//添加Status_code条件
			if(vo.getStatus_code()!=null) {
				criteriaUser.andStatus_codeEqualTo(vo.getStatus_code());
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.nontax.service.UsersService#addSysUser(com.nontax.entity.SysUser)
	 */
	@Override
	@Transactional
	public void addSysUser(SysUser u) {
		List<SysUser> listSysUser = getSysUserByUsername(u);
		if(listSysUser==null||listSysUser.size()==0) {
			u.setDelete_status(0);
			sysUserMapper.insert(u);
		}else {
			throw new UsersException();
		}
	}

	/* (non-Javadoc)
	 * @see com.nontax.service.UsersService#updateSysUser(com.nontax.entity.SysUser)
	 */
	@Override
	@Transactional
	public void updateSysUser(SysUser u) {
		List<SysUser> listSysUser = getSysUserByUsernameNotSelf(u);
		if(listSysUser==null||listSysUser.size()==0) {
			sysUserMapper.updateByPrimaryKeySelective(u);
		}else {
			throw new UsersException();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.nontax.service.UsersService#deleteSysUser(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void deleteSysUser(Integer id) {
		SysUser u = new SysUser();
		u.setId(id);
		u.setDelete_status(1);
		sysUserMapper.updateByPrimaryKeySelective(u);
	}
	
	/* (non-Javadoc)
	 * @see com.nontax.service.UsersService#getSysUser(java.lang.Integer)
	 */
	@Override
	public SysUser getSysUser(Integer id) {
		
		SysUser u =sysUserMapper.selectByPrimaryKey(id);
		u.setPassword(null);
		
		return u;
	}
	
	/* (non-Javadoc)
	 * @see com.nontax.service.UsersService#getSysUserByUsernameAndPassword(com.nontax.entity.SysUser)
	 */
	@Override
	public List<SysUser> getSysUserByUsernameAndPassword(SysUser u) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(u.getUsername())
		.andPasswordEqualTo(u.getPassword())
		.andDelete_statusEqualTo(0)
		.andStatus_codeEqualTo(0)
		.andService_tokenEqualTo(u.getService_token());
		
		return sysUserMapper.selectByExample(example);
	}
	
	
	/* (non-Javadoc)
	 * @see com.nontax.service.UsersService#checkLogin(com.nontax.entity.SysUser)
	 */
	@Override
	public SysUser checkLogin(SysUser u){
		List<SysUser> listSysUser=getSysUserByUsernameAndPassword(u);
		if(listSysUser!=null && listSysUser.size()==1) {
			return listSysUser.get(0);
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.nontax.service.UsersService#mapSysPermissionBySysUser(com.nontax.entity.SysUser)
	 */
	@Override
	public Map<String,String> mapSysPermissionBySysUser(SysUser u){
		Map<String,String> mapSysPermission=new HashMap<String,String>();
		List<SysPermission> listSysPermission= permissionDaoService.listSysPermissionBySysUserID(u);
		String permission;
		for(SysPermission p:listSysPermission) {
//			权限编码格式例如(user:list)
			permission =p.getMenu_code()+":"+p.getPermission_code();
			mapSysPermission.put(permission, permission);
		}
		return mapSysPermission;
	}

	/**
	 * 用户实体对象转换为VO对象
	 * @param u
	 * @param vo
	 */
	@Override
	public void SysUserToVO(SysUser u,SysUserVO vo) {
		BeanUtils.copyProperties(u, vo);
		if(u.getRole_id()!=null || u.getRole_id()>0) {
			SysRole role = roleDaoService.getSysRoles(u.getRole_id());
			if(role!=null) {
				vo.setRole_name(role.getRole_name());
			}
		}
		
	}
	
	/**
	 * 用户实体对象转换为VO对象
	 * @param u
	 * @param vo
	 */
	@Override
	public void VOToSysUser(SysUser u,SysUserVO vo) {
		BeanUtils.copyProperties(vo, u);
		if(null==vo.getDelete_status()) {
			u.setDelete_status(0);
		}
		if(null==vo.getStatus_code()) {
			u.setStatus_code(0);
		}
	}
	
	/**
	 * 
	 * @描述:清除用户集合中密码信息
	 * @方法名: clearPassWord
	 * @param listSysUser
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年4月27日上午10:42:43
	 * @修改人 王靓
	 * @修改时间 2018年4月27日上午10:42:43
	 * @修改备注
	 * @since
	 * @throws
	 */
	@Override
	public void clearPassWord(List<SysUser> listSysUser) {
		for(SysUser u:listSysUser) {
			u.setPassword(null);
		}
	}

	
	/**
	 * @描述:
	 * @方法名: listSubUsers
	 * @param userIDs
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日上午8:54:46
	 * @修改人：王靓
	 * @修改时间：2018年5月16日上午8:54:46
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysUser> listSubUsers(List<Integer> userIDs) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andIdIn(userIDs)
		.andDelete_statusEqualTo(0);
		return sysUserMapper.selectByExample(example);
	}

	
	/**
	 * @描述:
	 * @方法名: modifySelfPass
	 * @param id
	 * @param password
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午2:08:33
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午2:08:33
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	@Transactional
	public boolean modifySelfPass(Integer id, String oldpassword,String newpassword) {
		SysUserExample example=new SysUserExample();
		example.createCriteria()
		.andPasswordEqualTo(oldpassword)
		.andIdEqualTo(id);
		List<SysUser> listSysUsers= sysUserMapper.selectByExample(example);
		if(listSysUsers!=null && listSysUsers.size()==1) {
			SysUser newuser = new SysUser();
			newuser.setId(id);
			newuser.setPassword(newpassword);
			int flag=sysUserMapper.updateByPrimaryKeySelective(newuser);
			
			return true;
		}else {
			return false;
		}
	}

	
	/**
	 * @描述:
	 * @方法名: getSysUserByUsername
	 * @param u
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午2:57:05
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午2:57:05
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysUser> getSysUserByUsername(SysUser u) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(u.getUsername())
		.andDelete_statusEqualTo(0);
		return sysUserMapper.selectByExample(example);
	}

	
	/**
	 * @描述:
	 * @方法名: getSysUserByUsernameNotSelf
	 * @param u
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午6:01:21
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午6:01:21
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysUser> getSysUserByUsernameNotSelf(SysUser u) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(u.getUsername())
		.andDelete_statusEqualTo(0)
		.andIdNotEqualTo(u.getId());
		return sysUserMapper.selectByExample(example);
	}

	
	/**
	 * @描述:
	 * @方法名: updateUserRoleId
	 * @param listSysUser
	 * @param role_id
	 * @创建人：王靓
	 * @创建时间：2018年5月23日上午11:40:07
	 * @修改人：王靓
	 * @修改时间：2018年5月23日上午11:40:07
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	@Transactional
	public void updateUserRoleId(List<Integer> selectIDs,List<Integer> unselectIDs, Integer role_id) {
		SysUserExample example1 = new SysUserExample();
		example1.createCriteria().andIdIn(unselectIDs);
		SysUser record1=new SysUser();
		record1.setRole_id(0);
		
		sysUserMapper.updateByExampleSelective(record1, example1);
		
		SysUserExample example2 = new SysUserExample();
		example2.createCriteria().andIdIn(selectIDs);
		SysUser record2=new SysUser();
		record2.setRole_id(role_id);
		
		sysUserMapper.updateByExampleSelective(record2, example2);
	}

	
	/**
	 * @描述:
	 * @方法名: listUsersByRoleIDHasEmpty
	 * @param role_id
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月23日下午1:35:46
	 * @修改人：王靓
	 * @修改时间：2018年5月23日下午1:35:46
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysUser> listUsersByRoleIDHasEmpty(Integer role_id) {
		List<Integer> roleids = new ArrayList<Integer>();
		roleids.add(role_id);
		roleids.add(0);
		
		SysUserExample example = new SysUserExample();
		example.createCriteria().andRole_idIn(roleids);
		example.setOrderByClause("role_id desc ");
		
		return sysUserMapper.selectByExample(example);
	}

	
	/**
	 * @描述:更新登录次数
	 * @方法名: updateLoginCount
	 * @param id
	 * @创建人：王靓
	 * @创建时间：2018年5月31日下午3:46:55
	 * @修改人：王靓
	 * @修改时间：2018年5月31日下午3:46:55
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	@Transactional
	public int updateLoginCount(Integer id,int login_cout) {
		SysUser record=new SysUser();
		record.setId(id);
		login_cout++;
		record.setLogin_count(login_cout);
		
		int r = sysUserMapper.updateByPrimaryKeySelective(record);
//		logger.info("更新登录次数完成："+r);
		return login_cout;
	}

	
 }
