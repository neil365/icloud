package com.usersauth.exception;

import com.spr.contents.msg.Contents;

public class UsersException extends RuntimeException {


	
	/**
	 * @字段：serialVersionUID
	 * @功能描述：
	 * @创建人：王靓
	 * @创建时间：2018年5月16日下午3:00:21
	 */
	
	private static final long serialVersionUID = -7421065062015355815L;

	public UsersException() {
		super(Contents.ERROR_09);
	}
}
