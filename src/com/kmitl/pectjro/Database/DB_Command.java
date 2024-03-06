package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DB_Command {
    public static HashMap getUserData(String gmail) throws SQLException {
        String sql = "SELECT * FROM User_info WHERE Gmail = '" + gmail + "';";
        ResultSet result = DBConnect.getData(sql);
        HashMap<String, String> output = new HashMap<String, String>();
        result.next();
        String[] get = {"Id", "Username", "Gmail", "Password", "Firstname", "Lastname"};
        for (String i: get){
            output.put(i.toLowerCase(), result.getString(i));
        }
        return output;
    }

    public static void addUserData(String username, String gmail, String password, String firstname, String lastname) throws SQLException{
        String sql = String.format("INSERT INTO User_info VALUES (DEFAULT, '%s', '%s', '%s', '%s', '%s');", username, gmail, password, firstname, lastname);
        DBConnect.updateData(sql);
        System.out.println("Successful insert");
    }

    public static boolean testConnection(ArrayList<String> info) {
        try {
            DBConnect.con = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", info.get(0), info.get(1), info.get(2)), info.get(3), info.get(4));
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
