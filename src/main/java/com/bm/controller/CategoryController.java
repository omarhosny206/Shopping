package com.bm.controller;

import com.bm.entity.Category;
import com.bm.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody Category category) {
        log.info("Adding category with name={}", category.getName());
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }
}
