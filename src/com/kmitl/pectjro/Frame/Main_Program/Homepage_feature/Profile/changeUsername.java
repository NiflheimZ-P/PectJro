package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;


import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.SQLOutput;
public class changeUsername {
    private JFrame fr;
    private JPanel pmain, top_mar, west_mar, east_mar;
    private JButton submit, cancel;
    private JTextField user;
    private JLabel txt;

    public changeUsername(){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //panel
        pmain = new JPanel();
        pmain.setLayout(new FlowLayout(2));
        top_mar = new JPanel();
        top_mar.setLayout(new FlowLayout(0));
        east_mar = new JPanel();
        west_mar = new JPanel();

        //Jlabel
        txt = new JLabel("    Change Username");

        //button
        submit = new JButton("Done");
        cancel = new JButton("Cancel");

        //txtfield
        user = new JTextField();

        //pmain
        pmain.add(submit); pmain.add(cancel);

        //set user
        pmain.setPreferredSize(new Dimension(400, 40));

        //set top
        top_mar.add(txt);
        top_mar.setPreferredSize(new Dimension(0, 35));

        east_mar.setPreferredSize(new Dimension(15, 0));
        west_mar.setPreferredSize(new Dimension(15, 0));

        //add to frame
        fr.add(top_mar, BorderLayout.NORTH);
        fr.add(east_mar, BorderLayout.EAST);
        fr.add(west_mar, BorderLayout.WEST);
        fr.add(user, BorderLayout.CENTER);
        fr.add(pmain, BorderLayout.SOUTH);

        //set visible and size
        fr.setSize(400, 150);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public JButton getSubmit() {
        return submit;
    }

    public JTextField getUser() {
        return user;
    }

    public JButton getCancel() {
        return cancel;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel( new FlatMacDarkLaf() );
        SwingUtilities.invokeLater(() -> {new changeUsername();});
    }
}
