package com.codingdojo.authentication.controllers;

//Web Stuff
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//Needed user-defined classes
import com.codingdojo.authentication.models.*;
import com.codingdojo.authentication.services.*;
import com.codingdojo.authentication.validator.*;
//Other Java classes needed
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoRegController {
	private final UserService us;
	private final UserValidator uv;
	
	public LoRegController(UserService us,
			UserValidator uv) {
		this.us = us;
		this.uv = uv;
	}
	
   @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user,
    		BindingResult result, HttpSession session) {
    	uv.validate(user, result);
    	if (result.hasErrors()) {
    		return "registrationPage.jsp";
    	} else {
    		User u = us.registerUser(user);
    		session.setAttribute("userID", u.getId());
    		return "redirect:/home";
    	}
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, 
    		@RequestParam("password") String password, Model model, 
    		HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
		if (us.authenticateUser(email, password)) {
			User u = us.findByEmail(email);
			session.setAttribute("userID", u.getId());
    		return "redirect:/home";
		} else {
			return "loginPage.jsp";
		}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long uID = (Long)session.getAttribute("userID");
    	User u = us.findById(uID);
    	model.addAttribute("user", u);
    	return "homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.removeAttribute("userID");
    	return "redirect:/login";
    }
}
