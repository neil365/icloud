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
import com.usersauth.entity.SysPermissionExample;
import com.usersauth.entity.SysPermissionExample.Criteria;
import com.usersauth.entity.SysRolePermission;
import com.usersauth.entity.SysUser;
import com.usersauth.exception.PermissionDoubleException;
import com.usersauth.mapper.SysPermissionMapper;
import com.usersauth.mapper.SysRolePermissionMapper;
import com.usersauth.service.PermissionDaoService;
import com.usersauth.service.RolePermissionService;
import com.usersauth.utils.RedisUtils;
import com.usersauth.vo.PermissionTree;
import com.usersauth.vo.PermissionTreeState;
import com.usersauth.vo.SysPermissionVO;
import com.usersauth.vo.SysUserVO;


@Service
public class PermissionDaoServiceImpl implements PermissionDaoService {

	@Autowired
	SysPermissionMapper sysPermissionMapper;
	@Autowired
	SysRolePermissionMapper sysRolePermissionMapper;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	RedisUtils redisUtils;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	/* (non-Javadoc)
	 * @see com.nontax.service.PermissionService#listSysPermissionBySysUserID(com.nontax.entity.SysUser)
	 */
	@Override
	public List<SysPermission> listSysPermissionBySysUserID(SysUser u) {
		return sysPermissionMapper.listSysPermissionBySysUserID(u.getId());
	}
	
	
	
	//权限树
	@Override
	public List<SysPermissionVO> listSysPermissionTree(String service_token) {		
		List<SysPermissionVO> roots=sysPermissionMapper.listSysPermissionByParentId(0);
		if(roots.size()==1) {
			menu_item(roots.get(0),service_token);
		}
		return roots;
	}
	
	//查询树节点
	private void menu_item(SysPermissionVO vo,String service_token){
		List<SysPermissionVO> menus_nodes=sysPermissionMapper.listSysPermissionByParentIdAndServiceToken(vo.getId(),service_token);
		if(menus_nodes!=null && menus_nodes.size()>0) {
			vo.setNodes(menus_nodes);
			for(SysPermissionVO pvo:menus_nodes) {
				menu_item(pvo,service_token);
			}
		}
	}

	
	/**
	 * 配置指定角色权限map
	 * @param listRolePermissions
	 * @return
	 */
	@Override
	public Map<String,String> buildMapRolePermissionsByRole(List<PermissionTree> roletree) {
		Map<String,String> mapRolePermissions = new HashMap<String,String>();
		for(PermissionTree t:roletree) {
			mapRolePermissions.put(t.getText(), t.getText());
		}
		
		return mapRolePermissions;
	}

	
	/**
	 * 构造权限树
	 * @param permissions
	 * @param tree
	 */
	@Override
	public void setPermissionTree(List<SysPermissionVO> permissions,List<PermissionTree> tree,Map<String,String> mapRolePermissions) {
		for(SysPermissionVO vo:permissions) {
			PermissionTree t = new PermissionTree();
			//节点名称
			t.setText(vo.getMenu_name()+"-"+vo.getPermission_name());
			t.setPermission(vo.getMenu_code()+":"+vo.getPermission_code());
			if(mapRolePermissions.get(t.getText())!=null) {
				PermissionTreeState state = new PermissionTreeState();
				state.setChecked(true);
				t.setState(state);
			}
			//子节点
			if(vo.getNodes()!=null && vo.getNodes().size()>0) {
				List<PermissionTree> nodes=new ArrayList<PermissionTree>();
				setPermissionTree(vo.getNodes(),nodes,mapRolePermissions);
				t.setNodes(nodes);
			}
			//
//			List<String> tags = new ArrayList<String>();
//			tags.add(vo.getId().toString());
//			t.setTags(tags);
			//
			t.setHref("#"+vo.getId().toString());
			tree.add(t);
		}
	}
	
	
	/**
	 * 检查用户是否有指定权限
	 * @param vo
	 * @param permission_code
	 * @return
	 */
	public boolean checkUserVoPermission(SysUserVO vo,String permission_code) {
		if(vo!=null) {
			if(vo.getPermission()!=null && vo.getPermission().size()>0) {
				if(vo.getPermission().contains(permission_code)) {
					//重新计算session时间
					redisUtils.checkToken(vo.getAuth_token());
					return true;
				}
			}
		}

		return false;
	}


	
	
