package com.delta.blog.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.blog.blog.model.Category;
import com.delta.blog.blog.repository.CategoryRepository;
import com.delta.blog.blog.transformer.CategoryFull;
import com.delta.blog.blog.transformer.CategoryTransformer;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryTransformer categoryTransformer;
	
	public CategoryFull getCategoryById(Integer id) {
		return categoryTransformer.transform(categoryRepository.findById(id).get());
	}
	public List<CategoryFull> getCategories(){
		return categoryTransformer.transform(categoryRepository.findAll());
	}
	
	public CategoryFull addCategory(Category category) {
		return categoryTransformer.transform(categoryRepository.save(category));
	}
	public void deleteCategoryById(Integer id) {
		categoryRepository.deleteById(id);
	}
	
	
}
