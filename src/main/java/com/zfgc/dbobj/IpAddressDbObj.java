package com.zfgc.dbobj;

public class IpAddressDbObj {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column IP_ADDRESS.IP_ADDRESS
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    private String ipAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column IP_ADDRESS.VERSION
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    private Byte version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column IP_ADDRESS.IS_SPAMMER_FLAG
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    private Boolean isSpammerFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IP_ADDRESS.IP_ADDRESS
     *
     * @return the value of IP_ADDRESS.IP_ADDRESS
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IP_ADDRESS.IP_ADDRESS
     *
     * @param ipAddress the value for IP_ADDRESS.IP_ADDRESS
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IP_ADDRESS.VERSION
     *
     * @return the value of IP_ADDRESS.VERSION
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    public Byte getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IP_ADDRESS.VERSION
     *
     * @param version the value for IP_ADDRESS.VERSION
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    public void setVersion(Byte version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IP_ADDRESS.IS_SPAMMER_FLAG
     *
     * @return the value of IP_ADDRESS.IS_SPAMMER_FLAG
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    public Boolean getIsSpammerFlag() {
        return isSpammerFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IP_ADDRESS.IS_SPAMMER_FLAG
     *
     * @param isSpammerFlag the value for IP_ADDRESS.IS_SPAMMER_FLAG
     *
     * @mbggenerated Thu Nov 03 12:42:31 EDT 2016
     */
    public void setIsSpammerFlag(Boolean isSpammerFlag) {
        this.isSpammerFlag = isSpammerFlag;
    }
}