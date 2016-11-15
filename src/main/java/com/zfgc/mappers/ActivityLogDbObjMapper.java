package com.zfgc.mappers;

import com.zfgc.dbobj.ActivityLogDbObj;
import com.zfgc.dbobj.ActivityLogDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityLogDbObjMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int countByExample(ActivityLogDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int deleteByExample(ActivityLogDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int deleteByPrimaryKey(Long activityLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int insert(ActivityLogDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int insertSelective(ActivityLogDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    List<ActivityLogDbObj> selectByExample(ActivityLogDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    ActivityLogDbObj selectByPrimaryKey(Long activityLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int updateByExampleSelective(@Param("record") ActivityLogDbObj record, @Param("example") ActivityLogDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int updateByExample(@Param("record") ActivityLogDbObj record, @Param("example") ActivityLogDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int updateByPrimaryKeySelective(ActivityLogDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_LOG
     *
     * @mbggenerated Sat Nov 12 16:45:49 EST 2016
     */
    int updateByPrimaryKey(ActivityLogDbObj record);
}