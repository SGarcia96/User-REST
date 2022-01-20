package com.ejemplos.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException() {
		super("Epic Fail: No existe el estudiante");
		action1();
	}
	public StudentNotFoundException(Long id) {
		super("Epic Fail: No existe el estudiante "+id);
	}	
	public void action1() {
		
	}
}
