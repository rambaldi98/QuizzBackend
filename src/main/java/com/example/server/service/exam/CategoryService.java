package com.example.server.service.exam;

import com.example.server.model.exam.Category;

import java.util.Set;

public interface CategoryService {
     Category addCategory(Category category);
     Category updateCategory(Category category);
     Set<Category> getCategories();
     Category getCategory(Long categoryId);
     void deleteCategory(Long categoryId);
}
