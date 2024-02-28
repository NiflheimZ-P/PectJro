package com.kmitl.pectjro;

import com.formdev.flatlaf.FlatDarkLaf;
import com.kmitl.pectjro.DBConnection.Setup;
import com.kmitl.pectjro.Frame.Login;

import javax.swing.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel( new FlatDarkLaf() );
        File info = new File("Database_Setting.dat");
        if (!info.exists()) {
            SwingUtilities.invokeLater(() -> {new Setup();} );
        } else {
            SwingUtilities.invokeLater(() -> {new Login();});
        }
    }
}
