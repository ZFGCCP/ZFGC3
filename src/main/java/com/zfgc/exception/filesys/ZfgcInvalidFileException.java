package com.zfgc.exception.filesys;

public class ZfgcInvalidFileException extends RuntimeException {

	
	private static final long serialVersionUID = -5072868047496039174L;
	private String fileName;
	private String reasonCode;
	private String[] allowedTypes;
	
	public static final String INVALID_FILE_NAME = "File name contained invalid characters.";
	public static final String INVALID_FILE_EXT =  "File type was invalid.";
	
	public ZfgcInvalidFileException(String fileName, String reasonCode){
		this.fileName = fileName;
		this.reasonCode = reasonCode;
	}
	
	public ZfgcInvalidFileException(String fileName, String reasonCode, String ... allowedTypes){
		this.allowedTypes = allowedTypes;
		this.fileName = fileName;
		this.reasonCode = reasonCode;
	} 
	
	@Override
	public String getMessage(){
		String result = "File " + fileName + " cannot be uploaded. ";
		
		if(reasonCode.equals(INVALID_FILE_NAME)){
			result += INVALID_FILE_NAME;
		}
		else if(reasonCode.equals(INVALID_FILE_EXT)){
			result += INVALID_FILE_EXT;
			
			if(allowedTypes != null && allowedTypes.length > 0){
				result += " Only ";
				for(int i = 0; i < allowedTypes.length; i++){
					String type = allowedTypes[i];
					result += type;
					
					if(i < i - 1){
						result += ", ";
					}
				}
				
				result += " are allowed.";
			}
		}
		
		return result;
	}
}
