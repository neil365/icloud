package com.usersauth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.spr.contents.msg.Contents;
import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;
import com.usersauth.entity.SysRole;
import com.usersauth.exception.ParameterException;
import com.usersauth.service.RoleDaoService;
import com.usersauth.service.RoleRedisService;
import com.usersauth.service.RoleService;
import com.usersauth.service.UsersDaoService;
import com.usersauth.service.UsersService;
import com.usersauth.vo.AuthToken;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDaoService roleDaoService;
	@Autowired
	RoleRedisService roleRedisService;
	@Autowired
	UsersService usersService;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * 
	 * @描述:角色列表
	 * @方法名: listRoles
	 * @param at
	 * @return 分页返回角色列表信息
	 * @创建人：王靓
	 * @创建时间：2018年4月21日上午10:35:55
	 * @修改人：王靓
	 * @修改时间：2018年4月21日上午10:35:55
	 * @修改备注：
	 * @throws
	 */
	@Override
	public Results<ListVO<SysRole>> listRoles(AuthToken at) {
		SysRole role =JSON.parseObject(at.getJsonObject(), SysRole.class);
		ListVO<SysRole> listVO=new ListVO<SysRole>();
		Page page = new Page();
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		role.setService_token(service_token);
		List<SysRole> listRoles=null;
		if(at.getPage()!=null && at.getPage().getCurrentPage()>0 && at.getPage().getPageSize()>0) {
			page.setPageNo(at.getPage().getCurrentPage());
			page.setPageSize(at.getPage().getPageSize());
			String listRedis = roleRedisService.searchPage(at.getPage().getPageSize(), at.getPage().getCurrentPage(),role,service_token);
			if(StringUtils.isEmpty(listRedis)) {
				logger.info("==>分页查询角色列表，没有缓存，建立缓存！");
				listRoles=roleDaoService.listAllSysRoleByPage(page,service_token);
				listVO.setList(listRoles);
				listVO.setPage(page);
				roleRedisService.putPage(at.getPage().getPageSize(), at.getPage().getCurrentPage(), JSON.toJSONString(listVO,SerializerFeature.WriteMapNullValue),role,service_token);
			}else {
				logger.info("==>分页查询角色列表，查询缓存！");
				listVO=JSON.parseObject(listRedis, ListVO.class);
			}
		}else {
			String listRedis=roleRedisService.searchAll(role,service_token);
			if(StringUtils.isEmpty(listRedis)) {
				logger.info("==>查询全部角色列表，没有缓存，建立缓存！");
				listRoles=roleDaoService.listAllSysRoleByPage(page,service_token);
				listVO.setList(listRoles);
				listVO.setPage(page);
				roleRedisService.putALLPage(JSON.toJSONString(listVO,SerializerFeature.WriteMapNullValue),role,service_token);
			}else {
				logger.info("==>查询全部角色列表，查询缓存！");
				listVO=JSON.parseObject(listRedis, ListVO.class);
			}
		}
		
		Results<ListVO<SysRole>> r=new Results<ListVO<SysRole>>(Contents.ERROR_00,listVO);
		return r;
	}

	/**
	 * 
	 * @描述: 新增角色
	 * @方法名: addRole
	 * @param at
	 * @return 返回新增的角色信息
	 * @创建人：王靓
	 * @创建时间：2018年4月21日上午10:35:27
	 * @修改人：王靓
	 * @修改时间：2018年4月21日上午10:35:27
	 * @修改备注：
	 * @throws
	 */
	@Override
	@Transactional
	public Results<SysRole> addRole(AuthToken at) {
		SysRole role =JSON.parseObject(at.getJsonObject(), SysRole.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		role.setService_token(service_token);
		roleDaoService.addSysRole(role);
		role =roleDaoService.getSysRoles(role.getId());
		roleRedisService.add(role.getId(), JSON.toJSONString(role,SerializerFeature.WriteMapNullValue),service_token);
		Results<SysRole> r=new Results<SysRole>(Contents.ERROR_00,role);
		return r;
	}

	/**
	 * 
	 * @描述:修改角色
	 * @方法名: updateRole
	 * @param at
	 * @return 返回更新的角色信息
	 * @创建人：王靓
	 * @创建时间：2018年4月21日上午10:34:52
	 * @修改人：王靓
	 * @修改时间：2018年4月21日上午10:34:52
	 * @修改备注：
	 * @throws
	 */
	@Override
	public Results<SysRole> updateRole(AuthToken at) {
		if(StringUtils.isEmpty(at.getJsonObject()) || at.getJsonObject().toLowerCase().equals("string")) {
			throw new ParameterException();
		}
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		SysRole role =JSON.parseObject(at.getJsonObject(), SysRole.class);
		roleDaoService.updateSysRole(role);
		role =roleDaoService.getSysRoles(role.getId());
		roleRedisService.update(role.getId(), JSON.toJSONString(role,SerializerFeature.WriteMapNullValue),service_token);
		Results<SysRole> r=new Results<SysRole>(Contents.ERROR_00,role);
		return r;
	}

	/**
	 * 
	 * @描述:删除角色
	 * @方法名: delRole
	 * @param at
	 * @return 返回删除的角色信息
	 * @创建人：王靓
	 * @创建时间：2018年4月21日上午10:31:52
	 * @修改人：王靓
	 * @修改时间：2018年4月21日上午10:31:52
	 * @修改备注：
	 * @throws
	 */
	@Override
	public Results<SysRole> delRole(AuthToken at) {
		SysRole role =JSON.parseObject(at.getJsonObject(), SysRole.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		roleDaoService.delRole(role);
		role =roleDaoService.getSysRoles(role.getId());
		roleRedisService.del(role.getId(),service_token);
		Results<SysRole> r=new Results<SysRole>(Contents.ERROR_00,role);
		return r;
	}

	
	/**
	 * @描述:返回部分角色列表信息
	 * @方法名: listSubRoles
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年4月27日上午10:46:42
	 * @修改人：王靓
	 * @修改时间：2018年4月27日上午10:46:42
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<List<SysRole>> listSubRoles(AuthToken at) {
		List<SysRole> listSysRoles =JSON.parseArray(at.getJsonObject(), SysRole.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		List<Integer> roleIDs=new ArrayList<Integer>();
		for(SysRole r:listSysRoles) {
			roleIDs.add(r.getId());
		}
		String ids=JSON.toJSONString(roleIDs);
		String subListRoles = roleRedisService.searchSubList(ids,service_token);
		if(StringUtils.isEmpty(subListRoles)) {
			logger.info("==>查询部分角色列表，没有缓存，建立缓存！");
			listSysRoles =roleDaoService.listSubRoles(roleIDs);
			roleRedisService.putSubList(ids, JSON.toJSONString(listSysRoles,SerializerFeature.WriteMapNullValue),service_token);
		}else {
			logger.info("==>查询缓存部分角色列表！");
			listSysRoles =JSON.parseArray(subListRoles,SysRole.class);
		}
		
		Results<List<SysRole>> r=new Results<List<SysRole>>(Contents.ERROR_00,listSysRoles);
		return r;
	}

	
	/**
	 * @描述:
	 * @方法名: delRoleCache
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月23日上午11:21:05
	 * @修改人：王靓
	 * @修改时间：2018年5月23日上午11:21:05
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<SysRole> delRoleCache(AuthToken at) {
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		roleRedisService.delAll(service_token);
		Results<SysRole> r=new Results<SysRole>(Contents.ERROR_00,null);
		return r;
	}
}
