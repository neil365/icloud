
/**
 * @标题: UsersRedisServiceImpl.java
 * @包名： com.usersauth.service.impl
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月15日 下午7:31:39
 */

package com.usersauth.service.impl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.usersauth.service.UsersRedisService;
import com.usersauth.utils.RedisHashUtils;
import com.usersauth.vo.SysUserVO;

/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service.impl
 * @类名称：UsersRedisServiceImpl
 * @创建人：王靓
 * @创建时间：2018年5月15日下午7:31:39
 * @修改人：王靓
 * @修改时间：2018年5月15日下午7:31:39
 * @修改备注：
 */
@Service
public class UsersRedisServiceImpl implements UsersRedisService {

	@Autowired
	RedisHashUtils redisHashUtils;
	
	/**
	 * @描述:查询用户分页缓存
	 * @方法名: search
	 * @param entries_key
	 * @param pageSize
	 * @param currentPage
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午7:31:50
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午7:31:50
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public <SysUserVO> String searchPage(int pageSize, int currentPage,SysUserVO vo,String service_token) {
		return redisHashUtils.get(UsersRedisService.USERS_PAGES+"-"+service_token,UsersRedisService.PRE+pageSize+"-"+currentPage+buildSysUserVOCondition((com.usersauth.vo.SysUserVO) vo));
		
	}

	/**
	 * 
	 * @描述:根据“用户VO”条件，构建部分key串。
	 * @方法名: buildSysUserVOCondition
	 * @param vo
	 * @return
	 * @返回类型 String
	 * @创建人 王靓
	 * @创建时间 2018年5月23日下午12:53:23
	 * @修改人 王靓
	 * @修改时间 2018年5月23日下午12:53:23
	 * @修改备注
	 * @since
	 * @throws
	 */
	public String buildSysUserVOCondition(SysUserVO vo) {
		StringBuffer sbf = new StringBuffer();
		if(vo==null) {
			return "";
		}
		//添加Username条件
		if(!StringUtils.isEmpty(vo.getUsername())) {
			sbf.append(vo.getUsername());
		}
		//添加Role_id条件
		if(vo.getRole_id()!=null) {
			sbf.append(vo.getRole_id());
		}
		//添加Nickname条件
		if(!StringUtils.isEmpty(vo.getNickname())) {
			sbf.append(vo.getNickname());
		}
		//添加Telephone条件
		if(!StringUtils.isEmpty(vo.getTelephone())) {
			sbf.append(vo.getTelephone());
		}
		//添加Email条件
		if(!StringUtils.isEmpty(vo.getEmail())) {
			sbf.append(vo.getEmail());
		}
		//添加Status_code条件
		if(!StringUtils.isEmpty(vo.getStatus_code())) {
			sbf.append(vo.getStatus_code());
		}
		//添加Reserve1条件
		if(!StringUtils.isEmpty(vo.getReserve1())) {
			sbf.append(vo.getReserve1());
		}
		//添加Reserve2条件
		if(!StringUtils.isEmpty(vo.getReserve2())) {
			sbf.append(vo.getReserve2());
		}
		
		//key编码
		Base64.Encoder b64e = Base64.getEncoder();
		if(!StringUtils.isEmpty(sbf.toString())) {
			return b64e.encodeToString(sbf.toString().getBytes());
		}else {
			return "";
		}
		
	}
	
	/**
	 * @描述:批量查询用户缓存
	 * @方法名: searchSubList
	 * @param ids
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日上午9:00:48
	 * @修改人：王靓
	 * @修改时间：2018年5月16日上午9:00:48
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String searchSubList(String ids,String service_token) {
		return redisHashUtils.get(UsersRedisService.USERS_PAGES+"-"+service_token,UsersRedisService.PRE+ids);
	}

	/**
	 * @描述:查询全部用户缓存
	 * @方法名: searchAll
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午10:10:20
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午10:10:20
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public <SysUserVO>String searchAll(SysUserVO uvo,String service_token) {
		return redisHashUtils.get(UsersRedisService.USERS_PAGES+"-"+service_token,UsersRedisService.PREALL+buildSysUserVOCondition((com.usersauth.vo.SysUserVO) uvo));
		
	}

	/**
	 * @描述:新增指定用户缓存
	 * @方法名: add
	 * @param entries_key
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午7:31:50
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午7:31:50
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void add(int id,String json,String service_token) {
		redisHashUtils.delete(UsersRedisService.USERS_PAGES);
		redisHashUtils.put(UsersRedisService.USERS+"-"+service_token, String.valueOf(id), json);
		
	}

	
	/**
	 * @描述:更新用户缓存
	 * @方法名: update
	 * @param entries_key
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午7:31:50
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午7:31:50
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void update(int id,String json,String service_token) {
		
		redisHashUtils.delete(UsersRedisService.USERS_PAGES+"-"+service_token);
		redisHashUtils.delete(UsersRedisService.USERS+"-"+service_token, String.valueOf(id));
		add(id,json,service_token);
		
	}

	
	/**
	 * @描述:删除指定用户缓存
	 * @方法名: del
	 * @param entries_key
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午7:31:50
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午7:31:50
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void del(int id,String service_token) {
		redisHashUtils.delete(UsersRedisService.USERS_PAGES+"-"+service_token);
		redisHashUtils.delete(UsersRedisService.USERS+"-"+service_token, String.valueOf(id));
		
	}


	


	
	/**
	 * @描述:查询指定用户缓存
	 * @方法名: get
	 * @param id
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午10:41:54
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午10:41:54
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String get(int id,String service_token) {
		return redisHashUtils.get(UsersRedisService.USERS+"-"+service_token, String.valueOf(id));
		
	}


	
	/**
	 * @描述:保存分页用户数据缓存
	 * @方法名: putPage
	 * @param pageSize
	 * @param currentPage
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午10:46:25
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午10:46:25
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public <SysUserVO>void putPage(int pageSize, int currentPage, String json,SysUserVO vo,String service_token) {
		redisHashUtils.put(UsersRedisService.USERS_PAGES+"-"+service_token, UsersRedisService.PRE+pageSize+"-"+currentPage+buildSysUserVOCondition((com.usersauth.vo.SysUserVO) vo), json);
		
	}


	
	/**
	 * @描述:保存全部用户数据缓存
	 * @方法名: putALLPage
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午10:51:15
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午10:51:15
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public <SysUserVO>void putALLPage(String json,SysUserVO uvo,String service_token) {
		redisHashUtils.put(UsersRedisService.USERS_PAGES+"-"+service_token,UsersRedisService.PREALL+buildSysUserVOCondition((com.usersauth.vo.SysUserVO) uvo),json);
	}

	
	/**
	 * @描述:保存部分用户数据缓存
	 * @方法名: putSubList
	 * @param ids
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月16日上午9:03:39
	 * @修改人：王靓
	 * @修改时间：2018年5月16日上午9:03:39
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void putSubList(String ids, String json,String service_token) {
		redisHashUtils.put(UsersRedisService.USERS_PAGES+"-"+service_token, UsersRedisService.PRE+ids, json);
		
	}

	
	/**
	 * @描述:
	 * @方法名: delAll
	 * @创建人：王靓
	 * @创建时间：2018年5月23日上午11:08:05
	 * @修改人：王靓
	 * @修改时间：2018年5月23日上午11:08:05
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void delAll(String service_token) {
		redisHashUtils.delete(UsersRedisService.USERS_PAGES+"-"+service_token);
		redisHashUtils.delete(UsersRedisService.USERS+"-"+service_token);
	}

	

}
