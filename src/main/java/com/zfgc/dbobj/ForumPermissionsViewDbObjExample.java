package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.List;

public class ForumPermissionsViewDbObjExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public ForumPermissionsViewDbObjExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
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

		public Criteria andForumIdIsNull() {
			addCriterion("FORUM_ID is null");
			return (Criteria) this;
		}

		public Criteria andForumIdIsNotNull() {
			addCriterion("FORUM_ID is not null");
			return (Criteria) this;
		}

		public Criteria andForumIdEqualTo(Short value) {
			addCriterion("FORUM_ID =", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdNotEqualTo(Short value) {
			addCriterion("FORUM_ID <>", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdGreaterThan(Short value) {
			addCriterion("FORUM_ID >", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdGreaterThanOrEqualTo(Short value) {
			addCriterion("FORUM_ID >=", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdLessThan(Short value) {
			addCriterion("FORUM_ID <", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdLessThanOrEqualTo(Short value) {
			addCriterion("FORUM_ID <=", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdIn(List<Short> values) {
			addCriterion("FORUM_ID in", values, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdNotIn(List<Short> values) {
			addCriterion("FORUM_ID not in", values, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdBetween(Short value1, Short value2) {
			addCriterion("FORUM_ID between", value1, value2, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdNotBetween(Short value1, Short value2) {
			addCriterion("FORUM_ID not between", value1, value2, "forumId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdIsNull() {
			addCriterion("MEMBER_GROUP_ID is null");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdIsNotNull() {
			addCriterion("MEMBER_GROUP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdEqualTo(Integer value) {
			addCriterion("MEMBER_GROUP_ID =", value, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdNotEqualTo(Integer value) {
			addCriterion("MEMBER_GROUP_ID <>", value, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdGreaterThan(Integer value) {
			addCriterion("MEMBER_GROUP_ID >", value, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("MEMBER_GROUP_ID >=", value, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdLessThan(Integer value) {
			addCriterion("MEMBER_GROUP_ID <", value, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdLessThanOrEqualTo(Integer value) {
			addCriterion("MEMBER_GROUP_ID <=", value, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdIn(List<Integer> values) {
			addCriterion("MEMBER_GROUP_ID in", values, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdNotIn(List<Integer> values) {
			addCriterion("MEMBER_GROUP_ID not in", values, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdBetween(Integer value1, Integer value2) {
			addCriterion("MEMBER_GROUP_ID between", value1, value2, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andMemberGroupIdNotBetween(Integer value1, Integer value2) {
			addCriterion("MEMBER_GROUP_ID not between", value1, value2, "memberGroupId");
			return (Criteria) this;
		}

		public Criteria andReadFlagIsNull() {
			addCriterion("READ_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andReadFlagIsNotNull() {
			addCriterion("READ_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andReadFlagEqualTo(Boolean value) {
			addCriterion("READ_FLAG =", value, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagNotEqualTo(Boolean value) {
			addCriterion("READ_FLAG <>", value, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagGreaterThan(Boolean value) {
			addCriterion("READ_FLAG >", value, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("READ_FLAG >=", value, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagLessThan(Boolean value) {
			addCriterion("READ_FLAG <", value, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("READ_FLAG <=", value, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagIn(List<Boolean> values) {
			addCriterion("READ_FLAG in", values, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagNotIn(List<Boolean> values) {
			addCriterion("READ_FLAG not in", values, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("READ_FLAG between", value1, value2, "readFlag");
			return (Criteria) this;
		}

		public Criteria andReadFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("READ_FLAG not between", value1, value2, "readFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagIsNull() {
			addCriterion("WRITE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andWriteFlagIsNotNull() {
			addCriterion("WRITE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andWriteFlagEqualTo(Boolean value) {
			addCriterion("WRITE_FLAG =", value, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagNotEqualTo(Boolean value) {
			addCriterion("WRITE_FLAG <>", value, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagGreaterThan(Boolean value) {
			addCriterion("WRITE_FLAG >", value, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("WRITE_FLAG >=", value, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagLessThan(Boolean value) {
			addCriterion("WRITE_FLAG <", value, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("WRITE_FLAG <=", value, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagIn(List<Boolean> values) {
			addCriterion("WRITE_FLAG in", values, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagNotIn(List<Boolean> values) {
			addCriterion("WRITE_FLAG not in", values, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("WRITE_FLAG between", value1, value2, "writeFlag");
			return (Criteria) this;
		}

		public Criteria andWriteFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("WRITE_FLAG not between", value1, value2, "writeFlag");
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

		public Criteria andDescriptionIsNull() {
			addCriterion("DESCRIPTION is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("DESCRIPTION is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("DESCRIPTION =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("DESCRIPTION <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("DESCRIPTION >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("DESCRIPTION >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("DESCRIPTION <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("DESCRIPTION <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("DESCRIPTION like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("DESCRIPTION not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("DESCRIPTION in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("DESCRIPTION not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("DESCRIPTION between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("DESCRIPTION not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNull() {
			addCriterion("CATEGORY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNotNull() {
			addCriterion("CATEGORY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdEqualTo(Integer value) {
			addCriterion("CATEGORY_ID =", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotEqualTo(Integer value) {
			addCriterion("CATEGORY_ID <>", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThan(Integer value) {
			addCriterion("CATEGORY_ID >", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CATEGORY_ID >=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThan(Integer value) {
			addCriterion("CATEGORY_ID <", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
			addCriterion("CATEGORY_ID <=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIn(List<Integer> values) {
			addCriterion("CATEGORY_ID in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotIn(List<Integer> values) {
			addCriterion("CATEGORY_ID not in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
			addCriterion("CATEGORY_ID between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CATEGORY_ID not between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdIsNull() {
			addCriterion("PARENT_FORUM_ID is null");
			return (Criteria) this;
		}

		public Criteria andParentForumIdIsNotNull() {
			addCriterion("PARENT_FORUM_ID is not null");
			return (Criteria) this;
		}

		public Criteria andParentForumIdEqualTo(Short value) {
			addCriterion("PARENT_FORUM_ID =", value, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdNotEqualTo(Short value) {
			addCriterion("PARENT_FORUM_ID <>", value, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdGreaterThan(Short value) {
			addCriterion("PARENT_FORUM_ID >", value, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdGreaterThanOrEqualTo(Short value) {
			addCriterion("PARENT_FORUM_ID >=", value, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdLessThan(Short value) {
			addCriterion("PARENT_FORUM_ID <", value, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdLessThanOrEqualTo(Short value) {
			addCriterion("PARENT_FORUM_ID <=", value, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdIn(List<Short> values) {
			addCriterion("PARENT_FORUM_ID in", values, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdNotIn(List<Short> values) {
			addCriterion("PARENT_FORUM_ID not in", values, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdBetween(Short value1, Short value2) {
			addCriterion("PARENT_FORUM_ID between", value1, value2, "parentForumId");
			return (Criteria) this;
		}

		public Criteria andParentForumIdNotBetween(Short value1, Short value2) {
			addCriterion("PARENT_FORUM_ID not between", value1, value2, "parentForumId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table FORUM_PERMISSIONS_VIEW
	 * @mbg.generated  Fri Dec 20 21:36:46 EST 2019
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
     * This class corresponds to the database table FORUM_PERMISSIONS_VIEW
     *
     * @mbg.generated do_not_delete_during_merge Fri Dec 20 21:29:44 EST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}