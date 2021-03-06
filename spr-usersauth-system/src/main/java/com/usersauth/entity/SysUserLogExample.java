package com.usersauth.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserLogExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public SysUserLogExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user_log
	 * @mbg.generated  Fri Aug 17 09:38:07 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_user_log
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

		public Criteria andUser_idIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUser_idIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUser_idEqualTo(Integer value) {
			addCriterion("user_id =", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idGreaterThan(Integer value) {
			addCriterion("user_id >", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idLessThan(Integer value) {
			addCriterion("user_id <", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idIn(List<Integer> values) {
			addCriterion("user_id in", values, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_nameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUser_nameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUser_nameEqualTo(String value) {
			addCriterion("user_name =", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameGreaterThan(String value) {
			addCriterion("user_name >", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameLessThan(String value) {
			addCriterion("user_name <", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameLike(String value) {
			addCriterion("user_name like", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameNotLike(String value) {
			addCriterion("user_name not like", value, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameIn(List<String> values) {
			addCriterion("user_name in", values, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "user_name");
			return (Criteria) this;
		}

		public Criteria andUser_nameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "user_name");
			return (Criteria) this;
		}

		public Criteria andMenu_codeIsNull() {
			addCriterion("menu_code is null");
			return (Criteria) this;
		}

		public Criteria andMenu_codeIsNotNull() {
			addCriterion("menu_code is not null");
			return (Criteria) this;
		}

		public Criteria andMenu_codeEqualTo(String value) {
			addCriterion("menu_code =", value, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeNotEqualTo(String value) {
			addCriterion("menu_code <>", value, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeGreaterThan(String value) {
			addCriterion("menu_code >", value, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeGreaterThanOrEqualTo(String value) {
			addCriterion("menu_code >=", value, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeLessThan(String value) {
			addCriterion("menu_code <", value, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeLessThanOrEqualTo(String value) {
			addCriterion("menu_code <=", value, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeLike(String value) {
			addCriterion("menu_code like", value, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeNotLike(String value) {
			addCriterion("menu_code not like", value, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeIn(List<String> values) {
			addCriterion("menu_code in", values, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeNotIn(List<String> values) {
			addCriterion("menu_code not in", values, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeBetween(String value1, String value2) {
			addCriterion("menu_code between", value1, value2, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_codeNotBetween(String value1, String value2) {
			addCriterion("menu_code not between", value1, value2, "menu_code");
			return (Criteria) this;
		}

		public Criteria andMenu_nameIsNull() {
			addCriterion("menu_name is null");
			return (Criteria) this;
		}

		public Criteria andMenu_nameIsNotNull() {
			addCriterion("menu_name is not null");
			return (Criteria) this;
		}

		public Criteria andMenu_nameEqualTo(String value) {
			addCriterion("menu_name =", value, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameNotEqualTo(String value) {
			addCriterion("menu_name <>", value, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameGreaterThan(String value) {
			addCriterion("menu_name >", value, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameGreaterThanOrEqualTo(String value) {
			addCriterion("menu_name >=", value, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameLessThan(String value) {
			addCriterion("menu_name <", value, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameLessThanOrEqualTo(String value) {
			addCriterion("menu_name <=", value, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameLike(String value) {
			addCriterion("menu_name like", value, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameNotLike(String value) {
			addCriterion("menu_name not like", value, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameIn(List<String> values) {
			addCriterion("menu_name in", values, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameNotIn(List<String> values) {
			addCriterion("menu_name not in", values, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameBetween(String value1, String value2) {
			addCriterion("menu_name between", value1, value2, "menu_name");
			return (Criteria) this;
		}

		public Criteria andMenu_nameNotBetween(String value1, String value2) {
			addCriterion("menu_name not between", value1, value2, "menu_name");
			return (Criteria) this;
		}

		public Criteria andPermission_codeIsNull() {
			addCriterion("permission_code is null");
			return (Criteria) this;
		}

		public Criteria andPermission_codeIsNotNull() {
			addCriterion("permission_code is not null");
			return (Criteria) this;
		}

		public Criteria andPermission_codeEqualTo(String value) {
			addCriterion("permission_code =", value, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeNotEqualTo(String value) {
			addCriterion("permission_code <>", value, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeGreaterThan(String value) {
			addCriterion("permission_code >", value, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeGreaterThanOrEqualTo(String value) {
			addCriterion("permission_code >=", value, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeLessThan(String value) {
			addCriterion("permission_code <", value, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeLessThanOrEqualTo(String value) {
			addCriterion("permission_code <=", value, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeLike(String value) {
			addCriterion("permission_code like", value, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeNotLike(String value) {
			addCriterion("permission_code not like", value, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeIn(List<String> values) {
			addCriterion("permission_code in", values, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeNotIn(List<String> values) {
			addCriterion("permission_code not in", values, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeBetween(String value1, String value2) {
			addCriterion("permission_code between", value1, value2, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_codeNotBetween(String value1, String value2) {
			addCriterion("permission_code not between", value1, value2, "permission_code");
			return (Criteria) this;
		}

		public Criteria andPermission_nameIsNull() {
			addCriterion("permission_name is null");
			return (Criteria) this;
		}

		public Criteria andPermission_nameIsNotNull() {
			addCriterion("permission_name is not null");
			return (Criteria) this;
		}

		public Criteria andPermission_nameEqualTo(String value) {
			addCriterion("permission_name =", value, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameNotEqualTo(String value) {
			addCriterion("permission_name <>", value, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameGreaterThan(String value) {
			addCriterion("permission_name >", value, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameGreaterThanOrEqualTo(String value) {
			addCriterion("permission_name >=", value, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameLessThan(String value) {
			addCriterion("permission_name <", value, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameLessThanOrEqualTo(String value) {
			addCriterion("permission_name <=", value, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameLike(String value) {
			addCriterion("permission_name like", value, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameNotLike(String value) {
			addCriterion("permission_name not like", value, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameIn(List<String> values) {
			addCriterion("permission_name in", values, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameNotIn(List<String> values) {
			addCriterion("permission_name not in", values, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameBetween(String value1, String value2) {
			addCriterion("permission_name between", value1, value2, "permission_name");
			return (Criteria) this;
		}

		public Criteria andPermission_nameNotBetween(String value1, String value2) {
			addCriterion("permission_name not between", value1, value2, "permission_name");
			return (Criteria) this;
		}

		public Criteria andRecord_dateIsNull() {
			addCriterion("record_date is null");
			return (Criteria) this;
		}

		public Criteria andRecord_dateIsNotNull() {
			addCriterion("record_date is not null");
			return (Criteria) this;
		}

		public Criteria andRecord_dateEqualTo(Date value) {
			addCriterion("record_date =", value, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateNotEqualTo(Date value) {
			addCriterion("record_date <>", value, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateGreaterThan(Date value) {
			addCriterion("record_date >", value, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateGreaterThanOrEqualTo(Date value) {
			addCriterion("record_date >=", value, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateLessThan(Date value) {
			addCriterion("record_date <", value, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateLessThanOrEqualTo(Date value) {
			addCriterion("record_date <=", value, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateIn(List<Date> values) {
			addCriterion("record_date in", values, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateNotIn(List<Date> values) {
			addCriterion("record_date not in", values, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateBetween(Date value1, Date value2) {
			addCriterion("record_date between", value1, value2, "record_date");
			return (Criteria) this;
		}

		public Criteria andRecord_dateNotBetween(Date value1, Date value2) {
			addCriterion("record_date not between", value1, value2, "record_date");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_user_log
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
     * This class corresponds to the database table sys_user_log
     *
     * @mbg.generated do_not_delete_during_merge Wed May 30 10:45:53 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}