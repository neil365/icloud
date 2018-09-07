package base.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.contents.msg.Results;

import base.bill.service.BillunitinventorymanageService;
import base.bill.util.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@CrossOrigin
@Api(value = "票据管理服务层", description = "票据管理服务层")
@RequestMapping(value = "/billManagement ")
public class BillunitinventorymanageController {
	
	@Autowired
	private	BillunitinventorymanageService  billunitinventorymanageService;
	/**
	 * 
	 * @描述: 调用票据管理服务接口 查询查询单位票据库存信息
	 * @方法名: getBillunitinventorymanageBycon
	 * @param bill_name
	 * @return
	 * @返回类型 Results
	 * @创建人 wangp
	 * @创建时间 2018年8月30日
	 * @since 
	 * @throws
	 */ 
	@ApiOperation(value = "查询单位票据库存信息")
	@Permission(menu = "billManagement ", value = "getBillunitinventorymanageBycon")
	@PostMapping(value = "/getBillunitinventorymanageBycon")
	
	public Results<Object> getBillunitinventorymanageBycon(String bill_name){
		
		return billunitinventorymanageService.getBillunitinventorymanageBycon(bill_name);
	}
}
