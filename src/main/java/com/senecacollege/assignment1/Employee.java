package com.senecacollege.assignment1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public abstract class Employee extends Client implements Serializable{
    private int employeeID;
    private LocalDate hireDate;

    public Employee(String firstName, String lastName, LocalDate dob, String username, String password, int employeeID, LocalDate hireDate) {
        super(firstName, lastName, dob, username, password);
        this.employeeID = employeeID;
        this.hireDate = hireDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
