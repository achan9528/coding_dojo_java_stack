package com.codingcontroller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DojoController {
	public static void main(String[] args) {
		SpringApplication.run(DojoController.class, args);
	};
	
	@RequestMapping("/{text}")
	public String isAwesome(@PathVariable("text") String text) {
		if (text.contains("-")){
			String text1 = text.substring(0,text.indexOf("-"));
			String text2 = text.substring(text.indexOf("-")+1);
			if (text2.equals("dojo")) {
				return text1 + " " + text2 + " is located in Southern California!";			
			} else {
				return text1.substring(0,1) + text2.substring(0,1) + " is the headquarters";
			}
		} else {
			return "The " + text + " is awesome!";
		}
	};	

}

