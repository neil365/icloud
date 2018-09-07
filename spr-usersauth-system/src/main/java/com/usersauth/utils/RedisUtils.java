package com.usersauth.utils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.usersauth.config.UsersConfig;
import com.usersauth.entity.SysPermission;
import com.usersauth.entity.SysPermissionExample;
import com.usersauth.entity.SysRole;
import com.usersauth.entity.SysRoleExample;
import com.usersauth.entity.SysUser;
import com.usersauth.entity.SysUserExample;
import com.usersauth.mapper.SysPermissionMapper;
import com.usersauth.mapper.SysRoleMapper;
import com.usersauth.mapper.SysUserMapper;
import com.usersauth.service.PermissionRedisService;
import com.usersauth.service.RoleRedisService;
import com.usersauth.service.UsersRedisService;
import com.usersauth.vo.SysUserVO;


@Component
public class RedisUtils {

	@Autowired
	UsersConfig usersConfig;
	@Autowired
	SysRoleMapper sysRoleMapper;
	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	SysPermissionMapper sysPermissionMapper;
	@Autowired
	RedisHashUtils redisHashUtils;
	
	
	
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * 
	 * @描述:初始化公共基础数据（用户、角色、权限）
	 * @方法名: initBaseData
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午4:12:26
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午4:12:26
	 * @修改备注
	 * @since
	 * @throws
	 */
	/*private void initBaseData() {
		Map<String,String> rolesMap = redisHashUtils.get(RoleRedisService.ROLES);
		Map<String,String> usersMap = redisHashUtils.get(UsersRedisService.USERS);
		Map<String,String> permissionsMap = redisHashUtils.get(PermissionRedisService.PERMISSIONS);
		if(rolesMap==null||rolesMap.size()==0) {
			logger.info("==>没有角色缓存");
			buildRolesMapMem(RoleRedisService.ROLES);
			logger.info("==>完成角色缓存");
		}
		if(usersMap==null||usersMap.size()==0) {
			logger.info("==>没有用户缓存");
			buildUsersMapMem(UsersRedisService.USERS);
			logger.info("==>完成用户缓存");
		}
		if(permissionsMap==null||permissionsMap.size()==0) {
			logger.info("==>没有权限缓存");
			buildPermissionsMapMem(PermissionRedisService.PERMISSIONS);
			logger.info("==>完成权限缓存");
		}
		
	}*/
	
	/**
	 * 
	 * @描述:构造角色内存共享数据
	 * @方法名: buildRolesMapMem
	 * @param paras
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午4:23:34
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午4:23:34
	 * @修改备注
	 * @since
	 * @throws
	 */
	/*private void buildRolesMapMem(String entries_key) {
		SysRoleExample example =new SysRoleExample();
		List<SysRole> listSysRole=sysRoleMapper.selectByExample(example);
		for(SysRole r:listSysRole) {
			redisHashUtils.put(entries_key,String.valueOf(r.getId().intValue()), JSON.toJSONString(r));
		}
	}*/
	
	/**
	 * 
	 * @描述:构造用户内存共享数据
	 * @方法名: buildUsersMapMem
	 * @param paras
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午4:29:39
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午4:29:39
	 * @修改备注
	 * @since
	 * @throws
	 */
	/*private void buildUsersMapMem(String entries_key) {
		SysUserExample example =new SysUserExample();
		List<SysUser> listSysUser=sysUserMapper.selectByExample(example);
		for(SysUser u:listSysUser) {
			redisHashUtils.put(entries_key,String.valueOf(u.getId().intValue()), JSON.toJSONString(u)); 
		}
	}*/
	
	/**
	 * 
	 * @描述:构造权限内存共享数据
	 * @方法名: buildPermissionsMapMem
	 * @param paras
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月15日下午4:32:47
	 * @修改人 王靓
	 * @修改时间 2018年5月15日下午4:32:47
	 * @修改备注
	 * @since
	 * @throws
	 */
	/*private void buildPermissionsMapMem(String entries_key) {
		SysPermissionExample example =new SysPermissionExample();
		List<SysPermission> listSysPermission=sysPermissionMapper.selectByExample(example);
		for(SysPermission p:listSysPermission) {
			redisHashUtils.put(entries_key,String.valueOf(p.getId().intValue()), JSON.toJSONString(p)); 
		}
	}*/
	
	/**
	 * 创建token
	 * @param vo
	 * @return
	 */
	public String createToken(SysUserVO vo) {
		String auth_token=UUID.randomUUID().toString();
		vo.setAuth_token(auth_token);
//		logger.info("expires:"+usersConfig.getExpires());
		
		redisHashUtils.putExpireSECONDS(auth_token, "SysUserVO", JSON.toJSONString(vo), usersConfig.getExpires());
		
		return auth_token;
	}
	
	
	/**
     * 验证token是否存在
     * @param model
     * @return
     */
    public boolean checkToken(String auth_token) {
    	String token = redisHashUtils.get(auth_token, "SysUserVO");
        if (StringUtils.isEmpty(token)) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redisHashUtils.expireDelay(auth_token,usersConfig.getExpires());
    	
        return true;
    }
	
    /**
     * 
     * @描述:延长token时间
     * @方法名: extensionOfTime
     * @返回类型 void
     * @创建人 王靓
     * @创建时间 2018年4月21日上午10:47:10
     * @修改人 王靓
     * @修改时间 2018年4月21日上午10:47:10
     * @修改备注
     * @since
     * @throws
     */
    public void extensionOfTime(String auth_token){
    	//如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
    	redisHashUtils.expireDelay(auth_token,usersConfig.getExpires());
    }
    
    
    /**
     * 删除token是否存在
     * @param auth_token
     */
    public void deleteToken(String auth_token) {
    	
    	redisHashUtils.delete(auth_token);
    }
	
    
    /**
     * 查询用户信息。
     * @param auth_token
     * @return
     */
    public SysUserVO getSysUserVO(String auth_token) {
    	String userjson =redisHashUtils.get(auth_token, "SysUserVO");
        if (StringUtils.isEmpty(userjson)) {
            return null;
        }else {
        	return JSON.parseObject(userjson, SysUserVO.class);
        }
    }
    
    
	
}
