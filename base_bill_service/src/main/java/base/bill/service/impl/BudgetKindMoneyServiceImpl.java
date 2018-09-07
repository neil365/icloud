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
import base.bill.service.BudgetKindMoneyService;
import base.bill.entity.TBudgetKindMoney;
import base.bill.entity.TBudgetKindMoneyExample;
import base.bill.entity.TFinancial;
import base.bill.entity.TBudgetKindMoneyExample.Criteria;
import base.bill.entity.vo.BudgetKindMoneyVO;
import base.bill.entity.vo.PageVO;
import base.bill.mapper.TBudgetKindMoneyMapper;
import base.bill.util.StrKit;



/**
 * 
 * @类描述：收入类款业务层实现
 * @项目名称：base_bill_service
 * @包名： base.bill.service.Impl
 * @类名称：BudgetKindMoneyServiceImpl
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
@Service
public class BudgetKindMoneyServiceImpl implements BudgetKindMoneyService {

	@Autowired
	private TBudgetKindMoneyMapper tBudgetKindMoneyMapper;

	@Override
	public Results<ListVO<TBudgetKindMoney>> getBudgetKindMoneyList(BudgetKindMoneyVO BudgetKindMoneyVO,
			PageVO pageVo) {

		// 放入集合
		ListVO<TBudgetKindMoney> list = new ListVO<TBudgetKindMoney>();

		// 操作类
		TBudgetKindMoneyExample example = new TBudgetKindMoneyExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 未删除的记录
		createCriteria.andDelete_statusEqualTo(0);
		
		// 分页
		Page page;
		
		Map<String, Object> aMap = new HashMap<String, Object>();

		// 添加预收类款id
		aMap.put("budget_kind_money_id", 0);
		
		if (pageVo == null) {
			page = new Page();
		} else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(),
					tBudgetKindMoneyMapper.countByExample(example));

			// 放入到集合中
			list.setPage(page);
			
			aMap.put("startRow", page.getCurrentResult());
			aMap.put("pageSize", pageVo.getPageSize());
		}

		// 获取父级信息
		List<TBudgetKindMoney> rootBudgetKindMoney = tBudgetKindMoneyMapper.getBudgetKindMoneyByParentId(aMap);
		
		// 遍历子级
		menu(rootBudgetKindMoney);
		
		// 添加排序、分页
		// example.setOrderByClause(
		// " budget_kind_money_id desc limit " + page.getCurrentResult() + "," +
		// pageVo.getPageSize());

		list.setList(rootBudgetKindMoney);

		return new Results<ListVO<TBudgetKindMoney>>(list);
	}

	@Override
	public Results<ListVO<TBudgetKindMoney>> getBudgetKindMoneyByCon(TBudgetKindMoney tBudgetKindMoney) {

		// 放入集合
		ListVO<TBudgetKindMoney> list = new ListVO<TBudgetKindMoney>();

		// 操作类
		TBudgetKindMoneyExample example = new TBudgetKindMoneyExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 判断预收类款id是否为空
		if (StrKit.notBlank(String.valueOf(tBudgetKindMoney.getBudget_kind_money_id()))) {
			createCriteria.andBudget_kind_money_idEqualTo(tBudgetKindMoney.getBudget_kind_money_id());
		}

		// 获取父级信息
		List<TBudgetKindMoney> rootBudgetKindMoney = tBudgetKindMoneyMapper.selectByExample(example);

		// 放入到集合
		list.setList(rootBudgetKindMoney);

		return new Results<ListVO<TBudgetKindMoney>>(list);
	}

	@Override
	public Results<Object> updateBudgetKindMoney(TBudgetKindMoney tBudgetKindMoney) {

		// 修改
		tBudgetKindMoneyMapper.updateByPrimaryKeySelective(tBudgetKindMoney);

		return new Results<Object>(Contents.ERROR_00);

	}

	@Override
	public Results<Object> insertBudgetKindMoney(TBudgetKindMoney tBudgetKindMoney) {

		// 放入集合
		ListVO<TBudgetKindMoney> list = new ListVO<TBudgetKindMoney>();

		// 操作类
		TBudgetKindMoneyExample example = new TBudgetKindMoneyExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 判断预收类款id是否为空
		if (StrKit.notBlank(String.valueOf(tBudgetKindMoney.getKindmoney_code()))) {
			createCriteria.andKindmoney_codeEqualTo((tBudgetKindMoney.getKindmoney_code()));
		}

		List<TBudgetKindMoney> exists = tBudgetKindMoneyMapper.selectByExample(example);

		if (exists.size() != 0) {
			return new Results<Object>(Contents.ERROR_305);
		}
		
		// 判断父级id是否有值
		if(tBudgetKindMoney.getParent_id() == null) {
			// 默认设置为父级
			tBudgetKindMoney.setParent_id(0);
		}
		
		// 增加
		tBudgetKindMoneyMapper.insertSelective(tBudgetKindMoney);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<Object> deleteBudgetKindMoney(TBudgetKindMoney tBudgetKindMoney) {
		// 默认设置删除标记为1
		tBudgetKindMoney.setDelete_status(1);

		tBudgetKindMoneyMapper.updateByPrimaryKeySelective(tBudgetKindMoney);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public void toBudgetKindMoneyExcel(HttpServletResponse response) {

		try {
			// 操作类
			TBudgetKindMoneyExample example = new TBudgetKindMoneyExample();

			// 增加条件
			Criteria createCriteria = example.createCriteria();

			// 获取父级信息
			List<TBudgetKindMoney> rootBudgetKindMoney = tBudgetKindMoneyMapper.selectByExample(example);

			// 文档类型
			response.setHeader("content-type", "text/html;charset=UTF-8");
			// 字符
			response.setCharacterEncoding("utf-8");

			// 设置头部
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String("收入类款".getBytes("utf-8"), "iso8859-1") +".xls");

			// 创建表格对象
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), TBudgetKindMoney.class,
					rootBudgetKindMoney);

			workbook.write(response.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取子级
	 * 
	 * @param rootFinancial
	 * @throws Exception
	 */
	private void menu(List<TBudgetKindMoney> rootBudgetKindMoney) {
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		
		for (TBudgetKindMoney tBudgetKindMoney : rootBudgetKindMoney) {
			
			aMap.put("budget_kind_money_id", tBudgetKindMoney.getBudget_kind_money_id());
			
			List<TBudgetKindMoney> cTBudgetKindMoney = tBudgetKindMoneyMapper.getBudgetKindMoneyByParentId(aMap);
			if (cTBudgetKindMoney.size() != 0) {
				tBudgetKindMoney.setChildren(cTBudgetKindMoney);
			}

			menu(cTBudgetKindMoney);
		}
	}

}
