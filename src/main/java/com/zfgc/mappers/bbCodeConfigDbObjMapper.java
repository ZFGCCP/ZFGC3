package com.zfgc.mappers;

import com.zfgc.dbobj.bbCodeConfigDbObj;
import com.zfgc.dbobj.bbCodeConfigDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface bbCodeConfigDbObjMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    long countByExample(bbCodeConfigDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    int deleteByExample(bbCodeConfigDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    int deleteByPrimaryKey(Integer bbCodeConfigId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    int insert(bbCodeConfigDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    int insertSelective(bbCodeConfigDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    List<bbCodeConfigDbObj> selectByExample(bbCodeConfigDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    bbCodeConfigDbObj selectByPrimaryKey(Integer bbCodeConfigId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    int updateByExampleSelective(@Param("record") bbCodeConfigDbObj record, @Param("example") bbCodeConfigDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    int updateByExample(@Param("record") bbCodeConfigDbObj record, @Param("example") bbCodeConfigDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    int updateByPrimaryKeySelective(bbCodeConfigDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BB_CODE_CONFIG
     *
     * @mbg.generated Fri Jun 02 22:45:29 EDT 2017
     */
    int updateByPrimaryKey(bbCodeConfigDbObj record);
}