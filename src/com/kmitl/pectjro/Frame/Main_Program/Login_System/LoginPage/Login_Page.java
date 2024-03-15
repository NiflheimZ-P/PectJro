package com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

import com.kmitl.pectjro.Frame.Groups_interface.LoginPage;
import com.kmitl.pectjro.Frame.Tools.*;

public class Login_Page implements LoginPage {
    // Attribute
    private final JPanel main_panel;
    private JInfoGet email = new JInfoGet("Email");
    private JPassGet password = new JPassGet("Password");
    private JCheckBox check = new JCheckBox("Remember Me");
    private JButton login = new JButton("Login");
    private JButton sign = new JButton("Sign up");

    // Constructor
    public Login_Page() {
        super();
        main_panel = new JPanel();
        main_panel.setBackground(Color.white);
        main_panel.setBorder(new CompoundBorder(
                new EmptyBorder(5, 5, 5, 5),
                new MatteBorder(1, 1, 1, 1, Color.gray)
        ));
        main_panel.setPreferredSize(new Dimension(480, 610));
        main_panel.setLayout(new GridBagLayout());

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
        main_panel.add(login, new Constraints(0, 5, 0, 1, new Insets(0, 0, 0, 0)));

        JPanel under = new JPanel();
        under.add(new JLabel("Haven't signed yet"));
        under.add(sign);
        under.setBackground(Color.white);
        main_panel.add(under, new Constraints(0, 6, 0, 0, new Insets(0, 0, 20, 0)));
    }

    // Accessor
    @Override
    public JPanel getPanel() { return main_panel; }

    public JButton getLogin() {return login;}
    public JButton getSign() {return sign;}
    public JInfoGet getEmail() {return email;}
    public JPassGet getPass() {return password;}
    public JCheckBox getCheck() {return check;}

}
