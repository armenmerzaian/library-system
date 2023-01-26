package com.senecacollege.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.chrono.Chronology;
import java.util.Objects;

public class AdminController {

    @FXML
    private TextField admin_firstname;
    @FXML
    private TextField admin_lastname;
    @FXML
    private DatePicker admin_dateofbirth;
    @FXML
    private DatePicker admin_dateofhire;
    @FXML
    private TextField admin_username;
    @FXML
    private TextField admin_password;
    @FXML
    private TextField admin_passwordR;
    @FXML
    private Label admin_pwErrorLbl;
    @FXML
    private TextField admin_empID;
    @FXML
    private Button admin_clearBtn;
    @FXML
    private Button addAdminBtn;


    @FXML
    private TextField lib_firstname;
    @FXML
    private TextField lib_lastname;
    @FXML
    private DatePicker lib_dateofbirth;
    @FXML
    private DatePicker lib_dateofhire;
    @FXML
    private TextField lib_username;
    @FXML
    private TextField lib_password;
    @FXML
    private TextField lib_passwordR;
    @FXML
    private Label lib_pwErrorLbl;
    @FXML
    private TextField lib_empID;
    @FXML
    private Button lib_clearBtn;
    @FXML
    private Button addLibrarianBtn;

    @FXML
    private TextField stu_firstname;
    @FXML
    private TextField stu_lastname;
    @FXML
    private DatePicker stu_dateofbirth;
    @FXML
    private ChoiceBox<Student.Year> yearchoice;
    @FXML
    private TextField stu_username;
    @FXML
    private TextField stu_password;
    @FXML
    private TextField stu_passwordR;
    @FXML
    private Label stu_pwErrorLbl;
    @FXML
    private TextField stu_stuID;
    @FXML
    private Button stu_clearBtn;
    @FXML
    private Button addStudentBtn;

    @FXML
    private ListView<Client> itemListView;


    private static Admin currentAdmin;

    @FXML
    private void initialize(){
        LibrarySystem ls = new LibrarySystem();
        admin_empID.setText(Integer.toString(ls.getEmployeesLength() + 1));
        lib_empID.setText(Integer.toString(ls.getEmployeesLength() + 1));

        yearchoice.getItems().add(Student.Year.first);
        yearchoice.getItems().add(Student.Year.second);
        yearchoice.getItems().add(Student.Year.third);
        yearchoice.getItems().add(Student.Year.forth);
    }

    public static void setCurrentAdmin(Admin admin){
        AdminController.currentAdmin = admin;
    }

    public void admin_clearFields(){
        admin_firstname.setText("");
        admin_lastname.setText("");
        admin_dateofbirth.setValue(null);
        admin_dateofhire.setValue(null);
        admin_username.setText("");
        admin_password.setText("");
        admin_passwordR.setText("");
        admin_pwErrorLbl.setText("");
    }

    public void lib_clearFields(){
        lib_firstname.setText("");
        lib_lastname.setText("");
        lib_dateofbirth.setValue(null);
        lib_dateofhire.setValue(null);
        lib_username.setText("");
        lib_password.setText("");
        lib_passwordR.setText("");
        lib_pwErrorLbl.setText("");
    }

    public void stu_clearFields(){
        stu_firstname.setText("");
        stu_lastname.setText("");
        stu_dateofbirth.setValue(null);
        yearchoice.setValue(null);
        stu_username.setText("");
        stu_password.setText("");
        stu_passwordR.setText("");
        stu_stuID.setText("");
        stu_pwErrorLbl.setText("");
    }

    public void deleteSelected(){
        Client selected = itemListView.getSelectionModel().getSelectedItem();
        LibrarySystem.accounts.remove(selected);

        if (selected instanceof Student st){
            LibrarySystem.students.remove(st);
        } else if (selected instanceof Librarian lb){
            LibrarySystem.librarians.remove(lb);
            LibrarySystem.employees.remove(lb);
        } else if (selected instanceof Admin ad){
            LibrarySystem.employees.remove(ad);
            LibrarySystem.employees.remove(ad);
        }
        LibrarySystem.saveStudentsToFile();
        LibrarySystem.saveAccountsToFile();
        displayAllEmployees();
    }

