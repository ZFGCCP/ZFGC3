package com.zfgc.mappers;

import com.zfgc.dbobj.TopicViewDbObj;
import com.zfgc.dbobj.TopicViewDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicViewDbObjMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	long countByExample(TopicViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	int deleteByExample(TopicViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	int insert(TopicViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	int insertSelective(TopicViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	List<TopicViewDbObj> selectByExampleWithBLOBs(TopicViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	List<TopicViewDbObj> selectByExample(TopicViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	int updateByExampleSelective(@Param("record") TopicViewDbObj record,
			@Param("example") TopicViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	int updateByExampleWithBLOBs(@Param("record") TopicViewDbObj record,
			@Param("example") TopicViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TOPIC_VIEW
	 * @mbg.generated  Sun Aug 02 19:40:51 EDT 2020
	 */
	int updateByExample(@Param("record") TopicViewDbObj record, @Param("example") TopicViewDbObjExample example);
}