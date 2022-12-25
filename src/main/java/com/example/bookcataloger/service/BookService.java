package com.example.bookcataloger.service;

import com.example.bookcataloger.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookcataloger.form.BookForm;
import com.example.bookcataloger.repository.BookRepository;

import java.util.Optional;

@Service
public class BookService {
//    @Autowired
//    BookRepository bookRepository;
    
    public void add(BookForm form) {
        Book book = new Book(form);
        BookRepository.bookRepository.saveBook(book);
    }
    
    public void remove(Long id) {
        BookRepository.bookRepository.deleteBook(id);
    }

    public void change(Long id, BookForm form) {
        Book book = new Book(form);
        BookRepository.bookRepository.changeBook(id, book);
    }
    
    public Optional<Book> getById(Long id) {
        return Optional.ofNullable(BookRepository.bookRepository.findByIdBook(id));
    }
    
    public Iterable<Book> getAllBooks() {
        return BookRepository.bookRepository.findAllBooks();
    }
    
    public Book save(Book book) {
        return BookRepository.bookRepository.saveBook(book);
    }
}
