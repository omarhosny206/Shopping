package com.bm.service;

import com.bm.entity.UpdateRequest;
import com.bm.entity.User;
import com.bm.util.JwtUtil;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public ProfileService(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }


    public ResponseEntity<?> update(UpdateRequest updateRequest, String header) {
        if(header == null || !header.startsWith("Bearer"))
            return new ResponseEntity<>(new ErrorMessage("Bad Request"), HttpStatus.BAD_REQUEST);

        String jwt = header.substring(7);
        String email= jwtUtil.getUserName(jwt);
        User user = userService.getByEmail(email);

        if(user == null)
            return new ResponseEntity<>(new ErrorMessage("Incorrect user"), HttpStatus.NOT_FOUND);

        user.setName(updateRequest.getName());
        user.setPassword(passwordEncoder.encode(updateRequest.getPassword()));
        userService.save(user);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}
