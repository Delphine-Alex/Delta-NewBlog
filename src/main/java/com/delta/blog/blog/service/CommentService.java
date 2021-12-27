package com.delta.blog.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.delta.blog.blog.model.Comment;
import com.delta.blog.blog.repository.CommentRepository;
@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public Optional<Comment> getCommentById(Integer id) {
		return commentRepository.findById(id);
	}
	public Iterable<Comment> getComments(){
		return commentRepository.findAll();
	}
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}
	public void deleteCommentById(Integer id) {
		commentRepository.deleteById(id);
	}
}
