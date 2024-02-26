package com.kmitl.pectjro.Frame;

import java.sql.*;

public class main {
    private static Connection connecto;
    public static void main(String[] args) throws Exception{
        connecto = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store", "test", "200525");
    }
}
