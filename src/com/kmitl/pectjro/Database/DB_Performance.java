package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;

import javax.swing.*;

public class DB_Performance {
    public static void createBackground(){
        SwingWorker<Void, Void> back = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                DBConnect.createConnect();
                return null;
            }
        };

        back.execute();
        System.out.println("Created");
    }
}
