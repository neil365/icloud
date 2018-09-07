package base.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.RefundApplication;
import base.bill.entity.vo.RefundApplicationVO;
import base.bill.service.RefundApplicationService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @描述: 退付申请管理 接口
 * @包名:base.bill.controller
 * @类名: RefundApplicationController
 * @创建人 wangp
 * @创建时间 2018年9月4日
 */
@RestController
@CrossOrigin
@Api(value = "退付申请管理 （业务接口）", description = "退付申请管理 （业务接口）")
@RequestMapping(value = "/RefundApplication")
public class RefundApplicationController {
	
	@Autowired
	private RefundApplicationService refundApplicationService;
	/**
	 * 新增  退付申请管理信息
	 * @param refundApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "保存 退付申请管理信息")
	@PostMapping(value = "/insertRefundApplication")
	@Permission(menu = "RefundApplication", value = "insertRefundApplication")
	public Results<Object> insertRefundApplication(@RequestBody RefundApplication refundApplication) {
		
		return refundApplicationService.insertRefundApplication(refundApplication);
		
	}
	
	/**
	 * 查询所有/根据条件查询  退付申请管理信息
	 * @param refundApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "查询所有/根据条件查询 退付申请管理信息")
	@PostMapping(value = "/getRefundApplicationList")
	@Permission(menu = "RefundApplication", value = "getRefundApplicationList")
	public Results<ListVO<RefundApplication>> getRefundApplicationList(@RequestBody RefundApplicationVO refundApplicationvo) {
		
		return refundApplicationService.getRefundApplicationList(refundApplicationvo,refundApplicationvo.getPageVO());
		
	}
	
	/**
	 * 删除  退付申请管理信息
	 * @param refundApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "删除退付申请管理信息")
	@PostMapping(value = "/deleteRefundApplication")
	@Permission(menu = "RefundApplication", value = "deleteRefundApplication")
	public Results<Object> deleteRefundApplication(@RequestBody RefundApplication refundApplication) {
		
		return refundApplicationService.deleteRefundApplication(refundApplication);
		
	}
	
	/**
	 * 修改  退付申请管理信息
	 * @param refundApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "修改 退付申请管理信息")
	@PostMapping(value = "/updateRefundApplication")
	@Permission(menu = "RefundApplication", value = "updateRefundApplication")
	public Results<Object> updateRefundApplication(@RequestBody RefundApplication refundApplication) {
		
		return refundApplicationService.updateRefundApplication(refundApplication);
		
	}
	
	/**
	 * 上报  退付申请管理信息
	 * @param refundApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "上报 退付申请管理信息")
	@PostMapping(value = "/reportRefundApplication")
	@Permission(menu = "RefundApplication", value = "reportRefundApplication")
	public Results<Object> reportRefundApplication(@RequestBody RefundApplication refundApplication) {
		
		return refundApplicationService.reportRefundApplication(refundApplication);
		
	}
	
	/**
	 * 取消上报  退付申请管理信息
	 * @param refundApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "取消上报 退付申请管理信息")
	@PostMapping(value = "/cancereportRefundApplication")
	@Permission(menu = "RefundApplication", value = "cancereportRefundApplication")
	public Results<Object> cancereportRefundApplication(@RequestBody RefundApplication refundApplication) {
		
		return refundApplicationService.cancereportRefundApplication(refundApplication);
		
	}
	
}
