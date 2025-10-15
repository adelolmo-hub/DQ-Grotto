package app.dqproject.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
		 Map<String, String> errors = new HashMap<>();
		 ex.getBindingResult().getFieldErrors()
		 .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		 return ResponseEntity.badRequest().body(errors);
	}
}
