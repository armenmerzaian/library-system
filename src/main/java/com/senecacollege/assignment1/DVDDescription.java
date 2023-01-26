package com.senecacollege.assignment1;

import java.io.Serializable;

public class DVDDescription implements Serializable {
    private int dvdCount;
    private String dvdDescription;
    private String librarySection;

    public DVDDescription(int dvdCount, String dvdDescription, String librarySection) {
        this.dvdCount = dvdCount;
        this.dvdDescription = dvdDescription;
        this.librarySection = librarySection;
    }

    public int getDVDCount() {
        return dvdCount;
    }

    public void setDVDCount(int bookCount) {
        this.dvdCount = bookCount;
    }

    public String getDVDDescription() {
        return dvdDescription;
    }

    public void setDVDDescription(String bookDescription) {
        this.dvdDescription = bookDescription;
    }

    public String getLibrarySection() {
        return librarySection;
    }

    public void setLibrarySection(String librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public String toString() {
        return " Description: '" + dvdDescription + '\'' +
                "\n Section: '" + librarySection + '\'' +
                "\n DVD Count: " + dvdCount;
    }
}
