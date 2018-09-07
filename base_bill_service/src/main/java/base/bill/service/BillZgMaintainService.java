package base.bill.service;

import javax.servlet.http.HttpServletResponse;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TBillZgMaintain;
import base.bill.entity.TBudgetKindMoney;
import base.bill.entity.vo.BillInfoMaintainVO;
import base.bill.entity.vo.BillZgMaintainVO;
import base.bill.entity.vo.PageVO;


/**
 * 
 * @类描述：票据字轨维护业务层接口
 * @项目名称：base_bill_service
 * @包名： base.bill.service
 * @类名称：IBillZgMaintainService
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
public interface BillZgMaintainService {
	
	/**
	 *  
	 * @描述: 获取票据字轨维护信息
	 * @方法名: getBillZgMaintainList
	 * @param billZgMaintainVO
	 * @param pageVo
	 * @return
	 * @返回类型 Results<ListVO<TBillZgMaintain>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TBillZgMaintain>> getBillZgMaintainList(BillZgMaintainVO billZgMaintainVO, PageVO pageVO);
	
	/**
	 * 
	 * @描述: 根据票据字轨维护条件获取信息
	 * @方法名: getBillZgMaintainCon
	 * @param billZgMaintainVO
	 * @return
	 * @返回类型 Results<ListVO<TBillZgMaintain>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TBillZgMaintain>> getBillZgMaintainByCon(BillZgMaintainVO billZgMaintainVO);
	
	/**
	 * 
	 * @描述: 修改票据字轨维护信息
	 * @方法名: updateBillInfoMaintain
	 * @param tBillZgMaintain
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> updateBillZgMaintain(TBillZgMaintain tBillZgMaintain);
	
	/**
	 * 
	 * @描述: 增加票据字轨维护
	 * @方法名: insertBillZgMaintain
	 * @param tBillZgMaintain
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> insertBillZgMaintain(TBillZgMaintain tBillZgMaintain);
	
	/**
	 * 
	 * @描述: 删除票据字轨维护信息
	 * @方法名: deleteBillZgMaintain
	 * @param tBillZgMaintain
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> deleteBillZgMaintain(TBillZgMaintain tBillZgMaintain);
	
	/**
	 *  
	 * @描述: 票据字轨维护导出到Excel
	 * @方法名: toBillZgMaintainExcel
	 * @param response
	 * @返回类型 void
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void toBillZgMaintainExcel(HttpServletResponse response);
		
}
