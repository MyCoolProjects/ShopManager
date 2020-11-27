package com.example.controller;

import com.example.entity.News;
import com.example.form.FormNews;
import com.example.repository.ImageRepository;
import com.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api-path}")
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
        news.setTitle(formNews.getTitle());
        news.setDescription(formNews.getDescription());
        newsRepository.save(news);
    }

    //Удалить продукт
    @DeleteMapping("/news/{id}")
    public void deleteNews(@PathVariable("id") Long id) {
        newsRepository.deleteById(id);
    }

}
