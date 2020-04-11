package com.shin.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;

import com.shin.domain.ApiResult;
import com.shin.exception.ServiceException;
import com.shin.utils.MessageUtils;

/**
 * Global Exception Advice in Main Application
 * treats only @RestController
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionRestControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handlerCommonException(Exception e) {
		log.error(e.getMessage());
		return new ResponseEntity<>(
				ApiResult.with(null)
						.statusCode(ApiResult.StatusCode.SERVER_ERROR)
						.message(MessageUtils.getMessage("common.error") + "\nInternal Server Error")
				, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity handleServiceException(ServiceException se) {
		log.error(se.getMessage());
		return new ResponseEntity<>(
				ApiResult.with(null)
						.statusCode((se.getStatusCode() == null) ? ApiResult.StatusCode.SERVER_ERROR : se.getStatusCode())
						.message(MessageUtils.getMessage(se.getMessage(), se.getMessageArgs()))
				, HttpStatus.OK);
	}
}
