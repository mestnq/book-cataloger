package com.example.bookcataloger;

import com.example.bookcataloger.controller.RESTController;
import com.example.bookcataloger.model.Book;
import com.example.bookcataloger.repository.BookRepository;
import com.example.bookcataloger.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
class IntegrationTests {
    @Autowired
    private RESTController restController;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
    }

    @Test
    void rest() throws Exception {
        assertThat(restController).isNotNull();
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listOfProducts() throws Exception {
        this.mockMvc.perform(get("/api/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getProductById() throws Exception { //TODO: нужен change
        long id = 3;
        Optional<Book> book = Optional.ofNullable(bookRepository.findByIdBook(id));

        this.mockMvc.perform(get("/change/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":3,\"name\":\"name\",\"bought\":\"false\"}"))
                .andDo(print())
                .andExpect(content().string(containsString(book.get().getName())));
    }

    @Test
    public void postAddProduct() throws Exception { //TODO: нужен change
        String bookName = "nameTest";
        this.mockMvc.perform(post("/api/add")
                        .param("bookName", bookName))
                .andDo(print());

        this.mockMvc.perform(get("/api/").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[*].name", hasItem(bookName)));

    }

}
