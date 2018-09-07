package base.bill.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import base.bill.util.Permission;
import base.bill.service.BillInfoMaintainService;
import base.bill.service.BudgetKindMoneyService;
import base.bill.service.ImposingUnitService;
import base.bill.service.NotaxProjectService;
import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TBillType;
import base.bill.entity.TImposingUnit;
import base.bill.entity.TNotaxProject;
import base.bill.entity.vo.BillInfoMaintainVO;
import base.bill.entity.vo.ImposingUnitVO;
import base.bill.entity.vo.NotaxProjectVO;
import base.bill.entity.vo.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "票据维护信息控制层", description = "票据维护信息接口")
@RequestMapping(value = "/billInfoMaintain")
public class BillInfoMaintainController {

	@Autowired
	private BillInfoMaintainService billInfoMaintainService;

	@ApiOperation(value = "票据票据维护信息")
	@PostMapping(value = "/getBillInfoMaintainList")
	@Permission(menu = "billInfoMaintain", value = "getBillInfoMaintainList")
	public Results<ListVO<TBillInfoMaintain>> getBillInfoMaintainList(
			@RequestBody BillInfoMaintainVO billInfoMaintainVO) {

		return billInfoMaintainService.getBillInfoMaintainList(billInfoMaintainVO, billInfoMaintainVO.getPageVO());
	}

	@ApiOperation(value = "根据票据维护获取信息")
	@PostMapping(value = "/getBillInfoMaintainByCon")
	@Permission(menu = "billInfoMaintain", value = "getBillInfoMaintainByCon")
	public Results<ListVO<TBillInfoMaintain>> getBillInfoMaintainByCon(
			@RequestBody BillInfoMaintainVO billInfoMaintainVO) {
		return billInfoMaintainService.getBillInfoMaintainByCon(billInfoMaintainVO);
	}

	@ApiOperation(value = "修改票据维护信息")
	@PostMapping(value = "/updateBillInfoMaintain")
	@Permission(menu = "billInfoMaintain", value = "updateBillInfoMaintain")
	public Results<Object> updateBillInfoMaintain(@RequestBody TBillInfoMaintain tBillInfoMaintain) {
		return billInfoMaintainService.updateBillInfoMaintain(tBillInfoMaintain);
	}

	@ApiOperation(value = "增加票据维护信息")
	@PostMapping(value = "/insertBillInfoMaintain")
	@Permission(menu = "billInfoMaintain", value = "insertBillInfoMaintain")
	public Results<Object> insertBillInfoMaintain(@RequestBody TBillInfoMaintain tBillInfoMaintain) {
		return billInfoMaintainService.insertBillInfoMaintain(tBillInfoMaintain);
	}

	@ApiOperation(value = "删除票据维护信息======(必填：bill_info_maintain_id: 票据id)")
	@PostMapping(value = "/deleteBillInfoMaintain")
	@Permission(menu = "billInfoMaintain", value = "deleteBillInfoMaintain")
	public Results<Object> deleteBillInfoMaintain(@RequestBody TBillInfoMaintain tBillInfoMaintain) {
		return billInfoMaintainService.deleteBillInfoMaintain(tBillInfoMaintain);
	}

	@ApiOperation(value = "非税项目信息导出到Excel")
	@GetMapping(value = "/toBillInfoMaintainExcel")
	@Permission(menu = "billInfoMaintain", value = "toBillInfoMaintainExcel")
	public void toBillInfoMaintainExcel(HttpServletResponse response) {
		billInfoMaintainService.toBillInfoMaintainExcel(response);
	}

	@ApiOperation(value = "票种票据信息树形结构")
	@PostMapping(value = "/getBillTypeTree")
	@Permission(menu = "billInfoMaintain", value = "getBillTypeTree")
	public Results<ListVO<TBillType>> getBillTypeTree(@RequestBody BillInfoMaintainVO billInfoMaintainVO) {
		return billInfoMaintainService.getBillTypeTree(billInfoMaintainVO);
	}
}
