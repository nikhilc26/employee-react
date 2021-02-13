package com.employeerestapi.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.employeerestapi.errorresponse.ErrorResponse;
import com.employeerestapi.exception.NoDataFoundException;

import javassist.NotFoundException;

@ControllerAdvice
public class EmployeeRestControllerAdvice {
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(NotFoundException e,
			WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST", details);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoDataFoundException.class)
	public final ResponseEntity<ErrorResponse> handleNoDataFoundException(NoDataFoundException e, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST", details);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
