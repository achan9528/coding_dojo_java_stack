package com.codingdojo.bookstore.controllers;


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
import com.codingdojo.bookstore.models.Book;
import java.util.List;

import com.codingdojo.bookstore.services.BookService;

@Controller
public class BookStoreController {
	private final BookService bookService;
	
	public BookStoreController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public String showBook(@PathVariable("id") Long id,
    		Model model) {
    	Book b = bookService.findBook(id);
    	model.addAttribute("book", b);
        return "show.jsp";
    }

}
