package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.StudentController;
import com.ejemplos.spring.service.StudentService;

@SpringBootTest
class ApiRestFullApplicationTests {

	@Autowired
	private StudentController controller;

	@Autowired
	private StudentService service;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
	}
}
