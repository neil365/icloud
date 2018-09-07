package base.bill.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jeecgframework.poi.excel.annotation.Excel;

import base.bill.entity.TImposingUnit;

import io.swagger.annotations.ApiModelProperty;

public class TImposingUnit {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.imposing_unit_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer imposing_unit_id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.unit_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "单位编码", mergeVertical = true, isImportField = "unit_code")
	private String unit_code;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.unit_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "单位名称", mergeVertical = true, isImportField = "unit_name")
	private String unit_name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.unit_adress
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "单位地址", mergeVertical = true, isImportField = "unit_adress")
	private String unit_adress;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.unit_principal
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "单位负责人", mergeVertical = true, isImportField = "unit_principal")
	private String unit_principal;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.phone
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "单位联系电话", mergeVertical = true, isImportField = "phone")
	private String phone;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.organization_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "组织机构代码", mergeVertical = true, isImportField = "organization_code")
	private String organization_code;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.special_manager
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "专管员", mergeVertical = true, isImportField = "special_manager")
	private String special_manager;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.treasury_payment_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "国库支付代码", mergeVertical = true, isImportField = "treasury_payment_code")
	private String treasury_payment_code;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.unit_brevity_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "单位简码", mergeVertical = true, isImportField = "unit_brevity_code")
	private String unit_brevity_code;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.bill_manager
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private String bill_manager;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.start_time
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Date start_time;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.stop_time
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Date stop_time;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer parent_id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.is_unit
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer is_unit;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.is_bill
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer is_bill;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.is_use
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer is_use;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer delete_status;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.remark
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private String remark;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.unit_competent_department_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer unit_competent_department_id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_imposing_unit.financial_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer financial_id;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.imposing_unit_id
	 * @return  the value of t_imposing_unit.imposing_unit_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getImposing_unit_id() {
		return imposing_unit_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.imposing_unit_id
	 * @param imposing_unit_id  the value for t_imposing_unit.imposing_unit_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setImposing_unit_id(Integer imposing_unit_id) {
		this.imposing_unit_id = imposing_unit_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.unit_code
	 * @return  the value of t_imposing_unit.unit_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getUnit_code() {
		return unit_code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.unit_code
	 * @param unit_code  the value for t_imposing_unit.unit_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_code(String unit_code) {
		this.unit_code = unit_code == null ? null : unit_code.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.unit_name
	 * @return  the value of t_imposing_unit.unit_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getUnit_name() {
		return unit_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.unit_name
	 * @param unit_name  the value for t_imposing_unit.unit_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name == null ? null : unit_name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.unit_adress
	 * @return  the value of t_imposing_unit.unit_adress
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getUnit_adress() {
		return unit_adress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.unit_adress
	 * @param unit_adress  the value for t_imposing_unit.unit_adress
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_adress(String unit_adress) {
		this.unit_adress = unit_adress == null ? null : unit_adress.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.unit_principal
	 * @return  the value of t_imposing_unit.unit_principal
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getUnit_principal() {
		return unit_principal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.unit_principal
	 * @param unit_principal  the value for t_imposing_unit.unit_principal
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_principal(String unit_principal) {
		this.unit_principal = unit_principal == null ? null : unit_principal.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.phone
	 * @return  the value of t_imposing_unit.phone
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.phone
	 * @param phone  the value for t_imposing_unit.phone
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.organization_code
	 * @return  the value of t_imposing_unit.organization_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getOrganization_code() {
		return organization_code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.organization_code
	 * @param organization_code  the value for t_imposing_unit.organization_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setOrganization_code(String organization_code) {
		this.organization_code = organization_code == null ? null : organization_code.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.special_manager
	 * @return  the value of t_imposing_unit.special_manager
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getSpecial_manager() {
		return special_manager;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.special_manager
	 * @param special_manager  the value for t_imposing_unit.special_manager
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setSpecial_manager(String special_manager) {
		this.special_manager = special_manager == null ? null : special_manager.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.treasury_payment_code
	 * @return  the value of t_imposing_unit.treasury_payment_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getTreasury_payment_code() {
		return treasury_payment_code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.treasury_payment_code
	 * @param treasury_payment_code  the value for t_imposing_unit.treasury_payment_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setTreasury_payment_code(String treasury_payment_code) {
		this.treasury_payment_code = treasury_payment_code == null ? null : treasury_payment_code.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.unit_brevity_code
	 * @return  the value of t_imposing_unit.unit_brevity_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getUnit_brevity_code() {
		return unit_brevity_code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.unit_brevity_code
	 * @param unit_brevity_code  the value for t_imposing_unit.unit_brevity_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_brevity_code(String unit_brevity_code) {
		this.unit_brevity_code = unit_brevity_code == null ? null : unit_brevity_code.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.bill_manager
	 * @return  the value of t_imposing_unit.bill_manager
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getBill_manager() {
		return bill_manager;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.bill_manager
	 * @param bill_manager  the value for t_imposing_unit.bill_manager
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setBill_manager(String bill_manager) {
		this.bill_manager = bill_manager == null ? null : bill_manager.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.start_time
	 * @return  the value of t_imposing_unit.start_time
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Date getStart_time() {
		return start_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.start_time
	 * @param start_time  the value for t_imposing_unit.start_time
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.stop_time
	 * @return  the value of t_imposing_unit.stop_time
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Date getStop_time() {
		return stop_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.stop_time
	 * @param stop_time  the value for t_imposing_unit.stop_time
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setStop_time(Date stop_time) {
		this.stop_time = stop_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.parent_id
	 * @return  the value of t_imposing_unit.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getParent_id() {
		return parent_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.parent_id
	 * @param parent_id  the value for t_imposing_unit.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.is_unit
	 * @return  the value of t_imposing_unit.is_unit
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getIs_unit() {
		return is_unit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.is_unit
	 * @param is_unit  the value for t_imposing_unit.is_unit
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setIs_unit(Integer is_unit) {
		this.is_unit = is_unit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.is_bill
	 * @return  the value of t_imposing_unit.is_bill
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getIs_bill() {
		return is_bill;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.is_bill
	 * @param is_bill  the value for t_imposing_unit.is_bill
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setIs_bill(Integer is_bill) {
		this.is_bill = is_bill;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.is_use
	 * @return  the value of t_imposing_unit.is_use
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getIs_use() {
		return is_use;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.is_use
	 * @param is_use  the value for t_imposing_unit.is_use
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setIs_use(Integer is_use) {
		this.is_use = is_use;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.delete_status
	 * @return  the value of t_imposing_unit.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getDelete_status() {
		return delete_status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.delete_status
	 * @param delete_status  the value for t_imposing_unit.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setDelete_status(Integer delete_status) {
		this.delete_status = delete_status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.remark
	 * @return  the value of t_imposing_unit.remark
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.remark
	 * @param remark  the value for t_imposing_unit.remark
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.unit_competent_department_id
	 * @return  the value of t_imposing_unit.unit_competent_department_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getUnit_competent_department_id() {
		return unit_competent_department_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.unit_competent_department_id
	 * @param unit_competent_department_id  the value for t_imposing_unit.unit_competent_department_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_competent_department_id(Integer unit_competent_department_id) {
		this.unit_competent_department_id = unit_competent_department_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_imposing_unit.financial_id
	 * @return  the value of t_imposing_unit.financial_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getFinancial_id() {
		return financial_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_imposing_unit.financial_id
	 * @param financial_id  the value for t_imposing_unit.financial_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setFinancial_id(Integer financial_id) {
		this.financial_id = financial_id;
	}

	private List<TImposingUnit> children = new ArrayList<TImposingUnit>();
	
	public List<TImposingUnit> getChildren() {
		return children;
	}

	public void setChildren(List<TImposingUnit> children) {
		this.children = children;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getUnitcode_name() {
		return unitcode_name;
	}

	public void setUnitcode_name(String unitcode_name) {
		this.unitcode_name = unitcode_name;
	}
   
	public boolean isLoading() {
		return loading;
	}

	public void setLoading(boolean loading) {
		this.loading = loading;
	}

	@ApiModelProperty(value = "选中状态")
	private boolean status;
	
	@ApiModelProperty(value = "执收单位编码与名称拼接")
	private String unitcode_name;
	
	@ApiModelProperty(value = "是否默认加载")
	private boolean loading;
	
}