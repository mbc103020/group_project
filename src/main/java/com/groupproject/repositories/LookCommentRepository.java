package com.groupproject.repositories;
import com.groupproject.models.LookComment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LookCommentRepository extends CrudRepository<LookComment, Long>{
	List<LookComment> findAll(); 

}
