package com.bm.service;

import com.bm.dto.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<?> login(LoginRequest loginRequest) throws Exception;
}
