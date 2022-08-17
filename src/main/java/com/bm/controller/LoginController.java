package com.bm.controller;

import com.bm.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bm.service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class LoginController {
	private final LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
		return loginService.login(loginRequest);
	}
}
