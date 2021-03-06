package com.usersauth.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysRoleExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public SysRoleExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
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

		public Criteria andRole_codeIsNull() {
			addCriterion("role_code is null");
			return (Criteria) this;
		}

		public Criteria andRole_codeIsNotNull() {
			addCriterion("role_code is not null");
			return (Criteria) this;
		}

		public Criteria andRole_codeEqualTo(String value) {
			addCriterion("role_code =", value, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeNotEqualTo(String value) {
			addCriterion("role_code <>", value, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeGreaterThan(String value) {
			addCriterion("role_code >", value, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeGreaterThanOrEqualTo(String value) {
			addCriterion("role_code >=", value, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeLessThan(String value) {
			addCriterion("role_code <", value, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeLessThanOrEqualTo(String value) {
			addCriterion("role_code <=", value, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeLike(String value) {
			addCriterion("role_code like", value, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeNotLike(String value) {
			addCriterion("role_code not like", value, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeIn(List<String> values) {
			addCriterion("role_code in", values, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeNotIn(List<String> values) {
			addCriterion("role_code not in", values, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeBetween(String value1, String value2) {
			addCriterion("role_code between", value1, value2, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_codeNotBetween(String value1, String value2) {
			addCriterion("role_code not between", value1, value2, "role_code");
			return (Criteria) this;
		}

		public Criteria andRole_nameIsNull() {
			addCriterion("role_name is null");
			return (Criteria) this;
		}

		public Criteria andRole_nameIsNotNull() {
			addCriterion("role_name is not null");
			return (Criteria) this;
		}

		public Criteria andRole_nameEqualTo(String value) {
			addCriterion("role_name =", value, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameNotEqualTo(String value) {
			addCriterion("role_name <>", value, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameGreaterThan(String value) {
			addCriterion("role_name >", value, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameGreaterThanOrEqualTo(String value) {
			addCriterion("role_name >=", value, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameLessThan(String value) {
			addCriterion("role_name <", value, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameLessThanOrEqualTo(String value) {
			addCriterion("role_name <=", value, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameLike(String value) {
			addCriterion("role_name like", value, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameNotLike(String value) {
			addCriterion("role_name not like", value, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameIn(List<String> values) {
			addCriterion("role_name in", values, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameNotIn(List<String> values) {
			addCriterion("role_name not in", values, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameBetween(String value1, String value2) {
			addCriterion("role_name between", value1, value2, "role_name");
			return (Criteria) this;
		}

		public Criteria andRole_nameNotBetween(String value1, String value2) {
			addCriterion("role_name not between", value1, value2, "role_name");
			return (Criteria) this;
		}

		public Criteria andCreate_timeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreate_timeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreate_timeEqualTo(Date value) {
			addCriterion("create_time =", value, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeGreaterThan(Date value) {
			addCriterion("create_time >", value, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeLessThan(Date value) {
			addCriterion("create_time <", value, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeIn(List<Date> values) {
			addCriterion("create_time in", values, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "create_time");
			return (Criteria) this;
		}

		public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "create_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeEqualTo(Date value) {
			addCriterion("update_time =", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeGreaterThan(Date value) {
			addCriterion("update_time >", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeLessThan(Date value) {
			addCriterion("update_time <", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeIn(List<Date> values) {
			addCriterion("update_time in", values, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2, "update_time");
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

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andStatus_codeIsNull() {
			addCriterion("status_code is null");
			return (Criteria) this;
		}

		public Criteria andStatus_codeIsNotNull() {
			addCriterion("status_code is not null");
			return (Criteria) this;
		}

		public Criteria andStatus_codeEqualTo(Integer value) {
			addCriterion("status_code =", value, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeNotEqualTo(Integer value) {
			addCriterion("status_code <>", value, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeGreaterThan(Integer value) {
			addCriterion("status_code >", value, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeGreaterThanOrEqualTo(Integer value) {
			addCriterion("status_code >=", value, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeLessThan(Integer value) {
			addCriterion("status_code <", value, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeLessThanOrEqualTo(Integer value) {
			addCriterion("status_code <=", value, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeIn(List<Integer> values) {
			addCriterion("status_code in", values, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeNotIn(List<Integer> values) {
			addCriterion("status_code not in", values, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeBetween(Integer value1, Integer value2) {
			addCriterion("status_code between", value1, value2, "status_code");
			return (Criteria) this;
		}

		public Criteria andStatus_codeNotBetween(Integer value1, Integer value2) {
			addCriterion("status_code not between", value1, value2, "status_code");
			return (Criteria) this;
		}

		public Criteria andService_tokenIsNull() {
			addCriterion("service_token is null");
			return (Criteria) this;
		}

		public Criteria andService_tokenIsNotNull() {
			addCriterion("service_token is not null");
			return (Criteria) this;
		}

		public Criteria andService_tokenEqualTo(String value) {
			addCriterion("service_token =", value, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenNotEqualTo(String value) {
			addCriterion("service_token <>", value, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenGreaterThan(String value) {
			addCriterion("service_token >", value, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenGreaterThanOrEqualTo(String value) {
			addCriterion("service_token >=", value, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenLessThan(String value) {
			addCriterion("service_token <", value, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenLessThanOrEqualTo(String value) {
			addCriterion("service_token <=", value, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenLike(String value) {
			addCriterion("service_token like", value, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenNotLike(String value) {
			addCriterion("service_token not like", value, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenIn(List<String> values) {
			addCriterion("service_token in", values, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenNotIn(List<String> values) {
			addCriterion("service_token not in", values, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenBetween(String value1, String value2) {
			addCriterion("service_token between", value1, value2, "service_token");
			return (Criteria) this;
		}

		public Criteria andService_tokenNotBetween(String value1, String value2) {
			addCriterion("service_token not between", value1, value2, "service_token");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_role
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
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
     * This class corresponds to the database table sys_role
     *
     * @mbg.generated do_not_delete_during_merge Tue Apr 17 15:36:58 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}