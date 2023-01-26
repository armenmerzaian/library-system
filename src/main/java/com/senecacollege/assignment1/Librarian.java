package com.senecacollege.assignment1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Librarian extends Employee implements Serializable {

    public Librarian(String firstName, String lastName, LocalDate dob, String username, String password, int employeeID, LocalDate hireDate) {
        super(firstName, lastName, dob, username, password, employeeID, hireDate);
    }

    public void addBook(LibraryBook newBook){
        LibrarySystem.addMaterial(newBook);
        LibrarySystem.addLibraryBook(newBook);
    }

    public void addDVD(DVD newDVD){
        LibrarySystem.addMaterial(newDVD);
        LibrarySystem.addDVD(newDVD);
    }

    public void addCD(CD newCD){
        LibrarySystem.addMaterial(newCD);
        LibrarySystem.addCD(newCD);
    }

    public void addMagazine(Magazine newZine){
        LibrarySystem.addMaterial(newZine);
        LibrarySystem.addMagazine(newZine);
    }

    @Override
    public String toString() {
        return getFirstName() + " " +
                getLastName() + "\n  " +
                "id: " + getEmployeeID() + "\n  " +
                getUsername() + "\n" +
                "Hired: " + getHireDate();
    }

}
