package com.capgemini.admission.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> objectBody = new LinkedHashMap<>();
		objectBody.put("Timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
		objectBody.put("errorCode", status.value());
		List<String> exceptions = ex.getBindingResult().getFieldErrors().stream().map(m -> m.getDefaultMessage())
				.collect(Collectors.toList());
		objectBody.put("errorMessages", exceptions);

		return new ResponseEntity<Object>(objectBody, status);
	}
	@ExceptionHandler(CollegeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(CollegeNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}
	@ExceptionHandler(UniversityNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(UniversityNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}
	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(BranchNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(CourseNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(ApplicationNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(PaymentNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(UserNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}
	
	
	
	
}

