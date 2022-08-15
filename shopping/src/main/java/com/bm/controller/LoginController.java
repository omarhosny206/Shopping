package com.bm.controller;

import com.bm.entity.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
		return loginService.login(loginRequest);
	}
}
