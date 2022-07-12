package com.ejemplos.spring.error.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super("User does not exist");
	}

	public UserNotFoundException(Long id) {
		super("User does not exist with id: " + id);
	}

}
