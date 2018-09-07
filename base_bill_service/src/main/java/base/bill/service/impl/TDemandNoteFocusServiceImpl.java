package base.bill.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.contents.msg.Contents;
import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;

import base.bill.entity.TBillType;
import base.bill.entity.TBillTypeExample;
import base.bill.entity.TDemandNote;
import base.bill.entity.TDemandNoteExample;
import base.bill.entity.TDemandNoteExample.Criteria;
import base.bill.entity.TDemandNoteHz;
import base.bill.entity.TDemandNoteHzExample;
import base.bill.entity.vo.PageVO;
import base.bill.entity.vo.TDemandNoteHzVO;
import base.bill.entity.vo.TDemandNoteVO;
import base.bill.mapper.TDemandNoteHzMapper;
import base.bill.mapper.TDemandNoteMapper;
import base.bill.service.TDemandNoteFocusService;
import base.bill.util.LogManage;

/**
 * 
 * @类描述： 一般缴款信息服务实现（汇缴服务）
 * @项目名称：base_bill_service
 * @包名：base.bill.serviceImpl
 * @类名称：TDemandNoteFocusServiceImpl
 * @创建人：wangp
 * @创建时间：2018年8月13日
 */
@SuppressWarnings("unused")
@Service
public class TDemandNoteFocusServiceImpl implements TDemandNoteFocusService{
	@Autowired
	private TDemandNoteMapper tDemandNoteMapper;
	@Autowired
	private TDemandNoteHzMapper tDemandNoteHzMapper;
	/**
	 *@类描述 新增 （保存）一般缴款信息单（汇缴服务）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：insertTDemandNoteFocus
	 */
	@Override
	public Results<Object> insertTDemandNoteFocus(TDemandNote tDemandNote) {

		// 操作类
		TDemandNoteExample example = new TDemandNoteExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		
		// 添加操作
		tDemandNote.setSource_payment_mode(2);//2显示为 来源：汇缴服务
		
		tDemandNoteMapper.insertSelective(tDemandNote);

		return new Results<Object>(Contents.ERROR_00);

	}
	
