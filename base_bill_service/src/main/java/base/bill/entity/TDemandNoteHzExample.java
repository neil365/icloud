package base.bill.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.math.BigDecimal;

public class TDemandNoteHzExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public TDemandNoteHzExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andBill_codeIsNull() {
			addCriterion("bill_code is null");
			return (Criteria) this;
		}

		public Criteria andBill_codeIsNotNull() {
			addCriterion("bill_code is not null");
			return (Criteria) this;
		}

		public Criteria andBill_codeEqualTo(String value) {
			addCriterion("bill_code =", value, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeNotEqualTo(String value) {
			addCriterion("bill_code <>", value, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeGreaterThan(String value) {
			addCriterion("bill_code >", value, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeGreaterThanOrEqualTo(String value) {
			addCriterion("bill_code >=", value, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeLessThan(String value) {
			addCriterion("bill_code <", value, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeLessThanOrEqualTo(String value) {
			addCriterion("bill_code <=", value, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeLike(String value) {
			addCriterion("bill_code like", value, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeNotLike(String value) {
			addCriterion("bill_code not like", value, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeIn(List<String> values) {
			addCriterion("bill_code in", values, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeNotIn(List<String> values) {
			addCriterion("bill_code not in", values, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeBetween(String value1, String value2) {
			addCriterion("bill_code between", value1, value2, "bill_code");
			return (Criteria) this;
		}

		public Criteria andBill_codeNotBetween(String value1, String value2) {
			addCriterion("bill_code not between", value1, value2, "bill_code");
			return (Criteria) this;
		}

		public Criteria andHj_moneyIsNull() {
			addCriterion("hj_money is null");
			return (Criteria) this;
		}

		public Criteria andHj_moneyIsNotNull() {
			addCriterion("hj_money is not null");
			return (Criteria) this;
		}

		public Criteria andHj_moneyEqualTo(BigDecimal value) {
			addCriterion("hj_money =", value, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyNotEqualTo(BigDecimal value) {
			addCriterion("hj_money <>", value, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyGreaterThan(BigDecimal value) {
			addCriterion("hj_money >", value, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("hj_money >=", value, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyLessThan(BigDecimal value) {
			addCriterion("hj_money <", value, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("hj_money <=", value, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyIn(List<BigDecimal> values) {
			addCriterion("hj_money in", values, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyNotIn(List<BigDecimal> values) {
			addCriterion("hj_money not in", values, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("hj_money between", value1, value2, "hj_money");
			return (Criteria) this;
		}

		public Criteria andHj_moneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("hj_money not between", value1, value2, "hj_money");
			return (Criteria) this;
		}

		public Criteria andPayers_nameIsNull() {
			addCriterion("payers_name is null");
			return (Criteria) this;
		}

		public Criteria andPayers_nameIsNotNull() {
			addCriterion("payers_name is not null");
			return (Criteria) this;
		}

		public Criteria andPayers_nameEqualTo(String value) {
			addCriterion("payers_name =", value, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameNotEqualTo(String value) {
			addCriterion("payers_name <>", value, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameGreaterThan(String value) {
			addCriterion("payers_name >", value, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameGreaterThanOrEqualTo(String value) {
			addCriterion("payers_name >=", value, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameLessThan(String value) {
			addCriterion("payers_name <", value, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameLessThanOrEqualTo(String value) {
			addCriterion("payers_name <=", value, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameLike(String value) {
			addCriterion("payers_name like", value, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameNotLike(String value) {
			addCriterion("payers_name not like", value, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameIn(List<String> values) {
			addCriterion("payers_name in", values, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameNotIn(List<String> values) {
			addCriterion("payers_name not in", values, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameBetween(String value1, String value2) {
			addCriterion("payers_name between", value1, value2, "payers_name");
			return (Criteria) this;
		}

		public Criteria andPayers_nameNotBetween(String value1, String value2) {
			addCriterion("payers_name not between", value1, value2, "payers_name");
			return (Criteria) this;
		}

		public Criteria andTz_dateIsNull() {
			addCriterion("tz_date is null");
			return (Criteria) this;
		}

		public Criteria andTz_dateIsNotNull() {
			addCriterion("tz_date is not null");
			return (Criteria) this;
		}

		public Criteria andTz_dateEqualTo(Date value) {
			addCriterionForJDBCDate("tz_date =", value, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("tz_date <>", value, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("tz_date >", value, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("tz_date >=", value, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateLessThan(Date value) {
			addCriterionForJDBCDate("tz_date <", value, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("tz_date <=", value, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateIn(List<Date> values) {
			addCriterionForJDBCDate("tz_date in", values, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("tz_date not in", values, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("tz_date between", value1, value2, "tz_date");
			return (Criteria) this;
		}

		public Criteria andTz_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("tz_date not between", value1, value2, "tz_date");
			return (Criteria) this;
		}

		public Criteria andOperatorIsNull() {
			addCriterion("operator is null");
			return (Criteria) this;
		}

		public Criteria andOperatorIsNotNull() {
			addCriterion("operator is not null");
			return (Criteria) this;
		}

		public Criteria andOperatorEqualTo(String value) {
			addCriterion("operator =", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotEqualTo(String value) {
			addCriterion("operator <>", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorGreaterThan(String value) {
			addCriterion("operator >", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorGreaterThanOrEqualTo(String value) {
			addCriterion("operator >=", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorLessThan(String value) {
			addCriterion("operator <", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorLessThanOrEqualTo(String value) {
			addCriterion("operator <=", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorLike(String value) {
			addCriterion("operator like", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotLike(String value) {
			addCriterion("operator not like", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorIn(List<String> values) {
			addCriterion("operator in", values, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotIn(List<String> values) {
			addCriterion("operator not in", values, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorBetween(String value1, String value2) {
			addCriterion("operator between", value1, value2, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotBetween(String value1, String value2) {
			addCriterion("operator not between", value1, value2, "operator");
			return (Criteria) this;
		}

		public Criteria andJk_stateIsNull() {
			addCriterion("jk_state is null");
			return (Criteria) this;
		}

		public Criteria andJk_stateIsNotNull() {
			addCriterion("jk_state is not null");
			return (Criteria) this;
		}

		public Criteria andJk_stateEqualTo(Integer value) {
			addCriterion("jk_state =", value, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateNotEqualTo(Integer value) {
			addCriterion("jk_state <>", value, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateGreaterThan(Integer value) {
			addCriterion("jk_state >", value, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateGreaterThanOrEqualTo(Integer value) {
			addCriterion("jk_state >=", value, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateLessThan(Integer value) {
			addCriterion("jk_state <", value, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateLessThanOrEqualTo(Integer value) {
			addCriterion("jk_state <=", value, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateIn(List<Integer> values) {
			addCriterion("jk_state in", values, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateNotIn(List<Integer> values) {
			addCriterion("jk_state not in", values, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateBetween(Integer value1, Integer value2) {
			addCriterion("jk_state between", value1, value2, "jk_state");
			return (Criteria) this;
		}

		public Criteria andJk_stateNotBetween(Integer value1, Integer value2) {
			addCriterion("jk_state not between", value1, value2, "jk_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateIsNull() {
			addCriterion("dz_state is null");
			return (Criteria) this;
		}

		public Criteria andDz_stateIsNotNull() {
			addCriterion("dz_state is not null");
			return (Criteria) this;
		}

		public Criteria andDz_stateEqualTo(Integer value) {
			addCriterion("dz_state =", value, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateNotEqualTo(Integer value) {
			addCriterion("dz_state <>", value, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateGreaterThan(Integer value) {
			addCriterion("dz_state >", value, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateGreaterThanOrEqualTo(Integer value) {
			addCriterion("dz_state >=", value, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateLessThan(Integer value) {
			addCriterion("dz_state <", value, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateLessThanOrEqualTo(Integer value) {
			addCriterion("dz_state <=", value, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateIn(List<Integer> values) {
			addCriterion("dz_state in", values, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateNotIn(List<Integer> values) {
			addCriterion("dz_state not in", values, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateBetween(Integer value1, Integer value2) {
			addCriterion("dz_state between", value1, value2, "dz_state");
			return (Criteria) this;
		}

		public Criteria andDz_stateNotBetween(Integer value1, Integer value2) {
			addCriterion("dz_state not between", value1, value2, "dz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateIsNull() {
			addCriterion("hz_state is null");
			return (Criteria) this;
		}

		public Criteria andHz_stateIsNotNull() {
			addCriterion("hz_state is not null");
			return (Criteria) this;
		}

		public Criteria andHz_stateEqualTo(Integer value) {
			addCriterion("hz_state =", value, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateNotEqualTo(Integer value) {
			addCriterion("hz_state <>", value, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateGreaterThan(Integer value) {
			addCriterion("hz_state >", value, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateGreaterThanOrEqualTo(Integer value) {
			addCriterion("hz_state >=", value, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateLessThan(Integer value) {
			addCriterion("hz_state <", value, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateLessThanOrEqualTo(Integer value) {
			addCriterion("hz_state <=", value, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateIn(List<Integer> values) {
			addCriterion("hz_state in", values, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateNotIn(List<Integer> values) {
			addCriterion("hz_state not in", values, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateBetween(Integer value1, Integer value2) {
			addCriterion("hz_state between", value1, value2, "hz_state");
			return (Criteria) this;
		}

		public Criteria andHz_stateNotBetween(Integer value1, Integer value2) {
			addCriterion("hz_state not between", value1, value2, "hz_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateIsNull() {
			addCriterion("zf_state is null");
			return (Criteria) this;
		}

		public Criteria andZf_stateIsNotNull() {
			addCriterion("zf_state is not null");
			return (Criteria) this;
		}

		public Criteria andZf_stateEqualTo(Integer value) {
			addCriterion("zf_state =", value, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateNotEqualTo(Integer value) {
			addCriterion("zf_state <>", value, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateGreaterThan(Integer value) {
			addCriterion("zf_state >", value, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateGreaterThanOrEqualTo(Integer value) {
			addCriterion("zf_state >=", value, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateLessThan(Integer value) {
			addCriterion("zf_state <", value, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateLessThanOrEqualTo(Integer value) {
			addCriterion("zf_state <=", value, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateIn(List<Integer> values) {
			addCriterion("zf_state in", values, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateNotIn(List<Integer> values) {
			addCriterion("zf_state not in", values, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateBetween(Integer value1, Integer value2) {
			addCriterion("zf_state between", value1, value2, "zf_state");
			return (Criteria) this;
		}

		public Criteria andZf_stateNotBetween(Integer value1, Integer value2) {
			addCriterion("zf_state not between", value1, value2, "zf_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateIsNull() {
			addCriterion("bl_state is null");
			return (Criteria) this;
		}

		public Criteria andBl_stateIsNotNull() {
			addCriterion("bl_state is not null");
			return (Criteria) this;
		}

		public Criteria andBl_stateEqualTo(Integer value) {
			addCriterion("bl_state =", value, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateNotEqualTo(Integer value) {
			addCriterion("bl_state <>", value, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateGreaterThan(Integer value) {
			addCriterion("bl_state >", value, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateGreaterThanOrEqualTo(Integer value) {
			addCriterion("bl_state >=", value, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateLessThan(Integer value) {
			addCriterion("bl_state <", value, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateLessThanOrEqualTo(Integer value) {
			addCriterion("bl_state <=", value, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateIn(List<Integer> values) {
			addCriterion("bl_state in", values, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateNotIn(List<Integer> values) {
			addCriterion("bl_state not in", values, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateBetween(Integer value1, Integer value2) {
			addCriterion("bl_state between", value1, value2, "bl_state");
			return (Criteria) this;
		}

		public Criteria andBl_stateNotBetween(Integer value1, Integer value2) {
			addCriterion("bl_state not between", value1, value2, "bl_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateIsNull() {
			addCriterion("delete_state is null");
			return (Criteria) this;
		}

		public Criteria andDelete_stateIsNotNull() {
			addCriterion("delete_state is not null");
			return (Criteria) this;
		}

		public Criteria andDelete_stateEqualTo(Integer value) {
			addCriterion("delete_state =", value, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateNotEqualTo(Integer value) {
			addCriterion("delete_state <>", value, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateGreaterThan(Integer value) {
			addCriterion("delete_state >", value, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_state >=", value, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateLessThan(Integer value) {
			addCriterion("delete_state <", value, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateLessThanOrEqualTo(Integer value) {
			addCriterion("delete_state <=", value, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateIn(List<Integer> values) {
			addCriterion("delete_state in", values, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateNotIn(List<Integer> values) {
			addCriterion("delete_state not in", values, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateBetween(Integer value1, Integer value2) {
			addCriterion("delete_state between", value1, value2, "delete_state");
			return (Criteria) this;
		}

		public Criteria andDelete_stateNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_state not between", value1, value2, "delete_state");
			return (Criteria) this;
		}

		public Criteria andHoldIsNull() {
			addCriterion("hold is null");
			return (Criteria) this;
		}

		public Criteria andHoldIsNotNull() {
			addCriterion("hold is not null");
			return (Criteria) this;
		}

		public Criteria andHoldEqualTo(String value) {
			addCriterion("hold =", value, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldNotEqualTo(String value) {
			addCriterion("hold <>", value, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldGreaterThan(String value) {
			addCriterion("hold >", value, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldGreaterThanOrEqualTo(String value) {
			addCriterion("hold >=", value, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldLessThan(String value) {
			addCriterion("hold <", value, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldLessThanOrEqualTo(String value) {
			addCriterion("hold <=", value, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldLike(String value) {
			addCriterion("hold like", value, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldNotLike(String value) {
			addCriterion("hold not like", value, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldIn(List<String> values) {
			addCriterion("hold in", values, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldNotIn(List<String> values) {
			addCriterion("hold not in", values, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldBetween(String value1, String value2) {
			addCriterion("hold between", value1, value2, "hold");
			return (Criteria) this;
		}

		public Criteria andHoldNotBetween(String value1, String value2) {
			addCriterion("hold not between", value1, value2, "hold");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_demand_note_hz
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_demand_note_hz
     *
     * @mbg.generated do_not_delete_during_merge Tue Aug 21 17:02:07 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}