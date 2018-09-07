package base.bill.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

public class BillTypeVO {
	
	@ApiModelProperty(value = "票据种类id")
	private Integer bill_type_id;
	
	@Autowired
	private PageVO pageVO;

	
	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public Integer getBill_type_id() {
		return bill_type_id;
	}

	public void setBill_type_id(Integer bill_type_id) {
		this.bill_type_id = bill_type_id;
	}
	
}
