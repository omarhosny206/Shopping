package com.bm.controller;

import com.bm.dto.ProductDto;
import com.bm.entity.Category;
import com.bm.entity.Product;
import com.bm.exception.ErrorResponse;
import com.bm.exception.Errors;
import com.bm.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAllByCategoryName(@RequestParam String category) {
        log.info("Getting all products with category-name={}", category);
        List<Product> products = productService.getAllByCategory(category);

        if (products != null) {
            log.info("found successfully");
            return new ResponseEntity<>(products, HttpStatus.OK);
        }

        log.error("not found");
        return new ResponseEntity<>(new ErrorResponse(Errors.CategoryNotFound.getErrorMessage()), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public Product getById(@RequestParam Long id) {
        log.info("Getting product with id={}", id);
        return productService.getById(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody ProductDto productDto) {
        log.info("Saving a new product={}", productDto);
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        log.info("Deleting a product with id={}", id);
        return new ResponseEntity<>(productService.deleteById(id), HttpStatus.OK);
    }
}
