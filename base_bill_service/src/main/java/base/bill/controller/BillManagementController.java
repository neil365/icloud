package base.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillManagement;
import base.bill.entity.TBillManagementMingxi;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TBillManagementVO;
import base.bill.service.BillManagementService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 票据领购申请（业务口）
 * @项目名 base_bill_service
 * @包名 base.bill.controller
 * @类名 BillManagementsController
 * @创建人 wangp
 * @创建时间 2018-08-27
 */
@RestController
@CrossOrigin
@Api(value = "票据领购申请", description = "票据领购申请（业务接口）")
@RequestMapping(value = "/BillManagement")
public class BillManagementController {
	
	@Autowired
	private BillManagementService billManagementService;
	
	/**
	 * 新增 票据领购申请信息
	 * @param BillManagement
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "保存 票据领购申请信息")
	@PostMapping(value = "/insertBillManagement")
	@Permission(menu = "BillManagement", value = "insertBillManagement")
	public Results<Object> insertBillManagement(@RequestBody TBillManagement tBillManagement) {
		
		return billManagementService.insertBillManagement(tBillManagement);
		
	}
	
	/**
	 * 条件查询 票据领购申请信息
	 * @param BillManagement
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	/*@ApiOperation(value = "条件查询 票据领购申请信息")
	@PostMapping(value = "/getBillManagementByCon")
	@Permission(menu = "BillManagement", value = "getBillManagementByCon")
	public Results<ListVO> getBillManagementByCon(@RequestBody TBillManagementVO billManagementvo , PageVO pageVo) {
		
		return billManagementService.getBillManagementByCon(billManagementvo,pageVo);
		
	}*/
	
	/**
	 * 查询所有/条件查询 票据领购申请信息
	 * @param BillManagement
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "查询所有/条件查询 票据领购申请信息")
	@PostMapping(value = "/getBillManagementList")
	@Permission(menu = "BillManagement", value = "getBillManagementList")
	public Results<ListVO<TBillManagement>> getBillManagementList(@RequestBody TBillManagementVO billManagementvo) {
		
		return billManagementService.getBillManagementList(billManagementvo,billManagementvo.getPageVO());
		
	}
	
	/**
	 * 删除 票据领购申请信息
	 * @param BillManagement
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "删除 票据领购申请信息")
	@PostMapping(value = "/deleteBillManagement")
	@Permission(menu = "BillManagement", value = "deleteBillManagement")
	public Results<Object> deleteBillManagement(@RequestBody TBillManagement billManagement) {
		
		return billManagementService.deleteBillManagement(billManagement);
		
	}
	
	
	/**
	 * 上报 票据领购申请信息
	 * @param BillManagement
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "上报 票据领购申请信息")
	@PostMapping(value = "/reportBillManagement")
	@Permission(menu = "BillManagement", value = "reportBillManagement")
	public Results<Object> reportBillManagement(@RequestBody TBillManagement billManagement) {
		
		return billManagementService.reportBillManagement(billManagement);
		
	}
	
	
	/**
	 * 取消上报 票据领购申请信息
	 * @param BillManagement
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "取消上报 票据领购申请信息")
	@PostMapping(value = "/cancereportBillManagement")
	@Permission(menu = "BillManagement", value = "cancereportBillManagement")
	public Results<Object> cancereportBillManagement(@RequestBody TBillManagement billManagement) {
		
		return billManagementService.cancereportBillManagement(billManagement);
		
	}
	
	/***********************************票据领购申请 明细*************************************************/
	
	/**
	 * 新增 票据领购申请 明细信息
	 * @param tDemandNote
	 * @创建人：wangp
	 * @创建时间：2018年8月13日
	 */
	@ApiOperation(value = "保存 票据领购申请 明细信息")
	@PostMapping(value = "/insertBillManagementmingxi")
	@Permission(menu = "BillManagement", value = "insertBillManagementmingxi")
	public Results<Object> insertBillManagementmingxi(@RequestBody TBillManagementMingxi tBillManagementMingxi) {
		
		return billManagementService.insertBillManagementmingxi(tBillManagementMingxi);
		
	}
	
}