	/**
	 * 
	 * @描述:查询树根节点
	 * @方法名: rootSysPermissionVO
	 * @param list
	 * @return
	 * @返回类型 SysPermissionVO
	 * @创建人 王靓
	 * @创建时间 2018年4月23日下午6:42:40
	 * @修改人 王靓
	 * @修改时间 2018年4月23日下午6:42:40
	 * @修改备注
	 * @since
	 * @throws
	 */
	private SysPermissionVO rootSysPermissionVO(List<SysPermission> list) {
		for(SysPermission p:list) {
			if(p.getParent_id()==0) {
				SysPermissionVO vo = new SysPermissionVO();
				SysPermissionToVO(p,vo);
				return vo;
			}
		}
		return null;
	}

	

	/**
	 * 
	 * @描述:权限实体转换为VO对象
	 * @方法名: SysPermissionToVO
	 * @param p
	 * @param vo
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年4月23日下午6:12:12
	 * @修改人 王靓
	 * @修改时间 2018年4月23日下午6:12:12
	 * @修改备注
	 * @since
	 * @throws
	 */
	private void SysPermissionToVO(SysPermission p,SysPermissionVO vo) {
		BeanUtils.copyProperties(p, vo);
	}
	
	/**
	 * 
	 * @描述:根据角色权限设置节点状态
	 * @方法名: setRolePermission
	 * @param vo
	 * @param listSysRolePermission
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年4月24日上午11:47:03
	 * @修改人 王靓
	 * @修改时间 2018年4月24日上午11:47:03
	 * @修改备注
	 * @since
	 * @throws
	 */
	private void setRolePermission(SysPermissionVO vo,List<SysRolePermission> listSysRolePermission) {
		int flag=0;
		if(listSysRolePermission!=null) {
			for(SysRolePermission p:listSysRolePermission) {
				if(p.getPermission_id()==vo.getId()) {
					flag=1;
					break;
				}
			}
		}
		
		vo.setStatus(flag);
	}


	/**
	 * 
	 * @描述:查询全部没删除的权限
	 * @方法名: listSysPermissionDeleteStatus0OrderBy
	 * @return
	 * @返回类型 List<SysPermission>
	 * @创建人 王靓
	 * @创建时间 2018年5月22日下午5:40:39
	 * @修改人 王靓
	 * @修改时间 2018年5月22日下午5:40:39
	 * @修改备注
	 * @since
	 * @throws
	 */
	private List<SysPermission> listSysPermissionDeleteStatus0OrderBy(){
		SysPermissionExample example = new SysPermissionExample();
		example.createCriteria().andDelete_statusEqualTo(0);
		example.setOrderByClause("parent_id,id");

		return sysPermissionMapper.selectByExample(example);
	}
	
	/**
	 * 
	 * @描述:按“权限VO”作为条件，查询全部没删除的权限
	 * @方法名: listSysPermissionDeleteStatus0OrderByVO
	 * @return
	 * @返回类型 List<SysPermission>
	 * @创建人 王靓
	 * @创建时间 2018年5月22日下午5:41:22
	 * @修改人 王靓
	 * @修改时间 2018年5月22日下午5:41:22
	 * @修改备注
	 * @since
	 * @throws
	 */
	public List<SysPermission> listSysPermissionDeleteStatus0OrderByVO(SysPermissionVO vo){
		SysPermissionExample example = new SysPermissionExample();
		Criteria criteriaPermission =example.createCriteria();
		criteriaPermission.andDelete_statusEqualTo(0)
		.andService_tokenEqualTo(vo.getService_token());
		example.setOrderByClause("sequenc");
		buildSysPermissionExample(criteriaPermission,vo);
		
		return sysPermissionMapper.selectByExample(example);
	}
	
