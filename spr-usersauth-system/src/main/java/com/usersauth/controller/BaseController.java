package com.usersauth.controller;

import com.spr.contents.msg.Page;

public abstract class BaseController {
	
	public Page setPage(Integer p){
		Page page = new Page();
		page.setPageSize(3);
		if(p!=null) {
			page.setPageNo(p);
		}else {
			page.setPageNo(1);
		}
		
		return page;
	}
}
