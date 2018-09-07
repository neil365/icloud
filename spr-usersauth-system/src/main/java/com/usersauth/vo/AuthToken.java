package com.usersauth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AuthToken {

	@ApiModelProperty("登录成功后返回的认证TOKEN信息")
	private String auth_token;
	@ApiModelProperty("用户权限编码")
	private String permission_code;
	@ApiModelProperty("用户名")
	private String username;
	@ApiModelProperty("密码")
	private String password;
	private PageVO page;
	@ApiModelProperty("JSON封装的请求对象")
	private String jsonObject;
	@ApiModelProperty("当前应用服务的TOKEN信息")
	private String service_token;

	
	public String getService_token() {
		return service_token;
	}

	public void setService_token(String service_token) {
		this.service_token = service_token;
	}

	public String getAuth_token() {
		return auth_token;
	}

	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission_code() {
		return permission_code;
	}

	public void setPermission_code(String permission_code) {
		this.permission_code = permission_code;
	}

	public String getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}

	public PageVO getPage() {
		return page;
	}

	public void setPage(PageVO page) {
		this.page = page;
	}

	
}
