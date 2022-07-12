package com.ejemplos.spring.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.converter.StudentConverter;
import com.ejemplos.spring.dto.StudentDTO;
import com.ejemplos.spring.model.Student;
import com.ejemplos.spring.service.StudentService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentConverter studentConverter;
	
	@Autowired
	private  StudentService studentService;

	@GetMapping
	public Collection<Student> getAllStudents() {
		log.info("------ getAllStudents() -> " + studentService.findAll());
		return studentService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
		log.info("------ student by id: " + id);
		Optional<Student> studentData = studentService.findById(id);
		if (!studentData.isEmpty()) {
		      return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	}

	@PostMapping
	public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDto) {
		return new ResponseEntity<>(studentService.save(studentDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentDTO> updateStudent(
			@PathVariable("id") long id,
			@RequestBody StudentDTO newStudentDTO) {
		Optional<Student> studentData = studentService.findById(id);

		if (!studentData.isEmpty()) {
			Student newStudent = studentData.get();
			newStudent.setFirstName(newStudentDTO.getFirstName());
			newStudent.setLastName(newStudentDTO.getLastName());
			newStudent.setEmail(newStudentDTO.getEmail());
			return new ResponseEntity<>(studentService.save(studentConverter.convertEntityToDto(newStudent)),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteById(id);
	}
}
