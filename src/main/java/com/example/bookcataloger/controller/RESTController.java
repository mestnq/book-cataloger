package com.example.bookcataloger.controller;

import com.example.bookcataloger.form.BookForm;
import com.example.bookcataloger.model.Book;
import com.example.bookcataloger.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RESTController {
    private final BookService bookService;
    
    public RESTController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/")
    private Iterable<Book> list() {
        Iterable<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }
    
    @GetMapping("/{id}")
    private Optional<Book> getById(@PathVariable("id") Long id) {
        return bookService.getById(id);
    }
    
    @PostMapping("/remove/{id}")
    private void delete(@PathVariable("id") Long id) {
        bookService.remove(id);
    }

    @PostMapping("/change/{id}")
    private void change(@PathVariable("id") Long id) {
        bookService.change(id);
    }
    
    @PostMapping("/update/{id}")
    private void update(@PathVariable("id") Long id) {
        bookService.getById(id).ifPresent(book -> {
            book.setBought(!book.isBought());
            bookService.save(book);
        });
    }
    
    @PostMapping("/add")
    private Book add(@RequestBody BookForm form) {
        return bookService.add(form);
    }
}