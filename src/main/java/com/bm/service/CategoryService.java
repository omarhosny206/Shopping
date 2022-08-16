package com.bm.service;

import com.bm.entity.Category;
import com.bm.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }
}
