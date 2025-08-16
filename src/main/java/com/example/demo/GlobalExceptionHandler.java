package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

@RestControllerAdvice // class should handle exceptions thrown by REST controllers, and returned value should be converted to JSON
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class) // whenever this exception is thrown(@NotNull or @Size), this method should run.
	public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		String errors = ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.joining(", "));
		return ResponseEntity.badRequest().body(errors);
	}

}

/* This class catches validation errors thrown anywhere in your controllers, 
extracts all the validation messages, combines them into a neat string, 
and returns that string in a 400 Bad Request response — so the client knows why the request failed. */
