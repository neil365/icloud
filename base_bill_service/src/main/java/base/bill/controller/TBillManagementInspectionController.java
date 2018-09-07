package base.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillManagementInspection;
import base.bill.entity.TBillManagementInspectionMingxi;
import base.bill.entity.vo.TBillManagementInspectionVO;
import base.bill.service.TBillManagementInspectionService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 票据缴验申请（业务口）
 * @项目名 base_bill_service
 * @包名 base.bill.controller
 * @类名 TBillManagementInspectionController
 * @创建人 wangp
 * @创建时间 2018-08-28
 */

@RestController
@CrossOrigin
@Api(value = "票据缴验申请", description = "票据缴验申请（业务接口）")
@RequestMapping(value = "/TBillManagementInspection")
public class TBillManagementInspectionController {
	@Autowired
	private TBillManagementInspectionService tbillManagementInspectionService;
	/**
	 * 新增 票据缴验申请信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "保存 票据缴验申请信息")
	@PostMapping(value = "/insertTBillManagementInspection")
	@Permission(menu = "TBillManagementInspection", value = "insertTBillManagementInspection")
	public Results<Object> insertTBillManagementInspection(@RequestBody TBillManagementInspection tBillManagementInspection) {
		
		return tbillManagementInspectionService.insertTBillManagementInspection(tBillManagementInspection);
		
	}
	
	/**
	 * 修改 票据缴验申请信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "修改 票据缴验申请信息")
	@PostMapping(value = "/updateTBillManagementInspection")
	@Permission(menu = "TBillManagementInspection", value = "updateTBillManagementInspection")
	public Results<Object> updateTBillManagementInspection(@RequestBody TBillManagementInspection tBillManagementInspection) {
		
		return tbillManagementInspectionService.updateTBillManagementInspection(tBillManagementInspection);
		
	}
	
	/**
	 * 根据条件查询 票据缴验申请信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	/*@ApiOperation(value = "根据条件查询 票据缴验申请信息")
	@PostMapping(value = "/getTBillManagementInspectionByCon")
	@Permission(menu = "TBillManagementInspection", value = "getTBillManagementInspectionByCon")
	public Results<ListVO> getTBillManagementInspectionByCon(@RequestBody TBillManagementInspectionVO tBillManagementInspectionvo,PageVO pageVo) {
		
		return tbillManagementInspectionService.getTBillManagementInspectionByCon(tBillManagementInspectionvo,pageVo);
		
	}*/
	
	/**
	 * 查询所有/根据条件查询 票据缴验申请信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "查询所有/根据条件查询 票据缴验申请信息")
	@PostMapping(value = "/getTBillManagementInspectionList")
	@Permission(menu = "TBillManagementInspection", value = "getTBillManagementInspectionList")
	public Results<ListVO<TBillManagementInspection>> getTBillManagementInspectionList(@RequestBody TBillManagementInspectionVO tBillManagementInspectionvo) {
		
		return tbillManagementInspectionService.getTBillManagementInspectionList(tBillManagementInspectionvo,tBillManagementInspectionvo.getPageVO());
		
	}
	
	/**
	 * 删除 票据缴验申请信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "删除 票据缴验申请信息")
	@PostMapping(value = "/deleteTBillManagementInspection")
	@Permission(menu = "TBillManagementInspection", value = "deleteTBillManagementInspection")
	public Results<Object> deleteTBillManagementInspection(@RequestBody TBillManagementInspection tBillManagementInspection) {
		
		return tbillManagementInspectionService.deleteTBillManagementInspection(tBillManagementInspection);
		
	}
	
	/**
	 * 上报 票据缴验申请信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "上报 票据缴验申请信息")
	@PostMapping(value = "/reportTBillManagementInspection")
	@Permission(menu = "TBillManagementInspection", value = "reportTBillManagementInspection")
	public Results<Object> reportTBillManagementInspection(@RequestBody TBillManagementInspection tBillManagementInspection) {
		
		return tbillManagementInspectionService.reportTBillManagementInspection(tBillManagementInspection);
		
	}
	
	/**
	 * 根据条件查询 票据缴验申请信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "取消上报 票据缴验申请信息")
	@PostMapping(value = "/cancereportTBillManagementInspection")
	@Permission(menu = "TBillManagementInspection", value = "cancereportTBillManagementInspection")
	public Results<Object> cancereportTBillManagementInspection(@RequestBody TBillManagementInspection tBillManagementInspection) {
		
		return tbillManagementInspectionService.cancereportTBillManagementInspection(tBillManagementInspection);
		
	}
	
	/***********************************票据缴验申请 明细*************************************************/
	
	/**
	 * 新增 票据缴验手动缴验  明细信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "新增 票据缴验手动缴验  明细信息")
	@PostMapping(value = "/insertTBillManagementInspectionmingxi")
	@Permission(menu = "TBillManagementInspection", value = "insertTBillManagementInspectionmingxi")
	public Results<Object> insertTBillManagementInspectionmingxi(@RequestBody TBillManagementInspectionMingxi tTBillManagementInspectionMingxi) {
		
		return tbillManagementInspectionService.insertTBillManagementInspectionmingxi(tTBillManagementInspectionMingxi);
		
	}
	
	/**
	 * 新增 手动非正常票据缴验 明细信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	
	/**
	 * 修改 票据缴验申请 明细信息
	 * @param tBillManagementInspection
	 * @创建人：wangp
	 * @创建时间：2018年8月28日
	 */
	@ApiOperation(value = "修改 票据缴验申请 明细信息")
	@PostMapping(value = "/updateTBillManagementInspectionmingxi")
	@Permission(menu = "TBillManagementInspection", value = "updateTBillManagementInspectionmingxi")
	public Results<Object> updateTBillManagementInspectionmingxi(@RequestBody TBillManagementInspectionMingxi tTBillManagementInspectionMingxi) {
		
		return tbillManagementInspectionService.updateTBillManagementInspectionmingxi(tTBillManagementInspectionMingxi);
		
	}
	
}

