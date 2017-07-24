package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.List;

public class HtmlEntityDbObjExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public HtmlEntityDbObjExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
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

		public Criteria andHtmlEntityIdIsNull() {
			addCriterion("HTML_ENTITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdIsNotNull() {
			addCriterion("HTML_ENTITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdEqualTo(Integer value) {
			addCriterion("HTML_ENTITY_ID =", value, "htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdNotEqualTo(Integer value) {
			addCriterion("HTML_ENTITY_ID <>", value, "htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdGreaterThan(Integer value) {
			addCriterion("HTML_ENTITY_ID >", value, "htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("HTML_ENTITY_ID >=", value, "htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdLessThan(Integer value) {
			addCriterion("HTML_ENTITY_ID <", value, "htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdLessThanOrEqualTo(Integer value) {
			addCriterion("HTML_ENTITY_ID <=", value, "htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdIn(List<Integer> values) {
			addCriterion("HTML_ENTITY_ID in", values, "htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdNotIn(List<Integer> values) {
			addCriterion("HTML_ENTITY_ID not in", values, "htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdBetween(Integer value1, Integer value2) {
			addCriterion("HTML_ENTITY_ID between", value1, value2,
					"htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("HTML_ENTITY_ID not between", value1, value2,
					"htmlEntityId");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterIsNull() {
			addCriterion("HTML_CHARACTER is null");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterIsNotNull() {
			addCriterion("HTML_CHARACTER is not null");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterEqualTo(String value) {
			addCriterion("HTML_CHARACTER =", value, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterNotEqualTo(String value) {
			addCriterion("HTML_CHARACTER <>", value, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterGreaterThan(String value) {
			addCriterion("HTML_CHARACTER >", value, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterGreaterThanOrEqualTo(String value) {
			addCriterion("HTML_CHARACTER >=", value, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterLessThan(String value) {
			addCriterion("HTML_CHARACTER <", value, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterLessThanOrEqualTo(String value) {
			addCriterion("HTML_CHARACTER <=", value, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterLike(String value) {
			addCriterion("HTML_CHARACTER like", value, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterNotLike(String value) {
			addCriterion("HTML_CHARACTER not like", value, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterIn(List<String> values) {
			addCriterion("HTML_CHARACTER in", values, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterNotIn(List<String> values) {
			addCriterion("HTML_CHARACTER not in", values, "htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterBetween(String value1, String value2) {
			addCriterion("HTML_CHARACTER between", value1, value2,
					"htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlCharacterNotBetween(String value1, String value2) {
			addCriterion("HTML_CHARACTER not between", value1, value2,
					"htmlCharacter");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIsNull() {
			addCriterion("HTML_ENTITY is null");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIsNotNull() {
			addCriterion("HTML_ENTITY is not null");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityEqualTo(String value) {
			addCriterion("HTML_ENTITY =", value, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityNotEqualTo(String value) {
			addCriterion("HTML_ENTITY <>", value, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityGreaterThan(String value) {
			addCriterion("HTML_ENTITY >", value, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityGreaterThanOrEqualTo(String value) {
			addCriterion("HTML_ENTITY >=", value, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityLessThan(String value) {
			addCriterion("HTML_ENTITY <", value, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityLessThanOrEqualTo(String value) {
			addCriterion("HTML_ENTITY <=", value, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityLike(String value) {
			addCriterion("HTML_ENTITY like", value, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityNotLike(String value) {
			addCriterion("HTML_ENTITY not like", value, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityIn(List<String> values) {
			addCriterion("HTML_ENTITY in", values, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityNotIn(List<String> values) {
			addCriterion("HTML_ENTITY not in", values, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityBetween(String value1, String value2) {
			addCriterion("HTML_ENTITY between", value1, value2, "htmlEntity");
			return (Criteria) this;
		}

		public Criteria andHtmlEntityNotBetween(String value1, String value2) {
			addCriterion("HTML_ENTITY not between", value1, value2,
					"htmlEntity");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table HTML_ENTITY
	 * @mbggenerated  Sun Jul 16 22:09:28 EDT 2017
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
     * This class corresponds to the database table HTML_ENTITY
     *
     * @mbggenerated do_not_delete_during_merge Sun Jul 16 16:30:35 EDT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}