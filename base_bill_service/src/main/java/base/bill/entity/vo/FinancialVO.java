package base.bill.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;


public class FinancialVO {
	
	@ApiModelProperty(value = "财政id")
	private Integer financial_id;
	
	@ApiModelProperty(value = "财政名称")
	private String financial_name;
	
	@ApiModelProperty(value = "是否管理员")
	private Integer isManage;
	
	
//	@Autowired
//	private PageVO pageVO;
//
//	public PageVO getPageVO() {
//		return pageVO;
//	}

//	public void setPageVO(PageVO pageVO) {
//		this.pageVO = pageVO;
//	}


	public String getFinancial_name() {
		return financial_name;
	}

	public void setFinancial_name(String financial_name) {
		this.financial_name = financial_name;
	}

	public Integer getFinancial_id() {
		return financial_id;
	}

	public void setFinancial_id(Integer financial_id) {
		this.financial_id = financial_id;
	}

	public Integer getIsManage() {
		return isManage;
	}

	public void setIsManage(Integer isManage) {
		this.isManage = isManage;
	}


}
