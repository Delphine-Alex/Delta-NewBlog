package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delta.blog.blog.model.Category;
import com.delta.blog.blog.service.CategoryService;

@RestController
@RequestMapping("api/private")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
		
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.upsert(category);
	}

	@PutMapping("/category/{id}")
	public Category Category(@RequestBody Category category) {
		return categoryService.upsert(category);
	}
	
	@DeleteMapping("/category/{id}")
	public void deleteCategoryById(@PathVariable("id") Integer id) {
		categoryService.deleteCategoryById(id);
	}
	
}
