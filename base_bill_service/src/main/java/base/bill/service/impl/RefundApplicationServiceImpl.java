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

import base.bill.entity.RefundApplication;
import base.bill.entity.RefundApplicationExample;
import base.bill.entity.RefundApplicationExample.Criteria;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.RefundApplicationVO;
import base.bill.mapper.RefundApplicationMapper;
import base.bill.service.RefundApplicationService;
import base.bill.util.LogManage;

/**
 * @描述: 退付申请管理
 * @包名:base.bill.service.impl
 * @类名: RefundApplicationServiceImpl
 * @创建人 wangp
 * @创建时间 2018年9月4日
 */
@Service
public class RefundApplicationServiceImpl implements RefundApplicationService{
	@Autowired
	private RefundApplicationMapper refundApplicationMapper;
	
	/**
	 * @描述: 退付申请管理（新增）（不可重复新增）
	 * @方法名: insertRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> insertRefundApplication(RefundApplication refundApplication) {
		 // 操作类
		RefundApplicationExample refundApplicationexample = new RefundApplicationExample();

		// 增加条件
		Criteria createCriteria = refundApplicationexample.createCriteria();
		
		//生成时间戳的 退付单号
		SimpleDateFormat  sdf= new SimpleDateFormat("yyyy");//获取系统当前年份
        Date date = new Date();
		String refund_number="退付"+ "["+sdf.format(date)+"]"+System.currentTimeMillis()+"号";
		refundApplication.setRefund_number(refund_number);
		
		//获取录入的票据编号
		String bill_number=refundApplication.getBill_number();
		//判断新增的票据编号是否存在
		if (bill_number == null|| bill_number=="") {
			
			System.out.println("票据号码为空 请重新输入");
			
			return new Results<Object>(Contents.ERROR_00);
		
		}else if(bill_number!= null&& !bill_number.equals("")) {
			System.out.println("正常 非已经录入的票据编号 可以新增");
			createCriteria.andBill_numberEqualTo(bill_number);
			
		}
		// 票据维护信息
		List<RefundApplication> exists = refundApplicationMapper.selectByExample(refundApplicationexample);
		
		// 如果有信息
		if (exists.size() != 0) {
			// 返回有存在
			System.out.println("票据号码已存在 不允许重新新增");
			return new Results<Object>(Contents.ERROR_308);
			
		}
		// 添加操作
		refundApplicationMapper.insertSelective(refundApplication);

		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 退付申请管理（查询所有/条件查询）
	 * @方法名: getRefundApplicationList
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<ListVO<RefundApplication>> getRefundApplicationList(RefundApplicationVO refundApplicationvo,
			PageVO pageVo) {
		// 操作类
		RefundApplicationExample refundApplicationexample = new RefundApplicationExample();

		// 增加条件
		Criteria createCriteria = refundApplicationexample.createCriteria();
		
		ListVO<RefundApplication> list=new ListVO<RefundApplication>();
		
		// 根据前端传的值添加条件（申请日期   财政审核状态）
		if (refundApplicationvo != null) {
			//申请日期
			if (refundApplicationvo.getStart_date() != null && refundApplicationvo.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(refundApplicationvo.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andApplication_dateBetween(refundApplicationvo.getStart_date(), c.getTime());
			}
			//审核状态
			if (refundApplicationvo.getAudit_state() != null && !refundApplicationvo.getAudit_state().equals("")) {
				createCriteria.andAudit_stateEqualTo(refundApplicationvo.getAudit_state());
			}
			//上报状态
			if (refundApplicationvo.getReporte_state() != null && !refundApplicationvo.getReporte_state().equals("")) {
				createCriteria.andReporte_stateEqualTo(refundApplicationvo.getReporte_state());
			}
			//票据编号
			if (refundApplicationvo.getBill_number() != null && !refundApplicationvo.getBill_number().equals("")) {
				createCriteria.andBill_numberEqualTo(refundApplicationvo.getBill_number());
			}
		}
		
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), refundApplicationMapper.countByExample(refundApplicationexample));
		}
		list.setPage(page);
		// 添加排序以及分页
		refundApplicationexample.setOrderByClause("id desc limit "+page.getCurrentResult()+","+page.getPageSize());

		List<RefundApplication> listRefundApplication = refundApplicationMapper.selectByExample(refundApplicationexample);
		// 将查询结果包装成ListVO/map集合
		list.setList(listRefundApplication);
		
		return new Results<ListVO<RefundApplication>>(list);
	}
	/**
	 * @描述: 退付申请管理（删除）
	 * @方法名: deleteRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> deleteRefundApplication(RefundApplication refundApplication) {

		// 操作类
		RefundApplicationExample refundApplicationexample = new RefundApplicationExample();

		// 增加条件
		Criteria createCriteria = refundApplicationexample.createCriteria();
		
		Integer report_status=refundApplication.getReporte_state();
		//判断上报状态 （已经上报的则不能删除）
		if (report_status!=1)  {
			
			System.out.println("未上报数据 可以删除");
			
			createCriteria.andReporte_stateEqualTo(report_status);
			
			// 删除标识设置为1
			refundApplication.setDelete_state(1);
			// 更新操作
			refundApplicationMapper.updateByPrimaryKeySelective(refundApplication);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(report_status==1) {
			System.out.println("已经上报的数据不可以删除");
			return new Results<Object>(Contents.ERROR_00);
		}
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 退付申请管理（修改）
	 * @方法名: updateRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> updateRefundApplication(RefundApplication refundApplication) {
		
		// 操作类
		RefundApplicationExample refundApplicationexample = new RefundApplicationExample();

		// 增加条件
		Criteria createCriteria = refundApplicationexample.createCriteria();
		// 更新操作
		refundApplicationMapper.updateByPrimaryKeySelective(refundApplication);
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 退付申请管理（上报）
	 * @方法名: reportRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> reportRefundApplication(RefundApplication refundApplication) {

		// 操作类
		RefundApplicationExample refundApplicationexample = new RefundApplicationExample();

		// 增加条件
		Criteria createCriteria = refundApplicationexample.createCriteria();
		
		Integer reporte_state=refundApplication.getReporte_state();
		
		if(reporte_state!=1) {
			System.out.println("可以上报");
			
			createCriteria.andReporte_stateEqualTo(reporte_state);
			
			// 上报标识设置为1
			refundApplication.setReporte_state(1);
			
			refundApplicationMapper.updateByPrimaryKeySelective(refundApplication);
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(reporte_state==1) {
			System.out.println("已经上报的数据 不可以再次上报");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 * @描述: 退付申请管理（取消上报）
	 * @方法名: cancereportRefundApplication
	 * @param refundApplication
	 * @return
	 * @throws Exception
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年9月4日
	 */
	@Override
	public Results<Object> cancereportRefundApplication(RefundApplication refundApplication) {

		// 操作类
		RefundApplicationExample refundApplicationexample = new RefundApplicationExample();

		// 增加条件
		Criteria createCriteria = refundApplicationexample.createCriteria();
		
		Integer reporte_state=refundApplication.getReporte_state();
		
		if(reporte_state!=1) {
			System.out.println("未上报的数据  不可以上报");
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(reporte_state==1) {
			System.out.println("已经上报的数据 可以取消上报");
			
			createCriteria.andReporte_stateEqualTo(reporte_state);
			
			// 上报标识设置为0
			refundApplication.setReporte_state(0);
			
			refundApplicationMapper.updateByPrimaryKeySelective(refundApplication);
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}

}
