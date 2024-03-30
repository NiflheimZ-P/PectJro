package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Note;

import java.sql.*;
import java.util.ArrayList;

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
    public void addNote(String Note) throws SQLException{
        String sql = String.format("INSERT INTO Note_info VALUES (DEFAULT,'%s');", Note);
        updateNote(sql);
    }

}
