package com.sms.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	//handler method for handling specific exception
	//?=not sure abut the class
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFound ex,WebRequest request)
	{
		Errordetails errors =new Errordetails(new Date(),ex.getMessage(),request.getDescription(false));
																				//false=short description
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		
	}
}
