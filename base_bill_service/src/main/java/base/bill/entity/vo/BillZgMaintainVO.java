package base.bill.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

public class BillZgMaintainVO {
	
	@ApiModelProperty(value = "字轨id")
	private Integer bill_zg_maintain_id;
	
	@Autowired
	private PageVO pageVO;

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public Integer getBill_zg_maintain_id() {
		return bill_zg_maintain_id;
	}

	public void setBill_zg_maintain_id(Integer bill_zg_maintain_id) {
		this.bill_zg_maintain_id = bill_zg_maintain_id;
	}

}
