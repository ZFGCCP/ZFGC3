package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IpAddressDbObjExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public IpAddressDbObjExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
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

		public Criteria andIpAddressIdIsNull() {
			addCriterion("IP_ADDRESS_ID is null");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdIsNotNull() {
			addCriterion("IP_ADDRESS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdEqualTo(Integer value) {
			addCriterion("IP_ADDRESS_ID =", value, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdNotEqualTo(Integer value) {
			addCriterion("IP_ADDRESS_ID <>", value, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdGreaterThan(Integer value) {
			addCriterion("IP_ADDRESS_ID >", value, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("IP_ADDRESS_ID >=", value, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdLessThan(Integer value) {
			addCriterion("IP_ADDRESS_ID <", value, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdLessThanOrEqualTo(Integer value) {
			addCriterion("IP_ADDRESS_ID <=", value, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdIn(List<Integer> values) {
			addCriterion("IP_ADDRESS_ID in", values, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdNotIn(List<Integer> values) {
			addCriterion("IP_ADDRESS_ID not in", values, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdBetween(Integer value1, Integer value2) {
			addCriterion("IP_ADDRESS_ID between", value1, value2, "ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIdNotBetween(Integer value1, Integer value2) {
			addCriterion("IP_ADDRESS_ID not between", value1, value2,
					"ipAddressId");
			return (Criteria) this;
		}

		public Criteria andIpAddressIsNull() {
			addCriterion("IP_ADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andIpAddressIsNotNull() {
			addCriterion("IP_ADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andIpAddressEqualTo(String value) {
			addCriterion("IP_ADDRESS =", value, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressNotEqualTo(String value) {
			addCriterion("IP_ADDRESS <>", value, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressGreaterThan(String value) {
			addCriterion("IP_ADDRESS >", value, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
			addCriterion("IP_ADDRESS >=", value, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressLessThan(String value) {
			addCriterion("IP_ADDRESS <", value, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressLessThanOrEqualTo(String value) {
			addCriterion("IP_ADDRESS <=", value, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressLike(String value) {
			addCriterion("IP_ADDRESS like", value, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressNotLike(String value) {
			addCriterion("IP_ADDRESS not like", value, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressIn(List<String> values) {
			addCriterion("IP_ADDRESS in", values, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressNotIn(List<String> values) {
			addCriterion("IP_ADDRESS not in", values, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressBetween(String value1, String value2) {
			addCriterion("IP_ADDRESS between", value1, value2, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andIpAddressNotBetween(String value1, String value2) {
			addCriterion("IP_ADDRESS not between", value1, value2, "ipAddress");
			return (Criteria) this;
		}

		public Criteria andVersionIsNull() {
			addCriterion("VERSION is null");
			return (Criteria) this;
		}

		public Criteria andVersionIsNotNull() {
			addCriterion("VERSION is not null");
			return (Criteria) this;
		}

		public Criteria andVersionEqualTo(Byte value) {
			addCriterion("VERSION =", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotEqualTo(Byte value) {
			addCriterion("VERSION <>", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThan(Byte value) {
			addCriterion("VERSION >", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThanOrEqualTo(Byte value) {
			addCriterion("VERSION >=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThan(Byte value) {
			addCriterion("VERSION <", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThanOrEqualTo(Byte value) {
			addCriterion("VERSION <=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionIn(List<Byte> values) {
			addCriterion("VERSION in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotIn(List<Byte> values) {
			addCriterion("VERSION not in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionBetween(Byte value1, Byte value2) {
			addCriterion("VERSION between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotBetween(Byte value1, Byte value2) {
			addCriterion("VERSION not between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagIsNull() {
			addCriterion("IS_SPAMMER_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagIsNotNull() {
			addCriterion("IS_SPAMMER_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagEqualTo(Boolean value) {
			addCriterion("IS_SPAMMER_FLAG =", value, "isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagNotEqualTo(Boolean value) {
			addCriterion("IS_SPAMMER_FLAG <>", value, "isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagGreaterThan(Boolean value) {
			addCriterion("IS_SPAMMER_FLAG >", value, "isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_SPAMMER_FLAG >=", value, "isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagLessThan(Boolean value) {
			addCriterion("IS_SPAMMER_FLAG <", value, "isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_SPAMMER_FLAG <=", value, "isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagIn(List<Boolean> values) {
			addCriterion("IS_SPAMMER_FLAG in", values, "isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagNotIn(List<Boolean> values) {
			addCriterion("IS_SPAMMER_FLAG not in", values, "isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_SPAMMER_FLAG between", value1, value2,
					"isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsSpammerFlagNotBetween(Boolean value1,
				Boolean value2) {
			addCriterion("IS_SPAMMER_FLAG not between", value1, value2,
					"isSpammerFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagIsNull() {
			addCriterion("IS_LOCKED_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagIsNotNull() {
			addCriterion("IS_LOCKED_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagEqualTo(Boolean value) {
			addCriterion("IS_LOCKED_FLAG =", value, "isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagNotEqualTo(Boolean value) {
			addCriterion("IS_LOCKED_FLAG <>", value, "isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagGreaterThan(Boolean value) {
			addCriterion("IS_LOCKED_FLAG >", value, "isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_LOCKED_FLAG >=", value, "isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagLessThan(Boolean value) {
			addCriterion("IS_LOCKED_FLAG <", value, "isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_LOCKED_FLAG <=", value, "isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagIn(List<Boolean> values) {
			addCriterion("IS_LOCKED_FLAG in", values, "isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagNotIn(List<Boolean> values) {
			addCriterion("IS_LOCKED_FLAG not in", values, "isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_LOCKED_FLAG between", value1, value2,
					"isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andIsLockedFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_LOCKED_FLAG not between", value1, value2,
					"isLockedFlag");
			return (Criteria) this;
		}

		public Criteria andLockedUntilIsNull() {
			addCriterion("LOCKED_UNTIL is null");
			return (Criteria) this;
		}

		public Criteria andLockedUntilIsNotNull() {
			addCriterion("LOCKED_UNTIL is not null");
			return (Criteria) this;
		}

		public Criteria andLockedUntilEqualTo(Date value) {
			addCriterion("LOCKED_UNTIL =", value, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilNotEqualTo(Date value) {
			addCriterion("LOCKED_UNTIL <>", value, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilGreaterThan(Date value) {
			addCriterion("LOCKED_UNTIL >", value, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilGreaterThanOrEqualTo(Date value) {
			addCriterion("LOCKED_UNTIL >=", value, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilLessThan(Date value) {
			addCriterion("LOCKED_UNTIL <", value, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilLessThanOrEqualTo(Date value) {
			addCriterion("LOCKED_UNTIL <=", value, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilIn(List<Date> values) {
			addCriterion("LOCKED_UNTIL in", values, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilNotIn(List<Date> values) {
			addCriterion("LOCKED_UNTIL not in", values, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilBetween(Date value1, Date value2) {
			addCriterion("LOCKED_UNTIL between", value1, value2, "lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLockedUntilNotBetween(Date value1, Date value2) {
			addCriterion("LOCKED_UNTIL not between", value1, value2,
					"lockedUntil");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsIsNull() {
			addCriterion("LOGIN_ATTEMPTS is null");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsIsNotNull() {
			addCriterion("LOGIN_ATTEMPTS is not null");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsEqualTo(Integer value) {
			addCriterion("LOGIN_ATTEMPTS =", value, "loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsNotEqualTo(Integer value) {
			addCriterion("LOGIN_ATTEMPTS <>", value, "loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsGreaterThan(Integer value) {
			addCriterion("LOGIN_ATTEMPTS >", value, "loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsGreaterThanOrEqualTo(Integer value) {
			addCriterion("LOGIN_ATTEMPTS >=", value, "loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsLessThan(Integer value) {
			addCriterion("LOGIN_ATTEMPTS <", value, "loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsLessThanOrEqualTo(Integer value) {
			addCriterion("LOGIN_ATTEMPTS <=", value, "loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsIn(List<Integer> values) {
			addCriterion("LOGIN_ATTEMPTS in", values, "loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsNotIn(List<Integer> values) {
			addCriterion("LOGIN_ATTEMPTS not in", values, "loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsBetween(Integer value1, Integer value2) {
			addCriterion("LOGIN_ATTEMPTS between", value1, value2,
					"loginAttempts");
			return (Criteria) this;
		}

		public Criteria andLoginAttemptsNotBetween(Integer value1,
				Integer value2) {
			addCriterion("LOGIN_ATTEMPTS not between", value1, value2,
					"loginAttempts");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table IP_ADDRESS
	 * @mbggenerated  Tue Apr 30 12:15:34 EDT 2019
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
     * This class corresponds to the database table IP_ADDRESS
     *
     * @mbggenerated do_not_delete_during_merge Mon Dec 12 00:09:53 EST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}