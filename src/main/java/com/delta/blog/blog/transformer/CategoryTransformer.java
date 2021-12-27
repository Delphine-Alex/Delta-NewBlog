package com.delta.blog.blog.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.model.Category;

@Component
public class CategoryTransformer {
	public CategoryFull transform(Category category) {
		CategoryFull categoryFull=new CategoryFull();
		categoryFull.setId(category.getId());
		categoryFull.setName(category.getName());
		for(Article article : category.getArticles()) {
			ArticleLight articleLight=new ArticleLight();
			articleLight.setId(article.getId());
			articleLight.setTitle(article.getTitle());
			articleLight.setAuthor_name(article.getAuthor_name());
			articleLight.setDate(article.getDate());
			articleLight.setContent(article.getContent());
			articleLight.setUser_id(article.getUser_id());
			
			categoryFull.getArticles().add(articleLight);
			
		}
		return categoryFull;
	}
	public List<CategoryFull> transform(Iterable<Category> categories) {
		List<CategoryFull> categoriesFull = new ArrayList<>();
		for(Category category : categories) {
			categoriesFull.add(transform(category));
		}
		return categoriesFull;
	}
}
