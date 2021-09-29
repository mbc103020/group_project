package com.groupproject.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.groupproject.models.UserLookLike;


public interface UserLookLikeRepository extends CrudRepository<UserLookLike, Long> {
	List<UserLookLike> findAll(); 

}
