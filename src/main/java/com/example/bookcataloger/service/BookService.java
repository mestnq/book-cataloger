package com.example.bookcataloger.service;

import com.example.bookcataloger.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookcataloger.form.BookForm;
import com.example.bookcataloger.repository.BookRepository;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    
    public Book add(BookForm form) {
        Book book = new Book(form);
        return bookRepository.save(book);
    }
    
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    public void change(Long id) {
        bookRepository.deleteById(id);//TODO: поменять на изменение
    }
    
    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }
    
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
