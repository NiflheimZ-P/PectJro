//package com.kmitl.pectjro.Database.DatabaseTable;
//
//import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Note;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//public class NoteTable {
//
//    private Connection con;
//    private
//
//    public NoteTable(Connection con){
//        this.con = con;
//    }
//
//    public void updateNote(String sql) throws SQLException {
//        Statement execute = con.createStatement();
//        execute.executeUpdate(sql);
//    }
//
//    private ResultSet getNote(String sql) throws SQLException{
//        Statement state = con.createStatement();
//        return state.executeQuery(sql);
//    }
//    public ArrayList<String> getAllNote(String Note) throws SQLException{
//        String sql = String.format("SELECT * FROM Note_info WHERE Note = %s", Note);
//        ArrayList<String> output = new ArrayList<>();
//        ResultSet result = getNote(sql);
//        while (result.next()) {
//            output.add(result.getString("Note"));
//        }
//        return output;
//    }
//}
