package com.zfgc.model.forum;

import com.zfgc.model.BaseZfgcModel;

public class PollOption extends BaseZfgcModel {
	
	private Integer pollOptionId;
	private Integer pollId;
	private String optionText;
	
	public Integer getPollOptionId() {
		return pollOptionId;
	}

	public void setPollOptionId(Integer pollOptionId) {
		this.pollOptionId = pollOptionId;
	}

	public Integer getPollId() {
		return pollId;
	}

	public void setPollId(Integer pollId) {
		this.pollId = pollId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
