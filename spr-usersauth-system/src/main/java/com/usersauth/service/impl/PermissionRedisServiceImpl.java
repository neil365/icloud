
/**
 * @标题: PermissionRedisServiceImpl.java
 * @包名： com.usersauth.service.impl
 * @功能描述：TODO
 * @作者： 王靓
 * @创建时间： 2018年5月17日 上午12:45:31
 */

package com.usersauth.service.impl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.usersauth.service.PermissionRedisService;
import com.usersauth.utils.RedisHashUtils;
import com.usersauth.vo.SysPermissionVO;

/**
 * @类描述：
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service.impl
 * @类名称：PermissionRedisServiceImpl
 * @创建人：王靓
 * @创建时间：2018年5月17日上午12:45:31
 * @修改人：王靓
 * @修改时间：2018年5月17日上午12:45:31
 * @修改备注：
 */
@Service
public class PermissionRedisServiceImpl implements PermissionRedisService {

	@Autowired
	RedisHashUtils redisHashUtils;
	
	/**
	 * @描述:
	 * @方法名: searchPage
	 * @param pageSize
	 * @param currentPage
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午12:45:32
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午12:45:32
	 * @修改备注：
	 * @throws
	 */

	@SuppressWarnings("hiding")
	@Override
	public <SysPermissionVO> String searchPage(int pageSize, int currentPage,SysPermissionVO vo,String service_token) {
		return redisHashUtils.get(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.PRE+pageSize+"-"+currentPage+buildSysPermissionCondition((com.usersauth.vo.SysPermissionVO) vo));
	}

	/**
	 * @描述:
	 * @方法名: searchAll
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午12:45:32
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午12:45:32
	 * @修改备注：
	 * @throws
	 */

	@Override
	public <SysPermissionVO>String searchAll(SysPermissionVO vo,String service_token) {
		return redisHashUtils.get(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.PREALL+buildSysPermissionCondition((com.usersauth.vo.SysPermissionVO) vo));
	}

	/**
	 * @描述:
	 * @方法名: putPage
	 * @param pageSize
	 * @param currentPage
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午12:45:32
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午12:45:32
	 * @修改备注：
	 * @throws
	 */

	@Override
	public <SysPermissionVO> void putPage(int pageSize, int currentPage, String json,SysPermissionVO vo,String service_token) {
		redisHashUtils.put(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token, PermissionRedisService.PRE+pageSize+"-"+currentPage+buildSysPermissionCondition((com.usersauth.vo.SysPermissionVO) vo), json);
		
	}

	/**
	 * @描述:
	 * @方法名: putALLPage
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午12:45:32
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午12:45:32
	 * @修改备注：
	 * @throws
	 */

	@Override
	public <SysPermissionVO>void putALLPage(String json,SysPermissionVO vo,String service_token) {
		redisHashUtils.put(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.PREALL+buildSysPermissionCondition((com.usersauth.vo.SysPermissionVO) vo),json);

	}

	/**
	 * @描述:
	 * @方法名: get
	 * @param id
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午12:45:32
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午12:45:32
	 * @修改备注：
	 * @throws
	 */

	@Override
	public String get(int id,String service_token) {
		return redisHashUtils.get(PermissionRedisService.PERMISSIONS+"-"+service_token, String.valueOf(id));
	}

	/**
	 * @描述:
	 * @方法名: add
	 * @param id
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午12:45:32
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午12:45:32
	 * @修改备注：
	 * @throws
	 */

	@Override
	public void add(int id, String json,String service_token) {
		delCache(service_token);
		redisHashUtils.put(PermissionRedisService.PERMISSIONS+"-"+service_token, String.valueOf(id), json);
	}

	/**
	 * @描述:
	 * @方法名: update
	 * @param id
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午12:45:32
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午12:45:32
	 * @修改备注：
	 * @throws
	 */

	@Override
	public void update(int id, String json,String service_token) {
		delCache(service_token);
		add(id,json,service_token);

	}

