package com.bm.controller;

import com.bm.entity.User;
import com.bm.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Slf4j
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody User user) {
        log.info("Registering a new user with name={}", user.getName());
        return registrationService.register(user);
    }
}
