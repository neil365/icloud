package com.usersauth.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.spr.contents.msg.Contents;
import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;
import com.usersauth.entity.SysUser;
import com.usersauth.service.PermissionService;
import com.usersauth.service.RoleService;
import com.usersauth.service.UsersDaoService;
import com.usersauth.service.UsersRedisService;
import com.usersauth.service.UsersService;
import com.usersauth.utils.RedisUtils;
import com.usersauth.vo.AuthToken;
import com.usersauth.vo.SysUserVO;

/**
 * 
 * @类描述：用户服务
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service.impl
 * @类名称：UsersServiceImpl
 * @创建人：王靓
 * @创建时间：2018年5月15日下午6:51:09
 * @修改人：王靓
 * @修改时间：2018年5月15日下午6:51:09
 * @修改备注：
 */
@Service
public class UsersServiceImpl implements UsersService {
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	
	@Autowired
	PermissionService permissionService;
	@Autowired
	RoleService roleService;
	@Autowired
	RedisUtils redisUtils;
	@Autowired
	UsersDaoService usersDaoService;
	@Autowired
	UsersRedisService usersRedisService;
	
	@Override
	public Results<SysUserVO> login(SysUserVO vo) {
		SysUser sysUser=usersDaoService.checkLogin(vo);
		if(sysUser==null) {
			Results<SysUserVO> r=new Results<SysUserVO>(Contents.ERROR_05,vo);
			return r;
		}else {
			logger.info("登录成功!用户ID："+sysUser.getId());
			//更新登录次数
			int login_cout = usersDaoService.updateLoginCount(sysUser.getId(),sysUser.getLogin_count());
			logger.info("更新登录次数："+login_cout);
			//清除用户缓存信息
			usersRedisService.delAll(vo.getService_token());
			logger.info("清除用户缓存信息...");
			Map<String,String> mapSysPermission=usersDaoService.mapSysPermissionBySysUser(sysUser);
			Set<String> sets=mapSysPermission.keySet();
			logger.info("权限==>"+JSON.toJSONString(sets));
			vo.setPermission(sets);
			
			usersDaoService.SysUserToVO(sysUser,vo);
			vo.setPassword(null);
			String auth_token=redisUtils.createToken(vo);
			vo.setAuth_token(auth_token);
			
			Results<SysUserVO> r=new Results<SysUserVO>(Contents.ERROR_00,vo);
			return r;
		}
	}
	
	
	
	/**
     * 删除token是否存在
     * @param auth_token
     */
	@Override
	public Results<SysUserVO> logout(String auth_token) {
		redisUtils.deleteToken(auth_token);
		Results<SysUserVO> r=new Results<SysUserVO>();
		return r;
	}
	
	/**
     * 验证token是否存在
     * @param auth_token
     */
	@Override
	public Results<SysUserVO> checkLogin(String auth_token) {
		Results<SysUserVO> r=null;
		if(redisUtils.checkToken(auth_token)) {
			r=new Results<SysUserVO>();
		}else{
			r=new Results<SysUserVO>(Contents.ERROR_03,null);
		}
		
		return r;
	}
	
	/**
     * 查询用户信息。
     * @param auth_token
     * @return
     */
    public Results<SysUserVO> getSysUserVO(String auth_token) {
    	SysUserVO vo = redisUtils.getSysUserVO(auth_token);
    	Results<SysUserVO> r=null;
    	if(vo==null) {
    		r=new Results<SysUserVO>(Contents.ERROR_03,null);
    	}else {
    		r=new Results<SysUserVO>(Contents.ERROR_00,vo);
    	}
    	
    	return r;
    }
    
    /**
     * 查询当前用户所属应用服务
     * @param auth_token
     * @return
     */
    @Override
    public String findCurrentServiceToken(String auth_token) {
    	SysUserVO vo = redisUtils.getSysUserVO(auth_token);
    	return vo.getService_token();
    }
    

