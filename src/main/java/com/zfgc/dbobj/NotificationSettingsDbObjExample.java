package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.List;

public class NotificationSettingsDbObjExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public NotificationSettingsDbObjExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
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

		public Criteria andNotificationSettingsIdIsNull() {
			addCriterion("NOTIFICATION_SETTINGS_ID is null");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdIsNotNull() {
			addCriterion("NOTIFICATION_SETTINGS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdEqualTo(Integer value) {
			addCriterion("NOTIFICATION_SETTINGS_ID =", value,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdNotEqualTo(Integer value) {
			addCriterion("NOTIFICATION_SETTINGS_ID <>", value,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdGreaterThan(Integer value) {
			addCriterion("NOTIFICATION_SETTINGS_ID >", value,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdGreaterThanOrEqualTo(
				Integer value) {
			addCriterion("NOTIFICATION_SETTINGS_ID >=", value,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdLessThan(Integer value) {
			addCriterion("NOTIFICATION_SETTINGS_ID <", value,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdLessThanOrEqualTo(Integer value) {
			addCriterion("NOTIFICATION_SETTINGS_ID <=", value,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdIn(List<Integer> values) {
			addCriterion("NOTIFICATION_SETTINGS_ID in", values,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdNotIn(List<Integer> values) {
			addCriterion("NOTIFICATION_SETTINGS_ID not in", values,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdBetween(Integer value1,
				Integer value2) {
			addCriterion("NOTIFICATION_SETTINGS_ID between", value1, value2,
					"notificationSettingsId");
			return (Criteria) this;
		}

		public Criteria andNotificationSettingsIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("NOTIFICATION_SETTINGS_ID not between", value1,
					value2, "notificationSettingsId");
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

		public Criteria andAutoSubscribeFlagIsNull() {
			addCriterion("AUTO_SUBSCRIBE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagIsNotNull() {
			addCriterion("AUTO_SUBSCRIBE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagEqualTo(Boolean value) {
			addCriterion("AUTO_SUBSCRIBE_FLAG =", value, "autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagNotEqualTo(Boolean value) {
			addCriterion("AUTO_SUBSCRIBE_FLAG <>", value, "autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagGreaterThan(Boolean value) {
			addCriterion("AUTO_SUBSCRIBE_FLAG >", value, "autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("AUTO_SUBSCRIBE_FLAG >=", value, "autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagLessThan(Boolean value) {
			addCriterion("AUTO_SUBSCRIBE_FLAG <", value, "autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("AUTO_SUBSCRIBE_FLAG <=", value, "autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagIn(List<Boolean> values) {
			addCriterion("AUTO_SUBSCRIBE_FLAG in", values, "autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagNotIn(List<Boolean> values) {
			addCriterion("AUTO_SUBSCRIBE_FLAG not in", values,
					"autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagBetween(Boolean value1,
				Boolean value2) {
			addCriterion("AUTO_SUBSCRIBE_FLAG between", value1, value2,
					"autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andAutoSubscribeFlagNotBetween(Boolean value1,
				Boolean value2) {
			addCriterion("AUTO_SUBSCRIBE_FLAG not between", value1, value2,
					"autoSubscribeFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagIsNull() {
			addCriterion("SEND_POST_IN_EMAIL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagIsNotNull() {
			addCriterion("SEND_POST_IN_EMAIL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagEqualTo(Boolean value) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG =", value,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagNotEqualTo(Boolean value) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG <>", value,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagGreaterThan(Boolean value) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG >", value,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG >=", value,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagLessThan(Boolean value) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG <", value,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG <=", value,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagIn(List<Boolean> values) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG in", values,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagNotIn(List<Boolean> values) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG not in", values,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagBetween(Boolean value1,
				Boolean value2) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG between", value1, value2,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andSendPostInEmailFlagNotBetween(Boolean value1,
				Boolean value2) {
			addCriterion("SEND_POST_IN_EMAIL_FLAG not between", value1, value2,
					"sendPostInEmailFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagIsNull() {
			addCriterion("INSTANT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andInstantFlagIsNotNull() {
			addCriterion("INSTANT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andInstantFlagEqualTo(Boolean value) {
			addCriterion("INSTANT_FLAG =", value, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagNotEqualTo(Boolean value) {
			addCriterion("INSTANT_FLAG <>", value, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagGreaterThan(Boolean value) {
			addCriterion("INSTANT_FLAG >", value, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("INSTANT_FLAG >=", value, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagLessThan(Boolean value) {
			addCriterion("INSTANT_FLAG <", value, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("INSTANT_FLAG <=", value, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagIn(List<Boolean> values) {
			addCriterion("INSTANT_FLAG in", values, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagNotIn(List<Boolean> values) {
			addCriterion("INSTANT_FLAG not in", values, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("INSTANT_FLAG between", value1, value2, "instantFlag");
			return (Criteria) this;
		}

		public Criteria andInstantFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("INSTANT_FLAG not between", value1, value2,
					"instantFlag");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdIsNull() {
			addCriterion("FREQUENCY_ID is null");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdIsNotNull() {
			addCriterion("FREQUENCY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdEqualTo(Integer value) {
			addCriterion("FREQUENCY_ID =", value, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdNotEqualTo(Integer value) {
			addCriterion("FREQUENCY_ID <>", value, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdGreaterThan(Integer value) {
			addCriterion("FREQUENCY_ID >", value, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FREQUENCY_ID >=", value, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdLessThan(Integer value) {
			addCriterion("FREQUENCY_ID <", value, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdLessThanOrEqualTo(Integer value) {
			addCriterion("FREQUENCY_ID <=", value, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdIn(List<Integer> values) {
			addCriterion("FREQUENCY_ID in", values, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdNotIn(List<Integer> values) {
			addCriterion("FREQUENCY_ID not in", values, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdBetween(Integer value1, Integer value2) {
			addCriterion("FREQUENCY_ID between", value1, value2, "frequencyId");
			return (Criteria) this;
		}

		public Criteria andFrequencyIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FREQUENCY_ID not between", value1, value2,
					"frequencyId");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagIsNull() {
			addCriterion("ONLY_FIRST_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagIsNotNull() {
			addCriterion("ONLY_FIRST_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagEqualTo(Boolean value) {
			addCriterion("ONLY_FIRST_FLAG =", value, "onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagNotEqualTo(Boolean value) {
			addCriterion("ONLY_FIRST_FLAG <>", value, "onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagGreaterThan(Boolean value) {
			addCriterion("ONLY_FIRST_FLAG >", value, "onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ONLY_FIRST_FLAG >=", value, "onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagLessThan(Boolean value) {
			addCriterion("ONLY_FIRST_FLAG <", value, "onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("ONLY_FIRST_FLAG <=", value, "onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagIn(List<Boolean> values) {
			addCriterion("ONLY_FIRST_FLAG in", values, "onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagNotIn(List<Boolean> values) {
			addCriterion("ONLY_FIRST_FLAG not in", values, "onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("ONLY_FIRST_FLAG between", value1, value2,
					"onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyFirstFlagNotBetween(Boolean value1,
				Boolean value2) {
			addCriterion("ONLY_FIRST_FLAG not between", value1, value2,
					"onlyFirstFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagIsNull() {
			addCriterion("REPLIES_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagIsNotNull() {
			addCriterion("REPLIES_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagEqualTo(Boolean value) {
			addCriterion("REPLIES_FLAG =", value, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagNotEqualTo(Boolean value) {
			addCriterion("REPLIES_FLAG <>", value, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagGreaterThan(Boolean value) {
			addCriterion("REPLIES_FLAG >", value, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("REPLIES_FLAG >=", value, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagLessThan(Boolean value) {
			addCriterion("REPLIES_FLAG <", value, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("REPLIES_FLAG <=", value, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagIn(List<Boolean> values) {
			addCriterion("REPLIES_FLAG in", values, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagNotIn(List<Boolean> values) {
			addCriterion("REPLIES_FLAG not in", values, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("REPLIES_FLAG between", value1, value2, "repliesFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("REPLIES_FLAG not between", value1, value2,
					"repliesFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagIsNull() {
			addCriterion("MODERATION_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andModerationFlagIsNotNull() {
			addCriterion("MODERATION_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andModerationFlagEqualTo(Boolean value) {
			addCriterion("MODERATION_FLAG =", value, "moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagNotEqualTo(Boolean value) {
			addCriterion("MODERATION_FLAG <>", value, "moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagGreaterThan(Boolean value) {
			addCriterion("MODERATION_FLAG >", value, "moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("MODERATION_FLAG >=", value, "moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagLessThan(Boolean value) {
			addCriterion("MODERATION_FLAG <", value, "moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("MODERATION_FLAG <=", value, "moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagIn(List<Boolean> values) {
			addCriterion("MODERATION_FLAG in", values, "moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagNotIn(List<Boolean> values) {
			addCriterion("MODERATION_FLAG not in", values, "moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("MODERATION_FLAG between", value1, value2,
					"moderationFlag");
			return (Criteria) this;
		}

		public Criteria andModerationFlagNotBetween(Boolean value1,
				Boolean value2) {
			addCriterion("MODERATION_FLAG not between", value1, value2,
					"moderationFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagIsNull() {
			addCriterion("ONLY_ME_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagIsNotNull() {
			addCriterion("ONLY_ME_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagEqualTo(Boolean value) {
			addCriterion("ONLY_ME_FLAG =", value, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagNotEqualTo(Boolean value) {
			addCriterion("ONLY_ME_FLAG <>", value, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagGreaterThan(Boolean value) {
			addCriterion("ONLY_ME_FLAG >", value, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ONLY_ME_FLAG >=", value, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagLessThan(Boolean value) {
			addCriterion("ONLY_ME_FLAG <", value, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("ONLY_ME_FLAG <=", value, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagIn(List<Boolean> values) {
			addCriterion("ONLY_ME_FLAG in", values, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagNotIn(List<Boolean> values) {
			addCriterion("ONLY_ME_FLAG not in", values, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("ONLY_ME_FLAG between", value1, value2, "onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andOnlyMeFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ONLY_ME_FLAG not between", value1, value2,
					"onlyMeFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagIsNull() {
			addCriterion("KARMA_EMAIL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagIsNotNull() {
			addCriterion("KARMA_EMAIL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagEqualTo(Boolean value) {
			addCriterion("KARMA_EMAIL_FLAG =", value, "karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagNotEqualTo(Boolean value) {
			addCriterion("KARMA_EMAIL_FLAG <>", value, "karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagGreaterThan(Boolean value) {
			addCriterion("KARMA_EMAIL_FLAG >", value, "karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("KARMA_EMAIL_FLAG >=", value, "karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagLessThan(Boolean value) {
			addCriterion("KARMA_EMAIL_FLAG <", value, "karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("KARMA_EMAIL_FLAG <=", value, "karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagIn(List<Boolean> values) {
			addCriterion("KARMA_EMAIL_FLAG in", values, "karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagNotIn(List<Boolean> values) {
			addCriterion("KARMA_EMAIL_FLAG not in", values, "karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("KARMA_EMAIL_FLAG between", value1, value2,
					"karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaEmailFlagNotBetween(Boolean value1,
				Boolean value2) {
			addCriterion("KARMA_EMAIL_FLAG not between", value1, value2,
					"karmaEmailFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagIsNull() {
			addCriterion("KARMA_PM_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagIsNotNull() {
			addCriterion("KARMA_PM_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagEqualTo(Boolean value) {
			addCriterion("KARMA_PM_FLAG =", value, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagNotEqualTo(Boolean value) {
			addCriterion("KARMA_PM_FLAG <>", value, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagGreaterThan(Boolean value) {
			addCriterion("KARMA_PM_FLAG >", value, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("KARMA_PM_FLAG >=", value, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagLessThan(Boolean value) {
			addCriterion("KARMA_PM_FLAG <", value, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("KARMA_PM_FLAG <=", value, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagIn(List<Boolean> values) {
			addCriterion("KARMA_PM_FLAG in", values, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagNotIn(List<Boolean> values) {
			addCriterion("KARMA_PM_FLAG not in", values, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("KARMA_PM_FLAG between", value1, value2, "karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andKarmaPmFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("KARMA_PM_FLAG not between", value1, value2,
					"karmaPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagIsNull() {
			addCriterion("TAGGED_EMAIL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagIsNotNull() {
			addCriterion("TAGGED_EMAIL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagEqualTo(Boolean value) {
			addCriterion("TAGGED_EMAIL_FLAG =", value, "taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagNotEqualTo(Boolean value) {
			addCriterion("TAGGED_EMAIL_FLAG <>", value, "taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagGreaterThan(Boolean value) {
			addCriterion("TAGGED_EMAIL_FLAG >", value, "taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("TAGGED_EMAIL_FLAG >=", value, "taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagLessThan(Boolean value) {
			addCriterion("TAGGED_EMAIL_FLAG <", value, "taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("TAGGED_EMAIL_FLAG <=", value, "taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagIn(List<Boolean> values) {
			addCriterion("TAGGED_EMAIL_FLAG in", values, "taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagNotIn(List<Boolean> values) {
			addCriterion("TAGGED_EMAIL_FLAG not in", values, "taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("TAGGED_EMAIL_FLAG between", value1, value2,
					"taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedEmailFlagNotBetween(Boolean value1,
				Boolean value2) {
			addCriterion("TAGGED_EMAIL_FLAG not between", value1, value2,
					"taggedEmailFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagIsNull() {
			addCriterion("TAGGED_PM_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagIsNotNull() {
			addCriterion("TAGGED_PM_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagEqualTo(Boolean value) {
			addCriterion("TAGGED_PM_FLAG =", value, "taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagNotEqualTo(Boolean value) {
			addCriterion("TAGGED_PM_FLAG <>", value, "taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagGreaterThan(Boolean value) {
			addCriterion("TAGGED_PM_FLAG >", value, "taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("TAGGED_PM_FLAG >=", value, "taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagLessThan(Boolean value) {
			addCriterion("TAGGED_PM_FLAG <", value, "taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("TAGGED_PM_FLAG <=", value, "taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagIn(List<Boolean> values) {
			addCriterion("TAGGED_PM_FLAG in", values, "taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagNotIn(List<Boolean> values) {
			addCriterion("TAGGED_PM_FLAG not in", values, "taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("TAGGED_PM_FLAG between", value1, value2,
					"taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andTaggedPmFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("TAGGED_PM_FLAG not between", value1, value2,
					"taggedPmFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagIsNull() {
			addCriterion("PM_EMAIL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagIsNotNull() {
			addCriterion("PM_EMAIL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagEqualTo(Boolean value) {
			addCriterion("PM_EMAIL_FLAG =", value, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagNotEqualTo(Boolean value) {
			addCriterion("PM_EMAIL_FLAG <>", value, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagGreaterThan(Boolean value) {
			addCriterion("PM_EMAIL_FLAG >", value, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("PM_EMAIL_FLAG >=", value, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagLessThan(Boolean value) {
			addCriterion("PM_EMAIL_FLAG <", value, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("PM_EMAIL_FLAG <=", value, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagIn(List<Boolean> values) {
			addCriterion("PM_EMAIL_FLAG in", values, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagNotIn(List<Boolean> values) {
			addCriterion("PM_EMAIL_FLAG not in", values, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("PM_EMAIL_FLAG between", value1, value2, "pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPmEmailFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("PM_EMAIL_FLAG not between", value1, value2,
					"pmEmailFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagIsNull() {
			addCriterion("POSTED_IN_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagIsNotNull() {
			addCriterion("POSTED_IN_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagEqualTo(Boolean value) {
			addCriterion("POSTED_IN_FLAG =", value, "postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagNotEqualTo(Boolean value) {
			addCriterion("POSTED_IN_FLAG <>", value, "postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagGreaterThan(Boolean value) {
			addCriterion("POSTED_IN_FLAG >", value, "postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("POSTED_IN_FLAG >=", value, "postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagLessThan(Boolean value) {
			addCriterion("POSTED_IN_FLAG <", value, "postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("POSTED_IN_FLAG <=", value, "postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagIn(List<Boolean> values) {
			addCriterion("POSTED_IN_FLAG in", values, "postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagNotIn(List<Boolean> values) {
			addCriterion("POSTED_IN_FLAG not in", values, "postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("POSTED_IN_FLAG between", value1, value2,
					"postedInFlag");
			return (Criteria) this;
		}

		public Criteria andPostedInFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("POSTED_IN_FLAG not between", value1, value2,
					"postedInFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagIsNull() {
			addCriterion("REPLIES_TO_ME_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagIsNotNull() {
			addCriterion("REPLIES_TO_ME_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagEqualTo(Boolean value) {
			addCriterion("REPLIES_TO_ME_FLAG =", value, "repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagNotEqualTo(Boolean value) {
			addCriterion("REPLIES_TO_ME_FLAG <>", value, "repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagGreaterThan(Boolean value) {
			addCriterion("REPLIES_TO_ME_FLAG >", value, "repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("REPLIES_TO_ME_FLAG >=", value, "repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagLessThan(Boolean value) {
			addCriterion("REPLIES_TO_ME_FLAG <", value, "repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("REPLIES_TO_ME_FLAG <=", value, "repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagIn(List<Boolean> values) {
			addCriterion("REPLIES_TO_ME_FLAG in", values, "repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagNotIn(List<Boolean> values) {
			addCriterion("REPLIES_TO_ME_FLAG not in", values, "repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("REPLIES_TO_ME_FLAG between", value1, value2,
					"repliesToMeFlag");
			return (Criteria) this;
		}

		public Criteria andRepliesToMeFlagNotBetween(Boolean value1,
				Boolean value2) {
			addCriterion("REPLIES_TO_ME_FLAG not between", value1, value2,
					"repliesToMeFlag");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table NOTIFICATION_SETTINGS
	 * @mbggenerated  Sat Feb 25 11:33:21 EST 2017
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
     * This class corresponds to the database table NOTIFICATION_SETTINGS
     *
     * @mbggenerated do_not_delete_during_merge Mon Feb 13 22:55:47 EST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}