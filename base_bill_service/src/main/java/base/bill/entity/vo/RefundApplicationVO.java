package base.bill.entity.vo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiParam;

public class RefundApplicationVO {
	@ApiParam(required = !true, name = "申请日期：开始日期", value = "申请日期：开始日期:\n\r2018-03-28")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_date;
	@ApiParam(required = !true, name = "申请日期：终止日期", value = "申请日期：终止日期:\n\r2018-04-02")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date;
	@Autowired
	private PageVO pageVO;
	@ApiParam(required = !true, name = "票据编号", value = "票据编号：\n\r票据编号 ")
	private String bill_number;
	@ApiParam(required = !true, name = "上报状态 ", value = "上报状态：\n\r上报状态（1已上报 0未上报） ")
	private Integer reporte_state;
	@ApiParam(required = !true, name = "审核状态", value = "审核状态：\n\r审核状态(1已审核成功 2审核失败 0未审核 3 审核中) ")
	private Integer audit_state;
	public String getBill_number() {
		return bill_number;
	}
	public void setBill_number(String bill_number) {
		this.bill_number = bill_number;
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
	public PageVO getPageVO() {
		return pageVO;
	}
	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
	
	public Integer getReporte_state() {
		return reporte_state;
	}
	public void setReporte_state(Integer reporte_state) {
		this.reporte_state = reporte_state;
	}
	public Integer getAudit_state() {
		return audit_state;
	}
	public void setAudit_state(Integer audit_state) {
		this.audit_state = audit_state;
	}
}
