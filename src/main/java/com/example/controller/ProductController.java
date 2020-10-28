package com.example.controller;

import com.example.entity.Product;
import com.example.form.FormProduct;
import com.example.repository.ProductRepository;
import com.example.repository.Specification_nameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("${api-path}")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Specification_nameRepository specificationnameRepository;

    //Получить продукты
    @GetMapping("/product")
    public Map<String, List<Product>> getProducts() {
        var response = new HashMap<String, List<Product>>();
        response.put("products", productRepository.findAll());
        return response;
    }

    //Получить продукт
    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

    //Добавить продукт
    @PostMapping("/product")
    public void postProduct(@RequestBody FormProduct formProduct) {
        Product product = new Product(formProduct);
        productRepository.save(product);
    }

}
