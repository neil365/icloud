package base.bill.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.contents.msg.Contents;
import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillManagement;
import base.bill.entity.TBillManagementExample;
import base.bill.entity.TDemandNote;
import base.bill.entity.TDemandNoteExample;
import base.bill.entity.TBillManagementExample.Criteria;
import base.bill.entity.TBillManagementMingxi;
import base.bill.entity.TBillManagementMingxiExample;
import base.bill.entity.TBillTypeExample;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TBillManagementVO;
import base.bill.mapper.TBillManagementMapper;
import base.bill.mapper.TBillManagementMingxiMapper;
import base.bill.service.BillManagementService;
import base.bill.util.LogManage;
/**
 * 
 * @类描述： 票据息服务实现（票据领购申请）
 * @项目名称：BillManagementService
 * @包名：base.bill.serviceImpl
 * @类名称：BillManagementServiceImpl
 * @创建人：wangp
 * @创建时间：2018年8月27日
 */
@SuppressWarnings("unused")
@Service
public class BillManagementServiceImpl implements BillManagementService{
	
	@Autowired
	private TBillManagementMapper tBillManagementMapper;
	
	@Autowired
	private TBillManagementMingxiMapper tBillManagementMingxiMapper;
	
	/**
	 *@类描述 票据领购申请（新增）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：insertTDemandNoteDT
	 */
	@Override
	public Results<Object> insertBillManagement(TBillManagement billManagement) {
		
		// 操作类
		TBillManagementExample example = new TBillManagementExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		//生成时间戳的 票据单号
		SimpleDateFormat  sdf= new SimpleDateFormat("yyyy");//获取系统当前年份
        Date date = new Date();
		String applicant_danhao="陕财票购"+ "["+sdf.format(date)+"]"+System.currentTimeMillis()+"号";
		billManagement.setApplicant_danhao(applicant_danhao);
		
		tBillManagementMapper.insertSelective(billManagement);

		return new Results<Object>(Contents.ERROR_00);
		
	}
	/**
	 *@类描述 票据领购申请（修改）
	 *@包名：base.bill.serviceImpl
	 *@类名称：BillManagementServiceImpl
	 *@方法名 ：updateBillManagement
	 */
	@Override
	public Results<Object> updateBillManagement(TBillManagement billManagement) {
		
		// 操作类
		TBillManagementExample tBillManagementexample = new TBillManagementExample();
		
		// 增加条件
		Criteria createCriteria = tBillManagementexample.createCriteria();

		tBillManagementMapper.updateByPrimaryKeySelective(billManagement);

		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据领购申请（根据条件查询数据）
	 *@包名：base.bill.serviceImpl
	 *@类名称：BillManagementServiceImpl
	 *@方法名 ：getBillManagementByCon
	 */
	/*@Override
	public Results<ListVO> getBillManagementByCon(TBillManagementVO billManagementvo, PageVO pageVo) {
	
		TBillManagementExample tBillManagementexample = new TBillManagementExample();
		
		Criteria createCriteria = tBillManagementexample.createCriteria();
		// 根据前端传的值添加条件
		if (billManagementvo != null) {
			//申请日期
			if (billManagementvo.getStart_date() != null && billManagementvo.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(billManagementvo.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andApplicant_timeBetween(billManagementvo.getStart_date(), c.getTime());
			}
			//财政审核状态
			if (billManagementvo.getCz_shenhe_state() != null && !billManagementvo.getCz_shenhe_state().equals("")) {
				createCriteria.andFinancial_examine_statusEqualTo(billManagementvo.getCz_shenhe_state());
			}
			
		}
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
			
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tBillManagementMapper.countByExample(tBillManagementexample));
		}
		// 添加排序以及分页
		tBillManagementexample.setOrderByClause("bill_management_id desc limit "+page.getCurrentResult()+","+page.getPageSize());
		
		List<TBillManagement> listTBillManagement = tBillManagementMapper.selectByExample(tBillManagementexample);
		// 将查询结果包装成ListVO/map集合
		ListVO map = new ListVO();
		map.put("page", page);
		map.put("tBillManagement",listTBillManagement);
		
		return new Results<ListVO>(map);
	}*/
	/**
	 *@类描述 票据领购申请（根据条件查询数据/查询所有数据）
	 *@包名：base.bill.serviceImpl
	 *@类名称：BillManagementServiceImpl
	 *@方法名 ：getBillManagementList
	 */
	@Override
	public Results<ListVO<TBillManagement>> getBillManagementList(TBillManagementVO billManagementvo, PageVO pageVo) {
		// 操作类
		TBillManagementExample tBillManagementexample = new TBillManagementExample();
		
		ListVO<TBillManagement> list = new ListVO<TBillManagement>();
		
		// 增加条件
		Criteria createCriteria = tBillManagementexample.createCriteria();
		
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
		if (billManagementvo != null) {
			//申请日期
			if (billManagementvo.getStart_date() != null && billManagementvo.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(billManagementvo.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andApplicant_timeBetween(billManagementvo.getStart_date(), c.getTime());
			}
			//财政审核状态
			if (billManagementvo.getCz_shenhe_state() != null && !billManagementvo.getCz_shenhe_state().equals("")) {
				createCriteria.andFinancial_examine_statusEqualTo(billManagementvo.getCz_shenhe_state());
			}
			
		}
		
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tBillManagementMapper.countByExample(tBillManagementexample));
		}
		list.setPage(page);
		// 添加排序以及分页
		tBillManagementexample.setOrderByClause("bill_management_id asc limit "+page.getCurrentResult()+","+page.getPageSize());

		List<TBillManagement> listTBillManagement = tBillManagementMapper.selectByExample(tBillManagementexample);
		// 将查询结果包装成ListVO/map集合
		list.setList(listTBillManagement);
		
		return new Results<ListVO<TBillManagement>>(list);
	}
	
