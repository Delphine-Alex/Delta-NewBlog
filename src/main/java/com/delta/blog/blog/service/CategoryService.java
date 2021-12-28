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
	
//	public CategoryFull getCategoryById(Integer id) {
//		return categoryTransformer.transform(categoryRepository.findById(id).get());
//	}
//	
//	
//	public CategoryFull addCategory(Category category) {
//		return categoryTransformer.transform(categoryRepository.save(category));
//	}
//	
//	public void deleteCategoryById(Integer id) {
//		categoryRepository.deleteById(id);
//	}
	
	
}
