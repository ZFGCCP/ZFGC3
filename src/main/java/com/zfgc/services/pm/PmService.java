package com.zfgc.services.pm;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dataprovider.PersonalMessageDataProvider;
import com.zfgc.dataprovider.PmKeyDataProvider;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.pm.PmKey;
import com.zfgc.services.AbstractService;
import com.zfgc.services.sanitization.SanitizationService;
import com.zfgc.util.security.RsaKeyPair;
import com.zfgc.util.security.ZfgcSecurityUtils;

@Component
public class PmService extends AbstractService {

	@Autowired
	PmKeyDataProvider pmKeyDataProvider;
	
	@Autowired
	PersonalMessageDataProvider pmDataProvider;
	
	@Autowired
	SanitizationService sanitizationService;
	
	//todo: make this take a user instead of a senderId
	public PersonalMessage sendMessage(Integer senderId, Integer receiverId, PersonalMessage message){
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(senderId);
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(receiverId);
		
		Key senderKey = null;
		Key receiverKey = null;
		try {
			senderKey = ZfgcSecurityUtils.stringToRsaKey(senderKeys.getPmPubKeyRsa());
			receiverKey = ZfgcSecurityUtils.stringToRsaKey(receiverKeys.getPmPubKeyRsa());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		message.setMessage(sanitizationService.sanitizeMessage(message.getMessage()));
		message.setSubject(sanitizationService.sanitizeMessage(message.getSubject()));
		
		PersonalMessage senderSave = (PersonalMessage)message.copy(message);
		PersonalMessage receiverSave = (PersonalMessage)message.copy(message);
		
		String senderMsg = ZfgcSecurityUtils.encryptRsa(message.getMessage(), senderKey);
		String receiverMsg = ZfgcSecurityUtils.encryptRsa(message.getMessage(), receiverKey);
		String senderSubject = ZfgcSecurityUtils.encryptRsa(message.getSubject(), senderKey);
		String receiverSubject = ZfgcSecurityUtils.encryptRsa(message.getSubject(), receiverKey);
		
		senderSave.setMessage(senderMsg);
		senderSave.setSubject(senderSubject);
		receiverSave.setMessage(receiverMsg);
		receiverSave.setSubject(receiverSubject);
		senderSave.setSentDt(new Date());
		receiverSave.setSentDt(new Date());
		senderSave.setSendCopyFlag(true);
		
		pmDataProvider.saveMessage(senderSave);
		pmDataProvider.saveMessage(receiverSave);
		
		return message;
		
	}
	
	public void createKeyPairs(Integer usersId, String passPhrase){
		SecretKeySpec aesKey = ZfgcSecurityUtils.generateAesKey(passPhrase);
		RsaKeyPair keyPair = ZfgcSecurityUtils.generateRsaPair();
		
		String privateKey = ZfgcSecurityUtils.RsaKeyToString(keyPair.getPrivateKey());
		String privateKeyEnc = ZfgcSecurityUtils.encryptAes(privateKey, aesKey);
		
		PmKey pmKey = new PmKey();
		pmKey.setPmKeyId(null);
		pmKey.setPmPrivKeyRsaEncrypted(privateKeyEnc);
		pmKey.setPmPubKeyRsa(ZfgcSecurityUtils.RsaKeyToString(keyPair.getPublicKey()));
		pmKey.setUsersId(usersId);
		
		pmKeyDataProvider.createPmKeyPair(pmKey);
	}
	
}
