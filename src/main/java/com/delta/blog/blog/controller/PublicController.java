package com.delta.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delta.blog.blog.configuration.JwtTokenUtil;
import com.delta.blog.blog.model.Article;
import com.delta.blog.blog.model.Category;
import com.delta.blog.blog.model.Comment;
import com.delta.blog.blog.service.ArticleService;
import com.delta.blog.blog.service.CategoryService;
import com.delta.blog.blog.service.CommentService;
//import com.delta.blog.blog.transformer.ArticleFull;
//import com.delta.blog.blog.transformer.CategoryFull;

@RestController
@RequestMapping("api/public")
public class PublicController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login (@RequestBody com.delta.blog.blog.model.User user){
		try {
			Authentication authenticate=authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
			
			
			User auththenticatedUser=(User) authenticate.getPrincipal();
			
			
			String token = jwtTokenUtil.generateAccessToken(auththenticatedUser);
			System.out.println("Token is : " + token);
			
			String text= auththenticatedUser.getUsername()+ " successfully authenticated";
			ResponseEntity<String> response=
					ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).body(text);
			return response;
			
		}
		catch(BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	
	
	@GetMapping("/categories")
	public Iterable<Category> getCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping("/category/{id}")
	public Category getCategoryById(@PathVariable("id") Integer id) {
		Category category = categoryService.getCategoryById(id).get();
		return category;
	}
	
	
	@GetMapping("/articles")
	public Iterable<Article> getArticles() {
		return articleService.getArticles();
	}
	
	@GetMapping("/article/{id}")
	public Article getArticles(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleById(id).get();
		return article;
	}
	
	
	@GetMapping("/comments")
	public Iterable<Comment> getComments() {
		return commentService.getComments();
	}
	
	@GetMapping("/comment/{id}")
	public Comment getCommentById(@PathVariable("id") Integer id) {
		Comment comment = commentService.getCommentById(id).get();
		return comment;
	}
	
	@PostMapping("/comments")
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.upsert(comment);
	}
	

}
