package com.microservice.exception.handler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservice.dto.APIError;
import com.microservice.exception.CurrencyNotValidExcpetipn;
import com.microservice.exception.OfferNotValidException;


@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler({OfferNotValidException.class, CurrencyNotValidExcpetipn.class})
	ResponseEntity<?> offerNotValidExcption(Exception ex, ServletWebRequest request)
	{
		APIError apiError = new APIError();
		
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setPathUri(request.getDescription(true));
		apiError.setErrors(Arrays.asList(ex.getClass() + ":"+ex.getMessage()));
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		APIError apiError = new APIError();
		
		List<FieldError> allErrors = ex.getBindingResult().getFieldErrors();
		
		List<String> feildErrors = allErrors.stream().map(err -> err.getField() + " : " + err.getDefaultMessage()).collect(Collectors.toList());
		
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setPathUri(request.getDescription(false));
		apiError.setTimestamp(LocalDateTime.now());
		
		apiError.setErrors(feildErrors);
		
		return new ResponseEntity(apiError, headers, apiError.getStatus());
	}
}