    public void postAddAdmin(){
        if (Objects.equals(admin_password.getText(), admin_passwordR.getText())){
            Admin newAdmin = new Admin(admin_firstname.getText(),
                    admin_lastname.getText(),
                    admin_dateofbirth.getValue(),
                    admin_username.getText(),
                    admin_password.getText(),
                    Integer.parseInt(admin_empID.getText()),
                    admin_dateofhire.getValue());
            currentAdmin.addAdmin(newAdmin);

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("New Admin '" + admin_firstname.getText() + " " + admin_lastname.getText() + "' Added Successfully!");
            a.show();

            admin_clearFields();
        } else {
            admin_pwErrorLbl.setText("Passwords Do Not Match.");
        }
    }

    public void postAddLibrarian(){
        if (Objects.equals(lib_password.getText(), lib_passwordR.getText())){
            Librarian newLibrarian = new Librarian(lib_firstname.getText(),
                    lib_lastname.getText(),
                    lib_dateofbirth.getValue(),
                    lib_username.getText(),
                    lib_password.getText(),
                    Integer.parseInt(lib_empID.getText()),
                    lib_dateofhire.getValue());
            currentAdmin.addLibrarian(newLibrarian);

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("New Librarian '" + lib_firstname.getText()+ " " + lib_lastname.getText() + "' Added Successfully!");
            a.show();

            lib_clearFields();
        } else {
            lib_pwErrorLbl.setText("Passwords Do Not Match.");
        }
    }

    public void postAddStudent(){
        if (Objects.equals(stu_password.getText(), stu_passwordR.getText())){
            Student newStudent = new Student(Integer.parseInt(stu_stuID.getText()),
                                            stu_firstname.getText(),
                                            stu_lastname.getText(),
                                            stu_dateofbirth.getValue(),
                                            stu_username.getText(),
                                            stu_password.getText(),
                                            yearchoice.getValue());
            currentAdmin.addStudent(newStudent);

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("New Student '" + stu_firstname.getText() + " " + stu_lastname.getText() + "' Added Successfully!");
            a.show();

            stu_clearFields();
        } else {
            stu_pwErrorLbl.setText("Passwords Do Not Match.");
        }
    }

    public void setStu_pwErrorLbl(){
        stu_pwErrorLbl.setText("");
    }
    public void setLib_pwErrorLbl(){
        lib_pwErrorLbl.setText("");
    }
    public void setAdmin_pwErrorLbl(){
        admin_pwErrorLbl.setText("");
    }

    public void setStu_username(){
        String fName = stu_firstname.getText();
        fName = fName.replaceAll(" ", "").toLowerCase();
        String lName = stu_lastname.getText();
        lName = lName.replace(" ", "").toLowerCase();
        stu_username.setText(fName + lName);
    }

    public void displayAllEmployees(){
        itemListView.getItems().clear();
        for(Employee emp : LibrarySystem.employees){
            itemListView.getItems().add(emp);
        }
    }

    public void displayAllAdmins(){
        itemListView.getItems().clear();
        for(Admin emp : LibrarySystem.admins){
            itemListView.getItems().add(emp);
        }
    }

    public void displayAllLibrarians(){
        itemListView.getItems().clear();
        for(Librarian emp : LibrarySystem.librarians){
            itemListView.getItems().add(emp);
        }
    }

    public void displayAllStudents(){
        itemListView.getItems().clear();
        for(Student st : LibrarySystem.students){
            itemListView.getItems().add(st);
        }
    }

    public void logout() throws IOException {
        LibrarySystem.changeScene("libraryLogin.fxml");
    }
}
