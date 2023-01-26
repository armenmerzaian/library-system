package com.senecacollege.assignment1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Timer;

public class AddBookController {

    @FXML
    private Label reportLbl;
    @FXML
    private Button addBookClearBtn;
    @FXML
    private Button addBookaddBookBtn;
    @FXML
    private TextField icbn;
    @FXML
    private TextField title;
    @FXML
    private TextField author;
    @FXML
    private TextField materialCount;
    @FXML
    private TextField librarianID;
    @FXML
    private TextField bookcount;
    @FXML
    private TextField section;
    @FXML
    private TextArea descr;

    private static Librarian currentLibrarian;

    @FXML
    private void initialize() {
        LibrarySystem ls = new LibrarySystem();
        materialCount.setText(Integer.toString(ls.getMaterialsLength() + 1001));
        librarianID.setText(Integer.toString(currentLibrarian.getEmployeeID()));
    }

    public void showStage() throws IOException {
        Stage st = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addBook.fxml"));
        Scene sc = new Scene(fxmlLoader.load(), 600, 400);
        st.setScene(sc);
        st.setResizable(false);
        st.setTitle("Add Book");
        st.show();
    }

    public void closeStage(){
        Stage stg = (Stage) addBookaddBookBtn.getScene().getWindow();
        stg.close();
    }

    public static void setCurrentLibrarian(Librarian librarian){
        AddBookController.currentLibrarian = librarian;
    }

    public void postAddBook() throws ParseException, InterruptedException {

        //TODO: validateInput();

        LibraryBookDescription lbDesc = new LibraryBookDescription(Integer.parseInt(bookcount.getText()), descr.getText(), section.getText());
        for(int i = 0; i < Integer.parseInt(bookcount.getText()); i++){
            LibraryBook newBook = new LibraryBook(Long.parseLong(icbn.getText()), title.getText(), author.getText(), currentLibrarian);
            newBook.setDescription(lbDesc);
            currentLibrarian.addBook(newBook);
        }

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(bookcount.getText() + (Integer.parseInt(bookcount.getText()) > 1 ? " entries added." : " entry added."));
        a.show();

        closeStage();
    }

    public void clearFields(){
        icbn.setText("");
        title.setText("");
        author.setText("");
        bookcount.setText("");
        section.setText("");
        descr.setText("");
    }


}
