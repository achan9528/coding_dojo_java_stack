package com.codingdojo.authentication.repositories;

import java.util.List;
import com.codingdojo.authentication.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
