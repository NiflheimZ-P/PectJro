package com.kmitl.pectjro.DBConnection;

import java.sql.SQLException;

public class CreateDatabase {
    public static void createUserTable(){
        DBConnect.createConnect();
        try {
            DBConnect.updateData("CREATE TABLE IF NOT EXISTS User_info (" +
                    "Id int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "Username VARCHAR(50) NOT NULL,Gmail VARCHAR(62)," +
                    "Password VARCHAR(62),Firstname VARCHAR(50)," +
                    "Lastname VARCHAR(50),UNIQUE (ID, Username));");
        } catch (SQLException e) { e.printStackTrace(); }
        System.out.println("Successful create UserTable");
    }
}
