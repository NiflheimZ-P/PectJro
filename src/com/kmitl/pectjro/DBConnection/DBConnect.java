package com.kmitl.pectjro.DBConnection;

import java.sql.*;

public class DBConnect {
    private static Connection connecto;

    public static void main(String[] args) throws Exception {
        connecto = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store", "test", "200525");
    }
}