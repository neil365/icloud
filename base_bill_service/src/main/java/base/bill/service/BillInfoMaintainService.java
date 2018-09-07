package base.bill.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TBillType;
import base.bill.entity.TBudgetKindMoney;
import base.bill.entity.vo.BillInfoMaintainVO;
import base.bill.entity.vo.PageVO;


/**
 * 
 * @类描述：票据信息维护业务层接口
 * @项目名称：base_bill_service
 * @包名： base.bill.service
 * @类名称：IFinancialService
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
public interface BillInfoMaintainService {
	
	/**
	 *  
	 * @描述: 获取票据信息维护
	 * @方法名: getBillInfoMaintainList
	 * @param billInfoMaintainVO
	 * @param pageVo
	 * @return
	 * @返回类型 Results<ListVO<BillInfoMaintain>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TBillInfoMaintain>> getBillInfoMaintainList(BillInfoMaintainVO billInfoMaintainVO, PageVO pageVO);
	
	
	/**
	 * 
	 * @描述: 获取票据信息树形结构
	 * @方法名: getBillInfoMaintainTreeList
	 * @param billInfoMaintainVO
	 * @return
	 * @返回类型 Results<ListVO<TBillInfoMaintain>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
//	public Results<ListVO<TBillInfoMaintain>> getBillInfoMaintainTreeList(BillInfoMaintainVO billInfoMaintainVO);
	
	/**
	 * 
	 * @描述:根据票据信息维护条件获取信息
	 * @方法名: getBillInfoMaintainByCon
	 * @param tBudgetKindMoney
	 * @return
	 * @返回类型 Results<ListVO<TBillInfoMaintain>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TBillInfoMaintain>> getBillInfoMaintainByCon(BillInfoMaintainVO billInfoMaintainVO);
	
	/**
	 * 
	 * @描述: 修改票据信息维护
	 * @方法名: updateBillInfoMaintain
	 * @param tBillInfoMaintain
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> updateBillInfoMaintain(TBillInfoMaintain tBillInfoMaintain);
	
	/**
	 *  
	 * @描述: 增加票据信息维护
	 * @方法名: insertBillInfoMaintain
	 * @param tBillInfoMaintain
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> insertBillInfoMaintain(TBillInfoMaintain tBillInfoMaintain);
	
	/**
	 * 
	 * @描述: 删除票据信息维护
	 * @方法名: deleteBillInfoMaintain
	 * @param tBillInfoMaintain
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> deleteBillInfoMaintain(TBillInfoMaintain tBillInfoMaintain);
	
	/**
	 * 
	 * @描述: 票据信息维护出到Excel
	 * @方法名: toBillInfoMaintainExcel
	 * @param response
	 * @返回类型 void
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void toBillInfoMaintainExcel(HttpServletResponse response);
	
	/**
	 * 
	 * @描述: 票种树形结构
	 * @方法名: getBillTypeTree
	 * @return
	 * @返回类型 Results<ListVO<TBillType>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TBillType>> getBillTypeTree(@RequestBody BillInfoMaintainVO billInfoMaintainVO);
		
}
