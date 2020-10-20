package com.example.controller;

import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ImageController {

    @Autowired
    ProductRepository productRepository;

    //Для изображения
    //@ResponseBody
    @GetMapping("/image/{product_id}")
    public byte[] getImaget(HttpServletResponse response, @PathVariable("product_id") Long product_id) {
        response.setContentType("image/jpeg");
        byte[] imgBytes = productRepository.getOne(product_id).getImage();

        return imgBytes;
    }
}
