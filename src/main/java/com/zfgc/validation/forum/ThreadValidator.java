package com.zfgc.validation.forum;

import org.springframework.stereotype.Component;

import com.zfgc.validation.AbstractValidator;
import com.zfgc.model.forum.Thread;

@Component
public class ThreadValidator extends AbstractValidator<Thread> {

	@Override
	public void validator(Thread model) throws RuntimeException {
		super.sanitizeString(model.getName());
		
		if(model.getName().length() > 128) {
			super.createError("THREAD_TITLE_LENGTH", "Thread subject cannot be more than 128 characters long.");
		}
		
		if(model.getTailPost().getHeadContent().getPostData().length() > 65535) {
			super.createError("BODY_LENGTH", "Post body cannot be more than 65535 characters long.");
		}
		
	}

}
