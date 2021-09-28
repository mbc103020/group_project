package com.groupproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupproject.repositories.LookRepository;
import com.groupproject.models.Look;
@Service
public class LookService{
	
	@Autowired
	private LookRepository lookRepository; 
	
	public List<Look> allLooks(){
		return lookRepository.findAll(); 
	}
	
	

}
