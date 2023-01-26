package com.senecacollege.assignment1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Student extends Client implements Serializable {

    enum Year{
        first, second, third, forth
    }

    private Year year;
    private int studentID;
    private ArrayList<Material> checkedOut;
    public ArrayList<Request> myRequests;

    public Student(int studentID, String firstName, String lastName, LocalDate dob, String username, String password, Year yr) {
        super(firstName, lastName, dob, username, password);
        this.year = yr;
        this.studentID = studentID;
        checkedOut = new ArrayList<>();
        myRequests = new ArrayList<>();
    }

    public void addRequest(Request newRequest){
        myRequests.add(newRequest);
        LibrarySystem.addRequest(newRequest);
    }

    public void addToCheckedOut(Material mt){
        checkedOut.add(mt);
    }

    public void removeFromCheckedOut(Material mt){
        checkedOut.remove(mt);
    }

    public ArrayList<Material> getCheckedOut(){
        return checkedOut;
    }

    public ArrayList<Request> getMyRequests() {
        return myRequests;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return getFirstName() + " " +
                getLastName() + "\n  " +
                "id: " + getStudentID() + "\n  " +
                getUsername() + "\n" +
                (year == Student.Year.first ? "First Year" : (year == Student.Year.second ? "Second Year" : (year == Student.Year.third ? "Third Year" : "Forth Year")));
    }
}
