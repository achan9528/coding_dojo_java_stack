package com.codingdojo.events.controllers;

//Web Stuff
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.ui.Model;
//Needed user-defined classes
import com.codingdojo.events.models.*;
import com.codingdojo.events.services.*;
import com.codingdojo.events.validator.*;

//Other Java classes needed
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EventsController {
	private final EventsService es;
	private final UserValidator uv;
	public EventsController(EventsService es,
			UserValidator uv) {
		this.es = es;
		this.uv = uv;
	}
	
	@RequestMapping("/")
	public String loRegPage(@ModelAttribute("regUser") User regUser,
			@ModelAttribute("logUser") User logUser) {
		return "loReg.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("regUser") User regUser,
			BindingResult result, 
			HttpSession session) {
		uv.validate(regUser, result);
		if (result.hasErrors()){
			return "loReg.jsp";
		} else {
			User u = es.registerUser(regUser);
			session.setAttribute("userID", u.getId());
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String registerUser(@RequestParam("logEmail") String email,
			@RequestParam("logPassword") String password, 
			HttpSession session,
			@Valid @ModelAttribute("regUser") User temp,
			BindingResult result) {
		if (es.authenticateUser(email, password)) {
			User u = es.findByEmail(email);
			session.setAttribute("userID", u.getId());
			return "redirect:/home";
		} else {
			return "loReg.jsp";
		}
	}
	
	@RequestMapping("/home")
	public String home(@ModelAttribute("newEvent") Event e,
			Model model, HttpSession session) {
		if (session.getAttribute("userID") != null) {
			User u = es.findById((Long)session.getAttribute("userID"));
			model.addAttribute("events", es.findEventsInState(u.getState()));
			model.addAttribute("otherEvents", es.findEventsOutOfState(u.getState()));
			model.addAttribute("user",u);
			return "events.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id,
			HttpSession session, Model model){
		if (session.getAttribute("userID") != null) {
			User u = es.findById((Long)session.getAttribute("userID"));
			Event e = es.findEventById(id);
			es.joinEvent(u, e);
			return "redirect:/events/" + e.getId();
		} else {
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/events/new",method=RequestMethod.POST)
	public String newEvent(@Valid @ModelAttribute("newEvent") Event e,
			BindingResult result, Model model,
			HttpSession session){
		if (session.getAttribute("userID") != null) {
			User u = es.findById((Long)session.getAttribute("userID"));
			if (result.hasErrors()) {
				model.addAttribute("events", es.findEventsInState(u.getState()));
				model.addAttribute("events", es.findEventsOutOfState(u.getState()));
				return "events.jsp";
			} else {
				e.setHost(u);
				Event newEvent = es.createEvent(e);
				return "redirect:/events/" + newEvent.getId();
			}
		} else {
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/events/{id}")
	public String newEvent(@PathVariable("id") Long id,
			HttpSession session, Model model,
			@ModelAttribute("m") Message m){
		if (session.getAttribute("userID") != null) {
			User u = es.findById((Long)session.getAttribute("userID"));
			Event e = es.findEventById(id);
			model.addAttribute("event", e);
			model.addAttribute("user", u);
			return "event.jsp";
		} else {
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/events/{eventID}/edit")
	public String editEventPage(@PathVariable("eventID") Long id,
			HttpSession session, Model model,
			@ModelAttribute("event") Event event){
		if (session.getAttribute("userID") != null) {
			Event e = es.findEventById(id);
			model.addAttribute("event", e);
			return "editPage.jsp";
		} else {
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/events/{eventID}/edit", method=RequestMethod.POST)
	public String editEvent(@PathVariable("eventID") Long id,
			HttpSession session, Model model,
			@Valid @ModelAttribute("event") Event event,
			BindingResult result){
		if (session.getAttribute("userID") != null) {
			Event e = es.findEventById(id);
			User u = es.findById((Long)session.getAttribute("userID"));
			if (result.hasErrors()) {
				model.addAttribute("event", e);
				model.addAttribute("user", u);
				return "editPage.jsp";
			} else {
				es.updateEvent(e, event);
				return "redirect:/events/" + e.getId();
			}
		} else {
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/events/{id}/delete")
	public String deleteEvent(@PathVariable("id") Long id,
			HttpSession session, Model model){
		if (session.getAttribute("userID") != null) {
			es.deleteEvent(id);
			return "redirect:/home";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/events/{eventId}", method=RequestMethod.POST)
	public String postMessage(@PathVariable("eventId") Long id,
			HttpSession session, Model model,
			@Valid @ModelAttribute("m") Message m, 
			BindingResult result){
		if (session.getAttribute("userID") != null) {
			User u = es.findById((Long)session.getAttribute("userID"));
			Event e = es.findEventById(id);
			if (result.hasErrors()) {
				model.addAttribute("user", u);
				model.addAttribute("event", e);
				System.out.println(result.getAllErrors());
				return "event.jsp";
			} else {
				Message newMessage = es.createMessage(m);
				System.out.println(m.getAuthor());
				return "redirect:/home";
//				return "redirect:/events/" + e.getId();
			}
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userID");
		return "redirect:/";
	}
}
