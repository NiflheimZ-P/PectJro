package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import java.sql.SQLException;

public class CreateDatabase {
    public static boolean createUserTable(){
        try {
            DBConnect.updateData("CREATE TABLE IF NOT EXISTS User_info (" +
                    "Id int NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE," +
                    "Username VARCHAR(50) NOT NULL," +
                    "Gmail VARCHAR(62) UNIQUE," +
                    "Password VARCHAR(62)," +
                    "Firstname VARCHAR(50)," +
                    "Lastname VARCHAR(50));");
            return true;
        } catch (SQLException e) { return false; }
    }
}
