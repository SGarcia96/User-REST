package com.ejemplos.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException() {
		super("Student does not exist");
	}

	public StudentNotFoundException(Long id) {
		super("Student does not exist " + id);
	}

}
