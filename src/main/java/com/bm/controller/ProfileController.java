package com.bm.controller;

import com.bm.dto.UpdateRequest;
import com.bm.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Slf4j
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody UpdateRequest updateRequest, @RequestHeader("Authorization") String header) {
        log.info("Trying to update user info");
        return profileService.update(updateRequest, header);
    }
}
