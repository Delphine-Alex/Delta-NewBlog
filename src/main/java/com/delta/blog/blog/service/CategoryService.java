package com.delta.blog.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.blog.blog.model.Category;
import com.delta.blog.blog.repository.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public Iterable<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategoryById(Integer id) {
		return categoryRepository.findById(id);
	}
	
	public Category upsert(Category category) {
		return categoryRepository.save(category);
	}
	

//	public void deleteCategoryById(Integer id) {
//		categoryRepository.deleteById(id);
//	}
	
	
}
