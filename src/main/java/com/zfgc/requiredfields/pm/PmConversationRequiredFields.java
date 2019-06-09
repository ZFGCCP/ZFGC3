package com.zfgc.requiredfields.pm;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.pm.PersonalMessage;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;

@Component
public class PmConversationRequiredFields extends AbstractRequiredFieldsChecker<PersonalMessage>{

	@Override
	public void requiredFieldsCheck(PersonalMessage model) throws ZfgcValidationException {
		checkRequiredFieldString(model.getSubject(), "subject", "Subject" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
		checkRequiredFieldString(model.getMessage(), "message", "Message" + IS_REQUIRED_FIELD, model.getErrors().getRequiredFieldsErrors());
	}
	
}