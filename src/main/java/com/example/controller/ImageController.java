package com.example.controller;

import com.example.entity.Image;
import com.example.form.FormImage;
import com.example.repository.ImageRepository;
import com.example.repository.NewsRepository;
import com.example.repository.ProductRepository;
import com.example.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Добавить изображение
    @PostMapping("/image")
    public ResponseEntity<String> postImage(@RequestBody FormImage formImage) {
        try {
            String payload = formImage.getPayload();
            String[] img = payload.split(";");
            String type = img[0].split(":")[1];
            String data = img[1].split(",")[1];
            Image image = new Image();
            image.setType(type);
            byte[] imgBytes = Base64.getDecoder().decode(data);
            image.setData(imgBytes);

            if (formImage.getIdImageNews() != null) {
                image.setIdImageNews(newsRepository.getOne(formImage.getIdImageNews()));
                Image savedImage = imageRepository.save(image);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", savedImage.getId());
                return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
            } else if (formImage.getIdImageProduct() != null) {
                image.setIdImageProduct(productRepository.getOne(formImage.getIdImageProduct()));
                Image savedImage = imageRepository.save(image);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", savedImage.getId());
                return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
            } else {
                Image savedImage = imageRepository.save(image);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", savedImage.getId());
                return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
            }
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message:", "Error creating image");
            jsonObject.put("error:", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
        }
    }

    // Получить изображения
    @GetMapping("/image")
    @JsonView({ JsonViews.ImageBasic.class })
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    // Получить изображение
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        String type = imageRepository.getOne(id).getType();
        return ResponseEntity.ok().contentType(MediaType.valueOf(type)).body(imageRepository.getOne(id).getData());
    }

    // Удалить продукт
    @DeleteMapping("/image/{id}")
    public void deleteImage(@PathVariable("id") Long id) {
        imageRepository.deleteById(id);
    }

}
