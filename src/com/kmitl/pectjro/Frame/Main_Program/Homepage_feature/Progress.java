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
    private JPanel fr;
    private JPanel p, p_zone1, p_zone2, p_zone11, p_zone12, p_zone121, p_zone122 , p_zone21, p_zone22, pl_adven, pl_disadven;
    private JProgressBar pg;
    private JLabel progress, percent, l1, l2, l3, l4, r1, r2, r3, r4;
    public Progress(){
        fr = new JPanel();
        p = new JPanel();   pl_adven = new JPanel(); pl_disadven = new JPanel();
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
        l1 = new JLabel("Advantage");
        l2 = new JLabel("- ข้อดี 1");
        l3 = new JLabel("- ข้อดี 2");
        l4 = new JLabel("- ข้อดี 3");
        r1 = new JLabel("Disadvantage");
        r2 = new JLabel("- ข้อเสีย 1");
        r3 = new JLabel("- ข้อเสีย 2");
        r4 = new JLabel("- ข้อเสีย 3");


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
        progress.setFont(new Font("Sans", Font.BOLD, 40));
        p_zone11.add(progress);

        p_zone121.setLayout(new FlowLayout());
        pg.setPreferredSize(new Dimension(400, 80));
        p_zone121.add(pg);
        pg.setBackground(Color.LIGHT_GRAY);
        p_zone122.setLayout(new BorderLayout());
        p_zone121.add(percent);
        percent.setFont(new Font("Sans", Font.BOLD, 25));

        p_zone1.add(p_zone12, BorderLayout.CENTER);
        p_zone12.setPreferredSize(new Dimension(500, 300));
        p_zone12.setLayout(new GridLayout(2,1));
        p_zone12.add(p_zone121);

        p_zone2.setLayout(new FlowLayout());
        p_zone2.add(p_zone21);
        p_zone21.setPreferredSize(new Dimension(300, 300));
        p_zone21.setLayout(new GridLayout(4,1));
        p_zone21.add(pl_adven);
        pl_adven.setLayout(new FlowLayout());
        pl_adven.add(l1);
        p_zone21.add(l2);
        p_zone21.add(l3);
        p_zone21.add(l4);
        p_zone2.add(p_zone22);
        p_zone22.setPreferredSize(new Dimension(300, 300));
        p_zone22.setLayout(new GridLayout(4,1));
        pl_disadven.add(r1);
        pl_disadven.setLayout(new FlowLayout());
        p_zone22.add(pl_disadven);
        p_zone22.add(r2);
        p_zone22.add(r3);
        p_zone22.add(r4);

        //set color and font
        fr.setBackground(new Color(49,51,56));
        p.setBackground(new Color(49,51,56));
        p_zone1.setBackground(new Color(49,51,56));
        p_zone2.setBackground(new Color(49,51,56));
        p_zone11.setBackground(new Color(49,51,56));
        p_zone12.setBackground(new Color(49,51,56));
        p_zone121.setBackground(new Color(49,51,56));
        p_zone122.setBackground(new Color(49,51,56));
        p_zone21.setBackground(new Color(49,51,56));
        p_zone22.setBackground(new Color(49,51,56));
        pl_disadven.setBackground(new Color(49,51,56));
        pl_adven.setBackground(new Color(49,51,56));
        progress.setForeground(Color.white);
        percent.setForeground(Color.white);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Sans", Font.BOLD, 24));
        l2.setForeground(Color.white);
        l2.setFont(new Font("Sans", Font.PLAIN, 16));
        l3.setForeground(Color.white);
        l3.setFont(new Font("Sans", Font.PLAIN, 16));
        l4.setForeground(Color.white);
        l4.setFont(new Font("Sans", Font.PLAIN, 16));
        r1.setForeground(Color.white);
        r1.setFont(new Font("Sans", Font.BOLD, 24));
        r2.setForeground(Color.white);
        r2.setFont(new Font("Sans", Font.PLAIN, 16));
        r3.setForeground(Color.white);
        r3.setFont(new Font("Sans", Font.PLAIN, 16));
        r4.setForeground(Color.white);
        r4.setFont(new Font("Sans", Font.PLAIN, 16));


        //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1000,700);
        fr.setVisible(true);
    }

    public JPanel getFr() {
        return fr;
    }

    public static void main(String[] args) {
        new Progress();
    }
}

