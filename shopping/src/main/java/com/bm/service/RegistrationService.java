package com.bm.service;

import com.bm.entity.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public String register(User user) {
        userService.save(user);
        return "Registered successfully";
    }
}
