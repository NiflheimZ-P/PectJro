package com.kmitl.pectjro.Database.Connection;

import com.kmitl.pectjro.Frame.Cache_Templates.Setting_Template;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class DBConnect {
    private static Connection con;

	public static synchronized Connection createConnect() {
        File info = new File("Database_Setting.dat");
		Setting_Template connect_data = null;
		try (ObjectInputStream data = new ObjectInputStream(new FileInputStream(info))) {
            connect_data = (Setting_Template) data.readObject();
            con = DriverManager.getConnection("jdbc:mysql://" + connect_data.host + ":" + connect_data.port + "/" + connect_data.database_name, connect_data.username, connect_data.password);
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();  //TODO make new Exception type that will appear pop up
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public synchronized static boolean checkConnection(ArrayList<String> info) {
        try {
            DBConnect.con = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", info.get(0), info.get(1), info.get(2)), info.get(3), info.get(4));
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}