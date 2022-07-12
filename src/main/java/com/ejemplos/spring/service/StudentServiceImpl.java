package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.controller.StudentNotFoundException;
import com.ejemplos.spring.converter.StudentConverter;
import com.ejemplos.spring.dto.StudentDTO;
import com.ejemplos.spring.model.Student;
import com.ejemplos.spring.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentConverter studentConverter;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {
		Optional<Student> studentData = studentRepository.findById(id);
		if (studentData.isPresent()) {
			return studentData;
		} else {
			return Optional.empty();
		}
	}

	@Override
	public StudentDTO save(StudentDTO studentDTO) {
		Student student = studentConverter.convertDtoToEntity(studentDTO);
		student = studentRepository.save(student);
		return studentConverter.convertEntityToDto(student);
	}

	@Override
	public void deleteById(long id) {
		studentRepository.deleteById(id);
	}

}
