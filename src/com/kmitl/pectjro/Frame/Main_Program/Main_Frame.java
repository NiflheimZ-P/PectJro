package com.kmitl.pectjro.Frame.Main_Program;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.Login_Page;

import javax.swing.*;
import java.awt.*;

public class Main_Frame {
    private JFrame frame = new JFrame();
    private JPanel main_panel;

    public Main_Frame(){
        ImageIcon icon = new ImageIcon("resources/Images/kmitl_it_data_science_01.jpg");
        frame.setContentPane(new JLabel(icon));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints manage = new GridBagConstraints();
        manage.gridx = 0; manage.gridy = 0; manage.weightx = 1; manage.weighty = 1;
        CardLayout page_manage = new CardLayout();
        main_panel = new JPanel(page_manage);
        main_panel.add(new Login_Page());
        frame.add(main_panel, manage);

        frame.setLocationRelativeTo(null);
        frame.setSize(1600, 900);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatMacLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        SwingUtilities.invokeLater(() -> {new Main_Frame();});
    }
}
