package com.codingcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CodingController {
	public static void main(String[] args) {
		SpringApplication.run(CodingController.class, args);
	};
	
	@RequestMapping("/coding")
	public String coding() {
		return "Hello Coding Dojo!";
	};
	
	@RequestMapping("/coding/python")
	public String codingPython() {
		return "Python/Django was awesome!";
	};

	@RequestMapping("/coding/java")
	public String codingJava() {
		return "Java/Spring is better!";
	};

}
