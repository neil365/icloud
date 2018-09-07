package base.bill.service.impl;

import java.io.IOException;
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
import base.bill.service.BillZgMaintainService;
import base.bill.entity.TBillZgMaintain;
import base.bill.entity.TBillZgMaintainExample;
import base.bill.entity.TBillZgMaintainExample.Criteria;
import base.bill.entity.vo.BillZgMaintainVO;
import base.bill.entity.vo.PageVO;
import base.bill.mapper.TBillZgMaintainMapper;

/**
 * 
 * @类描述：票据字轨维护业务层实现
 * @项目名称：spr-non-tax-core @包名： base.bill.business.impl
 * @类名称：BillZgMaintainImpl
 * @创建人：吴镇锡
 * @创建时间：2018年5月14日下午6:16:49
 * @修改人：吴镇锡
 * @修改时间：2018年5月14日下午6:16:49 @修改备注：
 */
@SuppressWarnings("unused")
@Service
public class BillZgMaintainImpl implements BillZgMaintainService {

	@Autowired
	private TBillZgMaintainMapper tBillZgMaintainMapper;

	@Override
	public Results<ListVO<TBillZgMaintain>> getBillZgMaintainList(BillZgMaintainVO billZgMaintainVO, PageVO pageVO) {
		ListVO<TBillZgMaintain> list = new ListVO<TBillZgMaintain>();

		// 操作类
		TBillZgMaintainExample example = new TBillZgMaintainExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 分页
		Page page;

		if (pageVO == null) {
			page = new Page();
		} else {
			page = new Page(pageVO.getCurrentPage(), pageVO.getPageSize(),
					tBillZgMaintainMapper.countByExample(example));
		}

		Map<String, Object> aMap = new HashMap<String, Object>();

		aMap.put("startRow", page.getCurrentResult());
		aMap.put("pageSize", page.getPageSize());

		// 获取父级信息
		List<TBillZgMaintain> rootBillInfoMaintain = tBillZgMaintainMapper.getBillZgMaintainList(aMap);

		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);

		// 添加排序、分页
		// example.setOrderByClause(
		// "imposing_unit_id desc limit" + pageVO.getCurrentPage() + "," +
		// pageVO.getPageSize());

		list.setPage(page);
		list.setList(rootBillInfoMaintain);

		return new Results<ListVO<TBillZgMaintain>>(list);
	}

	@Override
	public Results<ListVO<TBillZgMaintain>> getBillZgMaintainByCon(BillZgMaintainVO billZgMaintainVO) {

		ListVO<TBillZgMaintain> list = new ListVO<TBillZgMaintain>();
 

		// 获取票据维护信息
		List<TBillZgMaintain> rootBillZgMaintain = tBillZgMaintainMapper.getBillZgMaintainByCon(billZgMaintainVO);

		list.setList(rootBillZgMaintain);

		return new Results<ListVO<TBillZgMaintain>>(list);
	}

	@Override
	public Results<Object> updateBillZgMaintain(TBillZgMaintain tBillZgMaintain) {
		
		// 修改
		tBillZgMaintainMapper.updateByPrimaryKeySelective(tBillZgMaintain);

		return new Results<Object>(Contents.ERROR_00);

	}

	@Override
	public Results<Object> insertBillZgMaintain(TBillZgMaintain tBillZgMaintain) {

		// 添加操作
		tBillZgMaintainMapper.insertSelective(tBillZgMaintain);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<Object> deleteBillZgMaintain(TBillZgMaintain tBillZgMaintain) {

		// 将删除标记设置为1
		tBillZgMaintain.setDelete_status(1);

		// 修改
		tBillZgMaintainMapper.updateByPrimaryKeySelective(tBillZgMaintain);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public void toBillZgMaintainExcel(HttpServletResponse response) {

		try {
			Map<String, Object> aMap = new HashMap<String, Object>();

			// 操作类
			TBillZgMaintainExample example = new TBillZgMaintainExample();

			// 增加条件
			Criteria createCriteria = example.createCriteria();

			// 获取父级信息
			List<TBillZgMaintain> rootTBillZgMaintain = tBillZgMaintainMapper.selectByExample(example);

			// 文档类型
			response.setHeader("content-type", "text/html;charset=UTF-8");
			// 字符
			response.setCharacterEncoding("utf-8");

			// 设置头部
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String("票据字轨".getBytes("utf-8"), "iso8859-1") + ".xls");

			// 创建表格对象
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), TBillZgMaintain.class,
					rootTBillZgMaintain);

			workbook.write(response.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
