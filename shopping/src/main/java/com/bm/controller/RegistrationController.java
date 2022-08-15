package com.bm.controller;

import com.bm.entity.User;
import com.bm.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping("/")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok(registrationService.register(user));
    }
}
