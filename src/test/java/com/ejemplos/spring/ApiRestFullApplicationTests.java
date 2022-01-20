package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.StudentController;

@SpringBootTest
class ApiRestFullApplicationTests {

	@Autowired
	private StudentController controller;

	@Test
	void contextLoads() {
		assertThat(true).isTrue();
	}

	@Test
	void controllerNotNull() {
		assertThat(controller).isNotNull();
	}

}
