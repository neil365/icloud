package base.bill.entity.vo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiParam;

public class TBillPplicationDestructionVO {
	@ApiParam(required = !true, name = "申请日期：开始日期", value = "申请日期：开始日期:\n\r2018-03-28")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_date;
	@ApiParam(required = !true, name = "申请日期：终止日期", value = "申请日期：终止日期:\n\r2018-04-02")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date;
	@ApiParam(required = !true, name = "经办人", value = "经办人")
	private String jbr;
	@Autowired
	private PageVO pageVO;
	public PageVO getPageVO() {
		return pageVO;
	}
	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
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
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	
}
