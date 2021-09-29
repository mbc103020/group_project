package com.groupproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.groupproject.models.Look;

public interface LookRepository extends CrudRepository<Look, Long> {
	List<Look> findAll(); 

}
