package base.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TDemandNote;
import base.bill.entity.TDemandNoteHz;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TDemandNoteHzVO;
import base.bill.entity.vo.TDemandNoteVO;
import base.bill.service.TDemandNoteFocusService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "一般缴款书 汇缴", description = "一般缴款书 汇缴接口")
@RequestMapping(value = "/tDemandNote")
public class TDemandNoteFocusController {
	@Autowired
	private TDemandNoteFocusService tDemandNoteFocusService;
	
	/**
	 * 新增一般缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "保存一般缴款书  汇缴")
	@PostMapping(value = "/insertTDemandNoteFocus")
	@Permission(menu = "tDemandNote", value = "insertTDemandNoteFocus")
	public Results<Object> insertTDemandNoteFocus(@RequestBody TDemandNote tDemandNote) {
		
		return tDemandNoteFocusService.insertTDemandNoteFocus(tDemandNote);
		
	}
	
	/**
	 * 汇总一般缴款书的票据信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "汇总一般缴款书  汇缴 新增一条汇总数据同时修改汇总状态")
	@PostMapping(value = "/insertTDemandNoteHzFocus")
	@Permission(menu = "tDemandNote", value = "insertTDemandNoteHzFocus")
	public Results<Object> insertTDemandNoteHzFocus(@RequestBody TDemandNoteHzVO tDemandNotevo) {
		
		return tDemandNoteFocusService.insertTDemandNoteHzFocus(tDemandNotevo);
		
	}

	/**
	 * 默认查询  根据条件查询缴款书的票据信息  汇缴
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "默认查询 根据条件查询缴款书的票据信息  汇缴")
	@PostMapping(value = "/TDemandNoteFocusList")
	@Permission(menu = "tDemandNote", value = "TDemandNoteFocusList")
	public Results<ListVO<TDemandNote>> TDemandNoteFocusList(@RequestBody TDemandNoteVO tDemandNoteVO) {
		
		return tDemandNoteFocusService.getTDemandNoteFocusList(tDemandNoteVO, tDemandNoteVO.getPageVO());
		
	}
	
	/**
	 * 默认查询所有缴款书的票据信息 汇缴
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
/*	@ApiOperation(value = "默认查询缴款书的票据信息 汇缴")
	@PostMapping(value = "/TDemandNoteFocusLists")
	@Permission(menu = "tDemandNote", value = "TDemandNoteFocusLists")
	public Results TDemandNoteFocusLists(@RequestBody TDemandNote tDemandNote, PageVO pageVo) {
		
		return tDemandNoteFocusService.TDemandNoteFocusLists(tDemandNote,pageVo);
		
	}*/
	/**
	 * 删除保存的缴款书的票据信息 汇缴
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "删除票据维护信息 汇缴======(必填：demand_note_id: 票据id  条件  已打印数据能删除（print_state==1）)")
	@PostMapping(value = "/deleteTDemandNoteFocus")
	@Permission(menu = "tDemandNote", value = "deleteTDemandNoteFocus")
	public Results<Object> deleteTDemandNoteFocus(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteFocusService.deleteTDemandNoteFocus(tDemandNote);
	}
	
	/**
	 * 作废保存的缴款书的票据信息  汇缴
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "作废票据维护信息  汇缴======(必填：demand_note_id: 票据id) 打印状态print_state  缴费状态payment_state 作废状态invalidated_state 编码bill_code ）")
	@PostMapping(value = "/invalidatedTDemandNoteFocus")
	@Permission(menu = "tDemandNote", value = "invalidatedTDemandNoteFocus")
	public Results<Object> invalidatedTDemandNoteFocus(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteFocusService.invalidatedTDemandNoteFocus(tDemandNote);
	}
	
	/**
	 * 取消作废保存的缴款书的票据信息 汇缴
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "取消作废票据维护信息 汇缴======(必填：demand_note_id: 票据id) 票据状态为作废 为1 方可取消作废")
	@PostMapping(value = "/cancelinvalidatedTDemandNoteFocus")
	@Permission(menu = "tDemandNote", value = "cancelinvalidatedTDemandNoteFocus")
	public Results<Object> cancelinvalidatedTDemandNoteFocus(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteFocusService.cancelinvalidatedTDemandNoteFocus(tDemandNote);
	}
	
	/**
	 * 打印缴款书的票据信息 汇缴
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "打印缴款书的票据信息 汇缴======(必填：bill_no: 票据号码 必须唯一  ,打印后 打印成功后状态变成1  为已打印)")
	@PostMapping(value = "/printTDemandNoteFocus")
	@Permission(menu = "tDemandNote", value = "printTDemandNoteFocus")
	public Results<Object> printTDemandNoteFocus(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteFocusService.printTDemandNoteFocus(tDemandNote);
	}
	
	/*************************************汇缴- 汇总表服务的接口调用*********************************************************/
	
	/**
	 * 作废保存的缴款书的票据信息  汇缴 汇总
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月23日
	 */
	@ApiOperation(value = "作废票据维护信息  汇总======(必填：demand_note_id: 票据id) bill_code")
	@PostMapping(value = "/invalidatedTDemandNoteHzFocus")
	@Permission(menu = "tDemandNote", value = "invalidatedTDemandNoteHzFocus")
	public Results<Object> invalidatedTDemandNoteHzFocus(@RequestBody TDemandNoteHz tDemandNotehz) {
		return tDemandNoteFocusService.invalidatedTDemandNoteHzFocus(tDemandNotehz);
	}
	
	/**
	 * 汇总缴款信息表（汇缴服务）删除汇总数据
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月23日
	 */
	@ApiOperation(value = "删除票据维护信息  汇总======(必填：demand_note_id: 票据id) summary_state")
	@PostMapping(value = "/deleteTDemandNoteHzFocus")
	@Permission(menu = "tDemandNote", value = "deleteTDemandNoteHzFocus")
	public Results<Object> deleteTDemandNoteHzFocus(@RequestBody TDemandNoteHz tDemandNotehz) {
		return tDemandNoteFocusService.deleteTDemandNoteHzFocus(tDemandNotehz);
	}
	/**
	 * 汇总缴款信息表（汇缴服务）查看汇总数据中的子表详细信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月23日
	 */
	@ApiOperation(value = "根据汇总主表的Bill_code查询相关子数据  汇缴")
	@PostMapping(value = "/getTDemandNoteHzFocusList")
	@Permission(menu = "tDemandNote", value = "getTDemandNoteHzFocusList")
	public Results getTDemandNoteHzFocusList(@RequestBody TDemandNoteHz tDemandNoteHz, PageVO pageVo) {
		return tDemandNoteFocusService.getTDemandNoteHzFocusList(tDemandNoteHz,pageVo);
	}
	/**
	 * 汇总缴款信息表（汇缴服务）重新打印汇总数据列表信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月23日
	 */
}
