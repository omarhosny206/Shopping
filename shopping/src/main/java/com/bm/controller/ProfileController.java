package com.bm.controller;

import com.bm.entity.UpdateRequest;
import com.bm.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody UpdateRequest updateRequest) {
        return profileService.update(updateRequest);
    }
}
