package com.groupproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.models.Like;
import com.groupproject.models.User;
import com.groupproject.models.Post;
import com.groupproject.repositories.LikeRepository;
import com.groupproject.repositories.PostRepository;
import com.groupproject.repositories.UserRepository;


@Service
public class LikeService {
	@Autowired
	private LikeRepository likeRepository; 
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private PostRepository postRepository; 
	
	public List<Like> allUserLikes(){
		return likeRepository.findAll(); 
	}; 
	
	public Like findUserLike(Long id) {
		Optional<Like> optionalLike = likeRepository.findById(id); 
		
		if(optionalLike.isPresent()) {
			return optionalLike.get(); 
		} else {
			return null; 
		}
	}
	
	public Like createLike(Like userLike) {
		return likeRepository.save(userLike); 
	}
	
	public void save(Like userLike) {
		this.likeRepository.save(userLike); 
	}
	
	public void deleteLikeById(Long id) {
		Like relationship = this.findUserLike(id); 
		this.likeRepository.delete(relationship);
	}
	
//	public void deleteUserLike(Long userId, Long postId) {
//		Optional<User> user = userRepository.findById(userId); 
//		Optional<Post> post = postRepository.findById(postId); 
//		
//		if (user.isPresent() && post.isPresent()) {
//			Optional<Like> userLike = likeRepository.findUserAndPost(user.get(), post.get());
//			
//			if (userLike.isPresent()) {
//				this.likeRepository.delete(userLike.get());
//			}
//		} 
//		
//	}
//	
	
	
	

}
