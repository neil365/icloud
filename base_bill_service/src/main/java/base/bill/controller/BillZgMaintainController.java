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
import base.bill.service.BillZgMaintainService;
import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TBillZgMaintain;
import base.bill.entity.vo.BillInfoMaintainVO;
import base.bill.entity.vo.BillZgMaintainVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "票据字轨维护控制层", description = "票据字轨维护信息接口")
@RequestMapping(value = "/billZgMaintain")
public class BillZgMaintainController {

	@Autowired
	private BillZgMaintainService billZgMaintainService;

	@ApiOperation(value = "票据字轨维护信息")
	@PostMapping(value = "/getBillZgMaintainList")
	@Permission(menu = "billZgMaintain", value = "getBillZgMaintainList")
	public Results<ListVO<TBillZgMaintain>> getBillZgMaintainList(@RequestBody BillZgMaintainVO billZgMaintainVO) {

		return billZgMaintainService.getBillZgMaintainList(billZgMaintainVO, billZgMaintainVO.getPageVO());
	}

	@ApiOperation(value = "根据票据字轨维护获取信息")
	@PostMapping(value = "/getBillZgMaintainByCon")
	@Permission(menu = "billZgMaintain", value = "getBillZgMaintainByCon")
	public Results<ListVO<TBillZgMaintain>> getBillZgMaintainByCon(@RequestBody BillZgMaintainVO billZgMaintainVO) {
		return billZgMaintainService.getBillZgMaintainByCon(billZgMaintainVO);
	}

	@ApiOperation(value = "修改票据字轨维护信息")
	@PostMapping(value = "/updateBillZgMaintain")
	@Permission(menu = "billZgMaintain", value = "updateBillZgMaintain")
	public Results<Object> updateBillZgMaintain(@RequestBody TBillZgMaintain tBillZgMaintain) {
		return billZgMaintainService.updateBillZgMaintain(tBillZgMaintain);
	}

	@ApiOperation(value = "增加票据字轨维护信息")
	@PostMapping(value = "/insertBillZgMaintain")
	@Permission(menu = "billZgMaintain", value = "insertBillZgMaintain")
	public Results<Object> insertBillZgMaintain(@RequestBody TBillZgMaintain tBillZgMaintain) {
		return billZgMaintainService.insertBillZgMaintain(tBillZgMaintain);
	}

	@ApiOperation(value = "删除票据字轨维护信息")
	@PostMapping(value = "/deleteBillZgMaintain")
	@Permission(menu = "billZgMaintain", value = "deleteBillZgMaintain")
	public Results<Object> deleteBillZgMaintain(@RequestBody TBillZgMaintain tBillZgMaintain) {
		return billZgMaintainService.deleteBillZgMaintain(tBillZgMaintain);
	}

	@ApiOperation(value = "非税项目信息导出到Excel")
	@GetMapping(value = "/toBillZgMaintainExcel")
	@Permission(menu = "billZgMaintain", value = "toBillZgMaintainExcel")
	public void toBillInfoMaintainExcel(HttpServletResponse response) {
		billZgMaintainService.toBillZgMaintainExcel(response);
	}

}
