package com.fatec.estacionamentotcc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fatec.estacionamentotcc.services.exceptions.ObjNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjNotFoundException.class)
	public ResponseEntity<StandardError> objectNotfound(ObjNotFoundException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}