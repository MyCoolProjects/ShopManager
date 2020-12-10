package com.example.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.example.entity.NewsPost;
import com.example.repository.ImageRepository;
import com.example.repository.NewsPostsRepository;

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
class NewsPostsController {

    @Autowired
    NewsPostsRepository newsPostsRepository;

    @Autowired
    ImageRepository imageRepository;

    // Вернуть новости
    @GetMapping("/newsposts")
    Map<String, List<NewsPost>> getAllNewsPosts() {
        return Collections.singletonMap("news_posts", newsPostsRepository.findAll());
    }

    @GetMapping("/newsposts/{id}")
    NewsPost getNewsPost(@PathVariable Long id) {
        return newsPostsRepository.findById(id).get();
    }

    // Добавить новость
    @PostMapping("/newsposts")
    NewsPost createNewsPost(@RequestBody NewsPost newsPost) {
        return newsPostsRepository.save(newsPost);
    }

    // Удалить продукт
    @DeleteMapping("/newsposts/{id}")
    void deleteNewsPost(@PathVariable Long id) {
        newsPostsRepository.deleteById(id);
    }

}
