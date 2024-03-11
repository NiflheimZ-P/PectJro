package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private final Connection con;
    public CreateTable(Connection con) {
        this.con = con;
    }

    private void updateData(String sql) {
        try {
            Statement execute = con.createStatement();
            execute.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace(); //TODO make error appear here
        }
    }
    public boolean createUserTable(){
        Connection con = DBConnect.createConnect();
        try {
            updateData("CREATE TABLE IF NOT EXISTS User_info (" +
                    "Id int NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE," +
                    "Username VARCHAR(50) NOT NULL," +
                    "Gmail VARCHAR(62) UNIQUE," +
                    "Password VARCHAR(62)," +
                    "Firstname VARCHAR(50)," +
                    "Lastname VARCHAR(50)," +
                    "Image LONGBLOB DEFAULT NULL," +
                    "Project_Done int DEFAULT 0," +
                    "Project_Expired int DEFAULT 0," +
                    "Project_Ontime int DEFAULT 0," +
                    "Admin boolean DEFAULT false);");
            return true;
        } catch (Exception e) { return false; }
    }
}
