package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature.Note;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class NoteTable {

    private Connection con;
    public Note note;
    private Statement stm;
    private ResultSet rs;
    public NoteTable(Connection con){
        this.con = con;
    }

    private void updateNote(String sql) throws SQLException {
        Statement execute = con.createStatement();
        execute.executeUpdate(sql);
    }

    private ResultSet getNote(String sql) throws SQLException{
        Statement state = con.createStatement();
        return state.executeQuery(sql);
    }
    public void addNote(int id, String name, String note) throws SQLException, FileNotFoundException {
        PreparedStatement sql = con.prepareStatement("INSERT INTO Note_info VALUES (DEFAULT, ?, ?, ?, DEFAULT);");
        sql.setInt(1, id);
        sql.setString(2, name);
        sql.setString(3, note);
        sql.executeUpdate();
    }

    public void UpdateNote(String name, String note, int id) throws SQLException, FileNotFoundException {
        String sql = String.format("UPDATE Note_info SET Name = '%s', Note = '%s' WHERE Id = %s;", name, note, id);
        updateNote(sql);
    }
}
