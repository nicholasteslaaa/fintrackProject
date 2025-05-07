package com.fintrack.form.uiController;

import com.fintrack.form.dataBaseManager.Session;
import com.fintrack.form.tableManager.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class AddCatatanPageController {
    UserData userData = UserData.getInstance();
    Session session = Session.getInstance();
    MethodCollection method = new MethodCollection();

    @FXML private ComboBox category;
    @FXML private TextField price;
    @FXML private DatePicker date;
    @FXML private TextField description;

    private FormSetController formSetController;

    public AddCatatanPageController() throws SQLException {
    }

    public void setFormSetController(FormSetController controller) {
        this.formSetController = controller;
    }

    @FXML
    private void initialize() {

    }


}
