package com.fintrack.form.uiController;

import com.fintrack.form.tableManager.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegisterPageControl {
    UserData userdata = UserData.getInstance();

    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordFieldRe_Enter;

    private FormSetController formSetController;

    public void setFormSetController(FormSetController controller) {
        this.formSetController = controller;
    }

    public RegisterPageControl() throws SQLException {
    }


    @FXML
    protected void registerBtn() throws SQLException {
        String username = tfUsername.getText().strip();
        String password = passwordField.getText().strip();
        String passwordRe_enter = passwordFieldRe_Enter.getText().strip();

        if (password.equals(passwordRe_enter)){
            if (userdata.isExist(username)){
                confirmationAlert("Username sudah terdaftar");
            }
            else{
                if (username.length() < 5){
                    confirmationAlert( "username minimal 5 karakter");
                }else if (password.length() < 8){
                    confirmationAlert("password too short! atleast use 8 character minimum");
                }else if(!isValid(password)){
                    confirmationAlert("pasword harus memiliki minimal 6 huruf, 1 angka, dan 1 simbol!");
                }else{
                    if(username.isEmpty() || password.isEmpty()){
                        confirmationAlert("username dan password tidak boleh kosong");
                    }
                    else if(userdata.register(username,password)){
                        confirmationAlert("akun berhasil di daftarkan!");
                    }else {
                        confirmationAlert("register gagal");
                    }
                }
                formSetController.addingUserDataToTable();
            }
        }else{
            confirmationAlert("Password Re-enter tidak sama");
        }


    }

    public boolean isValid(String str){
        int alphaCounter = 0;
        int numberCounter = 0;
        int symbolCounter = 0;


        for(Character i:str.toCharArray()){
            if (isAlpha(i)){
                alphaCounter++;
            }
            if (isNum(i.toString())){
                numberCounter++;
            }
            if (!isAlpha(i) && !isNum(i.toString())){
                symbolCounter++;
            }
        }
        if (alphaCounter < 6 && numberCounter < 1 && symbolCounter < 1){
            return false;
        }
        return true;
    }

    void confirmationAlert(String messege){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText(null); // or set a custom header
        alert.setContentText(messege);
        alert.showAndWait();
    }

    public static boolean isAlpha(Character chr) {
        if (chr == null) {
            return false;
        }

        if (Character.isLetter(chr)){
            return true;
        }
        return true;
    }

    public boolean isNum(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str); // or Integer.parseInt(str) if you want only integers
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



}
