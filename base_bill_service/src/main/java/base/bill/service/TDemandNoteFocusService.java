package base.bill.service;

import java.util.List;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TDemandNote;
import base.bill.entity.TDemandNoteHz;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TDemandNoteHzVO;
import base.bill.entity.vo.TDemandNoteVO;
/**
 * 
 * @类描述： 一般缴款信息服务(汇缴服务)
 * @项目名称：base_bill_service
 * @包名：base.bill.service
 * @类名称：TDemandNoteFocusService
 * @创建人：wangp
 * @创建时间：2018年8月20日日
 */

public interface TDemandNoteFocusService {
	
		/**
		 * 
		 * @描述:增加(保存) 一般缴款信息 汇缴服务
		 * @方法名: insertTDemandNoteFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<Object> insertTDemandNoteFocus(TDemandNote tDemandNote);
		
		/**
		 * 
		 * @描述:汇总(修改) 一般缴款信息 汇缴服务 
		 * @方法名: updateTDemandNoteFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<Object> updateTDemandNoteFocus(TDemandNoteVO tDemandNotevo,List list);
		
		/**
		 * 
		 * @描述:打印一般缴款信息(汇缴服务) 即为修改新增一个票据号码入库
		 * @方法名: PrintTDemandNoteFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<Object> printTDemandNoteFocus(TDemandNote tDemandNote);

		/**
		 * 
		 * @描述: 条件查询获取 查询所有  汇缴明细服务一般缴款信息
		 * @方法名: getTDemandNoteFocusList
		 * @param financialVO
		 * @param pageVo
		 * @return
		 * @返回类型 Results<ListVO<TDemandNote>>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<ListVO<TDemandNote>> getTDemandNoteFocusList(TDemandNoteVO tDemandNoteVO, PageVO pageVo);
		
		/**
		 * 
		 * @描述: 条件查询获取 集中汇缴汇总查询一般缴款信息
		 * @方法名: getTDemandNoteJZFocusList
		 * @param financialVO
		 * @param pageVo
		 * @return
		 * @返回类型 Results<ListVO<TDemandNote>>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<ListVO<TDemandNote>> getTDemandNoteJZFocusList(TDemandNoteVO tDemandNoteVO, PageVO pageVo);
		
		/**
		 * 
		 * @描述:  查询汇缴服务一般缴款信息
		 * @方法名: TDemandNoteFocusLists
		 * @return
		 * @返回类型 List<TFinancial>
		 * @创建人wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		//public Results<ListVO<TDemandNote>> TDemandNoteFocusLists(TDemandNote tDemandNote, PageVO pageVo);
		
		
		/**
		 * 
		 * @描述: 删除汇缴服务一般缴款信息
		 * @方法名: deleteTDemandNoteFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<Object> deleteTDemandNoteFocus(TDemandNote tDemandNote);
		
		/**
		 * 
		 * @描述: 作废汇缴服务一般缴款信息单
		 * @方法名: invalidatedTDemandNoteFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<Object> invalidatedTDemandNoteFocus(TDemandNote tDemandNote);
		
		/**
		 * 
		 * @描述: 取消作废汇缴服务一般缴款信息单
		 * @方法名: cancelinvalidatedTDemandNoteFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<Object> cancelinvalidatedTDemandNoteFocus(TDemandNote tDemandNote);
		
		/*************************************汇缴- 汇总表服务的功能接口*********************************************************/
		
		/**
		 * 
		 * @描述: 作废汇缴服务一般缴款信息单
		 * @方法名: invalidatedTDemandNoteHzFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月20日
		 * @since
		 * @throws
		 */
		public Results<Object> invalidatedTDemandNoteHzFocus(TDemandNoteHz tDemandNotehz);
		
		/**
		 * 
		 * @描述: 汇总缴款信息表（汇缴服务）新增汇总数据
		 * @方法名: insertTDemandNoteHzFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月23日
		 * @since
		 * @throws
		 */
		public Results<Object> insertTDemandNoteHzFocus(TDemandNoteHzVO tDemandNoteHzvo);
		
		/**
		 * 
		 * @描述:汇总缴款信息表（汇缴服务）删除汇总数据
		 * @方法名: deleteTDemandNoteHzFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月23日
		 * @since
		 * @throws
		 */
		public Results<Object> deleteTDemandNoteHzFocus(TDemandNoteHz tDemandNotehz);
		
		/**
		 * 
		 * @描述:汇总缴款信息表（汇缴服务）查看汇总数据中的子表详细信息
		 * @方法名: getTDemandNoteHzFocusList
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月23日
		 * @since
		 * @throws
		 */
		public Results getTDemandNoteHzFocusList(TDemandNoteHz tDemandNoteHz, PageVO pageVo);
		
		/**
		 * 
		 * @描述:汇总缴款信息表（汇缴服务）重新打印汇总数据列表信息
		 * @方法名: printTDemandNoteHzFocus
		 * @return
		 * @返回类型 Results<Object>
		 * @创建人 wangp
		 * @创建时间 2018年8月23日
		 * @since
		 * @throws
		 */
		public Results<Object> printTDemandNoteHzFocus(TDemandNote tDemandNote);
}

