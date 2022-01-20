package com.ejemplos.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Student", description = "Student Class")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(name = "id", description = "Identificador único para el estudiante", example = "42", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 0, max = 30)
	@NotEmpty
	private String first_name;
	@NotEmpty
	private String last_name;
	@NotEmpty
	private String year;

}
