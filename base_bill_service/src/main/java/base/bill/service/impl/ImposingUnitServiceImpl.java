package base.bill.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
import base.bill.service.ImposingUnitService;
import base.bill.entity.TFinancial;
import base.bill.entity.TImposingUnit;
import base.bill.entity.TImposingUnitExample;
import base.bill.entity.TImposingUnitNprojectExample;
import base.bill.entity.TLevyfallImposingUnitExample;
import base.bill.entity.TNotaxProject;
import base.bill.entity.TUnitCompetentDepartment;
import base.bill.entity.TImposingUnitExample.Criteria;
import base.bill.entity.TLevyfallImposingUnit;
import base.bill.entity.vo.ImposingUnitVO;
import base.bill.entity.vo.LevyFallVO;
import base.bill.entity.vo.PageVO;
import base.bill.mapper.TImposingUnitMapper;
import base.bill.mapper.TLevyfallImposingUnitMapper;
import base.bill.util.StrKit;

/**
 * 
 * @类描述：执收单位业务层
 * @项目名称：spr-non-tax-core @包名： base.bill.business
 * @类名称：FinancialServiceImpl
 * @创建人：wangp
 * @创建时间：2018年5月9日上午10:42:49
 */
@SuppressWarnings("unused")
@Service
public class ImposingUnitServiceImpl implements ImposingUnitService {

	@Autowired
	private TImposingUnitMapper tImposingUnitMapper;
	@Autowired
	private TLevyfallImposingUnitMapper tLevyfallImposingUnitMapper;

	@Override
	public Results<ListVO<TImposingUnit>> getImposingUnitList(ImposingUnitVO imposingUnitVO, PageVO pageVO) {

		ListVO<TImposingUnit> list = new ListVO<TImposingUnit>();

		// 操作类
		TImposingUnitExample example = new TImposingUnitExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		createCriteria.andParent_idEqualTo(0);
		createCriteria.andDelete_statusEqualTo(0);

		// 判断是否为管理员
		if (imposingUnitVO.getIs_manage() != null && imposingUnitVO.getIs_manage() == 1) {

			Page page;

			if (pageVO == null) {
				page = new Page();
			} else {
				page = new Page(pageVO.getCurrentPage(), pageVO.getPageSize(),
						tImposingUnitMapper.countByExample(example));

				// 放入到集合中
				list.setPage(page);
			}

			// 获取执收单位的树形结构
			List<TImposingUnit> rootTImposingUnit = buildTree(0, imposingUnitVO.getLevyfall_id(), page);

			list.setList(rootTImposingUnit);

			return new Results<ListVO<TImposingUnit>>(list);

		} else {

			Map<String, Object> aMap = new HashMap<String, Object>();

			// 获取父级信息
			List<TImposingUnit> rootTImposingUnit = tImposingUnitMapper.getImposingUnitByUser(aMap);

			// 征收大厅与执收单位挂接数据
			Map<Integer, Integer> mapTLevyfallImposingUnit = selectedTLevyfallImposingUnit(
					imposingUnitVO.getLevyfall_id());

			// 树形结构
			List<TImposingUnit> list1 = tree(0, rootTImposingUnit, mapTLevyfallImposingUnit);

			list.setList(list1);
		}

		return new Results<ListVO<TImposingUnit>>(list);
	}

	// 征收大厅与执收单位挂接信息
	private Map<Integer, Integer> selectedTLevyfallImposingUnit(Integer levyfall_id) {

		// 查询条件
		TLevyfallImposingUnitExample example = new TLevyfallImposingUnitExample();

		example.createCriteria().andLevyfall_idEqualTo(levyfall_id);

		// 获取征收大厅与执收单位挂接信息
		List<TLevyfallImposingUnit> listTLevyfallImposingUnit = tLevyfallImposingUnitMapper.selectByExample(example);

		Map<Integer, Integer> mapTLevyfallImposingUnit = new HashMap<Integer, Integer>();

		for (TLevyfallImposingUnit t : listTLevyfallImposingUnit) {
			// 非税项目的id，放入map集合
			mapTLevyfallImposingUnit.put(t.getImposing_unit_id(), t.getImposing_unit_id());
		}

		return mapTLevyfallImposingUnit;
	}

