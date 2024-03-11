package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Feedback_Page;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;

public class Feedback{
    private JFrame fr;

    private JPanel pl_select, pl_Main_FeedBack;

    private JTextArea text_Area;
    public Feedback() {
        //setup
       fr = new JFrame("Feedback");
       text_Area = new JTextArea();
       pl_select = new JPanel(new FlowLayout());




        for (int i = 0; i < 10; i++) {
            pl_select.add(new user_feedback("1231231","123123123asdasdada","resources/Images/aunkung.jpeg"));

        }
        pl_select.setPreferredSize(new Dimension(600,4000));
        JScrollPane scroll = new JScrollPane(pl_select,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //scroll.setPreferredSize(new Dimension(600,400));
        //scroll.setViewportView(pl_select);
        fr.add(scroll);

        fr.setSize(600, 400);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SwingUtilities.invokeLater(()->{new Feedback();});

    }
}
