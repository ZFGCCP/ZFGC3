package com.zfgc.util.security;

import java.security.Key;

public class RsaKeyPair {
	private Key publicKey;
	private Key privateKey;
	
	public Key getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(Key privateKey) {
		this.privateKey = privateKey;
	}
	public Key getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(Key publicKey) {
		this.publicKey = publicKey;
	}
}
