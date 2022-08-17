package com.bm.service.impl;

import com.bm.dto.LoginResponse;
import com.bm.dto.CustomUserDetails;
import com.bm.entity.User;
import com.bm.repository.UserRepository;
import com.bm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        log.info("Saving a user with name={}", user.getName());
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        log.info("Updating a user");
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        log.info("Getting user with id={}", id);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public LoginResponse getByEmailAndPassword(String email, String password) {
        log.info("Getting user by email and password");
        User user = userRepository.findByEmailAndPassword(email, password);

        if (user == null) {
            log.error("User not found");
            return null;
        }

        log.error("User found");
        LoginResponse loginResponse = new LoginResponse();
        BeanUtils.copyProperties(user, loginResponse);
        return loginResponse;
    }

    @Override
    public User getByEmail(String email) {
        log.info("Getting user with email={}", email);
        return userRepository.findByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Loading user");
        User user = getByEmail(email);
        return new CustomUserDetails(user);
    }
}
