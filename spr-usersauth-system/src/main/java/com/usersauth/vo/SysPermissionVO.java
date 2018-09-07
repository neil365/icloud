package com.usersauth.vo;

import java.util.List;

import com.usersauth.entity.SysPermission;


public class SysPermissionVO extends SysPermission{

	private List<SysPermissionVO> nodes;
	private Integer status;
	private Integer role_id;

	public List<SysPermissionVO> getNodes() {
		return nodes;
	}

	public void setNodes(List<SysPermissionVO> nodes) {
		this.nodes = nodes;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

}