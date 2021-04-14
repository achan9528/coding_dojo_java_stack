package com.codingdojo.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DojoSurveyController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="name") String name,
			@RequestParam(value="dojoLocation") String dojoLoc, 
			@RequestParam(value="favoriteLanguage") String favLang, 
			@RequestParam(value="comments") String comments,
			RedirectAttributes redirectAttributes) {
		
		System.out.println(name);
		System.out.println(dojoLoc);
		System.out.println(favLang);
		
		try {
			String[] dojos = {"San Jose","Seattle","Orange County"};
			String[] langs = {"Python", "Java", "Javascript"};
			
			redirectAttributes.addFlashAttribute("name",name);
			redirectAttributes.addFlashAttribute("dojo",dojos[Integer.parseInt(dojoLoc)-1]);
			redirectAttributes.addFlashAttribute("fav",langs[Integer.parseInt(favLang)-1]);
			redirectAttributes.addFlashAttribute("comments",comments);
			
			return "redirect:/results";
		} catch(Exception e) {
			redirectAttributes.addAttribute("error",e.toString());
			return "redirect:/";
		}
	}
	
	@RequestMapping("/results")
	public String results() {
		return "results.jsp";
	}
}
