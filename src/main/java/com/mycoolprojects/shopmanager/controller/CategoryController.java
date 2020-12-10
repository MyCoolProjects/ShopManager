package com.mycoolprojects.shopmanager.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.mycoolprojects.shopmanager.entity.Category;
import com.mycoolprojects.shopmanager.repository.CategoryRepository;

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
class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Получить категории
    @GetMapping("/categories")
    Map<String, List<Category>> getAllCategories() {
        return Collections.singletonMap("categories", categoryRepository.findAll());
    }

    // Получить категорию
    @GetMapping("/categories/{id}")
    Category getCategory(@PathVariable Long id) {
        return categoryRepository.findById(id).get();
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
