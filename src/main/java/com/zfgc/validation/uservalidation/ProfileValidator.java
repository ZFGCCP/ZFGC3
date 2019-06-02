package com.zfgc.validation.uservalidation;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.zfgc.model.users.Users;
import com.zfgc.model.users.profile.UserProfileView;
import com.zfgc.validation.AbstractValidator;

@Component
public class ProfileValidator extends AbstractValidator<UserProfileView>{

	private final int CUSTOM_TITLE_LEN = 64;
	private final int PERSONAL_TEXT_LEN = 64;
	private final int LOCATION_LEN = 32;
	private final int WEBSITE_LEN = 32;
	private final int WEBSITE_URL_LEN = 64;
	
	@Override
	public void validator(UserProfileView model) throws RuntimeException {
		if(!StringUtils.isEmpty(model.getPersonalInfo().getCustomTitle())){
			if(model.getPersonalInfo().getCustomTitle().length() > CUSTOM_TITLE_LEN){
				model.getErrors().getValidationErrors().add(super.createError("STRING_TOO_LONG", "Custome Title cannot be more than " + CUSTOM_TITLE_LEN + " characters."));
			}
			
			super.checkStringFormatAllowBlank(model, model.getPersonalInfo().getCustomTitle(), "Custom Title");
		}
		
		if(!StringUtils.isEmpty(model.getPersonalInfo().getPersonalText())){
			if(model.getPersonalInfo().getPersonalText().length() > PERSONAL_TEXT_LEN){
				model.getErrors().getValidationErrors().add(super.createError("STRING_TOO_LONG", "Personal Text cannot be more than " + PERSONAL_TEXT_LEN + " characters."));
			}
			
			super.checkStringFormatAllowBlank(model, model.getPersonalInfo().getPersonalText(), "Personal Text");
		}
		
		if(!StringUtils.isEmpty(model.getPersonalInfo().getLocation())){
			if(model.getPersonalInfo().getLocation().length() > LOCATION_LEN){
				model.getErrors().getValidationErrors().add(super.createError("STRING_TOO_LONG", "Location cannot be more than " + LOCATION_LEN + " characters."));
			}
			
			super.checkStringFormatAllowBlank(model, model.getPersonalInfo().getLocation(), "Location");
		}
		
		if(!StringUtils.isEmpty(model.getPersonalInfo().getWebsiteTitle())){
			if(model.getPersonalInfo().getWebsiteTitle().length() > WEBSITE_LEN){
				model.getErrors().getValidationErrors().add(super.createError("STRING_TOO_LONG", "Website Title cannot be more than " + WEBSITE_LEN + " characters."));
			}
			
			super.checkStringFormatAllowBlank(model, model.getPersonalInfo().getLocation(), "Website Title");
		}
		
		if(!StringUtils.isEmpty(model.getPersonalInfo().getWebsiteUrl())){
			if(model.getPersonalInfo().getWebsiteUrl().length() > WEBSITE_URL_LEN){
				model.getErrors().getValidationErrors().add(super.createError("STRING_TOO_LONG", "Website URL cannot be more than " + WEBSITE_URL_LEN + " characters."));
			}
			
			super.checkUrlFormat(model, model.getPersonalInfo().getWebsiteUrl(), true);
		}
		
	}
	
}