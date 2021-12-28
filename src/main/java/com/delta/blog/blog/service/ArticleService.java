package com.delta.blog.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public Iterable<Article> getArticles(){
		return articleRepository.findAll();
	}

	public Optional<Article> getArticleById(Integer id) {
		return articleRepository.findById(id);
	}
	
//	public ArticleFull getArticleById(Integer id) {
//		return articleTransformer.transform(articleRepository.findById(id).get());
//	}
//	
//	public ArticleFull addArticle(Article article) {
//		return articleTransformer.transform(articleRepository.save(article));
//	}
//	
//	public void deleteArticleById(Integer id) {
//		articleRepository.deleteById(id);
//	}
}
