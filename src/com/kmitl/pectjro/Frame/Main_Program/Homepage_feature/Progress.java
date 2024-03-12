package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Insi
 */
import java.awt.*;
import javax.swing.*;
public class Progress {
    private JFrame fr;
    private JPanel p, p_zone1, p_zone2, p_zone11, p_zone12, p_zone121, p_zone122 , p_zone21, p_zone22;
    private JProgressBar pg;
    private JLabel progress, percent, l1, l2, l3, l4, r1, r2, r3, r4;
    public Progress(){
        fr = new JFrame("Progress page");
        p = new JPanel();
        p_zone1 = new JPanel();
        p_zone2 = new JPanel();
        p_zone11 = new JPanel();
        p_zone12 = new JPanel();
        p_zone21 = new JPanel();
        p_zone22 = new JPanel();
        p_zone121 = new JPanel();
        p_zone122 = new JPanel();
        pg = new JProgressBar();
        progress = new JLabel("Progress");
        percent = new JLabel(" 0%");
        l1 = new JLabel("somesomesomesome");
        l2 = new JLabel("somesomesomesomesomesomesomesome");
        l3 = new JLabel("somesomesomesomesomesomesomesome");
        l4 = new JLabel("somesomesomesomesomesomesomesome");
        r1 = new JLabel("somesomesomesome");
        r2 = new JLabel("somesomesomesomesomesomesomesome");
        r3 = new JLabel("somesomesomesomesomesomesomesome");
        r4 = new JLabel("somesomesomesomesomesomesomesome");


        fr.add(p);

        p.setLayout(new BorderLayout());
        p.add(p_zone1, BorderLayout.NORTH);
        p_zone1.setPreferredSize(new Dimension(1000, 300));
        p.add(p_zone2, BorderLayout.CENTER);

        p_zone1.setLayout(new BorderLayout());
        progress.setSize(30,50);
        p_zone1.add(p_zone11, BorderLayout.NORTH);
        p_zone11.setPreferredSize(new Dimension(500, 100));
        p_zone11.setLayout(new FlowLayout());
        progress.setFont(new Font("Arial", Font.PLAIN, 40));
        p_zone11.add(progress);

        p_zone121.setLayout(new FlowLayout());
        pg.setPreferredSize(new Dimension(400, 80));
        p_zone121.add(pg);
        p_zone122.setLayout(new BorderLayout());
        p_zone121.add(percent);
        percent.setFont(new Font("Arial", Font.PLAIN, 25));

        p_zone1.add(p_zone12, BorderLayout.CENTER);
        p_zone12.setPreferredSize(new Dimension(500, 300));
        p_zone12.setLayout(new GridLayout(2,1));
        p_zone12.add(p_zone121);

        p_zone2.setLayout(new FlowLayout());
        p_zone2.add(p_zone21);
        p_zone21.setPreferredSize(new Dimension(300, 300));
        p_zone21.setLayout(new GridLayout(4,1));
        p_zone21.add(l1);
        p_zone21.add(l2);
        p_zone21.add(l3);
        p_zone21.add(l4);
        p_zone2.add(p_zone22);
        p_zone22.setPreferredSize(new Dimension(300, 300));
        p_zone22.setLayout(new GridLayout(4,1));
        p_zone22.add(r1);
        p_zone22.add(r2);
        p_zone22.add(r3);
        p_zone22.add(r4);


        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1000,700);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new Progress();
    }
}

