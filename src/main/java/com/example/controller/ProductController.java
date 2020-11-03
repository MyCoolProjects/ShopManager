package com.example.controller;

import com.example.entity.Product;
import com.example.form.FormProduct;
import com.example.repository.ImageRepository;
import com.example.repository.ProductRepository;
import com.example.repository.Specification_nameRepository;
import com.example.service.ProductService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductService productService;

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
    public ResponseEntity<String> postProduct(@RequestBody FormProduct formProduct) throws IOException {
        Product product = new Product(formProduct);
        Product product1 = productService.saveProduct(product);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", product1.getId());
        return ResponseEntity.status(HttpStatus.OK)
                .body(jsonObject.toString());
    }
}
