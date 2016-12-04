package com.zfgc.rules;

import com.zfgc.model.BaseZfgcModel;


public abstract class AbstractRulesChecker<T extends BaseZfgcModel> {
	public abstract void rulesCheck(T model) throws Exception;
	
}
