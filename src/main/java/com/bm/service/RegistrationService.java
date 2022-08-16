package com.bm.service;

import com.bm.entity.User;
import com.bm.exception.ErrorResponse;
import com.bm.exception.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> register(User user) {
    	User possibleUser = userService.getByEmail(user.getEmail());
    	
    	if(possibleUser != null) {
    		return new ResponseEntity<>(new ErrorResponse(Errors.EmailNotUnique.getErrorMessage()), HttpStatus.BAD_REQUEST);
    	}

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return new ResponseEntity<>("Registered Successfully", HttpStatus.OK);
    }
}
