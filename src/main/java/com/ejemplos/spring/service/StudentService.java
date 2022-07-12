package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ejemplos.spring.dto.StudentDTO;
import com.ejemplos.spring.model.Student;

@Service
public interface StudentService {

	public List<Student> findAll();

	public Optional<Student> findById(Long id);

	public StudentDTO save(StudentDTO student);

	public void deleteById(long id);

}
