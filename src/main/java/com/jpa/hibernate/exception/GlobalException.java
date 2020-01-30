package com.jpa.hibernate.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.jpa.hibernate.entity.ErrorDetails;



@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
