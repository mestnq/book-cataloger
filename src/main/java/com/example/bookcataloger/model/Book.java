package com.example.bookcataloger.model;

import com.example.bookcataloger.form.BookForm;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    private String name;
    private String genre;
    private String took;
    private String returned;
    private boolean bought;
    
    public Book() {
    }
    
    public Book(BookForm form) {
        this.id = form.getId();
        this.name = form.getName();
        this.genre = form.getGenre();
        this.took = form.getTook();
        this.returned = form.getReturned();
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getTook() {
        return took;
    }

    public String getReturned() {
        return returned;
    }

    public boolean isBought() {
        return bought;
    }
    
    public void setBought(boolean bought) {
        this.bought = bought;
    }
}