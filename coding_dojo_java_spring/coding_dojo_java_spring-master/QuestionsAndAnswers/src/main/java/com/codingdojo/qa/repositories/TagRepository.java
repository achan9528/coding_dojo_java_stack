package com.codingdojo.qa.repositories;

import java.util.List;
import com.codingdojo.qa.models.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag,Long>{
	List<Tag> findAll();
	
	List<Tag> findBySubjectIs(String s);
}
