package base.bill.service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import base.bill.entity.TBillManagement;
import base.bill.entity.TBillManagementMingxi;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TBillManagementVO;

/**
 * @描述: 票据领购
 * @包名:base.bill.service
 * @类名: BillManagementService
 * @param billManagement
 * @创建人 wangp
 * @创建时间 2018年8月27日
 */
public interface BillManagementService {
	/**
	 * @描述: 票据领购申请（新增）
	 * @方法名: insertBillManagement
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	public Results<Object> insertBillManagement(TBillManagement billManagement);
	
	/**
	 * @描述: 票据领购申请（修改）
	 * @方法名: updateBillManagement
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	public Results<Object> updateBillManagement(TBillManagement billManagement);
	
	/**
	 * @描述: 票据领购申请（根据条件查询数据）
	 * @方法名: getBillManagementByCon
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	//public Results<ListVO> getBillManagementByCon(TBillManagementVO billManagementvo, PageVO pageVo);
	
	/**
	 * @描述: 票据领购申请（根据条件查询数据/查询所有数据）
	 * @方法名: getBillManagementList
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	public Results<ListVO<TBillManagement>> getBillManagementList(TBillManagementVO billManagementvo, PageVO pageVo);
	
	/**
	 * @描述: 票据领购申请（删除数据）
	 * @方法名: deleteBillManagement
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	public Results<Object> deleteBillManagement(TBillManagement billManagement);
	
	/**
	 * @描述: 票据领购申请（上报）
	 * @方法名: reportBillManagement
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	public Results<Object> reportBillManagement(TBillManagement billManagement);
	
	/**
	 * @描述: 票据领购申请（取消上报）
	 * @方法名: cancereportBillManagement
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	public Results<Object> cancereportBillManagement(TBillManagement billManagement);
	
	
	/***********************************票据领购申请 明细*************************************************/
	
	/**
	 * @描述: 票据领购申请 明细（新增）
	 * @方法名: insertBillManagement
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	public Results<Object> insertBillManagementmingxi(TBillManagementMingxi tBillManagementMingxi);
	
	/**
	 * @描述: 票据领购申请 明细（修改）
	 * @方法名: updateBillManagementmingxi
	 * @param billManagement
	 * @return
	 * @throws Exception
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年8月27日
	 */
	public Results<Object> updateBillManagementmingxi(TBillManagementMingxi tBillManagementMingxi);
	
}
