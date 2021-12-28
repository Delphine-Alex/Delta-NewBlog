package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delta.blog.blog.model.Comment;
import com.delta.blog.blog.service.CommentService;

@RestController
@RequestMapping("api/private")
public class CommentController {

	@Autowired
	private CommentService commentService;

	
	@PostMapping("/comments")
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.upsert(comment);
	}
//	
//	@PutMapping("/comments")
//	public Comment updateComment(@RequestBody Comment comment) {
//		return commentService.addComment(comment); 
//	}
//	
//	@DeleteMapping("/comment/{id}")
//	public void deleteCommentById(@PathVariable("id") Integer id) {
//		commentService.deleteCommentById(id);
//	}
	
}
