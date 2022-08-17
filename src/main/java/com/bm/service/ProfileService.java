package com.bm.service;

import com.bm.dto.UpdateRequest;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    ResponseEntity<?> update(UpdateRequest updateRequest, String header);
}
