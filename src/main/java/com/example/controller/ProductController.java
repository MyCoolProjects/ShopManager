package com.example.controller;

import java.io.IOException;
import java.util.List;

import com.example.entity.Product;
import com.example.repository.CategoryRepository;
import com.example.repository.ImageRepository;
import com.example.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api-path}")
class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ImageRepository imageRepository;

    // Получить продукты
    @GetMapping("/products")
    List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Получить продукт
    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    // Добавить продукт
    @PostMapping("/products")
    Product postProduct(@RequestBody Product product) throws IOException {
        return productRepository.save(product);
    }

    // Удалить продукт
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
