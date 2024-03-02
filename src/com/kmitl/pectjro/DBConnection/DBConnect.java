package com.kmitl.pectjro.DBConnection;

import com.kmitl.pectjro.Frame.SetupPage.Setting_Template;

import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConnect {
    private Connection con;
    private Setting_Template connect_data;

    public DBConnect() {
        File info = new File("Database_Setting.dat");
        try (ObjectInputStream data = new ObjectInputStream(new FileInputStream(info))) {
            connect_data = (Setting_Template) data.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + connect_data.host + ":" + connect_data.port + "/" + connect_data.database_name, connect_data.username, connect_data.password);
        } catch (SQLException e) { throw new RuntimeException(e); }

    }

    public HashMap getData(String query) {
        Statement state;
        try {
            state = con.createStatement();
            ResultSet result = state.executeQuery(query);
        } catch (SQLException e) { throw new RuntimeException(e); }
        return new HashMap(); // เพื่อให้มันไม่ error เฉยๆ
    }

    public static void main(String[] args) {
        new DBConnect();
    }
}