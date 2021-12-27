package com.delta.blog.blog.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.model.Category;

@Component
public class ArticleTransformer {
	public ArticleFull transform(Article article) {
		ArticleFull articleFull = new ArticleFull();
		articleFull.setId(article.getId());
		articleFull.setTitle(article.getTitle());
		articleFull.setAuthor_name(article.getAuthor_name());
		articleFull.setDate(article.getDate());
		articleFull.setContent(article.getContent());
		articleFull.setUser_id(article.getUser_id());
		
		for(Category category : article.getCategories()) {
			CategoryLight categoryLight = new CategoryLight();
			categoryLight.setId(category.getId());
			categoryLight.setName(category.getName());
			articleFull.getCategories().add(categoryLight);
		}
		
		articleFull.setComments(article.getComments());
		
		return articleFull;
	}
	
	public List<ArticleFull> transform(Iterable<Article> articles) {
		List<ArticleFull> articlesFull = new ArrayList<>();
		for(Article article : articles) {
			articlesFull.add(transform(article));
		}
		return articlesFull;
	}
}
