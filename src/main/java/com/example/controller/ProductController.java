package com.example.controller;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.repository.SpecificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SpecificationsRepository specificationsRepository;

    @GetMapping("/productAllGet")
    public List<Product> productAllGet() {
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping(value = "/productGet/{id}", method = RequestMethod.GET)
    public Optional<Product> getProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

}