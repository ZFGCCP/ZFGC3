package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemSettingsDbObjExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public SystemSettingsDbObjExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
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

		public Criteria andSystemSettingIdIsNull() {
			addCriterion("SYSTEM_SETTING_ID is null");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdIsNotNull() {
			addCriterion("SYSTEM_SETTING_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdEqualTo(Integer value) {
			addCriterion("SYSTEM_SETTING_ID =", value, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdNotEqualTo(Integer value) {
			addCriterion("SYSTEM_SETTING_ID <>", value, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdGreaterThan(Integer value) {
			addCriterion("SYSTEM_SETTING_ID >", value, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SYSTEM_SETTING_ID >=", value, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdLessThan(Integer value) {
			addCriterion("SYSTEM_SETTING_ID <", value, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdLessThanOrEqualTo(Integer value) {
			addCriterion("SYSTEM_SETTING_ID <=", value, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdIn(List<Integer> values) {
			addCriterion("SYSTEM_SETTING_ID in", values, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdNotIn(List<Integer> values) {
			addCriterion("SYSTEM_SETTING_ID not in", values, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdBetween(Integer value1, Integer value2) {
			addCriterion("SYSTEM_SETTING_ID between", value1, value2, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andSystemSettingIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SYSTEM_SETTING_ID not between", value1, value2, "systemSettingId");
			return (Criteria) this;
		}

		public Criteria andValueIsNull() {
			addCriterion("VALUE is null");
			return (Criteria) this;
		}

		public Criteria andValueIsNotNull() {
			addCriterion("VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andValueEqualTo(String value) {
			addCriterion("VALUE =", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotEqualTo(String value) {
			addCriterion("VALUE <>", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThan(String value) {
			addCriterion("VALUE >", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThanOrEqualTo(String value) {
			addCriterion("VALUE >=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThan(String value) {
			addCriterion("VALUE <", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThanOrEqualTo(String value) {
			addCriterion("VALUE <=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLike(String value) {
			addCriterion("VALUE like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotLike(String value) {
			addCriterion("VALUE not like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueIn(List<String> values) {
			addCriterion("VALUE in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotIn(List<String> values) {
			addCriterion("VALUE not in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueBetween(String value1, String value2) {
			addCriterion("VALUE between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotBetween(String value1, String value2) {
			addCriterion("VALUE not between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("CODE not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCreatedTsIsNull() {
			addCriterion("CREATED_TS is null");
			return (Criteria) this;
		}

		public Criteria andCreatedTsIsNotNull() {
			addCriterion("CREATED_TS is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedTsEqualTo(Date value) {
			addCriterion("CREATED_TS =", value, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsNotEqualTo(Date value) {
			addCriterion("CREATED_TS <>", value, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsGreaterThan(Date value) {
			addCriterion("CREATED_TS >", value, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATED_TS >=", value, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsLessThan(Date value) {
			addCriterion("CREATED_TS <", value, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsLessThanOrEqualTo(Date value) {
			addCriterion("CREATED_TS <=", value, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsIn(List<Date> values) {
			addCriterion("CREATED_TS in", values, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsNotIn(List<Date> values) {
			addCriterion("CREATED_TS not in", values, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsBetween(Date value1, Date value2) {
			addCriterion("CREATED_TS between", value1, value2, "createdTs");
			return (Criteria) this;
		}

		public Criteria andCreatedTsNotBetween(Date value1, Date value2) {
			addCriterion("CREATED_TS not between", value1, value2, "createdTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsIsNull() {
			addCriterion("UPDATED_TS is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsIsNotNull() {
			addCriterion("UPDATED_TS is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsEqualTo(Date value) {
			addCriterion("UPDATED_TS =", value, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsNotEqualTo(Date value) {
			addCriterion("UPDATED_TS <>", value, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsGreaterThan(Date value) {
			addCriterion("UPDATED_TS >", value, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATED_TS >=", value, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsLessThan(Date value) {
			addCriterion("UPDATED_TS <", value, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsLessThanOrEqualTo(Date value) {
			addCriterion("UPDATED_TS <=", value, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsIn(List<Date> values) {
			addCriterion("UPDATED_TS in", values, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsNotIn(List<Date> values) {
			addCriterion("UPDATED_TS not in", values, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsBetween(Date value1, Date value2) {
			addCriterion("UPDATED_TS between", value1, value2, "updatedTs");
			return (Criteria) this;
		}

		public Criteria andUpdatedTsNotBetween(Date value1, Date value2) {
			addCriterion("UPDATED_TS not between", value1, value2, "updatedTs");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SYSTEM_SETTINGS
	 * @mbg.generated  Mon May 27 13:46:15 EDT 2019
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
     * This class corresponds to the database table SYSTEM_SETTINGS
     *
     * @mbg.generated do_not_delete_during_merge Mon May 27 13:25:36 EDT 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}