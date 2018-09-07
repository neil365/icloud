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

import com.spr.contents.msg.Contents;
import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;
import base.bill.service.NotaxProjectService;
import base.bill.entity.TBudgetKindMoney;
import base.bill.entity.TBudgetKindMoneyExample;
import base.bill.entity.TImposingUnit;
import base.bill.entity.TImposingUnitExample;
import base.bill.entity.TImposingUnitNproject;
import base.bill.entity.TImposingUnitNprojectExample;
import base.bill.entity.TNotaxProject;
import base.bill.entity.TNotaxProjectExample;
import base.bill.entity.TNotaxProjectExample.Criteria;
import base.bill.entity.vo.NotaxProjectVO;
import base.bill.entity.vo.PageVO;
import base.bill.mapper.TBudgetKindMoneyMapper;
import base.bill.mapper.TImposingUnitNprojectMapper;
import base.bill.mapper.TNotaxProjectMapper;
import base.bill.util.StrKit;

/**
 * 
 * @类描述：非税项目业务层实现
 * @项目名称：base_bill_service 
 * @包名： base.bill.service.Impl
 * @类名称：FinancialServiceImpl
 * @创建人：wangp
 * @创建时间：2018年5月9日上午10:42:49
 * @修改人：wangp
 * @修改时间：2018年5月9日上午10:42:49 
 * @修改备注：
 */
@SuppressWarnings("unused")
@Service
public class NotaxProjectServiceImpl implements NotaxProjectService {

	@Autowired
	private TNotaxProjectMapper tNotaxProjectMapper;
	@Autowired
	private TImposingUnitNprojectMapper tImposingUnitNprojectMapper;
	@Autowired
	TBudgetKindMoneyMapper tBudgetKindMoneyMapper;
	
	private List<TNotaxProject> tree(Integer parent_id, List<TNotaxProject> rootTNotaxProject,	
			Map<Integer, String> mapTImposingUnitNproject, Map<Integer, TBudgetKindMoney> mapTBudgetKindMoney) {
		// 获取子级
		return menu(parent_id, rootTNotaxProject, mapTImposingUnitNproject, mapTBudgetKindMoney);
	}

	// 创建树形结构
	private List<TNotaxProject> buildTree(Integer parent_id, NotaxProjectVO notaxProjectVO, Page page) {

		// 操作类
		TNotaxProjectExample example = new TNotaxProjectExample();

		Criteria createCriteria = example.createCriteria();

		// 添加未删除，开启， 父id为0条件
		createCriteria.andDelete_statusEqualTo(0);
		createCriteria.andParent_idEqualTo(0);

		if (page != null) {
			example.setOrderByClause(
					"notax_project_id desc limit " + page.getCurrentResult() + "," + page.getPageSize());
		}

		// 全部数据
		List<TNotaxProject> rootTNotaxProject = tNotaxProjectMapper.selectByExample(example);

		// 获取当前页数据的子级
		List<TNotaxProject> listTNotaxProject = getChildren(rootTNotaxProject);

		// 执收单位与非税项目信息
		Map<Integer, String> mapTImposingUnitNproject = selectedTImposingUnitNproject(notaxProjectVO);

		// 查询所有的收入类款
		Map<Integer, TBudgetKindMoney> mapTBudgetKindMoney = findAllMapTBudgetKindMoney();

		// 树形结构
		List<TNotaxProject> treeList = tree(parent_id, listTNotaxProject, mapTImposingUnitNproject,
				mapTBudgetKindMoney);

		return treeList;
	}

	// 子级中的所有数据
	private List<TNotaxProject> getChildren(List<TNotaxProject> rootTNotaxProject) {

		List<Integer> ids = new ArrayList<Integer>();

		// 操作类
		TNotaxProjectExample example = new TNotaxProjectExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 删除不能为0
		createCriteria.andDelete_statusEqualTo(0);

		if (rootTNotaxProject.size() != 0 && rootTNotaxProject != null) {
			// 向集合中添加非税id
			for (TNotaxProject tNotaxProject : rootTNotaxProject) {
				ids.add(tNotaxProject.getNotax_project_id());
			}

			// 非空验证
			if (ids.size() != 0 && ids != null) {
				createCriteria.andParent_idIn(ids);
				example.or().andNotax_project_idIn(ids);
			}
		}

		// 获取数据
		List<TNotaxProject> listTNotaxProject = tNotaxProjectMapper.selectByExample(example);

		return listTNotaxProject;
	}

