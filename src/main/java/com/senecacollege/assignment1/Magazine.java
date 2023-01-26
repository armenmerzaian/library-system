package com.senecacollege.assignment1;

import java.io.Serializable;

public class Magazine extends Material implements Serializable {

    enum Category {
        news, sports, cooking, art, fashion, technology, health, business, literature, science, education, youth
    }
    private String title;
    private Category category;
    private int issue;
    private int year;

    private static MagazineDescription description;

    public Magazine(String title, Category category, int issue, int year, Librarian lib) {
        super(lib);
        this.title = title;
        this.category = category;
        this.issue = issue;
        this.year = year;
    }

    public void setDescription(int count, String desc, String section){
        Magazine.description = new MagazineDescription(count, desc, section);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(MagazineDescription description){
        Magazine.description = description;
    }

    public String getDescription(){
        return Magazine.description.toString();
    }

    public String getMagazineDescription(){
        return Magazine.description.getMagazineDescription();
    }

    public String getLibrarySection(){
        return Magazine.description.getLibrarySection();
    }

    public int getMagazineCount(){
        return Magazine.description.getMagazineCount();
    }

    @Override
    public String toString() {
        return   getTitle() +
                "  #" + issue +
                "\t (" + year + ")" +
                "\n Category: " + (category == Magazine.Category.news ? "News" :
                        (category == Magazine.Category.cooking ? "Cooking" :
                                (category == Magazine.Category.art ? "Art" :
                                        (category == Magazine.Category.fashion ? "Fashion" :
                                                (category == Magazine.Category.technology ? "Technology" :
                                                        (category == Magazine.Category.health ? "Health" :
                                                                (category == Magazine.Category.business ? "Business" :
                                                                        (category == Category.literature ? "Literature" :
                                                                                (category == Category.science ? "Science" :
                                                                                        (category == Category.education ? "Education" :
                                                                                                (category == Category.sports ? "Sports" :"Youth"))))))))))) +
                "\n Code: " + getMaterialCode() +
//                "\n" + (getDescription() == null ? "" : getDescription()) +
                "\n" + (isCheckedOut() ? "--Checked Out--" : "In Stock") +
                "\n" + (isCheckedOut() ? getLastCheckout().toString() : (getLastReturn() == null ? "" : "Last Returned: " + getLastReturn().toString()));
    }
}
