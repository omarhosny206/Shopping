package com.bm.service;

import com.bm.entity.User;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {
    ResponseEntity<?> register(User user);
}
