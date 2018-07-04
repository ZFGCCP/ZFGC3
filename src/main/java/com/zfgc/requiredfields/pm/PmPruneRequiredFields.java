package com.zfgc.requiredfields.pm;

import org.springframework.stereotype.Component;

import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.model.pm.PmPrune;
import com.zfgc.requiredfields.AbstractRequiredFieldsChecker;
import com.zfgc.requiredfields.RequiredField;

@Component
public class PmPruneRequiredFields  extends AbstractRequiredFieldsChecker<PmPrune>{

	@Override
	public void requiredFieldsCheck(PmPrune model) throws ZfgcValidationException {
		RequiredField olderThan = super.checkRequiredFieldOr(model.getOlderThanDt(), "Older Than", "At least one field is required", model.getErrors().getRequiredFieldsErrors());
		RequiredField inactive = super.checkRequiredFieldOr(model.getInactiveForDt(), "Inactive Longer Than",  "At least one field is required", model.getErrors().getRequiredFieldsErrors());
		RequiredField byUser = super.checkRequiredFieldOr(model.getDeleteStartedUserId(), "Delete by Starting User",  "At least one field is required", model.getErrors().getRequiredFieldsErrors());
		RequiredField startedByMe = super.checkRequiredFieldBooleanOr(model.getStartedByMeFlag(), "Started By Me",  "At least one field is required", model.getErrors().getRequiredFieldsErrors());
		
		or( model.getErrors().getRequiredFieldsErrors(),olderThan,inactive,byUser,startedByMe);
		
		super.checkErrorsFound("PmPrune", model);
	}
	
}