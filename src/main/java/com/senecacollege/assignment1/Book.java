package com.senecacollege.assignment1;

import java.io.Serializable;

public abstract class Book extends Material implements Serializable {
    private Long icbn;
    private String title;
    private String author;

    public Book(Long icbn, String title, String author, Librarian libr) {
        super(libr);
        this.icbn = icbn;
        this.title = title;
        this.author = author;
    }

    public Long getIcbn() {
        return icbn;
    }

    public void setIcbn(Long icbn) {
        this.icbn = icbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