	/**
	 * 
	 * @描述:封装权限查询条件
	 * @方法名: buildSysPermissionExample
	 * @param example
	 * @param vo
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月22日下午5:56:40
	 * @修改人 王靓
	 * @修改时间 2018年5月22日下午5:56:40
	 * @修改备注
	 * @since
	 * @throws
	 */
	private void buildSysPermissionExample(Criteria criteriaPermission,SysPermissionVO vo) {
		if(vo!=null) {
			//添加Menu_code条件
			if(!StringUtils.isEmpty(vo.getMenu_code())) {
				criteriaPermission.andMenu_codeLike("%"+vo.getMenu_code()+"%");
			}
			//添加Menu_name条件
			if(!StringUtils.isEmpty(vo.getMenu_name())) {
				criteriaPermission.andMenu_nameLike("%"+vo.getMenu_name()+"%");
			}
			//添加Permission_code条件
			if(!StringUtils.isEmpty(vo.getPermission_code())) {
	//			logger.info("==>"+vo.getPermission_code());
				criteriaPermission.andPermission_codeLike("%"+vo.getPermission_code()+"%");
			}
			//添加Permission_name条件
			if(!StringUtils.isEmpty(vo.getPermission_name())) {
				criteriaPermission.andPermission_nameLike("%"+vo.getPermission_name()+"%");
			}
			//添加Uri条件
			if(!StringUtils.isEmpty(vo.getUri())) {
				criteriaPermission.andUriLike("%"+vo.getUri()+"%");
			}
			//添加Icon条件
			if(!StringUtils.isEmpty(vo.getIcon())) {
				criteriaPermission.andIconLike("%"+vo.getIcon()+"%");
			}
			//添加Img_uri条件
			if(!StringUtils.isEmpty(vo.getImg_uri())) {
				criteriaPermission.andImg_uriLike("%"+vo.getImg_uri()+"%");
			}
			//添加Status_code条件
			if(vo.getStatus_code()!=null) {
				criteriaPermission.andStatus_codeEqualTo(vo.getStatus_code());
			}
		}
	}
	
	/**
	 * 
	 * @描述:封装权限VO树
	 * @方法名: buildSysPermissionTree
	 * @param id
	 * @return
	 * @返回类型 List<SysPermissionVO>
	 * @创建人 王靓
	 * @创建时间 2018年5月9日下午5:38:35
	 * @修改人 王靓
	 * @修改时间 2018年5月9日下午5:38:35
	 * @修改备注
	 * @since
	 * @throws
	 */
	@Override
	public List<SysPermissionVO> buildSysPermissionTree(Integer id,SysPermissionVO vo){
//		List<SysPermission> listSysPermission =listSysPermissionDeleteStatus0OrderBy();
		List<SysPermission> listSysPermission =listSysPermissionDeleteStatus0OrderByVO(vo);
		List<SysPermissionVO> tree = permissionsubtree(id,listSysPermission);
		
		return tree;
	}
	
	/**
	 * 
	 * @描述:递归构造树
	 * @方法名: permissionsubtree
	 * @param id
	 * @param listSysPermission
	 * @return
	 * @返回类型 List<SysPermissionVO>
	 * @创建人 王靓
	 * @创建时间 2018年5月7日下午6:46:54
	 * @修改人 王靓
	 * @修改时间 2018年5月7日下午6:46:54
	 * @修改备注
	 * @since
	 * @throws
	 */
	public List<SysPermissionVO> permissionsubtree(Integer id,List<SysPermission> listSysPermission){
		List<SysPermissionVO> listsub = new ArrayList<SysPermissionVO>();
		for(SysPermission p:listSysPermission) {
			/**
			 * 注意事项：
			 * Integer对象比较必须用intValue()方法。
			 * 默认IntegerCache.low 是-127，Integer.high是128，如果在这个区间内，他就会把变量i当做一个变量，放到内存中；
			 * 但如果不在这个范围内，就会去new一个Integer对象，这样在用==比较时，比较的是两个对象的地址，结果肯定是false。
			 */
			if(id.intValue() == p.getParent_id().intValue()) {
				SysPermissionVO vo= new SysPermissionVO();
				SysPermissionToVO(p, vo);
				vo.setNodes(permissionsubtree(p.getId(),listSysPermission));
				listsub.add(vo);
			}
		}
		
		return listsub;
	}

