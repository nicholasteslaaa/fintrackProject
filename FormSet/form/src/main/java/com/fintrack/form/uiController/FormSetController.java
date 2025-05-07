package com.fintrack.form.uiController;

import com.fintrack.form.dataBaseManager.Session;
import com.fintrack.form.tableManager.UserData;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class FormSetController {
    Session session = Session.getInstance();
    @FXML private TableView<Object[]> tableView;
    @FXML private TableColumn<Object[], String> usernameColumn;
    @FXML private TableColumn<Object[], String> passwordColumn;

    @FXML private Label currentUserLabel;

    @FXML
    private VBox mainVBox;

    private Node formNode; // To keep track of the form.fxml content

    private ObservableList<String> usernameList;
    private ObservableList<String> passwordList;

    String getCurrentUserLabel(){
        return currentUserLabel.getText();
    }

    void setCurrentUserLabel(String str){
        currentUserLabel.setText(str);
    }

    @FXML
    public void ShowLoginForm() {
        String path = "/com/fintrack/form/LoginPage.fxml";
        try {
            removeForm();
            formNode = FXMLLoader.load(getClass().getResource(path));
            mainVBox.getChildren().add(formNode); // Add form.fxml below the button
            addingUserDataToTable();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent loginRoot = loader.load();
            // Get controller of login page
            LoginPageController loginController = loader.getController();
            // Inject this controller to login page
            loginController.setFormSetController(this);
            // Show login page inside mainVBox
            mainVBox.getChildren().setAll(loginRoot);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void ShowRegisterForm(){
        String path = "/com/fintrack/form/RegisterPage.fxml";
        try {
            removeForm();
            formNode = FXMLLoader.load(getClass().getResource(path));
            mainVBox.getChildren().add(formNode); // Add form.fxml below the button
            addingUserDataToTable();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent loginRoot = loader.load();
            // Get controller of login page
            RegisterPageControl registerController = loader.getController();
            // Inject this controller to login page
            registerController.setFormSetController(this);
            // Show login page inside mainVBox
            mainVBox.getChildren().setAll(loginRoot);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void deleteAccountForm(){
        String path = "/com/fintrack/form/DeleteAccountPage.fxml";
        try {
            removeForm();
            formNode = FXMLLoader.load(getClass().getResource(path));
            mainVBox.getChildren().add(formNode); // Add form.fxml below the button
            addingUserDataToTable();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent loginRoot = loader.load();
            // Get controller of login page
            DeleteAccountPageController deleteAccountController = loader.getController();
            // Inject this controller to login page
            deleteAccountController.setFormSetController(this);
            // Show login page inside mainVBox
            mainVBox.getChildren().setAll(loginRoot);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void logoutBtn(){
        session.setUsername(null);
        setCurrentUserLabel("Current User: ");
    }


    public void removeForm() {
        if (formNode != null) {
//            mainVBox.getChildren().remove(formNode);
            mainVBox.getChildren().clear();
            formNode = null;
        }
    }

    @FXML
    public void addingUserDataToTable() throws SQLException {
        ArrayList<Object[]> rawData = UserData.getInstance().getAllData();

        System.out.println(rawData);
        for (Object[] i : rawData){
            System.out.print(i[0]+" ");
            System.out.println(i[1]);
        }

        ObservableList<Object[]> table = FXCollections.observableArrayList(UserData.getInstance().getUserData());
        tableView.setItems(table);
        usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0].toString()));
        passwordColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1].toString()));
    }


}
