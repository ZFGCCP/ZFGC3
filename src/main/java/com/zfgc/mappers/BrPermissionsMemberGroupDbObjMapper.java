package com.zfgc.mappers;

import com.zfgc.dbobj.BrPermissionsMemberGroupDbObjExample;
import com.zfgc.dbobj.BrPermissionsMemberGroupDbObjKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrPermissionsMemberGroupDbObjMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_PERMISSIONS_MEMBER_GROUP
     *
     * @mbggenerated Sun Mar 24 17:30:13 EDT 2019
     */
    int countByExample(BrPermissionsMemberGroupDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_PERMISSIONS_MEMBER_GROUP
     *
     * @mbggenerated Sun Mar 24 17:30:13 EDT 2019
     */
    int deleteByExample(BrPermissionsMemberGroupDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_PERMISSIONS_MEMBER_GROUP
     *
     * @mbggenerated Sun Mar 24 17:30:13 EDT 2019
     */
    int deleteByPrimaryKey(BrPermissionsMemberGroupDbObjKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_PERMISSIONS_MEMBER_GROUP
     *
     * @mbggenerated Sun Mar 24 17:30:13 EDT 2019
     */
    int insert(BrPermissionsMemberGroupDbObjKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_PERMISSIONS_MEMBER_GROUP
     *
     * @mbggenerated Sun Mar 24 17:30:13 EDT 2019
     */
    int insertSelective(BrPermissionsMemberGroupDbObjKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_PERMISSIONS_MEMBER_GROUP
     *
     * @mbggenerated Sun Mar 24 17:30:13 EDT 2019
     */
    List<BrPermissionsMemberGroupDbObjKey> selectByExample(BrPermissionsMemberGroupDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_PERMISSIONS_MEMBER_GROUP
     *
     * @mbggenerated Sun Mar 24 17:30:13 EDT 2019
     */
    int updateByExampleSelective(@Param("record") BrPermissionsMemberGroupDbObjKey record, @Param("example") BrPermissionsMemberGroupDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BR_PERMISSIONS_MEMBER_GROUP
     *
     * @mbggenerated Sun Mar 24 17:30:13 EDT 2019
     */
    int updateByExample(@Param("record") BrPermissionsMemberGroupDbObjKey record, @Param("example") BrPermissionsMemberGroupDbObjExample example);
}