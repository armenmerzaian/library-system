package com.senecacollege.assignment1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class AddCDController {

    @FXML
    private TextField title;
    @FXML
    private ChoiceBox<CD.Genre> genrechoice;
    @FXML
    private TextField tracks;
    @FXML
    private TextField artist;
    @FXML
    private TextField recordlabel;
    @FXML
    private TextField materialCount;
    @FXML
    private TextField librarianID;
    @FXML
    private TextField cdcount;
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

        genrechoice.getItems().add(CD.Genre.rock);
        genrechoice.getItems().add(CD.Genre.jazz);
        genrechoice.getItems().add(CD.Genre.heavyMetal);
        genrechoice.getItems().add(CD.Genre.pop);
        genrechoice.getItems().add(CD.Genre.classical);
        genrechoice.getItems().add(CD.Genre.hipHop);
        genrechoice.getItems().add(CD.Genre.country);

    }

    public void showStage() throws IOException {
        Stage st = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addCD.fxml"));
        Scene sc = new Scene(fxmlLoader.load(), 600, 400);
        st.setScene(sc);
        st.setResizable(false);
        st.setTitle("Add CD");
        st.show();
    }

    public void closeStage(){
        Stage stg = (Stage) addDVDBtn.getScene().getWindow();
        stg.close();
    }

    public static void setCurrentLibrarian(Librarian librarian){
        AddCDController.currentLibrarian = librarian;
    }

    public void postAddCD() throws ParseException, InterruptedException {

        //TODO: validateInput();

        CDDescription cdDesc = new CDDescription(Integer.parseInt(cdcount.getText()), descr.getText(), section.getText());
        for(int i = 0; i < Integer.parseInt(cdcount.getText()); i++){
            CD newCD = new CD(title.getText(), genrechoice.getValue(), artist.getText(), recordlabel.getText(), Integer.parseInt(tracks.getText()), currentLibrarian);
            newCD.setDescription(cdDesc);
            currentLibrarian.addCD(newCD);
        }

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(cdcount.getText() + (Integer.parseInt(cdcount.getText()) > 1 ? " entries added." : " entry added."));
        a.show();

        closeStage();
    }

    public void clearFields(){
        title.setText("");
        tracks.setText("");
        artist.setText("");
        genrechoice.setValue(null);
        recordlabel.setText("");
        cdcount.setText("");
        section.setText("");
        descr.setText("");
    }
}
