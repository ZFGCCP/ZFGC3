package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.List;

public class UserContactSettingsDbObjExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public UserContactSettingsDbObjExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
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
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
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

        public Criteria andUserContactSettingsIdIsNull() {
            addCriterion("USER_CONTACT_SETTINGS_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdIsNotNull() {
            addCriterion("USER_CONTACT_SETTINGS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdEqualTo(Integer value) {
            addCriterion("USER_CONTACT_SETTINGS_ID =", value, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdNotEqualTo(Integer value) {
            addCriterion("USER_CONTACT_SETTINGS_ID <>", value, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdGreaterThan(Integer value) {
            addCriterion("USER_CONTACT_SETTINGS_ID >", value, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_CONTACT_SETTINGS_ID >=", value, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdLessThan(Integer value) {
            addCriterion("USER_CONTACT_SETTINGS_ID <", value, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_CONTACT_SETTINGS_ID <=", value, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdIn(List<Integer> values) {
            addCriterion("USER_CONTACT_SETTINGS_ID in", values, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdNotIn(List<Integer> values) {
            addCriterion("USER_CONTACT_SETTINGS_ID not in", values, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_CONTACT_SETTINGS_ID between", value1, value2, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andUserContactSettingsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_CONTACT_SETTINGS_ID not between", value1, value2, "userContactSettingsId");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNull() {
            addCriterion("EMAIL_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNotNull() {
            addCriterion("EMAIL_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressEqualTo(String value) {
            addCriterion("EMAIL_ADDRESS =", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotEqualTo(String value) {
            addCriterion("EMAIL_ADDRESS <>", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThan(String value) {
            addCriterion("EMAIL_ADDRESS >", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_ADDRESS >=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThan(String value) {
            addCriterion("EMAIL_ADDRESS <", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_ADDRESS <=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLike(String value) {
            addCriterion("EMAIL_ADDRESS like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotLike(String value) {
            addCriterion("EMAIL_ADDRESS not like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIn(List<String> values) {
            addCriterion("EMAIL_ADDRESS in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotIn(List<String> values) {
            addCriterion("EMAIL_ADDRESS not in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressBetween(String value1, String value2) {
            addCriterion("EMAIL_ADDRESS between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotBetween(String value1, String value2) {
            addCriterion("EMAIL_ADDRESS not between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andUsersIdIsNull() {
            addCriterion("USERS_ID is null");
            return (Criteria) this;
        }

        public Criteria andUsersIdIsNotNull() {
            addCriterion("USERS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUsersIdEqualTo(Integer value) {
            addCriterion("USERS_ID =", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotEqualTo(Integer value) {
            addCriterion("USERS_ID <>", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdGreaterThan(Integer value) {
            addCriterion("USERS_ID >", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USERS_ID >=", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdLessThan(Integer value) {
            addCriterion("USERS_ID <", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdLessThanOrEqualTo(Integer value) {
            addCriterion("USERS_ID <=", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdIn(List<Integer> values) {
            addCriterion("USERS_ID in", values, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotIn(List<Integer> values) {
            addCriterion("USERS_ID not in", values, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdBetween(Integer value1, Integer value2) {
            addCriterion("USERS_ID between", value1, value2, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USERS_ID not between", value1, value2, "usersId");
            return (Criteria) this;
        }

        public Criteria andGtalkIsNull() {
            addCriterion("GTALK is null");
            return (Criteria) this;
        }

        public Criteria andGtalkIsNotNull() {
            addCriterion("GTALK is not null");
            return (Criteria) this;
        }

        public Criteria andGtalkEqualTo(String value) {
            addCriterion("GTALK =", value, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkNotEqualTo(String value) {
            addCriterion("GTALK <>", value, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkGreaterThan(String value) {
            addCriterion("GTALK >", value, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkGreaterThanOrEqualTo(String value) {
            addCriterion("GTALK >=", value, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkLessThan(String value) {
            addCriterion("GTALK <", value, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkLessThanOrEqualTo(String value) {
            addCriterion("GTALK <=", value, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkLike(String value) {
            addCriterion("GTALK like", value, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkNotLike(String value) {
            addCriterion("GTALK not like", value, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkIn(List<String> values) {
            addCriterion("GTALK in", values, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkNotIn(List<String> values) {
            addCriterion("GTALK not in", values, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkBetween(String value1, String value2) {
            addCriterion("GTALK between", value1, value2, "gtalk");
            return (Criteria) this;
        }

        public Criteria andGtalkNotBetween(String value1, String value2) {
            addCriterion("GTALK not between", value1, value2, "gtalk");
            return (Criteria) this;
        }

        public Criteria andSkypeIsNull() {
            addCriterion("SKYPE is null");
            return (Criteria) this;
        }

        public Criteria andSkypeIsNotNull() {
            addCriterion("SKYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSkypeEqualTo(String value) {
            addCriterion("SKYPE =", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotEqualTo(String value) {
            addCriterion("SKYPE <>", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeGreaterThan(String value) {
            addCriterion("SKYPE >", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeGreaterThanOrEqualTo(String value) {
            addCriterion("SKYPE >=", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLessThan(String value) {
            addCriterion("SKYPE <", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLessThanOrEqualTo(String value) {
            addCriterion("SKYPE <=", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLike(String value) {
            addCriterion("SKYPE like", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotLike(String value) {
            addCriterion("SKYPE not like", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeIn(List<String> values) {
            addCriterion("SKYPE in", values, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotIn(List<String> values) {
            addCriterion("SKYPE not in", values, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeBetween(String value1, String value2) {
            addCriterion("SKYPE between", value1, value2, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotBetween(String value1, String value2) {
            addCriterion("SKYPE not between", value1, value2, "skype");
            return (Criteria) this;
        }

        public Criteria andSteamIsNull() {
            addCriterion("STEAM is null");
            return (Criteria) this;
        }

        public Criteria andSteamIsNotNull() {
            addCriterion("STEAM is not null");
            return (Criteria) this;
        }

        public Criteria andSteamEqualTo(String value) {
            addCriterion("STEAM =", value, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamNotEqualTo(String value) {
            addCriterion("STEAM <>", value, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamGreaterThan(String value) {
            addCriterion("STEAM >", value, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamGreaterThanOrEqualTo(String value) {
            addCriterion("STEAM >=", value, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamLessThan(String value) {
            addCriterion("STEAM <", value, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamLessThanOrEqualTo(String value) {
            addCriterion("STEAM <=", value, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamLike(String value) {
            addCriterion("STEAM like", value, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamNotLike(String value) {
            addCriterion("STEAM not like", value, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamIn(List<String> values) {
            addCriterion("STEAM in", values, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamNotIn(List<String> values) {
            addCriterion("STEAM not in", values, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamBetween(String value1, String value2) {
            addCriterion("STEAM between", value1, value2, "steam");
            return (Criteria) this;
        }

        public Criteria andSteamNotBetween(String value1, String value2) {
            addCriterion("STEAM not between", value1, value2, "steam");
            return (Criteria) this;
        }

        public Criteria andPsnIsNull() {
            addCriterion("PSN is null");
            return (Criteria) this;
        }

        public Criteria andPsnIsNotNull() {
            addCriterion("PSN is not null");
            return (Criteria) this;
        }

        public Criteria andPsnEqualTo(String value) {
            addCriterion("PSN =", value, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnNotEqualTo(String value) {
            addCriterion("PSN <>", value, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnGreaterThan(String value) {
            addCriterion("PSN >", value, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnGreaterThanOrEqualTo(String value) {
            addCriterion("PSN >=", value, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnLessThan(String value) {
            addCriterion("PSN <", value, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnLessThanOrEqualTo(String value) {
            addCriterion("PSN <=", value, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnLike(String value) {
            addCriterion("PSN like", value, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnNotLike(String value) {
            addCriterion("PSN not like", value, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnIn(List<String> values) {
            addCriterion("PSN in", values, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnNotIn(List<String> values) {
            addCriterion("PSN not in", values, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnBetween(String value1, String value2) {
            addCriterion("PSN between", value1, value2, "psn");
            return (Criteria) this;
        }

        public Criteria andPsnNotBetween(String value1, String value2) {
            addCriterion("PSN not between", value1, value2, "psn");
            return (Criteria) this;
        }

        public Criteria andNnidIsNull() {
            addCriterion("NNID is null");
            return (Criteria) this;
        }

        public Criteria andNnidIsNotNull() {
            addCriterion("NNID is not null");
            return (Criteria) this;
        }

        public Criteria andNnidEqualTo(String value) {
            addCriterion("NNID =", value, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidNotEqualTo(String value) {
            addCriterion("NNID <>", value, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidGreaterThan(String value) {
            addCriterion("NNID >", value, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidGreaterThanOrEqualTo(String value) {
            addCriterion("NNID >=", value, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidLessThan(String value) {
            addCriterion("NNID <", value, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidLessThanOrEqualTo(String value) {
            addCriterion("NNID <=", value, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidLike(String value) {
            addCriterion("NNID like", value, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidNotLike(String value) {
            addCriterion("NNID not like", value, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidIn(List<String> values) {
            addCriterion("NNID in", values, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidNotIn(List<String> values) {
            addCriterion("NNID not in", values, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidBetween(String value1, String value2) {
            addCriterion("NNID between", value1, value2, "nnid");
            return (Criteria) this;
        }

        public Criteria andNnidNotBetween(String value1, String value2) {
            addCriterion("NNID not between", value1, value2, "nnid");
            return (Criteria) this;
        }

        public Criteria andXboxLiveIsNull() {
            addCriterion("XBOX_LIVE is null");
            return (Criteria) this;
        }

        public Criteria andXboxLiveIsNotNull() {
            addCriterion("XBOX_LIVE is not null");
            return (Criteria) this;
        }

        public Criteria andXboxLiveEqualTo(String value) {
            addCriterion("XBOX_LIVE =", value, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveNotEqualTo(String value) {
            addCriterion("XBOX_LIVE <>", value, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveGreaterThan(String value) {
            addCriterion("XBOX_LIVE >", value, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveGreaterThanOrEqualTo(String value) {
            addCriterion("XBOX_LIVE >=", value, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveLessThan(String value) {
            addCriterion("XBOX_LIVE <", value, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveLessThanOrEqualTo(String value) {
            addCriterion("XBOX_LIVE <=", value, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveLike(String value) {
            addCriterion("XBOX_LIVE like", value, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveNotLike(String value) {
            addCriterion("XBOX_LIVE not like", value, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveIn(List<String> values) {
            addCriterion("XBOX_LIVE in", values, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveNotIn(List<String> values) {
            addCriterion("XBOX_LIVE not in", values, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveBetween(String value1, String value2) {
            addCriterion("XBOX_LIVE between", value1, value2, "xboxLive");
            return (Criteria) this;
        }

        public Criteria andXboxLiveNotBetween(String value1, String value2) {
            addCriterion("XBOX_LIVE not between", value1, value2, "xboxLive");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated do_not_delete_during_merge Wed Nov 14 23:10:41 EST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table USER_CONTACT_SETTINGS
     *
     * @mbggenerated Wed Nov 14 23:10:41 EST 2018
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