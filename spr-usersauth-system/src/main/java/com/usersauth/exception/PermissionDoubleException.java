package com.usersauth.exception;

import com.spr.contents.msg.Contents;

public class PermissionDoubleException extends RuntimeException {


	
	/**
	 * @字段：serialVersionUID
	 * @功能描述：
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午7:05:16
	 */
	
	private static final long serialVersionUID = -3169862387143324822L;

	public PermissionDoubleException() {
		super(Contents.ERROR_11);
	}
}
