package com.bm.service.impl;

import com.bm.dto.ProductDto;
import com.bm.entity.Category;
import com.bm.entity.Product;
import com.bm.repository.ProductRepository;
import com.bm.service.CategoryService;
import com.bm.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public String save(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        Category category = categoryService.findByName(productDto.getCategoryName());
        product.setCategory(category);
        productRepository.save(product);
        return "Added successfully";
    }


    @Override
    public List<Product> getAllByCategory(String categoryName) {
        Category category = categoryService.findByName(categoryName);

        if(category == null)
            return null;

        return productRepository.findAllByCategory(category);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public String deletyById(Long id) {
        productRepository.deleteById(id);
        return "Deleted successfully";
    }
}
