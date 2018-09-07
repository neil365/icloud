package base.bill.entity.vo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiParam;

public class TBillManagementVO {
	@ApiParam(required = !true, name = "申请日期：开始日期", value = "申请日期：开始日期:\n\r2018-03-28")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_date;
	@ApiParam(required = !true, name = "申请日期：终止日期", value = "申请日期：终止日期:\n\r2018-04-02")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date;
	@ApiParam(required = !true, name = "财政审核状态 ", value = "财政审核状态")
	private Integer cz_shenhe_state;
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
	public Integer getCz_shenhe_state() {
		return cz_shenhe_state;
	}
	public void setCz_shenhe_state(Integer cz_shenhe_state) {
		this.cz_shenhe_state = cz_shenhe_state;
	}
}
