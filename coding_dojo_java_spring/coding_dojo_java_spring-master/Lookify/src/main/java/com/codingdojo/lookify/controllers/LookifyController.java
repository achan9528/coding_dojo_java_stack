package com.codingdojo.lookify.controllers;

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

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class LookifyController {
	private final SongService ss;
	
	public LookifyController(SongService ss) {
		this.ss = ss;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute String s, 
			BindingResult result, Model model) {
		List<Song> songs = ss.allSongs();
		model.addAttribute("songs",songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String songDescription(@PathVariable Long id,
			Model model) {
		Song s = ss.findSong(id);
		model.addAttribute("song",s);
		return "show.jsp";
	}
	
	@RequestMapping(value="/songs/{id}/delete")
	public String deleteSong(@PathVariable Long id) {
		ss.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/songs/new")
	public String newSongForm(@ModelAttribute Song song,
			BindingResult result) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.PUT)
	public String addNewSong(@Valid @ModelAttribute Song s,
			BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			ss.createSong(s);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchResults(@RequestParam("searchValue") String s) {
		return "redirect:/search?searchValue="+s;
	}
	
	@RequestMapping(value="/search")
	public String searchResults(@RequestParam("searchValue") String s,
			Model model) {
		List<Song> sr = ss.searchArtist(s);
		model.addAttribute("songs", sr);
		return "searchResults.jsp";
	}
	
	@RequestMapping(value="/top")
	public String top(Model model) {
		List<Song> sr = ss.topTen();
		model.addAttribute("songs", sr);
		return "topTen.jsp";
	}
}
