package base.bill.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

public class LevyFallVO {
	
	@ApiModelProperty(value = "财政id")
	private Integer financial_id;
	
	@ApiModelProperty(value = "征收大厅id")
	private Integer levyfall_id;
		
	@ApiModelProperty(value = "是否为管理员")
	private Integer is_manage;
	
	@Autowired
	private PageVO pageVO;

	
	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public Integer getLevyfall_id() {
		return levyfall_id;
	}

	public void setLevyfall_id(Integer levyfall_id) {
		this.levyfall_id = levyfall_id;
	}

 

	public Integer getFinancial_id() {
		return financial_id;
	}

	public void setFinancial_id(Integer financial_id) {
		this.financial_id = financial_id;
	}

	public Integer getIs_manage() {
		return is_manage;
	}

	public void setIs_manage(Integer is_manage) {
		this.is_manage = is_manage;
	}

	
}
