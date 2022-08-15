package com.bm.controller;

import com.bm.entity.Product;
import com.bm.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllByCategoryName(@RequestParam String category) {
        List<Product> products = productService.getAllByCategory(category);

        if(products != null)
            return new ResponseEntity<>(products, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Product getById(Long id) {
        return productService.getById(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
