package com.kmitl.pectjro.Database.Connection;

import com.kmitl.pectjro.Frame.SetupPage.Setting_Template;
import java.sql.*;
import java.io.*;

public class DBConnect {
    private static Connection con;
    private static Setting_Template connect_data;

    public static void createConnect() {
        File info = new File("Database_Setting.dat");
        try (ObjectInputStream data = new ObjectInputStream(new FileInputStream(info))) {
            connect_data = (Setting_Template) data.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + connect_data.host + ":" + connect_data.port + "/" + connect_data.database_name, connect_data.username, connect_data.password);
        } catch (SQLException e) { throw new RuntimeException(e); }
        System.out.println("Successful connect");
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

    public static void main(String[] args) {
        new DBConnect();
    }
}