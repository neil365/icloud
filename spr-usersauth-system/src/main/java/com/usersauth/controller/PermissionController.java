package com.usersauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import com.usersauth.aop.Permission;
import com.usersauth.entity.SysPermission;
import com.usersauth.service.PermissionService;
import com.usersauth.vo.AuthToken;
import com.usersauth.vo.PermissionTree;
import com.usersauth.vo.SysPermissionVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="权限服务")
public class PermissionController extends BaseController{

	
	@Autowired
	PermissionService permissionService;
	
	
	@PostMapping("/permissiontreeview")
	@Permission(menu="role",value="list")
	@ApiOperation(value="treeview组件有状态权限树结构（含用户角色权限），返回treeview组件系统权限树信息。"
			+ "jsonObject必填属性：text=节点名称，nodes=子节点集合，href=节点ID，state.checked=节点默认选中")
	public Results<List<PermissionTree>> permissiontree(@RequestBody AuthToken at){
		return permissionService.permissiontree(at.getAuth_token());
	}
	
	@PostMapping("/permissiontreeviewnostate")
	@Permission(menu="role",value="list")
	@ApiOperation(value="treeview组件无状态权限树结构，返回treeview组件系统权限树信息。"
			+ "jsonObject必填属性：text=节点名称，nodes=子节点集合，href=节点ID，state.checked=节点默认选中")
	public Results<List<PermissionTree>> permissiontreenostate(@RequestBody AuthToken at){
		return permissionService.permissiontreenostate(at.getAuth_token());
	}
	
	@PostMapping("/permissionCurrentRoleList")
	@Permission(menu="permission",value="list")
	@ApiOperation(value="获取token用户权限列表信息，获取token用户权限列表信息")
	public Results<List<SysPermission>> permissionCurrentRoleList(@RequestBody AuthToken at){
		return permissionService.permissionCurrentRoleList(at.getAuth_token());
	}
	
	@PostMapping("/permissionList")
	@Permission(menu="permission",value="list")
	@ApiOperation(value="获取分页权限列表信息，获取分页权限列表信息。"
			+ "jsonObject必填属性：id=权限ID（根节点为0）,role_id=角色ID,menu_code,menu_name,permission_code,permission_name,uri,status_code,img_uri,icon")
	public Results<ListVO<SysPermission>> permissionList(@RequestBody AuthToken at){
		return permissionService.permissionList(at);
	}
	
	@PostMapping("/permissiontreenode")
	@Permission(menu="permission",value="list")
	@ApiOperation(value="获取指定层级权限树,不包含孙子节点，获取指定层级权限树结构。"
			+ "jsonObject必填属性：id=权限ID（根节点为0）,role_id=角色ID"
			+ "jsonObject属性：id=权限ID，role_id=角色ID")
	public Results<List<SysPermissionVO>> permissiontreenode(@RequestBody AuthToken at){
		return permissionService.permissiontreenode(at);
	}
	
	@PostMapping("/checkUserPermission")
	@Permission(menu="role",value="list")
	@ApiOperation(value="验证用户是否有操作权限，返回状态")
	public Results<?> checkUserPermission(@RequestBody AuthToken at){
		return permissionService.checkUserPermission(at.getAuth_token(),at.getPermission_code());
	}
	
	@PostMapping("/addPermission")
	@Permission(menu="permission",value="add")
	@ApiOperation(value="新增权限，返回新增的权限信息。"
			+ "jsonObject必填属性：menu_code=菜单编码，menu_name=菜单名称，permission_code=权限编码，permission_name=权限名称，uri=页面URI，parent_id=上级菜单ID，delete_status=是否有效  0有效  1无效，status_code=状态码0启用，1禁用")
	public Results<SysPermission> addPermission(@RequestBody AuthToken at){
		return permissionService.addPermission(at);
	}
	
	@PostMapping("/updatePermission")
	@Permission(menu="permission",value="update")
	@ApiOperation(value="修改权限信息，返回更新的权限信息。"
			+ "jsonObject必填属性：id=权限ID，menu_code=菜单编码，menu_name=菜单名称，permission_code=权限编码，permission_name=权限名称，parent_id=上级菜单ID，delete_status=是否有效  0有效  1无效，status_code=状态码0启用，1禁用")
	public Results<SysPermission> updatePermission(@RequestBody AuthToken at){
		return permissionService.updatePermission(at);
	}
	
	@PostMapping("/deletePermission")
	@Permission(menu="permission",value="delete")
	@ApiOperation(value="删除权限信息，返回更新状态信息，jsonObject必填属性：id=权限ID")
	public Results<SysPermission> deletePermission(@RequestBody AuthToken at){
		return permissionService.deletePermission(at);
	}
	
	@PostMapping("/deletePermissionCache")
	@Permission(menu="permission",value="delete")
	@ApiOperation(value="删除权限缓存信息，返回更新状态信息")
	public Results<SysPermission> deletePermissionCache(@RequestBody AuthToken at){
		return permissionService.deletePermissionCache(at);
	}

	@PostMapping("/permissionTree")
	@Permission(menu="permission",value="list")
	@ApiOperation(value="查询权限树，不含用户权限状态，查询指定节点的权限树，包含孙子节点，无用户权限状态。"
			+ "jsonObject必填属性：id=权限ID（根节点为0）")
	public Results<List<SysPermissionVO>> permissionTree(@RequestBody AuthToken at){
		return permissionService.permissionTree(at);
	}
	
	@PostMapping("/permissionTreeHasStatus")
	@Permission(menu="permission",value="list")
	@ApiOperation(value="查询权限树，含用户权限状态，查询指定节点的权限树，包含孙子节点，有用户权限状态。"
			+ "jsonObject必填属性：id=权限ID（根节点为0）,role_id=角色ID,menu_code,menu_name,permission_code,permission_name,uri,status_code,img_uri,icon")
	public Results<List<SysPermissionVO>> permissionTreeHasStatus(@RequestBody AuthToken at){
		return permissionService.permissionTreeHasStatus(at);
	}
	
	@PostMapping("/permissionCurrentRoleTree")
	@Permission(menu="permission",value="list")
	@ApiOperation(value="获取token用户权限树信息，获取token用户权限列表信息。"
			+ "jsonObject必填属性：id=权限ID（根节点为0）,role_id=角色ID,menu_code,menu_name,permission_code,permission_name,uri,status_code,img_uri,icon")
	public Results<List<SysPermissionVO>> permissionCurrentRoleTree(@RequestBody AuthToken at){
		return permissionService.permissionCurrentRoleTree(at);
	}
}
