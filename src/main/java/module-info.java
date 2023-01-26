module com.senecacollege.assignment1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.senecacollege.assignment1 to javafx.fxml;
    exports com.senecacollege.assignment1;
}