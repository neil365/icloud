package base.bill.service;

import java.util.List;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TDemandNote;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TDemandNoteVO;
/**
 * 
 * @类描述： 一般缴款信息服务（直接缴款服务和汇缴服务）
 * @项目名称：base_bill_service
 * @包名：base.bill.service
 * @类名称：TDemandNoteService
 * @创建人：wangp
 * @创建时间：2018年8月13日
 */
public interface TDemandNoteService {
	
	/**
	 * 
	 * @描述:增加(保存) 一般缴款信息 直接缴款信息
	 * @方法名: insertTDemandNote
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	public Results<Object> insertTDemandNote(TDemandNote tDemandNote);

	
	/**
	 * 
	 * @描述:打印一般缴款信息 直接缴款信息 即为修改新增一个票据号码入库
	 * @方法名: PrintTDemandNote
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	public Results<Object> printTDemandNote(TDemandNote tDemandNote);

	
	
	/**
	 * 
	 * @描述: 条件查询获取 一般缴款信息信息
	 * @方法名: getTDemandNoteList
	 * @param financialVO
	 * @param pageVo
	 * @return
	 * @返回类型 Results<ListVO<TDemandNote>>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	public Results<ListVO<TDemandNote>> getTDemandNoteList(TDemandNoteVO tDemandNoteVO, PageVO pageVo);
	
	/**
	 * 
	 * @描述:  查询一般缴款信息
	 * @方法名: getTDemandNoteByCon
	 * @return
	 * @返回类型 List<TFinancial>
	 * @创建人wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws 方法暂停使用
	 */
	//public Results<ListVO<TDemandNote>> getTDemandNoteByCon(TDemandNoteVO tDemandNoteVO, PageVO pageVo);
	
	
	/**
	 * 
	 * @描述: 删除一般缴款信息
	 * @方法名: deleteTDemandNote
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	public Results<Object> deleteTDemandNote(TDemandNote tDemandNote);
	
	/**
	 * 
	 * @描述: 作废一般缴款信息单
	 * @方法名: invalidatedTDemandNote
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	public Results<Object> invalidatedTDemandNote(TDemandNote tDemandNote);
	
	/**
	 * 
	 * @描述: 取消作废一般缴款信息单
	 * @方法名: cancelinvalidatedTDemandNote
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	public Results<Object> cancelinvalidatedTDemandNote(TDemandNote tDemandNote);
	
	/**
	 * 
	 * @描述: 回执一般缴款信息单
	 * @方法名: returnTDemandNote
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月17
	 * @since
	 * @throws
	 */
	public Results<Object> returnTDemandNote(TDemandNote tDemandNote);
	
	/**
	 * 
	 * @描述: 取消回执一般缴款信息单
	 * @方法名: cancereturnTDemandNote
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月17
	 * @since
	 * @throws
	 */
	public Results<Object> cancereturnTDemandNote(TDemandNote tDemandNote);
	
	/**
	 * 
	 * @描述: 通过时间排序 查询最近录入一般缴款信息单
	 * @方法名: cancereturnTDemandNote
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月17
	 * @since
	 * @throws
	 */
	public Results<ListVO<TDemandNote>> getTDemandNotetimeList(TDemandNoteVO tDemandNoteVO, PageVO pageVo);
	
	/***************************调缴款人服务 查询已经录入的缴款人信息***************************************************/
	/**
	 * 
	 * @描述: 调用缴款人服务接口 通过缴款人姓名作为条件查出缴款人主信息
	 * @方法名: getTContinbutorsList
	 * @param bill_name
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	public String getTContinbutorsList(String t_full_contributors_name);
	//调接口新增
	public Results<Object> insertTDemandNotes(TDemandNoteVO tDemandNotevo);
}
