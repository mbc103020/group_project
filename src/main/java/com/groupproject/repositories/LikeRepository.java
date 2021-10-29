package com.groupproject.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import com.groupproject.models.User;

import com.groupproject.models.Like;
import com.groupproject.models.Post;

public interface LikeRepository extends CrudRepository<Like, Long> {
	List<Like> findAll(); 
//	Optional<Like> findUserAndPost(User user, Post post); 
	

}
