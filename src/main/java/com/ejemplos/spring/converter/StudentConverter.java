package com.ejemplos.spring.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.spring.dto.StudentDTO;
import com.ejemplos.spring.model.Student;

@Component
public class StudentConverter {
	
	@Autowired
	ModelMapper modelMapper;

	public StudentDTO convertEntityToDto(Student student) {
		return modelMapper.map(student, StudentDTO.class);
	}
	
	public Student convertDtoToEntity(StudentDTO studentDTO) {
		return modelMapper.map(studentDTO, Student.class);
	}
}