	@Override
	public Results<ListVO<TNotaxProject>> getNotaxProjectList(NotaxProjectVO notaxProjectVO, PageVO pageVO) {
		
		ListVO<TNotaxProject> list = new ListVO<TNotaxProject>();

		// 操作类
		TNotaxProjectExample example = new TNotaxProjectExample();

		// 条件
		Criteria createCriteria = example.createCriteria();

		// 增加条件
		createCriteria.andDelete_statusEqualTo(0);
		createCriteria.andParent_idEqualTo(0);

		Page page;

		if (pageVO == null) {
			page = new Page();
		} else {
			page = new Page(pageVO.getCurrentPage(), pageVO.getPageSize(), tNotaxProjectMapper.countByExample(example));

			// 放入到集合中
			list.setPage(page);
		}

		// 创建非税项目树形结构
		List<TNotaxProject> rootTNotaxProject = buildTree(0, notaxProjectVO, page);

		list.setList(rootTNotaxProject);

		return new Results<ListVO<TNotaxProject>>(list);
	}

	// 所有类款ID与名称对照表
	private Map<Integer, TBudgetKindMoney> findAllMapTBudgetKindMoney() {
		Map<Integer, TBudgetKindMoney> mapTBudgetKindMoney = new HashMap<Integer, TBudgetKindMoney>();
		TBudgetKindMoneyExample example = new TBudgetKindMoneyExample();
		example.createCriteria().andDelete_statusEqualTo(0);

		// 获取所有收入类款信息
		List<TBudgetKindMoney> listTBudgetKindMoney = tBudgetKindMoneyMapper.selectByExample(example);
		for (TBudgetKindMoney b : listTBudgetKindMoney) {
			mapTBudgetKindMoney.put(b.getBudget_kind_money_id(), b);
		}

		return mapTBudgetKindMoney;
	}

	// 执收单位与项目挂接数据
	private Map<Integer, String> selectedTImposingUnitNproject(NotaxProjectVO notaxProjectVO) {
		TImposingUnitNprojectExample example2 = new TImposingUnitNprojectExample();

		// 非空校验
		if (notaxProjectVO.getCapital_property() != null) {
			example2.createCriteria().andImposing_unit_idEqualTo(notaxProjectVO.getImposing_unit_id())
					.andCapital_propertyEqualTo(notaxProjectVO.getCapital_property());
		} else {
			example2.createCriteria().andImposing_unit_idEqualTo(notaxProjectVO.getImposing_unit_id());
		}

		List<TImposingUnitNproject> listTImposingUnitNproject = tImposingUnitNprojectMapper.selectByExample(example2);

		// 封装一个执收单位的所有项目集合
		Map<Integer, String> mapTImposingUnitNproject = new HashMap<Integer, String>();
		for (TImposingUnitNproject u : listTImposingUnitNproject) {
			mapTImposingUnitNproject.put(u.getNotax_project_id(), u.getNotax_project_id() + "-" + u.getCapital_property());
		}
		
		return mapTImposingUnitNproject;
	}

	/**
	 * 获取子级
	 *
	 * @param rootFinancial
	 * @throws Exception
	 */
	private List<TNotaxProject> menu(Integer parent_id, List<TNotaxProject> rootTNotaxProject,
			Map<Integer, String> mapTImposingUnitNproject, Map<Integer, TBudgetKindMoney> mapTBudgetKindMoney) {
		List<TNotaxProject> subList = new ArrayList<TNotaxProject>();
		for (TNotaxProject tTNotaxProject : rootTNotaxProject) {

			// 父级id相等
			if (tTNotaxProject.getParent_id() == parent_id) {

				tTNotaxProject.setCode_name(
						tTNotaxProject.getNon_taxproject_code() + " " + tTNotaxProject.getNon_taxproject_name());

				// 如果存在，将非税项目的选中状态修改为true
				if (mapTImposingUnitNproject.get(tTNotaxProject.getNotax_project_id()) != null) {
					
					String capital_property = mapTImposingUnitNproject.get(tTNotaxProject.getNotax_project_id()).split("-")[1];
					
					tTNotaxProject.setCapital_property(Integer.parseInt(capital_property));
					
					tTNotaxProject.setStatus(true);
				}
				
				// 如果票种存在，将票种信息加入到实体类中
				if (mapTBudgetKindMoney.get(tTNotaxProject.getBudget_kind_money_id()) != null) {
					tTNotaxProject
							.settBudgetKindMoney(mapTBudgetKindMoney.get(tTNotaxProject.getBudget_kind_money_id()));

					// 收入类款编码与名称拼接
					tTNotaxProject.gettBudgetKindMoney()
							.setBudgetKindMoney_code_name(tTNotaxProject.gettBudgetKindMoney().getKindmoney_code() + " "
									+ tTNotaxProject.gettBudgetKindMoney().getKindmoney_name());
				}
				
				// 遍历子级
				tTNotaxProject.setChildren(menu(tTNotaxProject.getNotax_project_id(), rootTNotaxProject,
						mapTImposingUnitNproject, mapTBudgetKindMoney));

				subList.add(tTNotaxProject);
			}

		}
		return subList;
	}

