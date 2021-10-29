package com.groupproject.controllers;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupproject.models.Like;
import com.groupproject.models.Post;
import com.groupproject.models.User;

import com.groupproject.services.PostService;
import com.groupproject.services.UserService;
import com.groupproject.services.LikeService; 



@SpringBootApplication
@Controller
public class PostController {
	
	@Autowired
	private PostService postService; 
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private LikeService likeService; 
	
	@GetMapping("/blogPosts")
	public String blogPosts(Model model, HttpSession session, @ModelAttribute("post")Post post) {
		Long userId = (Long) session.getAttribute("userId"); 
		if(userId == null) {
			return "redirect:/"; 
		}
		
		List<Post> allBlogPosts = this.postService.allBlogPosts(); 
		model.addAttribute("posts", allBlogPosts); 
		return "Blog/blogs.jsp"; 
	}
	
	@PostMapping("/newBlogPost")
	public String newBlogPost(@Valid Post post, BindingResult result, HttpSession session, Model model) {
		
		Long userId = (Long) session.getAttribute("userId"); 
		
		if(userId == null) {
			return "redirect:/"; 
		}
		
		User user = this.userService.findUserById(userId); 
		model.addAttribute("loggedInUser", user); 
		
		if(result.hasErrors()) {
			return "Blog/blogs.jsp"; 
		} else {
			post.setUser(user); 
			this.postService.createPost(post); 
			return "redirect:/blogPosts"; 
			
		}
		
	}
	
	@GetMapping("/editPost/{postId}")
	public String getEditForm(@PathVariable("postId") Long postId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); 
		User user = this.userService.findUserById(userId);
		Post post = this.postService.findPostById(postId); 
		if(post == null) {
			return "/blogPosts"; 
		}
		if(user != post.getUser()) {
			return "redirect:/blogPosts"; 
		}
			model.addAttribute("post", post);
			return "Blog/editPost.jsp"; 	
	
	}
	
	@PostMapping("/updatePost/{postId}")
	public String updatePost(@PathVariable("postId") Long postId, @Valid Post post, BindingResult result, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); 
		User user = this.userService.findUserById(userId);
		if(result.hasErrors()) {
			return "/editPost/{postId}"; 
		}
			this.postService.updatePost(postId, post); 

			return "redirect:/blogPosts"; 
	}
	
	@GetMapping("/deletePost/{postId}")
	public String deletePost(@PathVariable("postId") Long postId ) {
		Post post = this.postService.findPostById(postId); 
		if(post != null) {
			this.postService.deletePost(postId); 		
		}
		
		return "redirect:/blogPosts"; 
		
	}
	
	@GetMapping("/viewPost/{postId}")
	public String viewPost(@PathVariable("postId") Long postId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); 
		User user = this.userService.findUserById(userId);
		if(userId == null) {
			return "redirect:/"; 
		}
		
		User loggedInUser = userService.findUserById(userId); 
		model.addAttribute("loggedInUser", loggedInUser); 
		
		Post post = this.postService.findPostById(postId); 
		model.addAttribute("post", post); 
		
	//	List<UserLikeIdea> likedUsers = idea.getUsersWhoLikedIdea(); 
	//	model.addAttribute("likedUsers", likedUsers); 
		
		
		return "Blog/viewPost.jsp"; 
		
	}
	
	@GetMapping("/likePost/{postId}")
	public String likePost(@PathVariable("postId") Long postId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); 
		User user = this.userService.findUserById(userId); 
		
		Post post = this.postService.findPostById(postId); 
		
		Like newLike = new Like(); 
		newLike.setPost(post); 
		newLike.setUser(user); 
		
		this.likeService.createLike(newLike); 
		
		return "redirect:/user/idea/ideaDashboard"; 
	
	}
	
	
	
	
	

}
