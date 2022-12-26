package com.example.bookcataloger;

import com.example.bookcataloger.controller.RESTController;
import com.example.bookcataloger.repository.BookRepository;
import com.example.bookcataloger.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTests {
    @Autowired
    private RESTController restController;
    @Autowired
    private BookRepository repository;
    @Autowired
    private BookService service;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkRest() {
        assertThat(restController).isNotNull();
    }

    @Test
    public void get() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postAdd() throws Exception {
        String param = "";
        this.mockMvc.perform(post("/api/books/add")
                        .param("book-name", param)
                        .param("book-genre", "")
                        .param("book-took", "")
                        .param("book-returned", ""))
                .andExpect(status().isFound());
    }
}
