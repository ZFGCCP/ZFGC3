package com.zfgc.validation;

public abstract class AbstractValidator<T> {
	public abstract void validator(T model) throws Exception;
}
