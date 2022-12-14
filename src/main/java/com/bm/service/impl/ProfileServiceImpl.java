package com.bm.service.impl;

import com.bm.dto.UpdateRequest;
import com.bm.entity.User;
import com.bm.service.ProfileService;
import com.bm.service.UserService;
import com.bm.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public ProfileServiceImpl(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseEntity<?> update(UpdateRequest updateRequest, String header) {
        log.info("Trying to update user info");

        if(header == null || !header.startsWith("Bearer")) {
            log.error("Bad Request, empty or incorrect header");
            return new ResponseEntity<>(new ErrorMessage("Bad Request"), HttpStatus.BAD_REQUEST);
        }


        String jwt = header.substring(7);
        String email= jwtUtil.getUserName(jwt);
        User user = userService.getByEmail(email);

        if(user == null) {
            log.error("User not found");
            return new ResponseEntity<>(new ErrorMessage("Incorrect user"), HttpStatus.NOT_FOUND);
        }


        user.setName(updateRequest.getName());
        user.setPassword(passwordEncoder.encode(updateRequest.getPassword()));
        userService.save(user);

        log.info("User updated successfully");
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}
