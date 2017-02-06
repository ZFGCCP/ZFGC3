package com.zfgc.services.userprofile;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.NavTabDataProvider;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NavTab;
import com.zfgc.services.AbstractService;
import com.zfgc.services.lookups.LookupService;

@Component
public class NavTabService extends AbstractService {

	@Autowired
	NavTabDataProvider navTabDataProvider;
	
	@Autowired
	LookupService lookupService;
	
	public List<NavTab> getUserProfileNavTabs(Users user, Integer userProfileId){
		List<NavTab> navTabs = null;
		try{
			navTabs = navTabDataProvider.getNavTabs(user);
		}
		catch(Exception ex){
			return null;
		}
		
		for(Iterator<NavTab> itr = navTabs.iterator(); itr.hasNext();){
			NavTab navTab = itr.next();
			/*for(Iterator<NavTab> iterator = navTab.getSubTabs().iterator(); iterator.hasNext();){
				NavTab childTab = iterator.next();
				if(childTab.getAllowSelfFlag() && !canViewSelfTab(userProfileId, user)){
					iterator.remove();
				}
			}*/
			
			if(navTab.getSubTabs().size() == 0){
				itr.remove();
			}
		}
		
		if(navTabs != null && navTabs.size() > 0){
			navTabs.get(0).setActive(true);
		}
		else{
			return null;
		}

		return navTabs;
	}
	
	private Boolean canViewSelfTab(Integer userProfileId, Users user){
		return userProfileId == user.getUsersId() || user.getPrimaryMemberGroupId() == 1 || user.getMemberGroups().contains(1);
	}
}
