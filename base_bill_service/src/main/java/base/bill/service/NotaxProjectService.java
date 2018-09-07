package base.bill.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;
import base.bill.entity.TFinancial;
import base.bill.entity.TImposingUnit;
import base.bill.entity.TNotaxProject;
import base.bill.entity.vo.FinancialVO;
import base.bill.entity.vo.NotaxProjectVO;
import base.bill.entity.vo.PageVO;


/**
 * 
 * @类描述：非税项目业务层接口
 * @项目名称：base_bill_service
 * @包名： base.bill.service
 * @类名称：IFinancialService
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
public interface NotaxProjectService {
	
	/**
	 * 
	 * @描述: 获取非税项目信息
	 * @方法名: getNotaxProjectList
	 * @param financialVO
	 * @param pageVo
	 * @return
	 * @返回类型 Results<ListVO<TFinancial>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TNotaxProject>> getNotaxProjectList(NotaxProjectVO notaxProjectVO, PageVO pageVo);
	
	/**
	 * 
	 * @描述: 根据非税项目信息
	 * @方法名: getNotaxProjectByCon
	 * @param financial_name
	 * @return
	 * @返回类型 List<TFinancial>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TNotaxProject>> getNotaxProjectByCon(NotaxProjectVO notaxProjectVO);
	
	/**
	 * 
	 * @描述: 修改非税项目信息
	 * @方法名: updateNotaxProject
	 * @param tNotaxProject
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> updateNotaxProject(TNotaxProject tNotaxProject);
	
	/**
	 * 
	 * @描述:增加非税项目信息
	 * @方法名: insertFinancial
	 * @param financial
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> insertNotaxProject(TNotaxProject tNotaxProject);
	
	/**
	 * 
	 * @描述: 删除非税项目信息
	 * @方法名: deleteFinancial
	 * @param financial_id
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> deleteNotaxProject(TNotaxProject tNotaxProject);
	
	/**
	 * 
	 * @描述: 非税项目是否使用
	 * @方法名: updateNotaxProjectIsUse
	 * @param tNotaxProject
	 * @return
	 * @返回类型 int
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> updateNotaxProjectIsUse(TNotaxProject tNotaxProject);
	
	/**
	 * 非税项目信息导出到Excel
	 * @描述:
	 * @方法名: toNotaxProjectExcel
	 * @param response
	 * @返回类型 void
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void toNotaxProjectExcel(HttpServletResponse response);
	
	/**
	 * 
	 * @描述: 获取非税项目树形结构，不包含子节点
	 * @方法名: getNotaxProjectNode
	 * @param notaxProjectVO
	 * @return
	 * @返回类型 Results<ListVO<TNotaxProject>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TNotaxProject>> getNotaxProjectNode(NotaxProjectVO notaxProjectVO);
	
	/**
	 *  
	 * @描述: 根据执收单位id获取非税项目挂接信息
	 * @方法名: getImposingUnitNotaxProjectByUnitId
	 * @param aMap
	 * @return
	 * @返回类型 Results<ListVO<TNotaxProject>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TNotaxProject>> getImposingUnitNotaxProjectByUnitId(NotaxProjectVO notaxProjectVO, PageVO pageVO);
	
}
