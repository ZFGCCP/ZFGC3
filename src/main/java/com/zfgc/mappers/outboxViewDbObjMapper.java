package com.zfgc.mappers;

import com.zfgc.dbobj.outboxViewDbObj;
import com.zfgc.dbobj.outboxViewDbObjExample;
import com.zfgc.dbobj.outboxViewDbObjWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface outboxViewDbObjMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    int countByExample(outboxViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    int deleteByExample(outboxViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    int insert(outboxViewDbObjWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    int insertSelective(outboxViewDbObjWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    List<outboxViewDbObjWithBLOBs> selectByExampleWithBLOBs(outboxViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    List<outboxViewDbObj> selectByExample(outboxViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    int updateByExampleSelective(@Param("record") outboxViewDbObjWithBLOBs record, @Param("example") outboxViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    int updateByExampleWithBLOBs(@Param("record") outboxViewDbObjWithBLOBs record, @Param("example") outboxViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OUTBOX_VIEW
     *
     * @mbggenerated Sun Aug 27 16:37:01 EDT 2017
     */
    int updateByExample(@Param("record") outboxViewDbObj record, @Param("example") outboxViewDbObjExample example);
}