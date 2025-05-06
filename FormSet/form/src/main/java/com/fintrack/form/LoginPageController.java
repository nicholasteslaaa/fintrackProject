package com.fintrack.form;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;

public class LoginPageController {
    UserData userdata = UserData.getInstance();

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Button loginBtn;

    private FormSetController formSetController;

    public void setFormSetController(FormSetController controller) {
        this.formSetController = controller;
    }

    public LoginPageController() throws SQLException {

    }

    @FXML
    private void initialize() {
        tfUsername.setOnAction(event -> loginBtn.fire());
        pfPassword.setOnAction(event -> loginBtn.fire());
    }

    @FXML
    protected void loginBtn() throws SQLException {
        String username = tfUsername.getText().strip();
        String password = pfPassword.getText().strip();
        if(username.isEmpty() || password.isEmpty()){
            confirmationAlert("username dan password tidak boleh kosong");
        }
        else if(userdata.login(username,password)){
            confirmationAlert("login berhasil!");
        }
        else{
            confirmationAlert("akun tidak ditemukan!");
        }

    }

    void confirmationAlert(String messege){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText(null); // or set a custom header
        alert.setContentText(messege);
        alert.showAndWait();
    }

    @FXML
    protected void registerBtn() throws SQLException {
        String username = tfUsername.getText().strip();
        String password = pfPassword.getText().strip();

        if(username.isEmpty() || password.isEmpty()){
            confirmationAlert("username dan password tidak boleh kosong");
        }
        else if(userdata.register(username,password)){
            confirmationAlert("akun berhasil di daftarkan!");
        }else {
            confirmationAlert("register gagal atau username sudah terdaftar");
        }
        formSetController.addingUserDataToTable();


    }

    public void setKeyAction(Scene scene){
        scene.setOnKeyPressed((KeyEvent event) -> {
            if(event.getCode() == KeyCode.ENTER){

            }
        });
    }

}