package com.filipe.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.filipe.cursomc.services.exceptions.ObjectNotFoundExceptions;



@ControllerAdvice
public class ResourceExceptionsHandler {
	
	@ExceptionHandler(ObjectNotFoundExceptions.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExceptions e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
