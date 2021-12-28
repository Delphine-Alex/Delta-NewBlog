package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.model.Category;
import com.delta.blog.blog.service.CategoryService;
//import com.delta.blog.blog.transformer.CategoryFull;

@RestController
@RequestMapping("api/private")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category/{id}")
	public Category getCategoryById(@PathVariable("id") Integer id) {
		Category category = categoryService.getCategoryById(id).get();
		return category;
	}
	
//	@GetMapping("/category/{id}")
//	public ResponseEntity<CategoryFull> getCategory(@PathVariable("id") Integer id) {
//		CategoryFull p = categoryService.getCategoryById(id);
//		return new ResponseEntity<CategoryFull>(p, HttpStatus.OK);
//	}
	
//	@PostMapping("/categories")
//	public CategoryFull addCategory(@RequestBody Category category) {
//		return categoryService.addCategory(category);
//	}
//	
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
