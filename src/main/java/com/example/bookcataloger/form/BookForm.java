package com.example.bookcataloger.form;

public class BookForm {
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
