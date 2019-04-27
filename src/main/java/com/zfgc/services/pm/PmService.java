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

import com.zfgc.constants.user.UserConstants;
import com.zfgc.dao.BrPmConversationUserInviteDao;
import com.zfgc.dataprovider.PersonalMessageDataProvider;
import com.zfgc.dataprovider.PmConversationDataProvider;
import com.zfgc.dataprovider.PmKeyDataProvider;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.exception.security.ZfgcInvalidAesKeyException;
import com.zfgc.exception.security.ZfgcSecurityException;
import com.zfgc.exception.security.ZfgcUnauthorizedException;
import com.zfgc.model.pm.BrPmConversationArchive;
import com.zfgc.model.pm.BrPmConversationUserInvite;
import com.zfgc.model.pm.BrUserConversation;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.model.pm.PmArchiveBoxView;
import com.zfgc.model.pm.PmBox;
import com.zfgc.model.pm.PmConversation;
import com.zfgc.model.pm.PmConversationMulti;
import com.zfgc.model.pm.PmConversationView;
import com.zfgc.model.pm.PmConvoBox;
import com.zfgc.model.pm.PmKey;
import com.zfgc.model.pm.PmPrune;
import com.zfgc.model.pm.PmTemplateConfig;
import com.zfgc.model.pm.PmUsersToAdd;
import com.zfgc.model.pm.TwoFactorKey;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.pm.PmPruneRequiredFields;
import com.zfgc.services.AbstractService;
import com.zfgc.services.authentication.AuthenticationService;
import com.zfgc.services.bbcode.BbcodeService;
import com.zfgc.services.sanitization.SanitizationService;
import com.zfgc.services.users.UsersService;
import com.zfgc.util.security.RsaKeyPair;
import com.zfgc.util.security.ZfgcSecurityUtils;
import com.zfgc.util.time.ZfgcTimeUtils;

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
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	PmPruneRequiredFields pmPruneRequiredFields;
	
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
	
	public PmConvoBox getConversationBox(TwoFactorKey aesKey, Users zfgcUser) throws ZfgcInvalidAesKeyException{
		aesKey.setUsersId(zfgcUser.getUsersId());
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(senderKeys.getParityWord());
		}
		
		try {
			List<PmConversationView> convoView = pmConversationDataProvider.getBoxViewByUsersId(zfgcUser);
			PmConvoBox convoBox = new  PmConvoBox();
			convoBox.setConversations(decryptAndPrepareConvoBox(convoView, senderKeys, aesKey));
			return convoBox;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PmConvoBox getConversationsSentBox(TwoFactorKey aesKey, Users zfgcUser) throws ZfgcInvalidAesKeyException{
		aesKey.setUsersId(zfgcUser.getUsersId());
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(senderKeys.getParityWord());
		}
		
		try {
			List<PmConversationView> convoView = pmConversationDataProvider.getSentBoxViewByUsersId(zfgcUser);
			PmConvoBox convoBox = new  PmConvoBox();
			convoBox.setConversations(decryptAndPrepareConvoBox(convoView, senderKeys, aesKey));
			return convoBox;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PmConvoBox getConversationsInBox(TwoFactorKey aesKey, Users zfgcUser) throws ZfgcInvalidAesKeyException{
		aesKey.setUsersId(zfgcUser.getUsersId());
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(senderKeys.getParityWord());
		}
		
		try {
			List<PmConversationView> convoView = pmConversationDataProvider.getInBoxViewByUsersId(zfgcUser);
			PmConvoBox convoBox = new  PmConvoBox();
			convoBox.setConversations(decryptAndPrepareConvoBox(convoView, senderKeys, aesKey));
			return convoBox;
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
	
	@Transactional
	public PmConversation sendMessageInConversation(Users user, List<Users> receivers, PersonalMessage message) throws ZfgcNotFoundException, RuntimeException{
		if(user.getUsersId() == null){
			throw new ZfgcNotFoundException();
		}

		sendMessage(user, message);
		
		if(!pmConversationDataProvider.isUserPartOfConvo(message.getPmConversationId(),user.getUsersId())){
			pmConversationDataProvider.addUserMappingToConvo(message.getPmConversationId(), user.getUsersId());
		}
		else{
			//set the convo to unread
			pmConversationDataProvider.setConvoToUnRead(message.getPmConversationId(), user.getUsersId());
		}
		
		for (Users receiver : receivers){
			//check if the user is in this convo already. if not, add them
			if(!pmConversationDataProvider.isUserPartOfConvo(message.getPmConversationId(),receiver.getUsersId())){
				pmConversationDataProvider.addUserMappingToConvo(message.getPmConversationId(), receiver.getUsersId());
			}
			else{
				//set the convo to unread
				pmConversationDataProvider.setConvoToUnRead(message.getPmConversationId(), receiver.getUsersId());
			}
		}
		
		PmConversation convo = new PmConversation();
		convo.setPmConversationId(message.getPmConversationId());
		
		return convo;
	}
	
	public String createInviteKey(Users user, Integer receiverId, TwoFactorKey aes){
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(user.getUsersId());
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(receiverId);
		String decryptedRsa = ZfgcSecurityUtils.decryptAes(senderKeys.getPmPrivKeyRsaEncrypted(), aes.getKey());
		
		Key receiverKey = null;
		try {
			receiverKey = ZfgcSecurityUtils.stringToRsaKey(receiverKeys.getPmPubKeyRsa());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			return null;
		}
		
		String senderKeyEncrypted = ZfgcSecurityUtils.encryptRsa(decryptedRsa, receiverKey);
		return senderKeyEncrypted;
	}
	
	@Transactional
	public PersonalMessage sendMessage(Users user, PersonalMessage message) throws RuntimeException{
		PmKey senderKeys = pmKeyDataProvider.getPmKeyByUsersId(user.getUsersId());
		
		Key senderKey = null;
		try {
			senderKey = ZfgcSecurityUtils.stringToRsaKey(senderKeys.getPmPubKeyRsa());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			return null;
		}
		
		message.setMessage(sanitizationService.sanitizeMessage(message.getMessage()));
		message.setSubject(sanitizationService.sanitizeMessage(message.getSubject()));
		message.setSenderId(user.getUsersId());
		
		if(message.getPmConversationId() == null){
			try{
				PmConversation convo = pmConversationDataProvider.createConversation(user.getUsersId());
				message.setPmConversationId(convo.getPmConversationId());
			}
			catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
			
		}
		
		PersonalMessage senderSave = (PersonalMessage)message.copy(message);

		senderSave.setSentDt(new Date());
		senderSave.setSendCopyFlag(true);
		
		try{
			pmDataProvider.saveMessage(senderSave);
		}
		catch(RuntimeException ex){
			ex.printStackTrace();
			throw ex;
		}
		
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
	
	public PersonalMessage getPmTemplate(PmTemplateConfig templateConfig){
		PersonalMessage pm = new PersonalMessage();
		
		if(templateConfig != null){
			pm.setReceivers(templateConfig.getReceivers());
			pm.setPmConversationId(templateConfig.getPmConversationId());
			pm.setSubject(templateConfig.getSubject());
		}
		
		return pm;
	}
	
	public PmConversation getConvoTemplate(Users user){
		PmConversation convo = new PmConversation();
		convo.setParticipants(new ArrayList<Users>());
		convo.setMessages(new ArrayList<PersonalMessage>());
		convo.setInitiatorId(user.getUsersId());
		convo.setStartDt(ZfgcTimeUtils.getToday());
		
		Users temp = new Users();
		temp.setDisplayName(user.getDisplayName());
		temp.setUsersId(user.getUsersId());
		convo.getParticipants().add(temp);
		
		PmTemplateConfig templateConfig = new PmTemplateConfig();
		templateConfig.setReceivers(convo.getParticipants());
		templateConfig.setSubject("");
		
		convo.getMessages().add(getPmTemplate(templateConfig));
		return convo;
	}
	
	public PmConvoBox getConvoBox(Users user){
		try {
			List<PmConversationView> convos = pmConversationDataProvider.getBoxViewByUsersId(user);
			
			PmConvoBox convoBox = new PmConvoBox();
			convoBox.setConversations(convos);
			
			return convoBox;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public PmConversation getConversation(Integer convoId, TwoFactorKey aesKey, Users user) throws ZfgcInvalidAesKeyException, RuntimeException {
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(user.getUsersId());
		aesKey.setUsersId(user.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		try {
			PmConversation convo = pmConversationDataProvider.getConversation(convoId);
			
			if(convo == null) {
				return null;
			}
			convo.setIsArchived(pmConversationDataProvider.isConvoArchived(convoId, user.getUsersId()));
			//make sure user belongs to this convo.  If not, check if they have an invite.
			if(!pmConversationDataProvider.isUserPartOfConvo(convoId, user.getUsersId()) && !convo.getIsArchived()){
				BrPmConversationUserInvite inviteCode = pmConversationDataProvider.getConvoInvite(convoId, user.getUsersId());
				if(inviteCode == null){
					throw new ZfgcNotFoundException("conversation Id" + convoId);
				}
				
				addUserToConvo(convoId, user, aesKey);
			}
			
			if(convo.getIsArchived()) {
				convo.setArchiveDt(pmConversationDataProvider.getArchivalDate(convoId, user.getUsersId()));
			}
			
			convo.setMessages(pmDataProvider.getMessagesByConversation(convo.getPmConversationId(), convo.getArchiveDt(), user));
			
			for(PersonalMessage pm : convo.getMessages()){
				pm.setMessage(bbCodeService.parseText(pm.getMessage()));
			}
			
			convo.setParticipants(usersService.getUsersByConversation(convoId));
			
			if(convo.getMessages().size() == 0) {
				return null;
			}
			
			//set the convo to read
			pmConversationDataProvider.setConvoToRead(convoId, user.getUsersId());
			
			return convo;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void removeConvoFromInbox(TwoFactorKey aesKey, PmConversation convo, Users zfgcUser) throws ZfgcInvalidAesKeyException, ZfgcNotFoundException, Exception{
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		aesKey.setUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		
		pmConversationDataProvider.deleteConversationFromBox(convo, zfgcUser);
	}
	
	public void removeUserFromConvo(TwoFactorKey aesKey, Integer convoId, Users remove, Users zfgcUser) throws ZfgcSecurityException, ZfgcNotFoundException, Exception{
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		aesKey.setUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		PmConversation convo = pmConversationDataProvider.getConversation(convoId);
		
		//verify that this user is the starting user
		if(convo.getInitiatorId() != zfgcUser.getUsersId()){
			throw new ZfgcUnauthorizedException();
		}
		
		//also verify that the user is not trying to remove themselves
		if(zfgcUser.getUsersId() == remove.getUsersId()){
			throw new ZfgcUnauthorizedException();
		}
		
		pmConversationDataProvider.deleteConversationFromBox(convo, remove);
	}
	
	@Transactional
	public void removeMultiConvoFromInbox(PmConversationMulti convos, Users zfgcUser)  throws ZfgcInvalidAesKeyException, RuntimeException{
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!checkIfAesKeyValid(convos.getAesKey(),zfgcUser)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		for(Integer convo : convos.getConvoIds()){
			PmConversation convoObj = new PmConversation();
			convoObj.setPmConversationId(convo);
			pmConversationDataProvider.deleteConversationFromBox(convoObj, zfgcUser);
		}
	}
	
	@Transactional
	public void moveMultiConversationToArchive(PmConversationMulti convos, Users zfgcUser)  throws ZfgcInvalidAesKeyException, RuntimeException{
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!checkIfAesKeyValid(convos.getAesKey(),zfgcUser)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		for(Integer convo : convos.getConvoIds()){
			BrPmConversationArchive archive = new BrPmConversationArchive();
			archive.setUsersId(zfgcUser.getUsersId());
			archive.setPmConversationId(convo);
			archive.setArchiveDt(new Date());
			
			//confirm that the convo exists
			//throws an exception if not
			pmConversationDataProvider.getConversation(convo);
			pmConversationDataProvider.addToArchive(archive);
			PmConversation convoObj = new PmConversation();
			convoObj.setPmConversationId(convo);
			pmConversationDataProvider.deleteConversationFromBox(convoObj, zfgcUser);
		}
	}
	
	@Transactional
	public void moveConversationToArchive(TwoFactorKey aesKey, Integer convoId, Users zfgcUser) throws ZfgcInvalidAesKeyException, RuntimeException{
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!checkIfAesKeyValid(aesKey,zfgcUser)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		BrPmConversationArchive archive = new BrPmConversationArchive();
		archive.setUsersId(zfgcUser.getUsersId());
		archive.setPmConversationId(convoId);
		archive.setArchiveDt(new Date());
		
		//confirm that the convo exists
		//throws an exception if not
		pmConversationDataProvider.getConversation(convoId);
	
		pmConversationDataProvider.addToArchive(archive);
	}
	
	@Transactional
	public PmConvoBox getArchiveBox(TwoFactorKey aesKey, Users zfgcUser) throws ZfgcInvalidAesKeyException, RuntimeException{
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!checkIfAesKeyValid(aesKey,zfgcUser)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		List<PmArchiveBoxView> archive = pmConversationDataProvider.getArchiveBox(zfgcUser);
		PmConvoBox archiveBox = new PmConvoBox();
		archiveBox.setConversations(new ArrayList<>());
		
		for(PmArchiveBoxView archived : archive){
			PmConversationView convo = mapper.map(archived, PmConversationView.class);
			convo.setArchived(true);
			
			archiveBox.getConversations().add(convo);
		}
		
		archiveBox.setConversations(decryptAndPrepareConvoBox(archiveBox.getConversations(), receiverKeys, aesKey));
		
		return archiveBox;
	}
	
	private boolean checkIfAesKeyValid(TwoFactorKey aesKey,Users zfgcUser) throws ZfgcInvalidAesKeyException{
		aesKey.setUsersId(zfgcUser.getUsersId());
		if(!authenticationService.isValidAesKey(aesKey)){
			return false;
		}
		
		return true;
	}
	
	public void pruneConversations(PmPrune prune, Users zfgcUser) throws Exception{
		PmKey receiverKeys = pmKeyDataProvider.getPmKeyByUsersId(zfgcUser.getUsersId());
		if(!checkIfAesKeyValid(prune.getTfa(),zfgcUser)){
			throw new ZfgcInvalidAesKeyException(receiverKeys.getParityWord());
		}
		
		try{
			pmPruneRequiredFields.requiredFieldsCheck(prune);
		}
		catch(ZfgcValidationException ex){
			throw ex;
		}
		
		List<Integer> pruneIds = pmConversationDataProvider.getConvosToBePruned(prune, zfgcUser);
		
		if(pruneIds.size() > 0){
			if(prune.getPruneFlag() == true){
				pmConversationDataProvider.bulkDeleteConversation(pruneIds, zfgcUser);
			}
			else{
				PmConversationMulti multi = new PmConversationMulti();
				multi.setAesKey(prune.getTfa());
				multi.setConvoIds(pruneIds);
				moveMultiConversationToArchive(multi, zfgcUser);
			}
		}
	}
	
	@Transactional
	public void inviteUsers(Integer conversationId, PmUsersToAdd pmUsers, Users user) throws RuntimeException{
		if(isConvoArchived(conversationId, user)){
			throw new ZfgcSecurityException("You are not authorized to invite users to this converation.");
		}
		
		Users zfgc = new Users();
		//todo: move this ID to a constants class
		zfgc.setUsersId(UserConstants.ZFGC_USER_ID);
		PmTemplateConfig pmTemplate = new PmTemplateConfig();
		pmTemplate.setPmConversationId(null);
		pmTemplate.setSubject(user.getDisplayName() + " has invited you to a conversation!");
		pmTemplate.setReceivers(pmUsers.getUsers());
		
		PersonalMessage pm = getPmTemplate(pmTemplate);
		pm.setMessage(user.getDisplayName() + " has invited you to their conversation! Click [url=http://zfgc.com:8080/forum/conversation/" + conversationId + "]here[/url] to join!");
		
		//create an invite code - using this user's private key and the receiving user's public key
		for(Users receiver : pmUsers.getUsers()){
			//check if the user already has an invite to this convo
			BrPmConversationUserInvite inviteCheck = pmConversationDataProvider.getConvoInvite(conversationId, receiver.getUsersId());
			if(inviteCheck != null){
				continue;
			}
			
			//String encryptedKey = createInviteKey(user,receiver.getUsersId(),pmUsers.getAesKey());
			String inviteCode = ZfgcSecurityUtils.generateMd5(ZfgcSecurityUtils.generateCryptoString(32));
			BrPmConversationUserInvite invite = new BrPmConversationUserInvite();
			invite.setInviteCode(inviteCode);
			invite.setDecryptor(null);
			invite.setUsersId(receiver.getUsersId());
			invite.setPmConversationId(conversationId);
			invite.setInviterId(user.getUsersId());
			
			pmConversationDataProvider.createInvite(invite);
		}
		
		try {
			sendMessageInConversation(zfgc,pmUsers.getUsers(),pm);
		} catch (ZfgcNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	private void addUserToConvo(Integer conversationId, Users user, TwoFactorKey aes) throws RuntimeException{
		//get the user's invite
		try {
			BrPmConversationUserInvite invite = pmConversationDataProvider.getConvoInvite(conversationId, user.getUsersId());
			
			//add an entry to the user to conversation mapping
			pmConversationDataProvider.addUserMappingToConvo(conversationId, user.getUsersId());
			
			//delete the invite
			pmConversationDataProvider.deleteInvite(invite);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Integer getUnreadPmCount(Users user) throws RuntimeException{
		return pmConversationDataProvider.countUnread(user.getUsersId());
	}
	
	private Boolean isConvoArchived(Integer pmConversationId, Users user) throws RuntimeException {
		return pmConversationDataProvider.isConvoArchived(pmConversationId, user.getUsersId());
	}
}
