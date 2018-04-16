package com.zfgc.model.pm;

import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class PmConversationMulti extends BaseZfgcModel {

	private TwoFactorKey aesKey;
	private List<Integer> convoIds;
	
	public TwoFactorKey getAesKey() {
		return aesKey;
	}

	public void setAesKey(TwoFactorKey aesKey) {
		this.aesKey = aesKey;
	}

	public List<Integer> getConvoIds() {
		return convoIds;
	}

	public void setConvoIds(List<Integer> convoIds) {
		this.convoIds = convoIds;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
