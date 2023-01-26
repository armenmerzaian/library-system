package com.senecacollege.assignment1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class AddDVDController {

    @FXML
    private TextField title;
    @FXML
    private ChoiceBox<DVD.AgeGroup> agegroup;
    @FXML
    private TextField stars;
    @FXML
    private TextField director;
    @FXML
    private TextField materialCount;
    @FXML
    private TextField librarianID;
    @FXML
    private TextField dvdcount;
    @FXML
    private TextField section;
    @FXML
    private TextArea descr;
    @FXML
    private Button clearBtn;
    @FXML
    private Button addDVDBtn;


    private static Librarian currentLibrarian;

    @FXML
    private void initialize() {
        LibrarySystem ls = new LibrarySystem();
        materialCount.setText(Integer.toString(ls.getMaterialsLength() + 1001));
        librarianID.setText(Integer.toString(currentLibrarian.getEmployeeID()));

        agegroup.getItems().add(DVD.AgeGroup.babies);
        agegroup.getItems().add(DVD.AgeGroup.kids);
        agegroup.getItems().add(DVD.AgeGroup.youngAdults);
        agegroup.getItems().add(DVD.AgeGroup.adults);
    }

    public void showStage() throws IOException {
        Stage st = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addDVD.fxml"));
        Scene sc = new Scene(fxmlLoader.load(), 600, 400);
        st.setScene(sc);
        st.setResizable(false);
        st.setTitle("Add DVD");
        st.show();
    }

    public void closeStage(){
        Stage stg = (Stage) addDVDBtn.getScene().getWindow();
        stg.close();
    }

    public static void setCurrentLibrarian(Librarian librarian){
        AddDVDController.currentLibrarian = librarian;
    }

    public void postAddDVD() throws ParseException, InterruptedException {

        //TODO: validateInput();

        DVDDescription dvdDesc = new DVDDescription(Integer.parseInt(dvdcount.getText()), descr.getText(), section.getText());
        for(int i = 0; i < Integer.parseInt(dvdcount.getText()); i++){
            DVD newDVD = new DVD(title.getText(), agegroup.getValue(), stars.getText().split(","), director.getText(), currentLibrarian);
            newDVD.setDescription(dvdDesc);
            currentLibrarian.addDVD(newDVD);
        }

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(dvdcount.getText() + (Integer.parseInt(dvdcount.getText()) > 1 ? " entries added." : " entry added."));
        a.show();

        closeStage();
    }

    public void clearFields(){
        title.setText("");
        stars.setText("");
        director.setText("");
        agegroup.setValue(null);
        dvdcount.setText("");
        section.setText("");
        descr.setText("");
    }
}
