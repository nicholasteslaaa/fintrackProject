package com.fintrack.form.tableManager;

import com.fintrack.form.dataBaseManager.DBConnection;

import java.sql.SQLException;

public class CategoryTable {
    DBConnection db;
    private static CategoryTable instance;

    private static CategoryTable getInstance() throws SQLException {
        if (instance == null){
            instance = new CategoryTable();
        }
        return instance;
    }

    public CategoryTable() throws SQLException {
        this.db = new DBConnection("/form/fintrackDatabase.db");
    }


}
