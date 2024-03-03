package com.kmitl.pectjro.Frame.Main_Program;
import java.awt.*;
import javax.swing.*;

public class Main_Interact{
    private JFrame fr;
    private JPanel pmain, pnorth, pleft, pcen, ptask, pcar, papr, pdead;
    private JButton task_bn, ca_bn, apr_bn, new_bn, op_bn;
    private JMenuBar men;
    private JMenu fil, edit, view, tool, win, help;
    private JLabel l1, l2, l3, l4;
    private JTextField sear_bar;
    private JDesktopPane dp;
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
        sear_bar = new JTextField();

        //create JPanel
        pmain = new JPanel();
        pnorth = new JPanel();
        pleft = new JPanel();
        ptask = new JPanel();
        pcar = new JPanel();
        papr = new JPanel();
        pdead = new JPanel();
        pcen = new JPanel();
        ptask.setLayout(new GridLayout(2,1));
        pcar.setLayout(new GridLayout(2,1));
        papr.setLayout(new GridLayout(2,1));
        pdead.setLayout(new GridLayout(2,1));
        pleft.setLayout(new GridLayout(4,1));

        //add to pnorth


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
        pmain.add(pleft, BorderLayout.WEST);

        //add to center
        pmain.add(pcen, BorderLayout.CENTER);

        //set dp
        dp.setBackground(Color.lightGray);

        // add dp to fr
        fr.add(pmain);
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
    }

    public static void main(String[] args) {
        new Main_Interact();
    }
}