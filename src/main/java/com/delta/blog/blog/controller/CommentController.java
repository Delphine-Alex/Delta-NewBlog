package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.delta.blog.blog.model.Comment;
import com.delta.blog.blog.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("/comments")
	public Iterable<Comment> getComments() {
		return commentService.getComments();
	}
	
	@GetMapping("/comment/{id}")
	public Comment getComment(@PathVariable("id") Integer id) {
		Comment comment = commentService.getCommentById(id).get();
		return comment;
	}
	
//	To do :
//	@PostMapping("/comments")
	
	
}
