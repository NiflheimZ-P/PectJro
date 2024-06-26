package com.kmitl.pectjro.Database.Connection;

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
            e.printStackTrace();
        }
    }
    public boolean createUserTable(){
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

    public boolean createProjectTable(){
        try{
            updateData("CREATE TABLE IF NOT EXISTS Project_info (" +
                    "Id int NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE," +
                    "Creator int NOT NULL," +
                    "Name VARCHAR(50) NOT NULL," +
                    "Description MEDIUMTEXT," +
                    "Start DATE NOT NULL," +
                    "Expired DATE NOT NULL," +
                    "Note LONGTEXT);");
            return true;
        } catch (Exception e) {
            return false;}
    }

    public boolean createStepTable(){
        try{
            updateData("CREATE TABLE IF NOT EXISTS Step_info (" +
                    "Id int NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE," +
                    "Owner_id int NOT NULL," +
                    "Name VARCHAR(50) NOT NULL," +
                    "Start DATE NOT NULL," +
                    "Expired DATE NOT NULL);");
            return true;
        } catch (Exception e) {
            return false;}
    }

    public boolean createFeedbackTable(){
        try {
            updateData("CREATE TABLE IF NOT EXISTS Feedback (" +
                    "Id int NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE," +
                    "User_id int NOT NULL," +
                    "Word MEDIUMTEXT);");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean createJoinUserProject(){
        try {
            updateData("CREATE TABLE IF NOT EXISTS User_Project (" +
                    "Id int NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE," +
                    "User_id int NOT NULL," +
                    "Project_id int NOT NULL);");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean createNoteTable() {
        try {
            updateData("CREATE TABLE IF NOT EXISTS Note_info (" +
                    "Id int NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE," +
                    "Owner_id int NOT NULL," +
                    "Name TEXT NOT NULL," +
                    "Note LONGTEXT," +
                    "Access boolean DEFAULT true);");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
