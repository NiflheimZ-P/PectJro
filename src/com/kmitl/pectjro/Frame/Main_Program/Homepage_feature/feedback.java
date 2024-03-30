package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;


public class feedback {
    private JFrame fr;
    private JPanel pn_north, pn_center, pn_south, ctn_center;
    private JLabel l_topic, l_subTopic;
    private JTextArea ta_feedback;
    private JButton bn_send;

    public feedback(){
        fr = new JFrame();

        pn_north = new JPanel();
        pn_center = new JPanel();
        pn_south = new JPanel();
        ctn_center = new JPanel();

        l_topic = new JLabel("Feedback!");
        l_subTopic = new JLabel("Please leave your feedback below :");

        ta_feedback = new JTextArea(4,45);

        bn_send = new JButton("Send");


        //north part
        fr.setLayout(new BorderLayout());
        fr.add(pn_north, BorderLayout.NORTH);
        pn_north.setLayout(new FlowLayout());
        pn_north.add(l_topic);

        //center part
        fr.add(pn_center, BorderLayout.CENTER);
        ctn_center.setLayout(new GridLayout(2, 1));
        ctn_center.add(l_subTopic);
        ctn_center.add(ta_feedback);
        ta_feedback.setLineWrap(true);
        pn_center.add(ctn_center);

        //south part
        fr.add(pn_south, BorderLayout.SOUTH);
        pn_south.setLayout(new FlowLayout());
        pn_south.add(bn_send);
        bn_send.setPreferredSize(new Dimension(100, 40));


        //set color and font
         fr.setBackground(new Color(49, 51, 56));
         pn_north.setBackground(new Color(49,51,56));
         pn_center.setBackground(new Color(49,51,56));
         pn_south.setBackground(new Color(49,51,56));
         ctn_center.setBackground(new Color(49,51,56));

        l_topic.setForeground(new Color(88,101,242));
        l_subTopic.setForeground(Color.white);

        l_topic.setFont(new Font("Sans", Font.BOLD, 30));
        l_subTopic.setFont(new Font("Sans", Font.PLAIN, 14));


        //show
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setResizable(false);
        fr.setSize(600, 250);
        fr.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        SwingUtilities.invokeLater(() -> {new feedback();
        });
    }
}
