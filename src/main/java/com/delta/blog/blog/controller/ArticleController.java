package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.service.ArticleService;

@RestController
@RequestMapping("api/private")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	

	@PostMapping("/articles")
	public Article addArticle(@RequestBody Article article) {
		return articleService.upsert(article);
	}

	
//	@PutMapping("/articles")
//	public ArticleFull updateArticle(@RequestBody Article article) {
//		return articleService.addArticle(article);
//	}
//	
//	@DeleteMapping("/article/{id}")
//	public void deleteArticle(@PathVariable("id") Integer id) {
//		articleService.deleteArticleById(id);
//	}
	
	
}
