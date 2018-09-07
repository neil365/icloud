package base.bill.service;

import com.spr.contents.msg.Results;

public interface BillunitinventorymanageService {
	/**
	 * 
	 * @描述: 根据条件 查询单位票据库存
	 * @方法名: getBillunitinventorymanage
	 * @return
	 * @返回类型 Results
	 * @创建人 wangp
	 * @创建时间 2018年8月30日
	 * @since
	 * @throws
	 */
	public Results<Object> getBillunitinventorymanageBycon(String bill_name);
}
