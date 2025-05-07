package com.fintrack.form.tableManager;

import com.fintrack.form.dataBaseManager.DBConnection;
import com.fintrack.form.dataBaseManager.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class CategoryTable {
    DBConnection db;
    private static CategoryTable instance;
    Session session = Session.getInstance();

    public static CategoryTable getInstance() throws SQLException {
        if (instance == null){
            instance = new CategoryTable();
        }
        return instance;
    }

    public CategoryTable() throws SQLException {
        this.db = new DBConnection("/form/fintrackDatabase.db");
    }

    public ArrayList<Object[]> getAllDataKategori() throws SQLException {
        ArrayList<Object[]> temp = new ArrayList<>();
        ArrayList<Object[]> data = db.RQuery("SELECT * FROM kategori");

        for (Object[] i : data){
            if(i[2].toString().equals(Session.getInstance().getUsername())){
                temp.add(i);
            }
        }
        return temp;
    }

    public Boolean addKategori(Double limit, String namaKategori) throws SQLException {
        String user = session.getUsername();
        if (user == null){
            return false;
        }else{
            db.CUDQuery("INSERT INTO kategori VALUES (?,?,?)",new String[] {namaKategori,limit.toString(),user}, "TEXT NUMERIC TEXT");
            return true;
        }
    }

}
