package com.groupproject.controllers;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.groupproject.models.Post;

import com.groupproject.services.PostService;

@SpringBootApplication
@Controller
public class PostController {
	
	@Autowired
	private PostService postService; 
	
	@GetMapping("/blogPosts")
	public String blogPosts(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); 
		if(userId == null) {
			return "redirect:/"; 
		}
		
		List<Post> allBlogPosts = this.postService.allBlogPosts(); 
		model.addAttribute("posts", allBlogPosts); 
		return "Blog/blogs.jsp"; 
	}
	
	

}
