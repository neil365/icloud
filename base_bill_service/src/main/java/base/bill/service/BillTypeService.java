package base.bill.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import base.bill.entity.TBillType;
import base.bill.entity.TUnitCompetentDepartment;
import base.bill.entity.vo.BillTypeVO;
import base.bill.entity.vo.PageVO;

/**
 * 
 * @类描述：票据种类维护服务层
 * @项目名称：base_bill_service
 * @包名： base.bill.service
 * @类名称：IUnitCompetentDepartmentService
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
@Service
public interface BillTypeService {

	/**
	 * 获取票据种类信息
	 * @param tBillType
	 * @param pageVo
	 * @return
	 */

	public Results<ListVO<TBillType>> getBillTypeList(BillTypeVO billTypeVO, PageVO pageVO);


	/**
	 * 
	 * @描述: 根据票据种类维护条件查询信息
	 * @方法名: getBillTypeByCon
	 * @param TBillType
	 * @return
	 * @返回类型 Results<ListVO<TBillType>>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */

	public Results<ListVO<TBillType>> getBillTypeByCon(BillTypeVO billTypeVO);


	/**
	 * 
	 * @描述: 修改票据种类维护信息
	 * @方法名: updateBillType
	 * @param tBillType
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> updateBillType(TBillType tBillType);

	/**
	 * 
	 * @描述: 增加票据种类维护信息
	 * @方法名: insertBillType
	 * @param tBillType
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> insertBillType(TBillType tBillType);

	/**
	 * 
	 * @描述: 删除票据种类维护信息
	 * @方法名: deleteBillType
	 * @param tUnitCompetentDepartment
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> deleteBillType(TBillType tBillType);
	
	/**
	 * 
	 * @描述: 票据种类维护信息导出到Excel
	 * @方法名: toBillTypeExcel
	 * @param response
	 * @返回类型 void
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public void toBillTypeExcel(HttpServletResponse response); 
	
	/**
	 * 
	 * @描述: 票据种类与票据信息的树形结构
	 * @方法名: getBillTypeTree
	 * @return
	 * @返回类型 Results<TBillType>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<ListVO<TBillType>> getBillTypeTree();
	
}
