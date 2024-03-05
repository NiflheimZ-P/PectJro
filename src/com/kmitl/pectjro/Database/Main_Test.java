package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import java.net.InetAddress;
import java.sql.SQLException;

public class Main_Test {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            String str = ia.getHostAddress();
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
