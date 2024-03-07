package com.kmitl.pectjro.Frame.Main_Program;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DB_Performance;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Login_Page;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Register_Page;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class Main_Frame implements ActionListener, WindowListener {
    private static JFrame frame = new JFrame("PectJro");
    private JPanel main_panel;
    private CardLayout page_manage = new CardLayout();
    private JPanel[] page = new JPanel[2];
    private static Boolean remember = false;

    public Main_Frame(){
        DB_Performance.createBackground();
        ImageIcon icon = new ImageIcon("resources/Images/kmitl_it_data_science_01.jpg");
        frame.setContentPane(new JLabel(icon));
        frame.setLayout(new GridBagLayout());
        frame.addWindowListener(this);

        GridBagConstraints manage = new GridBagConstraints();
        page[0] = new Login_Page(this);
        page[1] = new Register_Page(this);

        main_panel = new JPanel(page_manage);
        main_panel.add(page[0], "login");
        main_panel.add(page[1], "register");

        frame.add(main_panel, manage);

        frame.setFocusable(true);
        frame.requestFocusInWindow();

        frame.setLocationRelativeTo(null);
        frame.setSize(1600, 900);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void change_content(Container swap){
        frame.setContentPane(swap);
    }

    public static void setRemember(Boolean stats) { remember = stats; }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Sign up")) {
            page_manage.show(main_panel, "register");
        } else if (e.getActionCommand().equals("Back")){
            page_manage.show(main_panel, "login");
        } else if (e.getActionCommand().equals("Submit")){
            if (((Register_Page) page[1]).creatingAccount()){
                page_manage.show(main_panel, "login");
                ((Register_Page) page[1]).setEmpty();
            }
        }
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
