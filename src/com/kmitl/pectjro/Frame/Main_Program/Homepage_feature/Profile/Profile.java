package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Main_Program.home_page.home_page;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import java.awt.*;
import javax.swing.*;

public class Profile {
    private JPanel fr;
    private JPanel pn_north, pn_center, pn_center_left,  pn_center_right, ctn_pn_center_right, margin_name,
            margin_email, margin_bn_profile;
    private JLabel l_topic, icon, l_name, l_email;
    private JButton bn_select_photo, bn_change_name, bn_change_password, bn_log_out;
    private Image im_profile;
    private home_page home;

    public Profile() {
        //set up
        fr = new JPanel();

        //Frame set up
        fr.setLayout(new BorderLayout());
        fr.setBackground(new Color(49,51,56));

        pn_north = new JPanel();
        pn_center = new JPanel();
        pn_center_left = new JPanel();
        pn_center_right = new JPanel();
        ctn_pn_center_right = new JPanel();
        margin_name = new JPanel();
        margin_email = new JPanel();
        margin_bn_profile = new JPanel();

        l_topic = new JLabel("Profile");
        icon = new JLabel();
        l_name = new JLabel("Username : ");
        l_email = new JLabel("Email : ");

        bn_select_photo = new JButton("Select Photo");
        bn_change_name = new JButton("Change name");
        bn_change_password = new JButton("Change password");
        bn_log_out = new JButton("Log out");

        im_profile = new ImageIcon("resources/Images/aunkung.jpeg").getImage();
        Image newImage = im_profile.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon ic_image = new ImageIcon(newImage);

        //top part and exit button
        fr.add(pn_north, BorderLayout.NORTH);
        pn_north.setLayout(new FlowLayout());
        pn_north.setBackground(new Color(49,51,56));
        pn_north.add(l_topic);
        l_topic.setSize(30, 50);
        l_topic.setFont(new Font("Sans", Font.BOLD, 40));
        l_topic.setForeground(Color.white);


        //Center part
        fr.add(pn_center, BorderLayout.CENTER);
        pn_center.setLayout(new GridLayout(1,2));
        pn_center.setBackground(new Color(49,51,56));

        //Center left part
        pn_center_left.setLayout(new FlowLayout(1,500,50));
        icon.setIcon(ic_image);
        pn_center.add(pn_center_left);
        pn_center_left.add(icon);//test image
        pn_center_left.add(bn_select_photo);
        bn_select_photo.setBorder(BorderFactory.createEmptyBorder());
        bn_select_photo.setPreferredSize(new Dimension(150, 60));
        bn_select_photo.setFont(new Font("Sans", Font.PLAIN, 18));
        bn_select_photo.setForeground(Color.white);
        bn_select_photo.setBackground(new Color(30,31,34));

        //Center right part
        pn_center_right.setLayout(new BorderLayout());
        pn_center_right.add(ctn_pn_center_right, BorderLayout.CENTER);
        pn_center.add(pn_center_right);

        ctn_pn_center_right.setLayout(new GridLayout(2,0));
        margin_name.setLayout(new FlowLayout(3,30,100));
        margin_name.add(l_name);
        l_name.setFont(new Font("Sans", Font.BOLD, 18));
        l_name.setForeground(Color.white);
        ctn_pn_center_right.add(margin_name);

        margin_email.setLayout(new FlowLayout(3,30,70));
        margin_email.add(l_email);
        l_email.setFont(new Font("Sans", Font.BOLD, 18));
        l_email.setForeground(Color.white);
        ctn_pn_center_right.add(margin_email);

        pn_center_right.add(margin_bn_profile, BorderLayout.SOUTH);
        margin_bn_profile.setLayout(new FlowLayout(1,10,80));
        margin_bn_profile.add(bn_change_name);
        bn_change_name.setBorder(BorderFactory.createEmptyBorder());
        bn_change_name.setPreferredSize(new Dimension(150, 60));
        bn_change_name.setFont(new Font("Sans", Font.PLAIN, 16));
        bn_change_name.setForeground(Color.white);
        bn_change_name.setBackground(new Color(30,31,34));

        margin_bn_profile.add(bn_change_password);
        bn_change_password.setBorder(BorderFactory.createEmptyBorder());
        bn_change_password.setPreferredSize(new Dimension(150, 60));
        bn_change_password.setFont(new Font("Sans", Font.PLAIN, 16));
        bn_change_password.setForeground(Color.white);
        bn_change_password.setBackground(new Color(30,31,34));

        margin_bn_profile.add(bn_log_out);
        bn_log_out.setBorder(BorderFactory.createEmptyBorder());
        bn_log_out.setPreferredSize(new Dimension(150, 60));
        bn_log_out.setFont(new Font("Sans", Font.PLAIN, 16));
        bn_log_out.setForeground(Color.white);
        bn_log_out.setBackground(new Color(30,31,34));


        //set color
        //pn_north.setBackground(new Color(43,45,49));
        pn_north.setBackground(new Color(49,51,56));
        pn_center.setBackground(new Color(49,51,56));
        pn_center_left.setBackground(new Color(49,51,56));
        pn_center_right.setBackground(new Color(49,51,56));
        ctn_pn_center_right.setBackground(new Color(49,51,56));
        margin_name.setBackground(new Color(49,51,56));
        margin_email.setBackground(new Color(49,51,56));
        margin_bn_profile.setBackground(new Color(49,51,56));




        //show
        //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1000,600);
        //fr.setResizable(false);
        fr.setVisible(true);
    }

    // Accessor
    public void setBn_select_photo(JButton bn_select_photo) {
        this.bn_select_photo = bn_select_photo;
    }
    public JButton getBn_select_photo() {
        return bn_select_photo;
    }
    public JButton getBn_change_name() {
        return bn_change_name;
    }
    public void setBn_change_name(JButton bn_change_name) {
        this.bn_change_name = bn_change_name;
    }
    public JButton getBn_change_password() {
        return bn_change_password;
    }
    public void setBn_change_password(JButton bn_change_password) {
        this.bn_change_password = bn_change_password;
    }
    public void setBn_log_out(JButton bn_log_out) {
        this.bn_log_out = bn_log_out;
    }
    public void setFr(JPanel fr) {
        this.fr = fr;
    }
    public Image getIm_profile() {
        return im_profile;
    }
    public void setIm_profile(Image im_profile) {
        this.im_profile = im_profile;
    }
    public JLabel getIcon() {
        return icon;
    }
    public JButton getBn_log_out() {
        return bn_log_out;
    }
    public JPanel getFr() {
        return fr;
    }
    public JLabel getL_name() {
        return l_name;
    }
    public void setL_name(JLabel l_name) {
        this.l_name = l_name;
    }
    public JLabel getL_email() {
        return l_email;
    }
    public void setL_email(JLabel l_email) {
        this.l_email = l_email;
    }
}
