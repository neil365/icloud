package com.usersauth.vo;

import java.util.List;
import java.util.Set;

import com.usersauth.entity.SysRole;
import com.usersauth.entity.SysUser;


public class SysUserVO extends SysUser  {

	private String auth_token;
	private String repassword;
	private List<SysRole> roles;
	private String role_name;
	private Set<String> permission;

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Set<String> getPermission() {
		return permission;
	}

	public void setPermission(Set<String> permission) {
		this.permission = permission;
	}

	public String getAuth_token() {
		return auth_token;
	}

	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}

}
