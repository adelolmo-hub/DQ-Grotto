package app.dqproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import app.dqproject.models.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleException(Exception exception){
		return new ResponseEntity<>(new ApiError(exception.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ApiError> handleException(EntityNotFoundException exception){
		return new ResponseEntity<>(new ApiError(exception.getMessage()),HttpStatus.NOT_FOUND); 
	}
}
