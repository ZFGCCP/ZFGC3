package com.zfgc.model.pm;

import com.zfgc.model.BaseZfgcModel;

public class ConvoPrune extends BaseZfgcModel{

	private boolean archiveFlag = false;
	private Integer deleteOlderThan;
	private Integer deleteInactiveAfter;
	private Integer deleteStartedById;
	private Integer deleteContainingId;
	private boolean deleteStartedByMeFlag;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}