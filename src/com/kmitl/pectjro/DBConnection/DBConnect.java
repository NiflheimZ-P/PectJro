package com.kmitl.pectjro.DBConnection;
import java.sql.*;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;


public class DBConnect {
    private static Connection connecto;

    public static void main(String[] args) throws Exception {
        connecto = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "2005253");
        Statement state = connecto.createStatement();
        ResultSet result = state.executeQuery("select * from testInfo");
        result.next();
        JSONParser pass = new JSONParser();
        Object obj = pass.parse(result.getString("number"));
        JSONArray a = (JSONArray) obj;
        Object c = 1;
        System.out.println(a);
        System.out.println(c);
    }
}