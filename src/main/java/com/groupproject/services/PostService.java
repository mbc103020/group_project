package com.groupproject.services;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.groupproject.models.Post;
import com.groupproject.repositories.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository; 
	
	public List<Post> allBlogPosts(){
		return postRepository.findAll(); 
	}; 
	
	public Post findPostById(Long id) {
		Optional<Post> optional = postRepository.findById(id); 
		if(optional.isPresent()) {
			return optional.get(); 
		}else {
			return null; 
		}
	}
	

}
