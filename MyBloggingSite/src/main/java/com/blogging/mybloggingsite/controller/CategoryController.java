package com.blogging.mybloggingsite.controller;

import com.blogging.mybloggingsite.model.Category;
import com.blogging.mybloggingsite.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/addnewcategory")
    ResponseEntity<Category> addNewCategory(@RequestBody Category category) {
        Category category1 = categoryService.addNewCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(category1);
    }

    @GetMapping("/getallcategory")
    ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.getCategoryList();
        return ResponseEntity.status(HttpStatus.FOUND).body(categories);
    }

    @GetMapping("/getcategorybyid/{categoryId}")
    ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.status(HttpStatus.FOUND).body(category);
    }
}
