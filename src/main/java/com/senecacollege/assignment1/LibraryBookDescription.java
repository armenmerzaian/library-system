package com.senecacollege.assignment1;

import javafx.scene.control.TextField;

import java.io.Serializable;

public class LibraryBookDescription implements Serializable {
    private int bookCount;
    private String bookDescription;
    private String librarySection;

    public LibraryBookDescription(int bookCount, String bookDescription, String librarySection) {
        this.bookCount = bookCount;
        this.bookDescription = bookDescription;
        this.librarySection = librarySection;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getLibrarySection() {
        return librarySection;
    }

    public void setLibrarySection(String librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public String toString() {
        return " Description: '" + bookDescription + '\'' +
                "\n Section: '" + librarySection + '\'' +
                "\n Book Count: " + bookCount;
    }
}
