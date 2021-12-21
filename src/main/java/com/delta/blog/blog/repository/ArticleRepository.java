package com.delta.blog.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delta.blog.blog.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
	
}
