package com.zfgc.dbobj;

public class PersonalMessageDbObjWithBLOBs extends PersonalMessageDbObj {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_MESSAGE.SUBJECT
     *
     * @mbggenerated Wed Aug 23 23:03:48 EDT 2017
     */
    private String subject;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_MESSAGE.MESSAGE
     *
     * @mbggenerated Wed Aug 23 23:03:48 EDT 2017
     */
    private String message;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_MESSAGE.SUBJECT
     *
     * @return the value of PERSONAL_MESSAGE.SUBJECT
     *
     * @mbggenerated Wed Aug 23 23:03:48 EDT 2017
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_MESSAGE.SUBJECT
     *
     * @param subject the value for PERSONAL_MESSAGE.SUBJECT
     *
     * @mbggenerated Wed Aug 23 23:03:48 EDT 2017
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_MESSAGE.MESSAGE
     *
     * @return the value of PERSONAL_MESSAGE.MESSAGE
     *
     * @mbggenerated Wed Aug 23 23:03:48 EDT 2017
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_MESSAGE.MESSAGE
     *
     * @param message the value for PERSONAL_MESSAGE.MESSAGE
     *
     * @mbggenerated Wed Aug 23 23:03:48 EDT 2017
     */
    public void setMessage(String message) {
        this.message = message;
    }
}