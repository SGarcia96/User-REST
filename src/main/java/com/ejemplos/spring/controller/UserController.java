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

import com.ejemplos.spring.converter.UserConverter;
import com.ejemplos.spring.dto.UserDTO;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private UserService userService;

	@GetMapping
	public Collection<User> getAllUsers() {
		log.info("------ getAllUsers() -> " + userService.findAll());
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		log.info("------ getUserById " + id + " -> " + userService.findById(id));
		Optional<User> userData = userService.findById(id);
		if (!userData.isEmpty()) {
		      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	}

	@PostMapping
	public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDto) {
		log.info("------ addUser -> " + userDto);
		return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(
			@PathVariable("id") long id,
			@RequestBody UserDTO newUserDTO) {
		log.info("------ updateUser -> " + newUserDTO);
		Optional<User> userData = userService.findById(id);

		if (!userData.isEmpty()) {
			User newUser = userData.get();
			newUser.setFirstName(newUserDTO.getFirstName());
			newUser.setLastName(newUserDTO.getLastName());
			newUser.setEmail(newUserDTO.getEmail());
			return new ResponseEntity<>(userService.save(userConverter.convertEntityToDto(newUser)),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		log.info("------ deleteUser -> " + userService.findById(id));
		userService.deleteById(id);
	}
}
