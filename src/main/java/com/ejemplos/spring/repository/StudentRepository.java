package com.ejemplos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
