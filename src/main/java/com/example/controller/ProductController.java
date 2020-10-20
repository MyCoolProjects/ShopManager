package com.example.controller;

import com.example.entity.Product;
import com.example.form.FormProduct;
import com.example.repository.ProductRepository;
import com.example.repository.Specification_nameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Specification_nameRepository specificationnameRepository;

    @GetMapping("/product")
    public Map<String, List<Product>> productAllGet() {
        var response = new HashMap<String, List<Product>>();
        response.put("products", productRepository.findAll());
        return response;
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

    //Для изображения
    @GetMapping("/imageJSON/{product_id}")
    public Map<String, String> getImage(@PathVariable("product_id") Long product_id) {
        Map<String, String> image = new HashMap<String, String>();
        String str = "data:image/jpeg;base64,";
        byte[] imgBytes = productRepository.getOne(product_id).getImage();
        String result = Base64.getEncoder().encodeToString(imgBytes);
        image.put("img", str + result);
        return image;
    }

    //Добавить объект
    @PostMapping("/productPost")
    public void postProduct(@RequestBody FormProduct formProduct) {
        String[] img = formProduct.getImage().split(",");
        formProduct.setImage(img[1]);
        byte[] imgByte = Base64.getDecoder().decode(formProduct.getImage());
        Product product = new Product(formProduct, imgByte);
        productRepository.save(product);
    }
}
