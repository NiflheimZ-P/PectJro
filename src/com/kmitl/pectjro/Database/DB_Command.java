package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DB_Command {
    public static HashMap getUserData(String gmail) throws SQLException {
        String sql = "SELECT * FROM User_info WHERE Gmail = '" + gmail + "';";
        ResultSet result = DBConnect.getData(sql);
        HashMap<String, String> output = new HashMap<String, String>();
        result.next();
        String[] get = {"Id", "Username", "Gmail", "Password", "Firstname", "Lastname", "Admin"};
        for (String i: get){
            output.put(i.toLowerCase(), result.getString(i));
        }
        return output;
    }

    public static void addUserData(String username, String gmail, String password, String firstname, String lastname) throws SQLException{
        String sql = String.format("INSERT INTO User_info VALUES (DEFAULT, '%s', '%s', '%s', '%s', '%s', DEFAULT);", username, gmail, password, firstname, lastname);
        DBConnect.updateData(sql);
        System.out.println("Successful insert");
    }
}
