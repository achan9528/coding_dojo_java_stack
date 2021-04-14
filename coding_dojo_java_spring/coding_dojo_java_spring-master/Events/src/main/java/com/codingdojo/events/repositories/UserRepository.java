package com.codingdojo.events.repositories;

import java.util.List;
import com.codingdojo.events.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.events.models.Event;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
