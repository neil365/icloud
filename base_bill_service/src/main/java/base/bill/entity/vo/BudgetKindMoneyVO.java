package base.bill.entity.vo;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

public class BudgetKindMoneyVO {
	
	@ApiModelProperty(value = "票据种类id")
	private Integer budget_kind_money_id;
	
	@Autowired
	private PageVO pageVO;

	
	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public Integer getBudget_kind_money_id() {
		return budget_kind_money_id;
	}

	public void setBudget_kind_money_id(Integer budget_kind_money_id) {
		this.budget_kind_money_id = budget_kind_money_id;
	}

	 
}
