package com.kmitl.pectjro.Frame.Main_Program;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Tools.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class home_page {

    private JFrame fr;
    private JPanel pn_north, pn_west, pn_center, ctn_pn_task, ctn_pn_calendar, ctn_pn_appraisement, ctn_pn_deadline, ctn_pn_deadline_2;
    private JTextField tf_seach_bar;
    private JButton bn_task, bn_calendar, bn_appraisement, bn_new, bn_option;
    private JLabel l1, l2, l3, l4;
    private TitledBorder tb_task, tb_calendar, tb_appraisement;

    public home_page(){
        //set up
        fr = new JFrame("PectJro");

        pn_north = new JPanel();
        pn_west = new JPanel();
        pn_center = new JPanel();
        ctn_pn_task = new JPanel();
        ctn_pn_calendar = new JPanel();
        ctn_pn_appraisement = new JPanel();
        ctn_pn_deadline = new JPanel();
        ctn_pn_deadline_2 = new JPanel();

        tf_seach_bar = new JTextField();

        bn_task = new JButton();
        bn_calendar = new JButton();
        bn_appraisement = new JButton();
        bn_new = new JButton();
        bn_option = new JButton();

        l1 = new JLabel("- 1");
        l2 = new JLabel("- 2");
        l3 = new JLabel("- 3");
        l4 = new JLabel("Deadline");

        tb_task = new TitledBorder("");
        tb_calendar = new TitledBorder("");
        tb_appraisement = new TitledBorder("");

        //set upper part (pn_north)
        fr.setLayout(new BorderLayout());
        fr.setBackground(Color.white);
        fr.add(pn_north, BorderLayout.NORTH);
        pn_north.setBackground(Color.lightGray);
        pn_north.add(tf_seach_bar);
        tf_seach_bar.setColumns(25);

        //set left part (pn_west)
        fr.add(pn_west, BorderLayout.WEST);
        pn_west.setLayout(new GridLayout(8, 1,0,10));
        pn_west.setBackground(Color.lightGray);

        //set up button
        bn_task.setText("Task");
        bn_calendar.setText("Calendar");
        bn_appraisement.setText("Appraisement");

        //set up inside left part
        ctn_pn_task.setBorder(tb_task);
        ctn_pn_task.setLayout(new GridLayout(1,1));
        ctn_pn_task.setBackground(Color.lightGray);
        ctn_pn_task.add(bn_task); pn_west.add(ctn_pn_task);

        ctn_pn_calendar.setBorder(tb_calendar);
        ctn_pn_calendar.setLayout(new GridLayout(1,1));
        ctn_pn_calendar.setBackground(Color.lightGray);
        ctn_pn_calendar.add(bn_calendar); pn_west.add(ctn_pn_calendar);

        ctn_pn_appraisement.setBorder(tb_appraisement);
        ctn_pn_appraisement.setLayout(new GridLayout(1,1));
        ctn_pn_appraisement.setBackground(Color.lightGray);
        ctn_pn_appraisement.add(bn_appraisement); pn_west.add(ctn_pn_appraisement);

        ctn_pn_deadline.setLayout(new FlowLayout());
        ctn_pn_deadline.setBackground(Color.lightGray);
        ctn_pn_deadline.add(l4); pn_west.add(ctn_pn_deadline);

        //show
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1400, 800);
        fr.setResizable(false);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        new home_page();
    }
}
