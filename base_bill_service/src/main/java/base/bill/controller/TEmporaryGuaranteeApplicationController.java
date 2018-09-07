package base.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TEmporaryGuaranteeApplication;
import base.bill.entity.vo.TEmporaryGuaranteeApplicationVO;
import base.bill.service.TEmporaryGuaranteeApplicationService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @描述: 暂保押申请信息管理 接口
 * @包名:base.bill.controller
 * @类名: TEmporaryGuaranteeApplicationController
 * @创建人 wangp
 * @创建时间 2018年9月4日
 */
@RestController
@CrossOrigin
@Api(value = "暂保押申请信息管理 （业务接口）", description = "暂保押申请信息管理 （业务接口）")
@RequestMapping(value = "/RefundApplication")
public class TEmporaryGuaranteeApplicationController {
	@Autowired
	private TEmporaryGuaranteeApplicationService tEmporaryGuaranteeApplicationService;
  
	/**
	 * 新增  暂保押申请信息
	 * @param tEmporaryGuaranteeApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "保存 退付申请管理信息")
	@PostMapping(value = "/insertTEmporaryGuaranteeApplication")
	@Permission(menu = "TEmporaryGuaranteeApplication", value = "insertTEmporaryGuaranteeApplication")
	public Results<Object> insertTEmporaryGuaranteeApplication(@RequestBody TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		
		return tEmporaryGuaranteeApplicationService.insertTEmporaryGuaranteeApplication(tEmporaryGuaranteeApplication);
		
	}
	
	/**
	 * 删除 暂保押申请信息
	 * @param tEmporaryGuaranteeApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "删除 退付申请管理信息")
	@PostMapping(value = "/deleteTEmporaryGuaranteeApplication")
	@Permission(menu = "TEmporaryGuaranteeApplication", value = "deleteTEmporaryGuaranteeApplication")
	public Results<Object> deleteTEmporaryGuaranteeApplication(@RequestBody TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		
		return tEmporaryGuaranteeApplicationService.deleteTEmporaryGuaranteeApplication(tEmporaryGuaranteeApplication);
		
	}
	
	/**
	 * 修改  暂保押申请信息
	 * @param tEmporaryGuaranteeApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "修改 退付申请管理信息")
	@PostMapping(value = "/updateTEmporaryGuaranteeApplication")
	@Permission(menu = "TEmporaryGuaranteeApplication", value = "updateTEmporaryGuaranteeApplication")
	public Results<Object> updateTEmporaryGuaranteeApplication(@RequestBody TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		
		return tEmporaryGuaranteeApplicationService.updateTEmporaryGuaranteeApplication(tEmporaryGuaranteeApplication);
		
	}
	
	/**
	 * 新增  暂保押申请信息
	 * @param tEmporaryGuaranteeApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "保存 退付申请管理信息")
	@PostMapping(value = "/reportTEmporaryGuaranteeApplication")
	@Permission(menu = "TEmporaryGuaranteeApplication", value = "reportTEmporaryGuaranteeApplication")
	public Results<Object> reportTEmporaryGuaranteeApplication(@RequestBody TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		
		return tEmporaryGuaranteeApplicationService.reportTEmporaryGuaranteeApplication(tEmporaryGuaranteeApplication);
		
	}
	
	/**
	 * 新增  暂保押申请信息
	 * @param tEmporaryGuaranteeApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "保存 退付申请管理信息")
	@PostMapping(value = "/cancereportTEmporaryGuaranteeApplication")
	@Permission(menu = "TEmporaryGuaranteeApplication", value = "cancereportTEmporaryGuaranteeApplication")
	public Results<Object> cancereportTEmporaryGuaranteeApplication(@RequestBody TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		
		return tEmporaryGuaranteeApplicationService.cancereportTEmporaryGuaranteeApplication(tEmporaryGuaranteeApplication);
		
	}
	
	/**
	 * 新增  暂保押申请信息
	 * @param tEmporaryGuaranteeApplication
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "保存 退付申请管理信息")
	@PostMapping(value = "/getTEmporaryGuaranteeApplicationList")
	@Permission(menu = "TEmporaryGuaranteeApplication", value = "getTEmporaryGuaranteeApplicationList")
	public Results<ListVO<TEmporaryGuaranteeApplication>> getTEmporaryGuaranteeApplicationList(@RequestBody TEmporaryGuaranteeApplicationVO tEmporaryGuaranteeApplicationvo) {
		
		return tEmporaryGuaranteeApplicationService.getTEmporaryGuaranteeApplicationList(tEmporaryGuaranteeApplicationvo,tEmporaryGuaranteeApplicationvo.getPageVO());
		
	}
	
}
