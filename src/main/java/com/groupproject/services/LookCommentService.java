package com.groupproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.models.LookComment;
import com.groupproject.repositories.LookCommentRepository;
@Service
public class LookCommentService {
	@Autowired
	private LookCommentRepository lookCommentRepository; 
	
	public List<LookComment> allLookComments(){
		return lookCommentRepository.findAll(); 
	}

}
