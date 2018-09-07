package base.bill.entity.vo;

import io.swagger.annotations.ApiParam;

public class TDemandNoteHzVO {
	@ApiParam(required = !true, name = "汇缴里面接收多个id ", value = "汇缴里面接收多个id：\n\r汇缴里面接收多个id ")
	String id;
	@ApiParam(required = !true, name = "缴款人", value = "缴款人：\n\r缴款人")
	String payers_name;
	@ApiParam(required = !true, name = "经办人 ", value = "经办人 ：\n\r经办人 ")
	String operator;
	@ApiParam(required = !true, name = "汇总金额", value = "汇总金额：\n\r汇总金额 ")
	String hj_money;
	public String getPayers_name() {
		return payers_name;
	}
	public void setPayers_name(String payers_name) {
		this.payers_name = payers_name;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getHj_money() {
		return hj_money;
	}
	public void setHj_money(String hj_money) {
		this.hj_money = hj_money;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
