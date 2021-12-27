package com.delta.blog.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delta.blog.blog.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByName(String name);
}
