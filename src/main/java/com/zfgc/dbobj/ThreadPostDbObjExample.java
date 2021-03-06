package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThreadPostDbObjExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public ThreadPostDbObjExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
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

		public Criteria andThreadPostIdIsNull() {
			addCriterion("THREAD_POST_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdIsNotNull() {
			addCriterion("THREAD_POST_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdEqualTo(Integer value) {
			addCriterion("THREAD_POST_ID =", value, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdNotEqualTo(Integer value) {
			addCriterion("THREAD_POST_ID <>", value, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdGreaterThan(Integer value) {
			addCriterion("THREAD_POST_ID >", value, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREAD_POST_ID >=", value, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdLessThan(Integer value) {
			addCriterion("THREAD_POST_ID <", value, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREAD_POST_ID <=", value, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdIn(List<Integer> values) {
			addCriterion("THREAD_POST_ID in", values, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdNotIn(List<Integer> values) {
			addCriterion("THREAD_POST_ID not in", values, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdBetween(Integer value1, Integer value2) {
			addCriterion("THREAD_POST_ID between", value1, value2, "threadPostId");
			return (Criteria) this;
		}

		public Criteria andThreadPostIdNotBetween(Integer value1, Integer value2) {
			addCriterion("THREAD_POST_ID not between", value1, value2, "threadPostId");
			return (Criteria) this;
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

		public Criteria andAuthorIdIsNull() {
			addCriterion("AUTHOR_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuthorIdIsNotNull() {
			addCriterion("AUTHOR_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorIdEqualTo(Integer value) {
			addCriterion("AUTHOR_ID =", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotEqualTo(Integer value) {
			addCriterion("AUTHOR_ID <>", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdGreaterThan(Integer value) {
			addCriterion("AUTHOR_ID >", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUTHOR_ID >=", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdLessThan(Integer value) {
			addCriterion("AUTHOR_ID <", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUTHOR_ID <=", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdIn(List<Integer> values) {
			addCriterion("AUTHOR_ID in", values, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotIn(List<Integer> values) {
			addCriterion("AUTHOR_ID not in", values, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
			addCriterion("AUTHOR_ID between", value1, value2, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUTHOR_ID not between", value1, value2, "authorId");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table THREAD_POST
	 * @mbg.generated  Sun May 10 20:55:18 EDT 2020
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
     * This class corresponds to the database table THREAD_POST
     *
     * @mbg.generated do_not_delete_during_merge Sun Apr 26 13:56:01 EDT 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}