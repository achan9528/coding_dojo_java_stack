package com.counter.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session){
		Integer count = (Integer) session.getAttribute("count");
		if (count != null) {
			count++;
			session.setAttribute("count", count);
		} else {
			session.setAttribute("count", 1);
		}
		return "home.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		try {
			Integer count = (Integer) session.getAttribute("count");
			model.addAttribute("count", count.intValue());
		} catch(NullPointerException e) {
			session.setAttribute("count", 0);
			Integer count = (Integer) session.getAttribute("count");
			model.addAttribute("count", count.intValue());
		}
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("count");
		return "redirect:/";
	}
}
