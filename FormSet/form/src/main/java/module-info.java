module com.fintrack.form {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.fintrack.form to javafx.fxml;
    exports com.fintrack.form;
    exports com.fintrack.form.dataBaseManager;
    opens com.fintrack.form.dataBaseManager to javafx.fxml;
    exports com.fintrack.form.uiController;
    opens com.fintrack.form.uiController to javafx.fxml;
    exports com.fintrack.form.tableManager;
    opens com.fintrack.form.tableManager to javafx.fxml;
}