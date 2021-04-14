package com.codingdojo.dojosandninjas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

//import org.hibernate.mapping.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.HashMap;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DNController {
	public final NinjaServices nS;
	public final DojoService dS;
	public DNController(NinjaServices nS,
			DojoService dS) {
		this.dS = dS;
		this.nS = nS;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "addDojoForm.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addDojoForm.jsp";
		} else {
			try {
				Dojo newDojo = dS.createDojo(dojo);
				return "redirect:/dojos/" + newDojo.getId();
			} catch (Exception e){
				 return "addDojoForm.jsp";
			}
		}
	}
	
	@RequestMapping(value="/ninjas/new")
	public String newNinjaForm(@ModelAttribute("ninja") Ninja ninja,
			Model model) {
		List<Dojo> allDojos = dS.findAll();
		Map<String,String> dojos = new HashMap<String,String>();
		for (int i = 0; i < allDojos.size(); i++) {
			Dojo t = allDojos.get(i);
			dojos.put(Long.toString(t.getId()), t.getName());
		}
		model.addAttribute("dojos", dojos);
		return "addNinjaForm.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String newNinjaForm(@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
//			return "redirect:/ninjas/new";
			List<Dojo> allDojos = dS.findAll();
			Map<String,String> dojos = new HashMap<String,String>();
			for (int i = 0; i < allDojos.size(); i++) {
				Dojo t = allDojos.get(i);
				dojos.put(Long.toString(t.getId()), t.getName());
			}
			model.addAttribute("dojos", dojos);
			return "addNinjaForm.jsp";
		} else {
			try {
				Ninja newNinja = nS.createNinja(ninja);
				return "redirect:/dojos/" + newNinja.getDojo().getId();
			} catch (Exception e) {
				return "addNinjaForm.jsp";
			}
		}
	}
	
	@RequestMapping(value="/dojos/{id}")
	public String dojos(@PathVariable("id") Long id,
			Model model) {
		Dojo d = dS.findDojo(id);
		model.addAttribute("dojo",d);
		return "dojo.jsp";
	}
	
	@RequestMapping(value="/ninjas/{id}")
	public String ninjas(@PathVariable("id") Long id,
			Model model) {
		Ninja n = nS.findNinja(id);
		model.addAttribute("ninja", n);
		return "ninja.jsp";
	}
}
