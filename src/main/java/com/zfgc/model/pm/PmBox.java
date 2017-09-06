package com.zfgc.model.pm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zfgc.model.BaseZfgcModel;

@Component
public class PmBox extends BaseZfgcModel{

	private List<PersonalMessage> messageList = new ArrayList<>();
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PersonalMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<PersonalMessage> messageList) {
		this.messageList = messageList;
	}
	
}