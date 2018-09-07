package base.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TDemandNote;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TDemandNoteVO;
import base.bill.service.TDemandNoteService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin
@Api(value = "一般缴款书 直缴", description = "一般缴款书 直缴接口")
@RequestMapping(value = "/tDemandNote")
public class TDemandNoteController {
	
	@Autowired
	private TDemandNoteService tDemandNoteService;
	
	/**
	 * 新增一般缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "保存一般缴款书 直缴")
	@PostMapping(value = "/insertTDemandNote")
	@Permission(menu = "tDemandNote", value = "insertTDemandNote")
	public Results<Object> insertTDemandNote(@RequestBody TDemandNote tDemandNote) {
		
		return tDemandNoteService.insertTDemandNote(tDemandNote);
		
	}
	
	/**
	 * 根据条件查询缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 * 方法暂时停用
	 *//*
	@ApiOperation(value = "根据条件查询缴款书的票据信息")
	@PostMapping(value = "/TDemandNoteList")
	@Permission(menu = "tDemandNote", value = "TDemandNoteList")
	public Results<ListVO<TDemandNote>> TDemandNoteList(@RequestBody TDemandNoteVO tDemandNoteVO) {
		
		return tDemandNoteService.getTDemandNoteList(tDemandNoteVO, tDemandNoteVO.getPageVO());
		
	}
	*/
	/**
	 * 默认查询所有    或者带条件查询  缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "默认查询所有    或者带条件查询缴款书的票据信息")
	@PostMapping(value = "/TDemandNoteLists")
	@Permission(menu = "tDemandNote", value = "TDemandNoteLists")
	public Results<ListVO<TDemandNote>> TDemandNoteLists(@RequestBody TDemandNoteVO tDemandNoteVO) {
		
		return tDemandNoteService.getTDemandNoteList(tDemandNoteVO, tDemandNoteVO.getPageVO());
		
	}
	
	/**
	 * 通过时间查询最近录入一般缴款书的信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "默认查询所有    或者带条件查询缴款书的票据信息")
	@PostMapping(value = "/getTDemandNotetimeList")
	@Permission(menu = "tDemandNote", value = "getTDemandNotetimeList")
	public Results<ListVO<TDemandNote>> getTDemandNotetimeList(@RequestBody TDemandNoteVO tDemandNoteVO) {
		
		return tDemandNoteService.getTDemandNotetimeList(tDemandNoteVO, tDemandNoteVO.getPageVO());
		
	}
	/**
	 * 删除保存的缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "删除票据维护信息======(必填：demand_note_id: 票据id  条件  已打印数据能删除（print_state==1）)")
	@PostMapping(value = "/deleteTDemandNote")
	@Permission(menu = "tDemandNote", value = "deleteTDemandNote")
	public Results<Object> deleteTDemandNote(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteService.deleteTDemandNote(tDemandNote);
	}
	
	
	/**
	 * 作废保存的缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "作废票据维护信息======(必填：demand_note_id: 票据id)  未打印数据且为未交费数据（print_state==1  payment_state==0）")
	@PostMapping(value = "/invalidatedTDemandNote")
	@Permission(menu = "tDemandNote", value = "invalidatedTDemandNote")
	public Results<Object> invalidatedTDemandNote(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteService.invalidatedTDemandNote(tDemandNote);
	}
	/**
	 * 取消作废保存的缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "取消作废票据维护信息======(必填：demand_note_id: 票据id) 票据状态为作废 为1 方可取消作废")
	@PostMapping(value = "/cancelinvalidatedTDemandNote")
	@Permission(menu = "tDemandNote", value = "cancelinvalidatedTDemandNote")
	public Results<Object> cancelinvalidatedTDemandNote(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteService.cancelinvalidatedTDemandNote(tDemandNote);
	}
	
	/**
	 * 回执作废保存的缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "回执票据维护信息======(必填：demand_note_id: 票据id) 票据状态 未打印 未缴费  未作废  为1 方可回执")
	@PostMapping(value = "/returnTDemandNote")
	@Permission(menu = "tDemandNote", value = "returnTDemandNote")
	public Results<Object> returnTDemandNote(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteService.returnTDemandNote(tDemandNote);
	}
	
	/**
	 * 回执作废保存的缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "取消回执票据维护信息======(必填：demand_note_id: 票据id) 票据状态 已回执")
	@PostMapping(value = "/cancereturnTDemandNote")
	@Permission(menu = "tDemandNote", value = "cancereturnTDemandNote")
	public Results<Object> cancereturnTDemandNote(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteService.cancereturnTDemandNote(tDemandNote);
	}
	
	/**
	 * 打印缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "打印缴款书的票据信息======(必填：bill_no: 票据号码 必须唯一  ,打印后 打印成功后状态变成1  为已打印)")
	@PostMapping(value = "/printTDemandNote")
	@Permission(menu = "tDemandNote", value = "printTDemandNote")
	public Results<Object> printTDemandNote(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteService.printTDemandNote(tDemandNote);
	}
	
	/******************************************************************************************/
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
	@ApiOperation(value = "通过缴款人姓名作为条件查出缴款人主信息")
	@Permission(menu = "tDemandNote ", value = "getTContinbutorsList")
	@PostMapping(value = "/getTContinbutorsList")
	
	public String getTContinbutorsList(String t_full_contributors_name){
		
		return tDemandNoteService.getTContinbutorsList(t_full_contributors_name);
	}
	
	/**
	 * 
	 * @描述: 调用缴款人服务接口缴款人姓名 账号  开户银行 录入缴款人主信息
	 * @方法名: getTContinbutorsList
	 * @param bill_name
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	@ApiOperation(value = "调用缴款人服务接口缴款人姓名 账号  开户银行 录入缴款人主信息")
	@Permission(menu = "tDemandNote ", value = "insertTDemandNotes")
	@PostMapping(value = "/insertTDemandNotes")
	public Results<Object> insertTDemandNotes(@RequestBody TDemandNoteVO tDemandNotevo) {
		
		return tDemandNoteService.insertTDemandNotes(tDemandNotevo);
		
	}
}
