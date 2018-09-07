package base.bill.service.impl;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;

import com.spr.contents.msg.Contents;
import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;
import base.bill.service.BillInfoMaintainService;
import base.bill.service.LevyfallBillInfoService;
import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TBillInfoMaintainExample;
import base.bill.entity.TBillInfoMaintainExample.Criteria;
import base.bill.entity.TBillType;
import base.bill.entity.TBillTypeExample;
import base.bill.entity.TImposingUnitNproject;
import base.bill.entity.TImposingUnitNprojectExample;
import base.bill.entity.TLevyFallExample;
import base.bill.entity.TLevyfallBillInfo;
import base.bill.entity.TLevyfallBillInfoExample;
import base.bill.entity.TUnitBillInfo;
import base.bill.entity.TUnitBillInfoExample;
import base.bill.entity.vo.BillInfoMaintainVO;
import base.bill.entity.vo.PageVO;
import base.bill.mapper.TBillInfoMaintainMapper;
import base.bill.mapper.TBillTypeMapper;
import base.bill.mapper.TLevyfallBillInfoMapper;
import base.bill.mapper.TUnitBillInfoMapper;
import base.bill.util.StrKit;

/**
 * 
 * @类描述：票据信息维护业务层实现
 * @项目名称：base_bill_service
 * @包名： base.bill.service.Impl
 * @类名称：BillInfoMaintainImpl
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
@SuppressWarnings("unused")
@Service
public class BillInfoMaintainImpl implements BillInfoMaintainService {

	@Autowired
	private TBillInfoMaintainMapper tBillInfoMaintainMapper;
	@Autowired
	private TBillTypeMapper tBillTypeMapper;
	@Autowired
	private TUnitBillInfoMapper tUnitBillInfoMapper;
	@Autowired
	private TLevyfallBillInfoMapper tLevyfallBillInfoMapper;

	@Override
	public Results<ListVO<TBillInfoMaintain>> getBillInfoMaintainList(BillInfoMaintainVO billInfoMaintainVO,
			PageVO pageVO) {

		ListVO<TBillInfoMaintain> list = new ListVO<TBillInfoMaintain>();

		// 操作类
		TBillInfoMaintainExample example = new TBillInfoMaintainExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
		
		// 分页
		Page page;

		if (pageVO == null) {
			page = new Page();
		} else {
			page = new Page(pageVO.getCurrentPage(), pageVO.getPageSize(),
					tBillInfoMaintainMapper.countByExample(example));
		}
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		
		aMap.put("startRow", page.getCurrentResult());
		aMap.put("pageSize", page.getPageSize());
		
		

		// 获取父级信息
		List<TBillInfoMaintain> rootBillInfoMaintain = tBillInfoMaintainMapper
				.getBillZgMaintainList(aMap);

		

		// 添加排序、分页
		// example.setOrderByClause(
		// "imposing_unit_id desc limit" + pageVO.getCurrentPage() + "," +
		// pageVO.getPageSize());

		list.setPage(page);
		list.setList(rootBillInfoMaintain);

		return new Results<ListVO<TBillInfoMaintain>>(list);

	}
	
	
	@Override
	public Results<ListVO<TBillInfoMaintain>> getBillInfoMaintainByCon(BillInfoMaintainVO billInfoMaintainVO) {

		ListVO<TBillInfoMaintain> list = new ListVO<TBillInfoMaintain>();

		// 操作类
		TBillInfoMaintainExample example = new TBillInfoMaintainExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		if (billInfoMaintainVO.getBill_info_maintain_id() != null) {
			createCriteria.andBill_info_maintain_idEqualTo(billInfoMaintainVO.getBill_info_maintain_id());
		}

		// 获取票据维护信息
		List<TBillInfoMaintain> rootBillInfoMaintain = tBillInfoMaintainMapper.getBillInfoMaintainByCon(billInfoMaintainVO);

		list.setList(rootBillInfoMaintain);

		return new Results<ListVO<TBillInfoMaintain>>(list);

	}

	@Override
	public Results<Object> updateBillInfoMaintain(TBillInfoMaintain tBillInfoMaintain) {

		tBillInfoMaintainMapper.updateByPrimaryKeySelective(tBillInfoMaintain);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<Object> insertBillInfoMaintain(TBillInfoMaintain tBillInfoMaintain) {

		// 操作类
		TBillInfoMaintainExample example = new TBillInfoMaintainExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 判断票据维护信息编码是否存在
		if (tBillInfoMaintain.getBill_code() != null) {
			createCriteria.andBill_codeEqualTo(tBillInfoMaintain.getBill_code());
		}

		// 票据维护信息
		List<TBillInfoMaintain> exists = tBillInfoMaintainMapper.selectByExample(example);

		// 如果有信息
		if (exists.size() != 0) {
			// 返回有存在
			return new Results<Object>(Contents.ERROR_308);
		}

		// 添加操作
		tBillInfoMaintainMapper.insertSelective(tBillInfoMaintain);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<Object> deleteBillInfoMaintain(TBillInfoMaintain tBillInfoMaintain) {

		// 将删除标记设置为1
		tBillInfoMaintain.setDelete_status(1);

		tBillInfoMaintainMapper.updateByPrimaryKeySelective(tBillInfoMaintain);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public void toBillInfoMaintainExcel(HttpServletResponse response) {
		try {

			Map<String, Object> aMap = new HashMap<String, Object>();

			// 操作类
			TBillInfoMaintainExample example = new TBillInfoMaintainExample();

			// 增加条件
			Criteria createCriteria = example.createCriteria();

			// 获取父级信息
			List<TBillInfoMaintain> rootTBillInfoMaintain = tBillInfoMaintainMapper.getBillZgMaintainList(aMap);

			// 文档类型
			response.setHeader("content-type", "text/html;charset=UTF-8");
			// 字符
			response.setCharacterEncoding("utf-8");

			// 设置头部
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String("票据信息".getBytes("utf-8"), "iso8859-1") + ".xls");

			// 创建表格对象
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), TBillInfoMaintain.class,
					rootTBillInfoMaintain);
			
			workbook.write(response.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Results<ListVO<TBillType>> getBillTypeTree(@RequestBody BillInfoMaintainVO billInfoMaintainVO) {
		
		ListVO<TBillType> list = new ListVO<TBillType>();

		// 操作类
		TBillTypeExample example = new TBillTypeExample();
		 
		example.createCriteria().andDelete_statusEqualTo(0);

		// 查询票据种类维护信息
		List<TBillType> billTypeList = tBillTypeMapper.selectByExample(example);
		
		// 创建空集合
		List<TBillType> alist = new ArrayList<TBillType>();
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		
		TBillType tBillType = null;
		
		// Map空集合
		Map<Integer, Integer> map = null;
		
		// 判断执收单位id不为空
		if (billInfoMaintainVO.getImposing_unit_id() != null) {
		     map = selectedTUnitBillInfo(billInfoMaintainVO.getImposing_unit_id());
		} 
		
		// 判断征收大厅是否为空
		if (billInfoMaintainVO.getLevyfall_id() != null) {
			
			 map = selectedTLevyfallBillInfo(billInfoMaintainVO.getLevyfall_id());
		}
		
		// 遍历票种信息
		for (int i = 0; i < billTypeList.size() && billTypeList != null; i++) {
			tBillType = billTypeList.get(i);
			
			// 票种编码和名称拼接
			tBillType.setBillinfo_code_name(tBillType.getBill_type_code() + "" + tBillType.getBill_type_name());
			
			
			alist.add(tBillType);
			
			aMap.put("bill_type_id", tBillType.getBill_type_id());
			
			// 遍历票据信息
			List<TBillInfoMaintain> billInfoMaintain = tBillInfoMaintainMapper.getBillInfoMaintainById(aMap);
			
			for (int j = 0; j < billInfoMaintain.size() && billInfoMaintain != null; j++) {
				TBillInfoMaintain bInfoMaintain = billInfoMaintain.get(j);
				
				// 票据信息与名称拼接
				bInfoMaintain.setBillinfo_code_name(bInfoMaintain.getBill_code() + " " + bInfoMaintain.getBill_name());
				
				if (map.get(bInfoMaintain.getBill_info_maintain_id()) != null) {
					bInfoMaintain.setStatus(true);
				}
				
				tBillType.getChildren().add(bInfoMaintain);
			}
		}
		
		list.setList(alist);
		
		return new Results<ListVO<TBillType>>(list);
	}
 
	// 执收单位与项目挂接数据
	private Map<Integer, Integer> selectedTUnitBillInfo(Integer imposing_unit_id) {
		
		TUnitBillInfoExample example = new TUnitBillInfoExample();
		
		example.createCriteria().andImposing_unit_idEqualTo(imposing_unit_id);
		
		List<TUnitBillInfo> listTUnitBillInfo = tUnitBillInfoMapper.selectByExample(example);
		
		//封装一个执收单位的所有项目集合
		Map<Integer, Integer> mapTUnitBillInfo = new HashMap<Integer, Integer>();
		for (TUnitBillInfo u : listTUnitBillInfo) {
			mapTUnitBillInfo.put(u.getBill_info_maintain_id(), u.getBill_info_maintain_id());
		}

		return mapTUnitBillInfo;
	}
	
	// 执收单位与项目挂接数据
	private Map<Integer, Integer> selectedTLevyfallBillInfo(Integer levyfall_id) {
		
		TLevyfallBillInfoExample example = new TLevyfallBillInfoExample();
		
		example.createCriteria().andLevyfall_idEqualTo(levyfall_id);
		
		List<TLevyfallBillInfo> listTLevyfallBillInfo = tLevyfallBillInfoMapper.selectByExample(example);
		
		//封装一个执收单位的所有项目集合
		Map<Integer, Integer> maplistTUnitBillInfo = new HashMap<Integer, Integer>();
		for (TLevyfallBillInfo u : listTLevyfallBillInfo) {
			
			maplistTUnitBillInfo.put(u.getBill_info_maintain_id(), u.getBill_info_maintain_id());
		}
		return maplistTUnitBillInfo;
	}
	
}
