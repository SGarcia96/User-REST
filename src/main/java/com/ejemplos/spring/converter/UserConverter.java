package com.ejemplos.spring.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.spring.dto.UserDTO;
import com.ejemplos.spring.model.User;

@Component
public class UserConverter {
	
	@Autowired
	ModelMapper modelMapper;

	public UserDTO convertEntityToDto(User user) {
		return modelMapper.map(user, UserDTO.class);
	}
	
	public User convertDtoToEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}
}
