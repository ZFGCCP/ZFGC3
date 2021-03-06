package com.zfgc.mappers;

import com.zfgc.dbobj.BrUsersIpAddressDbObjExample;
import com.zfgc.dbobj.BrUsersIpAddressDbObjKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrUsersIpAddressDbObjMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_USERS_IP_ADDRESS
     *
     * @mbggenerated Sun Nov 13 18:59:44 EST 2016
     */
    int countByExample(BrUsersIpAddressDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_USERS_IP_ADDRESS
     *
     * @mbggenerated Sun Nov 13 18:59:44 EST 2016
     */
    int deleteByExample(BrUsersIpAddressDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_USERS_IP_ADDRESS
     *
     * @mbggenerated Sun Nov 13 18:59:44 EST 2016
     */
    int deleteByPrimaryKey(BrUsersIpAddressDbObjKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_USERS_IP_ADDRESS
     *
     * @mbggenerated Sun Nov 13 18:59:44 EST 2016
     */
    int insert(BrUsersIpAddressDbObjKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_USERS_IP_ADDRESS
     *
     * @mbggenerated Sun Nov 13 18:59:44 EST 2016
     */
    int insertSelective(BrUsersIpAddressDbObjKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_USERS_IP_ADDRESS
     *
     * @mbggenerated Sun Nov 13 18:59:44 EST 2016
     */
    List<BrUsersIpAddressDbObjKey> selectByExample(BrUsersIpAddressDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_USERS_IP_ADDRESS
     *
     * @mbggenerated Sun Nov 13 18:59:44 EST 2016
     */
    int updateByExampleSelective(@Param("record") BrUsersIpAddressDbObjKey record, @Param("example") BrUsersIpAddressDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_USERS_IP_ADDRESS
     *
     * @mbggenerated Sun Nov 13 18:59:44 EST 2016
     */
    int updateByExample(@Param("record") BrUsersIpAddressDbObjKey record, @Param("example") BrUsersIpAddressDbObjExample example);
}