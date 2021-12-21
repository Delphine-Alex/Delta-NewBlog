package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/articles")
	public Iterable<Article> getArticles() {
		return articleService.getArticles();
	}
	
	@GetMapping("/article/{id}")
	public Article getArticle(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleById(id).get();
		return article;
	}
	
	
}
