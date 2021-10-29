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
	
	public Post createPost(Post post) {
		return postRepository.save(post); 
	}
	
	public void save(Post post) {
		this.postRepository.save(post); 
	}
	
	public Post updatePost(Long id, Post postUpdate) {
		Post post = this.findPostById(id); 
		if(post!= null) {
			post.setTitle(postUpdate.getTitle());
			post.setContent(postUpdate.getContent());
			this.save(post);
			return post; 
		}
		return null; 
	}
	
	public void deletePost(Long id) {
		Optional<Post> optionalPost = postRepository.findById(id); 
		if(optionalPost.isPresent()) {
			postRepository.deleteById(id);
		}
	}
	

}
