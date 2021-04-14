package com.codingdojo.languages.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService langService;
	
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.GET)
	public String index(@ModelAttribute("lang") Language lang,
			Model model) {
		List<Language> langs = langService.allBooks();
		model.addAttribute("langs", langs);
		return "index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String createLanguage(@Valid @ModelAttribute("lang") Language lang,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else{
			langService.createLanguage(lang);
			return "redirect:/languages";		
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.GET)
	public String showLanguage(@PathVariable Long id,
			Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("lang",lang);
		return "show.jsp";
	}
	
	@RequestMapping(value="/languages/{id}/edit", method=RequestMethod.GET)
	public String editPage(@PathVariable("id") Long id,
			Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("lang",lang);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String editLanguage(@Valid @ModelAttribute("lang") Language lang,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			langService.updateLang(lang.getId(), lang.getName(),lang.getCreator(), lang.getCurrentVersion());
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String deleteLanguage(@PathVariable("id") Long id) {
		langService.deleteBook(id);
		return "redirect:/languages";
	}
}
