package base.bill.service.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.spr.contents.msg.Contents;
import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TBillInfoMaintainExample;
import base.bill.entity.TBillManagementExample;
import base.bill.entity.TBillZgMaintain;
import base.bill.entity.TDemandNote;
import base.bill.entity.TDemandNoteExample;
import base.bill.entity.TDemandNoteExample.Criteria;
import base.bill.entity.vo.NotaxProjectVO;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TDemandNoteVO;
import base.bill.mapper.TDemandNoteMapper;
import base.bill.service.TDemandNoteService;
import base.bill.util.HttpRequest;
import base.bill.util.HttpRequest.Http;
import base.bill.util.LogManage;

/**
 * 
 * @类描述： 一般缴款信息服务实现（直接缴款服务和汇缴服务）
 * @项目名称：base_bill_service
 * @包名：base.bill.serviceImpl
 * @类名称：TDemandNoteServiceImpl
 * @创建人：wangp
 * @创建时间：2018年8月13日
 */
@SuppressWarnings("unused")
@Service
public class TDemandNoteServiceImpl implements TDemandNoteService{
	@Autowired
	private TDemandNoteMapper tDemandNoteMapper;
	
    @Autowired
	private RestTemplate restTemplate;
	/**
	 *@类描述 新增一般缴款信息单（直接缴款）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：insertTDemandNote
	 */
	@Override
	public Results<Object> insertTDemandNote(TDemandNote tDemandNote) {

		// 操作类
		TDemandNoteExample example = new TDemandNoteExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		// 添加操作
		tDemandNote.setSource_payment_mode(0);//0显示为 来源：直接缴款服务
		tDemandNoteMapper.insertSelective(tDemandNote);

		return new Results<Object>(Contents.ERROR_00);

	}
	/**
	 *@类描述：条件查询  查询所有 一般缴款书的信息
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：getTDemandNoteList
	 * @创建人wangp
	 * @创建时间2018-08-13
	 */
	@Override
	public Results<ListVO<TDemandNote>> getTDemandNoteList(TDemandNoteVO tDemandNoteVO,PageVO pageVo) {
		ListVO<TDemandNote> list = new ListVO<TDemandNote>();
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		// 根据前端传的值添加条件
		if (tDemandNoteVO != null) {
			//开票起止日期
			if (tDemandNoteVO.getStart_date() != null && tDemandNoteVO.getEnd_date() != null) {
				Calendar c = Calendar.getInstance();  
				c.setTime(tDemandNoteVO.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andBill_dateBetween(tDemandNoteVO.getStart_date(), c.getTime());
			}
			//起止号码
			if (tDemandNoteVO.getBill_no_start() != null && !tDemandNoteVO.getBill_no_start().equals("") && tDemandNoteVO.getBill_no_end() != null  && !tDemandNoteVO.getBill_no_end().equals("")) {
				createCriteria.andBill_noBetween(tDemandNoteVO.getBill_no_start(),tDemandNoteVO.getBill_no_end());
			}
			//缴款人全称
			if (tDemandNoteVO.getPayer_name() != null&& !tDemandNoteVO.getPayer_name().equals("")) {
				createCriteria.andPayer_nameEqualTo(tDemandNoteVO.getPayer_name());
			}
			//项目名称
			if (tDemandNoteVO.getIncome_project_name() != null&& !tDemandNoteVO.getIncome_project_name().equals("")) {
				createCriteria.andIncome_project_nameLike("%"+tDemandNoteVO.getIncome_project_name()+"%");
			}
			//经办人名称
			if (tDemandNoteVO.getOperator() != null&& !tDemandNoteVO.getOperator().equals("")) {
				createCriteria.andOperatorEqualTo(tDemandNoteVO.getOperator());
			}
			//打印状态   是否已打印(1为打印 0为未打印)
			if (tDemandNoteVO.getPrint_state() != null && !tDemandNoteVO.getPrint_state().equals("")){
				createCriteria.andPrint_stateEqualTo(tDemandNoteVO.getPrint_state());
			}
		}
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
		//为直缴模式
		createCriteria.andSource_payment_modeEqualTo(0);	
		
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tDemandNoteMapper.countByExample(tDemandNoteExample));
			
		}
		list.setPage(page);
		// 添加排序以及分页
		tDemandNoteExample.setOrderByClause("demand_note_id asc limit "+page.getCurrentResult()+","+page.getPageSize());
		
		List<TDemandNote> listTDemandNote = tDemandNoteMapper.selectByExample(tDemandNoteExample);
		// 将查询结果包装成ListVO/map集合
		
		list.setList(listTDemandNote);
		
