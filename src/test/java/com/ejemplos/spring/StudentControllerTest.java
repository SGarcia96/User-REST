package com.ejemplos.spring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ejemplos.spring.service.StudentService;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThan;

public class StudentControllerTest {

	@MockBean
	StudentService studentService;

	@BeforeAll
	public static void setup() {
		baseURI = "http://localhost:8080/";
		port = 8080;
	}

	@Test
	public void shouldGetAllStudentsWithStatus200() {
		given()
			.get("/students")
		.then()
			.statusCode(200)
			.assertThat()
			.body("size()", greaterThan(0));
	}

	@Test
	@Disabled
	public void postTest() {
	}

	@Test
	@Disabled
	public void putTest() {
	}

	@Test
	@Disabled
	public void delete() {
	}

}
