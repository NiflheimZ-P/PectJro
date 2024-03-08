package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import com.kmitl.pectjro.Database.DB_Command;
import com.kmitl.pectjro.Frame.Cache_Templates.User_Template;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame;
import com.kmitl.pectjro.Frame.Main_Program.home_page;
import com.kmitl.pectjro.Frame.Tools.*;
import java.io.*;

public class Login_Page implements ActionListener {
    private static JPanel main_panel;
    private JInfoGet email = new JInfoGet("Email");
    private JPassGet password = new JPassGet("Password");
    private JCheckBox check = new JCheckBox("Remember Me");
    private JButton login = new JButton("Login");
    private JButton sign = new JButton("Sign up");
    public Login_Page(ActionListener frame) {
        super();
        main_panel = new JPanel();
        main_panel.setBackground(Color.white);
        main_panel.setBorder(new CompoundBorder(
                new EmptyBorder(5, 5, 5, 5),
                new MatteBorder(1, 1, 1, 1, Color.gray)
        ));
        main_panel.setPreferredSize(new Dimension(480, 610));
        main_panel.setLayout(new GridBagLayout());

        sign.addActionListener(frame);

        main_panel.add(
                new Image_Resizer(new ImageIcon("resources/Images/Logo.png"), 200, 200),
                new Constraints(0, 0, 0, 1, new Insets(0, 0, 0, 0))
        );

        email.setPreferredSize(new Dimension(350, 35));
        main_panel.add(email, new Constraints(0, 1, 0, 0, new Insets(0, 0, 0, 0)));

        password.setPreferredSize(new Dimension(350, 35));
        main_panel.add(password, new Constraints(0, 2, 0, 0, new Insets(20, 0, 0, 0)));

        main_panel.add(check, new Constraints(0, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, new Insets(20, 0, 0, 0)));

        login.setFont(new Font("", Font.PLAIN, 13));
        login.setPreferredSize(new Dimension(200, 50));
        login.addActionListener(this);
        main_panel.add(login, new Constraints(0, 5, 0, 1, new Insets(0, 0, 0, 0)));

        JPanel under = new JPanel();
        under.add(new JLabel("Haven't signed yet"));
        under.add(sign);
        under.setBackground(Color.white);
        main_panel.add(under, new Constraints(0, 6, 0, 0, new Insets(0, 0, 20, 0)));
    }

    public JPanel getMain_panel() { return main_panel; }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gmail = email.getText();
        String pass = password.getMyPass();
        HashMap<String, String> thisGmail;
		try { thisGmail = DB_Command.getUserData(gmail); }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "The email address doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
		}
        if (loginSystem(pass, thisGmail)) {
            Main_Frame.changePage(new home_page());
        }
	}

    public boolean loginSystem(String pass, HashMap<String, String> data) {
        if(!pass.equals(data.get("password"))){
            JOptionPane.showMessageDialog(null, "Password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            Main_Login.setRemember(check.isSelected());
        }
        User_Template cache = new User_Template();
        cache.setData(data);
        File remember = new File("User_Cache");
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(remember))) {
            remember.createNewFile();
            write.writeObject(cache);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
