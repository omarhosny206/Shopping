package com.bm.service;

import com.bm.dto.ProductDto;
import com.bm.entity.Product;

import java.util.List;

public interface ProductService {
    String save(ProductDto productDto);

    List<Product> getAllByCategory(String categoryName);

    Product getById(Long id);

    String deletyById(Long id);
}
