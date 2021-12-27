package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.service.ArticleService;
import com.delta.blog.blog.transformer.ArticleFull;
@RestController
@RequestMapping("api/private")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@PostMapping("/article")
	public ArticleFull addArticle(@RequestBody Article article) {
		return articleService.addArticle(article);
	}
	
	@DeleteMapping("/article/{id}")
	public void deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticleById(id);
	}
	
	@PutMapping("/article")
	public ArticleFull updateArticle(@RequestBody Article article) {
		return articleService.addArticle(article);
	}
	
}
