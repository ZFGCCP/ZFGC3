package com.zfgc.services.saml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zfgc.dataprovider.UserConnectionDataProvider;
import com.zfgc.dataprovider.UsersDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.lkup.LkupMemberGroup;
import com.zfgc.model.users.Hostname;
import com.zfgc.model.users.IpAddress;
import com.zfgc.model.users.Permissions;
import com.zfgc.model.users.UserConnection;
import com.zfgc.model.users.Users;
import com.zfgc.services.ip.IpAddressService;
import com.zfgc.services.users.PermissionsService;
import com.zfgc.services.users.UsersService;
import com.zfgc.util.security.ZfgcSecurityUtils;

@Service
public class OauthUsersDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UsersDataProvider usersDataProvider;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	IpAddressService ipService;
	
	@Autowired
	PermissionsService permissionsService;
	
	@Autowired
	UserConnectionDataProvider userConnectionDataProvider;
	
	private List<String> roles;
	 
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = new Users();
        try {
			user = usersService.getUserByEmail(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        //did the user's primary IP change since last log in?
       /* IpAddress primaryIp = user.getPrimaryIpAddress();
        if(!user.getCurrentIpAddress().equals(primaryIp.getIpAddress())) {
        	//does this IP exist already?
        	try {
				IpAddress ipCheck = ipService.getIpAddress(user.getCurrentIpAddress());
				
				user.setPrimaryIp(ipCheck.getIpAddressId());
				user.setPrimaryIpAddress(ipCheck);
			} catch (ZfgcNotFoundException e) {
				IpAddress newIp = ipService.createIpAddress(user.getCurrentIpAddress());
	        	user.setPrimaryIpAddress(newIp);
	        	user.setPrimaryIp(newIp.getIpAddressId());
	        	
				e.printStackTrace();
			}
        	catch (Exception ex) {
        		ex.printStackTrace();
        	}
        }
        
        //did the user's primary hostname change since last log in?
        Hostname primaryHostname = user.getPrimaryHostname();
        if(!user.getCurrentHostname().equals(primaryHostname.getHostname())) {
        	//does this hostname exist already?
        	try {
        		Hostname hostCheck = ipService.getHostname(user.getCurrentHostname());
        		
        		user.setPrimaryHostname(hostCheck);
        		user.setPrimaryHostnameId(hostCheck.getHostnameId());
        	}
        	catch(ZfgcNotFoundException e) {
        		Hostname newHost = ipService.createHostname(user.getCurrentHostname());
        		user.setPrimaryHostname(newHost);
        		user.setPrimaryHostnameId(newHost.getHostnameId());
        		
        		e.printStackTrace();
        	}
        	catch(Exception ex) {
        		ex.printStackTrace();
        	}
        }*/
        
        user.setFromDb(false);
        
        user.setPrimaryMemberGroupId(user.getPrimaryMemberGroupId());
        //user.setTimeZone(credential.getAttributeAsString("TIME_ZONE"));

        
        List<Integer> memberGroupIds = new ArrayList<>();
        memberGroupIds.add(user.getPrimaryMemberGroupId());
        
        if(user.getSecondaryMemberGroups() != null){
	        for(LkupMemberGroup group : user.getSecondaryMemberGroups().getMemberGroups()){
	        	memberGroupIds.add(group.getMemberGroupId());
	        }
        }
        
        user.setPermissions(permissionsService.getPermissionsByMemberGroup(memberGroupIds.toArray(new Integer[memberGroupIds.size()])));
        
        //usersDataProvider.saveUser(user);
        
        user.setSessionMatchup(ZfgcSecurityUtils.generateCryptoString(8));
        
        return user;
	}

}
