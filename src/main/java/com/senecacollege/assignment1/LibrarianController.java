package com.senecacollege.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;



//used to control librarian dashboard
public class LibrarianController {

    @FXML
    private Button logoutBtn;
    @FXML
    private Button addBookBtn;
    @FXML
    private Button addDVDBtn;
    @FXML
    private Button addCDBtn;
    @FXML
    private Button addMagazineBtn;
    @FXML
    private Button viewAllMaterialsBtn;
    @FXML
    private Button viewAllBooksBtn;
    @FXML
    private Button viewAllDVDsBtn;
    @FXML
    private Button viewAllCDsBtn;
    @FXML
    private Button viewAllMagazinesBtn;
    @FXML
    private ListView<Material> itemListView;
    @FXML
    private TextField returnMaterialCode;
    @FXML
    private Button returnBtn;
    @FXML
    private Button returnClearBtn;
    @FXML
    private Label returnErrorLbl;
    @FXML
    private ChoiceBox<Integer> studentchoice;
    @FXML
    private TextField checkoutMaterialCode;
    @FXML
    private DatePicker issuedate;
    @FXML
    private DatePicker returndate;
    @FXML
    private Label checkoutErrorLbl;
    @FXML
    private ListView<Request> requestListView;


    public void showAddBook() throws IOException {
        AddBookController addBookController = new AddBookController();
        addBookController.showStage();
    }

    public void showAddDVD() throws IOException{
        AddDVDController addDVDController = new AddDVDController();
        addDVDController.showStage();
    }

    public void showAddCD() throws IOException {
        AddCDController addCDController = new AddCDController();
        addCDController.showStage();
    }

    public void showAddMagazine() throws IOException {
        AddMagazineController addMagazineController = new AddMagazineController();
        addMagazineController.showStage();
    }

    @FXML
    private void initialize(){
        //LibrarySystem.loadFromFile();

        for(Student st : LibrarySystem.students){
            studentchoice.getItems().add(st.getStudentID());
        }

        for(Request rq : LibrarySystem.requests){
            requestListView.getItems().add(rq);
        }

        issuedate.setValue(LocalDate.now());
        returndate.setValue(LocalDate.now().plusDays(21));

    }

    public void checkout_clearFields(){
        studentchoice.setValue(null);
        checkoutMaterialCode.setText("");
        issuedate.setValue(LocalDate.now());
        returndate.setValue(LocalDate.now().plusDays(21));
    }

    public void checkoutMaterial(){
        int i, count = 0;
        for(i = 0; i < LibrarySystem.getMaterialsLength(); i++){
            if (LibrarySystem.materials.get(i).getMaterialCode() == Integer.parseInt(checkoutMaterialCode.getText())){
                count++;
                if (LibrarySystem.materials.get(i).isCheckedOut()){
                    checkoutErrorLbl.setTextFill(Color.ORANGE);
                    checkoutErrorLbl.setText("Material is Already Checked-Out.");
                } else {
                    LibrarySystem.materials.get(i).setCheckedOut(true);
                    LibrarySystem.materials.get(i).incrementCheckoutCount();
                    LibrarySystem.materials.get(i).setLastCheckout(issuedate.getValue());
                    LibrarySystem.materials.get(i).setLastReturn(returndate.getValue());
                    for(int j = 0; j < LibrarySystem.students.size(); j++){
                        if(LibrarySystem.students.get(j).getStudentID() == studentchoice.getValue()){
                            Student stu = LibrarySystem.students.get(j);
                            stu.addToCheckedOut(LibrarySystem.materials.get(i));
                        }
                    }
                    for(int j = 0; j < LibrarySystem.students.size(); j++){
                        if(LibrarySystem.accounts.get(j) instanceof Student stu){
                            if(stu.getStudentID() == studentchoice.getValue()){
                                stu.addToCheckedOut(LibrarySystem.materials.get(i));
                            }
                        }
                    }
                    /*for(Student st : LibrarySystem.students){
                        if(st.getStudentID() == studentchoice.getValue()){
                            LibrarySystem.accounts.remove(st);
                            st.addToCheckedOut(LibrarySystem.materials.get(i));
                            LibrarySystem.accounts.add(st);
                        }
                    }*/
                    LibrarySystem.saveToFile();
                    LibrarySystem.saveStudentsToFile();

                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText(LibrarySystem.materials.get(i).getMaterialCode() + " Checked-Out Successfully!");
                    a.show();
                    checkout_clearFields();
                }
                break;
            }
        }
        if (count < 1){
            checkoutErrorLbl.setText("Material Code Could Not Be Found.");
        }

    }

