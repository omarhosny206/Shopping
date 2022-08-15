package com.bm.controller;

import com.bm.entity.UpdateRequest;
import com.bm.entity.User;
import com.bm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/")
    public void getById(@RequestBody UpdateRequest updateRequest) {
        User user = userService.getByEmail(updateRequest.getEmail());
        BeanUtils.copyProperties(updateRequest, user);
        userService.update(user);
    }
}
