package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
	
	List<Person> findByFirstNameContaining(String search);
	
	List<Person> findByLastNameContaining(String search);
	
	Long countByFirstNameContaining(String search);
	
	Long countByLastNameContaining(String search);
	
	Long deleteByFirstNameStartingWith(String search);
	
	Long deleteByLastNameStartingWith(String search);
}
