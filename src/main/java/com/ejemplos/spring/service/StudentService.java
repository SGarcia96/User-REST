package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Student;

@Service
public interface StudentService {

	// Return all students
	public List<Student> findAll();

	// Find the student with this id
	public Optional<Student> findById(int id);

	// Save a new student & update
	public Student save(Student student);

	// Delete student with this id
	public void deleteById(int id);
	
	public List<Student> findAllByYear(int anyo);

}
