package com.zfgc.exception.handlers;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zfgc.exception.ZfgcDataExistsException;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.exception.ZfgcValidationException;
import com.zfgc.exception.filesys.ZfgcInvalidFileException;
import com.zfgc.exception.security.ZfgcInvalidAesKeyException;
import com.zfgc.exception.security.ZfgcSecurityException;
import com.zfgc.exception.security.ZfgcUnauthorizedException;

@ControllerAdvice
public class RuntimeExceptionHandler {

	Logger LOGGER = LogManager.getLogger(RuntimeExceptionHandler.class);
	
	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity defaultErrorHandler(HttpServletRequest req, Exception e) {
		LOGGER.error("An unexpected error occured.", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occured. Please contact an administrator for assistance.");
	}
	
	@ExceptionHandler(value=ZfgcNotFoundException.class)
	public ResponseEntity zfgcNotFoundErrorHandler(HttpServletRequest req, Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(value=ZfgcDataExistsException.class)
	public ResponseEntity zfgcDataExistsErrorHandler(HttpServletRequest req, Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	@ExceptionHandler(value=ZfgcValidationException.class)
	public ResponseEntity zfgcValidationErrorHandler(HttpServletRequest req, ZfgcValidationException e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getErrors());
	}
	
	@ExceptionHandler(value=ZfgcInvalidAesKeyException.class)
	public ResponseEntity zfgcInvalidAesKeyErrorHandler(HttpServletRequest req, Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
	
	@ExceptionHandler(value=ZfgcSecurityException.class)
	public ResponseEntity zfgcSecurityErrorHandler(HttpServletRequest req, Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
	
	@ExceptionHandler(value=ZfgcUnauthorizedException.class)
	public ResponseEntity zfgcUnauthorizedErrorHandler(HttpServletRequest req, Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}
	
	@ExceptionHandler(value=AccessDeniedException.class)
	public ResponseEntity accessDeniedExceptionErrorHandler(HttpServletRequest req, Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}
	
	@ExceptionHandler(value=ZfgcInvalidFileException.class)
	public ResponseEntity zfgcInvalidFileErrorHandler(HttpServletRequest req, Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
	}
}
