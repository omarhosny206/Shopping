package com.bm.service;

import com.bm.entity.Category;

public interface CategoryService {
    Category findByName(String categoryName);

    String save(Category category);
}
