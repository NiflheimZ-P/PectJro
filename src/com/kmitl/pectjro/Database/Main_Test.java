package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;

import java.sql.SQLException;

public class Main_Test {
    public static void main(String[] args) {
        DBConnect.createConnect();
        try {
            //DB_Command.addUserData("AunLnwza007", "Aunwongpra@gmail.com", "200525354235", "Anawat", "Wongprachanukul");
            System.out.println(DB_Command.getUserData("Aunwongpra@gmail.com"));
        } catch (SQLException e) {
            System.out.println("Already exist");
        }
    }
}
