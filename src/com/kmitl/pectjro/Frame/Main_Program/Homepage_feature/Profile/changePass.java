package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLOutput;

public class changePass{
    private JFrame fr;
    private JPanel pmain, top_mar, west_mar, east_mar, pcenter;
    private JButton submit, cancel;
    private JTextField  old_txt, neww_txt, con_txt;
    private JLabel old, neww, con, up_txt;

    public changePass(){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //panel
        pmain = new JPanel();
        pmain.setLayout(new FlowLayout(2,5,4));
        top_mar = new JPanel();
        top_mar.setLayout(new FlowLayout());
        east_mar = new JPanel();
        west_mar = new JPanel();
        pcenter = new JPanel();

        //Jlabel
        old = new JLabel("    Current Password");
        neww = new JLabel("    New Password");
        con = new JLabel("    Confirm Password");
        up_txt = new JLabel("Update You Password");

        //button
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");

        //txtfield
        old_txt = new JTextField();
        neww_txt = new JTextField();
        con_txt = new JTextField();

        //pmain
        pmain.add(submit); pmain.add(cancel);

        //set user
        pmain.setPreferredSize(new Dimension(400, 40));

        //set top
        top_mar.add(up_txt);
        top_mar.setPreferredSize(new Dimension(0, 30));

        east_mar.setPreferredSize(new Dimension(15, 0));
        west_mar.setPreferredSize(new Dimension(15, 0));

        //add to pcenter
        pcenter.setLayout(new GridLayout(6,1));
        pcenter.add(old);
        pcenter.add(old_txt);
        pcenter.add(neww);
        pcenter.add(neww_txt);
        pcenter.add(con);
        pcenter.add(con_txt);

        //add to frame
        fr.add(top_mar, BorderLayout.NORTH);
        fr.add(east_mar, BorderLayout.EAST);
        fr.add(west_mar, BorderLayout.WEST);
        fr.add(pcenter, BorderLayout.CENTER);
        fr.add(pmain, BorderLayout.SOUTH);


        //set visible and size
        fr.setSize(400, 400);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public JButton getSubmit() {
        return submit;
    }

    public JButton getCancel() {
        return cancel;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel( new FlatMacDarkLaf() );
        SwingUtilities.invokeLater(() -> {new changePass();});
    }

    public JTextField getCon_txt() {
        return con_txt;
    }
}

