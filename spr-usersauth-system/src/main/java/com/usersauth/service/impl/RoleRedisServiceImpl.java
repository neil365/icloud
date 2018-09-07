
/**
 * @标题: UsersRedisServiceImpl.java
 * @包名： com.usersauth.service.impl
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月15日 下午7:31:39
 */

package com.usersauth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersauth.service.RoleRedisService;
import com.usersauth.utils.RedisHashUtils;

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
public class RoleRedisServiceImpl implements RoleRedisService {

	@Autowired
	RedisHashUtils redisHashUtils;
	
	/**
	 * @描述:查询角色分页缓存
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
	public <SysRole> String searchPage(int pageSize, int currentPage,SysRole role,String service_token) {
		return redisHashUtils.get(RoleRedisService.ROLES_PAGES+"-"+service_token,RoleRedisService.PRE+pageSize+"-"+currentPage);
		
	}

	
	/**
	 * @描述:批量查询角色缓存
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
		return redisHashUtils.get(RoleRedisService.ROLES_PAGES+"-"+service_token,RoleRedisService.PRE+ids);
	}

	/**
	 * @描述:查询全部角色缓存
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
	public <SysRole>String searchAll(SysRole role,String service_token) {
		return redisHashUtils.get(RoleRedisService.ROLES_PAGES+"-"+service_token,RoleRedisService.PREALL);
		
	}

	/**
	 * @描述:新增指定角色缓存
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
		redisHashUtils.delete(RoleRedisService.ROLES_PAGES+"-"+service_token);
		redisHashUtils.put(RoleRedisService.ROLES+"-"+service_token, String.valueOf(id), json);
		
	}

	
	/**
	 * @描述:更新角色缓存
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
		
		redisHashUtils.delete(RoleRedisService.ROLES_PAGES+"-"+service_token);
		redisHashUtils.delete(RoleRedisService.ROLES+"-"+service_token, String.valueOf(id));
		add(id,json,service_token);
		
	}

	
	/**
	 * @描述:删除指定角色缓存
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
		redisHashUtils.delete(RoleRedisService.ROLES_PAGES+"-"+service_token);
		redisHashUtils.delete(RoleRedisService.ROLES+"-"+service_token, String.valueOf(id));
		
	}


	


	
	/**
	 * @描述:查询指定角色缓存
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
		return redisHashUtils.get(RoleRedisService.ROLES+"-"+service_token, String.valueOf(id));
		
	}


	
	/**
	 * @描述:保存分页角色数据缓存
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
	public <SysRole>void putPage(int pageSize, int currentPage, String json,SysRole role,String service_token) {
		redisHashUtils.put(RoleRedisService.ROLES_PAGES+"-"+service_token, RoleRedisService.PRE+pageSize+"-"+currentPage, json);
		
	}


	
	/**
	 * @描述:保存全部角色数据缓存
	 * @方法名: putALLPage
	 * @创建人：王靓
	 * @创建时间：2018年5月15日下午10:51:15
	 * @修改人：王靓
	 * @修改时间：2018年5月15日下午10:51:15
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public <SysRole>void putALLPage(String json,SysRole role,String service_token) {
		redisHashUtils.put(RoleRedisService.ROLES_PAGES+"-"+service_token,RoleRedisService.PREALL,json);
	}

	
	/**
	 * @描述:保存部分角色数据缓存
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
		redisHashUtils.put(RoleRedisService.ROLES_PAGES+"-"+service_token, RoleRedisService.PRE+ids, json);
		
	}


	
	/**
	 * @描述:
	 * @方法名: delAll
	 * @创建人：王靓
	 * @创建时间：2018年5月23日上午11:07:02
	 * @修改人：王靓
	 * @修改时间：2018年5月23日上午11:07:02
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void delAll(String service_token) {
		redisHashUtils.delete(RoleRedisService.ROLES_PAGES+"-"+service_token);
		redisHashUtils.delete(RoleRedisService.ROLES+"-"+service_token);
		
	}

	

}
