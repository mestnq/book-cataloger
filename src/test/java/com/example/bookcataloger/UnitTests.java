package com.example.bookcataloger;

import com.example.bookcataloger.form.BookForm;
import com.example.bookcataloger.model.Book;
import com.example.bookcataloger.repository.BookRepository;
import com.example.bookcataloger.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UnitTests {
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void addProduct() {
        BookForm bookForm = new BookForm("nameTest", "genreTest", "returnedTest", "tookTest");
        Book book = new Book(bookForm);
        Book saved = bookService.save(book);
        assertThat(saved).isNotNull();
        assertThat(saved.getName().equals(bookForm.getName()));

    }

    @Test
    public void deleteProduct() {
        BookForm bookForm = new BookForm("nameTest1", "genreTest1", "returnedTest1", "tookTest1");
        Book book = new Book(bookForm);
        Optional<Book> product = Optional.of(book);
        Long id = book.getId();
        bookRepository.deleteBook(id);
        Book deletedBook = bookRepository.findByIdBook(id);
        assertThat(deletedBook).isEqualTo(null);
    }
}
