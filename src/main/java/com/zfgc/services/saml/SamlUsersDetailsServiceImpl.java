package com.zfgc.services.saml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.Users;

@Component
public class SamlUsersDetailsServiceImpl implements SAMLUserDetailsService{

	@Autowired
	UsersDataProvider usersDataProvider;
	
	private List<String> roles;
	 
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
	
	@Override
	public Object loadUserBySAML(SAMLCredential credential)
			throws UsernameNotFoundException {
		String usersId = credential.getAttributeAsString("USERS_ID");
		String displayName = credential.getAttributeAsString("DISPLAY_NAME");
		String loginName = credential.getAttributeAsString("LOGIN_NAME");
		String[] groupIds = credential.getAttributeAsStringArray("GROUP_IDS");
		String[] groupNames = credential.getAttributeAsStringArray("GROUPS");
		//String activeFlag = credential.getAttributeAsString("ACTIVE_FLAG");
		String primaryIpAddress =  credential.getAttributeAsString("PRIMARY_IP_ADDRESS");
		String primaryMemberGroupId =  credential.getAttributeAsString("PRIMARY_MEMBER_GROUP_ID");

        Users user = new Users();
        IpAddress ip = new IpAddress();
        ip.setIpAddress(primaryIpAddress);
        
        user.setUsersId(Integer.parseInt(usersId));
        user.setDisplayName(displayName);
        user.setLoginName(displayName);
        user.setFromDb(false);
        //user.setActiveFlag(activeFlag != null && activeFlag.equals("1") ? true : false);
        user.setPrimaryIpAddress(ip);
        user.setPrimaryMemberGroupId(Integer.parseInt(primaryMemberGroupId));
        user.setTimeZone(credential.getAttributeAsString("TIME_ZONE"));
        
        Map<Integer, String> groups = new HashMap<Integer, String>();
        
        for(int i = 0; i < groupIds.length; i++){
        	groups.put(Integer.parseInt(groupIds[i]), groupNames[i]);
        }
        
        user.setMemberGroups(groups);
        
        return user;
	}

}
