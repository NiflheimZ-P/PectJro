package com.kmitl.pectjro.Frame.Main_Program;

import com.kmitl.pectjro.Frame.Tools.*;
import java.awt.*;
import javax.swing.*;

public class Main_Interact{
    private JFrame fr;
    private JPanel pmain, pnorth, pleft, pcen, ptask, pcar, papr, pdead, npane1, npane2, npane3;
    private JButton task_bn, ca_bn, apr_bn, new_bn, op_bn;
    private JMenuBar men;
    private JMenu fil, edit, view, tool, win, help;
    private JLabel l1, l2, l3, l4;
    private JTextField sear_bar;
    private JDesktopPane dp;
    private JInternalFrame if1, up_if;
    public Main_Interact(){
        //create frame
        fr = new JFrame("PectJro");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create button
        task_bn = new JButton("Task");
        ca_bn = new JButton("Calendar");
        apr_bn = new JButton("Appraisement");
        new_bn = new JButton("+");
        op_bn = new JButton("Option");

        //create Menubar
        men = new JMenuBar();

        //create menu
        fil = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        tool = new JMenu("Tool");
        win = new JMenu("Window");
        help = new JMenu("Help");

        //creat label
        l1 = new JLabel("????");
        l2 = new JLabel("????");
        l3 = new JLabel("????");
        l4 = new JLabel("????");

        //create dp
        dp = new JDesktopPane();

        //create TextField
        sear_bar = new JTextField("Search                                                                                                                                        ");

        //create Internalframe
        if1 = new JInternalFrame("Page", false, false, false, false);
        up_if = new JInternalFrame("UP_BAR", false, false, false, false);

        //create JPanel
        pmain = new JPanel();
        pnorth = new JPanel();
        pleft = new JPanel();
        ptask = new JPanel();
        pcar = new JPanel();
        papr = new JPanel();
        pdead = new JPanel();
        pcen = new JPanel();
        npane1 = new JPanel();
        npane2 = new JPanel();
        npane3 = new JPanel();
        ptask.setLayout(new GridLayout(2,1));
        pcar.setLayout(new GridLayout(2,1));
        papr.setLayout(new GridLayout(2,1));
        pdead.setLayout(new GridLayout(2,1));
        pleft.setLayout(new GridLayout(4,1));
        pnorth.setLayout(new GridLayout(1, 3));
        npane1.setLayout(new FlowLayout());
        npane2.setLayout(new FlowLayout());
        npane3.setLayout(new FlowLayout());

        //add to upnorth
        npane1.add(
                new Image_Resizer(new ImageIcon("resources/Images/Logo.jpg"), 50, 100)
        );
        npane2.add(sear_bar);
        sear_bar.setSize(200,100);
        npane3.add(new_bn);
        npane3.add(op_bn);
        pnorth.add(npane1);
        pnorth.add(npane2);
        pnorth.add(npane3);
        up_if.add(pnorth);
        dp.add(up_if, BorderLayout.NORTH);

        //add to pLeft
        ptask.add(l1);
        ptask.add(task_bn);
        pcar.add(l2);
        pcar.add(ca_bn);
        papr.add(l3);
        papr.add(apr_bn);
        pdead.add(l4);
        pleft.add(ptask);
        pleft.add(pcar);
        pleft.add(papr);
        pleft.add(pdead);
        if1.getContentPane().add(pleft, BorderLayout.CENTER);
        dp.add(if1, BorderLayout.WEST);

        //if1 setting
        if1.setVisible(true);
        if1.setBounds(-1, 125, 300, 875);

        //up_if setting
        up_if.setVisible(true);
        up_if.setBounds(-1, -30, 1920, 200);



        //add to center
        pmain.add(pcen, BorderLayout.CENTER);

        //set dp
        dp.setBackground(Color.WHITE);

        // add dp to fr
        fr.add(dp);
        fr.setJMenuBar(men);
        men.add(fil);
        men.add(edit);
        men.add(view);
        men.add(tool);
        men.add(win);
        men.add(help);

        //set visible
        fr.setSize(1920,1080);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        new Main_Interact();
    }
}