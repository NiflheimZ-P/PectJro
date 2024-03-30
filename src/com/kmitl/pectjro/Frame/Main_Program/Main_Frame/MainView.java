package com.kmitl.pectjro.Frame.Main_Program.Main_Frame;

import javax.swing.*;
import java.awt.*;

public class MainView {
    // Attribute
    private JFrame frame;

    // Constructor
    public MainView(){
        frame = new JFrame("PectJro");
        frame.setLocationRelativeTo(null);
        frame.setSize(1600, 900);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new CardLayout());
        frame.setVisible(true);
    }

    // Accessor
    public JFrame getFrame() {return frame;}
}