	/**
	 * 
	 * @描述:根据用户权限，递归更新树状态。
	 * @方法名: permissionHasStatus
	 * @param tree
	 * @param listSysRolePermission
	 * @返回类型 void
	 * @创建人 王靓
	 * @创建时间 2018年5月9日下午5:46:14
	 * @修改人 王靓
	 * @修改时间 2018年5月9日下午5:46:14
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void permissionHasStatus(List<SysPermissionVO> tree,List<SysRolePermission> listSysRolePermission) {
		for(SysPermissionVO p:tree) {
			for(SysRolePermission rp:listSysRolePermission) {
				if(rp.getPermission_id().intValue()==p.getId().intValue()) {
//					logger.info("====>"+p.getMenu_code()+":"+p.getPermission_code());
					//有此权限
					p.setStatus(1);
					break;
				}
			}
			if(p.getStatus()==null) {
				//没有此权限
				p.setStatus(0);
			}
			permissionHasStatus(p.getNodes(),listSysRolePermission);
		}
	}



	
	/**
	 * @描述:
	 * @方法名: listSysPermissionBySysUserID
	 * @param id
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午6:40:38
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午6:40:38
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysPermission> listSysPermissionBySysUserID(Integer id) {
		return sysPermissionMapper.listSysPermissionBySysUserID(id);
	}



	
	/**
	 * @描述:
	 * @方法名: listAllSysPermissionByPage
	 * @param page
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午6:44:45
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午6:44:45
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysPermission> listAllSysPermissionByPage(Page page,SysPermissionVO vo) {
		SysPermissionExample example = new SysPermissionExample();
		Criteria criteriaPermission=example.createCriteria();
		criteriaPermission.andDelete_statusEqualTo(0);
		buildSysPermissionExample(criteriaPermission, vo);
		
		if(page!=null && page.getPageNo()>0 && page.getPageSize()>0) {
			page.setTotalCount(sysPermissionMapper.countByExample(example));
			example.setOrderByClause(" id desc limit "+page.getCurrentResult()+","+page.getPageSize());
		}
		
		return sysPermissionMapper.selectByExample(example);
		
	}



	
	/**
	 * @描述:
	 * @方法名: addSysPermission
	 * @param permission
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午6:54:00
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午6:54:00
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	@Transactional
	public void addSysPermission(SysPermission permission) {
		List<SysPermission> listSysPermission = this.getSysPermissionByCodeAndName(permission);
		if(listSysPermission.size()==0) {
			permission.setDelete_status(0);
			sysPermissionMapper.insert(permission);
		}else {
			throw new PermissionDoubleException();
		}
	}



	
	/**
	 * @描述:
	 * @方法名: getSysPermissionByCodeAndName
	 * @param permission
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午6:59:02
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午6:59:02
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysPermission> getSysPermissionByCodeAndName(SysPermission permission) {
		SysPermissionExample example = new SysPermissionExample();
		example.createCriteria().andDelete_statusEqualTo(0)
		.andMenu_codeEqualTo(permission.getMenu_code())
		.andMenu_nameEqualTo(permission.getMenu_name())
		.andPermission_codeEqualTo(permission.getPermission_code())
		.andPermission_nameEqualTo(permission.getPermission_name())
		.andService_tokenEqualTo(permission.getService_token());
		
		return sysPermissionMapper.selectByExample(example);
		
	}



	
	/**
	 * @描述:
	 * @方法名: getSysPermissionByCodeAndNameNotSelf
	 * @param permission
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午6:59:02
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午6:59:02
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysPermission> getSysPermissionByCodeAndNameNotSelf(SysPermission permission) {
		SysPermissionExample example = new SysPermissionExample();
		example.createCriteria().andDelete_statusEqualTo(0)
		.andMenu_codeEqualTo(permission.getMenu_code())
		.andMenu_nameEqualTo(permission.getMenu_name())
		.andPermission_codeEqualTo(permission.getPermission_code())
		.andPermission_nameEqualTo(permission.getPermission_name())
		.andIdNotEqualTo(permission.getId());
		
		return sysPermissionMapper.selectByExample(example);
	}



	
	/**
	 * @描述:
	 * @方法名: getSysPermission
	 * @param id
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午7:18:35
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午7:18:35
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public SysPermission getSysPermission(Integer id) {
		return sysPermissionMapper.selectByPrimaryKey(id);
	}



	
	/**
	 * @描述:
	 * @方法名: updateSysPermission
	 * @param permission
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午7:20:12
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午7:20:12
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	@Transactional
	public void updateSysPermission(SysPermission permission) {
		List<SysPermission> listSysPermission = this.getSysPermissionByCodeAndNameNotSelf(permission);
		if(listSysPermission.size()==0) {
			sysPermissionMapper.updateByPrimaryKeySelective(permission);
		}else {
			throw new PermissionDoubleException();
		}
		
	}



	
	/**
	 * @描述:
	 * @方法名: delSysPermission
	 * @param permission
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午7:27:01
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午7:27:01
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	@Transactional
	public void delSysPermission(SysPermission permission) {
		permission.setDelete_status(1);
		sysPermissionMapper.updateByPrimaryKeySelective(permission);
		
	}



	
	/**
	 * @描述:
	 * @方法名: listSysPermissionVOByParentIdAndRoleID
	 * @param vo
	 * @return
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午7:31:47
	 * @修改人：王靓
	 * @修改时间：2018年5月16日下午7:31:47
	 * @修改备注：
	 * @throws
	 */
	
	@Override
	public List<SysPermissionVO> listSysPermissionVOByParentIdAndRoleID(SysPermissionVO vo) {
		return sysPermissionMapper.listSysPermissionVOByParentIdAndRoleID(vo);
	}

	
	
	
}
