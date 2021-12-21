package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.delta.blog.blog.model.Category;
import com.delta.blog.blog.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public Iterable<Category> getCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable("id") Integer id) {
		Category category = categoryService.getCategoryById(id).get();
		return category;
	}
	
	
}