	/**
	 *@类描述 票据领购申请（删除数据）
	 *@包名：base.bill.serviceImpl
	 *@类名称：BillManagementServiceImpl
	 *@方法名 ：deleteBillManagement
	 */
	@Override
	public Results<Object> deleteBillManagement(TBillManagement billManagement) {
		
		// 操作类
		TBillManagementExample tBillManagementexample = new TBillManagementExample();
		
		// 增加条件
		Criteria createCriteria = tBillManagementexample.createCriteria();
		
		Integer bill_management_id=billManagement.getBill_management_id();
		
		Integer report_status=billManagement.getReport_status();
		//判断上报状态 （已经上报的则不能删除）
		if (report_status!=1)  {
			
			System.out.println("未上报数据 可以删除");
			
			createCriteria.andBill_management_idEqualTo(bill_management_id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			// 删除标识设置为1
			billManagement.setDelete_status(1);
			
			tBillManagementMapper.updateByPrimaryKeySelective(billManagement);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(report_status==1) {
			System.out.println("已经上报的数据不可以删除");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	
	
	/**
	 *@类描述 票据领购申请（上报）
	 *@包名：base.bill.serviceImpl
	 *@类名称：BillManagementServiceImpl
	 *@方法名 ：getBillManagementList
	 */
	@Override
	public Results<Object> reportBillManagement(TBillManagement billManagement) {
		
		// 操作类
		TBillManagementExample tBillManagementexample = new TBillManagementExample();
		
		// 增加条件
		Criteria createCriteria = tBillManagementexample.createCriteria();
		
		Integer bill_management_id=billManagement.getBill_management_id();
		
		Integer report_status=billManagement.getReport_status();
		
		if(report_status!=1) {
			System.out.println("可以上报");
			createCriteria.andBill_management_idEqualTo(bill_management_id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			// 上报标识设置为1
			billManagement.setReport_status(1);
			
			tBillManagementMapper.updateByPrimaryKeySelective(billManagement);
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(report_status==1) {
			System.out.println("已经上报的数据 不可以再次上报");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	
	
	/**
	 *@类描述 票据领购申请（取消上报）
	 *@包名：base.bill.serviceImpl
	 *@类名称：BillManagementServiceImpl
	 *@方法名 ：getBillManagementList
	 */
	@Override
	public Results<Object> cancereportBillManagement(TBillManagement billManagement) {
		
		// 操作类
		TBillManagementExample tBillManagementexample = new TBillManagementExample();
		
		// 增加条件
		Criteria createCriteria = tBillManagementexample.createCriteria();
		
		Integer bill_management_id=billManagement.getBill_management_id();
		
		Integer report_status=billManagement.getReport_status();
		
		if(report_status!=1) {
			System.out.println("未上报的数据  不可以上报");
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(report_status==1) {
			System.out.println("已经上报的数据 可以取消上报");
			createCriteria.andBill_management_idEqualTo(bill_management_id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			
			// 上报标识设置为0
			billManagement.setReport_status(0);
			
			tBillManagementMapper.updateByPrimaryKeySelective(billManagement);
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	
	/***********************************票据领购申请 明细*************************************************/
	
	/**
	 *@类描述 票据领购申请 明细（新增）
	 *@包名：base.bill.serviceImpl
	 *@类名称：BillManagementServiceImpl
	 *@方法名 ：insertBillManagementmingxi
	 */
	@Override
	public Results<Object> insertBillManagementmingxi(TBillManagementMingxi billManagementMingxi) {
		
		// 操作类
		TBillManagementMingxiExample examples = new TBillManagementMingxiExample();

		// 增加条件
		base.bill.entity.TBillManagementMingxiExample.Criteria createCriteria = examples.createCriteria();
		
		// 添加操作
		tBillManagementMingxiMapper.insertSelective(billManagementMingxi);

		return new Results<Object>(Contents.ERROR_00);
		
	}
	
	/**
	 *@类描述 票据领购申请 明细（修改）
	 *@包名：base.bill.serviceImpl
	 *@类名称：BillManagementServiceImpl
	 *@方法名 ：updateBillManagementmingxi
	 */
	@Override
	public Results<Object> updateBillManagementmingxi(TBillManagementMingxi billManagementMingxi) {
		
		// 操作类
		TBillManagementMingxiExample examples = new TBillManagementMingxiExample();

		// 增加条件
		base.bill.entity.TBillManagementMingxiExample.Criteria createCriteria = examples.createCriteria();
		
		// 添加操作
		tBillManagementMingxiMapper.updateByPrimaryKeySelective(billManagementMingxi);

		return new Results<Object>(Contents.ERROR_00);
		
	}
}
