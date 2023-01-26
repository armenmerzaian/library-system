package com.senecacollege.assignment1;

import java.io.Serializable;
import java.text.ParseException;

public class LibraryBook extends Book implements Serializable {

    private static LibraryBookDescription description;

    public LibraryBook(Long icbn, String title, String author, Librarian libr) throws ParseException {
        super(icbn, title, author, libr);
    }
    public void setDescription(int count, String desc, String section){
        LibraryBook.description = new LibraryBookDescription(count, desc, section);
    }

    public void setDescription(LibraryBookDescription description){
        LibraryBook.description = description;
    }

    public String getDescription(){
        return LibraryBook.description.toString();
    }

    public String getBookDescription(){
        return LibraryBook.description.getBookDescription();
    }

    public String getLibrarySection(){
        return LibraryBook.description.getLibrarySection();
    }


    public int getBookCount(){
        return LibraryBook.description.getBookCount();
    }


    @Override
    public String toString() {
        return   getTitle() + " by " + getAuthor() +
                "\n ICBN: " + getIcbn() +
                "\n Code: " + getMaterialCode() +
//                "\n" + (getDescription() == null ? "" : getDescription()) +
                 "\n" + (isCheckedOut() ? "--Checked Out--" : "In Stock") +
                 "\n" + (isCheckedOut() ? getLastCheckout().toString() : (getLastReturn() == null ? "" : "Last Returned: " + getLastReturn().toString()));
    }
}
