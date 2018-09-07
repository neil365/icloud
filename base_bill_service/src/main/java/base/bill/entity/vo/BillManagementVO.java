package base.bill.entity.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiParam;

public class BillManagementVO {
	@ApiParam(required = !true, name = "查询日期：开始日期", value = "查询日期：开始日期:\n\r2018-03-28")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_date;
	@ApiParam(required = !true, name = "查询日期：终止日期", value = "查询日期：终止日期:\n\r2018-04-02")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date;
	@ApiParam(required = !true, name = "执收单位", value = "执收单位：\n\r执收单位名称id")
	private Integer imposing_unit_id;
	@ApiParam(required = !true, name = "执收单位名称", value = "执收单位名称：\n\r中华人民共和国公安部交通管理局")
	private String chg_agen_name;
	@ApiParam(required = !true, name = "票据名称", value = "票据名称：\n\r陕西省非税一般缴款通知书")
	private String bill_name;
	@ApiParam(required = !true, name = "入库状态", value = "入库状态：\n\r0未入库，1已入库")
	private Integer is_applicant;
	public String getChg_agen_name() {
		return chg_agen_name;
	}
	public void setChg_agen_name(String chg_agen_name) {
		this.chg_agen_name = chg_agen_name;
	}
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
	public Integer getImposing_unit_id() {
		return imposing_unit_id;
	}
	public void setImposing_unit_id(Integer imposing_unit_id) {
		this.imposing_unit_id = imposing_unit_id;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getBill_name() {
		return bill_name;
	}
	public void setBill_name(String bill_name) {
		this.bill_name = bill_name;
	}
	public Integer getIs_applicant() {
		return is_applicant;
	}
	public void setIs_applicant(Integer is_applicant) {
		this.is_applicant = is_applicant;
	}
}
