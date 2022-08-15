package com.bm.service;

import com.bm.entity.Category;
import com.bm.entity.Product;
import com.bm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public void save(Product product) {
        productRepository.save(product);
    }


    public List<Product> getAllByCategory(String categoryName) {
        Category category = categoryService.findByName(categoryName);

        if(category == null)
            return null;

        return productRepository.findAllByCategory(category);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
