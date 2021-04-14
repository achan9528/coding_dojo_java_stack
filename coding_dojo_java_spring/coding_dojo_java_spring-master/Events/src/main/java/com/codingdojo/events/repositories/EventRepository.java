package com.codingdojo.events.repositories;

import java.util.List;
import com.codingdojo.events.models.Event;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long>{
	Event findByName(String name);
	
	List<Event> findByStateIs(String name);
	
	List<Event> findByStateNot(String name);

}
