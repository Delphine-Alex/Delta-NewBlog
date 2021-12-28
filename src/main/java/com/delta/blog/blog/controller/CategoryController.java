package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	

//	@PutMapping("/categories")
//	public CategoryFull updateCategory(@RequestBody Category category) {
//		return categoryService.addCategory(category);
//	}
//	
//	@DeleteMapping("/category/{id}")
//	public void deleteCategory(@PathVariable("id") Integer id) {
//		categoryService.deleteCategoryById(id);
//	}

	
}
