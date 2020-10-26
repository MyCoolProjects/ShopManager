package com.example.controller;

import com.example.entity.Image;
import com.example.form.FormImage;
import com.example.repository.ImageRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Base64;

@RestController
@RequestMapping("${api-path}")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductRepository productRepository;

    //Добавить изображение
    @PostMapping("/image")
    public void postImage(@RequestBody FormImage formImage) {
        String[] img = formImage.getImage().split(",");
        String[] type1 = img[0].split(":");
        String[] type2 = type1[1].split(";");
        Image image = new Image();
        image.setType(type2[0]);
        byte[] imgByte = Base64.getDecoder().decode(img[1]);
        System.out.println(type2[0]);
        System.out.println(Arrays.toString(imgByte));
        image.setData(imgByte);
        image.setId_image_product(productRepository.getOne(formImage.getId_image_product()));
        imageRepository.save(image);
    }

    //Получить изображение
    @RequestMapping(value = "/image/{id}")
    @ResponseBody
    public ResponseEntity getImage(@PathVariable Long id)
    {
        String type = imageRepository.getOne(id).getType();
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(type))
                .body(imageRepository.getOne(id).getData());
    }

}