	// 创建树形结构
	private List<TImposingUnit> buildTree(Integer parent_id, Integer levyfall_id, Page page) {

		// 操作类
		TImposingUnitExample example = new TImposingUnitExample();

		Criteria createCriteria = example.createCriteria();

		createCriteria.andDelete_statusEqualTo(0);
		createCriteria.andParent_idEqualTo(0);

		if (page != null) {
			example.setOrderByClause(
					"imposing_unit_id desc limit " + page.getCurrentResult() + "," + page.getPageSize());
		}

		// 执收单位全部数据
		List<TImposingUnit> rootTImposingUnit = tImposingUnitMapper.selectByExample(example);

		List<TImposingUnit> listTImposingUnit = getChildren(rootTImposingUnit);

		// 征收大厅与执收单位数据
		Map<Integer, Integer> mapTLevyfallImposingUnit = selectedTLevyfallImposingUnit(levyfall_id);

		List<TImposingUnit> treeList = tree(parent_id, listTImposingUnit, mapTLevyfallImposingUnit);

		return treeList;
	}

	// 子级中的所有数据
	private List<TImposingUnit> getChildren(List<TImposingUnit> rootTImposingUnit) {

		List<Integer> ids = new ArrayList<Integer>();

		// 操作类
		TImposingUnitExample example = new TImposingUnitExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 删除不能为0
		createCriteria.andDelete_statusEqualTo(0);

		// 非空校验
		if (rootTImposingUnit.size() != 0 && rootTImposingUnit != null) {
			for (TImposingUnit tImposingUnit : rootTImposingUnit) {
				if (tImposingUnit.getImposing_unit_id() != null) {
					ids.add(tImposingUnit.getImposing_unit_id());
				}
			}

			if (ids.size() != 0 && ids != null) {
				createCriteria.andParent_idIn(ids);
				example.or().andImposing_unit_idIn(ids);
			}

		}

		List<TImposingUnit> listTImposingUnit = tImposingUnitMapper.selectByExample(example);

		return listTImposingUnit;
	}

	private List<TImposingUnit> tree(Integer parent_id, List<TImposingUnit> rootTImposingUnit,
			Map<Integer, Integer> mapTLevyfallImposingUnit) {
		// 获取子级
		return menu(parent_id, rootTImposingUnit, mapTLevyfallImposingUnit);
	}

	/**
	 * 获取子级
	 *
	 * @param rootFinancial
	 * @throws Exception
	 *             父级id，所有非税集合，执收单位非税map集合，收入类款集合
	 */
	private List<TImposingUnit> menu(Integer parent_id, List<TImposingUnit> rootTImposingUnit,
			Map<Integer, Integer> mapTLevyfallImposingUnit) {

		List<TImposingUnit> subList = new ArrayList<TImposingUnit>();

		// 非税项目集合
		for (TImposingUnit t : rootTImposingUnit) {
			// 执收单位编码与名称拼接
			t.setUnitcode_name(t.getUnit_code() + " " + t.getUnit_name());

			// 如果遍历的对象的父id等于parent_id
			if (t.getParent_id() == parent_id) {

				// 如果挂接map集合中的执收单位id不为空
				if (mapTLevyfallImposingUnit.get(t.getImposing_unit_id()) != null) {
					// 将对象中的选中状态改成true
					t.setStatus(true);
				}

				// 递归调用
				t.setChildren(menu(t.getImposing_unit_id(), rootTImposingUnit, mapTLevyfallImposingUnit));

				subList.add(t);
			}
		}
		return subList;
	}

	@Override
	public Results<ListVO<TImposingUnit>> getFinancialByCon(ImposingUnitVO imposingUnitVO) {

		ListVO<TImposingUnit> list = new ListVO<>();

		// 操作类
		TImposingUnitExample example = new TImposingUnitExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 判断执收单位id是否为空
		if (imposingUnitVO.getImposing_unit_id() != null) {
			// 执收单位条件
			createCriteria.andImposing_unit_idEqualTo(imposingUnitVO.getImposing_unit_id());

			// 必须是未删除的
			createCriteria.andDelete_statusEqualTo(0);

			// 父级
			List<TImposingUnit> rootTImposingUnit = tImposingUnitMapper.selectByExample(example);

			list.setList(rootTImposingUnit);
		}

		return new Results<ListVO<TImposingUnit>>(list);

	}