	@Override
	public Results<ListVO<TNotaxProject>> getNotaxProjectByCon(NotaxProjectVO notaxProjectVO) {

		ListVO<TNotaxProject> list = new ListVO<TNotaxProject>();

		// 操作类
		TNotaxProjectExample example = new TNotaxProjectExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 非空校验
		if (notaxProjectVO.getNotax_project_id() != null) {
			createCriteria.andNotax_project_idEqualTo(notaxProjectVO.getNotax_project_id());
		}

		// 获取非税项目数据
		List<TNotaxProject> rootNotaxProject = tNotaxProjectMapper.selectByExample(example);

		// 放入到ListVO集合中
		list.setList(rootNotaxProject);

		return new Results<ListVO<TNotaxProject>>(list);
	}

	@Override
	public Results<Object> updateNotaxProject(TNotaxProject tNotaxProject) {
		
		// 修改
		tNotaxProjectMapper.updateByPrimaryKeySelective(tNotaxProject);

		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<Object> insertNotaxProject(TNotaxProject tNotaxProject) {

		// 操作类
		TNotaxProjectExample example = new TNotaxProjectExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();

		// 判断财政编码是否存在
		if (tNotaxProject.getNon_taxproject_code() != null) {
			createCriteria.andNon_taxproject_codeEqualTo(tNotaxProject.getNon_taxproject_code());
		}

		// 查询是财政编码和财政名称是否存在
		List<TNotaxProject> exists = tNotaxProjectMapper.selectByExample(example);

		if (exists.size() != 0) {
			return new Results<Object>(Contents.ERROR_306);
		}

		// 如果父级id为空，默认设置为0
		if (tNotaxProject.getParent_id() == null) {
			tNotaxProject.setParent_id(0);
		}

		// 默认是开启的
		tNotaxProject.setIs_use(1);

		// 添加操作
		tNotaxProjectMapper.insertSelective(tNotaxProject);

		return new Results<Object>(Contents.ERROR_00);

	}

	@Override
	public Results<Object> deleteNotaxProject(TNotaxProject tNotaxProject) {
		// 将删除标记设置为1
		tNotaxProject.setDelete_status(1);

		tNotaxProjectMapper.updateByPrimaryKeySelective(tNotaxProject);

		return new Results<Object>(Contents.ERROR_00);
	}

	/**
	 *
	 * @描述:财政信息导出到Excel @方法名: toNotaxProjectExcel @param response @param request
	 * @返回类型 void @创建人 wangp @创建时间 2018年5月9日下午6:12:10 @修改人 wangp @修改时间
	 *       2018年5月9日下午6:12:10 @修改备注 @since @throws
	 */
	@Override
	public void toNotaxProjectExcel(HttpServletResponse response) {

		try {


			// 操作类
			TNotaxProjectExample example = new TNotaxProjectExample();

			example.createCriteria().andDelete_statusEqualTo(0);

			// 全部数据
			List<TNotaxProject> rootTNotaxProject = tNotaxProjectMapper.selectByExample(example);

			// 获取子级
			menu(0, rootTNotaxProject, new HashMap(), new HashMap());

			// 创建list集合
			List<TNotaxProject> subNotaxProject = new ArrayList<TNotaxProject>();

			// 遍历集合
			for (int i = 0; i < rootTNotaxProject.size(); i++) {
				TNotaxProject f = rootTNotaxProject.get(i);

				// 添加到集合中
				subNotaxProject.add(f);

				if (f.getChildren() != null) {
					for (int j = 0; j < f.getChildren().size(); j++) {
						TNotaxProject fi = f.getChildren().get(j);
						subNotaxProject.add(fi);
					}
				}
			}

			// 文档类型
			response.setHeader("content-type", "text/html;charset=UTF-8");
			// 字符
			response.setCharacterEncoding("utf-8");

			// 设置头部
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String("非税项目".getBytes("utf-8"), "iso8859-1") + ".xls");

			// 创建表格对象
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), TNotaxProject.class, rootTNotaxProject);

