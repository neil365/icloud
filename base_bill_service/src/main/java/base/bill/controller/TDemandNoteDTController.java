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
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TDemandNoteVO;
import base.bill.service.TDemandNoteDTService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "一般缴款书（大厅模式）也为 委托业务", description = "一般缴款书 （大厅模式）也为 委托业务 接口")
@RequestMapping(value = "/tDemandNotes")
public class TDemandNoteDTController {
	@Autowired
	private TDemandNoteDTService tDemandNoteServiceDT;
	
	/**
	 * 新增一般缴款书的票据信息（大厅模式）也为 委托业务
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 */
	@ApiOperation(value = "保存一般缴款书（大厅模式）也为 委托业务")
	@PostMapping(value = "/insertTDemandNoteDT")
	@Permission(menu = "tDemandNote", value = "insertTDemandNoteDT")
	public Results<Object> insertTDemandNoteDT(@RequestBody TDemandNote tDemandNote) {
		
		return tDemandNoteServiceDT.insertTDemandNoteDT(tDemandNote);
		
	}
	
	/**
	 * 默认查询所有 根据条件查询缴款书的票据信息（大厅模式）也为 委托业务
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 */
	@ApiOperation(value = "根据条件查询缴款书的票据信息（大厅模式）也为 委托业务")
	@PostMapping(value = "/TDemandNoteListDT")
	@Permission(menu = "tDemandNote", value = "TDemandNoteListDT")
	public Results<ListVO<TDemandNote>> TDemandNoteListDT(@RequestBody TDemandNoteVO tDemandNoteVO) {
		
		return tDemandNoteServiceDT.getTDemandNoteListDT(tDemandNoteVO, tDemandNoteVO.getPageVO());
		
	}
	
	/**
	 * 默认查询所有缴款书的票据信息（大厅模式）也为 委托业务
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 *//*
	@ApiOperation(value = "默认查询缴款书的票据信息（大厅模式）也为 委托业务")
	@PostMapping(value = "/TDemandNoteListsDT")
	@Permission(menu = "tDemandNote", value = "TDemandNoteListsDT")
	public Results<ListVO> TDemandNoteListsDT(@RequestBody TDemandNote tDemandNote  , PageVO pageVo) {
		
		return tDemandNoteServiceDT.getTDemandNoteByConDT(tDemandNote,pageVo);
		
	}*/
	/**
	 * 删除保存的缴款书的票据信息（大厅模式）
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 */
	@ApiOperation(value = "删除票据维护信息（大厅模式）======(必填：demand_note_id: 票据id  条件  已打印数据能删除（print_state==1）)")
	@PostMapping(value = "/deleteTDemandNoteDT")
	@Permission(menu = "tDemandNote", value = "deleteTDemandNoteDT")
	public Results<Object> deleteTDemandNoteDT(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteServiceDT.deleteTDemandNoteDT(tDemandNote);
	}
	
	
	/**
	 * 作废保存的缴款书的票据信息（大厅模式）
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 */
	@ApiOperation(value = "作废票据维护信息（大厅模式）======(必填：demand_note_id: 票据id)  未打印数据且为未交费数据（print_state==1  payment_state==0）")
	@PostMapping(value = "/invalidatedTDemandNoteDT")
	@Permission(menu = "tDemandNote", value = "invalidatedTDemandNoteDT")
	public Results<Object> invalidatedTDemandNoteDT(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteServiceDT.invalidatedTDemandNoteDT(tDemandNote);
	}
	/**
	 * 取消作废保存的缴款书的票据信息（大厅模式）也为 委托业务
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 */
	@ApiOperation(value = "取消作废票据维护信息（大厅模式）也为 委托业务======(必填：demand_note_id: 票据id) 票据状态为作废 为1 方可取消作废")
	@PostMapping(value = "/cancelinvalidatedTDemandNoteDT")
	@Permission(menu = "tDemandNote", value = "cancelinvalidatedTDemandNoteDT")
	public Results<Object> cancelinvalidatedTDemandNoteDT(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteServiceDT.cancelinvalidatedTDemandNoteDT(tDemandNote);
	}
	
	/**
	 * 回执作废保存的缴款书的票据信息（大厅模式）也为 委托业务
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 */
	@ApiOperation(value = "回执票据维护信息（大厅模式）也为 委托业务======(必填：demand_note_id: 票据id) 票据状态 未打印 未缴费  未作废  为1 方可回执")
	@PostMapping(value = "/returnTDemandNoteDT")
	@Permission(menu = "tDemandNote", value = "returnTDemandNoteDT")
	public Results<Object> returnTDemandNote(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteServiceDT.returnTDemandNoteDT(tDemandNote);
	}
	
	/**
	 * 回执作废保存的缴款书的票据信息（大厅模式）也为 委托业务
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 */
	@ApiOperation(value = "取消回执票据维护信息（大厅模式）也为 委托业务======(必填：demand_note_id: 票据id) 票据状态 已回执")
	@PostMapping(value = "/cancereturnTDemandNoteDT")
	@Permission(menu = "tDemandNote", value = "cancereturnTDemandNote")
	public Results<Object> cancereturnTDemandNote(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteServiceDT.cancereturnTDemandNoteDT(tDemandNote);
	}
	
	/**
	 * 打印缴款书的票据信息（大厅模式）也为 委托业务
	 * @param tDemandNoteDT
	 * @创建人：wangp
	 * @创建时间：2018年8月17日
	 */
	@ApiOperation(value = "打印缴款书的票据信息（大厅模式）也为 委托业务======(必填：bill_no: 票据号码 必须唯一  ,打印后 打印成功后状态变成1  为已打印)")
	@PostMapping(value = "/printTDemandNote")
	@Permission(menu = "tDemandNote", value = "printTDemandNote")
	public Results<Object> printTDemandNoteDT(@RequestBody TDemandNote tDemandNote) {
		return tDemandNoteServiceDT.printTDemandNoteDT(tDemandNote);
	}
}

