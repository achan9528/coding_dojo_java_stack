package com.codingdojo.countries.repositories;

import java.util.List;
import com.codingdojo.countries.models.City;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends CrudRepository<City,Long>{
//	@Query("SELECT * FROM City ct WHERE population>500000 ORDER BY population DESC")
//	List<Object[]> join3();
}
