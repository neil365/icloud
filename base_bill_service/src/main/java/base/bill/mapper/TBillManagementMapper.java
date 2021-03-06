package base.bill.mapper;

import base.bill.entity.TBillManagement;
import base.bill.entity.TBillManagementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 票据管理Mapper
 * @author wangp
 * @time 2018-08-08
 */
public interface TBillManagementMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	long countByExample(TBillManagementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByExample(TBillManagementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer bill_management_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insert(TBillManagement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insertSelective(TBillManagement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	List<TBillManagement> selectByExample(TBillManagementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	TBillManagement selectByPrimaryKey(Integer bill_management_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TBillManagement record,
			@Param("example") TBillManagementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExample(@Param("record") TBillManagement record, @Param("example") TBillManagementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKeySelective(TBillManagement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_management
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKey(TBillManagement record);

	Long getStartNumberBillManagement();
}