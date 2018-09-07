package base.bill.service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TEmporaryGuaranteeApplication;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TEmporaryGuaranteeApplicationVO;

/**
 * @描述: 暂保押申请信息 管理
 * @包名:base.bill.service
 * @类名: TEmporaryGuaranteeApplicationService
 * @param RefundApplication
 * @创建人 wangp
 * @创建时间 2018年9月5日
 */
public interface TEmporaryGuaranteeApplicationService {
	/**
	 * @描述: 暂保押申请信息 管理（新增）（不可重复新增）
	 * @方法名: insertRefundApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月5日
	 */
	public Results<Object> insertTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication);
	
	/**
	 * @描述: 暂保押申请信息 管理（修改）
	 * @方法名: updateTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月5日
	 */
	public Results<Object> updateTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication);
	
	/**
	 * @描述: 暂保押申请信息 管理（删除）
	 * @方法名: deleteTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月5日
	 */
	public Results<Object> deleteTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication);
	
	/**
	 * @描述: 暂保押申请信息 管理（上报）
	 * @方法名: reportTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月5日
	 */
	public Results<Object> reportTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication);
	
	/**
	 * @描述: 暂保押申请信息 管理（取消上报）
	 * @方法名: cancereportTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月5日
	 */
	public Results<Object> cancereportTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication);
	
	/**
	 * @描述: 暂保押申请信息 管理（查询所有/按条件查询）
	 * @方法名: getTEmporaryGuaranteeApplicationList
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<ListVO<TEmporaryGuaranteeApplication>>
	 * @创建人 wangp
	 * @创建时间 2018年9月5日
	 */
	public Results<ListVO<TEmporaryGuaranteeApplication>> getTEmporaryGuaranteeApplicationList(TEmporaryGuaranteeApplicationVO tEmporaryGuaranteeApplicationvo,PageVO pageVo);
}
