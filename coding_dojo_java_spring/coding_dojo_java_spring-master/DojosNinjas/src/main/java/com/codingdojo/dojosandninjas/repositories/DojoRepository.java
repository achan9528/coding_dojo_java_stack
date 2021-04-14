package com.codingdojo.dojosandninjas.repositories;

import java.util.List;
import com.codingdojo.dojosandninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;

public interface DojoRepository extends CrudRepository<Dojo,Long>{
	List<Dojo> findAll();
	
	List<Dojo> findByNameContaining(String search);
	
}
