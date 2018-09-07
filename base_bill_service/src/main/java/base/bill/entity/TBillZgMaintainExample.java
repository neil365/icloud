package base.bill.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * 票据字轨维护
 * @author wangp
 * @time 2018-08-08
 */
public class TBillZgMaintainExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public TBillZgMaintainExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_bill_zg_maintain
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_bill_zg_maintain
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

		public Criteria andBill_zg_maintain_idIsNull() {
			addCriterion("bill_zg_maintain_id is null");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idIsNotNull() {
			addCriterion("bill_zg_maintain_id is not null");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idEqualTo(Integer value) {
			addCriterion("bill_zg_maintain_id =", value, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idNotEqualTo(Integer value) {
			addCriterion("bill_zg_maintain_id <>", value, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idGreaterThan(Integer value) {
			addCriterion("bill_zg_maintain_id >", value, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("bill_zg_maintain_id >=", value, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idLessThan(Integer value) {
			addCriterion("bill_zg_maintain_id <", value, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idLessThanOrEqualTo(Integer value) {
			addCriterion("bill_zg_maintain_id <=", value, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idIn(List<Integer> values) {
			addCriterion("bill_zg_maintain_id in", values, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idNotIn(List<Integer> values) {
			addCriterion("bill_zg_maintain_id not in", values, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idBetween(Integer value1, Integer value2) {
			addCriterion("bill_zg_maintain_id between", value1, value2, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBill_zg_maintain_idNotBetween(Integer value1, Integer value2) {
			addCriterion("bill_zg_maintain_id not between", value1, value2, "bill_zg_maintain_id");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameIsNull() {
			addCriterion("billzg_name is null");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameIsNotNull() {
			addCriterion("billzg_name is not null");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameEqualTo(String value) {
			addCriterion("billzg_name =", value, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameNotEqualTo(String value) {
			addCriterion("billzg_name <>", value, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameGreaterThan(String value) {
			addCriterion("billzg_name >", value, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameGreaterThanOrEqualTo(String value) {
			addCriterion("billzg_name >=", value, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameLessThan(String value) {
			addCriterion("billzg_name <", value, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameLessThanOrEqualTo(String value) {
			addCriterion("billzg_name <=", value, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameLike(String value) {
			addCriterion("billzg_name like", value, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameNotLike(String value) {
			addCriterion("billzg_name not like", value, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameIn(List<String> values) {
			addCriterion("billzg_name in", values, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameNotIn(List<String> values) {
			addCriterion("billzg_name not in", values, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameBetween(String value1, String value2) {
			addCriterion("billzg_name between", value1, value2, "billzg_name");
			return (Criteria) this;
		}

		public Criteria andBillzg_nameNotBetween(String value1, String value2) {
			addCriterion("billzg_name not between", value1, value2, "billzg_name");
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

		public Criteria andBill_type_idIsNull() {
			addCriterion("bill_type_id is null");
			return (Criteria) this;
		}

		public Criteria andBill_type_idIsNotNull() {
			addCriterion("bill_type_id is not null");
			return (Criteria) this;
		}

		public Criteria andBill_type_idEqualTo(Integer value) {
			addCriterion("bill_type_id =", value, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idNotEqualTo(Integer value) {
			addCriterion("bill_type_id <>", value, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idGreaterThan(Integer value) {
			addCriterion("bill_type_id >", value, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("bill_type_id >=", value, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idLessThan(Integer value) {
			addCriterion("bill_type_id <", value, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idLessThanOrEqualTo(Integer value) {
			addCriterion("bill_type_id <=", value, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idIn(List<Integer> values) {
			addCriterion("bill_type_id in", values, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idNotIn(List<Integer> values) {
			addCriterion("bill_type_id not in", values, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idBetween(Integer value1, Integer value2) {
			addCriterion("bill_type_id between", value1, value2, "bill_type_id");
			return (Criteria) this;
		}

		public Criteria andBill_type_idNotBetween(Integer value1, Integer value2) {
			addCriterion("bill_type_id not between", value1, value2, "bill_type_id");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_bill_zg_maintain
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
     * This class corresponds to the database table t_bill_zg_maintain
     *
     * @mbg.generated do_not_delete_during_merge Wed Aug 08 10:13:11 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}