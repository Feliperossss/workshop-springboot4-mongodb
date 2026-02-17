package com.felipealb.workshopmongo.resource.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipealb.workshopmongo.service.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound( ObjectNotFoundException e, HttpServletRequest request){
		StandartError error = new StandartError(Instant.now(),HttpStatus.NOT_FOUND.value(),e.getMessage(),"object not found", request.getRequestURI() );
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
