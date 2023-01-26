package com.senecacollege.assignment1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class AddMagazineController {
    @FXML
    private TextField title;
    @FXML
    private ChoiceBox<Magazine.Category> categorychoice;
    @FXML
    private TextField issue;
    @FXML
    private TextField year;
    @FXML
    private TextField materialCount;
    @FXML
    private TextField librarianID;
    @FXML
    private TextField magazinecount;
    @FXML
    private TextField section;
    @FXML
    private TextArea descr;
    @FXML
    private Button clearBtn;
    @FXML
    private Button addMagazineBtn;


    private static Librarian currentLibrarian;

    @FXML
    private void initialize() {
        LibrarySystem ls = new LibrarySystem();
        materialCount.setText(Integer.toString(ls.getMaterialsLength() + 1001));
        librarianID.setText(Integer.toString(currentLibrarian.getEmployeeID()));

        categorychoice.getItems().add(Magazine.Category.news);
        categorychoice.getItems().add(Magazine.Category.sports);
        categorychoice.getItems().add(Magazine.Category.cooking);
        categorychoice.getItems().add(Magazine.Category.art);
        categorychoice.getItems().add(Magazine.Category.fashion);
        categorychoice.getItems().add(Magazine.Category.technology);
        categorychoice.getItems().add(Magazine.Category.health);
        categorychoice.getItems().add(Magazine.Category.business);
        categorychoice.getItems().add(Magazine.Category.literature);
        categorychoice.getItems().add(Magazine.Category.science);
        categorychoice.getItems().add(Magazine.Category.education);
        categorychoice.getItems().add(Magazine.Category.youth);
    }

    public void showStage() throws IOException {
        Stage st = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addMagazine.fxml"));
        Scene sc = new Scene(fxmlLoader.load(), 600, 400);
        st.setScene(sc);
        st.setResizable(false);
        st.setTitle("Add Magazine");
        st.show();
    }

    public void closeStage(){
        Stage stg = (Stage) addMagazineBtn.getScene().getWindow();
        stg.close();
    }

    public static void setCurrentLibrarian(Librarian librarian){
        AddMagazineController.currentLibrarian = librarian;
    }

    public void postAddMagazine() throws ParseException, InterruptedException {

        //TODO: validateInput();

        MagazineDescription mgDesc = new MagazineDescription(Integer.parseInt(magazinecount.getText()), descr.getText(), section.getText());
        for(int i = 0; i < Integer.parseInt(magazinecount.getText()); i++){
            Magazine newZine = new Magazine(title.getText(), categorychoice.getValue(), Integer.parseInt(issue.getText()), Integer.parseInt(year.getText()), currentLibrarian);
            newZine.setDescription(mgDesc);
            currentLibrarian.addMagazine(newZine);
        }

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(magazinecount.getText() + (Integer.parseInt(magazinecount.getText()) > 1 ? " entries added." : " entry added."));
        a.show();

        closeStage();
    }

    public void clearFields(){
        title.setText("");
        issue.setText("");
        year.setText("");
        categorychoice.setValue(null);
        magazinecount.setText("");
        section.setText("");
        descr.setText("");
    }
}
