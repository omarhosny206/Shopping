package com.bm.service.impl;

import com.bm.entity.Category;
import com.bm.repository.CategoryRepository;
import com.bm.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public String save(Category category) {
        categoryRepository.save(category);
        return "Added successfully";
    }
}
