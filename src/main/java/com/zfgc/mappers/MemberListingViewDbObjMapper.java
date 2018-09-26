package com.zfgc.mappers;

import com.zfgc.dbobj.MemberListingViewDbObj;
import com.zfgc.dbobj.MemberListingViewDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberListingViewDbObjMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_LISTING_VIEW
     *
     * @mbg.generated Sun Sep 16 12:03:50 EDT 2018
     */
    long countByExample(MemberListingViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_LISTING_VIEW
     *
     * @mbg.generated Sun Sep 16 12:03:50 EDT 2018
     */
    int deleteByExample(MemberListingViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_LISTING_VIEW
     *
     * @mbg.generated Sun Sep 16 12:03:50 EDT 2018
     */
    int insert(MemberListingViewDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_LISTING_VIEW
     *
     * @mbg.generated Sun Sep 16 12:03:50 EDT 2018
     */
    int insertSelective(MemberListingViewDbObj record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_LISTING_VIEW
     *
     * @mbg.generated Sun Sep 16 12:03:50 EDT 2018
     */
    List<MemberListingViewDbObj> selectByExample(MemberListingViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_LISTING_VIEW
     *
     * @mbg.generated Sun Sep 16 12:03:50 EDT 2018
     */
    int updateByExampleSelective(@Param("record") MemberListingViewDbObj record, @Param("example") MemberListingViewDbObjExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_LISTING_VIEW
     *
     * @mbg.generated Sun Sep 16 12:03:50 EDT 2018
     */
    int updateByExample(@Param("record") MemberListingViewDbObj record, @Param("example") MemberListingViewDbObjExample example);
}