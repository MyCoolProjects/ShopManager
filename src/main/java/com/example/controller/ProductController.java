package com.example.controller;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.repository.Specification_nameRepository;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Specification_nameRepository specificationnameRepository;

    @JsonRawValue
    public List<Product> products;

    @GetMapping("/product")
    public Map<String, List<Product>> productAllGet() {
        var response = new HashMap<String, List<Product>>();
        response.put("products", productRepository.findAll());
        return response;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Optional<Product> getProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

}
