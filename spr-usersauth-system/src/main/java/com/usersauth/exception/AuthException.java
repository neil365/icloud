package com.usersauth.exception;

import com.spr.contents.msg.Contents;

public class AuthException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AuthException() {
		super(Contents.ERROR_04);
	}

}
