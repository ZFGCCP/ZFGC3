package com.zfgc.exception;

public class ZfgcDataExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String field = null;
	
	public ZfgcDataExistsException(String field){
		this.field = field;
	}
	
	@Override
	public String getMessage(){
		return "Data already exists in database: " + field;
	}
}