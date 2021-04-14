package com.codingcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingcontrollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingController.class, args);
	}

}


//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class HomeController {
//    @RequestMapping("/")
//    public String index(@RequestParam(value="q") String searchQuery) {
//        return "You searched for: " + searchQuery;
//    }
//}

//@RequestMapping("/")
//public String index(@RequestParam(value="q", required=false) String searchQuery) {
//    return "You searched for: " + searchQuery;
//}
////...


//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class HomeController {
//    @RequestMapping("/m/{track}/{module}/{lesson}")
//    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
//    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
//    }
//}