    /**
     * 获取用户列表信息
     */
	@Override
	public Results<ListVO<SysUserVO>> listUsers(AuthToken at) {
		SysUserVO uvo =JSON.parseObject(at.getJsonObject(), SysUserVO.class);
		//设置当前用户所属应用服务
		String service_token = findCurrentServiceToken(at.getAuth_token());
		uvo.setService_token(service_token);
		ListVO<SysUserVO> listVO=new ListVO<SysUserVO>();
		Page page = new Page();
		List<SysUser> listSysUser=null;
		if(at.getPage()!=null && at.getPage().getPageSize()>0 && at.getPage().getCurrentPage()>0) {
			page.setPageNo(at.getPage().getCurrentPage());
			page.setPageSize(at.getPage().getPageSize());
			String listRedis=usersRedisService.searchPage(at.getPage().getPageSize(), at.getPage().getCurrentPage(),uvo,service_token);
			if(StringUtils.isEmpty(listRedis)) {
				logger.info("==>分页查询用户列表，没有缓存，建立缓存！");
				listSysUser=usersDaoService.listAllSysUserByPage(page,uvo);
				List<SysUserVO> listSysUserVO =buildListSysUser2vo(listSysUser);
				listVO.setList(listSysUserVO);
				listVO.setPage(page);
				usersRedisService.putPage(at.getPage().getPageSize(), at.getPage().getCurrentPage(), JSON.toJSONString(listVO,SerializerFeature.WriteMapNullValue),uvo,service_token);
			}else {
				logger.info("==>分页查询用户列表，查询缓存！");
				listVO=JSON.parseObject(listRedis, ListVO.class);
			}
		}else {
			String listRedis=usersRedisService.searchAll(uvo,service_token);
			if(StringUtils.isEmpty(listRedis)) {
				logger.info("==>查询全部用户列表，没有缓存，建立缓存！");
				listSysUser=usersDaoService.listAllSysUserByPage(null,uvo);
				List<SysUserVO> listSysUserVO =buildListSysUser2vo(listSysUser);
				listVO.setList(listSysUserVO);
				listVO.setPage(page);
				usersRedisService.putALLPage(JSON.toJSONString(listVO,SerializerFeature.WriteMapNullValue),uvo,service_token);
			}else {
				logger.info("==>查询全部用户列表，查询缓存！");
				listVO=JSON.parseObject(listRedis, ListVO.class);
			}
			
		}
		
		
		Results<ListVO<SysUserVO>> r=new Results<ListVO<SysUserVO>>(Contents.ERROR_00,listVO);
		return r;
	}
	
	/**
	 * 
	 * @描述:用户集合转换为用户VO集合
	 * @方法名: buildListSysUser2vo
	 * @param listSysUser
	 * @return
	 * @返回类型 List<SysUserVO>
	 * @创建人 王靓
	 * @创建时间 2018年5月24日下午4:57:02
	 * @修改人 王靓
	 * @修改时间 2018年5月24日下午4:57:02
	 * @修改备注
	 * @since
	 * @throws
	 */
	private List<SysUserVO> buildListSysUser2vo(List<SysUser> listSysUser) {
		List<SysUserVO> listSysUserVO = new ArrayList<SysUserVO>();
		for(SysUser u:listSysUser) {
			SysUserVO vo = new SysUserVO();
			usersDaoService.SysUserToVO(u,vo);
			listSysUserVO.add(vo);
		}
		return listSysUserVO;
	}
	
	/**
	 * @描述:获取部分用户列表信息
	 * @方法名: listSubUsers
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年4月27日上午10:14:37
	 * @修改人：王靓
	 * @修改时间：2018年4月27日上午10:14:37
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<List<SysUser>> listSubUsers(AuthToken at) {
		List<SysUser> listSysUsers =JSON.parseArray(at.getJsonObject(), SysUser.class);
		//设置当前用户所属应用服务
		String service_token = findCurrentServiceToken(at.getAuth_token());
		List<Integer> userIDs=new ArrayList<Integer>();
		for(SysUser u:listSysUsers) {
			userIDs.add(u.getId());
		}
		String ids=JSON.toJSONString(userIDs);
		String subListUsers = usersRedisService.searchSubList(ids,service_token);
		if(StringUtils.isEmpty(subListUsers)) {
			logger.info("==>查询部分用户列表，没有缓存，建立缓存！");
			listSysUsers =usersDaoService.listSubUsers(userIDs);
			usersDaoService.clearPassWord(listSysUsers);
			usersRedisService.putSubList(ids, JSON.toJSONString(listSysUsers,SerializerFeature.WriteMapNullValue),service_token);
		}else {
			logger.info("==>查询缓存部分用户列表！");
			listSysUsers =JSON.parseArray(subListUsers,SysUser.class);
		}
		
		Results<List<SysUser>> r=new Results<List<SysUser>>(Contents.ERROR_00,listSysUsers);
		return r;
	}

	
	/**
	 * 新增用户
	 */
	@Override
	public Results<SysUser> addUser(AuthToken at) {
		SysUserVO sysUserVO =JSON.parseObject(at.getJsonObject(), SysUserVO.class);
		//设置当前用户所属应用服务
		String service_token = findCurrentServiceToken(at.getAuth_token());
		sysUserVO.setService_token(service_token);
		SysUser user = new SysUser();
		usersDaoService.VOToSysUser(user,sysUserVO);
		user.setLogin_count(0);
		usersDaoService.addSysUser(user);
		user=usersDaoService.getSysUser(user.getId());
		usersRedisService.add(user.getId(), JSON.toJSONString(user,SerializerFeature.WriteMapNullValue),service_token);
		Results<SysUser> r=new Results<SysUser>(Contents.ERROR_00,user);
		return r;
	}

