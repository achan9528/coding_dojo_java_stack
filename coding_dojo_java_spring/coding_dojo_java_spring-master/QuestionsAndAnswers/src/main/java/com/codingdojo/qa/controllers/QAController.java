package com.codingdojo.qa.controllers;

//Web Stuff
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//Needed user-defined classes
import com.codingdojo.qa.models.*;
import com.codingdojo.qa.services.*;
//Other Java classes needed
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Controller
public class QAController {
	private final QuestionService qs;
	private final AnswerService as;
	private final TagService ts;
	
	public QAController(QuestionService qs,
			AnswerService as, TagService ts) {
		this.qs = qs;
		this.as = as;
		this.ts = ts;
	}
	
	@RequestMapping("/questions")
	public String questionsDashboard(Model model) {
		model.addAttribute("questions",qs.findAll());
		return "questionDashboard.jsp";
	}
	
	@RequestMapping("/questions/{qid}")
	public String showQuestion(@ModelAttribute("a") Answer a,
			@PathVariable("qid") Long qid,
			Model model) {
		model.addAttribute("question", qs.findQuestion(qid));
		return "showQuestion.jsp";
	}
	
	@RequestMapping(value="/questions/{qid}", method=RequestMethod.POST)
	public String addAnswer(@Valid @ModelAttribute("a") Answer a,
			BindingResult result,
			Model model, 
			@PathVariable("qid") Long qid) {
		if (result.hasErrors()) {
			model.addAttribute("question", qs.findQuestion(a.getQuestion().getId()));
			return "showQuestion.jsp";
		} else {
			Answer newA = as.createAnswer(a);
//			qs.addAnswer(qs.findQuestion(id), newA);
//			return "redirect:/questions/" + newA.getQuestion().getId();

			return "redirect:/questions/" + newA.getQuestion().getId();
}
	}
	
	@RequestMapping(value="/questions/new")
	public String addQuestionForm(@ModelAttribute("q") Question q,
			@ModelAttribute("tag") Tag t) {
		return "newQuestionForm.jsp";
	}
	
	@RequestMapping(value="/questions/new", method=RequestMethod.POST)
	public String addQuestionForm(@Valid @ModelAttribute("q") Question q,
			BindingResult result1) {
		if (result1.hasErrors()) {
			return "newQuestionForm.jsp";
		} else {
			Question newQ = qs.createQuestion(q);
//			Tag newT = ts.createTag(t);
//			newQ = qs.addTag(newQ, newT);
			return "redirect:/questions/" + newQ.getId();
		}
	}
	
}
