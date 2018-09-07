package base.bill.entity.vo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiParam;

public class TDemandNoteVO{
	/*@ApiParam(required = !true, name = "主键ID ", value = "主键ID  ")
	private Integer demand_note_id;
	public Integer getDemand_note_id() {
		return demand_note_id;
	}
	public void setDemand_note_id(Integer demand_note_id) {
		this.demand_note_id = demand_note_id;
	}*/
	@ApiParam(required = !true, name = "查询日期：开始日期", value = "查询日期：开始日期:\n\r2018-03-28")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_date;
	@ApiParam(required = !true, name = "查询日期：终止日期", value = "查询日期：终止日期:\n\r2018-04-02")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date;
	@ApiParam(required = !true, name = "开始票据号段 ", value = "开始票据号段 ")
	private String bill_no_start;
	@ApiParam(required = !true, name = "结束票据号段", value = "结束票据号段 ")
	private String bill_no_end;
	//@ApiParam(required = !true, name = "填制日期起止日期 ", value = "填制日期起止日期 ：\n\r填制日期起止日期 ")
	//private Date bill_date;
	@ApiParam(required = !true, name = "缴款人名称 ", value = "缴款人名称 ：\n\r缴款人名称 ")
	private String payer_name; 
	@ApiParam(required = !true, name = "缴款人名称 ", value = "缴款人名称 ：\n\r缴款人名称 ")
	private String t_full_contributors_name; 
	public String getT_full_contributors_name() {
		return t_full_contributors_name;
	}
	public void setT_full_contributors_name(String t_full_contributors_name) {
		this.t_full_contributors_name = t_full_contributors_name;
	}
	public String getT_full_contributors_bank() {
		return t_full_contributors_bank;
	}
	public void setT_full_contributors_bank(String t_full_contributors_bank) {
		this.t_full_contributors_bank = t_full_contributors_bank;
	}
	public String getT_full_contributors_bank_number() {
		return t_full_contributors_bank_number;
	}
	public void setT_full_contributors_bank_number(String t_full_contributors_bank_number) {
		this.t_full_contributors_bank_number = t_full_contributors_bank_number;
	}
	@ApiParam(required = !true, name = "缴款人开户行 ", value = "缴款人开户行 ：\n\r缴款人开户行 ")
	private String t_full_contributors_bank; 
	@ApiParam(required = !true, name = "缴款人开户行账号 ", value = "缴款人开户行账号 ：\n\r缴款人开户行账号 ")
	private String t_full_contributors_bank_number; 
	@ApiParam(required = !true, name = "项目名称 ", value = "项目名称 ：\n\r项目名称 ")
	private String income_project_name; 
	@ApiParam(required = !true, name = "经办人名称 ", value = "经办人名称 ：\n\r经办人名称 ")
	private String operator;
	@ApiParam(required = !true, name = "打印状态 ", value = "打印状态：\n\r打印状态（1为打印 0为未打印） ")
	private Integer print_state;
	@ApiParam(required = !true, name = "作废状态 ", value = "作废状态：\n\r作废状态（1为作废 0为未作废） ")
	private Integer invalidated_state;
	@ApiParam(required = !true, name = "备注", value = "备注 ：\n\r备注 ")
	private String memo; 
	@ApiParam(required = !true, name = "票据名称 ", value = "票据名称：\n\r票据名称 ")
	private String bill_name; 
	@ApiParam(required = !true, name = "汇缴里面接收多个id ", value = "汇缴里面接收多个id：\n\r汇缴里面接收多个id ")
	private String id;
	@ApiParam(required = !true, name = "外键id ", value = "外键id ：\n\r外键id ")
	private Integer id_waijianid;
	@ApiParam(required = !true, name = "缴款方式 ", value = "缴款方式：\n\r缴款方式 ")
	private String payment_method; 
	@ApiParam(required = !true, name = "汇总状态 ", value = "汇总状态：\n\r汇总状态（1为汇总 0为未汇总） ")
	private Integer summary_state;
	@ApiParam(required = !true, name = "执收单位（也为委托单位） ", value = "执收单位（也为委托单位）：\n\r执收单位（也为委托单位） ")
	private String chg_agen_name; 
	@ApiParam(required = !true, name = "票据编码 ", value = "票据编码：\n\r票据编码 ")
	private String bill_code;
	@Autowired
	private PageVO pageVO;
	public Integer getInvalidated_state() {
		return invalidated_state;
	}
	public void setInvalidated_state(Integer invalidated_state) {
		this.invalidated_state = invalidated_state;
	}
	public PageVO getPageVO() {
		return pageVO;
	}
	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public Integer getId_waijianid() {
		return id_waijianid;
	}
	public void setId_waijianid(Integer id_waijianid) {
		this.id_waijianid = id_waijianid;
	}
	public String getBill_code() {
		return bill_code;
	}
	public void setBill_code(String bill_code) {
		this.bill_code = bill_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChg_agen_name() {
		return chg_agen_name;
	}
	public void setChg_agen_name(String chg_agen_name) {
		this.chg_agen_name = chg_agen_name;
	}
	public Integer getSummary_state() {
		return summary_state;
	}
	public void setSummary_state(Integer summary_state) {
		this.summary_state = summary_state;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getBill_name() {
		return bill_name;
	}
	public void setBill_name(String bill_name) {
		this.bill_name = bill_name;
	}
	/*public Date getBill_date() {
		return bill_date;
	}
	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}*/
	public String getBill_no_start() {
		return bill_no_start;
	}
	public void setBill_no_start(String bill_no_start) {
		this.bill_no_start = bill_no_start;
	}
	public String getBill_no_end() {
		return bill_no_end;
	}
	public void setBill_no_end(String bill_no_end) {
		this.bill_no_end = bill_no_end;
	}
	public String getPayer_name() {
		return payer_name;
	}
	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}
	public String getIncome_project_name() {
		return income_project_name;
	}
	public void setIncome_project_name(String income_project_name) {
		this.income_project_name = income_project_name;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Integer getPrint_state() {
		return print_state;
	}
	public void setPrint_state(Integer print_state) {
		this.print_state = print_state;
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
}
