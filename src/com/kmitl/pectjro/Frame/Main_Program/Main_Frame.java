package com.kmitl.pectjro.Frame.Main_Program;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Database.DB_Performance;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Login_Page;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Main_Login;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Register_Page;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class Main_Frame implements WindowListener {
    private static JFrame frame = new JFrame("PectJro");
    private static Boolean remember = false;

    public Main_Frame(){
        DB_Performance.createBackground();
        frame.setContentPane(new Main_Login());
        frame.addWindowListener(this);

        frame.setLocationRelativeTo(null);
        frame.setSize(1600, 900);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        File target = new File("User_Cache");
        if (!remember) { target.delete(); }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        File target = new File("User_Cache");
        if (!remember) { target.delete(); }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel( new FlatMacLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        SwingUtilities.invokeLater(() -> {new Main_Frame();});
    }
}
