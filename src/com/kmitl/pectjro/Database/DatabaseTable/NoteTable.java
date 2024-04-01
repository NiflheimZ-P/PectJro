package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature.Note;
import com.kmitl.pectjro.Frame.Templates.Note_Template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

    private void updateData(String sql) throws SQLException {
        Statement execute = con.createStatement();
        execute.executeUpdate(sql);
    }

    private ResultSet getData(String sql) throws SQLException{
        Statement state = con.createStatement();
        return state.executeQuery(sql);
    }
    public void addNote(int owner_id, String name, String note) throws SQLException, FileNotFoundException {
        PreparedStatement sql = con.prepareStatement("INSERT INTO Note_info VALUES (DEFAULT, ?, ?, ?, DEFAULT);");
        sql.setInt(1, owner_id);
        sql.setString(2, name);
        sql.setString(3, note);
        sql.executeUpdate();
    }

    public void UpdateNote(int note_id, String name, String note) throws SQLException, FileNotFoundException {
        String sql = String.format("UPDATE Note_info SET Name = '%s', Note = '%s' WHERE Id = %s;", name, note, note_id);
        updateData(sql);
    }

    public ArrayList<Note_Template> getAllNote(int id) throws SQLException{
        String sql = String.format("SELECT * FROM Note_info WHERE Owner_id = %s;", id);
        ResultSet result = getData(sql);

        ArrayList<Note_Template> output = new ArrayList<>();
        while (result.next()) {
            Note_Template current = new Note_Template();
            current.id = result.getInt("Id");
            current.ownerid = result.getInt("Owner_id");
            current.name = result.getString("Name");
            current.note = result.getString("Note");
            output.add(current);
        }

        return output;
    }

    public boolean getAccess(int note_id) throws SQLException{
        String sql = String.format("SELECT * FROM Note_info WHERE Id = %s;", note_id);
        ResultSet result = getData(sql);
        result.next();
		return result.getBoolean("Access");
    }

    public void updateAccess(int note_id, boolean stats) throws SQLException{
        PreparedStatement update = con.prepareStatement("UPDATE Note_info SET Access = ? WHERE Id = ?;");
        update.setBoolean(1, stats);
        update.setInt(2, note_id);
        update.executeUpdate();
    }

    public void deleteNote(int note_id) throws SQLException {
        String sql = String.format("DELETE FROM Note_info WHERE Id = %s;", note_id);
        updateData(sql);
    }
}
