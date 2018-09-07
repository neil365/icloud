package com.usersauth.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@ApiModel
public class PageVO {

	@ApiModelProperty("默认每页数据数量")
	public static int DEFAULT_PAGE_SIZE = 15;
	@ApiModelProperty("默认每页数据数量")
	private int pageSize = DEFAULT_PAGE_SIZE;
	@ApiModelProperty("默认当前页数")
	private int currentPage = 1;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage < 0 ? 0 : currentPage;
	}

}
