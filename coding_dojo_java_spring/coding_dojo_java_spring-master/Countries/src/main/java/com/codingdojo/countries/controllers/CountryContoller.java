package com.codingdojo.countries.controllers;

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
import com.codingdojo.countries.models.*;
import com.codingdojo.countries.services.*;
//Other Java classes needed
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CountryContoller {
	private final CountryService cs;
	
	public CountryContoller(CountryService cs) {
		this.cs = cs;
	}
	
	@RequestMapping("/")
	public String getResults(Model model) {
		List<Object[]> table = cs.join8();
		System.out.println("Found table with " + table.size() + " rows");
		for (Object[] row: table) {
			System.out.println(row[0]);
			System.out.println(row[1]);
//			System.out.println(row[2]);
//			System.out.println(row[3]);
		}
		return "This is a test";
	}
}
