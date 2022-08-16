package com.bm.controller;

import com.bm.entity.User;
import com.bm.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody User user) {
        return registrationService.register(user);
    }
}
