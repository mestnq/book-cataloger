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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class RESTController {
    private final BookService bookService;
    
    public RESTController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/books")
    private Iterable<Book> list() {
        Iterable<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    @GetMapping("/books/{id}")
    protected Optional<Book> listBooks(@PathVariable Long id) {
        return bookService.getById(id);
    }
    
//    @GetMapping("/{id}")
//    private Optional<Book> getById(@PathVariable("id") Long id) {
//        return bookService.getById(id);
//    }
//
//    @PostMapping("/remove/{id}")
//    private void delete(@PathVariable("id") Long id) {
//        bookService.remove(id);
//    }
//
//    @GetMapping("/change/{id}")
//    private void change(@PathVariable("id") Long id, @RequestBody BookForm form) {
//        bookService.change(id, form);
//    }
    
//    @PostMapping("/update/{id}")
//    private void update(@PathVariable("id") Long id) {
//        bookService.getById(id).ifPresent(book -> {
//            book.setBought(!book.isBought());
//            bookService.save(book);
//        });
//    }
    
//    @PostMapping("/add")
//    private void add(@RequestBody BookForm form) {
//        bookService.add(form);
//    }

    @PostMapping("/books/add")
    protected void addBook(HttpServletRequest req, HttpServletResponse resp) {
        BookForm bookForm = getBookFromRequest(req);

        logRequestParams(req);

        bookService.add(bookForm);
        try {
            resp.sendRedirect("/");
        }
        catch (IOException ignored) {

        }
    }

    @PostMapping("/books/update")
    protected void updateBook(HttpServletRequest req, HttpServletResponse resp) {
        BookForm bookForm = getBookFromRequest(req);

        logRequestParams(req);

        if (Objects.equals(req.getParameter("books-delete"), "on")) {
            bookService.remove(bookForm.getId());
        } else {
            bookService.updateBook(bookForm);
        }
        try {
            resp.sendRedirect("/update");
        }
        catch (IOException ignored) {

        }
    }

    private BookForm getBookFromRequest(HttpServletRequest req) {
        BookForm bookForm = new BookForm();

        String id = req.getParameter("books-id");
        if (id != null) {
            bookForm.setId(Long.parseLong(id));
        }

        bookForm.setName(req.getParameter("book-name"));
        bookForm.setGenre(req.getParameter("book-genre"));
        bookForm.setReturned(req.getParameter("book-took"));
        bookForm.setTook(req.getParameter("book-returned"));

        return bookForm;
    }

    private void logRequestParams(HttpServletRequest req) {
        Map<String, String[]> map = req.getParameterMap();
        List<String> params = new ArrayList<>();
        for (String key : map.keySet()) {
            params.add(key + " " + Arrays.toString(map.get(key)));
        }
    }
}