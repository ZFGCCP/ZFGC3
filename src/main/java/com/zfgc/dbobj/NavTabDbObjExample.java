package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.List;

public class NavTabDbObjExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public NavTabDbObjExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
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

        public Criteria andNavTabIdIsNull() {
            addCriterion("NAV_TAB_ID is null");
            return (Criteria) this;
        }

        public Criteria andNavTabIdIsNotNull() {
            addCriterion("NAV_TAB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNavTabIdEqualTo(Integer value) {
            addCriterion("NAV_TAB_ID =", value, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdNotEqualTo(Integer value) {
            addCriterion("NAV_TAB_ID <>", value, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdGreaterThan(Integer value) {
            addCriterion("NAV_TAB_ID >", value, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NAV_TAB_ID >=", value, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdLessThan(Integer value) {
            addCriterion("NAV_TAB_ID <", value, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdLessThanOrEqualTo(Integer value) {
            addCriterion("NAV_TAB_ID <=", value, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdIn(List<Integer> values) {
            addCriterion("NAV_TAB_ID in", values, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdNotIn(List<Integer> values) {
            addCriterion("NAV_TAB_ID not in", values, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdBetween(Integer value1, Integer value2) {
            addCriterion("NAV_TAB_ID between", value1, value2, "navTabId");
            return (Criteria) this;
        }

        public Criteria andNavTabIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NAV_TAB_ID not between", value1, value2, "navTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdIsNull() {
            addCriterion("PARENT_TAB_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentTabIdIsNotNull() {
            addCriterion("PARENT_TAB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentTabIdEqualTo(Integer value) {
            addCriterion("PARENT_TAB_ID =", value, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdNotEqualTo(Integer value) {
            addCriterion("PARENT_TAB_ID <>", value, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdGreaterThan(Integer value) {
            addCriterion("PARENT_TAB_ID >", value, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARENT_TAB_ID >=", value, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdLessThan(Integer value) {
            addCriterion("PARENT_TAB_ID <", value, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdLessThanOrEqualTo(Integer value) {
            addCriterion("PARENT_TAB_ID <=", value, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdIn(List<Integer> values) {
            addCriterion("PARENT_TAB_ID in", values, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdNotIn(List<Integer> values) {
            addCriterion("PARENT_TAB_ID not in", values, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_TAB_ID between", value1, value2, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andParentTabIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_TAB_ID not between", value1, value2, "parentTabId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIsNull() {
            addCriterion("SEQUENCE_NO is null");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIsNotNull() {
            addCriterion("SEQUENCE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceNoEqualTo(Integer value) {
            addCriterion("SEQUENCE_NO =", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotEqualTo(Integer value) {
            addCriterion("SEQUENCE_NO <>", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoGreaterThan(Integer value) {
            addCriterion("SEQUENCE_NO >", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQUENCE_NO >=", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoLessThan(Integer value) {
            addCriterion("SEQUENCE_NO <", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("SEQUENCE_NO <=", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIn(List<Integer> values) {
            addCriterion("SEQUENCE_NO in", values, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotIn(List<Integer> values) {
            addCriterion("SEQUENCE_NO not in", values, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("SEQUENCE_NO between", value1, value2, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQUENCE_NO not between", value1, value2, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSectionCodeIsNull() {
            addCriterion("SECTION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSectionCodeIsNotNull() {
            addCriterion("SECTION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSectionCodeEqualTo(String value) {
            addCriterion("SECTION_CODE =", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeNotEqualTo(String value) {
            addCriterion("SECTION_CODE <>", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeGreaterThan(String value) {
            addCriterion("SECTION_CODE >", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SECTION_CODE >=", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeLessThan(String value) {
            addCriterion("SECTION_CODE <", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeLessThanOrEqualTo(String value) {
            addCriterion("SECTION_CODE <=", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeLike(String value) {
            addCriterion("SECTION_CODE like", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeNotLike(String value) {
            addCriterion("SECTION_CODE not like", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeIn(List<String> values) {
            addCriterion("SECTION_CODE in", values, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeNotIn(List<String> values) {
            addCriterion("SECTION_CODE not in", values, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeBetween(String value1, String value2) {
            addCriterion("SECTION_CODE between", value1, value2, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeNotBetween(String value1, String value2) {
            addCriterion("SECTION_CODE not between", value1, value2, "sectionCode");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NAV_TAB
     *
     * @mbggenerated do_not_delete_during_merge Thu Jan 26 21:57:27 EST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NAV_TAB
     *
     * @mbggenerated Thu Jan 26 21:57:27 EST 2017
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
}