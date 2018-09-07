package base.bill.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RefundApplicationMingxiExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public RefundApplicationMingxiExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table refund_application_mingxi
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table refund_application_mingxi
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

		public Criteria andMingxi_idIsNull() {
			addCriterion("mingxi_id is null");
			return (Criteria) this;
		}

		public Criteria andMingxi_idIsNotNull() {
			addCriterion("mingxi_id is not null");
			return (Criteria) this;
		}

		public Criteria andMingxi_idEqualTo(Integer value) {
			addCriterion("mingxi_id =", value, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idNotEqualTo(Integer value) {
			addCriterion("mingxi_id <>", value, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idGreaterThan(Integer value) {
			addCriterion("mingxi_id >", value, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("mingxi_id >=", value, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idLessThan(Integer value) {
			addCriterion("mingxi_id <", value, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idLessThanOrEqualTo(Integer value) {
			addCriterion("mingxi_id <=", value, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idIn(List<Integer> values) {
			addCriterion("mingxi_id in", values, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idNotIn(List<Integer> values) {
			addCriterion("mingxi_id not in", values, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idBetween(Integer value1, Integer value2) {
			addCriterion("mingxi_id between", value1, value2, "mingxi_id");
			return (Criteria) this;
		}

		public Criteria andMingxi_idNotBetween(Integer value1, Integer value2) {
			addCriterion("mingxi_id not between", value1, value2, "mingxi_id");
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

		public Criteria andBill_informationIsNull() {
			addCriterion("bill_information is null");
			return (Criteria) this;
		}

		public Criteria andBill_informationIsNotNull() {
			addCriterion("bill_information is not null");
			return (Criteria) this;
		}

		public Criteria andBill_informationEqualTo(String value) {
			addCriterion("bill_information =", value, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationNotEqualTo(String value) {
			addCriterion("bill_information <>", value, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationGreaterThan(String value) {
			addCriterion("bill_information >", value, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationGreaterThanOrEqualTo(String value) {
			addCriterion("bill_information >=", value, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationLessThan(String value) {
			addCriterion("bill_information <", value, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationLessThanOrEqualTo(String value) {
			addCriterion("bill_information <=", value, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationLike(String value) {
			addCriterion("bill_information like", value, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationNotLike(String value) {
			addCriterion("bill_information not like", value, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationIn(List<String> values) {
			addCriterion("bill_information in", values, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationNotIn(List<String> values) {
			addCriterion("bill_information not in", values, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationBetween(String value1, String value2) {
			addCriterion("bill_information between", value1, value2, "bill_information");
			return (Criteria) this;
		}

		public Criteria andBill_informationNotBetween(String value1, String value2) {
			addCriterion("bill_information not between", value1, value2, "bill_information");
			return (Criteria) this;
		}

		public Criteria andReasons_refundIsNull() {
			addCriterion("reasons_refund is null");
			return (Criteria) this;
		}

		public Criteria andReasons_refundIsNotNull() {
			addCriterion("reasons_refund is not null");
			return (Criteria) this;
		}

		public Criteria andReasons_refundEqualTo(String value) {
			addCriterion("reasons_refund =", value, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundNotEqualTo(String value) {
			addCriterion("reasons_refund <>", value, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundGreaterThan(String value) {
			addCriterion("reasons_refund >", value, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundGreaterThanOrEqualTo(String value) {
			addCriterion("reasons_refund >=", value, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundLessThan(String value) {
			addCriterion("reasons_refund <", value, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundLessThanOrEqualTo(String value) {
			addCriterion("reasons_refund <=", value, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundLike(String value) {
			addCriterion("reasons_refund like", value, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundNotLike(String value) {
			addCriterion("reasons_refund not like", value, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundIn(List<String> values) {
			addCriterion("reasons_refund in", values, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundNotIn(List<String> values) {
			addCriterion("reasons_refund not in", values, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundBetween(String value1, String value2) {
			addCriterion("reasons_refund between", value1, value2, "reasons_refund");
			return (Criteria) this;
		}

		public Criteria andReasons_refundNotBetween(String value1, String value2) {
			addCriterion("reasons_refund not between", value1, value2, "reasons_refund");
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

		public Criteria andUpdate_dateIsNull() {
			addCriterion("update_date is null");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateIsNotNull() {
			addCriterion("update_date is not null");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateEqualTo(Date value) {
			addCriterionForJDBCDate("update_date =", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("update_date <>", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("update_date >", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("update_date >=", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateLessThan(Date value) {
			addCriterionForJDBCDate("update_date <", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("update_date <=", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateIn(List<Date> values) {
			addCriterionForJDBCDate("update_date in", values, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("update_date not in", values, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("update_date between", value1, value2, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("update_date not between", value1, value2, "update_date");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table refund_application_mingxi
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
     * This class corresponds to the database table refund_application_mingxi
     *
     * @mbg.generated do_not_delete_during_merge Tue Sep 04 17:53:25 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}