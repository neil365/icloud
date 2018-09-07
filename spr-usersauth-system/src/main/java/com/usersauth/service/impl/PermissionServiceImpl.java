package com.usersauth.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.usersauth.entity.SysPermission;
import com.usersauth.entity.SysRolePermission;
import com.usersauth.exception.PermissionException;
import com.usersauth.service.PermissionDaoService;
import com.usersauth.service.PermissionRedisService;
import com.usersauth.service.PermissionService;
import com.usersauth.service.RolePermissionDaoService;
import com.usersauth.service.UsersService;
import com.usersauth.utils.RedisUtils;
import com.usersauth.vo.AuthToken;
import com.usersauth.vo.PermissionTree;
import com.usersauth.vo.SysPermissionVO;
import com.usersauth.vo.SysUserVO;


@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionDaoService permissionDaoService;
	@Autowired
	RolePermissionDaoService rolePermissionDaoService;
	@Autowired
	RedisUtils redisUtils;
	@Autowired
	PermissionRedisService permissionRedisService;
	@Autowired
	UsersService usersService;
	
	
	private final Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * 获取用户权限列表信息
	 */
	@Override
	public Results<List<SysPermission>> permissionCurrentRoleList(String auth_token) {
		SysUserVO sysUserVO = redisUtils.getSysUserVO(auth_token);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(auth_token);
		List<SysPermission> listSysPermission=null;
		String listRedis =permissionRedisService.getPermissionCurrentRoleList(auth_token,service_token);
		if(StringUtils.isEmpty(listRedis)) {
			logger.info("==>查询用户权限列表，没有缓存，建立缓存！");
			listSysPermission= permissionDaoService.listSysPermissionBySysUserID(sysUserVO.getId());
			permissionRedisService.putPermissionCurrentRoleList(auth_token, JSON.toJSONString(listSysPermission,SerializerFeature.WriteMapNullValue),service_token);
		}else {
			logger.info("==>查询用户权限列表，查询缓存！");
			listSysPermission=JSON.parseArray(listRedis, SysPermission.class);
		}
		
		Results<List<SysPermission>> r =new Results<List<SysPermission>>(Contents.ERROR_00,listSysPermission);
		
		return r;
	}
	
	/**
	 * @描述:获取权限列表信息
	 * @方法名: listAllSysPermission
	 * @param auth_token
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年4月23日上午11:54:11
	 * @修改人：王靓
	 * @修改时间：2018年4月23日上午11:54:11
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<ListVO<SysPermission>> permissionList(AuthToken at) {
		SysPermissionVO vo =JSON.parseObject(at.getJsonObject(), SysPermissionVO.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		ListVO<SysPermission> listVO = new ListVO<SysPermission>();
		List<SysPermission> listSysPermission=null;
		Page page =new Page();
		if(at.getPage()!=null && at.getPage().getPageSize()>0 && at.getPage().getCurrentPage()>0) {
			page.setPageNo(at.getPage().getCurrentPage());
			page.setPageSize(at.getPage().getPageSize());
			String listRedis = permissionRedisService.searchPage(at.getPage().getPageSize(), at.getPage().getCurrentPage(),vo,service_token);
			if(StringUtils.isEmpty(listRedis)) {
				logger.info("==>分页查询权限列表，没有缓存，建立缓存！");
				listSysPermission=permissionDaoService.listAllSysPermissionByPage(page,vo);
				listVO.setList(listSysPermission);
				listVO.setPage(page);
				permissionRedisService.putPage(at.getPage().getPageSize(), at.getPage().getCurrentPage(),  JSON.toJSONString(listVO,SerializerFeature.WriteMapNullValue),vo,service_token);
			}else {
				logger.info("==>分页查询权限列表，查询缓存！");
				listVO=JSON.parseObject(listRedis, ListVO.class);
			}
		}else {
			String listRedis =permissionRedisService.searchAll(vo,service_token);
			if(StringUtils.isEmpty(listRedis)) {
				logger.info("==>查询全部权限列表，没有缓存，建立缓存！");
				listSysPermission=permissionDaoService.listAllSysPermissionByPage(null,vo);
				listVO.setList(listSysPermission);
				listVO.setPage(page);
				permissionRedisService.putALLPage(JSON.toJSONString(listVO,SerializerFeature.WriteMapNullValue),vo,service_token);
			}else {
				logger.info("==>查询全部权限列表，查询缓存！");
				listVO=JSON.parseObject(listRedis, ListVO.class);
			}
		}
		
		Results<ListVO<SysPermission>> r=new Results<ListVO<SysPermission>>(Contents.ERROR_00,listVO);
		return r;
	}
	
	/**
	 * 有状态权限树结构
	 */
	public Results<List<PermissionTree>> permissiontree(String auth_token) {
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(auth_token);
		Map<String,String> mapRolePermissions = new HashMap<String,String>();
		SysUserVO vo = redisUtils.getSysUserVO(auth_token);
		List<PermissionTree> tree=null;
		String listRedis = permissionRedisService.getPermissiontree(String.valueOf(vo.getRole_id()),service_token);
		if(StringUtils.isEmpty(listRedis)) {
			logger.info("==>查询有状态权限树，没有缓存，建立缓存！");
			List<SysPermissionVO> permissions=permissionDaoService.listSysPermissionTree(vo.getService_token());
			List<PermissionTree> roletree = rolePermissionDaoService.listPermissionTreeByRoleId(vo.getRole_id());
			//配置指定角色权限map
			mapRolePermissions = permissionDaoService.buildMapRolePermissionsByRole(roletree);
			permissionDaoService.setPermissionTree(permissions,tree,mapRolePermissions);
			permissionRedisService.putPermissiontree(String.valueOf(vo.getRole_id()), JSON.toJSONString(tree,SerializerFeature.WriteMapNullValue),service_token);
		}else {
			logger.info("==>查询有状态权限树，查询缓存！");
			tree=JSON.parseArray(listRedis, PermissionTree.class);
		}
		
		Results<List<PermissionTree>> r=new Results<List<PermissionTree>>(Contents.ERROR_00,tree);
		return r;
	}
	
	/**
	 * 用户日志管理类
	 */
	@Autowired
	UsersLogServiceImpl usersLogServiceImpl;
	/**
	 * @描述: 验证用户是否有权限
	 * @方法名: checkUserPermission
	 * @param auth_token
	 * @param permission_code
	 * @return
	 * @修改人：刘晔
	 * @修改时间：2018年5月17日上午11:17:26
	 * @修改备注：新增用户日志管理功能
	 * 当用户有这个权限访问接口时，记录用户操作。
	 */
	public Results<?>  checkUserPermission(String auth_token,String permission_code){
		SysUserVO vo = redisUtils.getSysUserVO(auth_token);
		if(permissionDaoService.checkUserVoPermission(vo,permission_code)) {
			//star 当用户有这个权限访问接口时，记录用户操作
			usersLogServiceImpl.userLogAdd(auth_token, permission_code.split(":"));
			//end  当用户有这个权限访问接口时，记录用户操作
			Results<?> r = new Results<>();
			return r;
		}
		throw new PermissionException();
	}
	
	
	/**
	 * 无状态权限树结构
	 */
	@Override
	public Results<List<PermissionTree>> permissiontreenostate(String auth_token) {
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(auth_token);
		Map<String,String> mapRolePermissions = new HashMap<String,String>();
		List<PermissionTree> tree=new ArrayList<PermissionTree>();
		String listRedis = permissionRedisService.getPermissiontreenostate(service_token);
		if(StringUtils.isEmpty(listRedis)) {
			logger.info("==>查询无状态权限树，没有缓存，建立缓存！");
			List<SysPermissionVO> permissions=permissionDaoService.listSysPermissionTree(service_token);
			//配置指定角色权限map
			permissionDaoService.setPermissionTree(permissions,tree,mapRolePermissions);
			permissionRedisService.putPermissiontreenostate(JSON.toJSONString(tree,SerializerFeature.WriteMapNullValue),service_token);
		}else {
			logger.info("==>查询无状态权限树，查询缓存！");
			tree=JSON.parseArray(listRedis, PermissionTree.class);
		}
		
		Results<List<PermissionTree>> r=new Results<List<PermissionTree>>(Contents.ERROR_00,tree);
		
		return r;
	}
	
	/**
	 * 
	 * @描述: 新增权限
	 * @方法名: addPermission
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年4月21日下午5:02:48
	 * @修改人：王靓
	 * @修改时间：2018年4月21日下午5:02:48
	 * @修改备注：
	 * @throws
	 */
	@Override
	public Results<SysPermission> addPermission(AuthToken at) {
		SysPermission permission =JSON.parseObject(at.getJsonObject(), SysPermission.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		permission.setService_token(service_token);
		permissionDaoService.addSysPermission(permission);
		permission =permissionDaoService.getSysPermission(permission.getId());
		permissionRedisService.add(permission.getId(), JSON.toJSONString(permission,SerializerFeature.WriteMapNullValue),service_token);
		
		Results<SysPermission> r=new Results<SysPermission>(Contents.ERROR_00,permission);
		return r;
	}
	
	/**
	 * 
	 * @描述:更新权限
	 * @方法名: updatePermission
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年4月21日下午5:07:20
	 * @修改人：王靓
	 * @修改时间：2018年4月21日下午5:07:20
	 * @修改备注：
	 * @throws
	 */
	@Override
	public Results<SysPermission> updatePermission(AuthToken at) {
		SysPermission permission =JSON.parseObject(at.getJsonObject(), SysPermission.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		permissionDaoService.updateSysPermission(permission);
		permission =permissionDaoService.getSysPermission(permission.getId());
		permissionRedisService.update(permission.getId(), JSON.toJSONString(permission,SerializerFeature.WriteMapNullValue),service_token);
		
		Results<SysPermission> r=new Results<SysPermission>(Contents.ERROR_00,permission);
		return r;
	}



	
	/**
	 * @描述:删除权限信息
	 * @方法名: deletePermission
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年4月22日下午2:16:34
	 * @修改人：王靓
	 * @修改时间：2018年4月22日下午2:16:34
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	@Transactional
	public Results<SysPermission> deletePermission(AuthToken at) {
		SysPermission permission =JSON.parseObject(at.getJsonObject(), SysPermission.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		//删除角色权限
		rolePermissionDaoService.deleteRolePermissionByPermissionId(permission.getId());
		//删除权限
		permissionDaoService.delSysPermission(permission);
		permission =permissionDaoService.getSysPermission(permission.getId());
		if(permission!=null) {
			permissionRedisService.del(permission.getId(),service_token);
		}
		
		Results<SysPermission> r=new Results<SysPermission>(Contents.ERROR_00,permission);
		return r;
	}

	
	

	
	/**
	 * @描述:
	 * @方法名: permissiontreenode
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年4月25日上午9:41:29
	 * @修改人：王靓
	 * @修改时间：2018年4月25日上午9:41:29
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<List<SysPermissionVO>> permissiontreenode(AuthToken at) {
		SysPermissionVO vo =JSON.parseObject(at.getJsonObject(), SysPermissionVO.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		vo.setService_token(service_token);
		List<SysPermissionVO> listSysPermissionVO =null;
		String listRedis = permissionRedisService.getPermissionTreeNodeByRole(String.valueOf(vo.getRole_id()),String.valueOf(vo.getId()),service_token);
		if(StringUtils.isEmpty(listRedis)) {
			logger.info("==>查询指定节点权限树，没有缓存，建立缓存！");
			listSysPermissionVO = permissionDaoService.listSysPermissionVOByParentIdAndRoleID(vo);
			permissionRedisService.putPermissionTreeNodeByRole(String.valueOf(vo.getRole_id()),String.valueOf(vo.getId()), JSON.toJSONString(listSysPermissionVO,SerializerFeature.WriteMapNullValue),service_token);
		}else {
			logger.info("==>查询指定节点权限树，查询缓存！");
			listSysPermissionVO=JSON.parseArray(listRedis, SysPermissionVO.class);
		}
		
		Results<List<SysPermissionVO>> r=new Results<List<SysPermissionVO>>(Contents.ERROR_00,listSysPermissionVO);
		return r;
	}


	
	/**
	 * 
	 * @描述:查询指定节点的权限树，包含孙子节点，无用户权限状态
	 * @方法名: permissionTree
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月7日下午6:41:21
	 * @修改人：王靓
	 * @修改时间：2018年5月7日下午6:41:21
	 * @修改备注：
	 * @throws
	 */
	@Override
	public Results<List<SysPermissionVO>> permissionTree(AuthToken at) {
		SysPermissionVO vo =JSON.parseObject(at.getJsonObject(), SysPermissionVO.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		vo.setService_token(service_token);
		List<SysPermissionVO> tree =null;
		String listRedis = permissionRedisService.getPermissionTreeByID(String.valueOf(vo.getId()),vo,service_token);
		if(StringUtils.isEmpty(listRedis)) {
			logger.info("==>查询指定节点权限树，包含孙子节点，无用户权限状态，没有缓存，建立缓存！");
			tree =permissionDaoService.buildSysPermissionTree(vo.getId(),vo);
			permissionRedisService.putPermissionTreeByID(String.valueOf(vo.getId()), JSON.toJSONString(tree,SerializerFeature.WriteMapNullValue),service_token);
		}else {
			logger.info("==>查询指定节点权限树，包含孙子节点，无用户权限状态，查询缓存！");
			tree=JSON.parseArray(listRedis, SysPermissionVO.class);
		}
		
		Results<List<SysPermissionVO>> r=new Results<List<SysPermissionVO>>(Contents.ERROR_00,tree);
		return r;
	}
	
	
	
	/**
	 * @描述:查询指定节点的权限树，包含孙子节点，有用户权限状态
	 * @方法名: permissionTreeHasStatus
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月9日下午4:48:14
	 * @修改人：王靓
	 * @修改时间：2018年5月9日下午4:48:14
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<List<SysPermissionVO>> permissionTreeHasStatus(AuthToken at) {
		SysPermissionVO vo =JSON.parseObject(at.getJsonObject(), SysPermissionVO.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		vo.setService_token(service_token);
		List<SysPermissionVO> tree =null;
		Integer role_id=0;
		if(vo.getRole_id()!=null && vo.getRole_id().intValue()>0) {
			role_id=vo.getRole_id();
		}else {
			SysUserVO uvo = redisUtils.getSysUserVO(at.getAuth_token());
			role_id=uvo.getRole_id();
		}
		String listRedis = permissionRedisService.getPermissionTreeHasStatusByID(String.valueOf(vo.getId()), String.valueOf(role_id),vo,service_token);
		if(StringUtils.isEmpty(listRedis)) {
			logger.info("==>查询指定节点的权限树，包含孙子节点，有用户权限状态，没有缓存，建立缓存！");
			tree =permissionDaoService.buildSysPermissionTree(vo.getId(),vo);
			List<SysRolePermission> listSysRolePermission=rolePermissionDaoService.listRolePermissionByRoleID(role_id);
			permissionDaoService.permissionHasStatus(tree,listSysRolePermission);
			permissionRedisService.putPermissionTreeHasStatusByID(String.valueOf(vo.getId()), String.valueOf(role_id), JSON.toJSONString(tree,SerializerFeature.WriteMapNullValue),vo,service_token);
		}else {
			logger.info("==>查询指定节点的权限树，包含孙子节点，有用户权限状态，查询缓存！");
			tree=JSON.parseArray(listRedis, SysPermissionVO.class);
		}
		
		Results<List<SysPermissionVO>> r=new Results<List<SysPermissionVO>>(Contents.ERROR_00,tree);
		return r;
	}

	
	/**
	 * @描述:删除全部权限缓存
	 * @方法名: deletePermissionCache
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月23日上午10:43:02
	 * @修改人：王靓
	 * @修改时间：2018年5月23日上午10:43:02
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<SysPermission> deletePermissionCache(AuthToken at) {
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		permissionRedisService.delAll(service_token);
		
		Results<SysPermission> r=new Results<SysPermission>(Contents.ERROR_00,null);
		return r;
	}

	
	/**
	 * @描述:
	 * @方法名: permissionCurrentRoleTree
	 * @param auth_token
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月29日下午5:00:24
	 * @修改人：王靓
	 * @修改时间：2018年5月29日下午5:00:24
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<List<SysPermissionVO>> permissionCurrentRoleTree(AuthToken at) {
		SysPermissionVO vo =JSON.parseObject(at.getJsonObject(), SysPermissionVO.class);
		//设置当前用户所属应用服务
		String service_token = usersService.findCurrentServiceToken(at.getAuth_token());
		SysUserVO sysUserVO = redisUtils.getSysUserVO(at.getAuth_token());
		vo.setService_token(service_token);
		List<SysPermissionVO> tree=null;
		String listRedis =permissionRedisService.getPermissionCurrentRoleTree(at.getAuth_token(),service_token);
		if(StringUtils.isEmpty(listRedis)) {
			logger.info("==>查询用户权限树，没有缓存，建立缓存！");
			//权限条件
			List<SysPermission> listSysPermissionCondition =permissionDaoService.listSysPermissionDeleteStatus0OrderByVO(vo);
			//用户角色权限
			List<SysPermission> listSysPermissionRole= permissionDaoService.listSysPermissionBySysUserID(sysUserVO.getId());
			//用条件过滤用户角色权限
			List<SysPermission> listSysPermission =filterCurrentRolePermission(listSysPermissionCondition,listSysPermissionRole);
			//构建权限树
			tree = permissionDaoService.permissionsubtree(vo.getId(),listSysPermission);
			permissionRedisService.putPermissionCurrentRoleTree(at.getAuth_token(), JSON.toJSONString(tree,SerializerFeature.WriteMapNullValue),service_token);
		}else {
			logger.info("==>查询用户权限树，查询缓存！");
			tree=JSON.parseArray(listRedis, SysPermissionVO.class);
		}
		
		Results<List<SysPermissionVO>> r =new Results<List<SysPermissionVO>>(Contents.ERROR_00,tree);
		
		return r;

		
	}
	
	/**
	 * 
	 * @描述:用条件过滤用户角色权限
	 * @方法名: filterCurrentRolePermission
	 * @param listSysPermissionCondition
	 * @param listSysPermissionRole
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月30日上午10:05:34
	 * @修改人 王靓
	 * @修改时间 2018年5月30日上午10:05:34
	 * @修改备注
	 * @since
	 * @throws
	 */
	public List<SysPermission> filterCurrentRolePermission(List<SysPermission> listSysPermissionCondition,List<SysPermission> listSysPermissionRole) {
		List<SysPermission> listSysPermission = new ArrayList<SysPermission>();
		for(SysPermission pc:listSysPermissionCondition) {
			for(SysPermission pr:listSysPermissionRole) {
				if(pc.getId().intValue()==pr.getId().intValue()) {
					listSysPermission.add(pc);
				}
			}
		}
		return listSysPermission;
	}
	
}
