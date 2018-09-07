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
import base.bill.entity.TBillPplicationDestruction;
import base.bill.entity.TBillPplicationDestructionExample;
import base.bill.entity.TBillPplicationDestructionExample.Criteria;
import base.bill.entity.TBillPplicationDestructionMingxi;
import base.bill.entity.TBillPplicationDestructionMingxiExample;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TBillPplicationDestructionVO;
import base.bill.mapper.TBillPplicationDestructionMapper;
import base.bill.mapper.TBillPplicationDestructionMingxiMapper;
import base.bill.service.TBillPplicationDestructionService;
import base.bill.util.LogManage;
@SuppressWarnings("unused")
@Service
public class TBillPplicationDestructionServiceImpl implements TBillPplicationDestructionService{
	
	@Autowired
	private TBillPplicationDestructionMapper tBillPplicationDestructionMapper;
	@Autowired
	private TBillPplicationDestructionMingxiMapper tBillPplicationDestructionmingxiMapper;
	/**
	 *@类描述 票据销毁申请（新增）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：insertTBillPplicationDestruction
	 */
	@Override
	public Results<Object> insertTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction) {
		
		//操作类
		TBillPplicationDestructionExample tBillPplicationDestructionexample=new TBillPplicationDestructionExample();
		//增加条件
		Criteria createCriteria = tBillPplicationDestructionexample.createCriteria();
		//生成销毁申请单号
		SimpleDateFormat  sdf= new SimpleDateFormat("yyyy");//获取系统当前年份
        Date date = new Date();
		String applicant_number="陕财票销"+ "["+sdf.format(date)+"]"+System.currentTimeMillis()+"号";
		tBillPplicationDestruction.setApplicant_number(applicant_number);
		//新增操作
		tBillPplicationDestructionMapper.insertSelective(tBillPplicationDestruction);
		//返回结果
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据销毁申请（根据条件查询）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：getTTBillPplicationDestructionBycon
	 */
	/*@Override
	public Results<ListVO> getTTBillPplicationDestructionBycon(TBillPplicationDestructionVO tBillPplicationDestructionvo, PageVO pageVo) {
		//操作类
		TBillPplicationDestructionExample tBillPplicationDestructionexample=new TBillPplicationDestructionExample();
		//增加条件
		Criteria createCriteria = tBillPplicationDestructionexample.createCriteria();
		
		// 根据前端传的值添加条件（申请日期   财政审核状态）
		if (tBillPplicationDestructionvo != null) {
			//申请日期
			if (tBillPplicationDestructionvo.getStart_date() != null && tBillPplicationDestructionvo.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(tBillPplicationDestructionvo.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andApplicant_timeBetween(tBillPplicationDestructionvo.getStart_date(), c.getTime());
			}
			//经办人
			if (tBillPplicationDestructionvo.getJbr() != null && !tBillPplicationDestructionvo.getJbr().equals("")) {
				createCriteria.andOperatorEqualTo(tBillPplicationDestructionvo.getJbr());
			}
		}
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
			
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tBillPplicationDestructionMapper.countByExample(tBillPplicationDestructionexample));
		}
		// 添加排序以及分页
		tBillPplicationDestructionexample.setOrderByClause("id desc limit "+page.getCurrentResult()+","+page.getPageSize());
		
		List<TBillPplicationDestruction> listTBillPplicationDestruction = tBillPplicationDestructionMapper.selectByExample(tBillPplicationDestructionexample);
		// 将查询结果包装成ListVO/map集合
		ListVO map = new ListVO();
		map.put("page", page);
		map.put("listTBillPplicationDestruction",listTBillPplicationDestruction);
		
		return new Results<ListVO>(map);
	}*/
	/**
	 *@类描述 票据销毁申请（查询所有/根据条件查询）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：getTBillPplicationDestructionList
	 */
	@Override
	public Results<ListVO<TBillPplicationDestruction>> getTBillPplicationDestructionList(TBillPplicationDestructionVO tBillPplicationDestructionvo,PageVO pageVo) {
		//操作类
		TBillPplicationDestructionExample tBillPplicationDestructionexample=new TBillPplicationDestructionExample();
		//增加条件
		Criteria createCriteria = tBillPplicationDestructionexample.createCriteria();
		ListVO<TBillPplicationDestruction> list=new ListVO<TBillPplicationDestruction>();
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
		// 根据前端传的值添加条件（申请日期   财政审核状态）
		if (tBillPplicationDestructionvo != null) {
			//申请日期
			if (tBillPplicationDestructionvo.getStart_date() != null && tBillPplicationDestructionvo.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(tBillPplicationDestructionvo.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andApplicant_timeBetween(tBillPplicationDestructionvo.getStart_date(), c.getTime());
			}
			//经办人
			if (tBillPplicationDestructionvo.getJbr() != null && !tBillPplicationDestructionvo.getJbr().equals("")) {
				createCriteria.andOperatorEqualTo(tBillPplicationDestructionvo.getJbr());
			}
		}	
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tBillPplicationDestructionMapper.countByExample(tBillPplicationDestructionexample));
		}
		list.setPage(page);
		// 添加排序以及分页
		tBillPplicationDestructionexample.setOrderByClause("id desc limit "+page.getCurrentResult()+","+page.getPageSize());
		
		List<TBillPplicationDestruction> listTBillPplicationDestruction = tBillPplicationDestructionMapper.selectByExample(tBillPplicationDestructionexample);
		// 将查询结果包装成ListVO/map集合
		list.setList(listTBillPplicationDestruction);
		return new Results<ListVO<TBillPplicationDestruction>>(list);
	}
	/**
	 *@类描述 票据销毁申请（修改）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：updateTBillPplicationDestruction
	 */
	@Override
	public Results<Object> updateTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction) {
		//操作类
		TBillPplicationDestructionExample tBillPplicationDestructionexample=new TBillPplicationDestructionExample();
		//增加条件
		Criteria createCriteria = tBillPplicationDestructionexample.createCriteria();
		
		tBillPplicationDestructionMapper.updateByPrimaryKeySelective(tBillPplicationDestruction);
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据销毁申请（删除）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：deleteTBillPplicationDestruction
	 */
	@Override
	public Results<Object> deleteTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction) {

		//操作类
		TBillPplicationDestructionExample tBillPplicationDestructionexample=new TBillPplicationDestructionExample();
		//增加条件
		Criteria createCriteria = tBillPplicationDestructionexample.createCriteria();
		
		Integer id=tBillPplicationDestruction.getId();
		
		Integer report_status=tBillPplicationDestruction.getReport_status();
		//判断上报状态 （已经上报的则不能删除）
		if (report_status!=1)  {
			
			System.out.println("未上报数据 可以删除");
			
			createCriteria.andIdEqualTo(id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			// 删除标识设置为1
			tBillPplicationDestruction.setDelete_status(1);
			
			tBillPplicationDestructionMapper.updateByPrimaryKeySelective(tBillPplicationDestruction);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(report_status==1) {
			System.out.println("已经上报的数据不可以删除");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据销毁申请（上报）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：reportTBillPplicationDestruction
	 */
	@Override
	public Results<Object> reportTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction) {
		
		//操作类
		TBillPplicationDestructionExample tBillPplicationDestructionexample=new TBillPplicationDestructionExample();
		//增加条件
		Criteria createCriteria = tBillPplicationDestructionexample.createCriteria();
		
		Integer id=tBillPplicationDestruction.getId();
		
		Integer report_status=tBillPplicationDestruction.getReport_status();
		
		if(report_status!=1) {
			System.out.println("可以上报");
			createCriteria.andIdEqualTo(id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			// 上报标识设置为1
			tBillPplicationDestruction.setReport_status(1);
			
			tBillPplicationDestructionMapper.updateByPrimaryKeySelective(tBillPplicationDestruction);
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(report_status==1) {
			System.out.println("已经上报的数据 不可以再次上报");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据销毁申请（取消上报）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：cancereportTBillPplicationDestruction
	 */
	@Override
	public Results<Object> cancereportTBillPplicationDestruction(TBillPplicationDestruction tBillPplicationDestruction) {
		
		//操作类
		TBillPplicationDestructionExample tBillPplicationDestructionexample=new TBillPplicationDestructionExample();
		//增加条件
		Criteria createCriteria = tBillPplicationDestructionexample.createCriteria();
		
		Integer id=tBillPplicationDestruction.getId();
		
		Integer report_status=tBillPplicationDestruction.getReport_status();
		
		if(report_status!=1) {
			System.out.println("未上报的数据  不可以上报");
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(report_status==1) {
			System.out.println("已经上报的数据 可以取消上报");
			createCriteria.andIdEqualTo(id);
			
			createCriteria.andReport_statusEqualTo(report_status);
			
			
			// 上报标识设置为0
			tBillPplicationDestruction.setReport_status(0);
			
			tBillPplicationDestructionMapper.updateByPrimaryKeySelective(tBillPplicationDestruction);
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}

	/***********************************票据销毁申请 明细*************************************************/
	/**
	 *@类描述 票据销毁申请明细（新增）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：insertTBillPplicationDestructionmingxi
	 */
	@Override
	public Results<Object> insertTBillPplicationDestructionmingxi(TBillPplicationDestructionMingxi tBillPplicationDestructionmingxi) {
		//操作类
		TBillPplicationDestructionMingxiExample tBillPplicationDestructionmingxiexample=new TBillPplicationDestructionMingxiExample();
		//增加条件
		base.bill.entity.TBillPplicationDestructionMingxiExample.Criteria createCriteria = tBillPplicationDestructionmingxiexample.createCriteria();
		
		//新增操作
		tBillPplicationDestructionmingxiMapper.insertSelective(tBillPplicationDestructionmingxi);
		//返回结果
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述 票据销毁申请明细（删除）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TBillPplicationDestructionServiceImpl
	 *@方法名 ：deleteTBillPplicationDestructionmingxi
	 */
	@Override
	public Results<Object> deleteTBillPplicationDestructionmingxi(TBillPplicationDestructionMingxi tBillPplicationDestructionmingxi) {
		//操作类
		TBillPplicationDestructionMingxiExample tBillPplicationDestructionmingxiexample=new TBillPplicationDestructionMingxiExample();
		//增加条件
		base.bill.entity.TBillPplicationDestructionMingxiExample.Criteria createCriteria = tBillPplicationDestructionmingxiexample.createCriteria();
		// 删除标识设置为1
		tBillPplicationDestructionmingxi.setDelete_status(1);
		
		tBillPplicationDestructionmingxiMapper.updateByPrimaryKeySelective(tBillPplicationDestructionmingxi);
		return new Results<Object>(Contents.ERROR_00);
	}

}