    public void setCheckoutErrorLbl(){
        checkoutErrorLbl.setText("");
    }

    public void logout() throws IOException {
        LibrarySystem.changeScene("libraryLogin.fxml");
    }

    public void displayAllMaterials(){
        itemListView.getItems().clear();
        for(Material mt : LibrarySystem.materials){
            itemListView.getItems().add(mt);
        }

    }
    public void displayAllBooks(){
        itemListView.getItems().clear();
        for(Material lb : LibrarySystem.libraryBooks){
            itemListView.getItems().add(lb);
        }
    }
    public void displayAllDVDs(){
        itemListView.getItems().clear();
        for(Material dv : LibrarySystem.dvds){
            itemListView.getItems().add(dv);
        }
    }
    public void displayAllCDs(){
        itemListView.getItems().clear();
        for(Material cd : LibrarySystem.cds){
            itemListView.getItems().add(cd);
        }
    }
    public void displayAllMagazines(){
        itemListView.getItems().clear();
        for(Material mg : LibrarySystem.magazines){
            itemListView.getItems().add(mg);
        }
    }

    public void returnMaterial(){
        int count = -1, i = 0, mc = Integer.parseInt(returnMaterialCode.getText());
        for(i = 0; i < LibrarySystem.materials.size(); i++){
            if(LibrarySystem.materials.get(i).getMaterialCode() == mc){
                if(LibrarySystem.materials.get(i).isCheckedOut()){
                    LibrarySystem.materials.get(i).setCheckedOut(false);
                    LibrarySystem.materials.get(i).setLastReturn(LocalDate.now());
                    for(Student st : LibrarySystem.students){
                        for(Material stm : st.getCheckedOut()){
                            if(stm.equals(LibrarySystem.materials.get(i))){
                                st.removeFromCheckedOut(stm);
                                break;
                            }
                        }
                    }
                    count = 1;
                    if(LibrarySystem.materials.get(i) instanceof LibraryBook lb){
                        int index = LibrarySystem.libraryBooks.indexOf(lb);
                        LibrarySystem.libraryBooks.get(index).setCheckedOut(false);
                        LibrarySystem.libraryBooks.get(index).setLastReturn(LocalDate.now());
                    } else if(LibrarySystem.materials.get(i) instanceof DVD dv){
                        int index = LibrarySystem.dvds.indexOf(dv);
                        LibrarySystem.dvds.get(index).setCheckedOut(false);
                        LibrarySystem.dvds.get(index).setLastReturn(LocalDate.now());
                    } else if(LibrarySystem.materials.get(i) instanceof CD cd){
                        int index = LibrarySystem.cds.indexOf(cd);
                        LibrarySystem.cds.get(index).setCheckedOut(false);
                        LibrarySystem.cds.get(index).setLastReturn(LocalDate.now());
                    }else if(LibrarySystem.materials.get(i) instanceof Magazine mg) {
                        int index = LibrarySystem.magazines.indexOf(mg);
                        LibrarySystem.magazines.get(index).setCheckedOut(false);
                        LibrarySystem.magazines.get(index).setLastReturn(LocalDate.now());
                    }
                } else {
                      count = 0;
                      returnErrorLbl.setTextFill(Color.ORANGE);
                      returnErrorLbl.setText("Already In Stock.");
                }
                break;
            }
        }
        if (count == 1){
            returnErrorLbl.setTextFill(Color.GREEN);
            returnErrorLbl.setText(LibrarySystem.materials.get(i).getMaterialCode() + " Returned Successfully.");
            LibrarySystem.saveToFile();
        } else if (count == -1){
            returnErrorLbl.setTextFill(Color.RED);
            returnErrorLbl.setText("Material Code Not Found");
        }
        emptyRMC();
    }

    public void emptyRMC(){
        returnMaterialCode.clear();
    }


}
