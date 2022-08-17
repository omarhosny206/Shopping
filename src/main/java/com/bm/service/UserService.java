package com.bm.service;

import com.bm.dto.LoginResponse;
import com.bm.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void save(User user);

    void update(User user);

    User getById(Long id);

    LoginResponse getByEmailAndPassword(String email, String password);

    User getByEmail(String email);
}
