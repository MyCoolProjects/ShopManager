package com.example.controller;

import java.util.Base64;
import java.util.List;

import com.example.dto.ImageRequestDto;
import com.example.entity.Image;
import com.example.repository.ImageRepository;
import com.example.repository.NewsPostsRepository;
import com.example.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    NewsPostsRepository newsRepository;

    // Добавить изображение
    @PostMapping("/images")
    public Image postImage(@RequestBody ImageRequestDto formImage) {
        Image image = new Image();
        String payload = formImage.getPayload();
        String[] img = payload.split(";");
        String type = img[0].split(":")[1];
        String data = img[1].split(",")[1];
        byte[] imgBytes = Base64.getDecoder().decode(data);
        image.setType(type);
        image.setData(imgBytes);

        if (formImage.getNewsPostId() != null) {
            image.setNewsPost(newsRepository.findById(formImage.getNewsPostId()).get());
            return imageRepository.save(image);
        } else if (formImage.getProductId() != null) {
            image.setProduct(productRepository.findById(formImage.getProductId()).get());
            return imageRepository.save(image);
        } else {
            return imageRepository.save(image);
        }
    }

    // Получить изображения
    @GetMapping("/images")
    List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    // Получить изображение
    @GetMapping("/images/{id}")
    ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        String type = imageRepository.findById(id).get().getType();
        return ResponseEntity.ok().contentType(MediaType.valueOf(type)).body(imageRepository.getOne(id).getData());
    }

    // Удалить продукт
    @DeleteMapping("/images/{id}")
    void deleteImage(@PathVariable Long id) {
        imageRepository.deleteById(id);
    }

}
