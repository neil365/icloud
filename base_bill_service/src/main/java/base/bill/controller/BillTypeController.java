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
import base.bill.service.BillTypeService;
import base.bill.entity.TBillType;
import base.bill.entity.vo.BillTypeVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "票据种类维护控制层", description = "票据种类维护接口")
@RequestMapping(value = "/billType")
public class BillTypeController {

	@Autowired
	private BillTypeService billTypeService;
	
	/**
	 * 
	 * @描述: 获取票据种类维护信息
	 * @方法名: getBillTypeList
	 * @param billTypeVO
	 * @return
	 * @返回类型 Results<ListVO<TBillType>>
	 * @创建人 吴镇锡
	 * @创建时间 2018年5月25日下午5:41:44
	 * @修改人 吴镇锡
	 * @修改时间 2018年5月25日下午5:41:44
	 * @修改备注
	 * @since
	 * @throws
	 */
	@ApiOperation(value = "获取票据种类维护信息")
	@PostMapping(value = "/getBillTypeList")
	@Permission(menu = "billType", value = "getBillTypeList")
	public Results<ListVO<TBillType>> getBillTypeList(@RequestBody BillTypeVO billTypeVO) {

		return billTypeService.getBillTypeList(billTypeVO, billTypeVO.getPageVO());

	}
	
	/**
	 * 
	 * @描述: 根据票据种类维护条件获取信息
	 * @方法名: getBillTypeByCon
	 * @param billTypeVO
	 * @return
	 * @返回类型 Results<ListVO<TBillType>>
	 * @创建人 吴镇锡
	 * @创建时间 2018年5月25日下午5:41:52
	 * @修改人 吴镇锡
	 * @修改时间 2018年5月25日下午5:41:52
	 * @修改备注
	 * @since
	 * @throws
	 */
	@ApiOperation(value = "根据票据种类维护条件获取信息")
	@PostMapping(value = "/getBillTypeByCon")
	@Permission(menu = "billType", value = "getBillTypeByCon")

	public Results<ListVO<TBillType>> getBillTypeByCon(@RequestBody BillTypeVO billTypeVO) {
		return billTypeService.getBillTypeByCon(billTypeVO);

	}
	
	/**
	 * 
	 * @描述: 修改票据种类维护信息
	 * @方法名: updateBillType
	 * @param tBillType
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 吴镇锡
	 * @创建时间 2018年5月25日下午5:42:01
	 * @修改人 吴镇锡
	 * @修改时间 2018年5月25日下午5:42:01
	 * @修改备注
	 * @since
	 * @throws
	 */
	@ApiOperation(value = "修改票据种类维护信息")
	@PostMapping(value = "/updateBillType")
	@Permission(menu = "billType", value = "updateBillType")
	public Results<Object> updateBillType(@RequestBody TBillType tBillType) {
		return billTypeService.updateBillType(tBillType);
	}
	
	/**
	 * 
	 * @描述: 增加票据种类维护信息
	 * @方法名: insertBillType
	 * @param tBillType
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 吴镇锡
	 * @创建时间 2018年5月25日下午5:42:10
	 * @修改人 吴镇锡
	 * @修改时间 2018年5月25日下午5:42:10
	 * @修改备注
	 * @since
	 * @throws
	 */
	@ApiOperation(value = "增加票据种类维护信息")
	@PostMapping(value = "/insertBillType")
	@Permission(menu = "billType", value = "insertBillType")
	public Results<Object> insertBillType(@RequestBody TBillType tBillType) {
		return billTypeService.insertBillType(tBillType);
	}
	
	/**
	 * 
	 * @描述: 删除票据种类维护信息
	 * @方法名: deleteBillType
	 * @param tBillType
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 吴镇锡
	 * @创建时间 2018年5月25日下午5:42:19
	 * @修改人 吴镇锡
	 * @修改时间 2018年5月25日下午5:42:19
	 * @修改备注
	 * @since
	 * @throws
	 */
	@ApiOperation(value = "删除票据种类维护信息")
	@PostMapping(value = "/deleteBillType")
	 @Permission(menu = "billType", value = "deleteBillType")
	public Results<Object> deleteBillType(@RequestBody TBillType tBillType) {
		return billTypeService.deleteBillType(tBillType);
	}
	
	/**
	 * 
	 * @描述: 票据种类维护信息导出到Excel
	 * @方法名: toUnitCompetentDepartmentExcel
	 * @param response
	 * @返回类型 void
	 * @创建人 吴镇锡
	 * @创建时间 2018年5月10日下午2:40:44
	 * @修改人 吴镇锡
	 * @修改时间 2018年5月10日下午2:40:44
	 * @修改备注
	 * @since
	 * @throws
	 */
	@ApiOperation(value = "票据种类维护信息导出到Excel")
	@GetMapping(value = "/toBillTypeExcel")
	@Permission(menu = "billType", value = "toBillTypeExcel")
	public void toBillTypeExcel(HttpServletResponse response) {
		billTypeService.toBillTypeExcel(response);
	}
	
 
}
