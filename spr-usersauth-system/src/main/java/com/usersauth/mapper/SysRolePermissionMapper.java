package com.usersauth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.usersauth.entity.SysRolePermission;
import com.usersauth.entity.SysRolePermissionExample;
import com.usersauth.vo.PermissionTree;

public interface SysRolePermissionMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	long countByExample(SysRolePermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	int deleteByExample(SysRolePermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	int insert(SysRolePermission record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	int insertSelective(SysRolePermission record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	List<SysRolePermission> selectByExample(SysRolePermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	SysRolePermission selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	int updateByExampleSelective(@Param("record") SysRolePermission record,
			@Param("example") SysRolePermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	int updateByPrimaryKeySelective(SysRolePermission record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role_permission
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	int updateByPrimaryKey(SysRolePermission record);

	/**
	 * 
	 * @描述:根据角色查询权限
	 * @方法名: listSysRolePermissionByRoleId
	 * @param role_id
	 * @return
	 * @返回类型 List<PermissionTree>
	 * @创建人 王靓
	 * @创建时间 2018年6月1日上午9:32:19
	 * @修改人 王靓
	 * @修改时间 2018年6月1日上午9:32:19
	 * @修改备注
	 * @since
	 * @throws
	 */
	List<PermissionTree> listSysRolePermissionByRoleId(Integer role_id);
}