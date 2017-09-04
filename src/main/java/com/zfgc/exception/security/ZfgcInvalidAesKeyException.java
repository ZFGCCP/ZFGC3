package com.zfgc.exception.security;

public class ZfgcInvalidAesKeyException extends ZfgcSecurityException {

	public ZfgcInvalidAesKeyException(String parityWord) {
		super("Invalid AES key used to decrypt parity word: " + parityWord);
	}

}
