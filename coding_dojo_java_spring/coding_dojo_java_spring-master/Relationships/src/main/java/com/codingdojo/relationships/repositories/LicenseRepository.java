package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findAll();
	
	List<License> findByStateContaining(String search);
	
	Long countByStateContaining(String search);
	
	Long deleteByStateStartingWith(String search);
}
