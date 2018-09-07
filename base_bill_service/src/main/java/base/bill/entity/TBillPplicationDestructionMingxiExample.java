package base.bill.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TBillPplicationDestructionMingxiExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public TBillPplicationDestructionMingxiExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_pplication_destruction_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_bill_pplication_destruction_mingxi
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

		public Criteria andMx_idIsNull() {
			addCriterion("mx_id is null");
			return (Criteria) this;
		}

		public Criteria andMx_idIsNotNull() {
			addCriterion("mx_id is not null");
			return (Criteria) this;
		}

		public Criteria andMx_idEqualTo(Integer value) {
			addCriterion("mx_id =", value, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idNotEqualTo(Integer value) {
			addCriterion("mx_id <>", value, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idGreaterThan(Integer value) {
			addCriterion("mx_id >", value, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("mx_id >=", value, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idLessThan(Integer value) {
			addCriterion("mx_id <", value, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idLessThanOrEqualTo(Integer value) {
			addCriterion("mx_id <=", value, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idIn(List<Integer> values) {
			addCriterion("mx_id in", values, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idNotIn(List<Integer> values) {
			addCriterion("mx_id not in", values, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idBetween(Integer value1, Integer value2) {
			addCriterion("mx_id between", value1, value2, "mx_id");
			return (Criteria) this;
		}

		public Criteria andMx_idNotBetween(Integer value1, Integer value2) {
			addCriterion("mx_id not between", value1, value2, "mx_id");
			return (Criteria) this;
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

		public Criteria andBill_nameIsNull() {
			addCriterion("bill_name is null");
			return (Criteria) this;
		}

		public Criteria andBill_nameIsNotNull() {
			addCriterion("bill_name is not null");
			return (Criteria) this;
		}

		public Criteria andBill_nameEqualTo(String value) {
			addCriterion("bill_name =", value, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameNotEqualTo(String value) {
			addCriterion("bill_name <>", value, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameGreaterThan(String value) {
			addCriterion("bill_name >", value, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameGreaterThanOrEqualTo(String value) {
			addCriterion("bill_name >=", value, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameLessThan(String value) {
			addCriterion("bill_name <", value, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameLessThanOrEqualTo(String value) {
			addCriterion("bill_name <=", value, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameLike(String value) {
			addCriterion("bill_name like", value, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameNotLike(String value) {
			addCriterion("bill_name not like", value, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameIn(List<String> values) {
			addCriterion("bill_name in", values, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameNotIn(List<String> values) {
			addCriterion("bill_name not in", values, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameBetween(String value1, String value2) {
			addCriterion("bill_name between", value1, value2, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_nameNotBetween(String value1, String value2) {
			addCriterion("bill_name not between", value1, value2, "bill_name");
			return (Criteria) this;
		}

		public Criteria andBill_prefixIsNull() {
			addCriterion("bill_prefix is null");
			return (Criteria) this;
		}

		public Criteria andBill_prefixIsNotNull() {
			addCriterion("bill_prefix is not null");
			return (Criteria) this;
		}

		public Criteria andBill_prefixEqualTo(Integer value) {
			addCriterion("bill_prefix =", value, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixNotEqualTo(Integer value) {
			addCriterion("bill_prefix <>", value, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixGreaterThan(Integer value) {
			addCriterion("bill_prefix >", value, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixGreaterThanOrEqualTo(Integer value) {
			addCriterion("bill_prefix >=", value, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixLessThan(Integer value) {
			addCriterion("bill_prefix <", value, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixLessThanOrEqualTo(Integer value) {
			addCriterion("bill_prefix <=", value, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixIn(List<Integer> values) {
			addCriterion("bill_prefix in", values, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixNotIn(List<Integer> values) {
			addCriterion("bill_prefix not in", values, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixBetween(Integer value1, Integer value2) {
			addCriterion("bill_prefix between", value1, value2, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andBill_prefixNotBetween(Integer value1, Integer value2) {
			addCriterion("bill_prefix not between", value1, value2, "bill_prefix");
			return (Criteria) this;
		}

		public Criteria andStart_numberIsNull() {
			addCriterion("start_number is null");
			return (Criteria) this;
		}

		public Criteria andStart_numberIsNotNull() {
			addCriterion("start_number is not null");
			return (Criteria) this;
		}

		public Criteria andStart_numberEqualTo(Long value) {
			addCriterion("start_number =", value, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberNotEqualTo(Long value) {
			addCriterion("start_number <>", value, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberGreaterThan(Long value) {
			addCriterion("start_number >", value, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberGreaterThanOrEqualTo(Long value) {
			addCriterion("start_number >=", value, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberLessThan(Long value) {
			addCriterion("start_number <", value, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberLessThanOrEqualTo(Long value) {
			addCriterion("start_number <=", value, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberIn(List<Long> values) {
			addCriterion("start_number in", values, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberNotIn(List<Long> values) {
			addCriterion("start_number not in", values, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberBetween(Long value1, Long value2) {
			addCriterion("start_number between", value1, value2, "start_number");
			return (Criteria) this;
		}

		public Criteria andStart_numberNotBetween(Long value1, Long value2) {
			addCriterion("start_number not between", value1, value2, "start_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberIsNull() {
			addCriterion("terminate_number is null");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberIsNotNull() {
			addCriterion("terminate_number is not null");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberEqualTo(Long value) {
			addCriterion("terminate_number =", value, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberNotEqualTo(Long value) {
			addCriterion("terminate_number <>", value, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberGreaterThan(Long value) {
			addCriterion("terminate_number >", value, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberGreaterThanOrEqualTo(Long value) {
			addCriterion("terminate_number >=", value, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberLessThan(Long value) {
			addCriterion("terminate_number <", value, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberLessThanOrEqualTo(Long value) {
			addCriterion("terminate_number <=", value, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberIn(List<Long> values) {
			addCriterion("terminate_number in", values, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberNotIn(List<Long> values) {
			addCriterion("terminate_number not in", values, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberBetween(Long value1, Long value2) {
			addCriterion("terminate_number between", value1, value2, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andTerminate_numberNotBetween(Long value1, Long value2) {
			addCriterion("terminate_number not between", value1, value2, "terminate_number");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuIsNull() {
			addCriterion("bill_fenshu is null");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuIsNotNull() {
			addCriterion("bill_fenshu is not null");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuEqualTo(Integer value) {
			addCriterion("bill_fenshu =", value, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuNotEqualTo(Integer value) {
			addCriterion("bill_fenshu <>", value, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuGreaterThan(Integer value) {
			addCriterion("bill_fenshu >", value, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuGreaterThanOrEqualTo(Integer value) {
			addCriterion("bill_fenshu >=", value, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuLessThan(Integer value) {
			addCriterion("bill_fenshu <", value, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuLessThanOrEqualTo(Integer value) {
			addCriterion("bill_fenshu <=", value, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuIn(List<Integer> values) {
			addCriterion("bill_fenshu in", values, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuNotIn(List<Integer> values) {
			addCriterion("bill_fenshu not in", values, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuBetween(Integer value1, Integer value2) {
			addCriterion("bill_fenshu between", value1, value2, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andBill_fenshuNotBetween(Integer value1, Integer value2) {
			addCriterion("bill_fenshu not between", value1, value2, "bill_fenshu");
			return (Criteria) this;
		}

		public Criteria andDelete_statusIsNull() {
			addCriterion("delete_status is null");
			return (Criteria) this;
		}

		public Criteria andDelete_statusIsNotNull() {
			addCriterion("delete_status is not null");
			return (Criteria) this;
		}

		public Criteria andDelete_statusEqualTo(Integer value) {
			addCriterion("delete_status =", value, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusNotEqualTo(Integer value) {
			addCriterion("delete_status <>", value, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusGreaterThan(Integer value) {
			addCriterion("delete_status >", value, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_status >=", value, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusLessThan(Integer value) {
			addCriterion("delete_status <", value, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusLessThanOrEqualTo(Integer value) {
			addCriterion("delete_status <=", value, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusIn(List<Integer> values) {
			addCriterion("delete_status in", values, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusNotIn(List<Integer> values) {
			addCriterion("delete_status not in", values, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusBetween(Integer value1, Integer value2) {
			addCriterion("delete_status between", value1, value2, "delete_status");
			return (Criteria) this;
		}

		public Criteria andDelete_statusNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_status not between", value1, value2, "delete_status");
			return (Criteria) this;
		}

		public Criteria andCreate_dateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}

		public Criteria andCreate_dateIsNotNull() {
			addCriterion("create_date is not null");
			return (Criteria) this;
		}

		public Criteria andCreate_dateEqualTo(Date value) {
			addCriterionForJDBCDate("create_date =", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("create_date <>", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("create_date >", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("create_date >=", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateLessThan(Date value) {
			addCriterionForJDBCDate("create_date <", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("create_date <=", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateIn(List<Date> values) {
			addCriterionForJDBCDate("create_date in", values, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("create_date not in", values, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("create_date between", value1, value2, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("create_date not between", value1, value2, "create_date");
			return (Criteria) this;
		}

		public Criteria andUpdateIsNull() {
			addCriterion("update is null");
			return (Criteria) this;
		}

		public Criteria andUpdateIsNotNull() {
			addCriterion("update is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateEqualTo(Date value) {
			addCriterionForJDBCDate("update =", value, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateNotEqualTo(Date value) {
			addCriterionForJDBCDate("update <>", value, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateGreaterThan(Date value) {
			addCriterionForJDBCDate("update >", value, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("update >=", value, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateLessThan(Date value) {
			addCriterionForJDBCDate("update <", value, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("update <=", value, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateIn(List<Date> values) {
			addCriterionForJDBCDate("update in", values, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateNotIn(List<Date> values) {
			addCriterionForJDBCDate("update not in", values, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("update between", value1, value2, "update");
			return (Criteria) this;
		}

		public Criteria andUpdateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("update not between", value1, value2, "update");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_bill_pplication_destruction_mingxi
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
     * This class corresponds to the database table t_bill_pplication_destruction_mingxi
     *
     * @mbg.generated do_not_delete_during_merge Wed Aug 29 09:30:53 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}