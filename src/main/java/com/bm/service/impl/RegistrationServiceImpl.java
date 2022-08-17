package com.bm.service.impl;

import com.bm.entity.User;
import com.bm.exception.ErrorResponse;
import com.bm.exception.Errors;

import com.bm.service.RegistrationService;
import com.bm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<?> register(User user) {
        log.info("Trying to register a new user");
    	User possibleUser = userService.getByEmail(user.getEmail());
    	
    	if(possibleUser != null) {
            log.error("This email is already taken");
    		return new ResponseEntity<>(new ErrorResponse(Errors.EmailNotUnique.getErrorMessage()), HttpStatus.BAD_REQUEST);
    	}

        log.info("User registered successfully");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return new ResponseEntity<>("Registered Successfully", HttpStatus.OK);
    }
}
