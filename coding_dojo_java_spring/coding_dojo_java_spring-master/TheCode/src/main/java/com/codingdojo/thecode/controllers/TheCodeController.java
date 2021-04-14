package com.codingdojo.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	@RequestMapping(value="/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/TryCode", method=RequestMethod.POST)
	public String tryCode(@RequestParam(value="userInput") String userInput, RedirectAttributes redirectAttributes) {
		if (userInput.equals("bushido")){
			return "redirect:/code";
		} else {
			redirectAttributes.addFlashAttribute("error","Your heart is not true. Keep training.");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/code")
	public String code() {
		return "code.jsp";
	}
	
}
