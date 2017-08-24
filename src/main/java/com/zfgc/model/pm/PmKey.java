package com.zfgc.model.pm;

import com.zfgc.model.BaseZfgcModel;

public class PmKey extends BaseZfgcModel {

	private Integer pmKeyId;
	private Integer usersId;
	private String pmPubKeyRsa;
	private String pmPrivKeyRsaEncrypted;
	
	public Integer getPmKeyId() {
		return pmKeyId;
	}

	public void setPmKeyId(Integer pmKeyId) {
		this.pmKeyId = pmKeyId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getPmPubKeyRsa() {
		return pmPubKeyRsa;
	}

	public void setPmPubKeyRsa(String pmPubKeyRsa) {
		this.pmPubKeyRsa = pmPubKeyRsa;
	}

	public String getPmPrivKeyRsaEncrypted() {
		return pmPrivKeyRsaEncrypted;
	}

	public void setPmPrivKeyRsaEncrypted(String pmPrivKeyRsaEncrypted) {
		this.pmPrivKeyRsaEncrypted = pmPrivKeyRsaEncrypted;
	}

	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}

}
