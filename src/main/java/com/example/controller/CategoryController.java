package com.example.controller;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    //Получить категории
    @GetMapping("/category")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    //Получить категорию
    @GetMapping("/category/{id}")
    public Optional<Category> getCategory(@PathVariable Long id) {
        return categoryRepository.findById(id);
    }

    //Добавить категорию
    @PostMapping("/category")
    public void postCategory(@RequestBody Category category) {
        categoryRepository.save(category);
    }
}
