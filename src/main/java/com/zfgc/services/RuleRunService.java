package com.zfgc.services;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.BaseZfgcModel;
import com.zfgc.model.users.Users;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;
import com.zfgc.rules.AbstractRulesChecker;
import com.zfgc.validation.AbstractValidator;

@Component
public class RuleRunService<M extends BaseZfgcModel> {

	public void runRules(AbstractValidator<M> validator, AbstractRequiredFieldsChecker<M> reqFields, AbstractRulesChecker<M> rules, M model, Users user) throws ZfgcValidationException, RuntimeException{
		
		if(reqFields != null){
			reqFields.requiredFieldsCheck(model);
			
			if(model.getErrors().getRequiredFieldsErrors().size() > 0){
				throw new ZfgcValidationException(model.getClass().getName(), model.getErrors());
			}
		}
		
		if(validator != null){
			validator.validator(model);
			
			if(model.getErrors().getValidationErrors().size() > 0){
				throw new ZfgcValidationException(model.getClass().getName(), model.getErrors());
			}
		}
		
		if(rules != null){
			rules.rulesCheck(model, user);
			
			if(model.getErrors().getRuleErrors().size() > 0){
				throw new ZfgcValidationException(model.getClass().getName(), model.getErrors());
			}
		}
	}
}