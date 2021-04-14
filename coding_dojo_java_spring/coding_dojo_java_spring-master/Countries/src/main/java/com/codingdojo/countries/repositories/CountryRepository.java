package com.codingdojo.countries.repositories;

import java.util.List;
import com.codingdojo.countries.models.Country;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language='Slovene' ORDER BY l.percentage DESC")
	List<Object[]> join1();
	
	@Query("SELECT c.name, COUNT(ct) FROM Country c JOIN c.cities ct GROUP BY c.id ORDER BY COUNT(ct) DESC")
	List<Object[]> join2();
	
	@Query("SELECT c.name, ct.name, ct.population FROM Country c JOIN c.cities ct WHERE c.name='MEXICO' AND ct.population>500000 ORDER BY ct.population DESC")
	List<Object[]> join3();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY c.name, l.percentage DESC")
	List<Object[]> join4();
	
	@Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.population > 100000 AND c.surface_area < 501")
	List<Object[]> join5();
	
	@Query("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form='Constitutional Monarchy' AND c.surface_area > 200 AND c.life_expectancy > 75")
	List<Object[]> join6();
	
	@Query("SELECT c.name, ct.name, ct.district, ct.population FROM Country c JOIN c.cities ct WHERE c.name='Argentina' AND ct.district ='Buenos Aires' AND ct.population > 500000")
	List<Object[]> join7();
	
	@Query("SELECT c.region, COUNT(c.id) FROM Country c GROUP BY c.region ORDER BY COUNT(c.region) DESC")
	List<Object[]> join8();
}
