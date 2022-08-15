package com.bm.service;

import com.bm.dto.UserDto;
import org.springframework.stereotype.Service;

import com.bm.entity.User;

@Service
public class LoginService {
	private final UserService userService;

	public LoginService(UserService userService) {
		this.userService = userService;
	}

	public UserDto getByEmailAndPassword(String email, String password) {
		return userService.getByEmailAndPassword(email, password);
	}
}
