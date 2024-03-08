package com.kmitl.pectjro.Frame.Main_Program;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Groups_interface.Changeable;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Main_Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class Main_Frame implements WindowListener {
    private static JFrame frame = new JFrame("PectJro");

    public Main_Frame(){
        frame.setLayout(new CardLayout());
        frame.addWindowListener(this);
        frame.setLocationRelativeTo(null);
        frame.setSize(1600, 900);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void changePage(Changeable page){
        frame.setContentPane((Container) page);
        frame.repaint();
        frame.revalidate();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        File user = new File("User_Cache");
        if (user.exists()){
            Main_Login.setRemember(true);
            changePage(new home_page());
        } else {
            changePage(new Main_Login());
        }
    }
    @Override
    public void windowClosing(WindowEvent e) {
        File target = new File("User_Cache");
        if (!Main_Login.getRemember()) { target.delete(); }
    }
    @Override
    public void windowClosed(WindowEvent e) {
        File target = new File("User_Cache");
        if (!Main_Login.getRemember()) { target.delete(); }
    }
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel( new FlatMacLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        SwingUtilities.invokeLater(() -> {new Main_Frame();});
    }
}