	/**
	 * 更新用户
	 */
	@Override
	public Results<SysUser> updateUser(AuthToken at) {
		SysUserVO sysUserVO =JSON.parseObject(at.getJsonObject(), SysUserVO.class);
		//设置当前用户所属应用服务
		String service_token = findCurrentServiceToken(at.getAuth_token());
		sysUserVO.setService_token(service_token);
		SysUser user = new SysUser();
		usersDaoService.VOToSysUser(user,sysUserVO);
		usersDaoService.updateSysUser(user);
		user =usersDaoService.getSysUser(user.getId());
		usersRedisService.update(user.getId(), JSON.toJSONString(user,SerializerFeature.WriteMapNullValue),service_token);
		Results<SysUser> r=new Results<SysUser>(Contents.ERROR_00,user);
		return r;
	}

	/**
	 * @描述:
	 * @方法名: updateUserRoleId
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月23日上午11:34:11
	 * @修改人：王靓
	 * @修改时间：2018年5月23日上午11:34:11
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<SysUser> updateUserRoleId(AuthToken at) {
		List<SysUser> listSysUser =JSON.parseArray(at.getJsonObject(), SysUser.class);
		//设置当前用户所属应用服务
		String service_token = findCurrentServiceToken(at.getAuth_token());
		List<Integer> selectIDs = new ArrayList<Integer>();
		List<Integer> unselectIDs = new ArrayList<Integer>();
		Integer role_id =null;
		for(SysUser u:listSysUser) {
			if(u.getRole_id()!=null && u.getRole_id().intValue()>0) {
				selectIDs.add(u.getId());
				role_id=u.getRole_id();
			}else {
				unselectIDs.add(u.getId());
			}
			usersRedisService.del(u.getId(),service_token);
		}
		
		usersDaoService.updateUserRoleId(selectIDs,unselectIDs,role_id);
		
		Results<SysUser> r=new Results<SysUser>(Contents.ERROR_00,null);
		return r;
	}
	
	
	/**
	 * 删除用户
	 */
	@Override
	public Results<SysUser> delUser(AuthToken at) {
		SysUser user =JSON.parseObject(at.getJsonObject(), SysUser.class);
		//设置当前用户所属应用服务
		String service_token = findCurrentServiceToken(at.getAuth_token());
		usersDaoService.deleteSysUser(user.getId());
		usersRedisService.del(user.getId(),service_token);
		Results<SysUser> r=new Results<SysUser>(Contents.ERROR_00,user);
		return r;
	}

	/**
	 * 
	 * @描述: 修改密码
	 * @方法名: modifySelfPass
	 * @param at
	 * @return 返回用户信息
	 * @创建人：王靓
	 * @创建时间：2018年4月21日上午11:25:39
	 * @修改人：王靓
	 * @修改时间：2018年4月21日上午11:25:39
	 * @修改备注：
	 * @throws
	 */
	@Override
	public Results<SysUserVO> modifySelfPass(AuthToken at) {
		SysUserVO uvo =JSON.parseObject(at.getJsonObject(), SysUserVO.class);
		SysUserVO rvo = redisUtils.getSysUserVO(at.getAuth_token());
		boolean modifypass = usersDaoService.modifySelfPass(rvo.getId(),at.getPassword(),uvo.getRepassword());
		if(modifypass) {
			return new Results<SysUserVO>();
		}else {
			return new Results<SysUserVO>(Contents.ERROR_12,null);
		}
		
		
	}



	
	/**
	 * @描述:
	 * @方法名: delUserCache
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月23日上午11:20:11
	 * @修改人：王靓
	 * @修改时间：2018年5月23日上午11:20:11
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<SysUser> delUserCache(AuthToken at) {
		//设置当前用户所属应用服务
		String service_token = findCurrentServiceToken(at.getAuth_token());
		usersRedisService.delAll(service_token);
		Results<SysUser> r=new Results<SysUser>(Contents.ERROR_00,null);
		return r;
	}



	
	/**
	 * @描述:
	 * @方法名: listUsersByRoleIDHasEmpty
	 * @param at
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月23日下午1:33:19
	 * @修改人：王靓
	 * @修改时间：2018年5月23日下午1:33:19
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public Results<List<SysUser>> listUsersByRoleIDHasEmpty(AuthToken at) {
		SysUserVO uvo =JSON.parseObject(at.getJsonObject(), SysUserVO.class);
		List<SysUser> listSysUser=usersDaoService.listUsersByRoleIDHasEmpty(uvo.getRole_id());
		Results<List<SysUser>> r=new Results<List<SysUser>>(Contents.ERROR_00,listSysUser);
		return r;
	}



	
	

	
	
	
 }
