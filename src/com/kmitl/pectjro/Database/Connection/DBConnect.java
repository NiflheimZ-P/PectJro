package com.kmitl.pectjro.Database.Connection;

import com.kmitl.pectjro.Frame.SetupPage.Setting_Template;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class DBConnect {
    public static Connection con;
    private static Setting_Template connect_data;

    public static boolean createConnect() {
        File info = new File("Database_Setting.dat");
        try (ObjectInputStream data = new ObjectInputStream(new FileInputStream(info))) {
            connect_data = (Setting_Template) data.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + connect_data.host + ":" + connect_data.port + "/" + connect_data.database_name, connect_data.username, connect_data.password);
        } catch (SQLException e) { throw new RuntimeException(e); }
        System.out.println("Created");
        return true;
    }

    public static boolean createConnection(ArrayList<String> info) {
        try {
            DBConnect.con = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", info.get(0), info.get(1), info.get(2)), info.get(3), info.get(4));
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static ResultSet getData(String sql) throws SQLException{
        Statement state = con.createStatement();
        ResultSet result = state.executeQuery(sql);
        return result;
    }

    public static void updateData(String sql) throws SQLException{
        Statement state = con.createStatement();
        state.executeUpdate(sql);
        System.out.println("Successful Update Table");
    }

    public static void close(){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new DBConnect();
    }
}