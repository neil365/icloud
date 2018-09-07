package base.bill.service;

import org.springframework.stereotype.Service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Results;
import base.bill.entity.TUnitBillInfo;
import base.bill.entity.vo.LevyfallBillInfoVO;

/**
 * 
 * @类描述： 征收大厅与票据信息挂接
 * @项目名称：base_bill_service
 * @包名： base.bill.service
 * @类名称：IUnitBillInfoService
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
@Service
public interface LevyfallBillInfoService {
	

	/**
	 * 
	 * @描述: 添加执收单位id查询与票据维护挂接信息
	 * @方法名: insertLevyfallBillInfo
	 * @param levyfallBillInfoVO
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> insertLevyfallBillInfo(LevyfallBillInfoVO levyfallBillInfoVO);

	
	/**
	 * 
	 * @描述: 删除执收单位与票据维护挂接信息
	 * @方法名: deleteLevyfallBillInfo
	 * @param levyfallBillInfoVO
	 * @return
	 * @返回类型 Results<Object>
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 * @since
	 * @throws
	 */
	public Results<Object> deleteLevyfallBillInfo(LevyfallBillInfoVO levyfallBillInfoVO);
	
}
