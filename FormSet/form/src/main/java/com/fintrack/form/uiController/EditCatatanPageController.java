package com.fintrack.form.uiController;

import com.fintrack.form.dataBaseManager.Session;
import com.fintrack.form.tableManager.CatatanKeuanganTable;
import com.fintrack.form.tableManager.CategoryTable;
import com.fintrack.form.tableManager.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDate;

public class EditCatatanPageController {
    UserData userData = UserData.getInstance();
    Session session = Session.getInstance();
    MethodCollection method = new MethodCollection();
    CatatanKeuanganTable catatanKeuanganTable = CatatanKeuanganTable.getInstance();
    CategoryTable categoryTable = CategoryTable.getInstance();

    @FXML
    private ComboBox<String> category;
    @FXML private TextField priceField;
    @FXML private DatePicker date;
    @FXML private TextField descriptionField;

    private FormSetController formSetController;


    public EditCatatanPageController() throws SQLException {
    }

    public void setFormSetController(FormSetController controller) {
        this.formSetController = controller;
    }

    @FXML
    private void initialize(){

    }

    @FXML
    private void setupValue(String kategori,Double harga,String tanggal,String deskripsi) throws SQLException {

        category.setValue(kategori);
        priceField.setText(String.valueOf(harga));
        date.setValue(LocalDate.parse(tanggal));
        descriptionField.setText(deskripsi);
    }

}
