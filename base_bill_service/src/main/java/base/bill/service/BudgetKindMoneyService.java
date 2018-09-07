package base.bill.service;

import javax.servlet.http.HttpServletResponse;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import base.bill.entity.TBudgetKindMoney;
import base.bill.entity.vo.BudgetKindMoneyVO;
import base.bill.entity.vo.PageVO;


/**
 * 
 * @类描述：预算类款业务层接口
 * @项目名称：base_bill_service
 * @包名： base.bill.service
 * @类名称：IFinancialService
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
public interface BudgetKindMoneyService {
	
	/**
	 *  
	 * @描述: 获取收入类款信息
	 * @方法名: getFinancialList
	 * @param tBudgetKindMoney
	 * @param pageVo
	 * @return
	 * @返回类型 Results<ListVO<TFinancial>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TBudgetKindMoney>> getBudgetKindMoneyList(BudgetKindMoneyVO BudgetKindMoneyVO, PageVO pageVo);
	
	/**
	 * 
	 * @描述:根据收入类款条件获取信息
	 * @方法名: getBudgetKindMoneyByCon
	 * @param tBudgetKindMoney
	 * @return
	 * @返回类型 Results<ListVO<TBudgetKindMoney>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TBudgetKindMoney>> getBudgetKindMoneyByCon(TBudgetKindMoney tBudgetKindMoney);
	
	/**
	 * 
	 * @描述: 修改收入类款信息
	 * @方法名: updateBudgetKindMoney
	 * @param tBudgetKindMoney
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> updateBudgetKindMoney(TBudgetKindMoney tBudgetKindMoney);
	
	/**
	 *  
	 * @描述: 增加收入类款信息
	 * @方法名: insertBudgetKindMoney
	 * @param tBudgetKindMoney
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> insertBudgetKindMoney(TBudgetKindMoney tBudgetKindMoney);
	
	/**
	 * 
	 * @描述: 删除收入类款信息
	 * @方法名: deleteBudgetKindMoney
	 * @param tBudgetKindMoney
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> deleteBudgetKindMoney(TBudgetKindMoney tBudgetKindMoney);
	
	/**
	 * 
	 * @描述: 收入类款信息导出到Excel
	 * @方法名: toBudgetKindMoney
	 * @param response
	 * @返回类型 void
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void toBudgetKindMoneyExcel(HttpServletResponse response);
		
}
