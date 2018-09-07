package com.usersauth.exception;

import com.spr.contents.msg.Contents;

public class RoleException extends RuntimeException {

	/**
	 * @字段：serialVersionUID
	 * @功能描述：
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午3:58:54
	 */
	
	private static final long serialVersionUID = -3266498498075048520L;

	public RoleException() {
		super(Contents.ERROR_10);
	}
}
