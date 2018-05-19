package com.zfgc.model.pm;

import com.zfgc.model.BaseZfgcModel;

public class PmPrune extends BaseZfgcModel {

	Integer pruneFlag = 0;
	Integer olderThan;
	Integer inactiveFor;
	Integer deleteStartedUserId;
	Integer deleteContainingUserId;
	Boolean startedByMeFlag;
	
	public Integer getPruneFlag() {
		return pruneFlag;
	}

	public void setPruneFlag(Integer pruneFlag) {
		this.pruneFlag = pruneFlag;
	}

	public Integer getOlderThan() {
		return olderThan;
	}

	public void setOlderThan(Integer olderThan) {
		this.olderThan = olderThan;
	}

	public Integer getInactiveFor() {
		return inactiveFor;
	}

	public void setInactiveFor(Integer inactiveFor) {
		this.inactiveFor = inactiveFor;
	}

	public Integer getDeleteStartedUserId() {
		return deleteStartedUserId;
	}

	public void setDeleteStartedUserId(Integer deleteStartedUserId) {
		this.deleteStartedUserId = deleteStartedUserId;
	}

	public Integer getDeleteContainingUserId() {
		return deleteContainingUserId;
	}

	public void setDeleteContainingUserId(Integer deleteContainingUserId) {
		this.deleteContainingUserId = deleteContainingUserId;
	}

	public Boolean getStartedByMeFlag() {
		return startedByMeFlag;
	}

	public void setStartedByMeFlag(Boolean startedByMeFlag) {
		this.startedByMeFlag = startedByMeFlag;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}