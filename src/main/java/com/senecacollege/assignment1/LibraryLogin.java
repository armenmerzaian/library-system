package com.senecacollege.assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;


import static com.senecacollege.assignment1.LibrarySystem.accounts;


public class LibraryLogin {

    @FXML
    private Label errorLabel;
    @FXML
    private Button button;
    @FXML
    private TextField userText;
    @FXML
    private PasswordField passText;

    public void userLogin(ActionEvent event) throws IOException {
        System.out.println("button pressed");
        checkLogin();
    }

    private void checkLogin() throws IOException {
        String user = userText.getText().toString();
        String pass = passText.getText().toString();

        //loop through every arrayList
        for (int i = 0; i < accounts.size(); i++){
            System.out.println(accounts.get(i));
            if (user.equals(accounts.get(i).getUsername())) {
                if (pass.equals(accounts.get(i).getPassword())) {
                    //check for instance type
                    if (accounts.get(i) instanceof Admin) {
                        LibrarySystem.changeScene("admin.fxml");
                        AdminController.setCurrentAdmin((Admin) accounts.get(i));
                    } else if (accounts.get(i) instanceof Librarian) {
                        AddBookController.setCurrentLibrarian((Librarian) accounts.get(i));
                        AddDVDController.setCurrentLibrarian((Librarian) accounts.get(i));
                        AddCDController.setCurrentLibrarian((Librarian) accounts.get(i));
                        AddMagazineController.setCurrentLibrarian((Librarian) accounts.get(i));
                        LibrarySystem.changeScene("librarian.fxml");
                    } else if (accounts.get(i) instanceof Student st) {
                        int index = LibrarySystem.students.indexOf(st);
                        Student stu = LibrarySystem.students.get(index);
                        StudentController.setCurrentStudent(stu);
                        LibrarySystem.changeScene("student.fxml");
                    }
                }
            }
        }

        errorLabel.setText("Invalid Login!");
    }
}
