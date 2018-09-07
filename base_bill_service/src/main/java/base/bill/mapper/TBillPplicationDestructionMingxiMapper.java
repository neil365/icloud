package base.bill.mapper;

import base.bill.entity.TBillPplicationDestructionMingxi;
import base.bill.entity.TBillPplicationDestructionMingxiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBillPplicationDestructionMingxiMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	long countByExample(TBillPplicationDestructionMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByExample(TBillPplicationDestructionMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer mx_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insert(TBillPplicationDestructionMingxi record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insertSelective(TBillPplicationDestructionMingxi record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	List<TBillPplicationDestructionMingxi> selectByExample(TBillPplicationDestructionMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	TBillPplicationDestructionMingxi selectByPrimaryKey(Integer mx_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TBillPplicationDestructionMingxi record,
			@Param("example") TBillPplicationDestructionMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExample(@Param("record") TBillPplicationDestructionMingxi record,
			@Param("example") TBillPplicationDestructionMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKeySelective(TBillPplicationDestructionMingxi record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKey(TBillPplicationDestructionMingxi record);
}