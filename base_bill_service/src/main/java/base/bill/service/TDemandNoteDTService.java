package base.bill.service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TDemandNote;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TDemandNoteVO;
/**
 * 
 * @类描述： 一般缴款信息服务（大厅模式）也为 委托业务
 * @项目名称：base_bill_service
 * @包名：base.bill.service
 * @类名称：TDemandNoteService
 * @创建人：wangp
 * @创建时间：2018年8月17日
 */

public interface TDemandNoteDTService {
	
		/**
		 * 
		 * @描述:增加(保存) 一般缴款信息 大厅模式 也为 委托业务
		 * @方法名: insertTDemandNoteDT
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		public Results<Object> insertTDemandNoteDT(TDemandNote tDemandNote);

		
		/**
		 * 
		 * @描述:打印一般缴款信息大厅模式也为 委托业务 即为修改新增一个票据号码入库
		 * @方法名: PrintTDemandNoteDT
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		public Results<Object> printTDemandNoteDT(TDemandNote tDemandNote);

		
		
		/**
		 * 
		 * @描述: 条件查询获取  查询所有  大厅模式 也为 委托业务一般缴款信息
		 * @方法名: getTDemandNoteListDT
		 * @param financialVO
		 * @param pageVo
		 * @return
		 * @返回类型 Results<ListVO<TDemandNote>>
		 * @创建人 wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		public Results<ListVO<TDemandNote>> getTDemandNoteListDT(TDemandNoteVO tDemandNoteVO, PageVO pageVo);
		
		/**
		 * 
		 * @描述:  查询大厅模式 也为 委托业务一般缴款信息
		 * @方法名: getTDemandNoteByConDT
		 * @return
		 * @返回类型 List<TFinancial>
		 * @创建人wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		//public Results getTDemandNoteByConDT(TDemandNote tDemandNote , PageVO pageVo);
		
		
		/**
		 * 
		 * @描述: 删除大厅模式也为 委托业务一般缴款信息
		 * @方法名: deleteTDemandNoteDT
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		public Results<Object> deleteTDemandNoteDT(TDemandNote tDemandNote);
		
		/**
		 * 
		 * @描述: 作废大厅模式 也为 委托业务一般缴款信息单
		 * @方法名: invalidatedTDemandNoteDT
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		public Results<Object> invalidatedTDemandNoteDT(TDemandNote tDemandNote);
		
		/**
		 * 
		 * @描述: 取消作废大厅模式 也为 委托业务一般缴款信息单
		 * @方法名: cancelinvalidatedTDemandNoteDT
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		public Results<Object> cancelinvalidatedTDemandNoteDT(TDemandNote tDemandNote);
		
		/**
		 * 
		 * @描述: 回执大厅模式 也为 委托业务一般缴款信息单
		 * @方法名: returnTDemandNoteDT
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		public Results<Object> returnTDemandNoteDT(TDemandNote tDemandNote);
		
		/**
		 * 
		 * @描述: 取消回执大厅模式 也为 委托业务一般缴款信息单
		 * @方法名: cancereturnTDemandNoteDT
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月17
		 * @since
		 * @throws
		 */
		public Results<Object> cancereturnTDemandNoteDT(TDemandNote tDemandNote);
}

