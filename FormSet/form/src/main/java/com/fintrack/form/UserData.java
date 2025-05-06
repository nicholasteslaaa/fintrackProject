package com.fintrack.form;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class UserData {
    DBConnection db;
    Encryption encrypt;
    private ArrayList<Object[]> allData;

    private static UserData instance;
    private UserData() throws SQLException {
        this.db = new DBConnection("D:/education/college/semester 4/RPLBO/Fintrack/fintrackProject/FormSet/form/fintrackDatabase.db");
        this.encrypt = new Encryption(10);
    }

    public static UserData getInstance() throws SQLException {
        if (instance == null){
            instance = new UserData();
        }
        return instance;
    }

    public ArrayList<Object[]> getUserData() throws SQLException {
        ArrayList<Object[]> result = db.RQuery("SELECT * FROM userData");
        return result;
    }

    public ArrayList<Object[]> getAllData() throws SQLException {
        allData = getUserData();
        return allData;
    }

    public boolean login(String username,String password) throws SQLException {
        String encryptedPassword = encrypt.encryption(password);
        ArrayList<Object[]> data = db.getDataQuery("SELECT * FROM userData WHERE username = ? AND password = ?",new String[] {username,encryptedPassword},"TEXT TEXT");
        System.out.println(data.size());
        if (!data.isEmpty()){
            if(data.get(0)[0].toString().equals(username) && data.get(0)[1].toString().equals(encryptedPassword)){
                System.out.println("login berhasil!");
                return true;
            }
        }
        System.out.println("akun tidak di temukan!");
        return false;
    }

    public boolean register(String username,String password) throws SQLException {
        String encryptedPassword = encrypt.encryption(password);
        ArrayList<Object[]> data = db.getDataQuery("SELECT * FROM userData WHERE username = ? AND password = ?",new String[] {username,encryptedPassword},"TEXT TEXT");
        System.out.println(data.size());
        if (data.size() > 0){
            System.out.println("Username already registered please use other username");
        }else{
            db.CUDQuery("INSERT INTO userData VALUES (?,?)",new String[] {username, encryptedPassword}, "TEXT TEXT");
            ArrayList<Object[]> checkingData = db.getDataQuery("SELECT * FROM userData WHERE username = ? AND password = ?",new String[] {username,encryptedPassword},"TEXT TEXT");
            if (checkingData.size() > 0){
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) throws SQLException {
        UserData d = new UserData();
        d.getUserData();
    }
}
