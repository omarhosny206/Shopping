package com.bm.controller;

import com.bm.dto.UserDto;
import com.bm.entity.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bm.entity.User;
import com.bm.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> getByEmailAndPassword(@RequestBody LoginRequest loginRequest) {
		UserDto userDto = loginService.getByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());

		if (userDto != null) {
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
