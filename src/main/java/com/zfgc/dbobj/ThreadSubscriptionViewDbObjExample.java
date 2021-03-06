package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.List;

public class ThreadSubscriptionViewDbObjExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public ThreadSubscriptionViewDbObjExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andThreadIdIsNull() {
			addCriterion("THREAD_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreadIdIsNotNull() {
			addCriterion("THREAD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreadIdEqualTo(Integer value) {
			addCriterion("THREAD_ID =", value, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdNotEqualTo(Integer value) {
			addCriterion("THREAD_ID <>", value, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdGreaterThan(Integer value) {
			addCriterion("THREAD_ID >", value, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREAD_ID >=", value, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdLessThan(Integer value) {
			addCriterion("THREAD_ID <", value, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREAD_ID <=", value, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdIn(List<Integer> values) {
			addCriterion("THREAD_ID in", values, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdNotIn(List<Integer> values) {
			addCriterion("THREAD_ID not in", values, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdBetween(Integer value1, Integer value2) {
			addCriterion("THREAD_ID between", value1, value2, "threadId");
			return (Criteria) this;
		}

		public Criteria andThreadIdNotBetween(Integer value1, Integer value2) {
			addCriterion("THREAD_ID not between", value1, value2, "threadId");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdIsNull() {
			addCriterion("SUBSCRIBER_ID is null");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdIsNotNull() {
			addCriterion("SUBSCRIBER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdEqualTo(Integer value) {
			addCriterion("SUBSCRIBER_ID =", value, "subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdNotEqualTo(Integer value) {
			addCriterion("SUBSCRIBER_ID <>", value, "subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdGreaterThan(Integer value) {
			addCriterion("SUBSCRIBER_ID >", value, "subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SUBSCRIBER_ID >=", value, "subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdLessThan(Integer value) {
			addCriterion("SUBSCRIBER_ID <", value, "subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdLessThanOrEqualTo(Integer value) {
			addCriterion("SUBSCRIBER_ID <=", value, "subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdIn(List<Integer> values) {
			addCriterion("SUBSCRIBER_ID in", values, "subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdNotIn(List<Integer> values) {
			addCriterion("SUBSCRIBER_ID not in", values, "subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdBetween(Integer value1, Integer value2) {
			addCriterion("SUBSCRIBER_ID between", value1, value2,
					"subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SUBSCRIBER_ID not between", value1, value2,
					"subscriberId");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameIsNull() {
			addCriterion("SUBSCRIBER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameIsNotNull() {
			addCriterion("SUBSCRIBER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameEqualTo(String value) {
			addCriterion("SUBSCRIBER_NAME =", value, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameNotEqualTo(String value) {
			addCriterion("SUBSCRIBER_NAME <>", value, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameGreaterThan(String value) {
			addCriterion("SUBSCRIBER_NAME >", value, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameGreaterThanOrEqualTo(String value) {
			addCriterion("SUBSCRIBER_NAME >=", value, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameLessThan(String value) {
			addCriterion("SUBSCRIBER_NAME <", value, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameLessThanOrEqualTo(String value) {
			addCriterion("SUBSCRIBER_NAME <=", value, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameLike(String value) {
			addCriterion("SUBSCRIBER_NAME like", value, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameNotLike(String value) {
			addCriterion("SUBSCRIBER_NAME not like", value, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameIn(List<String> values) {
			addCriterion("SUBSCRIBER_NAME in", values, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameNotIn(List<String> values) {
			addCriterion("SUBSCRIBER_NAME not in", values, "subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameBetween(String value1, String value2) {
			addCriterion("SUBSCRIBER_NAME between", value1, value2,
					"subscriberName");
			return (Criteria) this;
		}

		public Criteria andSubscriberNameNotBetween(String value1, String value2) {
			addCriterion("SUBSCRIBER_NAME not between", value1, value2,
					"subscriberName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdIsNull() {
			addCriterion("THREAD_STARTER_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdIsNotNull() {
			addCriterion("THREAD_STARTER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdEqualTo(Integer value) {
			addCriterion("THREAD_STARTER_ID =", value, "threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdNotEqualTo(Integer value) {
			addCriterion("THREAD_STARTER_ID <>", value, "threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdGreaterThan(Integer value) {
			addCriterion("THREAD_STARTER_ID >", value, "threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREAD_STARTER_ID >=", value, "threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdLessThan(Integer value) {
			addCriterion("THREAD_STARTER_ID <", value, "threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREAD_STARTER_ID <=", value, "threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdIn(List<Integer> values) {
			addCriterion("THREAD_STARTER_ID in", values, "threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdNotIn(List<Integer> values) {
			addCriterion("THREAD_STARTER_ID not in", values, "threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdBetween(Integer value1, Integer value2) {
			addCriterion("THREAD_STARTER_ID between", value1, value2,
					"threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("THREAD_STARTER_ID not between", value1, value2,
					"threadStarterId");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameIsNull() {
			addCriterion("THREAD_STARTER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameIsNotNull() {
			addCriterion("THREAD_STARTER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameEqualTo(String value) {
			addCriterion("THREAD_STARTER_NAME =", value, "threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameNotEqualTo(String value) {
			addCriterion("THREAD_STARTER_NAME <>", value, "threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameGreaterThan(String value) {
			addCriterion("THREAD_STARTER_NAME >", value, "threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameGreaterThanOrEqualTo(String value) {
			addCriterion("THREAD_STARTER_NAME >=", value, "threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameLessThan(String value) {
			addCriterion("THREAD_STARTER_NAME <", value, "threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameLessThanOrEqualTo(String value) {
			addCriterion("THREAD_STARTER_NAME <=", value, "threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameLike(String value) {
			addCriterion("THREAD_STARTER_NAME like", value, "threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameNotLike(String value) {
			addCriterion("THREAD_STARTER_NAME not like", value,
					"threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameIn(List<String> values) {
			addCriterion("THREAD_STARTER_NAME in", values, "threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameNotIn(List<String> values) {
			addCriterion("THREAD_STARTER_NAME not in", values,
					"threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameBetween(String value1, String value2) {
			addCriterion("THREAD_STARTER_NAME between", value1, value2,
					"threadStarterName");
			return (Criteria) this;
		}

		public Criteria andThreadStarterNameNotBetween(String value1,
				String value2) {
			addCriterion("THREAD_STARTER_NAME not between", value1, value2,
					"threadStarterName");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table THREAD_SUBSCRIPTION_VIEW
	 * @mbggenerated  Sat Feb 25 18:45:20 EST 2017
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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
     * This class corresponds to the database table THREAD_SUBSCRIPTION_VIEW
     *
     * @mbggenerated do_not_delete_during_merge Fri Feb 17 18:33:28 EST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}