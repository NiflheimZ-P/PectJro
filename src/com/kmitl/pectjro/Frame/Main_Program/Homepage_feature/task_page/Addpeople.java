package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;

import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.SQLOutput;

public class Addpeople {
    private JFrame fr;
    private JPanel p_main, p_zone1, p_zone2, p_zone11, p_zone12, west, top;
    private JButton Add, Close;
    private JTextArea ta;
    private JTextField tx;
    private JInfoGet search_member;
    private JLabel l1;

    public Addpeople(){
        fr = new JFrame();
        p_main = new JPanel();
        p_zone1 = new JPanel();
        p_zone2 = new JPanel();
        p_zone11 = new JPanel();
        p_zone12 = new JPanel();
        Add = new JButton("Add");
        Close = new JButton("Close");
        tx = new JTextField();
        ta = new JTextArea();
        top = new JPanel();
        west = new JPanel();

        search_member = new JInfoGet("Search Member");

        l1 = new JLabel("Add member to this project");

        fr.add(p_main);
        p_main.setLayout(new GridLayout(1,2));
        p_main.add(p_zone1);
        p_main.add(p_zone2);

        p_zone1.setLayout(new BorderLayout());
        p_zone1.add(p_zone11, BorderLayout.CENTER);
        p_zone1.add(p_zone12, BorderLayout.SOUTH);
        p_zone12.setPreferredSize(new Dimension(300,140));

        p_zone11.setLayout(new BorderLayout());

        p_zone11.add(west, BorderLayout.WEST);
        p_zone11.add(top, BorderLayout.NORTH);
        top.setPreferredSize(new Dimension(200,60));
        west.setPreferredSize(new Dimension(0,100));
        JPanel tmp = new JPanel();
        p_zone11.add(tmp, BorderLayout.CENTER);
        tmp.add(l1);
        l1.setFont(new Font("Sans", Font.PLAIN, 14));
        tmp.add(tx);
        tx.setPreferredSize(new Dimension(200,40));
        tx.setBackground(new Color(30,31,34));

        p_zone12.setLayout(new FlowLayout());
        p_zone12.add(Add);
        Add.setPreferredSize(new Dimension(90,40));
        Add.setBorder(BorderFactory.createEmptyBorder());
        Add.setFont(new Font("Sans", Font.PLAIN, 12));
        p_zone12.add(Close);
        Close.setPreferredSize(new Dimension(90,40));
        Close.setBorder(BorderFactory.createEmptyBorder());
        Close.setFont(new Font("Sans", Font.PLAIN, 12));
        

        p_zone2.setLayout(new FlowLayout());
        p_zone2.add(ta);
        ta.setBackground(new Color(30,31,34));
        ta.setPreferredSize(new Dimension(250,265));
        ta.setEditable(false);

        //set Color
        p_main.setBackground(new Color(49,51,56));
        p_zone1.setBackground(new Color(49,51,56));
        p_zone2.setBackground(new Color(49,51,56));
        tmp.setBackground(new Color(49,51,56));
        p_zone11.setBackground(new Color(49,51,56));
        p_zone12.setBackground(new Color(49,51,56));
        west.setBackground(new Color(49,51,56));
        top.setBackground(new Color(49,51,56));
        Add.setBackground(new Color(30,31,34));
        Close.setBackground(new Color(30,31,34));

        fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setSize(600,300);
        fr.setVisible(true);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel( new FlatMacDarkLaf() );
        SwingUtilities.invokeLater(() -> {new Addpeople();});
    }
}