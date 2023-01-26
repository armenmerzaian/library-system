package com.senecacollege.assignment1;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;

public class MaterialWriter {
    private static ObjectOutput output;

    public static void main(String[] args) throws ParseException {

        Librarian lib1 = new Librarian("Armen",
                                        "Merzaian",
                                        LocalDate.of(1975, 8, 15),
                                        "librarian",
                                        "librarian",
                                        2,
                                        LocalDate.of(2002, 1, 19));

        openFile("allMaterials.sir");


        //hard coded data based on real-life objects

        /*
         BOOKS
         */
        LibraryBook lb1 = new LibraryBook(593459873L, "The Lincoln Highway: A Novel", "Amor Towles", lib1);
        lb1.setDescription(
                3,
                "In June, 1954, eighteen-year-old Emmett Watson is driven home to Nebraska by the warden of the juvenile work " +
                        "farm where he has just served fifteen months for involuntary manslaughter. His mother long gone, his father " +
                        "recently deceased, and the family farm foreclosed upon by the bank, Emmett's intention is to pick up his eight-year-old " +
                        "brother, Billy, and head to California where they can start their lives anew. But when the warden drives away, Emmett discovers " +
                        "that two friends from the work farm have hidden themselves in the trunk of the warden's car. Together, they have hatched an altogether " +
                        "different plan for Emmett's future, one that will take them all on a fateful journey in the opposite direction—to the City of New York.",
                "A1");
        addBook(lb1);

        LibraryBook lb2 = new LibraryBook(593396596L, "Crying in H Mart", "Michelle Zauner", lib1);
        lb1.setDescription(
                2,
                "In this exquisite story of family, food, grief, and endurance, Michelle Zauner proves herself far more than a dazzling singer, " +
                        "songwriter, and guitarist. With humor and heart, she tells of growing up one of the few Asian American kids at her school in Eugene, " +
                        "Oregon; of struggling with her mother's particular, high expectations of her; of a painful adolescence; of treasured months spent in her " +
                        "grandmother's tiny apartment in Seoul, where she and her mother would bond, late at night, over heaping plates of food.",
                "A2");
        addBook(lb2);

        LibraryBook lb3 = new LibraryBook(1250790751L, "The Plot: A Novel", "Jean Hanff Korelitz", lib1);
        lb1.setDescription(
                1,
                "Jacob Finch Bonner was once a promising young novelist with a respectably published first book. Today, he’s teaching in a third-rate " +
                        "MFA program and struggling to maintain what’s left of his self-respect; he hasn’t written—let alone published—anything decent in years. " +
                        "When Evan Parker, his most arrogant student, announces he doesn’t need Jake’s help because the plot of his book in progress is a sure thing, " +
                        "Jake is prepared to dismiss the boast as typical amateur narcissism. But then . . . he hears the plot.",
                "A1");
        addBook(lb3);

        LibraryBook lb4 = new LibraryBook(316492922L, "How the Word Is Passed: A Reckoning with the History of Slavery Across America", "Clint Smith", lib1);
        lb1.setDescription(
                2,
                "Beginning in his hometown of New Orleans, Clint Smith leads the reader on an unforgettable tour of monuments and landmarks—those that are honest " +
                        "about the past and those that are not—that offer an intergenerational story of how slavery has been central in shaping our nation’s collective history, " +
                        "and ourselves.",
                "A4");
        addBook(lb4);

         /*
         DVDs
         */
        DVD dvd1 = new DVD("Spider-Man: No Way Home", DVD.AgeGroup.youngAdults, new String[]{"Tom Holland", "Zendaya"}, "Jon Watts", lib1);
        dvd1.setDescription(
                        1,
                        "With Spider-Man's identity now revealed, our friendly neighborhood web-slinger is unmasked and no longer able to separate his " +
                                "normal life as Peter Parker from the high stakes of being a superhero. When Peter asks for help from Doctor Strange, the stakes " +
                                "become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                        "B1");
        addDVD(dvd1);

        DVD dvd2 = new DVD("Matrix 4", DVD.AgeGroup.adults, new String[]{"Keanu Reeves", "Carrie-Anne-Moss"}, "Lana Wachowski", lib1);
        dvd2.setDescription(
                1,
                "To find out if his reality is a physical or mental construct, Mr. Anderson, aka Neo, will have to choose to follow the white rabbit " +
                        "once more. If he's learned anything, it's that choice, while an illusion, is still the only way out of -- or into -- the Matrix. Neo already " +
                        "knows what he has to do, but what he doesn't yet know is that the Matrix is stronger, more secure and far more dangerous than ever before.",
                "B2");
        addDVD(dvd2);

        DVD dvd3 = new DVD("Dune", DVD.AgeGroup.adults, new String[]{"Timothee Chalamet", "Rebecca Ferguson"}, "Denis Villeneuve", lib1);
        dvd3.setDescription(
                1,
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in " +
                        "the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most" +
                        " precious resource in existence, only those who can conquer their own fear will survive.",
                "B2");
        addDVD(dvd3);


        /*
        CDs
        */
        CD cd1 = new CD("Medicine at Midnight", CD.Genre.rock, "Foo Fighters", "Roswell Records", 9, lib1);
        cd1.setDescription(
                2,
                "Medicine at Midnight is the tenth studio album by American rock band Foo Fighters. " +
                        "It was released through RCA and Roswell Records on February 5, 2021",
                "C4");
        addCD(cd1);

        CD cd2 = new CD("Donda", CD.Genre.hipHop, "Ye (Kanye West)", "GOOD Music", 27, lib1);
        cd2.setDescription(
                2,
                "Donda is the tenth studio album by American rapper Kanye West, released through GOOD Music on August 29, 2021, " +
                        "with distribution handled by Def Jam Recordings.",
                "C3");
        addCD(cd2);

        CD cd3 = new CD("enargeia", CD.Genre.classical, "Emily D'Angelo", "Deutsche Grammophon", 12, lib1);
        cd2.setDescription(
                2,
                "",
                "C5");
        addCD(cd3);



        /*
        Magazines
        */
        Magazine mg1 = new Magazine("TIME", Magazine.Category.news, 14122020, 2020, lib1);
        mg1.setDescription(
                1,
                "Meet TIME’s First-Ever Kid of the Year",
                "E2");
        addMagazine(mg1);

        Magazine mg2 = new Magazine("Bon Appetite", Magazine.Category.cooking, 26032019, 2019, lib1);
        mg2.setDescription(
                3,
                "New Spring Classics",
                "E3");
        addMagazine(mg2);

        Magazine mg3 = new Magazine("The New Yorker", Magazine.Category.literature, 15022021, 2021, lib1);
        mg3.setDescription(
                1,
                "Sergio García Sánchez’s 'Eustace Tilley at Ninety-six'",
                "E4");
        addMagazine(mg3);


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

    public static void addBook(LibraryBook book) throws ParseException {
        try {
            output.writeObject(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addDVD(DVD dvd){
        try {
            output.writeObject(dvd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addCD(CD cd) {
        try {
            output.writeObject(cd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMagazine(Magazine mg) {
        try {
            output.writeObject(mg);
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
