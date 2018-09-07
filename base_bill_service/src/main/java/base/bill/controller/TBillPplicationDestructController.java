package base.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillPplicationDestruction;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TBillPplicationDestructionVO;
import base.bill.service.TBillPplicationDestructionService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
* 票据销毁申请（业务口）
* @项目名 base_bill_service
* @包名 base.bill.controller
* @类名 TBillPplicationDestructController
* @创建人 wangp
* @创建时间 2018-08-29
*/
@RestController
@CrossOrigin
@Api(value = "票据销毁申请", description = "票据销毁申请（业务接口）")
@RequestMapping(value = "/TBillPplicationDestruct")
public class TBillPplicationDestructController {
	@Autowired
	private TBillPplicationDestructionService tBillPplicationDestructionService;
	
	/**
	 * 新增 票据销毁申请
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "保存 票据销毁申请")
	@PostMapping(value = "/insertTBillPplicationDestruction")
	@Permission(menu = "TBillPplicationDestruction", value = "insertTBillPplicationDestruction")
	public Results<Object> insertTBillPplicationDestruction(@RequestBody TBillPplicationDestruction tBillPplicationDestruction) {
		
		return tBillPplicationDestructionService.insertTBillPplicationDestruction(tBillPplicationDestruction);
		
	}
	
	/**
	 *查询所有  票据销毁申请
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	/*@ApiOperation(value = "查询所有 票据缴验申请信息")
	@PostMapping(value = "/getTTBillPplicationDestructionBycon")
	@Permission(menu = "TBillPplicationDestruction", value = "getTTBillPplicationDestructionBycon")
	public Results<ListVO> getTTBillPplicationDestructionBycon(@RequestBody TBillPplicationDestructionVO tBillPplicationDestructionvo, PageVO pageVo) {
		
		return tBillPplicationDestructionService.getTTBillPplicationDestructionBycon(tBillPplicationDestructionvo,pageVo);
		
	}*/
	
	/**
	 * 条件查询/查询所有 票据销毁申请
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "条件查询/查询所有 票据缴验申请信息")
	@PostMapping(value = "/getTBillPplicationDestructionList")
	@Permission(menu = "TBillPplicationDestruction", value = "getTBillPplicationDestructionList")
	public Results<ListVO<TBillPplicationDestruction>> getTBillPplicationDestructionList(@RequestBody TBillPplicationDestructionVO tBillPplicationDestructionVO) {
		
		return tBillPplicationDestructionService.getTBillPplicationDestructionList(tBillPplicationDestructionVO,tBillPplicationDestructionVO.getPageVO());
		
	}
	
	/**
	 *修改 票据销毁申请
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "修改  票据销毁申请")
	@PostMapping(value = "/updateTBillPplicationDestruction")
	@Permission(menu = "TBillPplicationDestruction", value = "updateTBillPplicationDestruction")
	public Results<Object> updateTBillPplicationDestruction(@RequestBody TBillPplicationDestruction tBillPplicationDestruction) {
		
		return tBillPplicationDestructionService.updateTBillPplicationDestruction(tBillPplicationDestruction);
		
	}
	
	/**
	 * 删除 票据销毁申请
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "删除 票据销毁申请")
	@PostMapping(value = "/deleteTBillPplicationDestruction")
	@Permission(menu = "TBillPplicationDestruction", value = "deleteTBillPplicationDestruction")
	public Results<Object> deleteTBillPplicationDestruction(@RequestBody TBillPplicationDestruction tBillPplicationDestruction) {
		
		return tBillPplicationDestructionService.deleteTBillPplicationDestruction(tBillPplicationDestruction);
		
	}
	
	/**
	 * 上报 票据销毁申请
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "上报 票据销毁申请")
	@PostMapping(value = "/reportTBillPplicationDestruction")
	@Permission(menu = "TBillPplicationDestruction", value = "reportTBillPplicationDestruction")
	public Results<Object> reportTBillPplicationDestruction(@RequestBody TBillPplicationDestruction tBillPplicationDestruction) {
		
		return tBillPplicationDestructionService.reportTBillPplicationDestruction(tBillPplicationDestruction);
		
	}
	
	/**
	 * 取消上报 票据销毁申请
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "取消上报 票据销毁申请")
	@PostMapping(value = "/cancereportTBillPplicationDestruction")
	@Permission(menu = "TBillPplicationDestruction", value = "cancereportTBillPplicationDestruction")
	public Results<Object> cancereportTBillPplicationDestruction(@RequestBody TBillPplicationDestruction tBillPplicationDestruction) {
		
		return tBillPplicationDestructionService.cancereportTBillPplicationDestruction(tBillPplicationDestruction);
		
	}
	
	/***********************************票据销毁申请 明细*************************************************/
	
}
