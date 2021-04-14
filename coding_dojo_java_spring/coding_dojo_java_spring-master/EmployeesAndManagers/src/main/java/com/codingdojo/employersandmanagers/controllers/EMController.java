package com.codingdojo.employersandmanagers.controllers;
//Web Stuff
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
//Needed user-defined classes
import com.codingdojo.employersandmanagers.models.*;
import com.codingdojo.employersandmanagers.services.*;
//Other Java classes needed
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EMController {
	private final EmployeeService es;
	public EMController(EmployeeService es) {
		this.es = es;
	}
	
	@RequestMapping(value="/{id}")
	public String showEmployee(@PathVariable("id") Long id) {
		es.showRelationships();
		return "This is a test";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addEmployee(@RequestParam("fn") String fn,
			@RequestParam("ln") String ln,
			@RequestParam("manager") Long id) {
		es.create(fn,ln,id);
		return "This is a test";
	}
	
}
