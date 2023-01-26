package com.senecacollege.assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LibrarySystem extends Application {

    private static ObjectInputStream input;

        private static Stage stg;

    public static ArrayList<Client> accounts = new ArrayList<>();
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<Librarian> librarians = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();

    public static ArrayList<Material> materials = new ArrayList<>();
    public static ArrayList<LibraryBook> libraryBooks = new ArrayList<>();
    public static ArrayList<DVD> dvds = new ArrayList<>();
    public static ArrayList<CD> cds = new ArrayList<>();
    public static ArrayList<Magazine> magazines = new ArrayList<>();

    public static ArrayList<Request> requests = new ArrayList<>();


    public static void main(String[] args) {
        loadAccounts();
        loadFromFile();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        /*stg.setResizable(false);*/
        Parent root = FXMLLoader.load(getClass().getResource("libraryLogin.fxml"));
        stg.setTitle("Library System");
        stg.setScene(new Scene(root, 408, 341));
        stg.show();
    }

    public static void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(LibrarySystem.class.getResource(fxml));
        stg.setMinHeight(450);
        stg.setMinWidth(600);
        stg.getScene().setRoot(pane);
    }

    private static void loadAccounts() {
        //open file
        try{
            input = new ObjectInputStream(new FileInputStream("accounts.sir"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read line into arrayLists
        try{
            while(true)
            {
                Object obj = input.readObject();
                Client cl = (Client) obj;
                if(cl instanceof Admin admin){
                    accounts.add(admin);
                    admins.add(admin);
                    employees.add(admin);
                } else if(cl instanceof Librarian librarian){
                    accounts.add(librarian);
                    librarians.add(librarian);
                    employees.add(librarian);
                } else if(cl instanceof Student student){
                    accounts.add(student);
                    students.add(student);
                }
            }
        }catch(EOFException e)
        {
            System.out.println("No more records in the file to read");
            System.out.println("Accounts:");
            System.out.println(accounts);
            System.out.println("Admins:");
            System.out.println(admins);
            System.out.println("Librarians:");
            System.out.println(librarians);
            System.out.println("Students:");
            System.out.println(students);

        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //close file
        try{
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile(){
        ObjectOutput output = null;

        //save books.sir
        File f1 = new File("books.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (LibraryBook lb : libraryBooks) {
            try {
                output.writeObject(lb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //save dvds.sir
        File f2 = new File("dvds.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (DVD dv : dvds) {
            try {
                output.writeObject(dv);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //save cds.sir
        File f3 = new File("cds.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f3));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CD cd : cds) {
            try {
                output.writeObject(cd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //save magazines.sir
        File f4 = new File("magazines.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f4));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Magazine mg : magazines) {
            try {
                output.writeObject(mg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //save allMaterials.sir
        File f5 = new File("allMaterials.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f5));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Material mt : materials) {
            try {
                output.writeObject(mt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFromFile(){
        ObjectInputStream input = null;
        try{
            input = new ObjectInputStream(new FileInputStream("allMaterials.sir"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            while(true)
            {
                Object obj = input.readObject();
                if(obj instanceof LibraryBook){
                    LibraryBook book = (LibraryBook) obj;
                    libraryBooks.add(book);
                    materials.add(book);
                } else if(obj instanceof DVD){
                    DVD dvd = (DVD) obj;
                    dvds.add(dvd);
                    materials.add(dvd);
                }else if(obj instanceof CD){
                    CD cd = (CD) obj;
                    cds.add(cd);
                    materials.add(cd);
                } else if(obj instanceof Magazine){
                    Magazine zine = (Magazine) obj;
                    magazines.add(zine);
                    materials.add(zine);
                }
            }
        }catch(EOFException e)
        {
            System.out.println("No more records in the file to read");
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            input = new ObjectInputStream(new FileInputStream("requests.sir"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            while(true)
            {
                Object obj = input.readObject();
                if(obj instanceof Request rq){
                    requests.add(rq);
                }
            }
        }catch(EOFException e)
        {
            System.out.println("No more records in the file to read");
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveAccountsToFile(){
        ObjectOutput output = null;

        // accounts.sir
        File f1 = new File("accounts.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Client cl : accounts) {
            try {
                output.writeObject(cl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveStudentsToFile(){
        ObjectOutput output = null;

        // accounts.sir
        File f1 = new File("students.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Student st : students) {
            try {
                output.writeObject(st);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRequeststoFile(){
        ObjectOutput output = null;

        // accounts.sir
        File f1 = new File("requests.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Request rq : requests) {
            try {
                output.writeObject(rq);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMaterial(Material material){
        materials.add(material);
        saveToFile();
    }

    public static void addLibraryBook(LibraryBook book){
        libraryBooks.add(book);
        saveToFile();
    }

    public static void addDVD(DVD dv){
        dvds.add(dv);
        saveToFile();
    }

    public static void addCD(CD cd){
        cds.add(cd);
        saveToFile();
    }

    public static void addMagazine(Magazine zine){
        magazines.add(zine);
        saveToFile();
    }

    public static void addAdmin(Admin admin){
        admins.add(admin);
    }

    public static void addAccount(Client client) {
        accounts.add(client);
        saveAccountsToFile();
    }

    public static void addEmployee(Employee newEmp) {
        employees.add(newEmp);
    }

    public static void addLibrarian(Librarian newLibrarian) {
        librarians.add(newLibrarian);
    }

    public static void addStudent(Student newStudent) {
        students.add(newStudent);
        saveStudentsToFile();
    }

    public static void addRequest(Request newRequest){
        LibrarySystem.requests.add(newRequest);
        saveRequeststoFile();
        saveStudentsToFile();
    }



    public static int getMaterialsLength(){
        return materials.size();
    }

    public static int getEmployeesLength() {return employees.size();}

    public static int getLibraryBooksLength(){
        return libraryBooks.size();
    }
}
