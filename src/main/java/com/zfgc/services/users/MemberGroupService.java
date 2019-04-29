package com.zfgc.services.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.BrMemberGroupUserDataProvider;
import com.zfgc.dataprovider.LkupMemberGroupDataProvider;
import com.zfgc.model.bridge.BrMemberGroupUser;
import com.zfgc.model.lkup.LkupMemberGroup;
import com.zfgc.model.users.SecondaryMemberGroups;
import com.zfgc.services.AbstractService;

@Component
public class MemberGroupService extends AbstractService{
	
	@Autowired
	private BrMemberGroupUserDataProvider brMemberGroupUserDataProvider;
	
	@Autowired
	private LkupMemberGroupDataProvider lkupMemberGroupDataProvider;
	
	public SecondaryMemberGroups getSecondaryMemberGroups(Integer usersId){
		List<BrMemberGroupUser> groups = brMemberGroupUserDataProvider.getMemberGroupUsers(usersId);
		SecondaryMemberGroups result = new SecondaryMemberGroups();
		result.setUsersId(usersId);
		
		for(BrMemberGroupUser group : groups){
			LkupMemberGroup memberGroup = lkupMemberGroupDataProvider.getMemberGroup(group.getMemberGroupId());
			result.getMemberGroups().add(memberGroup);
		}
		
		return result;
	}
	
}