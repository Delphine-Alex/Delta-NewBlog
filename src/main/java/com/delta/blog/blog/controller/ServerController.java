package com.delta.blog.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

	@GetMapping("/")
	public String getServer() {
		return "Server works!";
	}
}
