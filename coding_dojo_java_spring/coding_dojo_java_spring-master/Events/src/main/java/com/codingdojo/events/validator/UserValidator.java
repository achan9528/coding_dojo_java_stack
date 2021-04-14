package com.codingdojo.events.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.EventsService;

@Component
public class UserValidator implements Validator{
	
	private final EventsService es;
	public UserValidator(EventsService es) {
		this.es = es;
	}
	
	// 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (es.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "InUse");
        }
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
    }	
}
