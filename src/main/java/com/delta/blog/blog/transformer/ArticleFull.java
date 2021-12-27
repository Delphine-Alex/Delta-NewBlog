package com.delta.blog.blog.transformer;

import java.util.ArrayList;
import java.util.List;

import com.delta.blog.blog.model.Comment;

public class ArticleFull extends ArticleLight{
	private List<Comment> comments = new ArrayList<>();
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<CategoryLight> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryLight> categories) {
		this.categories = categories;
	}
	private List<CategoryLight> categories = new ArrayList<>();
}
