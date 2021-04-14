package com.codingdojo.ninjagold.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Controller
public class NinjaGoldController {
	
	@RequestMapping("/Gold")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("totalGold") == null){
			model.addAttribute("gold", 0);
		} else {
			model.addAttribute("gold", session.getAttribute("totalGold"));
		}
		
		
		if (session.getAttribute("log") == null) {
			System.out.println("bad");
			model.addAttribute("activities", "No activities yet!");
		} else {
			model.addAttribute("activities", session.getAttribute("log"));
		}

		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String findGold(@RequestParam(value="submitValue") String submitValue,
			RedirectAttributes redirectAttributes,
			HttpSession session) {
		try {
			System.out.println("reached");
			String[] activities = {"farm", "cave", "house", "casino"};
			int[] mins = {10, 5, 2, 0};
			int[] maxes = {20, 10, 5, 50}; 
			Random r = new Random();
			int userPressed = Integer.parseInt(submitValue) - 1;
			
			int diff = maxes[userPressed] - mins[userPressed];
			int goldAdded = r.nextInt(diff + 1) + mins[userPressed];
			
			if (userPressed==3) {
				if (r.nextBoolean()) {
					goldAdded *= -1;
				}
			}
			
			int totalGold;
			if (session.getAttribute("totalGold") == null) {
				totalGold = goldAdded;
			} else {
				totalGold = (Integer) session.getAttribute("totalGold") + goldAdded;
			}
			session.setAttribute("totalGold", totalGold);
			
			LocalDateTime ldt = LocalDateTime.now();
			String gl;
			if (goldAdded>0) {
				gl = "earned";
			} else {
				gl = "lost";
			}
			String newActivity = "You entered a " + activities[userPressed] + " and " + gl + " " + Integer.toString(goldAdded) + " gold (" + ldt + ")\n";
			String log;
			
			if (session.getAttribute("log") == null) {
				log = newActivity;
			} else {
				log = newActivity + session.getAttribute("log");
			}

			System.out.println(log);
			session.setAttribute("log", log);

			return "redirect:/Gold";
			
		} catch(Exception e) {
			System.out.println(e.toString());
			redirectAttributes.addFlashAttribute("error", e.toString());
			return "redirect:/Gold";
		}
		

	}
	
}
