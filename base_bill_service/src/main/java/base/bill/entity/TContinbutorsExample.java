package base.bill.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TContinbutorsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public TContinbutorsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
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

		public Criteria andT_full_contributors_nameIsNull() {
			addCriterion("t_full_contributors_name is null");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameIsNotNull() {
			addCriterion("t_full_contributors_name is not null");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameEqualTo(String value) {
			addCriterion("t_full_contributors_name =", value, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameNotEqualTo(String value) {
			addCriterion("t_full_contributors_name <>", value, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameGreaterThan(String value) {
			addCriterion("t_full_contributors_name >", value, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameGreaterThanOrEqualTo(String value) {
			addCriterion("t_full_contributors_name >=", value, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameLessThan(String value) {
			addCriterion("t_full_contributors_name <", value, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameLessThanOrEqualTo(String value) {
			addCriterion("t_full_contributors_name <=", value, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameLike(String value) {
			addCriterion("t_full_contributors_name like", value, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameNotLike(String value) {
			addCriterion("t_full_contributors_name not like", value, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameIn(List<String> values) {
			addCriterion("t_full_contributors_name in", values, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameNotIn(List<String> values) {
			addCriterion("t_full_contributors_name not in", values, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameBetween(String value1, String value2) {
			addCriterion("t_full_contributors_name between", value1, value2, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_nameNotBetween(String value1, String value2) {
			addCriterion("t_full_contributors_name not between", value1, value2, "t_full_contributors_name");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankIsNull() {
			addCriterion("t_full_contributors_bank is null");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankIsNotNull() {
			addCriterion("t_full_contributors_bank is not null");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankEqualTo(String value) {
			addCriterion("t_full_contributors_bank =", value, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankNotEqualTo(String value) {
			addCriterion("t_full_contributors_bank <>", value, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankGreaterThan(String value) {
			addCriterion("t_full_contributors_bank >", value, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankGreaterThanOrEqualTo(String value) {
			addCriterion("t_full_contributors_bank >=", value, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankLessThan(String value) {
			addCriterion("t_full_contributors_bank <", value, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankLessThanOrEqualTo(String value) {
			addCriterion("t_full_contributors_bank <=", value, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankLike(String value) {
			addCriterion("t_full_contributors_bank like", value, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankNotLike(String value) {
			addCriterion("t_full_contributors_bank not like", value, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankIn(List<String> values) {
			addCriterion("t_full_contributors_bank in", values, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankNotIn(List<String> values) {
			addCriterion("t_full_contributors_bank not in", values, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankBetween(String value1, String value2) {
			addCriterion("t_full_contributors_bank between", value1, value2, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bankNotBetween(String value1, String value2) {
			addCriterion("t_full_contributors_bank not between", value1, value2, "t_full_contributors_bank");
			return (Criteria) this;
		}

		public Criteria andT_add_dateIsNull() {
			addCriterion("t_add_date is null");
			return (Criteria) this;
		}

		public Criteria andT_add_dateIsNotNull() {
			addCriterion("t_add_date is not null");
			return (Criteria) this;
		}

		public Criteria andT_add_dateEqualTo(Date value) {
			addCriterion("t_add_date =", value, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateNotEqualTo(Date value) {
			addCriterion("t_add_date <>", value, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateGreaterThan(Date value) {
			addCriterion("t_add_date >", value, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateGreaterThanOrEqualTo(Date value) {
			addCriterion("t_add_date >=", value, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateLessThan(Date value) {
			addCriterion("t_add_date <", value, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateLessThanOrEqualTo(Date value) {
			addCriterion("t_add_date <=", value, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateIn(List<Date> values) {
			addCriterion("t_add_date in", values, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateNotIn(List<Date> values) {
			addCriterion("t_add_date not in", values, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateBetween(Date value1, Date value2) {
			addCriterion("t_add_date between", value1, value2, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_add_dateNotBetween(Date value1, Date value2) {
			addCriterion("t_add_date not between", value1, value2, "t_add_date");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberIsNull() {
			addCriterion("t_full_contributors_bank_number is null");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberIsNotNull() {
			addCriterion("t_full_contributors_bank_number is not null");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberEqualTo(String value) {
			addCriterion("t_full_contributors_bank_number =", value, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberNotEqualTo(String value) {
			addCriterion("t_full_contributors_bank_number <>", value, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberGreaterThan(String value) {
			addCriterion("t_full_contributors_bank_number >", value, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberGreaterThanOrEqualTo(String value) {
			addCriterion("t_full_contributors_bank_number >=", value, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberLessThan(String value) {
			addCriterion("t_full_contributors_bank_number <", value, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberLessThanOrEqualTo(String value) {
			addCriterion("t_full_contributors_bank_number <=", value, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberLike(String value) {
			addCriterion("t_full_contributors_bank_number like", value, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberNotLike(String value) {
			addCriterion("t_full_contributors_bank_number not like", value, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberIn(List<String> values) {
			addCriterion("t_full_contributors_bank_number in", values, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberNotIn(List<String> values) {
			addCriterion("t_full_contributors_bank_number not in", values, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberBetween(String value1, String value2) {
			addCriterion("t_full_contributors_bank_number between", value1, value2, "t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_bank_numberNotBetween(String value1, String value2) {
			addCriterion("t_full_contributors_bank_number not between", value1, value2,
					"t_full_contributors_bank_number");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeIsNull() {
			addCriterion("t_full_contributors_code is null");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeIsNotNull() {
			addCriterion("t_full_contributors_code is not null");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeEqualTo(String value) {
			addCriterion("t_full_contributors_code =", value, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeNotEqualTo(String value) {
			addCriterion("t_full_contributors_code <>", value, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeGreaterThan(String value) {
			addCriterion("t_full_contributors_code >", value, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeGreaterThanOrEqualTo(String value) {
			addCriterion("t_full_contributors_code >=", value, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeLessThan(String value) {
			addCriterion("t_full_contributors_code <", value, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeLessThanOrEqualTo(String value) {
			addCriterion("t_full_contributors_code <=", value, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeLike(String value) {
			addCriterion("t_full_contributors_code like", value, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeNotLike(String value) {
			addCriterion("t_full_contributors_code not like", value, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeIn(List<String> values) {
			addCriterion("t_full_contributors_code in", values, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeNotIn(List<String> values) {
			addCriterion("t_full_contributors_code not in", values, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeBetween(String value1, String value2) {
			addCriterion("t_full_contributors_code between", value1, value2, "t_full_contributors_code");
			return (Criteria) this;
		}

		public Criteria andT_full_contributors_codeNotBetween(String value1, String value2) {
			addCriterion("t_full_contributors_code not between", value1, value2, "t_full_contributors_code");
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

		public Criteria andT_create_dateIsNull() {
			addCriterion("t_create_date is null");
			return (Criteria) this;
		}

		public Criteria andT_create_dateIsNotNull() {
			addCriterion("t_create_date is not null");
			return (Criteria) this;
		}

		public Criteria andT_create_dateEqualTo(Date value) {
			addCriterion("t_create_date =", value, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateNotEqualTo(Date value) {
			addCriterion("t_create_date <>", value, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateGreaterThan(Date value) {
			addCriterion("t_create_date >", value, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateGreaterThanOrEqualTo(Date value) {
			addCriterion("t_create_date >=", value, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateLessThan(Date value) {
			addCriterion("t_create_date <", value, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateLessThanOrEqualTo(Date value) {
			addCriterion("t_create_date <=", value, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateIn(List<Date> values) {
			addCriterion("t_create_date in", values, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateNotIn(List<Date> values) {
			addCriterion("t_create_date not in", values, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateBetween(Date value1, Date value2) {
			addCriterion("t_create_date between", value1, value2, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_create_dateNotBetween(Date value1, Date value2) {
			addCriterion("t_create_date not between", value1, value2, "t_create_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateIsNull() {
			addCriterion("t_update_date is null");
			return (Criteria) this;
		}

		public Criteria andT_update_dateIsNotNull() {
			addCriterion("t_update_date is not null");
			return (Criteria) this;
		}

		public Criteria andT_update_dateEqualTo(Date value) {
			addCriterion("t_update_date =", value, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateNotEqualTo(Date value) {
			addCriterion("t_update_date <>", value, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateGreaterThan(Date value) {
			addCriterion("t_update_date >", value, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateGreaterThanOrEqualTo(Date value) {
			addCriterion("t_update_date >=", value, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateLessThan(Date value) {
			addCriterion("t_update_date <", value, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateLessThanOrEqualTo(Date value) {
			addCriterion("t_update_date <=", value, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateIn(List<Date> values) {
			addCriterion("t_update_date in", values, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateNotIn(List<Date> values) {
			addCriterion("t_update_date not in", values, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateBetween(Date value1, Date value2) {
			addCriterion("t_update_date between", value1, value2, "t_update_date");
			return (Criteria) this;
		}

		public Criteria andT_update_dateNotBetween(Date value1, Date value2) {
			addCriterion("t_update_date not between", value1, value2, "t_update_date");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_continbutors
	 * @mbg.generated  Sat Aug 11 10:11:56 CST 2018
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
     * This class corresponds to the database table t_continbutors
     *
     * @mbg.generated do_not_delete_during_merge Sat Aug 11 10:11:36 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}