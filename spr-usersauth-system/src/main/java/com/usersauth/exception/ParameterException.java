package com.usersauth.exception;

import com.spr.contents.msg.Contents;

public class ParameterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1584193081388567898L;

	public ParameterException() {
		super(Contents.ERROR_08);
	}
}
