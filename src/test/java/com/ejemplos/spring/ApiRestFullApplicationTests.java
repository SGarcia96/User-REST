package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.UserController;
import com.ejemplos.spring.service.UserService;

@SpringBootTest
class ApiRestFullApplicationTests {

	@Autowired
	private UserController controller;

	@Autowired
	private UserService service;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
	}
}
