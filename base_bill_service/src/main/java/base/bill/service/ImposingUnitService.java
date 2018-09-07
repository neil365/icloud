package base.bill.service;

import javax.servlet.http.HttpServletResponse;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import base.bill.entity.TImposingUnit;
import base.bill.entity.vo.ImposingUnitVO;
import base.bill.entity.vo.PageVO;

/**
 * 
 * @类描述：执收单位服务层
 * @项目名称：base_bill_service
 * @包名： base.bill.service
 * @类名称：IImposingUnitService
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
public interface ImposingUnitService {

	/**
	 * 
	 * @描述:获取执收单位信息
	 * @方法名: getImposingUnitList
	 * @param imposingUnitVO
	 * @return
	 * @返回类型 Results<List<TImposingUnit>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TImposingUnit>> getImposingUnitList(ImposingUnitVO imposingUnitVO, PageVO pageVO);
	
	/**
	 * 根据条件单位获取信息
	 * @描述:
	 * @方法名: getFinancialByCon
	 * @param imposingUnitVO
	 * @return
	 * @返回类型 Results<List<TImposingUnit>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TImposingUnit>> getFinancialByCon(ImposingUnitVO imposingUnitVO);

	/**
	 * 
	 * @描述: 修改执收单位信息
	 * @方法名: updateImposingUnit
	 * @param tImposingUnit
	 * @return
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> updateImposingUnit(TImposingUnit tImposingUnit);

	/**
	 * 
	 * @描述: 增加执收单位信息
	 * @方法名: insertImposingUnit
	 * @param tImposingUnit
	 * @return
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年5月11日上午9:19:54
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> insertImposingUnit(TImposingUnit tImposingUnit);

	/**
	 * 
	 * @描述: 删除执收单位信息
	 * @方法名: deleteImposingUnit
	 * @param tImposingUnit
	 * @return
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018年5月11日上午9:19:41
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> deleteImposingUnit(TImposingUnit tImposingUnit);
	
	/**
	 * 
	 * @描述: 执收单位信息导出到Excel
	 * @方法名: toFinancialExcel
	 * @param response
	 * @返回类型 void
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void toImposingUnitExcel(HttpServletResponse response);

	
	/**
	 * 
	 * @描述: 执收单位是否使用
	 * @方法名: updateImposingUnitIsUse
	 * @param tImposingUnit
	 * @return
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> updateImposingUnitIsUse(TImposingUnit tImposingUnit);
	
	/**
	 * 
	 * @描述: 获取执收单位树形结构，不包含子节点
	 * @方法名: getImposingUnitTreeNode
	 * @param imposingUnitVO
	 * @param pageVO
	 * @return
	 * @返回类型 Results<ListVO<TImposingUnit>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TImposingUnit>> getImposingUnitNode (ImposingUnitVO imposingUnitVO); 
	
	
	/**
	 * 
	 * @描述: 根据征收大厅id获取与执收单位挂接信息
	 * @方法名: getLevyFallImposingUnitByLevyFallId
	 * @param imposingUnitVO
	 * @param pageVO
	 * @return
	 * @返回类型 Results<ListVO<TImposingUnit>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TImposingUnit>> getLevyFallImposingUnitByLevyFallId(ImposingUnitVO imposingUnitVO, PageVO pageVO);

}
