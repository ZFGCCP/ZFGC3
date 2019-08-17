package com.zfgc.mappers;

import com.zfgc.dbobj.NavTabViewDbObj;
import com.zfgc.dbobj.NavTabViewDbObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavTabViewDbObjMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NAV_TAB_VIEW
	 * @mbg.generated  Sat Aug 17 15:37:50 EDT 2019
	 */
	long countByExample(NavTabViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NAV_TAB_VIEW
	 * @mbg.generated  Sat Aug 17 15:37:50 EDT 2019
	 */
	int deleteByExample(NavTabViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NAV_TAB_VIEW
	 * @mbg.generated  Sat Aug 17 15:37:50 EDT 2019
	 */
	int insert(NavTabViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NAV_TAB_VIEW
	 * @mbg.generated  Sat Aug 17 15:37:50 EDT 2019
	 */
	int insertSelective(NavTabViewDbObj record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NAV_TAB_VIEW
	 * @mbg.generated  Sat Aug 17 15:37:50 EDT 2019
	 */
	List<NavTabViewDbObj> selectByExample(NavTabViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NAV_TAB_VIEW
	 * @mbg.generated  Sat Aug 17 15:37:50 EDT 2019
	 */
	int updateByExampleSelective(@Param("record") NavTabViewDbObj record,
			@Param("example") NavTabViewDbObjExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NAV_TAB_VIEW
	 * @mbg.generated  Sat Aug 17 15:37:50 EDT 2019
	 */
	int updateByExample(@Param("record") NavTabViewDbObj record, @Param("example") NavTabViewDbObjExample example);

	//custom
    List<NavTabViewDbObj> getNavigationTabs(@Param("memberGroupIds") List<Integer> memberGroupIds, @Param("primaryMemberGroupId") Integer primaryMemberGroupId);
}