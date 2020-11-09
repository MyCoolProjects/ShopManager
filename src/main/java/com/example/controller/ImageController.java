package com.example.controller;

import com.example.entity.Image;
import com.example.form.FormImage;
import com.example.repository.ImageRepository;
import com.example.repository.NewsRepository;
import com.example.repository.ProductRepository;
import com.example.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    NewsRepository newsRepository;

    //Добавить изображение
    @PostMapping("/image")
    public void postImage(@RequestBody FormImage formImage) {
        String[] img = formImage.getImage().split(",");
        String[] type1 = img[0].split(":");
        String[] type2 = type1[1].split(";");
        Image image = new Image();
        image.setType(type2[0]);
        byte[] imgByte = Base64.getDecoder().decode(img[1]);
        image.setData(imgByte);
        if(formImage.getId_image_product() == null && formImage.getId_image_news() != null) {
            image.setId_image_news(newsRepository.getOne(formImage.getId_image_news()));
        }
        if(formImage.getId_image_news() == null && formImage.getId_image_product() != null) {
            image.setId_image_product(productRepository.getOne(formImage.getId_image_product()));
        }
        imageRepository.save(image);
    }

    //Получить изображения
    @GetMapping("/image")
    @JsonView({Views.FormImage.class})
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    //Получить изображение
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id)
    {
        String type = imageRepository.getOne(id).getType();
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(type))
                .body(imageRepository.getOne(id).getData());
    }

}
