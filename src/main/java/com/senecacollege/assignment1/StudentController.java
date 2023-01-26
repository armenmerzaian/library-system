package com.senecacollege.assignment1;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class StudentController {

    @FXML
    private ListView<Material> myMaterialListView;
    @FXML
    private TextField searchBox;
    @FXML
    private ListView<Material> allMaterialListView;
    @FXML
    private ListView<Request> myRequestsListView;


    private static Student currentStudent;

    //private ArrayList<Material> myMaterials;
    private Material selected;

    @FXML
    private void initialize(){

        /*myMaterials = new ArrayList<>(currentStudent.getCheckedOut());
        populateMyMaterial();

        if(currentStudent.getMyRequests() != null){
            populateMyRequests();
        }*/
        myMaterialListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        populateMyMaterial();
        myMaterialListView.getSelectionModel().getSelectedItems().addListener(
                (ListChangeListener.Change<? extends Material> change) -> {
                    ObservableList<Material> oList = myMaterialListView.getSelectionModel().getSelectedItems();
                    if(oList != null){
                        System.out.println(oList);
                    } else {
                        System.out.println(myMaterialListView.getSelectionModel().getSelectedItem());
                    }
                }
        );

        myRequestsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        populateMyRequests();
        myRequestsListView.getSelectionModel().getSelectedItems().addListener(
                (ListChangeListener.Change<? extends Request> change) -> {
                    ObservableList<Request> oList = myRequestsListView.getSelectionModel().getSelectedItems();
                    if(oList != null){
                        System.out.println(oList);
                    } else {
                        System.out.println(myRequestsListView.getSelectionModel().getSelectedItem());
                    }
                }
        );


        allMaterialListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        populateAllMaterials(LibrarySystem.materials);
        allMaterialListView.getSelectionModel().getSelectedItems().addListener(
                (ListChangeListener.Change<? extends Material> change) -> {
                    ObservableList<Material> oList = allMaterialListView.getSelectionModel().getSelectedItems();
                    if(oList != null){
                        selected = oList.get(0);
                        System.out.println(oList);
                    } else {
                        System.out.println(allMaterialListView.getSelectionModel().getSelectedItem());
                    }
                }
        );
    }

    public void forceLoad(){
        //myMaterials = new ArrayList<>(currentStudent.getCheckedOut());
        populateMyMaterial();
        //populateMyRequests();
    }

    public static void setCurrentStudent(Student student){
        StudentController.currentStudent = student;
    }

    private void populateMyMaterial(){
        //myMaterialListView.getItems().clear();
        /*for(Material mt : myMaterials){
            myMaterialListView.getItems().add(mt);
        }*/

        ObservableList<Material> myItems = FXCollections.observableArrayList(currentStudent.getCheckedOut());
        myMaterialListView.setItems(myItems);
    }

    private void populateAllMaterials(ArrayList<Material> materialList){
        ObservableList<Material> items = FXCollections.observableArrayList(materialList);
        allMaterialListView.setItems(items);
    }

    private void populateMyRequests(){
        /*myRequestsListView.getItems().clear();
        for(Request rq : currentStudent.getMyRequests()){
            myRequestsListView.getItems().add(rq);
        }*/
        ObservableList<Request> myRequests = FXCollections.observableArrayList(currentStudent.getMyRequests());
        myRequestsListView.setItems(myRequests);
    }

    public void searchMaterials(){
        String searchString = searchBox.getText();
        ArrayList<Material> filteredList = new ArrayList<>();

        for(int i = 0; i < LibrarySystem.getMaterialsLength(); i++){
            if(LibrarySystem.materials.get(i) instanceof LibraryBook lb){
                if(lb.getTitle().toLowerCase().contains(searchString.toLowerCase())){
                    filteredList.add(lb);
                }
            } else if(LibrarySystem.materials.get(i) instanceof DVD dv){
                if(dv.getTitle().toLowerCase().contains(searchString.toLowerCase())){
                    filteredList.add(dv);
                }
            } else if(LibrarySystem.materials.get(i) instanceof CD cd){
                if(cd.getTitle().toLowerCase().contains(searchString.toLowerCase())){
                    filteredList.add(cd);
                }
            } else if(LibrarySystem.materials.get(i) instanceof Magazine mg){
                if(mg.getTitle().toLowerCase().contains(searchString.toLowerCase())){
                    filteredList.add(mg);
                }
            }
        }
        System.out.println(filteredList);
        populateAllMaterials(filteredList);
    }

    public void requestToReserve() throws ParseException {
        Request newRequest = new Request(currentStudent.getStudentID(), selected.getMaterialCode());
        currentStudent.addRequest(newRequest);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Request Sent!");
        a.show();
        populateMyRequests();
    }

    public void deleteRequest(){
        Request toDelete = myRequestsListView.getSelectionModel().getSelectedItem();
        LibrarySystem.requests.remove(toDelete);
        currentStudent.getMyRequests().remove(toDelete);
        populateMyRequests();
        LibrarySystem.saveStudentsToFile();
        LibrarySystem.saveRequeststoFile();
    }

    public void logout() throws IOException {
        LibrarySystem.changeScene("libraryLogin.fxml");
    }
}
