package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
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
    public Addpeople(){
        fr = new JFrame();
        p_main = new JPanel();
        p_zone1 = new JPanel();
        p_zone2 = new JPanel();
        p_zone11 = new JPanel();
        p_zone12 = new JPanel();
        Add = new JButton("Add");
        Close = new JButton("Close");
        tx = new JTextField("Search");
        ta = new JTextArea();
        top = new JPanel();
        west = new JPanel();

        fr.add(p_main);
        p_main.setLayout(new GridLayout(1,2));
        p_main.add(p_zone1);
        p_main.add(p_zone2);

        p_zone1.setLayout(new BorderLayout());
        p_zone1.add(p_zone11, BorderLayout.CENTER);
        p_zone1.add(p_zone12, BorderLayout.SOUTH);
        p_zone12.setPreferredSize(new Dimension(300,150));

        p_zone11.setLayout(new BorderLayout());

        p_zone11.add(west, BorderLayout.WEST);
        p_zone11.add(top, BorderLayout.NORTH);
        top.setPreferredSize(new Dimension(200,60));
        west.setPreferredSize(new Dimension(20,100));
        p_zone11.add(tx, BorderLayout.CENTER);
        tx.setPreferredSize(new Dimension(200,40));

        p_zone12.setLayout(new FlowLayout());
        p_zone12.add(Add);
        Add.setPreferredSize(new Dimension(90,40));
        p_zone12.add(Close);
        Close.setPreferredSize(new Dimension(90,40));

        p_zone2.setLayout(new FlowLayout());
        p_zone2.add(ta);
        ta.setPreferredSize(new Dimension(250,500));
        ta.setEditable(false);

        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setSize(600,300);
        fr.setVisible(true);






    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel( new FlatMacDarkLaf() );
        SwingUtilities.invokeLater(() -> {new Addpeople();});
    }
}
