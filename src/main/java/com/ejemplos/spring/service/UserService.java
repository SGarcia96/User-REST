package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ejemplos.spring.dto.UserDTO;
import com.ejemplos.spring.model.User;

@Service
public interface UserService {

	public List<User> findAll();

	public Optional<User> findById(Long id);

	public UserDTO save(UserDTO user);

	public void deleteById(long id);

}
