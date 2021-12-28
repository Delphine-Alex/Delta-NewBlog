package com.delta.blog.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delta.blog.blog.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
