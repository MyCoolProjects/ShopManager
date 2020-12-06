package com.example.controller;

import java.util.List;

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
    /*
     * @PostMapping("/image") public ResponseEntity<String> postImage(@RequestBody
     * FormImage formImage) { try { String payload = formImage.getPayload();
     * String[] img = payload.split(";"); String type = img[0].split(":")[1]; String
     * data = img[1].split(",")[1]; Image image = new Image(); image.setType(type);
     * byte[] imgBytes = Base64.getDecoder().decode(data); image.setData(imgBytes);
     * 
     * if (formImage.getIdImageNews() != null) {
     * image.setIdImageNews(newsRepository.getOne(formImage.getIdImageNews()));
     * Image savedImage = imageRepository.save(image); JSONObject jsonObject = new
     * JSONObject(); jsonObject.put("id", savedImage.getId()); return
     * ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString()); } else if
     * (formImage.getIdImageProduct() != null) {
     * image.setIdImageProduct(productRepository.getOne(formImage.getIdImageProduct(
     * ))); Image savedImage = imageRepository.save(image); JSONObject jsonObject =
     * new JSONObject(); jsonObject.put("id", savedImage.getId()); return
     * ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString()); } else {
     * Image savedImage = imageRepository.save(image); JSONObject jsonObject = new
     * JSONObject(); jsonObject.put("id", savedImage.getId()); return
     * ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString()); } } catch
     * (Exception e) { JSONObject jsonObject = new JSONObject();
     * jsonObject.put("message:", "Error creating image"); jsonObject.put("error:",
     * e.getMessage()); return
     * ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString()); }
     * }
     */

    // Получить изображения
    @GetMapping("/images")
    List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    // Получить изображение
    @GetMapping("/images/{id}")
    ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        String type = imageRepository.getOne(id).getType();
        return ResponseEntity.ok().contentType(MediaType.valueOf(type)).body(imageRepository.getOne(id).getData());
    }

    // Удалить продукт
    @DeleteMapping("/images/{id}")
    void deleteImage(@PathVariable Long id) {
        imageRepository.deleteById(id);
    }

}
