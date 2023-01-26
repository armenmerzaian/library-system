package com.senecacollege.assignment1;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class AccountWriter {
    private static ObjectOutput output;

    public static void main(String[] args) {


        openFile("accounts.sir");
        addAdmin("Armen", "Merzaian", LocalDate.of(1969, 1, 1), "admin", "admin", 1, LocalDate.of(2000, 6, 1));
        addLibrarian("Armen", "Merzaian", LocalDate.of(1975, 8, 15), "librarian", "librarian", 2, LocalDate.of(2002, 1, 19));
        closeFile();
    }

    public static void openFile(String filename){
        File f = new File(filename);
        try {
            output = new ObjectOutputStream(new FileOutputStream(f, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAdmin(String firstName, String lastName, LocalDate dob, String username, String password, int employeeID, LocalDate hireDate){
        Admin admin = new Admin(firstName, lastName, dob, username, password, employeeID, hireDate);
        try {
            output.writeObject(admin);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addLibrarian(String firstName, String lastName, LocalDate dob, String username, String password, int employeeID, LocalDate hireDate){
        Librarian librarian = new Librarian(firstName, lastName, dob, username, password, employeeID, hireDate);
        try {
            output.writeObject(librarian);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void closeFile() {
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
