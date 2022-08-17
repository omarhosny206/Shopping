package com.bm.service.impl;

import com.bm.dto.ProductDto;
import com.bm.entity.Category;
import com.bm.entity.Product;
import com.bm.repository.ProductRepository;
import com.bm.service.CategoryService;
import com.bm.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public String save(ProductDto productDto) {
        log.info("Saving new product assigned to category-name={}", productDto.getCategoryName());
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        Category category = categoryService.findByName(productDto.getCategoryName());
        product.setCategory(category);
        productRepository.save(product);
        return "Added successfully";
    }


    @Override
    public List<Product> getAllByCategory(String categoryName) {
        log.info("Getting all products with category-name={}", categoryName);
        Category category = categoryService.findByName(categoryName);

        if (category == null) {
            log.error("Not found");
            return null;
        }

        log.info("Found successfully");
        return productRepository.findAllByCategory(category);
    }

    @Override
    public Product getById(Long id) {
        log.info("Getting a product with id={}", id);
        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            log.error("Not found");
            return null;
        }

        log.error("Found successfully");
        return product;
    }

    @Override
    public String deleteById(Long id) {
        log.info("Deleting a product with id={}", id);
        productRepository.deleteById(id);
        return "Deleted successfully";
    }
}
