package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;

import javax.swing.*;

public class DB_Performance {
    public static void createBackground(){
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    DBConnect.createConnect();
                    try { Thread.sleep(10 * 60 * 1000);}
                    catch (InterruptedException e) { throw new RuntimeException(e); }
                }
			}
        });
        a.start();
        System.out.println("create done");
    }
}
