package com.zfgc.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class Poll extends BaseZfgcModel {

	private String question;
	private Integer maxVotesPerUser;
	private Integer runForDays;
	private Boolean allowChange = false;
	private Integer resultVisibilityId = 0;
	private Integer pollId;
	private Boolean multipleChoiceFlag = false;
	private Integer threadId;
	
	private List<PollOption> options = new ArrayList<>();
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getMaxVotesPerUser() {
		return maxVotesPerUser;
	}

	public void setMaxVotesPerUser(Integer maxVotesPerUser) {
		this.maxVotesPerUser = maxVotesPerUser;
	}

	public Integer getRunForDays() {
		return runForDays;
	}

	public void setRunForDays(Integer runForDays) {
		this.runForDays = runForDays;
	}

	public Boolean getAllowChange() {
		return allowChange;
	}

	public void setAllowChange(Boolean allowChange) {
		this.allowChange = allowChange;
	}

	public Integer getResultVisibilityId() {
		return resultVisibilityId;
	}

	public void setResultVisibilityId(Integer resultVisibilityId) {
		this.resultVisibilityId = resultVisibilityId;
	}

	public Integer getPollId() {
		return pollId;
	}

	public void setPollId(Integer pollId) {
		this.pollId = pollId;
	}

	public Boolean getMultipleChoiceFlag() {
		return multipleChoiceFlag;
	}

	public void setMultipleChoiceFlag(Boolean multipleChoiceFlag) {
		this.multipleChoiceFlag = multipleChoiceFlag;
	}

	public List<PollOption> getOptions() {
		return options;
	}

	public void setOptions(List<PollOption> options) {
		this.options = options;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getThreadId() {
		return threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	
}