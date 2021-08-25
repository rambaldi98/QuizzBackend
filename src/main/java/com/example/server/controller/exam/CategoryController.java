package com.example.server.controller.exam;

import com.example.server.model.exam.Category;
import com.example.server.service.exam.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // add category
    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    // getcategory

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return this.categoryService.getCategory(id);
    }

    // get all

    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    // update

    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }


    // delete

    @DeleteMapping("/{id}")

    public void deleteCategory(@PathVariable("id") Long id){
        this.categoryService.deleteCategory(id);
    }


}
