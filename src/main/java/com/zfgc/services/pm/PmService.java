package com.zfgc.services.pm;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.dataprovider.PersonalMessageDataProvider;
import com.zfgc.dataprovider.PmConversationDataProvider;
import com.zfgc.dataprovider.PmKeyDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.security.ZfgcInvalidAesKeyException;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.pm.PmBox;
import com.zfgc.model.pm.PmConversation;
import com.zfgc.model.pm.PmConversationView;
import com.zfgc.model.pm.PmKey;
import com.zfgc.model.pm.TwoFactorKey;
import com.zfgc.model.users.Users;
import com.zfgc.services.AbstractService;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.bbcode.BbcodeService;
import com.zfgc.services.sanitization.SanitizationService;
import com.zfgc.services.users.UsersService;
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
	
	@Autowired
	BbcodeService bbCodeService;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	PmConversationDataProvider pmConversationDataProvider;
	
	private PmBox decryptPmBox(PmBox pmBox, PmKey keys, TwoFactorKey aesKey){
		String decryptedRsa = ZfgcSecurityUtils.decryptAes(keys.getPmPrivKeyRsaEncrypted(), aesKey.getKey());
		Key senderKey = null;
		
		try {
			senderKey = ZfgcSecurityUtils.stringToRsaPrivKey(decryptedRsa);
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
		for(PersonalMessage pm : pmBox.getMessageList()){
			pm.setSubject(ZfgcSecurityUtils.decryptRsa(pm.getSubject(), senderKey).trim());
			pm.setMessage(ZfgcSecurityUtils.decryptRsa(pm.getMessage(), senderKey).trim());
		}
		return pmBox;
	}
	
	public PmBox getOutbox(TwoFactorKey aesKey, Users zfgcUser) throws ZfgcInvalidAesKeyException{
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(senderKeys.getParityWord());
		}
		
		try {
			PmBox outbox = pmDataProvider.getOutbox(zfgcUser);
			return decryptPmBox(outbox, senderKeys, aesKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PmBox getInbox(TwoFactorKey aesKey, Users zfgcUser) throws ZfgcInvalidAesKeyException{
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(senderKeys.getParityWord());
		}
		
		try {
			PmBox inbox = pmDataProvider.getInbox(zfgcUser);
			return decryptPmBox(inbox, senderKeys, aesKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<PmConversationView> getConversationBox(TwoFactorKey aesKey, Users zfgcUser) throws ZfgcInvalidAesKeyException{
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(senderKeys.getParityWord());
		}
		
		try {
			List<PmConversationView> convoView = pmConversationDataProvider.getBoxViewByUsersId(zfgcUser.getUsersId());
			return decryptAndPrepareConvoBox(convoView, senderKeys, aesKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<PmConversationView> decryptAndPrepareConvoBox(List<PmConversationView> convoView, PmKey key, TwoFactorKey tfa){
		List<PmConversationView> result = new ArrayList<>();
		
		String decryptedRsa = ZfgcSecurityUtils.decryptAes(key.getPmPrivKeyRsaEncrypted(), tfa.getKey());
		Key senderKey = null;
		
		try {
			senderKey = ZfgcSecurityUtils.stringToRsaPrivKey(decryptedRsa);
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		for(PmConversationView view : convoView){
			view.setMessage(ZfgcSecurityUtils.decryptRsa(view.getMessage(), senderKey).trim());
			view.setSubject(ZfgcSecurityUtils.decryptRsa(view.getSubject(), senderKey).trim());

			try {
				view.setMessage(bbCodeService.parseText(view.getMessage()));
			} catch (NoSuchFieldException | SecurityException
					| IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
			
			result.add(view);
		}
		
		return result;
	}
	
	//todo: add user instead of receiverId
	public PersonalMessage openMessage(Integer pmId, Integer receiverId, TwoFactorKey aesKey) throws ZfgcNotFoundException, ZfgcInvalidAesKeyException{
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(receiverId);
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		try {
			PersonalMessage pm = pmDataProvider.getInboxMessage(pmId);
			PersonalMessage pmCopy = (PersonalMessage)pm.copy(pm);
			pmCopy.setReadFlag(true);
			
			String decryptedRsa = ZfgcSecurityUtils.decryptAes(receiverKeys.getPmPrivKeyRsaEncrypted(), aesKey.getKey());
			Key receiverKey = null;
			
			try {
				receiverKey = ZfgcSecurityUtils.stringToRsaPrivKey(decryptedRsa);
			} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
				e.printStackTrace();
				return null;
			}
			
			pm.setMessage(ZfgcSecurityUtils.decryptRsa(pm.getMessage(), receiverKey).trim());
			try {
				pm.setMessage(bbCodeService.parseText(pm.getMessage()));
			} catch (NoSuchFieldException | SecurityException
					| IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
			
			pm.setSubject(ZfgcSecurityUtils.decryptRsa(pm.getSubject(), receiverKey).trim());
			
			pmDataProvider.saveMessage(pmCopy);
			
			return pm;
			
		} catch (ZfgcNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void sendMessageInConversation(Users user, List<Users> receivers, PersonalMessage message) throws ZfgcNotFoundException{
		if(user.getUsersId() == null){
			throw new ZfgcNotFoundException();
		}
		
		for(Users receiver : receivers){
			sendMessage(user, receiver.getUsersId(), message);
		}
	}
	
	@Transactional
	public PersonalMessage sendMessage(Users user, Integer receiverId, PersonalMessage message){
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(user.getUsersId());
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(receiverId);
		
		Key senderKey = null;
		Key receiverKey = null;
		try {
			senderKey = ZfgcSecurityUtils.stringToRsaKey(senderKeys.getPmPubKeyRsa());
			receiverKey = ZfgcSecurityUtils.stringToRsaKey(receiverKeys.getPmPubKeyRsa());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			return null;
		}
		
		message.setMessage(sanitizationService.sanitizeMessage(message.getMessage()));
		message.setSubject(sanitizationService.sanitizeMessage(message.getSubject()));
		
		if(message.getPmConversationId() == null){
			PmConversation convo = pmConversationDataProvider.createConversation(user.getUsersId());
			message.setPmConversationId(convo.getPmConversationId());
		}
		
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
		pmKey.setParityWord(ZfgcSecurityUtils.encryptAes(authenticationService.PM_PARITY_WORD, aesKey));
		
		pmKeyDataProvider.createPmKeyPair(pmKey);
	}
	
	public PersonalMessage getPmTemplate(){
		return new PersonalMessage();
	}
}
