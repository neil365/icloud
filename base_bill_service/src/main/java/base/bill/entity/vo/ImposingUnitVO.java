package base.bill.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

public class ImposingUnitVO {
	
	@ApiModelProperty(value = "财政id")
	private Integer financial_id;
	
	@ApiModelProperty(value = "执收单位id")
	private Integer imposing_unit_id;
	
	@ApiModelProperty(value = "执收单位与非税项目的id")
	private Integer imposing_unit_nproject_id;
	
	@ApiModelProperty(value = "征收大厅id")
	private Integer levyfall_id;
	
	@ApiModelProperty(value = "资金性质")
	private Integer capital_property;
		
	@ApiModelProperty(value = "非税项目id拼接成字符串(例如：1,2,3)")
	private String notax_project_id_str;
	
	@ApiModelProperty(value = "票据信息id拼接成字符串(例如：1,2,3)")
	private String bill_info_maintain_id_str;
	
	@ApiModelProperty(value = "是否管理员")
	private Integer is_manage;
	
	@ApiModelProperty(value = "是否启用")
	private Integer is_use;
	
	@ApiModelProperty(value = "是否加载")
	private boolean loading;
	
	/**
	 * 新增用户id
	 * 作者:刘晔
	 */
	@ApiModelProperty(value = "用户id")
	private Integer user_id;
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Autowired
	private PageVO pageVO;

	public Integer getImposing_unit_id() {
		return imposing_unit_id;
	}

	public void setImposing_unit_id(Integer imposing_unit_id) {
		this.imposing_unit_id = imposing_unit_id;
	}

 
	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}


	public Integer getIs_use() {
		return is_use;
	}

	public void setIs_use(Integer is_use) {
		this.is_use = is_use;
	}

	public String getNotax_project_id_str() {
		return notax_project_id_str;
	}

	public void setNotax_project_id_str(String notax_project_id_str) {
		this.notax_project_id_str = notax_project_id_str;
	}


	public Integer getFinancial_id() {
		return financial_id;
	}

	public void setFinancial_id(Integer financial_id) {
		this.financial_id = financial_id;
	}

	public Integer getLevyfall_id() {
		return levyfall_id;
	}

	public void setLevyfall_id(Integer levyfall_id) {
		this.levyfall_id = levyfall_id;
	}

	public String getBill_info_maintain_id_str() {
		return bill_info_maintain_id_str;
	}

	public void setBill_info_maintain_id_str(String bill_info_maintain_id_str) {
		this.bill_info_maintain_id_str = bill_info_maintain_id_str;
	}

	public Integer getCapital_property() {
		return capital_property;
	}

	public void setCapital_property(Integer capital_property) {
		this.capital_property = capital_property;
	}

	public Integer getIs_manage() {
		return is_manage;
	}

	public void setIs_manage(Integer is_manage) {
		this.is_manage = is_manage;
	}

	public boolean isLoading() {
		return loading;
	}

	public void setLoading(boolean loading) {
		this.loading = loading;
	}

	public Integer getImposing_unit_nproject_id() {
		return imposing_unit_nproject_id;
	}

	public void setImposing_unit_nproject_id(Integer imposing_unit_nproject_id) {
		this.imposing_unit_nproject_id = imposing_unit_nproject_id;
	}

 
}
