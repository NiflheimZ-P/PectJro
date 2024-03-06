package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

import com.kmitl.pectjro.Frame.Main_Program.Main_Frame;
import com.kmitl.pectjro.Frame.Tools.*;

public class Login_Page extends JPanel {
    private JInfoGet email = new JInfoGet("Email");
    private JPassGet password = new JPassGet("Password");
    private JCheckBox check = new JCheckBox("Remember Me");
    private JButton login = new JButton("Login");
    private JButton sign = new JButton("Sign up");
    public Login_Page(Main_Frame frame) {
        super();
        this.setBackground(Color.white);
        this.setBorder(new CompoundBorder(
                new EmptyBorder(5, 5, 5, 5),
                new MatteBorder(1, 1, 1, 1, Color.gray)
        ));
        this.setPreferredSize(new Dimension(480, 610));
        this.setLayout(new GridBagLayout());

        sign.addActionListener(frame);

        this.add(
                new Image_Resizer(new ImageIcon("resources/Images/Logo.png"), 200, 200),
                new Constraints(0, 0, 0, 1, new Insets(0, 0, 0, 0))
        );

        email.setPreferredSize(new Dimension(350, 35));
        this.add(email, new Constraints(0, 1, 0, 0, new Insets(0, 0, 0, 0)));

        password.setPreferredSize(new Dimension(350, 35));
        this.add(password, new Constraints(0, 2, 0, 0, new Insets(20, 0, 0, 0)));

        this.add(check, new Constraints(0, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, new Insets(20, 0, 0, 0)));

        login.setFont(new Font("", Font.PLAIN, 13));
        login.setPreferredSize(new Dimension(200, 50));
        this.add(login, new Constraints(0, 5, 0, 1, new Insets(0, 0, 0, 0)));

        JPanel under = new JPanel();
        under.add(new JLabel("Haven't signed yet"));
        under.add(sign);
        under.setBackground(Color.white);
        this.add(under, new Constraints(0, 6, 0, 0, new Insets(0, 0, 20, 0)));
    }
}
