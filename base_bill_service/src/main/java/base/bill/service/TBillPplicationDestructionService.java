package base.bill.service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillPplicationDestruction;
import base.bill.entity.TBillPplicationDestructionMingxi;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TBillPplicationDestructionVO;

/**
 * @描述: 票据销毁申请
 * @包名:base.bill.service
 * @类名: TBillPplicationDestructionService
 * @param tBillPplicationDestruction
 * @创建人 wangp
 * @创建时间 2018年8月29日
 */
public interface TBillPplicationDestructionService {
	/**
	 * @描述: 票据销毁申请（新增）
	 * @方法名: insertTBillPplicationDestruction
	 * @param tBillPplicationDestruction
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	public Results<Object> insertTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction);
	/**
	 * @描述: 票据销毁申请（条件查询数据）
	 * @方法名: getTTBillPplicationDestructionBycon
	 * @param tBillPplicationDestruction
	 * @return
	 * @throws Exception
	 * @返回类型 int 
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	//public Results<ListVO<TBillPplicationDestruction>> getTTBillPplicationDestructionBycon(TBillPplicationDestructionVO tBillPplicationDestructionvo, PageVO pageVo);
	/**
	 * @描述: 票据销毁申请（查询所有数据）
	 * @方法名: getTBillPplicationDestructionList
	 * @param tBillPplicationDestruction
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	public  Results<ListVO<TBillPplicationDestruction>> getTBillPplicationDestructionList(TBillPplicationDestructionVO tBillPplicationDestructionvo,PageVO pageVo);
	/**
	 * @描述: 票据销毁申请（修改）
	 * @方法名: updateTBillPplicationDestruction
	 * @param tBillPplicationDestruction
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	public Results<Object> updateTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction);
	
	/**
	 * @描述: 票据销毁申请（删除数据）
	 * @方法名: deleteTBillPplicationDestruction
	 * @param tBillPplicationDestruction
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	public Results<Object> deleteTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction);
	
	/**
	 * @描述: 票据销毁申请（上报）
	 * @方法名: reportTBillPplicationDestruction
	 * @param tBillPplicationDestruction
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	public Results<Object> reportTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction);
	
	/**
	 * @描述: 票据销毁申请（取消上报）
	 * @方法名: cancereportTBillPplicationDestruction
	 * @param tBillPplicationDestruction
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	public Results<Object> cancereportTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction);
	
	/***********************************票据销毁申请 明细*************************************************/
	
	/**
	 * @描述: 票据销毁申请 明细（新增）
	 * @方法名: insertTBillPplicationDestruction
	 * @param tBillPplicationDestructionmingxi
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	public Results<Object> insertTBillPplicationDestructionmingxi(TBillPplicationDestructionMingxi tBillPplicationDestructionmingxi);
	
	/**
	 * @描述: 票据销毁申请 明细（删除数据）
	 * @方法名: deleteTBillPplicationDestructionmingxi
	 * @param tBillPplicationDestructionmingxi
	 * @return
	 * @throws Exception
	 * @创建人 wangp
	 * @创建时间 2018年8月29日
	 */
	public Results<Object> deleteTBillPplicationDestructionmingxi(TBillPplicationDestructionMingxi tBillPplicationDestructionmingxi);
}
