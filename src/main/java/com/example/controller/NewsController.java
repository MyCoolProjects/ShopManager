package com.example.controller;

import com.example.entity.NewsPost;
import com.example.form.FormNewsPost;
import com.example.jsonview.JsonViews;
import com.example.repository.ImageRepository;
import com.example.repository.NewsRepository;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;

import java.util.List;

@RestController
@RequestMapping("${api-path}")
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    ImageRepository imageRepository;

    // Вернуть новости
    @GetMapping("/news")
    @JsonView(JsonViews.NewsPostBasic.class)
    public List<NewsPost> getNewsPosts() {
        return newsRepository.findAll();
    }

    // Добавить новость
    @PostMapping("/news")
    @JsonView(JsonViews.NewsPostBasic.class)
    public ResponseEntity<String> addNewsPost(@RequestBody FormNewsPost formNews) {
        NewsPost post = new NewsPost();
        post.setTitle(formNews.getTitle());
        post.setDescription(formNews.getDescription());
        newsRepository.save(post);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", post.getId());
        return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
    }

    // Удалить продукт
    @DeleteMapping("/news/{id}")
    public void deleteNewsPost(@PathVariable("id") Long id) {
        newsRepository.deleteById(id);
    }

}