	@Override
	public Results<Object> updateImposingUnit(TImposingUnit tImposingUnit) {

		tImposingUnitMapper.updateByPrimaryKeySelective(tImposingUnit);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<Object> insertImposingUnit(TImposingUnit tImposingUnit) {
		// 操作类
		TImposingUnitExample example = new TImposingUnitExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 判断财政编码是否存在
		if (tImposingUnit.getUnit_code() != null) {
			createCriteria.andOrganization_codeEqualTo(tImposingUnit.getUnit_code());
		}

		// 查询是财政编码和财政名称是否存在
		List<TImposingUnit> exists = tImposingUnitMapper.selectByExample(example);

		if (exists.size() != 0) {
			return new Results<Object>(Contents.ERROR_301);
		}

		// 如果父级id为空，默认设置为0
		if (tImposingUnit.getParent_id() == null) {
			tImposingUnit.setParent_id(0);
		}

		// 添加操作
		tImposingUnitMapper.insertSelective(tImposingUnit);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<Object> deleteImposingUnit(TImposingUnit tImposingUnit) {

		tImposingUnit.setDelete_status(1);

		tImposingUnitMapper.updateByPrimaryKeySelective(tImposingUnit);

		return new Results<Object>(Contents.ERROR_00);
	}

	/**
	 * 获取子级
	 * 
	 * @param rootFinancial
	 * @throws Exception
	 */
	private void menu(List<TImposingUnit> rootImposingUnit) {

		for (TImposingUnit tImposingUnit : rootImposingUnit) {

			List<TImposingUnit> cImposingUnit = tImposingUnitMapper
					.getImposingUnitByParentId(tImposingUnit.getImposing_unit_id());

			if (cImposingUnit.size() != 0 && cImposingUnit != null) {

				tImposingUnit.setChildren(cImposingUnit);
			}

			menu(cImposingUnit);
		}
	}

	/**
	 *
	 * @描述:财政信息导出到Excel 
	 * @方法名: toFinancialExcel 
	 * @param response 
	 * @param request
	 * @返回类型 void 
	 * @创建人 wangp 
	 * @创建时间 2018-8-18
	 * @修改备注 @since @throws
	 */
	@Override
	public void toImposingUnitExcel(HttpServletResponse response) {

		try {
			// 操作类
			TImposingUnitExample example = new TImposingUnitExample();

			// 增加条件
			Criteria createCriteria = example.createCriteria();

			// 获取父级信息
			List<TImposingUnit> rootTImposingUnit = tImposingUnitMapper.getImposingUnitByParentId(0);

			// 获取子级
			menu(rootTImposingUnit);

			// 创建list集合
			List<TImposingUnit> subImposingUnit = new ArrayList<TImposingUnit>();

			// 遍历集合
			for (int i = 0; i < rootTImposingUnit.size(); i++) {
				TImposingUnit f = rootTImposingUnit.get(i);

				// 添加到subFinancial集合中
				subImposingUnit.add(f);

				if (f.getChildren() != null) {
					for (int j = 0; j < f.getChildren().size(); j++) {
						TImposingUnit fi = f.getChildren().get(j);
						subImposingUnit.add(fi);
					}
				}
			}

			// 文档类型
			response.setHeader("content-type", "text/html;charset=UTF-8");
			// 字符
			response.setCharacterEncoding("utf-8");

			// 设置头部
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=imposingUnit.xls");

			// 创建表格对象
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), TImposingUnit.class, subImposingUnit);

			workbook.write(response.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Results<Object> updateImposingUnitIsUse(TImposingUnit tImposingUnit) {

		// 判断是否为空
		if (StrKit.notBlank(String.valueOf(tImposingUnit.getImposing_unit_id()))
				&& StrKit.notBlank(String.valueOf(tImposingUnit.getIs_use()))) {

			List<TImposingUnit> rootImposingUnit = tImposingUnitMapper
					.getImposingUnitByParentId(tImposingUnit.getImposing_unit_id());

			// 获取子级
			menu(rootImposingUnit);

			// 创建list集合
			List<TImposingUnit> subImposingUnit = new ArrayList<TImposingUnit>();

			// 遍历集合
			for (int i = 0; i < rootImposingUnit.size(); i++) {
				TImposingUnit f = rootImposingUnit.get(i);

				// 添加到subImposingUnit集合中
				subImposingUnit.add(f);

				// 判断是否有子级
				if (f.getChildren() != null) {
					for (int j = 0; j < f.getChildren().size(); j++) {
						TImposingUnit fi = f.getChildren().get(j);
						subImposingUnit.add(fi);
					}
				}
			}

			if (subImposingUnit.size() != 0 && subImposingUnit != null) {
				// 修改子级中信息的是否启用
				for (TImposingUnit imposingUnit : subImposingUnit) {

					TImposingUnit t = new TImposingUnit();
					t.setImposing_unit_id(imposingUnit.getImposing_unit_id());
					t.setIs_use(tImposingUnit.getIs_use());

					tImposingUnitMapper.updateImposingUnitIsUse(t);
				}

			}

			// 没有子级，直接修改父级是否启用
			TImposingUnit imposingUnit = new TImposingUnit();
			imposingUnit.setIs_use(tImposingUnit.getIs_use());
			imposingUnit.setImposing_unit_id(tImposingUnit.getImposing_unit_id());

			tImposingUnitMapper.updateImposingUnitIsUse(imposingUnit);
		}
		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<ListVO<TImposingUnit>> getImposingUnitNode(ImposingUnitVO imposingUnitVO) {
		
		ListVO<TImposingUnit> list = new ListVO<TImposingUnit>();

		List<TImposingUnit> subTImposingUnit = new ArrayList<TImposingUnit>();

		List<TImposingUnit> node = new ArrayList<TImposingUnit>();
		
		Map<Integer, Integer> mapTLevyfallImposingUnit = new HashMap<Integer, Integer>();
		
		if (imposingUnitVO.getLevyfall_id() != null) {
			// 征收大厅与执收单位数据
			 mapTLevyfallImposingUnit = selectedTLevyfallImposingUnit(imposingUnitVO.getLevyfall_id());
		}		

		// 操作类
		TImposingUnitExample example = new TImposingUnitExample();
		Criteria createCriteria = example.createCriteria();

		// 判断是否为管理员
		if (imposingUnitVO.getIs_manage() != null && imposingUnitVO.getIs_manage() == 1) {

			// 查询父节点
			List<TImposingUnit> rootTImposingUnit = new ArrayList<TImposingUnit>();

			// 执收单位id为空，查询父节点
			if (imposingUnitVO.getImposing_unit_id() == null) {

				// 删除条件为0，父级id为0
				createCriteria.andDelete_statusEqualTo(0).andParent_idEqualTo(0);

				// 将父节点信息放入集合中
				rootTImposingUnit = tImposingUnitMapper.selectByExample(example);

				for (TImposingUnit tImposingUnit : rootTImposingUnit) {

					// 子节点
					subTImposingUnit = getChildrens(tImposingUnit.getImposing_unit_id());

					// 编码与单位名称拼接
					tImposingUnit.setUnitcode_name(tImposingUnit.getUnit_code() + " " + tImposingUnit.getUnit_name());
					
					// 非空校验
					if (mapTLevyfallImposingUnit.get(tImposingUnit.getImposing_unit_id()) != null) {
						// 如果执收单位与非税项目挂接，将status改为true
						tImposingUnit.setStatus(true);
					}

					// 是否有子节点
					if (subTImposingUnit.size() > 0) {
						tImposingUnit.setLoading(false);
					} else {

						TImposingUnit t = new TImposingUnit();

						t.setImposing_unit_id(tImposingUnit.getImposing_unit_id());

						node.add(t);

						tImposingUnit.setChildren(node);
					}
				}

			} else {

				// 执收单位id
				List<Integer> ids = new ArrayList<Integer>();
				ids.add(imposingUnitVO.getImposing_unit_id());

				TImposingUnitExample example1 = new TImposingUnitExample();

				Criteria criteria = example1.createCriteria();
				criteria.andDelete_statusEqualTo(0);

				// 条件执收单位id和父id
				criteria.andParent_idIn(ids);

				// 查询子节点
				rootTImposingUnit = tImposingUnitMapper.selectByExample(example1);
				
				for (TImposingUnit tImposingUnit : rootTImposingUnit) {

					subTImposingUnit = getChildrens(tImposingUnit.getImposing_unit_id());

					// 编码与单位名称拼接
					tImposingUnit.setUnitcode_name(tImposingUnit.getUnit_code() + " " + tImposingUnit.getUnit_name());
					
					if (mapTLevyfallImposingUnit.get(tImposingUnit.getImposing_unit_id()) != null) {
						
						System.out.println(mapTLevyfallImposingUnit.get(tImposingUnit.getImposing_unit_id()));
						// 如果执收单位与非税项目挂接，将status改为true
						tImposingUnit.setStatus(true);
					}

					// 判断是否有子集
					if (subTImposingUnit.size() > 0) {
						tImposingUnit.setLoading(false);

					} else {

						TImposingUnit t = new TImposingUnit();

						t.setImposing_unit_id(tImposingUnit.getImposing_unit_id());

						node.add(t);

						tImposingUnit.setChildren(node);
					}
				}
			}

			list.setList(rootTImposingUnit);

			return new Results<ListVO<TImposingUnit>>(list);

		} else { // 非管理员

			List<TImposingUnit> rootTImposingUnit = new ArrayList<TImposingUnit>();

			Map<String, Object> aMap = new HashMap<String, Object>();

			// 执收单位id为空，查询所有父级
			if (imposingUnitVO.getImposing_unit_id() == null) {
				aMap.put("parent_id", 0);
				aMap.put("financial_id", imposingUnitVO.getFinancial_id());

				rootTImposingUnit = tImposingUnitMapper.getImposingUnitByUser(aMap);

				for (TImposingUnit tImposingUnit : rootTImposingUnit) {

					subTImposingUnit = getChildrens(tImposingUnit.getImposing_unit_id());

					// 编码与单位名称拼接
					tImposingUnit.setUnitcode_name(tImposingUnit.getUnit_code() + " " + tImposingUnit.getUnit_name());

					// 判断是否有子集
					if (subTImposingUnit.size() > 0) {
						tImposingUnit.setLoading(false);

					} else {

						TImposingUnit t = new TImposingUnit();

						t.setImposing_unit_id(tImposingUnit.getImposing_unit_id());

						node.add(t);

						tImposingUnit.setChildren(node);
					}
				}

			} else { // 执收单位不为空
				aMap.put("parent_id", imposingUnitVO.getImposing_unit_id());
				aMap.put("financial_id", imposingUnitVO.getFinancial_id());

				rootTImposingUnit = tImposingUnitMapper.getImposingUnitByUser(aMap);

				for (TImposingUnit tImposingUnit : rootTImposingUnit) {

					subTImposingUnit = getChildrens(tImposingUnit.getImposing_unit_id());

					// 编码与单位名称拼接
					tImposingUnit.setUnitcode_name(tImposingUnit.getUnit_code() + " " + tImposingUnit.getUnit_name());

					// 判断是否有子集
					if (subTImposingUnit.size() > 0) {
						tImposingUnit.setLoading(false);

					} else {

						TImposingUnit t = new TImposingUnit();

						t.setImposing_unit_id(tImposingUnit.getImposing_unit_id());

						node.add(t);

						tImposingUnit.setChildren(node);
					}
				}
			}

			list.setList(rootTImposingUnit);
		}

		return new Results<ListVO<TImposingUnit>>(list);
	}

	private List<TImposingUnit> getChildrens(Integer imposing_unit_id) {

		List<Integer> ids = new ArrayList<Integer>();

		ids.add(imposing_unit_id);

		TImposingUnitExample example = new TImposingUnitExample();

		Criteria criteria = example.createCriteria();
		criteria.andDelete_statusEqualTo(0);

		// 条件执收单位id和父id
		criteria.andParent_idIn(ids);

		// 查询子节点
		return tImposingUnitMapper.selectByExample(example);
	}

	@Override
	public Results<ListVO<TImposingUnit>> getLevyFallImposingUnitByLevyFallId(ImposingUnitVO imposingUnitVO,
			PageVO pageVO) {

		ListVO<TImposingUnit> list = new ListVO<TImposingUnit>();

		Map<String, Object> aMap = new HashMap<String, Object>();

		// 操作类
		TLevyfallImposingUnitExample example = new TLevyfallImposingUnitExample();

		// 增加条件征收大厅id
		example.createCriteria().andLevyfall_idEqualTo(imposingUnitVO.getLevyfall_id());

		Page page;

		// 非空校验
		if (pageVO == null) {
			page = new Page();
		} else {
			page = new Page(pageVO.getCurrentPage(), pageVO.getPageSize(),
					tLevyfallImposingUnitMapper.countByExample(example));

			aMap.put("start_row", page.getCurrentResult());
			aMap.put("page_size", pageVO.getPageSize());

			// 放入到集合中
			list.setPage(page);
		}

		// 判断征收大厅id是否为空
		if (StrKit.isBlank(imposingUnitVO.getLevyfall_id())) {

			aMap.put("levyfall_id", imposingUnitVO.getLevyfall_id());
			
			// 查询征收大厅已挂接的执收单位信息
			List<TImposingUnit> listTImposingUnit = tImposingUnitMapper.getLevyFallImposingUnitByLevyFallId(aMap);
			
			list.setList(listTImposingUnit);
		}

		return new Results<ListVO<TImposingUnit>>(list);
	}

}
