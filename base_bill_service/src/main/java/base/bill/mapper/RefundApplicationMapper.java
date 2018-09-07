package base.bill.mapper;

import base.bill.entity.RefundApplication;
import base.bill.entity.RefundApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundApplicationMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	long countByExample(RefundApplicationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByExample(RefundApplicationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insert(RefundApplication record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insertSelective(RefundApplication record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	List<RefundApplication> selectByExample(RefundApplicationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	RefundApplication selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExampleSelective(@Param("record") RefundApplication record,
			@Param("example") RefundApplicationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExample(@Param("record") RefundApplication record, @Param("example") RefundApplicationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKeySelective(RefundApplication record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKey(RefundApplication record);
}