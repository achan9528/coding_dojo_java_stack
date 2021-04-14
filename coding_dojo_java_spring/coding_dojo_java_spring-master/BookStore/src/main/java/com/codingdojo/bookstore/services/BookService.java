package com.codingdojo.bookstore.services;

import com.codingdojo.bookstore.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import com.codingdojo.bookstore.models.Book;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    public Book updateBook(Long id, String title, 
    		String desc, String lang, Integer numOfPages) {
    	Book b = findBook(id);
    	b.setTitle(title);
    	b.setDescription(desc);
    	b.setLanguage(lang);
    	b.setNumberOfPages(numOfPages);
    	bookRepository.save(b);
    	return b;
    }
    
}
