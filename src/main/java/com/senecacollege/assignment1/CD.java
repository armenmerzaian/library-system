package com.senecacollege.assignment1;

import java.io.Serializable;
import java.util.Arrays;

public class CD extends Material implements Serializable {

    enum Genre {
        rock, jazz, heavyMetal, pop, classical, hipHop, country
    }
    private String title;
    private Genre genre;
    private String artist;
    private String recordLabel;
    private int noOfTracks;

    private static CDDescription description;

    public CD(String title, Genre genre, String artist, String recordLabel, int noOfTracks, Librarian lib) {
        super(lib);
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.recordLabel = recordLabel;
        this.noOfTracks = noOfTracks;
    }

    public void setDescription(int count, String desc, String section){
        CD.description = new CDDescription(count, desc, section);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(CDDescription description){
        CD.description = description;
    }

    public String getDescription(){
        return CD.description.toString();
    }

    public String getCDDescription(){
        return CD.description.getCDDescription();
    }

    public String getLibrarySection(){
        return CD.description.getLibrarySection();
    }

    public int getCDCount(){
        return CD.description.getCDCount();
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    public int getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(int noOfTracks) {
        this.noOfTracks = noOfTracks;
    }

    @Override
    public String toString() {
        return   getTitle() +
                "\n by: " + artist +
                "\t (" + (genre == CD.Genre.rock ? "Rock" : (genre == CD.Genre.jazz ? "Jazz" : (genre == CD.Genre.heavyMetal ? "Heavy Metal" : (genre == CD.Genre.pop ? "Pop" : (genre == CD.Genre.classical ? "Classical" : (genre == CD.Genre.hipHop ? "HipHop" : "Country")))))) + ")" +
                "\n Label: " +
                "\n Tracks: " + noOfTracks +
                "\n Code: " + getMaterialCode() +
//                "\n" + (getDescription() == null ? "" : getDescription()) +
                "\n" + (isCheckedOut() ? "--Checked Out--" : "In Stock") +
                "\n" + (isCheckedOut() ? getLastCheckout().toString() : (getLastReturn() == null ? "" : "Last Returned: " + getLastReturn().toString()));
    }
}
