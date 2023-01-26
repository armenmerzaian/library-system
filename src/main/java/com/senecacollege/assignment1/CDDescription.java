package com.senecacollege.assignment1;

import java.io.Serializable;

public class CDDescription implements Serializable {
    private int cdCount;
    private String cdDescription;
    private String librarySection;

    public CDDescription(int cdCount, String cdDescription, String librarySection) {
        this.cdCount = cdCount;
        this.cdDescription = cdDescription;
        this.librarySection = librarySection;
    }

    public int getCDCount() {
        return cdCount;
    }

    public void setCDCount(int cdCount) {
        this.cdCount = cdCount;
    }

    public String getCDDescription() {
        return cdDescription;
    }

    public void setCDDescription(String cdDescription) {
        this.cdDescription = cdDescription;
    }

    public String getLibrarySection() {
        return librarySection;
    }

    public void setLibrarySection(String librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public String toString() {
        return " Description: '" + cdDescription + '\'' +
                "\n Section: '" + librarySection + '\'' +
                "\n CD Count: " + cdCount;
    }
}
