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

import base.bill.entity.TEmporaryGuaranteeApplication;
import base.bill.entity.TEmporaryGuaranteeApplicationExample;
import base.bill.entity.TEmporaryGuaranteeApplicationExample.Criteria;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TEmporaryGuaranteeApplicationVO;
import base.bill.mapper.TEmporaryGuaranteeApplicationMapper;
import base.bill.service.TEmporaryGuaranteeApplicationService;
import base.bill.util.LogManage;
/**
 * @描述: 暂保押申请信息管理
 * @包名:base.bill.service.impl
 * @类名: TEmporaryGuaranteeApplicationServiceImpl
 * @创建人 wangp
 * @创建时间 2018年9月4日
 */
@Service
public class TEmporaryGuaranteeApplicationServiceImpl implements TEmporaryGuaranteeApplicationService{

	@Autowired
	private TEmporaryGuaranteeApplicationMapper tEmporaryGuaranteeApplicationMapper;
	
	/**
	 * @描述: 暂保押申请信息管理（新增）（不可重复新增）
	 * @方法名: insertTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> insertTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		
		 // 操作类
		TEmporaryGuaranteeApplicationExample tEmporaryGuaranteeApplicationexample = new TEmporaryGuaranteeApplicationExample();

		// 增加条件
		Criteria createCriteria = tEmporaryGuaranteeApplicationexample.createCriteria();
		
		//生成时间戳的 退付单号
		SimpleDateFormat  sdf= new SimpleDateFormat("yyyy");//获取系统当前年份
        Date date = new Date();
		String application_temporary_number="暂保押"+ "["+sdf.format(date)+"]"+System.currentTimeMillis()+"号";
		tEmporaryGuaranteeApplication.setApplication_temporary_number(application_temporary_number);
		
		//获取录入的票据编号
		String bill_number=tEmporaryGuaranteeApplication.getBill_number();
		//判断新增的票据编号是否存在
		if (bill_number == null|| bill_number=="") {
			
			System.out.println("票据号码为空 请重新输入");
			
			return new Results<Object>(Contents.ERROR_00);
		
		}else if(bill_number!= null&& !bill_number.equals("")) {
			System.out.println("正常 非已经录入的票据编号 可以新增");
			createCriteria.andBill_numberEqualTo(bill_number);
			
		}
		// 票据维护信息
		List<TEmporaryGuaranteeApplication> exists = tEmporaryGuaranteeApplicationMapper.selectByExample(tEmporaryGuaranteeApplicationexample);
		
		// 如果有信息
		if (exists.size() != 0) {
			// 返回有存在
			System.out.println("票据号码已存在 不允许重新新增");
			return new Results<Object>(Contents.ERROR_308);
			
		}
		// 添加操作
		tEmporaryGuaranteeApplicationMapper.insertSelective(tEmporaryGuaranteeApplication);

		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 暂保押申请信息管理（修改）
	 * @方法名: updateTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> updateTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		
		// 操作类
		TEmporaryGuaranteeApplicationExample tEmporaryGuaranteeApplicationexample = new TEmporaryGuaranteeApplicationExample();
	
		// 增加条件
		Criteria createCriteria = tEmporaryGuaranteeApplicationexample.createCriteria();
		// 更新操作
		tEmporaryGuaranteeApplicationMapper.updateByPrimaryKeySelective(tEmporaryGuaranteeApplication);
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 暂保押申请信息管理（删除）
	 * @方法名: deleteTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> deleteTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		
		// 操作类
		TEmporaryGuaranteeApplicationExample tEmporaryGuaranteeApplicationexample = new TEmporaryGuaranteeApplicationExample();
	
		// 增加条件
		Criteria createCriteria = tEmporaryGuaranteeApplicationexample.createCriteria();
		
		Integer report_status=tEmporaryGuaranteeApplication.getReporte_state();
		//判断上报状态 （已经上报的则不能删除）
		if (report_status!=1)  {
			
			System.out.println("未上报数据 可以删除");
			
			createCriteria.andReporte_stateEqualTo(report_status);
			
			// 删除标识设置为1
			tEmporaryGuaranteeApplication.setDelete_state(1);
			// 更新操作
			tEmporaryGuaranteeApplicationMapper.updateByPrimaryKeySelective(tEmporaryGuaranteeApplication);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(report_status==1) {
			System.out.println("已经上报的数据不可以删除");
			return new Results<Object>(Contents.ERROR_00);
		}
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 暂保押申请信息管理（上报）
	 * @方法名: reportTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> reportTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		// 操作类
		TEmporaryGuaranteeApplicationExample tEmporaryGuaranteeApplicationexample = new TEmporaryGuaranteeApplicationExample();
	
		// 增加条件
		Criteria createCriteria = tEmporaryGuaranteeApplicationexample.createCriteria();
		
		Integer reporte_state=tEmporaryGuaranteeApplication.getReporte_state();
		
		if(reporte_state!=1) {
			System.out.println("可以上报");
			
			createCriteria.andReporte_stateEqualTo(reporte_state);
			
			// 上报标识设置为1
			tEmporaryGuaranteeApplication.setReporte_state(1);
			
			tEmporaryGuaranteeApplicationMapper.updateByPrimaryKeySelective(tEmporaryGuaranteeApplication);
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(reporte_state==1) {
			System.out.println("已经上报的数据 不可以再次上报");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 暂保押申请信息管理（取消上报）
	 * @方法名: cancereportTEmporaryGuaranteeApplication
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> cancereportTEmporaryGuaranteeApplication(TEmporaryGuaranteeApplication tEmporaryGuaranteeApplication) {
		// 操作类
		TEmporaryGuaranteeApplicationExample tEmporaryGuaranteeApplicationexample = new TEmporaryGuaranteeApplicationExample();
	
		// 增加条件
		Criteria createCriteria = tEmporaryGuaranteeApplicationexample.createCriteria();
		
		Integer reporte_state=tEmporaryGuaranteeApplication.getReporte_state();
		
		if(reporte_state!=1) {
			System.out.println("未上报的数据  不可以上报");
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(reporte_state==1) {
			System.out.println("已经上报的数据 可以取消上报");
			
			createCriteria.andReporte_stateEqualTo(reporte_state);
			
			// 上报标识设置为0
			tEmporaryGuaranteeApplication.setReporte_state(0);
			
			tEmporaryGuaranteeApplicationMapper.updateByPrimaryKeySelective(tEmporaryGuaranteeApplication);
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 暂保押申请信息管理（查询所有/条件查询）
	 * @方法名: getTEmporaryGuaranteeApplicationList
	 * @param tEmporaryGuaranteeApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<ListVO<TEmporaryGuaranteeApplication>> getTEmporaryGuaranteeApplicationList(TEmporaryGuaranteeApplicationVO tEmporaryGuaranteeApplicationvo,PageVO pageVo) {
		
		// 操作类
		TEmporaryGuaranteeApplicationExample tEmporaryGuaranteeApplicationexample = new TEmporaryGuaranteeApplicationExample();
	
		// 增加条件
		Criteria createCriteria = tEmporaryGuaranteeApplicationexample.createCriteria();
		
		ListVO<TEmporaryGuaranteeApplication> list=new ListVO<TEmporaryGuaranteeApplication>();
		
		// 根据前端传的值添加条件（申请日期   财政审核状态）
		if (tEmporaryGuaranteeApplicationvo != null) {
			//申请日期
			if (tEmporaryGuaranteeApplicationvo.getStart_date() != null && tEmporaryGuaranteeApplicationvo.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(tEmporaryGuaranteeApplicationvo.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andApplication_dateBetween(tEmporaryGuaranteeApplicationvo.getStart_date(), c.getTime());
			}
			//审核状态
			if (tEmporaryGuaranteeApplicationvo.getAudit_state() != null && !tEmporaryGuaranteeApplicationvo.getAudit_state().equals("")) {
				createCriteria.andAudit_stateEqualTo(tEmporaryGuaranteeApplicationvo.getAudit_state());
			}
			//上报状态
			if (tEmporaryGuaranteeApplicationvo.getReporte_state() != null && !tEmporaryGuaranteeApplicationvo.getReporte_state().equals("")) {
				createCriteria.andReporte_stateEqualTo(tEmporaryGuaranteeApplicationvo.getReporte_state());
			}
			//票据编号
			if (tEmporaryGuaranteeApplicationvo.getBill_number() != null && !tEmporaryGuaranteeApplicationvo.getBill_number().equals("")) {
				createCriteria.andBill_numberEqualTo(tEmporaryGuaranteeApplicationvo.getBill_number());
			}
		}
		
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tEmporaryGuaranteeApplicationMapper.countByExample(tEmporaryGuaranteeApplicationexample));
		}
		list.setPage(page);
		// 添加排序以及分页
		tEmporaryGuaranteeApplicationexample.setOrderByClause("id desc limit "+page.getCurrentResult()+","+page.getPageSize());

		List<TEmporaryGuaranteeApplication> listTEmporaryGuaranteeApplication = tEmporaryGuaranteeApplicationMapper.selectByExample(tEmporaryGuaranteeApplicationexample);
		// 将查询结果包装成ListVO/map集合
		list.setList(listTEmporaryGuaranteeApplication);
		
		return new Results<ListVO<TEmporaryGuaranteeApplication>>(list);
		
	}

}
