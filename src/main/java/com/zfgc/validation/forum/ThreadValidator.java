package com.zfgc.validation.forum;

import org.springframework.stereotype.Component;

import com.zfgc.validation.AbstractValidator;
import com.zfgc.model.forum.Thread;

@Component
public class ThreadValidator extends AbstractValidator<Thread> {

	@Override
	public void validator(Thread model) throws RuntimeException {
		super.sanitizeString(model.getTitle());
		
		if(model.getTitle().length() > 128) {
			super.createError("THREAD_TITLE_LENGTH", "Thread subject cannot be more than 128 characters long.");
		}
		
	}

}
