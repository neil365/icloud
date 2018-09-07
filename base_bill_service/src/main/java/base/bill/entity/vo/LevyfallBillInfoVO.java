package base.bill.entity.vo;

import io.swagger.annotations.ApiModelProperty;

public class LevyfallBillInfoVO {
		
	@ApiModelProperty(value = "征收大厅id")
	private Integer levyfall_id;
	
	@ApiModelProperty(value = "票据信息维护id拼接成字符串(例如：1,2,3)")
	private String bill_info_maintain_id_str;

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

 
	
}
