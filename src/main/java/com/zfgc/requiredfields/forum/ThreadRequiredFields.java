package com.zfgc.requiredfields.forum;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.forum.Thread;

import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;

@Component
public class ThreadRequiredFields extends AbstractRequiredFieldsChecker<Thread> {

	@Override
	public void requiredFieldsCheck(Thread model) throws ZfgcValidationException {
		checkRequiredFieldString(model.getName(), "Subject","Subject is a required field",model.getErrors().getRequiredFieldsErrors());
		checkRequiredFieldString(model.getTailPost().getHeadContent().getPostData(), "Body", "Post body is a required field",model.getErrors().getRequiredFieldsErrors());
		
	}

}
