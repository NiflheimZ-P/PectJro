package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Insi
 */
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import com.toedter.calendar.*;
import java.awt.*;
import javax.swing.*;

public class ProjectCreate {
    private JFrame fr;
    private JPanel p_main, p_zone1, p_zone2, p_zone11, p_zone12, p_zone21, p_zone22, p_zone23, p_zone221, p_zone222;
    private JButton b_photo, b_create, b_back;
    private JLabel picture, l1, l2, l3, l4;
    private JInfoGet projectname;
    private JDateChooser d1, d2;
    public ProjectCreate(){
        ImageIcon icon = null;
        icon = new ImageIcon("resources/Images/aunkung.jpeg");

        fr = new JFrame();
        p_main = new JPanel();
        p_zone1 = new JPanel();
        p_zone2 = new JPanel();
        p_zone11 = new JPanel();
        p_zone12 = new JPanel();
        p_zone21 = new JPanel();
        p_zone22 = new JPanel();
        p_zone23 = new JPanel();
        p_zone221 = new JPanel();
        p_zone222 = new JPanel();

        b_photo = new JButton("Photo");
        b_create = new JButton("Create");
        b_back = new JButton("Back");

        picture = new JLabel("picture here");
        l1 = new JLabel("           Get Starto");
        l2 = new JLabel("Enter your ProjectName");
        l3 = new JLabel("Start");
        l4 = new JLabel("End");
        projectname = new JInfoGet("ProjectName");

        d1 = new JDateChooser();
        d2 = new JDateChooser();

        fr.add(p_main);
        p_main.setLayout(new BorderLayout());
        p_main.add(p_zone1, BorderLayout.WEST);
        p_zone1.setPreferredSize(new Dimension(200, 300));
        p_main.add(p_zone2, BorderLayout.CENTER);

        p_zone1.setLayout(new BorderLayout());
        p_zone1.add(p_zone11, BorderLayout.CENTER);
        p_zone11.setPreferredSize(new Dimension(200, 200));
        p_zone1.add(p_zone12, BorderLayout.SOUTH);
        p_zone12.setPreferredSize(new Dimension(200, 100));

        p_zone11.setLayout(new FlowLayout());
        p_zone11.add(picture);

        p_zone12.setLayout(new FlowLayout());
        p_zone12.add(b_photo);

        p_zone2.setLayout(new BorderLayout());
        p_zone2.add(p_zone21, BorderLayout.NORTH);
        p_zone21.setPreferredSize(new Dimension(400, 110));
        p_zone2.add(p_zone22, BorderLayout.CENTER);
        p_zone22.setPreferredSize(new Dimension(400, 130));
        p_zone2.add(p_zone23, BorderLayout.SOUTH);
        p_zone23.setPreferredSize(new Dimension(400, 50));

        p_zone21.setLayout(new GridLayout(3,1));
        p_zone21.add(l1);
        p_zone21.add(l2);
        p_zone21.add(projectname);

        p_zone22.setLayout(new GridLayout(1,2));
        p_zone22.add(p_zone221);
        p_zone221.setLayout(new GridLayout(2,1));
        p_zone221.add(l3);
        p_zone221.add(d1);
        p_zone22.add(p_zone222);
        p_zone222.setLayout(new GridLayout(2,1));
        p_zone222.add(l4);
        p_zone222.add(d2);

        p_zone23.setLayout(new FlowLayout());
        p_zone23.add(b_create);
        p_zone23.add(b_back);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setSize(600,300);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new ProjectCreate();
    }
}
