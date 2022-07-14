package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.converter.UserConverter;
import com.ejemplos.spring.dto.UserDTO;
import com.ejemplos.spring.error.custom.UserNotFoundException;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserConverter userConverter;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return Optional.of(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = userConverter.convertDtoToEntity(userDTO);
		user = userRepository.save(user);
		return userConverter.convertEntityToDto(user);
	}

	@Override
	public void deleteById(long id) {
		Optional<User> userToDelete = Optional.of(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
		userRepository.deleteById(userToDelete.get().getId());
	}
}
