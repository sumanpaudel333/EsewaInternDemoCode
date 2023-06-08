package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.model.Category;

import java.util.List;

public interface CategoryService {
    Category addNewCategory(Category category);
    List<Category> getCategoryList();
    Category getCategoryById(Long categoryId);
}
