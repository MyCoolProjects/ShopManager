package com.example.controller;

import java.util.List;

import com.example.entity.NewsPost;
import com.example.repository.ImageRepository;
import com.example.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api-path}")
class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    ImageRepository imageRepository;

    // Вернуть новости
    @GetMapping("/newsposts")
    List<NewsPost> getAllNewsPosts() {
        return newsRepository.findAll();
    }

    @GetMapping("/newsposts/{id}")
    NewsPost getNewsPost(@PathVariable Long id) {
        return newsRepository.getOne(id);
    }

    // Добавить новость
    @PostMapping("/newsposts")
    NewsPost createNewsPost(@RequestBody NewsPost newsPost) {
        return newsRepository.save(newsPost);
    }

    // Удалить продукт
    @DeleteMapping("/newsposts/{id}")
    void deleteNewsPost(@PathVariable Long id) {
        newsRepository.deleteById(id);
    }

}
