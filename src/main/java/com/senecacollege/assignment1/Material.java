package com.senecacollege.assignment1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public abstract class Material implements Serializable {
    private static int mCode = 1000;
    private Librarian addedBy;
    private int materialCode;

    private int checkoutCount;

    private LocalDate lastCheckout;
    private LocalDate lastReturn;
    private boolean checkedOut;

    public Material(Librarian lib) {
        Material.mCode++;
        this.materialCode = mCode;
        this.addedBy = lib;
        this.checkoutCount = 0;
        this.checkedOut = false;
    }

    public Librarian getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Librarian addedBy) {
        this.addedBy = addedBy;
    }

    public int getMaterialCode(){
        return materialCode;
    }

    public int getCheckoutCount() {
        return checkoutCount;
    }

    public void setCheckoutCount(int checkoutCount) {
        this.checkoutCount = checkoutCount;
    }

    public void incrementCheckoutCount(){
        this.checkoutCount++;
    }

    public LocalDate getLastCheckout() {
        return lastCheckout;
    }

    public void setLastCheckout(LocalDate lastCheckout) {
        this.lastCheckout = lastCheckout;
    }

    public LocalDate getLastReturn() {
        return lastReturn;
    }

    public void setLastReturn(LocalDate lastReturn) {
        this.lastReturn = lastReturn;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
