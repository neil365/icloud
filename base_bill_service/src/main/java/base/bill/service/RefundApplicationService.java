package base.bill.service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.RefundApplication;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.RefundApplicationVO;

/**
 * @描述: 退付申请管理
 * @包名:base.bill.service
 * @类名: RefundApplicationService
 * @param RefundApplication
 * @创建人 wangp
 * @创建时间 2018年9月4日
 */
public interface RefundApplicationService{
	/**
	 * @描述: 退付申请管理（新增）（不可重复新增）
	 * @方法名: insertRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	public Results<Object> insertRefundApplication(RefundApplication refundApplication);
	
	/**
	 * @描述: 退付申请管理（查询（申请日期、票据编号、是否审核、是否上报））
	 * @方法名: insertRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	public Results<ListVO<RefundApplication>> getRefundApplicationList(RefundApplicationVO refundApplicationvo,PageVO pageVo);
	
	/**
	 * @描述: 退付申请管理（删除）
	 * @方法名: deleteRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	public Results<Object> deleteRefundApplication(RefundApplication refundApplication);
	
	/**
	 * @描述: 退付申请管理（修改）
	 * @方法名: updateRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	public Results<Object> updateRefundApplication(RefundApplication refundApplication);

	/**
	 * @描述: 退付申请管理（上报）
	 * @方法名: reportRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	public Results<Object> reportRefundApplication(RefundApplication refundApplication);
	
	/**
	 * @描述: 退付申请管理（取消上报）
	 * @方法名: cancereportRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	public Results<Object> cancereportRefundApplication(RefundApplication refundApplication);
	
	
}
