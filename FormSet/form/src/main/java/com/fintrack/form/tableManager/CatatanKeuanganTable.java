package com.fintrack.form.tableManager;

import com.fintrack.form.dataBaseManager.DBConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class CatatanKeuanganTable {
    DBConnection db;

    public CatatanKeuanganTable() throws SQLException {
        this.db = new DBConnection("/form/fintrackDatabase.db");
    }

    public ArrayList<Object[]> getAllDataCatatan() throws SQLException {
        ArrayList<Object[]> result = db.RQuery("SELECT * FROM kategori");
        return result;
    }


    public boolean isExist(String username) throws SQLException {
        ArrayList<Object[]> usernameDatabase = db.RQuery("SELECT username FROM kategori");

        for (Object[] i : usernameDatabase){
            if (i[0].toString().equals(username)){
                return true;
            }
        }
        return  false;
    }

    public boolean addCatatan(String username,String password) throws SQLException {
      
        return  false;
    }

    public boolean deleteCatatan(String username,String password) throws SQLException {

        return false;
    }

}
