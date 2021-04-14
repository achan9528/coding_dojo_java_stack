package com.codingdojo.authentication.services;

import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository ur;
	
	public UserService(UserRepository ur) {
		this.ur = ur;
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return ur.save(user);
	}
	
	public User findById(Long id) {
		Optional<User> u = ur.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	public User findByEmail(String s) {
		return ur.findByEmail(s);
	}
	
	public boolean authenticateUser(String email, String password) {
		User u = ur.findByEmail(email);
		if (u==null) {
			return false;
		} else {
			if (BCrypt.checkpw(password,u.getPassword())){
				return true;
			} else {
				return false;
			}
		}
	}
}	
