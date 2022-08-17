package com.bm.service.impl;

import com.bm.entity.Category;
import com.bm.repository.CategoryRepository;
import com.bm.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByName(String categoryName) {
        log.info("Getting category with name={}", categoryName);
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public String save(Category category) {
        log.info("Saving category with name={}", category.getName());
        categoryRepository.save(category);
        return "Added successfully";
    }
}