	/**
	 * @描述:
	 * @方法名: del
	 * @param id
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午12:45:32
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午12:45:32
	 * @修改备注：
	 * @throws
	 */

	@Override
	public void del(int id,String service_token) {
		delCache(service_token);
	}

	private void delCache(String service_token) {
		redisHashUtils.delete(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token);
		redisHashUtils.delete(PermissionRedisService.PERMISSIONS+"-"+service_token);
	}
	
	/**
	 * @描述:
	 * @方法名: getPermissionCurrentRoleList
	 * @param auth_token
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午1:33:47
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午1:33:47
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String getPermissionCurrentRoleList(String auth_token,String service_token) {
		return redisHashUtils.get(auth_token, PermissionRedisService.PERMISSIONS+"-"+service_token);
	}

	
	/**
	 * @描述:
	 * @方法名: putPermissionCurrentRoleList
	 * @param auth_token
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午1:33:47
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午1:33:47
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void putPermissionCurrentRoleList(String auth_token, String json,String service_token) {
		redisHashUtils.put(auth_token, PermissionRedisService.PERMISSIONS+"-"+service_token,json);
		
	}

	
	/**
	 * @描述:
	 * @方法名: getPermissiontree
	 * @param role_id
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午1:56:30
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午1:56:30
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String getPermissiontree(String role_id,String service_token) {
		return redisHashUtils.get(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.TREEROLE+"-"+role_id);
	}

	
	/**
	 * @描述:
	 * @方法名: putPermissiontree
	 * @param role_id
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午1:56:30
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午1:56:30
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void putPermissiontree(String role_id, String json,String service_token) {
		redisHashUtils.put(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.TREEROLE+"-"+role_id,json);
		
	}

	
	/**
	 * @描述:
	 * @方法名: getPermissiontreenostate
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午2:08:33
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午2:08:33
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String getPermissiontreenostate(String service_token) {
		return redisHashUtils.get(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.NODE);
	}

	
	/**
	 * @描述:
	 * @方法名: putPermissiontreenostate
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午2:08:33
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午2:08:33
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void putPermissiontreenostate(String json,String service_token) {
		redisHashUtils.put(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.NODE,json);
		
	}

	
	/**
	 * @描述:
	 * @方法名: getPermissionTreeNodeByRole
	 * @param role_id
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午2:17:56
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午2:17:56
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String getPermissionTreeNodeByRole(String role_id,String parent_id,String service_token) {
		return redisHashUtils.get(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.NODE+"-"+role_id+"-"+parent_id);
		
	}

	
	/**
	 * @描述:
	 * @方法名: putPermissionTreeNodeByRole
	 * @param role_id
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午2:17:56
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午2:17:56
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void putPermissionTreeNodeByRole(String role_id,String parent_id, String json,String service_token) {
		redisHashUtils.put(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.NODE+"-"+role_id+"-"+parent_id,json);
		
	}

	
	/**
	 * @描述:
	 * @方法名: getPermissionTreeByID
	 * @param id
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午2:37:09
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午2:37:09
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String getPermissionTreeByID(String id,SysPermissionVO vo,String service_token) {
		return redisHashUtils.get(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.TREE+"-"+id+buildSysPermissionCondition(vo));
	}

	
	/**
	 * @描述:
	 * @方法名: putPermissionTreeByID
	 * @param id
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午2:37:09
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午2:37:09
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void putPermissionTreeByID(String id, String json,String service_token) {
		redisHashUtils.put(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.TREE+"-"+id,json);
		
	}

	
	/**
	 * @描述:
	 * @方法名: getPermissionTreeHasStatusByID
	 * @param id
	 * @param role_id
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午2:44:35
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午2:44:35
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String getPermissionTreeHasStatusByID(String id, String role_id,SysPermissionVO vo,String service_token) {
		return redisHashUtils.get(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.TREEROLE+"-"+id+'-'+role_id+buildSysPermissionCondition(vo));
	}

	/**
	 * 
	 * @描述:根据“权限VO”条件，构建部分key串。
	 * @方法名: buildSysPermissionCondition
	 * @param vo
	 * @return
	 * @返回类型 String
	 * @创建人 王靓
	 * @创建时间 2018年5月22日下午6:07:10
	 * @修改人 王靓
	 * @修改时间 2018年5月22日下午6:07:10
	 * @修改备注
	 * @since
	 * @throws
	 */
	public String buildSysPermissionCondition(SysPermissionVO vo) {
		StringBuffer sbf = new StringBuffer();
		if(vo==null) {
			return "";
		}
		//添加Menu_code条件
		if(!StringUtils.isEmpty(vo.getMenu_code())) {
			sbf.append(vo.getMenu_code());
		}
		//添加Menu_name条件
		if(!StringUtils.isEmpty(vo.getMenu_name())) {
			sbf.append(vo.getMenu_name());
		}
		//添加Permission_code条件
		if(!StringUtils.isEmpty(vo.getPermission_code())) {
			sbf.append(vo.getPermission_code());
		}
		//添加Permission_name条件
		if(!StringUtils.isEmpty(vo.getPermission_name())) {
			sbf.append(vo.getPermission_name());
		}
		//添加Uri条件
		if(!StringUtils.isEmpty(vo.getUri())) {
			sbf.append(vo.getUri());
		}
		//添加Icon条件
		if(!StringUtils.isEmpty(vo.getIcon())) {
			sbf.append(vo.getIcon());
		}
		//添加Img_uri条件
		if(!StringUtils.isEmpty(vo.getImg_uri())) {
			sbf.append(vo.getImg_uri());
		}
		//添加Status_code条件
		if(vo.getStatus_code()!=null) {
			sbf.append(vo.getStatus_code());
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
	 * @描述:
	 * @方法名: putPermissionTreeHasStatusByID
	 * @param id
	 * @param role_id
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月17日上午2:44:35
	 * @修改人：王靓
	 * @修改时间：2018年5月17日上午2:44:35
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void putPermissionTreeHasStatusByID(String id, String role_id, String json,SysPermissionVO vo,String service_token) {
		if(!"[]".equals(json)) {
			redisHashUtils.put(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token,PermissionRedisService.TREEROLE+"-"+id+'-'+role_id+buildSysPermissionCondition(vo),json);
		}
	}

	
	/**
	 * @描述:
	 * @方法名: delAll
	 * @创建人：王靓
	 * @创建时间：2018年5月23日上午10:40:49
	 * @修改人：王靓
	 * @修改时间：2018年5月23日上午10:40:49
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void delAll(String service_token) {
		redisHashUtils.delete(PermissionRedisService.PERMISSIONS_PAGES+"-"+service_token);
		redisHashUtils.delete(PermissionRedisService.PERMISSIONS+"-"+service_token);
	}

	
	/**
	 * @描述:
	 * @方法名: getPermissionCurrentRoleTree
	 * @param auth_token
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月29日下午5:04:40
	 * @修改人：王靓
	 * @修改时间：2018年5月29日下午5:04:40
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public String getPermissionCurrentRoleTree(String auth_token,String service_token) {
		return redisHashUtils.get(auth_token, PermissionRedisService.PERMISSIONSTREE+"-"+service_token);
		
	}

	
	/**
	 * @描述:
	 * @方法名: putPermissionCurrentRoleTree
	 * @param auth_token
	 * @param json
	 * @创建人：王靓
	 * @创建时间：2018年5月29日下午5:06:23
	 * @修改人：王靓
	 * @修改时间：2018年5月29日下午5:06:23
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public void putPermissionCurrentRoleTree(String auth_token, String json,String service_token) {
		redisHashUtils.put(auth_token, PermissionRedisService.PERMISSIONSTREE+"-"+service_token,json);
		
	}



	

}
