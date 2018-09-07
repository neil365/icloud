package base.bill.mapper;

import base.bill.entity.TBudgetKindMoney;
import base.bill.entity.TBudgetKindMoneyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TBudgetKindMoneyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	long countByExample(TBudgetKindMoneyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByExample(TBudgetKindMoneyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer budget_kind_money_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insert(TBudgetKindMoney record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insertSelective(TBudgetKindMoney record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	List<TBudgetKindMoney> selectByExample(TBudgetKindMoneyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	TBudgetKindMoney selectByPrimaryKey(Integer budget_kind_money_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TBudgetKindMoney record,
			@Param("example") TBudgetKindMoneyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExample(@Param("record") TBudgetKindMoney record, @Param("example") TBudgetKindMoneyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKeySelective(TBudgetKindMoney record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_budget_kind_money
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKey(TBudgetKindMoney record);

	/**
	 * 
	 * @描述: 获取收入类款父类信息
	 * @方法名: getBudgetKindMoneyByParentId
	 * @param aMap
	 * @return
	 * @返回类型 List<TBudgetKindMoney>
	 * @创建人 吴镇锡
	 * @创建时间 2018年5月18日上午9:58:08
	 * @修改人 吴镇锡
	 * @修改时间 2018年5月18日上午9:58:08
	 * @修改备注
	 * @since
	 * @throws
	 */
	List<TBudgetKindMoney> getBudgetKindMoneyByParentId(Map<String, Object> aMap);
}