package com.usersauth.exception;

import com.spr.contents.msg.Contents;

public class PermissionException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3576964351107536025L;

	public PermissionException() {
		super(Contents.ERROR_06);
	}
}
