package com.delta.blog.blog.transformer;

import java.util.ArrayList;
import java.util.List;

public class CategoryFull extends CategoryLight {
	private List<ArticleLight> articles = new ArrayList<>();

	public List<ArticleLight> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleLight> articles) {
		this.articles = articles;
	}
}
