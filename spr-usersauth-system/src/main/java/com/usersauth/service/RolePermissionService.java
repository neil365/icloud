package com.usersauth.service;

import com.spr.contents.msg.Results;
import com.usersauth.entity.SysRolePermission;
import com.usersauth.vo.AuthToken;


public interface RolePermissionService {

	Results<SysRolePermission> updateRoelPermission(AuthToken at);
}
