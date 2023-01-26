package com.senecacollege.assignment1;

import java.io.Serializable;
import java.util.Arrays;

public class DVD extends Material implements Serializable {

    enum AgeGroup {
        babies, kids, youngAdults, adults
    }
    private String title;
    private AgeGroup ageGroup;
    private String[] stars;
    private String director;

    private static DVDDescription description;

    public DVD(String title, AgeGroup ageGroup, String[] stars, String director, Librarian lib) {
        super(lib);
        this.title = title;
        this.ageGroup = ageGroup;
        this.stars = stars;
        this.director = director;
    }

    public void setDescription(int count, String desc, String section){
        DVD.description = new DVDDescription(count, desc, section);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String[] getStars() {
        return stars;
    }

    public void setStars(String[] stars) {
        this.stars = stars;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(DVDDescription description){
        DVD.description = description;
    }

    public String getDescription(){
        return DVD.description.toString();
    }

    public String getDVDDescription(){
        return DVD.description.getDVDDescription();
    }

    public String getLibrarySection(){
        return DVD.description.getLibrarySection();
    }

    public int getDVDCount(){
        return DVD.description.getDVDCount();
    }

    @Override
    public String toString() {
        return   getTitle() +
                "\n Featuring: " + Arrays.toString(stars) +
                "\n by " + director +
                "\n For: " + (ageGroup == AgeGroup.babies ? "Babies" : (ageGroup == AgeGroup.kids ? "Kids" : (ageGroup == AgeGroup.youngAdults ? "Young Adults" : "Adults"))) +
                "\n Code: " + getMaterialCode() +
//                "\n" + (getDescription() == null ? "" : getDescription()) +
                "\n" + (isCheckedOut() ? "--Checked Out--" : "In Stock") +
                "\n" + (isCheckedOut() ? getLastCheckout().toString() : (getLastReturn() == null ? "" : "Last Returned: " + getLastReturn().toString()));
    }
}
