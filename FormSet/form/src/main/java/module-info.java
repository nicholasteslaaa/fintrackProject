module com.fintrack.form {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.fintrack.form to javafx.fxml;
    exports com.fintrack.form;
}