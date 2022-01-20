package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Student;
import com.ejemplos.spring.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findById(int id) {
		return studentRepository.findById(id);
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> findAllByYear(int anyo) {
		return studentRepository.findAllByYear(anyo);
	}

}
