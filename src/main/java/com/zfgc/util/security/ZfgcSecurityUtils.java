package com.zfgc.util.security;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import com.zfgc.model.users.Users;

public class ZfgcSecurityUtils {

	public static RsaKeyPair generateRsaPair(){
		RsaKeyPair result = new RsaKeyPair();
		
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048);
			KeyPair kp = kpg.genKeyPair();
			result.setPublicKey(kp.getPublic());
			result.setPrivateKey(kp.getPrivate());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public static SecretKeySpec generateAesKey(String seed){
		byte[] sha = null;
		try {
			sha = generateSha1(seed).substring(0, 16).getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		SecretKeySpec key = new SecretKeySpec(sha,"AES");
		return key;
	}
	
	public static String encryptRsa(String digest, Key key){
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherData = cipher.doFinal(digest.getBytes("UTF-8"));
			
			return Base64.encodeBase64URLSafeString(cipherData);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String decryptRsa(String cipherText, Key key){
        try {
        	Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");  
            cipher.init(Cipher.DECRYPT_MODE, key);
			return new String(cipher.doFinal(Base64.decodeBase64(cipherText.getBytes("UTF-8"))));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static String encryptAes(String digest, String secretKey){
		SecretKeySpec aesKey = generateAesKey(secretKey);
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			return Base64.encodeBase64URLSafeString(cipher.doFinal(digest.getBytes("UTF-8")));
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String encryptAes(String digest, SecretKeySpec secretKey){
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.encodeBase64URLSafeString(cipher.doFinal(digest.getBytes("UTF-8")));
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String decryptAes(String cipherText, String secretKey){
		SecretKeySpec aesKey = generateAesKey(secretKey);
        
        try {
        	Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
			return new String(cipher.doFinal(Base64.decodeBase64(cipherText)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String generateSha1(String digestStr){
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-1");
			digest.update(digestStr.getBytes());
			byte[] hash = digest.digest();
			
			return Base64.encodeBase64URLSafeString(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String generateMd5(String digestStr){
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(digestStr.getBytes());
			byte[] hash = digest.digest();
			
			return Base64.encodeBase64URLSafeString(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Key stringToRsaKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException{
		try {
			byte [] keyByte = Base64.decodeBase64(key.getBytes("UTF-8"));
			KeyFactory fact = KeyFactory.getInstance("RSA");
			
			return fact.generatePublic(new X509EncodedKeySpec(keyByte));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Key stringToRsaPrivKey(String key) throws InvalidKeySpecException, NoSuchAlgorithmException{
		try {
			byte [] keyByte = Base64.decodeBase64(key.getBytes("UTF-8"));
			KeyFactory fact = KeyFactory.getInstance("RSA");
			
			return fact.generatePrivate(new PKCS8EncodedKeySpec(keyByte));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String RsaKeyToString(Key key){
		String result = Base64.encodeBase64URLSafeString(key.getEncoded());
		return result;
	}
	
	public static String generateCryptoString(int unencodedLength){
		Random cryptoRand = new SecureRandom();
		byte[] salt = new byte[unencodedLength];
		cryptoRand.nextBytes(salt);
		return Base64.encodeBase64URLSafeString(salt);
	}
	
	public static boolean checkUserAuthorizationProfileEditor(Integer usersId, Users zfgcUser){
		return zfgcUser.getHasRoles("ROLE_ZFGC_PROFILE_EDITOR") || usersId == zfgcUser.getUsersId();
	}
}
