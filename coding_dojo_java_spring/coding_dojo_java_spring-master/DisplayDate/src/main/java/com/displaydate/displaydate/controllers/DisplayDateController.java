package com.displaydate.displaydate.controllers;

// Spring packages
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

// java packages
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class DisplayDateController {
	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
  @RequestMapping("/date")
  public String getDate(Model model) {
      LocalDateTime d = LocalDateTime.now();
      DateTimeFormatter df = DateTimeFormatter.ofPattern("EEEE, 'the' d 'of' LLLL, u");
//      DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
  String fd = df.format(d);
  model.addAttribute("date", fd);
  return "date.jsp";
  }
  @RequestMapping("/time")
  public String getTime(Model model) {
	  LocalDateTime d = LocalDateTime.now();
	  DateTimeFormatter df = DateTimeFormatter.ofPattern("h:m a");
  String time = df.format(d);
  model.addAttribute("time", time);
  return "time.jsp";
  }
  
//  @RequestMapping("/time")
//  public String  
}
