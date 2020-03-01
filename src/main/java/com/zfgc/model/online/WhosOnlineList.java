package com.zfgc.model.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zfgc.model.BaseZfgcModel;

public class WhosOnlineList extends BaseZfgcModel {

	private List<OnlineUser> onlineUsers = new ArrayList<>();
	private Map<Integer, List<OnlineUser>> onlineUsersDetailed = new HashMap<>();
	
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

	public Map<Integer, List<OnlineUser>> getOnlineUsersDetailed() {
		return onlineUsersDetailed;
	}

	public void setOnlineUsersDetailed(Map<Integer, List<OnlineUser>> onlineUsersDetailed) {
		this.onlineUsersDetailed = onlineUsersDetailed;
	}
	
	public Integer getCount() {
		return onlineUsersDetailed.size();
	}

}