	/**
	 *@类描述： 打印一般缴款信息单（汇缴服务） 
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：printTDemandNoteFocus
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 */
	@Override
	public Results<Object> printTDemandNoteFocus(TDemandNote tDemandNote) {

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
	 *@类描述：需要进行汇缴明细列表 默认为未打印数据    根据条件参数查询 或者无参数 查询所有汇缴明细数据 列表(汇缴服务)
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：getTDemandNoteFocusList
	 * @创建人wangp	
	 * @创建时间2018-08-13
	 */
	@Override
	public  Results<ListVO<TDemandNote>> getTDemandNoteFocusList(TDemandNoteVO tDemandNoteVO,PageVO pageVo) {
		ListVO<TDemandNote> list = new ListVO<TDemandNote>();
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		// 根据前端传的值添加条件
		if (tDemandNoteVO != null) {
			//开票起止日期
			if (tDemandNoteVO.getStart_date() != null && tDemandNoteVO.getEnd_date() != null && !tDemandNoteVO.getStart_date().equals("") && !tDemandNoteVO.getEnd_date().equals("")) {
				Calendar c = Calendar.getInstance();  
				c.setTime(tDemandNoteVO.getEnd_date());  
				//c.add(Calendar.SECOND, 60*60*24-1);// 今天+1天-1s
				LogManage.printInfo("End_date:"+c.getTime());
				createCriteria.andBill_dateBetween(tDemandNoteVO.getStart_date(), c.getTime());
			}
			//缴款人全称
			if (tDemandNoteVO.getPayer_name() != null&& !tDemandNoteVO.getPayer_name().equals("")) {
				createCriteria.andPayer_nameEqualTo(tDemandNoteVO.getPayer_name());
			}
			//票据名称
			if (tDemandNoteVO.getBill_name() != null&& !tDemandNoteVO.getBill_name().equals("")) {
				createCriteria.andBill_nameEqualTo(tDemandNoteVO.getBill_name());
			}
			//备注
			if (tDemandNoteVO.getMemo() != null&& !tDemandNoteVO.getMemo().equals("")) {
				createCriteria.andMemoEqualTo(tDemandNoteVO.getMemo());
			}
			//经办人
			if (tDemandNoteVO.getOperator() != null&& !tDemandNoteVO.getOperator().equals("")) {
				createCriteria.andOperatorEqualTo(tDemandNoteVO.getOperator());
			}
			//打印状态   是否已打印(1为打印 0为未打印) 
			if (tDemandNoteVO.getPrint_state() != null && !tDemandNoteVO.getPrint_state().equals("")){
				createCriteria.andPrint_stateEqualTo(tDemandNoteVO.getPrint_state());
			}
			//起止号码
			if (tDemandNoteVO.getBill_no_start() != null && !tDemandNoteVO.getBill_no_start().equals("") && tDemandNoteVO.getBill_no_end() != null  && !tDemandNoteVO.getBill_no_end().equals("")) {
				createCriteria.andBill_noBetween(tDemandNoteVO.getBill_no_start(),tDemandNoteVO.getBill_no_end());
			}
			//是否汇总
			if (tDemandNoteVO.getSummary_state() != null && !tDemandNoteVO.getSummary_state().equals("")){
				createCriteria.andSummary_stateEqualTo(tDemandNoteVO.getSummary_state());
			}
			//是否作废
			if (tDemandNoteVO.getInvalidated_state() != null && !tDemandNoteVO.getInvalidated_state().equals("")){
				createCriteria.andInvalidated_stateEqualTo(tDemandNoteVO.getInvalidated_state());
			}
		}
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
		//默认查询条件为
		createCriteria.andSource_payment_modeEqualTo(2);
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
	 *@类描述：查询一般缴款书的信息（汇缴服务）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：getTDemandNoteFocusByCon
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 */
	/*@Override
	public Results TDemandNoteFocusLists(TDemandNote tDemandNote ,PageVO pageVo) {

		ListVO<TDemandNote> list = new ListVO<TDemandNote>();
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		// 操作类
		TDemandNoteExample example = new TDemandNoteExample();

		// 增加条件
		Criteria createCriteria = example.createCriteria();
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
		//createCriteria.andPrint_stateEqualTo(1);
		//为汇缴模式状态
		createCriteria.andSource_payment_modeEqualTo(2);
		if (tDemandNote.getDemand_note_id() != null) {
			createCriteria.andDemand_note_idEqualTo(tDemandNote.getDemand_note_id());
		}
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tDemandNoteMapper.countByExample(tDemandNoteExample));
		}
		// 添加排序以及分页
		tDemandNoteExample.setOrderByClause("demand_note_id desc limit "+page.getCurrentResult()+","+page.getPageSize());

		List<TDemandNote> listTDemandNote = tDemandNoteMapper.selectByExample(tDemandNoteExample);
		// 将查询结果包装成ListVO/map集合
		ListVO map = new ListVO();
		map.put("page", page);
		map.put("demandNoteList",listTDemandNote);
		
		return new Results<ListVO>(map);
	}*/
	
	
	/**
	 *@类描述：删除保存的一般缴款信息汇缴明细单（汇缴服务）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：deleteTDemandNoteFocus
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 */
	@Override
	public Results<Object> deleteTDemandNoteFocus(TDemandNote tDemandNote) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		Integer print_state = tDemandNote.getPrint_state();
		Integer demand_note_id =tDemandNote.getDemand_note_id();
		// 判断缴款书状态是否为已打印状态  已打印数据不能被删除
		if (print_state!=1)  {
			
			System.out.println("未打印数据  可以删除");
			
			createCriteria.andDemand_note_idEqualTo(demand_note_id);
			//打印状态
			createCriteria.andPrint_stateEqualTo(print_state);
			//为汇缴模式状态
			createCriteria.andSource_payment_modeEqualTo(2);
			// 删除标识设置为1
			tDemandNote.setDelete_status(1);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(print_state==1){
			System.out.println("已打印数据  不可以删除");
			return new Results<Object>(Contents.ERROR_00);
		}

		return new Results<Object>(Contents.ERROR_00);
	}
	
	/**
	 *@类描述：作废一般缴款信息汇缴明细单（汇缴服务）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：invalidatedTDemandNoteFocus
	 *@创建人 wangp	
	 *@创建时间 2018-08-13
	 */
	@Override
	public Results<Object> invalidatedTDemandNoteFocus(TDemandNote tDemandNote) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		Integer demand_note_id =tDemandNote.getDemand_note_id();//获取前端传值（ID）
		Integer payment_state =tDemandNote.getPayment_state();//获取前端传值（交费状态）
		Integer summary_state=tDemandNote.getSummary_state();//获取前端传值（汇总状态）
		String bill_code=tDemandNote.getBill_code();//获取汇总后票据编码
		Integer invalidated_state =tDemandNote.getInvalidated_state();//作废状态
		Integer print_state = tDemandNote.getPrint_state();//打印状态
		// 判断缴款书状态未打印数据并且未缴费的数据 并且未作废的数据可以作废
		if (invalidated_state==0&& print_state==0 && payment_state==0 &&summary_state==0)  {
			 
			System.out.println("未打印数据并且未缴费的数据 并且未作废的数据可以作废");
			
			createCriteria.andDemand_note_idEqualTo(demand_note_id);
			createCriteria.andPrint_stateEqualTo(print_state);
			createCriteria.andPayment_stateEqualTo(payment_state);
			// 作废标识设置为1
			tDemandNote.setInvalidated_state(1);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if( invalidated_state==0&& print_state==1 && payment_state!=1 &&summary_state==0){
			System.out.println("已打印数据 但是未缴费的数据并且未作废的数据 未汇总的数据 可以作废");
			
			createCriteria.andDemand_note_idEqualTo(demand_note_id);
			createCriteria.andPrint_stateEqualTo(print_state);
			createCriteria.andPayment_stateEqualTo(payment_state);
			// 作废标识设置为1
			tDemandNote.setInvalidated_state(1);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(print_state==1 && payment_state==1 &&invalidated_state==0 &&summary_state==0){
			System.out.println("票据 数据已被打印成功 并且缴费成功  不可以作废");
			return new Results<Object>(Contents.ERROR_00);
		}
		else if(print_state==1 && payment_state==0 &&invalidated_state==1){
			System.out.println("已经作废的数据  不可以再次作废");
			return new Results<Object>(Contents.ERROR_00);
		}else if (summary_state==1 && payment_state==1)  {
			//已汇总的数据 已缴费的数据 不可以作废
			System.out.println("已汇总 已缴费的数据 不可以作废");
			return new Results<Object>(Contents.ERROR_00);
		}else if(summary_state==1 && payment_state!=1){
			//已汇总的数据 要作废需要先作废汇总主表数据 从表子数据才可以作废
			System.out.println("已汇总未缴费的数据 要作废需要先作废汇总主表数据 从表所有汇总子数据都将作废  确认要作废汇总表  票据编码="+bill_code);
			return new Results<Object>(Contents.ERROR_00);
		}
		
		return new Results<Object>(Contents.ERROR_00);
	}
	
	
	/**
	 *@类描述：取消作废一般缴款信息汇缴明细单（汇缴服务）
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：cancelinvalidatedTDemandNote
	 *@创建人 wangp	
	 *@创建时间 2018-08-17
	 */
	@Override
	public Results<Object> cancelinvalidatedTDemandNoteFocus(TDemandNote tDemandNote) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		Integer demand_note_id= tDemandNote.getDemand_note_id();
		Integer invalidated_state= tDemandNote.getInvalidated_state();
		
		// 判断缴款书状态是否为已作废状态  已作废数据可以被取消作废
		if (invalidated_state==1)  {
			
			System.out.println("确定要取消作废");
			
			createCriteria.andInvalidated_stateEqualTo(invalidated_state);
			createCriteria.andDemand_note_idEqualTo(demand_note_id);
			// 作废标识设置为1
			tDemandNote.setInvalidated_state(0);
			
			tDemandNoteMapper.updateByPrimaryKeySelective(tDemandNote);
			return new Results<Object>(Contents.ERROR_00);
		}
		return new Results<Object>(Contents.ERROR_00);
	}
	
/*************************************汇缴- 汇总表服务的功能实现*********************************************************/
	/**
	 *@param listId 
	 * @类描述 汇总缴款信息单（汇缴服务）修改表中的汇总状态
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：updateTDemandNoteFocus
	 */
	
	public Results<Object> updateTDemandNoteFocus(TDemandNoteVO tDemandNotevo, List list) {
		
		// 操作类
		TDemandNoteExample example = new TDemandNoteExample();
		 TDemandNote tDemandNote=new TDemandNote();
		// 增加条件
		Criteria createCriteria = example.createCriteria();
		//默认为未删除的数据
		createCriteria.andDelete_statusEqualTo(0);
		//必须为已打印数据
		createCriteria.andPrint_stateEqualTo(1);
		
		
		//根据传入的参数ID 作为条件进行修改汇总状态，和子数据的外键ID 
		createCriteria.andDemand_note_idIn(list);
		
		tDemandNote.setSummary_state(1);//汇总成功 修改汇总状态为1
		//修改票据编码和主表编码一致
		tDemandNote.setBill_code(tDemandNotevo.getBill_code());
		//修改子表数据的 多条汇总外键ID和主表主键ID一致
		tDemandNote.setId(tDemandNotevo.getId_waijianid());
		
		tDemandNoteMapper.updateByExampleSelective(tDemandNote,example);
		
		return new Results<Object>(Contents.ERROR_00);
	}
	
	/**
	 *@类描述 汇总缴款信息表（汇缴服务）新增汇总数据
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：insertTDemandNoteHzFocus
	 */
	@Override
	public Results<Object> insertTDemandNoteHzFocus(TDemandNoteHzVO tDemandNoteHzvo) {

		// 操作类
		TDemandNoteExample example = new TDemandNoteExample();
		TDemandNoteHz tDemandNoteHz =new TDemandNoteHz();
		// 增加条件
		Criteria createCriteria = example.createCriteria();
		//获取前端输入要汇总的数据ID 拿到后进行分割
		String[] ids=tDemandNoteHzvo.getId().split(",");
		//for循环遍历获取数据
		List list=new ArrayList(); 
		for(String id:ids) {
			list.add(id);
		}
		//作为List 条件传值
		createCriteria.andDemand_note_idIn(list);
		//通过条件进行数据查询
		List<TDemandNote> listtDemandNote =tDemandNoteMapper.selectByExample(example);
		 
		Integer print_state = 0;
		Integer source_payment_mode=0;
		Integer summary_state=0;
		for (TDemandNote tDemandNote : listtDemandNote) {
			print_state = tDemandNote.getPrint_state();
			source_payment_mode = tDemandNote.getSource_payment_mode();
			summary_state=tDemandNote.getSummary_state();
		}
		//System.out.println(payment_method);
		if(print_state!=1 ||source_payment_mode!=2 || summary_state!=0 ) {
			System.out.println("包含未打印数据 或者不是汇缴方式录入的数据或者是已经汇总的数据 不可以汇总");
			return new Results<Object>(Contents.ERROR_00);
		}else if(print_state==1 || source_payment_mode==2 || summary_state==0 ) {
			
			double amount_lowercase=0.0;
			//循环累计要获取的总金额
			for (TDemandNote tDemandNote : listtDemandNote) {
				amount_lowercase+=tDemandNote.getTotal_amount_lowercase().doubleValue();
			}
			//添加方法 插入值
			tDemandNoteHz.setHj_money(BigDecimal.valueOf(amount_lowercase));//总金额 
	 		tDemandNoteHz.setTz_date(new Date());//填制日期（使用当前日期）
			//生成时间戳的 票据编码
			Long bill_code=System.currentTimeMillis();
			tDemandNoteHz.setBill_code(String.valueOf(bill_code));
			//System.out.println(tDemandNoteHzMapper.insertSelective(tDemandNoteHzs));
			//tDemandNoteHz.setPayers_name("省交警总队后勤中心");
			//tDemandNoteHz.setOperator("张三");
			//tDemandNoteHz.setJk_state(1);
			/*tDemandNoteHz.setDz_state(0);
			tDemandNoteHz.setHz_state(0);
			tDemandNoteHz.setSummary_state(0);
			tDemandNoteHz.setBl_state(0);*/
			// 添加操作
			tDemandNoteHzMapper.insertSelective(tDemandNoteHz);
			
			TDemandNoteVO tDemandNotevo=new TDemandNoteVO();
			//获取汇总主表主键ID
			tDemandNotevo.setId_waijianid(tDemandNoteHz.getId());
			//获取票据编码
			tDemandNotevo.setBill_code(tDemandNoteHz.getBill_code());
			//获取前端传入的多条汇总子表的Id
			/*for (TDemandNote tDemandNote : listtDemandNote) {
				System.out.println(tDemandNote.getDemand_note_id());
			}*/
			
			System.out.println(list);
			//tDemandNoteHzvo.setId(listId);
			//调用修改子表数据的方法
			updateTDemandNoteFocus(tDemandNotevo,list);
			
			}
		
		return new Results<Object>(Contents.ERROR_00);
	}
	
	/**
	 *@类描述：集中汇缴汇总查询(汇缴服务)(默认查询已经打印 需要汇总的信息)
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：getTDemandNoteFocusList
	 * @创建人wangp	
	 * @创建时间2018-08-13
	 */
	@Override
	public  Results<ListVO<TDemandNote>> getTDemandNoteJZFocusList(TDemandNoteVO tDemandNoteVO,PageVO pageVo) {
		ListVO<TDemandNote> list = new ListVO<TDemandNote>();
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		// 根据前端传的值添加条件
		if (tDemandNoteVO != null) {
			
			//票据名称
			if (tDemandNoteVO.getBill_name() != null&& !tDemandNoteVO.getBill_name().equals("")) {
				createCriteria.andBill_nameEqualTo(tDemandNoteVO.getBill_name());
			}
			
			//委托单位（也为指定可以委托的执收单位）
			if (tDemandNoteVO.getChg_agen_name() != null&& !tDemandNoteVO.getChg_agen_name().equals("")) {
				createCriteria.andChg_agen_nameEqualTo(tDemandNoteVO.getChg_agen_name());
			}
			//缴款方式（现金 或者支票）
			if (tDemandNoteVO.getPayment_method() != null&& !tDemandNoteVO.getPayment_method().equals("")) {
				createCriteria.andPayment_methodEqualTo(tDemandNoteVO.getPayment_method());
			}
		}
		// 删除标记为0(未删除)
		createCriteria.andDelete_statusEqualTo(0);
		createCriteria.andPrint_stateEqualTo(1);
		// 返回page对象 分页
		Page page;
		if (pageVo==null) {
			page = new Page();
		}else {
			page = new Page(pageVo.getCurrentPage(), pageVo.getPageSize(), tDemandNoteMapper.countByExample(tDemandNoteExample));
		}
		// 添加排序以及分页
		tDemandNoteExample.setOrderByClause("demand_note_id desc limit "+page.getCurrentResult()+","+page.getPageSize());
		
		List<TDemandNote> listTDemandNote = tDemandNoteMapper.selectByExample(tDemandNoteExample);
		// 将查询结果包装成ListVO/map集合
		
		
		return new Results<ListVO<TDemandNote>>(list);
	}
	
	/**
	 *@类描述 汇总缴款信息表（汇缴服务）作废汇总数据
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：invalidatedTDemandNoteHzFocus
	 */
	@Override
	public Results<Object> invalidatedTDemandNoteHzFocus(TDemandNoteHz tDemandNotehz) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		TDemandNote tDemandNote=new TDemandNote();
		Integer id =tDemandNotehz.getId();//获取前端传值（ID）
		String bill_code=tDemandNotehz.getBill_code();//获取汇总的票据编码作为更新作废状态的条件
		if (bill_code!=null && !bill_code.equals(""))  {
			System.out.println("可以作废,将作废汇总表下的所有汇总数据");
			
			createCriteria.andIdEqualTo(id);
			createCriteria.andBill_codeEqualTo(bill_code);
			// 作废标识设置为1
			tDemandNotehz.setZf_state(1);
			
			tDemandNoteHzMapper.updateByPrimaryKeySelective(tDemandNotehz);
			
			createCriteria.andBill_codeEqualTo(bill_code);
			List<TDemandNote> listTDemandNotes = tDemandNoteMapper.selectByExample(tDemandNoteExample);
			List list=new ArrayList(); 
			for (TDemandNote tDemandNotes : listTDemandNotes) {
				list.add(tDemandNotes.getDemand_note_id());
				
			}
			//作为List 条件传值
			createCriteria.andDemand_note_idIn(list);
			tDemandNote.setInvalidated_state(1);
			tDemandNoteMapper.updateByExampleSelective(tDemandNote, tDemandNoteExample);
			
			return new Results<Object>(Contents.ERROR_00);
		}

		return new Results<Object>(Contents.ERROR_00);
	}
	
	/**
	 *@类描述 汇总缴款信息表（汇缴服务）删除汇总数据
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：insertTDemandNoteHzFocus
	 */
	@Override
	public Results<Object> deleteTDemandNoteHzFocus(TDemandNoteHz tDemandNotehz) {
		
		TDemandNoteHzExample tDemandNotehzExample = new TDemandNoteHzExample();
		base.bill.entity.TDemandNoteHzExample.Criteria createCriteria = tDemandNotehzExample.createCriteria();
		Integer id =tDemandNotehz.getId	();
		Integer zf_state=tDemandNotehz.getZf_state();
		if (zf_state==1)  {
			
			System.out.println("已作废数据  可以删除");
			
			createCriteria.andIdEqualTo(id);
			//作废状态
			createCriteria.andZf_stateEqualTo(zf_state);
			// 删除标识设置为1
			tDemandNotehz.setDelete_state(1);
			
			tDemandNoteHzMapper.updateByPrimaryKeySelective(tDemandNotehz);
			
			return new Results<Object>(Contents.ERROR_00);
		}else if(zf_state!=1) {
			System.out.println("未作废数据  不可以删除");
			return new Results<Object>(Contents.ERROR_00);
		}

		return new Results<Object>(Contents.ERROR_00);
	}
	
	/**
	 *@类描述 汇总缴款信息表（汇缴服务）查看汇总数据中的子表详细信息
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：getTDemandNoteHzFocusList
	 */
	@Override
	public Results getTDemandNoteHzFocusList(TDemandNoteHz tDemandNoteHz, PageVO pageVo) {
		TDemandNoteExample tDemandNoteExample = new TDemandNoteExample();
		
		Criteria createCriteria = tDemandNoteExample.createCriteria();
		
		//获取主表的bill_code
		String bill_code=tDemandNoteHz.getBill_code();
		//作为查询的条件
		createCriteria.andBill_codeEqualTo(bill_code);
		
		tDemandNoteMapper.selectByExample(tDemandNoteExample);
		
		return new Results<Object>(Contents.ERROR_00);
		
	}
	
	/**
	 *@类描述 汇总缴款信息表（汇缴服务）重新打印汇总数据列表信息
	 *@包名：base.bill.serviceImpl
	 *@类名称：TDemandNoteFocusServiceImpl
	 *@方法名 ：printTDemandNoteHzFocus
	 */
	@Override
	public Results<Object> printTDemandNoteHzFocus(TDemandNote tDemandNote) {
		return null;
	}

}
