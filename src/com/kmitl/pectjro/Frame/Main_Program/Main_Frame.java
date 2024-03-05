package com.kmitl.pectjro.Frame.Main_Program;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Login_Page;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Register_Page;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Frame implements ActionListener {
    private JFrame frame = new JFrame("PectJro");
    private JPanel main_panel;
    private CardLayout page_manage = new CardLayout();
    private JPanel[] page = new JPanel[2];

    public Main_Frame(){
        DBConnect.createConnect();
        ImageIcon icon = new ImageIcon("resources/Images/kmitl_it_data_science_01.jpg");
        frame.setContentPane(new JLabel(icon));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints manage = new GridBagConstraints();

        page[0] = new Login_Page(this);
        page[1] = new Register_Page(this);

        main_panel = new JPanel(page_manage);
        main_panel.add(page[0], "login");
        main_panel.add(page[1], "register");

        frame.add(main_panel, manage);

        frame.setLocationRelativeTo(null);
        frame.setSize(1600, 900);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

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

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel( new FlatMacLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        SwingUtilities.invokeLater(() -> {new Main_Frame();});
    }
}
