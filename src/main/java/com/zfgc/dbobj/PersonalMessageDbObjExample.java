package com.zfgc.dbobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonalMessageDbObjExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public PersonalMessageDbObjExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
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

		public Criteria andPersonalMessageIdIsNull() {
			addCriterion("PERSONAL_MESSAGE_ID is null");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdIsNotNull() {
			addCriterion("PERSONAL_MESSAGE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdEqualTo(Integer value) {
			addCriterion("PERSONAL_MESSAGE_ID =", value, "personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdNotEqualTo(Integer value) {
			addCriterion("PERSONAL_MESSAGE_ID <>", value, "personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdGreaterThan(Integer value) {
			addCriterion("PERSONAL_MESSAGE_ID >", value, "personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PERSONAL_MESSAGE_ID >=", value, "personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdLessThan(Integer value) {
			addCriterion("PERSONAL_MESSAGE_ID <", value, "personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdLessThanOrEqualTo(Integer value) {
			addCriterion("PERSONAL_MESSAGE_ID <=", value, "personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdIn(List<Integer> values) {
			addCriterion("PERSONAL_MESSAGE_ID in", values, "personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdNotIn(List<Integer> values) {
			addCriterion("PERSONAL_MESSAGE_ID not in", values,
					"personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdBetween(Integer value1,
				Integer value2) {
			addCriterion("PERSONAL_MESSAGE_ID between", value1, value2,
					"personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPersonalMessageIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("PERSONAL_MESSAGE_ID not between", value1, value2,
					"personalMessageId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdIsNull() {
			addCriterion("PM_CONVERSATION_ID is null");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdIsNotNull() {
			addCriterion("PM_CONVERSATION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdEqualTo(Integer value) {
			addCriterion("PM_CONVERSATION_ID =", value, "pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdNotEqualTo(Integer value) {
			addCriterion("PM_CONVERSATION_ID <>", value, "pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdGreaterThan(Integer value) {
			addCriterion("PM_CONVERSATION_ID >", value, "pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PM_CONVERSATION_ID >=", value, "pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdLessThan(Integer value) {
			addCriterion("PM_CONVERSATION_ID <", value, "pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdLessThanOrEqualTo(Integer value) {
			addCriterion("PM_CONVERSATION_ID <=", value, "pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdIn(List<Integer> values) {
			addCriterion("PM_CONVERSATION_ID in", values, "pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdNotIn(List<Integer> values) {
			addCriterion("PM_CONVERSATION_ID not in", values,
					"pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdBetween(Integer value1,
				Integer value2) {
			addCriterion("PM_CONVERSATION_ID between", value1, value2,
					"pmConversationId");
			return (Criteria) this;
		}

		public Criteria andPmConversationIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("PM_CONVERSATION_ID not between", value1, value2,
					"pmConversationId");
			return (Criteria) this;
		}

		public Criteria andSenderIdIsNull() {
			addCriterion("SENDER_ID is null");
			return (Criteria) this;
		}

		public Criteria andSenderIdIsNotNull() {
			addCriterion("SENDER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSenderIdEqualTo(Integer value) {
			addCriterion("SENDER_ID =", value, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdNotEqualTo(Integer value) {
			addCriterion("SENDER_ID <>", value, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdGreaterThan(Integer value) {
			addCriterion("SENDER_ID >", value, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SENDER_ID >=", value, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdLessThan(Integer value) {
			addCriterion("SENDER_ID <", value, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdLessThanOrEqualTo(Integer value) {
			addCriterion("SENDER_ID <=", value, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdIn(List<Integer> values) {
			addCriterion("SENDER_ID in", values, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdNotIn(List<Integer> values) {
			addCriterion("SENDER_ID not in", values, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdBetween(Integer value1, Integer value2) {
			addCriterion("SENDER_ID between", value1, value2, "senderId");
			return (Criteria) this;
		}

		public Criteria andSenderIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SENDER_ID not between", value1, value2, "senderId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdIsNull() {
			addCriterion("RECEIVER_ID is null");
			return (Criteria) this;
		}

		public Criteria andReceiverIdIsNotNull() {
			addCriterion("RECEIVER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverIdEqualTo(Integer value) {
			addCriterion("RECEIVER_ID =", value, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdNotEqualTo(Integer value) {
			addCriterion("RECEIVER_ID <>", value, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdGreaterThan(Integer value) {
			addCriterion("RECEIVER_ID >", value, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("RECEIVER_ID >=", value, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdLessThan(Integer value) {
			addCriterion("RECEIVER_ID <", value, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdLessThanOrEqualTo(Integer value) {
			addCriterion("RECEIVER_ID <=", value, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdIn(List<Integer> values) {
			addCriterion("RECEIVER_ID in", values, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdNotIn(List<Integer> values) {
			addCriterion("RECEIVER_ID not in", values, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdBetween(Integer value1, Integer value2) {
			addCriterion("RECEIVER_ID between", value1, value2, "receiverId");
			return (Criteria) this;
		}

		public Criteria andReceiverIdNotBetween(Integer value1, Integer value2) {
			addCriterion("RECEIVER_ID not between", value1, value2,
					"receiverId");
			return (Criteria) this;
		}

		public Criteria andSentDtIsNull() {
			addCriterion("SENT_DT is null");
			return (Criteria) this;
		}

		public Criteria andSentDtIsNotNull() {
			addCriterion("SENT_DT is not null");
			return (Criteria) this;
		}

		public Criteria andSentDtEqualTo(Date value) {
			addCriterion("SENT_DT =", value, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtNotEqualTo(Date value) {
			addCriterion("SENT_DT <>", value, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtGreaterThan(Date value) {
			addCriterion("SENT_DT >", value, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtGreaterThanOrEqualTo(Date value) {
			addCriterion("SENT_DT >=", value, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtLessThan(Date value) {
			addCriterion("SENT_DT <", value, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtLessThanOrEqualTo(Date value) {
			addCriterion("SENT_DT <=", value, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtIn(List<Date> values) {
			addCriterion("SENT_DT in", values, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtNotIn(List<Date> values) {
			addCriterion("SENT_DT not in", values, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtBetween(Date value1, Date value2) {
			addCriterion("SENT_DT between", value1, value2, "sentDt");
			return (Criteria) this;
		}

		public Criteria andSentDtNotBetween(Date value1, Date value2) {
			addCriterion("SENT_DT not between", value1, value2, "sentDt");
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

		public Criteria andSendCopyFlagIsNull() {
			addCriterion("SEND_COPY_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagIsNotNull() {
			addCriterion("SEND_COPY_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagEqualTo(Boolean value) {
			addCriterion("SEND_COPY_FLAG =", value, "sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagNotEqualTo(Boolean value) {
			addCriterion("SEND_COPY_FLAG <>", value, "sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagGreaterThan(Boolean value) {
			addCriterion("SEND_COPY_FLAG >", value, "sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SEND_COPY_FLAG >=", value, "sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagLessThan(Boolean value) {
			addCriterion("SEND_COPY_FLAG <", value, "sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("SEND_COPY_FLAG <=", value, "sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagIn(List<Boolean> values) {
			addCriterion("SEND_COPY_FLAG in", values, "sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagNotIn(List<Boolean> values) {
			addCriterion("SEND_COPY_FLAG not in", values, "sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("SEND_COPY_FLAG between", value1, value2,
					"sendCopyFlag");
			return (Criteria) this;
		}

		public Criteria andSendCopyFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SEND_COPY_FLAG not between", value1, value2,
					"sendCopyFlag");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table PERSONAL_MESSAGE
	 * @mbggenerated  Wed Sep 06 19:27:46 EDT 2017
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
     * This class corresponds to the database table PERSONAL_MESSAGE
     *
     * @mbggenerated do_not_delete_during_merge Sat Aug 12 10:17:55 EDT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}