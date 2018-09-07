package base.bill.entity.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiParam;

@Component
public class PageVO {

	public static int DEFAULT_PAGE_SIZE = 15;
	@ApiParam(required = !true, name = "每页显示条数", value = "每页显示条数:\\n\\r15")
	private int pageSize = DEFAULT_PAGE_SIZE;
	@ApiParam(required = !true, name = "当前页", value = "当前页:\\n\\r1")
	private int currentPage = 1;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage <= 0 ? 1 : currentPage;
	}

}
