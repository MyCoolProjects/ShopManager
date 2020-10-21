package com.example.controller;

import com.example.entity.Image;
import com.example.form.FormImage;
import com.example.repository.ImageRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductRepository productRepository;

    //Добавить изображение
    @PostMapping("/image")
    public void postImage(@RequestBody FormImage formImage) {
        String[] img = formImage.getImage().split(",");
        Image image = new Image();
        image.setType(img[0]);
        byte[] imgByte = Base64.getDecoder().decode(img[1]);
        image.setData(imgByte);
        image.setId_image_product(productRepository.getOne(formImage.getId_image_product()));
        imageRepository.save(image);
    }

    //Получить изображение
    @GetMapping("/image/{product_id}")
    public Map<String, String> getImage(@PathVariable("product_id") Long product_id) {
        Map<String, String> image = new HashMap<String, String>();
        String type = imageRepository.getOne(product_id).getType();
        byte[] data = imageRepository.getOne(product_id).getData();
        String result = Base64.getEncoder().encodeToString(data);
        image.put("img", type + result);
        return image;
    }
}
