package com.bm.service;

import com.bm.entity.User;
import com.bm.exception.ErrorResponse;
import com.bm.exception.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<?> register(User user) {
    	User possibleUser = userService.getByEmail(user.getEmail());
    	
    	if(possibleUser != null) {
    		return new ResponseEntity<>(new ErrorResponse(Errors.EmailNotUnique.getErrorMessage()), HttpStatus.BAD_REQUEST);
    	}
    	
        userService.save(user);
        
        return new ResponseEntity<>("Registered Successfully", HttpStatus.OK);
    }
}
