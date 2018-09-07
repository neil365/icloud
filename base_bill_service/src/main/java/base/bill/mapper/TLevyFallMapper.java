package base.bill.mapper;

import base.bill.entity.TLevyFall;
import base.bill.entity.TLevyFallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLevyFallMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	long countByExample(TLevyFallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByExample(TLevyFallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer levyfall_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insert(TLevyFall record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insertSelective(TLevyFall record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	List<TLevyFall> selectByExample(TLevyFallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	TLevyFall selectByPrimaryKey(Integer levyfall_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TLevyFall record, @Param("example") TLevyFallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExample(@Param("record") TLevyFall record, @Param("example") TLevyFallExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKeySelective(TLevyFall record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_levy_fall
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKey(TLevyFall record);
}