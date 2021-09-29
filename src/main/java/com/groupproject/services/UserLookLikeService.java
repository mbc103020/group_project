package com.groupproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.models.UserLookLike;
import com.groupproject.repositories.UserLookLikeRepository;

@Service
public class UserLookLikeService {
	
	@Autowired
	private UserLookLikeRepository userLookLikeRepository; 
	
	public List<UserLookLike> allUserLookLikes(){
		return userLookLikeRepository.findAll(); 
	}
	
	

}
