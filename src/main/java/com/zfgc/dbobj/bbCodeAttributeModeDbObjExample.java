package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.List;

public class bbCodeAttributeModeDbObjExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public bbCodeAttributeModeDbObjExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
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
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
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

        public Criteria andBbCodeAttributeModeIdIsNull() {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdIsNotNull() {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdEqualTo(Integer value) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID =", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdNotEqualTo(Integer value) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID <>", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdGreaterThan(Integer value) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID >", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID >=", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdLessThan(Integer value) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID <", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdLessThanOrEqualTo(Integer value) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID <=", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdIn(List<Integer> values) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID in", values, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdNotIn(List<Integer> values) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID not in", values, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdBetween(Integer value1, Integer value2) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID between", value1, value2, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BB_CODE_ATTRIBUTE_MODE_ID not between", value1, value2, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdIsNull() {
            addCriterion("BB_CODE_CONFIG_ID is null");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdIsNotNull() {
            addCriterion("BB_CODE_CONFIG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdEqualTo(Integer value) {
            addCriterion("BB_CODE_CONFIG_ID =", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdNotEqualTo(Integer value) {
            addCriterion("BB_CODE_CONFIG_ID <>", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdGreaterThan(Integer value) {
            addCriterion("BB_CODE_CONFIG_ID >", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BB_CODE_CONFIG_ID >=", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdLessThan(Integer value) {
            addCriterion("BB_CODE_CONFIG_ID <", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("BB_CODE_CONFIG_ID <=", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdIn(List<Integer> values) {
            addCriterion("BB_CODE_CONFIG_ID in", values, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdNotIn(List<Integer> values) {
            addCriterion("BB_CODE_CONFIG_ID not in", values, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("BB_CODE_CONFIG_ID between", value1, value2, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BB_CODE_CONFIG_ID not between", value1, value2, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagIsNull() {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagIsNotNull() {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagEqualTo(Boolean value) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG =", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagNotEqualTo(Boolean value) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG <>", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagGreaterThan(Boolean value) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG >", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG >=", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagLessThan(Boolean value) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG <", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG <=", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagIn(List<Boolean> values) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG in", values, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagNotIn(List<Boolean> values) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG not in", values, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG between", value1, value2, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("CONTENT_IS_ATTRIBUTE_FLAG not between", value1, value2, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andOpenTagIsNull() {
            addCriterion("OPEN_TAG is null");
            return (Criteria) this;
        }

        public Criteria andOpenTagIsNotNull() {
            addCriterion("OPEN_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTagEqualTo(String value) {
            addCriterion("OPEN_TAG =", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagNotEqualTo(String value) {
            addCriterion("OPEN_TAG <>", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagGreaterThan(String value) {
            addCriterion("OPEN_TAG >", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_TAG >=", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagLessThan(String value) {
            addCriterion("OPEN_TAG <", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagLessThanOrEqualTo(String value) {
            addCriterion("OPEN_TAG <=", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagLike(String value) {
            addCriterion("OPEN_TAG like", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagNotLike(String value) {
            addCriterion("OPEN_TAG not like", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagIn(List<String> values) {
            addCriterion("OPEN_TAG in", values, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagNotIn(List<String> values) {
            addCriterion("OPEN_TAG not in", values, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagBetween(String value1, String value2) {
            addCriterion("OPEN_TAG between", value1, value2, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagNotBetween(String value1, String value2) {
            addCriterion("OPEN_TAG not between", value1, value2, "openTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagIsNull() {
            addCriterion("CLOSE_TAG is null");
            return (Criteria) this;
        }

        public Criteria andCloseTagIsNotNull() {
            addCriterion("CLOSE_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTagEqualTo(String value) {
            addCriterion("CLOSE_TAG =", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagNotEqualTo(String value) {
            addCriterion("CLOSE_TAG <>", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagGreaterThan(String value) {
            addCriterion("CLOSE_TAG >", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagGreaterThanOrEqualTo(String value) {
            addCriterion("CLOSE_TAG >=", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagLessThan(String value) {
            addCriterion("CLOSE_TAG <", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagLessThanOrEqualTo(String value) {
            addCriterion("CLOSE_TAG <=", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagLike(String value) {
            addCriterion("CLOSE_TAG like", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagNotLike(String value) {
            addCriterion("CLOSE_TAG not like", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagIn(List<String> values) {
            addCriterion("CLOSE_TAG in", values, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagNotIn(List<String> values) {
            addCriterion("CLOSE_TAG not in", values, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagBetween(String value1, String value2) {
            addCriterion("CLOSE_TAG between", value1, value2, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagNotBetween(String value1, String value2) {
            addCriterion("CLOSE_TAG not between", value1, value2, "closeTag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagIsNull() {
            addCriterion("OUTPUT_CONTENT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagIsNotNull() {
            addCriterion("OUTPUT_CONTENT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagEqualTo(Boolean value) {
            addCriterion("OUTPUT_CONTENT_FLAG =", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagNotEqualTo(Boolean value) {
            addCriterion("OUTPUT_CONTENT_FLAG <>", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagGreaterThan(Boolean value) {
            addCriterion("OUTPUT_CONTENT_FLAG >", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("OUTPUT_CONTENT_FLAG >=", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagLessThan(Boolean value) {
            addCriterion("OUTPUT_CONTENT_FLAG <", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("OUTPUT_CONTENT_FLAG <=", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagIn(List<Boolean> values) {
            addCriterion("OUTPUT_CONTENT_FLAG in", values, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagNotIn(List<Boolean> values) {
            addCriterion("OUTPUT_CONTENT_FLAG not in", values, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("OUTPUT_CONTENT_FLAG between", value1, value2, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("OUTPUT_CONTENT_FLAG not between", value1, value2, "outputContentFlag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated do_not_delete_during_merge Fri Jun 02 22:45:29 EDT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BB_CODE_ATTRIBUTE_MODE
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
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