package com.usersauth.vo;

import java.util.List;

public class PermissionTree {

	private String text;
	private String permission;
	private List<PermissionTree> nodes;
	private List<String> tags;
	private String href;
	private PermissionTreeState state;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<PermissionTree> getNodes() {
		return nodes;
	}
	public void setNodes(List<PermissionTree> nodes) {
		this.nodes = nodes;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public PermissionTreeState getState() {
		return state;
	}
	public void setState(PermissionTreeState state) {
		this.state = state;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
