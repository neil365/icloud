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

import base.bill.entity.TBillManagementInspection;
import base.bill.entity.TBillManagementInspectionExample;
import base.bill.entity.TBillManagementInspectionExample.Criteria;
import base.bill.entity.TBillManagementInspectionMingxi;
import base.bill.entity.TBillManagementInspectionMingxiExample;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TBillManagementInspectionVO;
import base.bill.mapper.TBillManagementInspectionMapper;
import base.bill.mapper.TBillManagementInspectionMingxiMapper;
import base.bill.service.TBillManagementInspectionService;
import base.bill.util.LogManage;
/**
 * 
 * @类描述： 票据服务实现（票据缴验）
 * @项目名称：TBillManagementInspectionService
 * @包名：base.bill.serviceImpl
 * @类名称：TBillManagementInspectionServiceImpl
 * @创建人：wangp
 * @创建时间：2018年8月28日
 */
@SuppressWarnings("unused")
@Service
public class TBillManagementInspectionServiceImpl implements TBillManagementInspectionService{
	
	@Autowired
	private TBillManagementInspectionMapper tBillManagementInspectionMapper;
	@Autowired
	private TBillManagementInspectionMingxiMapper tBillManagementInspectionMingxiMapper;
	/**
	 *@类描述 票据缴验（新增）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：insertTBillManagementInspection
	 */
	@Override
	public Results<Object> insertTBillManagementInspection(TBillManagementInspection tBillManagementInspection) {
		
		// 操作类
		TBillManagementInspectionExample example = new TBillManagementInspectionExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		//生成时间戳的 票据单号
		SimpleDateFormat  sdf= new SimpleDateFormat("yyyy");//获取系统当前年份
        Date date = new Date();
		String applicant_number="陕财票验"+ "["+sdf.format(date)+"]"+System.currentTimeMillis()+"号";
		tBillManagementInspection.setApplicant_number(applicant_number);
		
		//前端获取申请日期，缴验截止日期， 获取单位编码 单位名称 （传入参数）
		//备注（手动输入）
		// 添加操作
		tBillManagementInspectionMapper.insertSelective(tBillManagementInspection);

		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据缴验（修改）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：updateTBillManagementInspection
	 */
	@Override
	public Results<Object> updateTBillManagementInspection(TBillManagementInspection tBillManagementInspection) {
		// 操作类
		TBillManagementInspectionExample example = new TBillManagementInspectionExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		// 更新操作
		tBillManagementInspectionMapper.updateByPrimaryKeySelective(tBillManagementInspection);
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据缴验（条件查询数据）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：getTBillManagementInspectionByCon
	 */
	/*@Override
	public Results<ListVO> getTBillManagementInspectionByCon(TBillManagementInspectionVO tBillManagementInspectionvo,PageVO pageVo) {
		
		// 操作类
		TBillManagementInspectionExample example = new TBillManagementInspectionExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		// 根据前端传的值添加条件（申请日期   财政审核状态）
		if (tBillManagementInspectionvo != null) {
			//申请日期
			if (tBillManagementInspectionvo.getStart_date() != null && tBillManagementInspectionvo.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(tBillManagementInspectionvo.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andApplicant_timeBetween(tBillManagementInspectionvo.getStart_date(), c.getTime());
			}
			//财政审核状态
			if (tBillManagementInspectionvo.getCz_shenhe_state() != null && !tBillManagementInspectionvo.getCz_shenhe_state().equals("")) {
				createCriteria.andFinancial_examine_statusEqualTo(tBillManagementInspectionvo.getCz_shenhe_state());
			}
		}
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
			
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tBillManagementInspectionMapper.countByExample(example));
		}
		// 添加排序以及分页
		example.setOrderByClause("id desc limit "+page.getCurrentResult()+","+page.getPageSize());
		
		List<TBillManagementInspection> listTBillManagementInspection = tBillManagementInspectionMapper.selectByExample(example);
		// 将查询结果包装成ListVO/map集合
		ListVO map = new ListVO();
		map.put("page", page);
		map.put("tBillManagementInspection",listTBillManagementInspection);
		
		return new Results<ListVO>(map);
	}*/
	/**
	 *@类描述 票据缴验（查询所有数据）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：getTBillManagementInspectionList
	 */
	@Override
	public Results<ListVO<TBillManagementInspection>> getTBillManagementInspectionList(TBillManagementInspectionVO tBillManagementInspectionvo,PageVO pageVo) {
		
		// 操作类
		TBillManagementInspectionExample example = new TBillManagementInspectionExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		ListVO<TBillManagementInspection> list=new ListVO<TBillManagementInspection>();
		
		// 根据前端传的值添加条件（申请日期   财政审核状态）
		if (tBillManagementInspectionvo != null) {
			//申请日期
			if (tBillManagementInspectionvo.getStart_date() != null && tBillManagementInspectionvo.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(tBillManagementInspectionvo.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andApplicant_timeBetween(tBillManagementInspectionvo.getStart_date(), c.getTime());
			}
			//财政审核状态
			if (tBillManagementInspectionvo.getCz_shenhe_state() != null && !tBillManagementInspectionvo.getCz_shenhe_state().equals("")) {
				createCriteria.andFinancial_examine_statusEqualTo(tBillManagementInspectionvo.getCz_shenhe_state());
			}
		}
		
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tBillManagementInspectionMapper.countByExample(example));
		}
		list.setPage(page);
		// 添加排序以及分页
		example.setOrderByClause("id desc limit "+page.getCurrentResult()+","+page.getPageSize());

		List<TBillManagementInspection> listTBillManagementInspection = tBillManagementInspectionMapper.selectByExample(example);
		// 将查询结果包装成ListVO/map集合
		list.setList(listTBillManagementInspection);
		
		return new Results<ListVO<TBillManagementInspection>>(list);
	}
	/**
	 *@类描述 票据缴验（删除数据）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：deleteTBillManagementInspection
	 */
	@Override
	public Results<Object> deleteTBillManagementInspection(TBillManagementInspection tBillManagementInspection) {

		//操作类
		TBillManagementInspectionExample example = new TBillManagementInspectionExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		Integer id=tBillManagementInspection.getId();
		
		Integer report_status=tBillManagementInspection.getReport_status();
		//判断上报状态 （已经上报的则不能删除）
		if (report_status!=1)  {
			
			System.out.println("未上报数据 可以删除");
			
			createCriteria.andIdEqualTo(id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			// 删除标识设置为1
			tBillManagementInspection.setDelete_status(1);
			
			tBillManagementInspectionMapper.updateByPrimaryKeySelective(tBillManagementInspection);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(report_status==1) {
			System.out.println("已经上报的数据不可以删除");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据缴验 （上报）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：reportTBillManagementInspection
	 */
	@Override
	public Results<Object> reportTBillManagementInspection(TBillManagementInspection tBillManagementInspection) {
		
		//操作类
		TBillManagementInspectionExample example = new TBillManagementInspectionExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		Integer id=tBillManagementInspection.getId();
		
		Integer report_status=tBillManagementInspection.getReport_status();
		
		if(report_status!=1) {
			System.out.println("可以上报");
			createCriteria.andIdEqualTo(id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			// 上报标识设置为1
			tBillManagementInspection.setReport_status(1);
			
			tBillManagementInspectionMapper.updateByPrimaryKeySelective(tBillManagementInspection);
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(report_status==1) {
			System.out.println("已经上报的数据 不可以再次上报");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据缴验（取消上报）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：cancereportTBillManagementInspection
	 */
	@Override
	public Results<Object> cancereportTBillManagementInspection(TBillManagementInspection tBillManagementInspection) {
		
		//操作类
		TBillManagementInspectionExample example = new TBillManagementInspectionExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		Integer id=tBillManagementInspection.getId();
		
		Integer report_status=tBillManagementInspection.getReport_status();
		
		if(report_status!=1) {
			System.out.println("未上报的数据  不可以上报");
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(report_status==1) {
			System.out.println("已经上报的数据 可以取消上报");
			createCriteria.andIdEqualTo(id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			
			// 上报标识设置为0
			tBillManagementInspection.setReport_status(0);
			
			tBillManagementInspectionMapper.updateByPrimaryKeySelective(tBillManagementInspection);
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	
	/***********************************票据缴验申请 明细*************************************************/
	
	/**
	 *@类描述 票据缴验明细（新增）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：insertTBillManagementInspectionmingxi
	 */
	@Override
	public Results<Object> insertTBillManagementInspectionmingxi(TBillManagementInspectionMingxi tTBillManagementInspectionMingxi) {
		// 操作类
		TBillManagementInspectionMingxiExample examples = new TBillManagementInspectionMingxiExample();

		// 增加条件
		base.bill.entity.TBillManagementInspectionMingxiExample.Criteria createCriteria = examples.createCriteria();
		
		// 添加操作
		tBillManagementInspectionMingxiMapper.insertSelective(tTBillManagementInspectionMingxi);

		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据缴验明细（修改）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillManagementInspectionServiceImpl
	 *@方法名 ：updateTBillManagementInspectionmingxi
	 */
	@Override
	public Results<Object> updateTBillManagementInspectionmingxi(TBillManagementInspectionMingxi tTBillManagementInspectionMingxi) {

		// 操作类
		TBillManagementInspectionMingxiExample examples = new TBillManagementInspectionMingxiExample();

		// 增加条件
		base.bill.entity.TBillManagementInspectionMingxiExample.Criteria createCriteria = examples.createCriteria();
				
		// 添加操作
		tBillManagementInspectionMingxiMapper.updateByPrimaryKeySelective(tTBillManagementInspectionMingxi);

		return new Results<Object>(Contents.ERROR_00);
	}

}
