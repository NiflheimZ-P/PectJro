package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;


import org.intellij.lang.annotations.Flow;

import java.awt.*;
import javax.swing.*;
public class userprogress {
    private JFrame fr;
    private JPanel p, p_zone1, p_zone2, p_zone12, p_zone21, p_zone22, p_zone221;
    private JLabel pic, name, probarname;
    private JProgressBar pg;
    public userprogress(){
        fr = new JFrame();
        p = new JPanel();
        p_zone1 = new JPanel();
        p_zone2 = new JPanel();
        p_zone12 = new JPanel();
        p_zone21 = new JPanel();
        p_zone22 = new JPanel();
        p_zone221 = new JPanel();
        pic = new JLabel("picture here");
        name = new JLabel("ProjectName");
        probarname = new JLabel("Progressbar");
        pg = new JProgressBar();

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(p);

        p.setLayout(new BorderLayout());
        p.add(p_zone1, BorderLayout.WEST);
        p_zone1.setPreferredSize(new Dimension(250,300));
        p.add(p_zone2, BorderLayout.CENTER);

        p_zone1.setLayout(new FlowLayout());
        p_zone1.add(pic);

        p_zone2.setLayout(new GridLayout(2,1));
        p_zone2.add(p_zone21);
        p_zone2.add(p_zone22);

        p_zone21.setLayout(new BorderLayout());
        p_zone21.add(name, BorderLayout.WEST);

        p_zone22.setLayout(new BorderLayout());
        p_zone22.add(probarname, BorderLayout.NORTH);
        p_zone22.add(p_zone221, BorderLayout.WEST);

        p_zone221.setLayout(new FlowLayout());
        p_zone221.add(pg);

        fr.setSize(600,300);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        new userprogress();
    }
}
