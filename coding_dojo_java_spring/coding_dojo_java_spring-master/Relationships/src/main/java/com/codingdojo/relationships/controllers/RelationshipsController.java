package com.codingdojo.relationships.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

import org.hibernate.mapping.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import java.util.HashMap;

import com.codingdojo.relationships.models.*;
import com.codingdojo.relationships.services.*;

@Controller
public class RelationshipsController {
	private final PersonService pS;
	private final LicenseService lS;
	
	public RelationshipsController(PersonService pS,
			LicenseService lS) {
		this.pS = pS;
		this.lS = lS;
	}
	
	@RequestMapping("/persons/new")
	public String newPersonForm(@ModelAttribute("newPerson") Person p,
			Model model) {
		return "newPersonForm.jsp";
	}
	
	@RequestMapping(value = "/persons/new", method=RequestMethod.POST)
	public String newPerson(@Valid @ModelAttribute("newPerson") Person p,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newPersonForm.jsp";
		} else {
			Person newPerson = pS.createPerson(p);
			return "redirect:/persons/" + newPerson.getId();
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicenseForm(@ModelAttribute("newLicense") License l,
			Model model) {
		HashMap<String, String> persons = new HashMap<String,String>();
		
		List<Person> p = pS.allPersons();
		for (int i = 0; i<p.size();i++) {
			String first = p.get(i).getFirstName();
			String last = p.get(i).getLastName();
			persons.put(Long.toString(p.get(i).getId()), first + " " + last);
		}
		model.addAttribute("persons", persons);
		return "newLicenseForm.jsp";
	}
	
	@RequestMapping(value = "/licenses/new", method=RequestMethod.POST)
	public String newLicense(@Valid @ModelAttribute("newLicense") License l,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newLicenseForm.jsp";
		} else {
			if (l.getPerson().getLicense()!=null) {
				return "redirect:/licenses/new";
			} else {
				License newLicense = lS.createLicense(l);
				return "redirect:/persons/" + newLicense.getPerson().getId();
			}
		}
	}
	
	@RequestMapping(value="/persons/{id}")
	public String showPerson(@PathVariable("id") Long id,
			Model model) {
		Person p = pS.findPerson(id);
		model.addAttribute("person",p);
		return "showPerson.jsp";
	}
}
