package base.bill.entity;

import java.util.List;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import base.bill.entity.TBudgetKindMoney;

import io.swagger.annotations.ApiModelProperty;

@ExcelTarget(value = "tBudgetKindMoney")
public class TBudgetKindMoney {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_budget_kind_money.budget_kind_money_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer budget_kind_money_id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_budget_kind_money.kindmoney_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "类款编码", mergeVertical = true, isImportField = "kindmoney_code")
	private String kindmoney_code;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_budget_kind_money.kindmoney_fullname
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private String kindmoney_fullname;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_budget_kind_money.kindmoney_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "类款名称", mergeVertical = true, isImportField = "kindmoney_name")
	private String kindmoney_name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_budget_kind_money.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer parent_id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_budget_kind_money.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer delete_status;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_budget_kind_money.state
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	@Excel(name = "备注", mergeVertical = true, isImportField = "state")
	private String state;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_budget_kind_money.budget_kind_money_id
	 * @return  the value of t_budget_kind_money.budget_kind_money_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getBudget_kind_money_id() {
		return budget_kind_money_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_budget_kind_money.budget_kind_money_id
	 * @param budget_kind_money_id  the value for t_budget_kind_money.budget_kind_money_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setBudget_kind_money_id(Integer budget_kind_money_id) {
		this.budget_kind_money_id = budget_kind_money_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_budget_kind_money.kindmoney_code
	 * @return  the value of t_budget_kind_money.kindmoney_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getKindmoney_code() {
		return kindmoney_code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_budget_kind_money.kindmoney_code
	 * @param kindmoney_code  the value for t_budget_kind_money.kindmoney_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setKindmoney_code(String kindmoney_code) {
		this.kindmoney_code = kindmoney_code == null ? null : kindmoney_code.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_budget_kind_money.kindmoney_fullname
	 * @return  the value of t_budget_kind_money.kindmoney_fullname
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getKindmoney_fullname() {
		return kindmoney_fullname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_budget_kind_money.kindmoney_fullname
	 * @param kindmoney_fullname  the value for t_budget_kind_money.kindmoney_fullname
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setKindmoney_fullname(String kindmoney_fullname) {
		this.kindmoney_fullname = kindmoney_fullname == null ? null : kindmoney_fullname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_budget_kind_money.kindmoney_name
	 * @return  the value of t_budget_kind_money.kindmoney_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getKindmoney_name() {
		return kindmoney_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_budget_kind_money.kindmoney_name
	 * @param kindmoney_name  the value for t_budget_kind_money.kindmoney_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setKindmoney_name(String kindmoney_name) {
		this.kindmoney_name = kindmoney_name == null ? null : kindmoney_name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_budget_kind_money.parent_id
	 * @return  the value of t_budget_kind_money.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getParent_id() {
		return parent_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_budget_kind_money.parent_id
	 * @param parent_id  the value for t_budget_kind_money.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_budget_kind_money.delete_status
	 * @return  the value of t_budget_kind_money.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getDelete_status() {
		return delete_status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_budget_kind_money.delete_status
	 * @param delete_status  the value for t_budget_kind_money.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setDelete_status(Integer delete_status) {
		this.delete_status = delete_status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_budget_kind_money.state
	 * @return  the value of t_budget_kind_money.state
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getState() {
		return state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_budget_kind_money.state
	 * @param state  the value for t_budget_kind_money.state
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public List<TBudgetKindMoney> getChildren() {
		return children;
	}

	public void setChildren(List<TBudgetKindMoney> children) {
		this.children = children;
	}

	public String getBudgetKindMoney_code_name() {
		return budgetKindMoney_code_name;
	}

	public void setBudgetKindMoney_code_name(String budgetKindMoney_code_name) {
		this.budgetKindMoney_code_name = budgetKindMoney_code_name;
	}
	
	private List<TBudgetKindMoney> children;
	
	@ApiModelProperty(value = "类款编码与名称拼接")
	private String budgetKindMoney_code_name;
}