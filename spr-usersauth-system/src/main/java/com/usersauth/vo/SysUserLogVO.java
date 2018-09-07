package com.usersauth.vo;

import java.util.Date;

public class SysUserLogVO extends AuthToken {
	//用户日志查询时间
	private Date start_date;
	private Date end_date;

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
}
