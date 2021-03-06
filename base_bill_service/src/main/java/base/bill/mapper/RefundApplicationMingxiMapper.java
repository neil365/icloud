package base.bill.mapper;

import base.bill.entity.RefundApplicationMingxi;
import base.bill.entity.RefundApplicationMingxiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundApplicationMingxiMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	long countByExample(RefundApplicationMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByExample(RefundApplicationMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer mingxi_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insert(RefundApplicationMingxi record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insertSelective(RefundApplicationMingxi record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	List<RefundApplicationMingxi> selectByExample(RefundApplicationMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	RefundApplicationMingxi selectByPrimaryKey(Integer mingxi_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExampleSelective(@Param("record") RefundApplicationMingxi record,
			@Param("example") RefundApplicationMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExample(@Param("record") RefundApplicationMingxi record,
			@Param("example") RefundApplicationMingxiExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKeySelective(RefundApplicationMingxi record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKey(RefundApplicationMingxi record);
}