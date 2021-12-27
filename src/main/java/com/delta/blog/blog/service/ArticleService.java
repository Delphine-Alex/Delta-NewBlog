package com.delta.blog.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.repository.ArticleRepository;
import com.delta.blog.blog.transformer.ArticleFull;
import com.delta.blog.blog.transformer.ArticleTransformer;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ArticleTransformer articleTransformer;
	
	public ArticleFull getArticleById(Integer id) {
		return articleTransformer.transform(articleRepository.findById(id).get());
	}
	public List<ArticleFull> getArticles(){
		return articleTransformer.transform(articleRepository.findAll());
	}
	public ArticleFull addArticle(Article article) {
		return articleTransformer.transform(articleRepository.save(article));
	}
	public void deleteArticleById(Integer id) {
		articleRepository.deleteById(id);
	}
}
