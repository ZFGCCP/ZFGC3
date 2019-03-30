package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.NavTabDao;
import com.zfgc.dbobj.NavTabDbObj;
import com.zfgc.dbobj.NavTabViewDbObj;
import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.NavTab;

@Component
public class NavTabDataProvider extends AbstractDataProvider {
	@Autowired
	NavTabDao navTabDao;
	
	public List<NavTab> getNavTabs(Users user) throws RuntimeException{
		List<NavTabViewDbObj> navTabsDb = null;
		try{
			navTabsDb = navTabDao.getNavigationTabs(user);
		}
		catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}
		Map<Integer, NavTab> mappedTabs = new HashMap<>();
		
		for(NavTabViewDbObj navTab : navTabsDb){
			if(!mappedTabs.containsKey(navTab.getNavTabId())){
				mappedTabs.put(navTab.getNavTabId(), mapNavTabParent(navTab));
			}
			
			mappedTabs.get(navTab.getNavTabId()).getSubTabs().add(mapNavTabChild(navTab));
		}

		return new ArrayList<>(mappedTabs.values());
	}
	
	private NavTab mapNavTabParent(NavTabViewDbObj navTabDbObj){
		NavTab navTab = new NavTab();
		
		navTab.setNavTabId(navTabDbObj.getNavTabId());
		navTab.setTitle(navTabDbObj.getTitle());
		navTab.setAllowSelfFlag(navTabDbObj.getAllowSelfFlag());
		
		return navTab;
	}
	
	private NavTab mapNavTabChild(NavTabViewDbObj navTabDbObj){
		NavTab navTab = new NavTab();
		
		navTab.setNavTabId(navTabDbObj.getChildNavTabId());
		navTab.setTitle(navTabDbObj.getChildTitle());
		navTab.setNavSectionId(navTabDbObj.getLkupNavSectionId());
		navTab.setAllowSelfFlag(navTabDbObj.getAllowSelfFlag());
		
		return navTab;
	}
}
