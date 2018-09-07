package base.bill.service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillManagementInspection;
import base.bill.entity.TBillManagementInspectionMingxi;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TBillManagementInspectionVO;

/**
 * @描述: 票据缴验
 * @包名:base.bill.service
 * @类名: TBillManagementInspectionInspectionService
 * @param tBillManagementInspection
 * @创建人 wangp
 * @创建时间 2018年8月28日
 */
public interface TBillManagementInspectionService {
	/**
	 * @描述: 票据缴验申请（新增）
	 * @方法名: insertTBillManagementInspection
	 * @param tBillManagementInspection
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	public Results<Object> insertTBillManagementInspection(TBillManagementInspection tBillManagementInspection);
	
	/**
	 * @描述: 票据缴验申请（修改） 
	 * @方法名: updateTBillManagementInspection
	 * @param tBillManagementInspection
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	public Results<Object> updateTBillManagementInspection(TBillManagementInspection tBillManagementInspection);
	
	/**
	 * @描述: 票据缴验申请（根据条件查询数据）
	 * @方法名: getTBillManagementInspectionByCon
	 * @param tBillManagementInspection
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	//public Results<ListVO> getTBillManagementInspectionByCon(TBillManagementInspectionVO tBillManagementInspectionvo, PageVO pageVo);
	
	/**
	 * @描述: 票据缴验申请（查询所有数据）
	 * @方法名: getTBillManagementInspectionList
	 * @param tBillManagementInspectionvo
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	public Results<ListVO<TBillManagementInspection>> getTBillManagementInspectionList(TBillManagementInspectionVO tBillManagementInspectionvo,PageVO pageVo);
	
	/**
	 * @描述: 票据缴验申请（删除数据）
	 * @方法名: deleteTBillManagementInspection
	 * @param tBillManagementInspection
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	public Results<Object> deleteTBillManagementInspection(TBillManagementInspection tBillManagementInspection);
	
	/**
	 * @描述: 票据缴验申请（上报）
	 * @方法名: reportTBillManagementInspection
	 * @param tBillManagementInspection
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	public Results<Object> reportTBillManagementInspection(TBillManagementInspection tBillManagementInspection);
	
	/**
	 * @描述: 票据缴验申请（取消上报）
	 * @方法名: cancereportTBillManagementInspection
	 * @param tBillManagementInspection
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	public Results<Object> cancereportTBillManagementInspection(TBillManagementInspection tBillManagementInspection);
	
	
	/***********************************票据缴验申请 明细*************************************************/
	
	/**
	 * @描述: 票据缴验申请 明细（新增）
	 * @方法名: insertTBillManagementInspection
	 * @param tBillManagementInspection
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	public Results<Object> insertTBillManagementInspectionmingxi(TBillManagementInspectionMingxi tTBillManagementInspectionMingxi);
	
	/**
	 * @描述: 票据缴验申请 明细（修改）
	 * @方法名: updateTBillManagementInspectionmingxi
	 * @param tBillManagementInspection
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月28日
	 */
	public Results<Object> updateTBillManagementInspectionmingxi(TBillManagementInspectionMingxi tTBillManagementInspectionMingxi);
	
}
