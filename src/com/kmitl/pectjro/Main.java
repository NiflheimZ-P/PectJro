package com.kmitl.pectjro;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.SetupPage.Main_Setup;
import javax.swing.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel( new FlatMacDarkLaf() );
        File info = new File("Database_Setting.dat");
        if (!info.exists()) {
            UIManager.setLookAndFeel( new FlatMacLightLaf() );
            SwingUtilities.invokeLater(() -> {new Main_Setup();});
        } else {
            UIManager.setLookAndFeel( new FlatMacDarkLaf() );
            SwingUtilities.invokeLater(() -> {new MainController().getView();});
        }
    }
}
