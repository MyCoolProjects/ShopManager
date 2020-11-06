package com.example.controller;

import com.example.entity.News;
import com.example.form.FormNews;
import com.example.repository.ImageRepository;
import com.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    ImageRepository imageRepository;

    //Вернуть новости
    @GetMapping("/news")
    public List<News> getNews() {
        return newsRepository.findAll();
    }

    //Добавить новость
    @PostMapping("/news")
    public void postNews(@RequestBody FormNews formNews) {
        News news = new News();
        news.setTitle(formNews.getName());
        news.setDescription(formNews.getDescription());
        newsRepository.save(news);
    }

}
