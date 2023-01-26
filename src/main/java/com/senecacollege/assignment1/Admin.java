package com.senecacollege.assignment1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Admin extends Employee implements Serializable {

    public Admin(String firstName, String lastName, LocalDate dob, String username, String password, int employeeID, LocalDate hireDate) {
        super(firstName, lastName, dob, username, password, employeeID, hireDate);
    }

    public void addAdmin(Admin newAdmin){
        LibrarySystem.addAccount(newAdmin);
        LibrarySystem.addAdmin(newAdmin);
        LibrarySystem.addEmployee(newAdmin);
    }

    public void addLibrarian(Librarian newLibrarian){
        LibrarySystem.addAccount(newLibrarian);
        LibrarySystem.addLibrarian(newLibrarian);
        LibrarySystem.addEmployee(newLibrarian);
    }

    public void addStudent(Student newStudent){
        LibrarySystem.addAccount(newStudent);
        LibrarySystem.addStudent(newStudent);
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
