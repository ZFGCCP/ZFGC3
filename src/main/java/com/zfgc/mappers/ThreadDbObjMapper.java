package com.zfgc.mappers;

import com.zfgc.dbobj.ThreadDbObj;
import com.zfgc.dbobj.ThreadDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThreadDbObjMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int countByExample(ThreadDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int deleteByExample(ThreadDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int deleteByPrimaryKey(Integer threadId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int insert(ThreadDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int insertSelective(ThreadDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    List<ThreadDbObj> selectByExample(ThreadDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    ThreadDbObj selectByPrimaryKey(Integer threadId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int updateByExampleSelective(@Param("record") ThreadDbObj record, @Param("example") ThreadDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int updateByExample(@Param("record") ThreadDbObj record, @Param("example") ThreadDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int updateByPrimaryKeySelective(ThreadDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THREAD
     *
     * @mbggenerated Sun Jan 08 19:40:04 EST 2017
     */
    int updateByPrimaryKey(ThreadDbObj record);
}