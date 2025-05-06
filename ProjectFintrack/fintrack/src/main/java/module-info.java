module com.fintrack.fintrack {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.fintrack.fintrack to javafx.fxml;
    exports com.fintrack.fintrack;
}