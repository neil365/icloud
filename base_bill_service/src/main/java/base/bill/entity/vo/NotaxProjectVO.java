package base.bill.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

public class NotaxProjectVO {
	
	@ApiModelProperty(value = "财政id")
	private Integer financial_id;
	
	@ApiModelProperty(value = "项目id")
	private Integer notax_project_id;
		
	@ApiModelProperty(value = "是否管理员")
	private Integer isManage;
	
	@ApiModelProperty(value = "执收单位id")
	private Integer imposing_unit_id;
	
	@ApiModelProperty(value = "资质性质")
	private Integer capital_property;
	
	@Autowired
	private PageVO pageVO;
	
	public Integer getImposing_unit_id() {
		return imposing_unit_id;
	}

	public void setImposing_unit_id(Integer imposing_unit_id) {
		this.imposing_unit_id = imposing_unit_id;
	}

	public Integer getIsManage() {
		return isManage;
	}

	public void setIsManage(Integer isManage) {
		this.isManage = isManage;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public Integer getNotax_project_id() {
		return notax_project_id;
	}

	public void setNotax_project_id(Integer notax_project_id) {
		this.notax_project_id = notax_project_id;
	}

	public Integer getFinancial_id() {
		return financial_id;
	}

	public void setFinancial_id(Integer financial_id) {
		this.financial_id = financial_id;
	}

	public Integer getCapital_property() {
		return capital_property;
	}

	public void setCapital_property(Integer capital_property) {
		this.capital_property = capital_property;
	}
	
	

	
}
