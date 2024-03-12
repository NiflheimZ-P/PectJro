package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.home_page;

import java.awt.*;
import javax.swing.*;

public class Profile {
    private JFrame fr;
    private JPanel pn_north, pn_west, pn_east, pn_south, pn_center, empty_pn_north_left, empty_pn_north_right,
            margin_pn_north_mid, pn_center_left,  pn_center_right, ctn_pn_center_right, margin_name,
            margin_email, margin_bn_profile;
    private JLabel l_topic, icon, l_name, l_email;
    private JButton bn_select_photo, bn_change_name, bn_change_password, bn_exit, bn_log_out;
    private ImageIcon im_profile;


    public Profile() {
        //set up
        fr = new JFrame();

        pn_north = new JPanel();
        pn_west = new JPanel();
        pn_east = new JPanel();
        pn_south = new JPanel();
        pn_center = new JPanel();
        empty_pn_north_left = new JPanel();
        empty_pn_north_right = new JPanel();
        margin_pn_north_mid = new JPanel();
        pn_center_left = new JPanel();
        pn_center_right = new JPanel();
        ctn_pn_center_right = new JPanel();
        margin_name = new JPanel();
        margin_email = new JPanel();
        margin_bn_profile = new JPanel();

        l_topic = new JLabel("Profile");
        icon = new JLabel();
        l_name = new JLabel("Name : ");
        l_email = new JLabel("Email : ");

        bn_select_photo = new JButton("Select Photo");
        bn_change_name = new JButton("Change name");
        bn_change_password = new JButton("Change password");
        bn_exit = new JButton("X");
        bn_log_out = new JButton("Log out");

        im_profile = new ImageIcon("/Users/win/Documents/GitHub/PectJro/Untitled/resources/Images/Logo.png");


        //Frame set up
        fr.setLayout(new BorderLayout());


        //top part and exit button
        fr.add(pn_north, BorderLayout.NORTH);
        pn_north.setLayout(new GridLayout(1,3));
        pn_north.setBackground(Color.lightGray);

        pn_north.add(empty_pn_north_left);
        empty_pn_north_left.setBackground(Color.lightGray);

        pn_north.add(margin_pn_north_mid);
        margin_pn_north_mid.setLayout(new FlowLayout(1,50,20));
        margin_pn_north_mid.setBackground(Color.lightGray);
        margin_pn_north_mid.add(l_topic);
        l_topic.setFont(new Font("Sans", Font.BOLD, 20));

        pn_north.add(empty_pn_north_right);
        empty_pn_north_right.setLayout(new FlowLayout(2, 30,10));
        empty_pn_north_right.setBackground(Color.lightGray);
        empty_pn_north_right.add(bn_exit, BorderLayout.EAST);
        bn_exit.setPreferredSize(new Dimension(40,40));


        //Center part
        fr.add(pn_center, BorderLayout.CENTER);
        pn_center.setLayout(new GridLayout(1,2));

        //Center left part
        pn_center_left.setLayout(new FlowLayout(1,50,50));
        icon.setIcon(im_profile);
        icon.setPreferredSize(new Dimension(300,300));
        pn_center.add(pn_center_left);
        pn_center_left.add(icon);//test image
        pn_center_left.add(bn_select_photo);

        //Center right part
        pn_center_right.setLayout(new BorderLayout());
        pn_center_right.add(ctn_pn_center_right, BorderLayout.CENTER);
        pn_center.add(pn_center_right);

        ctn_pn_center_right.setLayout(new GridLayout(2,0));
        margin_name.setLayout(new FlowLayout(3,50,100));
        margin_name.add(l_name);
        ctn_pn_center_right.add(margin_name);

        margin_email.setLayout(new FlowLayout(3,50,70));
        margin_email.add(l_email);
        ctn_pn_center_right.add(margin_email);

        pn_center_right.add(margin_bn_profile, BorderLayout.SOUTH);
        margin_bn_profile.setLayout(new FlowLayout(1,50,80));
        margin_bn_profile.add(bn_change_name);
        margin_bn_profile.add(bn_change_password);
        margin_bn_profile.add(bn_log_out);


        //show
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1000,600);
        fr.setResizable(false);
        fr.setVisible(true);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SwingUtilities.invokeLater(() -> {new Profile(); });
    }
}
