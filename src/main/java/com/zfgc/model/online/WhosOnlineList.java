package com.zfgc.model.online;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class WhosOnlineList extends BaseZfgcModel {

	private List<OnlineUser> onlineUsers = new ArrayList<>();
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OnlineUser> getOnlineUsers() {
		return onlineUsers;
	}

	public void setOnlineUsers(List<OnlineUser> onlineUsers) {
		this.onlineUsers = onlineUsers;
	}

}
