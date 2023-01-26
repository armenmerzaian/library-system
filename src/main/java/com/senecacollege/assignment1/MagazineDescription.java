package com.senecacollege.assignment1;

public class MagazineDescription {
    private int magazineCount;
    private String magazineDescription;
    private String librarySection;

    public MagazineDescription(int magazineCount, String magazineDescription, String librarySection) {
        this.magazineCount = magazineCount;
        this.magazineDescription = magazineDescription;
        this.librarySection = librarySection;
    }

    public int getMagazineCount() {
        return magazineCount;
    }

    public void setCDCount(int magazineCount) {
        this.magazineCount = magazineCount;
    }

    public String getMagazineDescription() {
        return magazineDescription;
    }

    public void setMagazineDescription(String magazineDescription) {
        this.magazineDescription = magazineDescription;
    }

    public String getLibrarySection() {
        return librarySection;
    }

    public void setLibrarySection(String librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public String toString() {
        return " Description: '" + magazineDescription + '\'' +
                "\n Section: '" + librarySection + '\'' +
                "\n Magazine Count: " + magazineCount;
    }
}
