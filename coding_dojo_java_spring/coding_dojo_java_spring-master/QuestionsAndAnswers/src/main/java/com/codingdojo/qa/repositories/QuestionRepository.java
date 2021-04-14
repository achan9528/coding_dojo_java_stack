package com.codingdojo.qa.repositories;

import java.util.List;
import com.codingdojo.qa.models.Question;
import org.springframework.data.repository.CrudRepository;


public interface QuestionRepository extends CrudRepository<Question,Long>{
	List<Question> findAll();
}