		return new Results<ListVO<TDemandNote>>(list);
	}
	
	/**
	 *@类描述：通过时间查询最近录入一般缴款书的信息
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：getTDemandNoteByCon
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 *
	 */
	@Override
	public Results<ListVO<TDemandNote>> getTDemandNotetimeList(TDemandNoteVO tDemandNoteVO,PageVO pageVo) {
		ListVO<TDemandNote> list = new ListVO<TDemandNote>();
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
	
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
	
		//为直缴模式
		createCriteria.andSource_payment_modeEqualTo(0);	
		
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tDemandNoteMapper.countByExample(tDemandNoteExample));
			
		}
		list.setPage(page);
		// 添加排序以及分页
		tDemandNoteExample.setOrderByClause("bill_date desc limit "+page.getCurrentResult()+","+page.getPageSize());
		
		List<TDemandNote> listTDemandNote = tDemandNoteMapper.selectByExample(tDemandNoteExample);
		// 将查询结果包装成ListVO/map集合
		
		list.setList(listTDemandNote);
		
		return new Results<ListVO<TDemandNote>>(list);
	}
	/**
	 *@类描述：查询所有一般缴款书的信息
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：getTDemandNoteByCon
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 *方法暂停使用
	 */
	/*@Override
	public Results<ListVO<TDemandNote>> getTDemandNoteByCon(TDemandNoteVO tDemandNoteVO,PageVO pageVo) {

		ListVO<TDemandNote> list = new ListVO<TDemandNote>();
		// 操作类
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		// 增加条件
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		// 根据前端传的值添加条件
				if (tDemandNoteVO != null) {
					//开票起止日期
					if (tDemandNoteVO.getStart_date() != null && tDemandNoteVO.getEnd_date() != null) {
						Calendar c = Calendar.getInstance();  
						c.setTime(tDemandNoteVO.getEnd_date());  
						//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
						LogManage.printInfo("End_date:"+c.getTime());
						createCriteria.andBill_dateBetween(tDemandNoteVO.getStart_date(), c.getTime());
					}
					//起止号码
					if (tDemandNoteVO.getBill_no_start() != null && !tDemandNoteVO.getBill_no_start().equals("") && tDemandNoteVO.getBill_no_end() != null  && !tDemandNoteVO.getBill_no_end().equals("")) {
						createCriteria.andBill_noBetween(tDemandNoteVO.getBill_no_start(),tDemandNoteVO.getBill_no_end());
					}
					//缴款人全称
					if (tDemandNoteVO.getPayer_name() != null&& !tDemandNoteVO.getPayer_name().equals("")) {
						createCriteria.andPayer_nameEqualTo(tDemandNoteVO.getPayer_name());
					}
					//项目名称
					if (tDemandNoteVO.getIncome_project_name() != null&& !tDemandNoteVO.getIncome_project_name().equals("")) {
						createCriteria.andIncome_project_nameLike("%"+tDemandNoteVO.getIncome_project_name()+"%");
					}
					//经办人名称
					if (tDemandNoteVO.getOperator() != null&& !tDemandNoteVO.getOperator().equals("")) {
						createCriteria.andOperatorEqualTo(tDemandNoteVO.getOperator());
					}
					//打印状态   是否已打印(1为打印 0为未打印)
					if (tDemandNoteVO.getPrint_state() != null && !tDemandNoteVO.getPrint_state().equals("")){
						createCriteria.andPrint_stateEqualTo(tDemandNoteVO.getPrint_state());
					}
				}
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
		//打印标记为1(已经打印)
		//createCriteria.andPrint_stateEqualTo(1);
		//为直缴模式
		createCriteria.andSource_payment_modeEqualTo(0);
		if (tDemandNoteVO.getDemand_note_id() != null) {
			createCriteria.andDemand_note_idEqualTo(tDemandNoteVO.getDemand_note_id());
		}
		// 返回page对象 分页
		Page page;
		if (pageVo==null) { 
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tDemandNoteMapper.countByExample(tDemandNoteExample));
			
		}
		// 添加排序以及分页
		tDemandNoteExample.setOrderByClause("demand_note_id asc limit "+page.getCurrentResult()+","+page.getPageSize());
		list.setPage(page);
		
		List<TDemandNote> listTDemandNote = tDemandNoteMapper.selectByExample(tDemandNoteExample);
		// 将查询结果包装成ListVO/map集合
		
		list.setList(listTDemandNote);
		
		return new Results<ListVO<TDemandNote>>(list);
	}*/
	
	/**
	 *@类描述： 打印一般缴款信息单(直接缴款) 即为修改
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：PrintTDemandNote
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 */
	@Override
	public Results<Object> printTDemandNote(TDemandNote tDemandNote) {

		// 操作类
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();

		// 增加条件
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		
		String bill_no=tDemandNote.getBill_no();
		// 判断票据号码是否存在  是否为空
		if (bill_no == null|| bill_no=="") {
			
			System.out.println("票据号码为空 请重新输入");
			
			return new Results<Object>(Contents.ERROR_308);
		
		}else if(bill_no!= null&& !bill_no.equals("")) {
			
			createCriteria.andBill_noEqualTo(tDemandNote.getBill_no());
			
		}
		// 票据维护信息
		List<TDemandNote> exists = tDemandNoteMapper.selectByExample(tDemandNoteExample);
		
		// 如果有信息
		if (exists.size() != 0) {
			// 返回有存在
			System.out.println("票据号码已存在 数据已被打印成功 不可以再次打印");
			return new Results<Object>(Contents.ERROR_308);
			
		}
		
		//如果票据单号录入正确 并且打印成功  将打印标识设置为1
		tDemandNote.setPrint_state(1);
		tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
		
		return new Results<Object>(Contents.ERROR_00);
	}
	/**
	 *@类描述：删除保存的一般缴款信息单(直接缴款)
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：deleteTDemandNote
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 */
	@Override
	public Results<Object> deleteTDemandNote(TDemandNote tDemandNote) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		Integer print_state = tDemandNote.getPrint_state();
		Integer demand_note_id =tDemandNote.getDemand_note_id();
		// 判断缴款书状态是否为已打印状态  已打印数据不能被删除
		if (print_state!=1)  {
			
			System.out.println("未打印数据  可以删除");
			
			createCriteria.andDemand_note_idEqualTo(demand_note_id);
			createCriteria.andPrint_stateEqualTo(print_state);
			
			// 删除标识设置为1
			tDemandNote.setDelete_status(1);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			
			return new Results<Object>(Contents.ERROR_00);
		}

		// 票据维护信息
		createCriteria.andDemand_note_idEqualTo(demand_note_id);
		createCriteria.andPrint_stateEqualTo(print_state);
		List<TDemandNote> exists = tDemandNoteMapper.selectByExample(tDemandNoteExample);
		
		
		// 如果有信息
		if (exists.size() != 0) {
			// 返回有存在
			System.out.println("票据 数据已被打印成功 不可以删除");
			return new Results<Object>(Contents.ERROR_308);
			
		}

		return new Results<Object>(Contents.ERROR_00);
	}
	
	/**
	 *@类描述：作废一般缴款信息单(直接缴款)
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：invalidatedTDemandNote
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 */
	@Override
	public Results<Object> invalidatedTDemandNote(TDemandNote tDemandNote) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		Integer print_state = tDemandNote.getPrint_state();//打印状态
		Integer demand_note_id =tDemandNote.getDemand_note_id();//ID
		Integer payment_state =tDemandNote.getPayment_state();//缴费状态
		Integer invalidated_state =tDemandNote.getInvalidated_state();//作废状态
		// 判断缴款书状态是否为已打印状态  已打印数据不能被删除
		if (invalidated_state==0&& print_state==0 && payment_state==0 )  {
			
			System.out.println("未打印数据并且未缴费的数据 并且未作废的数据可以作废");
			
			createCriteria.andDemand_note_idEqualTo(demand_note_id);
			createCriteria.andPrint_stateEqualTo(print_state);
			createCriteria.andPayment_stateEqualTo(payment_state);
			// 作废标识设置为1
			tDemandNote.setInvalidated_state(1);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if( invalidated_state==0&& print_state==1 && payment_state!=1 ){
			System.out.println("已打印数据 但是未缴费的数据并且未作废的数据可以作废");
			
			createCriteria.andDemand_note_idEqualTo(demand_note_id);
			createCriteria.andPrint_stateEqualTo(print_state);
			createCriteria.andPayment_stateEqualTo(payment_state);
			// 作废标识设置为1
			tDemandNote.setInvalidated_state(1);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(print_state==1 && payment_state==1 &&invalidated_state==0){
			System.out.println("票据 数据已被打印成功 并且缴费成功  不可以作废");
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(print_state==1 && payment_state==0 &&invalidated_state==1){
			System.out.println("已经作废的数据  不可以再次作废");
			return new Results<Object>(Contents.ERROR_00);
		}
		
		return new Results<Object>(Contents.ERROR_00);
}


	
	
	/**
	 *@类描述：取消作废一般缴款信息单(直接缴款)
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：cancelinvalidatedTDemandNote
	 *@创建人 wangp	
	 *@创建时间 2018-08-17
	 */
	@Override
	public Results<Object> cancelinvalidatedTDemandNote(TDemandNote tDemandNote) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		Integer invalidated_state = tDemandNote.getInvalidated_state();
	
		// 判断缴款书状态是否为已打印状态  已打印数据不能被删除
		if (invalidated_state==1)  {
			
			System.out.println("可以取消作废");
			
			createCriteria.andInvalidated_stateEqualTo(invalidated_state);
			// 作废标识设置为1
			tDemandNote.setInvalidated_state(0);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	
	/**
	 *@类描述：回执一般缴款信息单(直接缴款)
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：returnTDemandNote
	 *@创建人 wangp	
	 *@创建时间 2018-08-17
	 */
	@Override
	public Results<Object> returnTDemandNote(TDemandNote tDemandNote) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		//获取打印状态
		Integer print_state = tDemandNote.getPrint_state();
		//获取ID
		Integer demand_note_id =tDemandNote.getDemand_note_id();
		//获取缴费状态
		Integer payment_state =tDemandNote.getPayment_state();
		//获取作废状态
		Integer invalidated_state =tDemandNote.getInvalidated_state();
		//回执状态
		Integer return_state =tDemandNote.getReturn_state();
		// 判断缴款书状态是否为已打印状态  已打印数据不能被删除
		if (print_state==0 && payment_state==0 && invalidated_state==1 )  {
			
			System.out.println("未打印数据  或者未缴费的数据 或者 已作废的数据 不可以回执");
			
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(print_state==1 && payment_state==1 && invalidated_state==0 && return_state==0) {
			System.out.println("已打印数据 且缴费的数据 未作废的数据未回执的数据可以回执");
			createCriteria.andDemand_note_idEqualTo(demand_note_id);
			createCriteria.andPrint_stateEqualTo(print_state);
			createCriteria.andPayment_stateEqualTo(payment_state);
			createCriteria.andInvalidated_stateEqualTo(invalidated_state);
			createCriteria.andReturn_stateEqualTo(return_state);
			// 回执标识设置为1
			tDemandNote.setReturn_state(1);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			System.out.println("回执成功");
			return new Results<Object>(Contents.ERROR_00);
		}else if(print_state==1 && payment_state==0 && invalidated_state==0){
			System.out.println("已经打印未作废 但是未缴费的数据不可以回执 ");
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(print_state==1 && payment_state==1 && invalidated_state==0 && return_state==1){
			System.out.println("已经打印未作废 已经缴费的 已经回执的数据不可以回执 ");
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	
	/**
	 *@类描述：取消回执一般缴款信息单(直接缴款)
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteServiceImpl
	 *@方法名 ：returnTDemandNote
	 *@创建人 wangp	
	 *@创建时间 2018-08-17
	 */
	@Override
	public Results<Object> cancereturnTDemandNote(TDemandNote tDemandNote) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		Integer demand_note_id =tDemandNote.getDemand_note_id();
		Integer returnstate=tDemandNote.getReturn_state();
		// 判断缴款书状态是否为已打印状态  已打印数据不能被删除
		if (returnstate==1)  {
			
			System.out.println("可以取消回执");
			
			createCriteria.andReturn_stateEqualTo(returnstate);
			// 取消回执 将标识设置为0
			tDemandNote.setReturn_state(0);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	
	/***************************调缴款人服务 查询已经录入的缴款人信息***************************************************/
	/**
	 * @throws IOException 
	 * 
	 * @描述: 调用缴款人服务接口 通过缴款人姓名作为条件查出缴款人主信息
	 * @方法名: getTContinbutorsList
	 * @param bill_name
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	@Override
	public String getTContinbutorsList(String t_full_contributors_name) {
		String sendHttp = "没有调通缴款人服务接口";
		try {
			JSONObject parseObject = JSONObject.parseObject("{\"t_full_contributors_name\":\""+t_full_contributors_name+"\"}");
			sendHttp = HttpRequest.sendHttp(Http.POST,"http://192.168.1.14:8081/tContinbutors/getTContinbutors", parseObject.toJSONString());
		} catch (IOException e) {
			System.out.println(sendHttp);
		}
		return sendHttp;
	}
	
	/**
	 * @throws IOException 
	 * 
	 * @描述: 调用缴款人服务接口缴款人姓名 账号  开户银行 录入缴款人主信息
	 * @方法名: insertTContinbutors
	 * @param bill_name
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018年8月13
	 * @since
	 * @throws
	 */
	@Override
	public Results<Object> insertTDemandNotes(TDemandNoteVO tDemandNotevo) {
		String sendHttp = "录入数据失败";
		String url ="http://192.168.1.14:8081/tContinbutors/insertTContinbutorss";
		try {
			JSONObject parseObject = JSONObject.parseObject("{\"tDemandNotevo\":\""+tDemandNotevo+"\"}");
			sendHttp = HttpRequest.sendHttp(Http.POST,url, parseObject.toJSONString());
		} catch (IOException e) {
			System.out.println(sendHttp);
		}
		return null;
	}
}