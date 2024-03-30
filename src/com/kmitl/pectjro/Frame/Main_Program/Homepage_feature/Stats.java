package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class Stats {
    private JPanel pn;
    private JPanel mainPanel, statsPanel, projectPanel, pn_north, pn_center, pn_center_2, pn_center_3;
    private JLabel titleLabel, username, profile, l1, l2, l3;
    private Image im_profile;
    private JLabel userLabel;
    private JLabel projectLabel;
    private JComboBox<String> statusComboBox;

    public JPanel getFrame(){
        return pn;
    }

    public Stats() {
        pn = new JPanel();

        pn_north = new JPanel();
        pn_center = new JPanel();
        pn_center_2 = new JPanel();
        pn_center_3 = new JPanel();

        titleLabel = new JLabel("Your Stats");
        username = new JLabel("Username");
        profile = new JLabel();
        l1 = new JLabel("Project Done   ");
        l2 = new JLabel("Complete Project");
        l3 = new JLabel("Late Project   ");

        im_profile = new ImageIcon("resources/Images/aunkung.jpeg").getImage();
        Image tmp_profile = im_profile.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ic_profile = new ImageIcon(tmp_profile);

        pn.setLayout(new GridLayout(4, 1));
        pn.add(pn_north);
        pn.add(pn_center);
        pn.add(pn_center_2);
        pn.add(pn_center_3);

        //north part
        pn_north.setLayout(new FlowLayout(FlowLayout.CENTER, 8000, 5));
        JPanel tmp = new JPanel();
        tmp.setLayout(new FlowLayout());
        tmp.add(titleLabel);
        pn_north.add(tmp);
        JPanel tmp2 = new JPanel();
        tmp2.setPreferredSize(new Dimension(600, 100));
        tmp2.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
        tmp2.setBorder(new LineBorder(new Color(30,31,34)));
        tmp2.add(profile);
        tmp2.add(username);
        profile.setIcon(ic_profile);
        pn_north.add(tmp2);

        //center part
        pn_center.setLayout(new FlowLayout());
        JPanel pn_l1 = new JPanel();
        pn_l1.setPreferredSize(new Dimension(200, 100));
        pn_l1.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 30));
        pn_l1.setBorder(new LineBorder(new Color(30,31,34)));
        pn_l1.add(l1);
        JLabel score_l1 = new JLabel("0");
        pn_l1.add(score_l1);
        pn_center.add(pn_l1);

        pn_center.setLayout(new FlowLayout());
        JPanel pn_l2 = new JPanel();
        pn_l2.setPreferredSize(new Dimension(200, 100));
        pn_l2.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 30));
        pn_l2.setBorder(new LineBorder(new Color(30,31,34)));
        pn_l2.add(l2);
        JLabel score_l2 = new JLabel("0");
        pn_l2.add(score_l2);
        pn_center_2.add(pn_l2);

        pn_center.setLayout(new FlowLayout());
        JPanel pn_l3 = new JPanel();
        pn_l3.setPreferredSize(new Dimension(200, 100));
        pn_l3.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 30));
        pn_l3.setBorder(new LineBorder(new Color(30,31,34)));
        pn_l3.add(l3);
        JLabel score_l3 = new JLabel("0");
        pn_l3.add(score_l3);
        pn_center_3.add(pn_l3);

        //set font and color
        titleLabel.setFont(new Font("Sans", Font.BOLD, 30));
        username.setFont(new Font("Sans", Font.PLAIN, 18));
        profile.setFont(new Font("Sans", Font.PLAIN, 16));
        l1.setFont(new Font("Sans", Font.BOLD, 14));
        l2.setFont(new Font("Sans", Font.BOLD, 14));
        l3.setFont(new Font("Sans", Font.BOLD, 14));
        score_l1.setFont(new Font("Sans", Font.PLAIN, 14));
        score_l2.setFont(new Font("Sans", Font.PLAIN, 14));
        score_l3.setFont(new Font("Sans", Font.PLAIN, 14));

        tmp.setBackground(new Color(49, 51, 56));
        tmp2.setBackground(new Color(49, 51, 56));
        pn_l1.setBackground(new Color(49, 51, 56));
        pn_l2.setBackground(new Color(49, 51, 56));
        pn_l3.setBackground(new Color(49, 51, 56));

        titleLabel.setForeground(new Color(88,101,242));
        username.setForeground(Color.white);
        profile.setForeground(Color.white);
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        l3.setForeground(Color.white);
        score_l1.setForeground(Color.white);
        score_l2.setForeground(Color.yellow);
        score_l3.setForeground(Color.red);

        pn.setBackground(new Color(49, 51, 56));
        pn_north.setBackground(new Color(49, 51, 56));
        pn_center.setBackground(new Color(49, 51, 56));
        pn_center_2.setBackground(new Color(49, 51, 56));
        pn_center_3.setBackground(new Color(49, 51, 56));

        //show
        //pn.setDefaultCloseOperation(JPanel.EXIT_ON_CLOSE);
        pn.setSize(1000, 800);
        //pn.setResizable(false);
        pn.setVisible(true);



        // pn = new JPanel();
        // mainPanel = new JPanel(new BorderLayout());
        // statsPanel = new JPanel(new GridLayout(3, 1));
        // projectPanel = new JPanel(new GridLayout(3, 1));

        // userLabel = new JLabel("Username: ");
        // projectLabel = new JLabel("Project Status: ");
        // titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // statusComboBox = new JComboBox<>();
        // statusComboBox.addItem("Completed");
        // statusComboBox.addItem("In Progress");
        // statusComboBox.addItem("Incomplete");

        // // Add components to the Panel
        // statsPanel.add(titleLabel);
        // statsPanel.add(userLabel);

        // projectPanel.add(projectLabel);
        // projectPanel.add(statusComboBox);

        // mainPanel.add(statsPanel, BorderLayout.NORTH);
        // mainPanel.add(projectPanel, BorderLayout.CENTER);

        // pn.add(mainPanel);
        // pn.setBackground(Color.CYAN);
        // //pn.setResizable(false);
        // pn.setSize(400, 300);
        // pn.setVisible(true);

    }

    public static void main(String[] args) {
        new Stats();
    }
}

