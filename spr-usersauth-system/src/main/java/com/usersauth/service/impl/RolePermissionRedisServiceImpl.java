
/**
 * @标题: RolePermissionRedisServiceImpl.java
 * @包名： com.usersauth.service.impl
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月29日 上午11:03:32
 */

package com.usersauth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersauth.service.PermissionRedisService;
import com.usersauth.service.RolePermissionRedisService;
import com.usersauth.utils.RedisHashUtils;

/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service.impl
 * @类名称：RolePermissionRedisServiceImpl
 * @创建人：王靓
 * @创建时间：2018年5月29日上午11:03:32
 * @修改人：王靓
 * @修改时间：2018年5月29日上午11:03:32
 * @修改备注：
 */
@Service
public class RolePermissionRedisServiceImpl implements RolePermissionRedisService {

	
	@Autowired
	RedisHashUtils redisHashUtils;
	
	
	/**
	 * @描述:
	 * @方法名: distributionPermission
	 * @创建人：王靓
	 * @创建时间：2018年5月29日上午11:03:33
	 * @修改人：王靓
	 * @修改时间：2018年5月29日上午11:03:33
	 * @修改备注：
	 * @throws
	 */

	@Override
	public void distributionPermission() {
		redisHashUtils.delete(PermissionRedisService.PERMISSIONS_PAGES);
		redisHashUtils.delete(PermissionRedisService.PERMISSIONS);
	}

	/**
	 * @描述:
	 * @方法名: updateRoelPermission
	 * @创建人：王靓
	 * @创建时间：2018年5月29日上午11:03:33
	 * @修改人：王靓
	 * @修改时间：2018年5月29日上午11:03:33
	 * @修改备注：
	 * @throws
	 */

	@Override
	public void updateRoelPermission() {
		redisHashUtils.delete(PermissionRedisService.PERMISSIONS_PAGES);
		redisHashUtils.delete(PermissionRedisService.PERMISSIONS);

	}

}