			workbook.write(response.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Results<Object> updateNotaxProjectIsUse(TNotaxProject tNotaxProject) {

		Map<String, Object> aMap = new HashMap<String, Object>();

		// 判断是否为空
		if (StrKit.notBlank(String.valueOf(tNotaxProject.getNotax_project_id()))
				&& StrKit.notBlank(String.valueOf(tNotaxProject.getIs_use()))) {

			aMap.put("parent_id", tNotaxProject.getNotax_project_id());

			List<TNotaxProject> rootTNotaxProject = tNotaxProjectMapper.getNotaxProjectByParentId(aMap);

			// 获取子级
			menu(tNotaxProject.getNotax_project_id(), rootTNotaxProject, null, null);

			// 创建list集合
			List<TNotaxProject> subTNotaxProject = new ArrayList<TNotaxProject>();

			// 遍历集合
			for (int i = 0; i < rootTNotaxProject.size(); i++) {
				TNotaxProject f = rootTNotaxProject.get(i);

				// 添加到subImposingUnit集合中
				subTNotaxProject.add(f);

				// 判断是否有子级
				if (f.getChildren() != null) {
					for (int j = 0; j < f.getChildren().size(); j++) {
						TNotaxProject fi = f.getChildren().get(j);
						subTNotaxProject.add(fi);
					}
				}
			}

			if (subTNotaxProject.size() != 0 && subTNotaxProject != null) {
				// 修改子级中信息的是否启用
				for (TNotaxProject imposingUnit : subTNotaxProject) {

					TNotaxProject t = new TNotaxProject();
					t.setNotax_project_id(tNotaxProject.getNotax_project_id());
					t.setIs_use(tNotaxProject.getIs_use());

					tNotaxProjectMapper.updateNotaxProjectIsUse(t);
				}

			}

			// 没有子级，直接修改父级是否启用
			TNotaxProject tNProject = new TNotaxProject();
			tNProject.setIs_use(tNotaxProject.getIs_use());
			tNProject.setNotax_project_id(tNotaxProject.getNotax_project_id());
			tNotaxProjectMapper.updateNotaxProjectIsUse(tNProject);
		}
		return new Results<Object>(Contents.ERROR_00);
	}

	@Override
	public Results<ListVO<TNotaxProject>> getNotaxProjectNode(NotaxProjectVO notaxProjectVO) {
		ListVO<TNotaxProject> list = new ListVO<TNotaxProject>();

		// 操作类
		TNotaxProjectExample example = new TNotaxProjectExample();

		// 条件
		Criteria createCriteria = example.createCriteria();
		
		// 存放父节点 
		List<TNotaxProject> rootTNotaxProject = new ArrayList<TNotaxProject>();

		// 存放子节点
		List<TNotaxProject> subTNotaxProject = new ArrayList<TNotaxProject>();

		List<TNotaxProject> node = new ArrayList<TNotaxProject>();
		
		// 执收单位与非税项目信息
		Map<Integer, String> mapTImposingUnitNproject = selectedTImposingUnitNproject(notaxProjectVO);

		// 非税项目id是否为空
		if (notaxProjectVO.getNotax_project_id() == null) {
			
			// 增加条件
			createCriteria.andDelete_statusEqualTo(0);
			createCriteria.andParent_idEqualTo(0);
			
			// 存放父节点
		    rootTNotaxProject = tNotaxProjectMapper.selectByExample(example);

			// 遍历父节点
			for (TNotaxProject tNotaxProject : rootTNotaxProject) {

				// 子节点
				subTNotaxProject = getChildrens(tNotaxProject.getNotax_project_id());

				// 编码与非税项目名称拼接
				tNotaxProject.setCode_name(
						tNotaxProject.getNon_taxproject_code() + " " + tNotaxProject.getNon_taxproject_name());
				
				// 非空校验
				if (mapTImposingUnitNproject.get(tNotaxProject.getNotax_project_id()) != null) {
					// 如果执收单位与非税项目挂接，将status改为true
					tNotaxProject.setStatus(true);
				}

				// 是否有子节点
				if (subTNotaxProject.size() > 0) {

					tNotaxProject.setLoading(false);
//					tNotaxProject.setDisabled(true);
				} else {

					TNotaxProject t = new TNotaxProject();

					t.setNotax_project_id(tNotaxProject.getNotax_project_id());

					node.add(t);

					tNotaxProject.setChildren(node);
				}
			}

		} else {

			// 执收单位id
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(notaxProjectVO.getNotax_project_id());

			TNotaxProjectExample example1 = new TNotaxProjectExample();

			Criteria criteria = example1.createCriteria();
			criteria.andDelete_statusEqualTo(0);

			// 条件执收单位id和父id
			criteria.andParent_idIn(ids);

			// 查询子节点
			rootTNotaxProject = tNotaxProjectMapper.selectByExample(example1);
			
			for (TNotaxProject tNotaxProject : rootTNotaxProject) {
				
				subTNotaxProject = getChildrens(tNotaxProject.getNotax_project_id());
					
				// 编码与非税项目名称拼接
				tNotaxProject.setCode_name(
						tNotaxProject.getNon_taxproject_code() + " " + tNotaxProject.getNon_taxproject_name());
				
				// 非空校验
				if (mapTImposingUnitNproject.get(tNotaxProject.getNotax_project_id()) != null) {
					
					// 如果执收单位与非税项目挂接，将status改为true
					tNotaxProject.setStatus(true);
				}
				
				// 判断是否有子集
				if (subTNotaxProject.size() > 0) {
					tNotaxProject.setLoading(false);
					
				} else {
					
					TNotaxProject t = new TNotaxProject();

					t.setNotax_project_id(tNotaxProject.getNotax_project_id());

					node.add(t);

					tNotaxProject.setChildren(node);
				}
			}
		}

		list.setList(rootTNotaxProject);

		return new Results<ListVO<TNotaxProject>>(list);
	}

	/**
	 * 
	 * @描述: 查询子节点 
	 * @方法名: getChildrens 
	 * @param notax_project_id 
	 * @return 
	 * @返回类型 List<TNotaxProject> 
	 * @创建人 wangp 
	 * @创建时间 2018-8-18
	 * @修改备注 
	 * @since 
	 * @throws
	 */
	private List<TNotaxProject> getChildrens(Integer notax_project_id) {

		List<Integer> ids = new ArrayList<Integer>();

		ids.add(notax_project_id);

		TNotaxProjectExample example = new TNotaxProjectExample();

		Criteria criteria = example.createCriteria();
		criteria.andDelete_statusEqualTo(0);

		// 条件执收单位id和父id
		criteria.andParent_idIn(ids);

		// 查询子节点
		return tNotaxProjectMapper.selectByExample(example);
	}

	@Override
	public Results<ListVO<TNotaxProject>> getImposingUnitNotaxProjectByUnitId(NotaxProjectVO notaxProjectVO, PageVO pageVO) {
		
		ListVO<TNotaxProject> list = new ListVO<TNotaxProject>();
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		
		// 操作类
		TImposingUnitNprojectExample example = new TImposingUnitNprojectExample();
		
		// 增加条件执收单位id
		example.createCriteria().andImposing_unit_idEqualTo(notaxProjectVO.getImposing_unit_id());
		
		Page page;
		
		// 非空校验
		if (pageVO == null) {
			page = new Page();
		} else {
			page = new Page(pageVO.getCurrentPage(), pageVO.getPageSize(), tImposingUnitNprojectMapper.countByExample(example));
			
			aMap.put("start_row", page.getCurrentResult());
			aMap.put("page_size", pageVO.getPageSize());
			
			// 放入到集合中
			list.setPage(page);
		}
		
		// 判断执收单位id是否为空
		if (StrKit.isBlank(notaxProjectVO.getImposing_unit_id())) {
			
			aMap.put("imposing_unit_id", notaxProjectVO.getImposing_unit_id());
			
			// 查询执收单位已挂接的非税项目信息
			List<TNotaxProject> listTNotaxProject = tNotaxProjectMapper.getImposingUnitNotaxProjectByUnitId(aMap);
			
			list.setList(listTNotaxProject);
		}
		
		return new Results<ListVO<TNotaxProject>>(list);
	}
	
	
}
