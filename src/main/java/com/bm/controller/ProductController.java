package com.bm.controller;

import com.bm.dto.ProductDto;
import com.bm.entity.Product;
import com.bm.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAllByCategoryName(@RequestParam String category) {
        List<Product> products = productService.getAllByCategory(category);

        if (products != null)
            return new ResponseEntity<>(products, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Product getById(Long id) {
        return productService.getById(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        return new ResponseEntity<>(productService.deletyById(id), HttpStatus.OK);
    }
}
