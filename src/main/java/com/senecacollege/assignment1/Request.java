package com.senecacollege.assignment1;

import java.io.Serializable;

public class Request implements Serializable {
    int r_studentID;
    int r_materialCode;

    public Request(int r_studentID, int r_materialCode) {
        this.r_studentID = r_studentID;
        this.r_materialCode = r_materialCode;
    }

    public int getR_studentID() {
        return r_studentID;
    }

    public void setR_studentID(int r_studentID) {
        this.r_studentID = r_studentID;
    }

    public int getR_materialCode() {
        return r_materialCode;
    }

    public void setR_materialCode(int r_materialCode) {
        this.r_materialCode = r_materialCode;
    }

    @Override
    public String toString() {
        return "For: " + getR_materialCode() +
                "\n Student: " + getR_studentID();
    }
}
