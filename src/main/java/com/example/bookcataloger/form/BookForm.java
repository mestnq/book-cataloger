package com.example.bookcataloger.form;

public class BookForm {
    private Long id;
    private String name;
    private String genre;
    private String returned;
    private String took;

    public BookForm() {
    }
    
    public BookForm(String name, String genre, String returned, String took) {
        this.name = name;
        this.genre = genre;
        this.returned = returned;
        this.took = took;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public void setTook(String took) {
        this.took = took;
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

    public void setName(String name) {
        this.name = name;
    }
}
