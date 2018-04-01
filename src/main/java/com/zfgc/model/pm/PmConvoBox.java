package com.zfgc.model.pm;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zfgc.model.BaseZfgcModel;

@Component
public class PmConvoBox extends BaseZfgcModel{

	private List<PmConversationView> conversations;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PmConversationView> getConversations() {
		return conversations;
	}

	public void setConversations(List<PmConversationView> conversations) {
		this.conversations = conversations;
	}
	
}