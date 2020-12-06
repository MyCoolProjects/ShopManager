package com.example.controller;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api-path}")
class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Получить категории
    @GetMapping("/categories")
    List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Получить категорию
    @GetMapping("/categories/{id}")
    Category getCategory(@PathVariable Long id) {
        return categoryRepository.getOne(id);
    }

    // Добавить категорию
    @PostMapping("/categories")
    Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping("/categories/{id}")
    void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
