package base.bill.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

public class BillInfoMaintainVO {
	
	@ApiModelProperty(value = "票据信息id")
	private Integer bill_info_maintain_id;
	
	@ApiModelProperty(value = "征收大厅id")
	private Integer levyfall_id;
	
	@ApiModelProperty(value = "执收单位id")
	private Integer imposing_unit_id;
	
	@Autowired
	private PageVO pageVO;

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public Integer getBill_info_maintain_id() {
		return bill_info_maintain_id;
	}

	public void setBill_info_maintain_id(Integer bill_info_maintain_id) {
		this.bill_info_maintain_id = bill_info_maintain_id;
	}

	public Integer getLevyfall_id() {
		return levyfall_id;
	}

	public void setLevyfall_id(Integer levyfall_id) {
		this.levyfall_id = levyfall_id;
	}

	public Integer getImposing_unit_id() {
		return imposing_unit_id;
	}

	public void setImposing_unit_id(Integer imposing_unit_id) {
		this.imposing_unit_id = imposing_unit_id;
	}

 

	
}
