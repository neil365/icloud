package base.bill.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.contents.msg.Contents;
import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;
import base.bill.service.BillTypeService;
import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TBillType;
import base.bill.entity.TBillTypeExample;
import base.bill.entity.TBillTypeExample.Criteria;
import base.bill.entity.vo.BillTypeVO;
import base.bill.entity.vo.PageVO;
import base.bill.mapper.TBillInfoMaintainMapper;
import base.bill.mapper.TBillTypeMapper;
import base.bill.util.StrKit;

/**
 * 
 * @类描述： 票据种类维护服务层实现
 * 
 * @项目名称：base_bill_service
 * @包名： base.bill.service.impl
 * @类名称：BillTypeServiceImpl
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
@SuppressWarnings("unused")
@Service
public class BillTypeServiceImpl implements BillTypeService {

	@Autowired
	private TBillTypeMapper tBillTypeMapper;
	@Autowired
	private TBillInfoMaintainMapper tBillInfoMaintainMapper;

	@Override
	public Results<ListVO<TBillType>> getBillTypeList(BillTypeVO billTypeVO, PageVO pageVO) {

		ListVO<TBillType> list = new ListVO<TBillType>();

		// 操作类
		TBillTypeExample example = new TBillTypeExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		createCriteria.andDelete_statusEqualTo(0);
		
		if (billTypeVO.getPageVO() != null) {
			// 分页
			Page page;

			if (pageVO == null) {
				page = new Page();
			} else {
				page = new Page(pageVO.getCurrentPage(), pageVO.getPageSize(), tBillTypeMapper.countByExample(example));
			}

			// 添加排序、分页
			example.setOrderByClause(" bill_type_id desc limit " + page.getCurrentResult() + "," + pageVO.getPageSize());

			list.setPage(page);
		}
		
		// 查询票据种类维护信息
		List<TBillType> billTypeList = tBillTypeMapper.selectByExample(example);
		
		list.setList(billTypeList);

		return new Results<ListVO<TBillType>>(list);
	}

	@Override

	public Results<ListVO<TBillType>> getBillTypeByCon(BillTypeVO billTypeVO) {

		ListVO<TBillType> list = new ListVO<TBillType>();

		// 操作类
		TBillTypeExample example = new TBillTypeExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 判断单位主管部门id是否为空

		if (StrKit.notBlank(String.valueOf(billTypeVO.getBill_type_id()))) {

			// 添加单位主管部门id条件
			createCriteria.andBill_type_idEqualTo(billTypeVO.getBill_type_id());

		}

		// 根据条件查询
		List<TBillType> billTypeList = tBillTypeMapper.selectByExample(example);

		// 放入到list集合中
		list.setList(billTypeList);

		return new Results<ListVO<TBillType>>(list);
	}

	@Override
	public Results<Object> updateBillType(TBillType tBillType) {

		// 操作类
		TBillTypeExample example = new TBillTypeExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		tBillTypeMapper.updateByPrimaryKeySelective(tBillType);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<Object> insertBillType(TBillType tBillType) {

		// 操作类
		TBillTypeExample example = new TBillTypeExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		if (StrKit.notBlank(tBillType.getBill_type_code())) {
			createCriteria.andBill_type_codeEqualTo(tBillType.getBill_type_code());
		}

		// 查询是财政编码和财政名称是否存在
		List<TBillType> exists = tBillTypeMapper.selectByExample(example);

		if (exists.size() != 0) {
			return new Results<Object>(Contents.ERROR_307);
		}

		// 插入操作
		tBillTypeMapper.insertSelective(tBillType);

		return new Results<Object>(Contents.ERROR_00);

	}

	@Override
	public Results<Object> deleteBillType(TBillType tBillType) {
		// 删除标识设置为1
		tBillType.setDelete_status(1);

		// 删除操作
		tBillTypeMapper.updateByPrimaryKeySelective(tBillType);

		return new Results<Object>(Contents.ERROR_00);

	}

	@Override
	public void toBillTypeExcel(HttpServletResponse response) {
		try {
			// 操作类
			TBillTypeExample example = new TBillTypeExample();

			// 增加条件
			Criteria createCriteria = example.createCriteria();

			// 查询所有票据种类信息
			List<TBillType> billTypeList = tBillTypeMapper.selectByExample(example);

			// 文档类型
			response.setHeader("content-type", "text/html;charset=UTF-8");
			// 字符
			response.setCharacterEncoding("utf-8");

			// 设置头部
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String("票据种类".getBytes("utf-8"), "iso8859-1") +".xls");

			// 创建表格对象
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), TBillType.class,
					billTypeList);

			workbook.write(response.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Results<ListVO<TBillType>> getBillTypeTree() {
		
		ListVO<TBillType> list = new ListVO<TBillType>();

		// 操作类
		TBillTypeExample example = new TBillTypeExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		createCriteria.andDelete_statusEqualTo(0);

		// 查询票据种类维护信息
		List<TBillType> billTypeList = tBillTypeMapper.selectByExample(example);
		
		// 创建空集合
		List<TBillType> alist = new ArrayList<TBillType>();
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		
		TBillType tBillType = null;
		
		// 遍历票种信息
		for (int i = 0; i < billTypeList.size() && billTypeList != null; i++) {
			tBillType = billTypeList.get(i);
			
			alist.add(tBillType);
			
			aMap.put("bill_type_id", tBillType.getBill_type_id());
			
			// 遍历票据信息
			List<TBillInfoMaintain> billInfoMaintain = tBillInfoMaintainMapper.getBillInfoMaintainById(aMap);
			
			for (int j = 0; j < billInfoMaintain.size() && billInfoMaintain != null; j++) {
				TBillInfoMaintain bInfoMaintain = billInfoMaintain.get(j);
								
				tBillType.getChildren().add(bInfoMaintain);
			}
		}
		
		list.setList(alist);
		
		return new Results<ListVO<TBillType>>(list);
	}


}
