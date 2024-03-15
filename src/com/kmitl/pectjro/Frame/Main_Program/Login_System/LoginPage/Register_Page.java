package com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.kmitl.pectjro.Frame.Groups_interface.LoginPage;
import com.kmitl.pectjro.Frame.Tools.*;

public class Register_Page implements LoginPage {
    // Attribute
    private JPanel main_panel;
    private JLabel regis, firstname, lastname, username, password, confirmpass, email;
    private JTextField firstname_field, lastname_field, username_field, email_field;
    private JPasswordField password_field, confirmpass_field;
    private JButton submit, back;

    // Constructor
    public Register_Page() {
        super();
        main_panel = new JPanel();
        main_panel.setBackground(Color.white);
        main_panel.setBorder(new CompoundBorder(
                new EmptyBorder(5, 5, 5, 5),
                new MatteBorder(1, 1, 1, 1, Color.gray)
        ));
        main_panel.setPreferredSize(new Dimension(480, 610));
        main_panel.setLayout(new GridBagLayout());

        regis = new JLabel("Register"); firstname = new JLabel("Firstname"); lastname = new JLabel("Lastname"); username = new JLabel("Username");
        password = new JLabel("Password"); confirmpass = new JLabel("Confirm Password"); email = new JLabel("Email");

        firstname_field = new JTextField(); lastname_field = new JTextField(); username_field = new JTextField(); password_field = new JPasswordField();
        confirmpass_field = new JPasswordField(); email_field = new JTextField();

        submit = new JButton("Submit"); back = new JButton("Back");
        submit.setToolTipText("Missing some information");
        // Register
        regis.setFont(new Font("", Font.BOLD, 40));
        main_panel.add(regis, new Constraints(0, 0, 2, 1, 1, 1,
                new Insets(0, 0, 0, 0)));

        // Firstname
        firstname.setFont(new Font("", Font.PLAIN, 13));
        main_panel.add(firstname, new Constraints(0, 1, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 0, 0)));

        // Firstname_Field
        firstname_field.setPreferredSize(new Dimension(200, 35));
        firstname_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        main_panel.add(firstname_field, new Constraints(0, 2, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Lastname
        lastname.setFont(new Font("", Font.PLAIN, 13));
        main_panel.add(lastname, new Constraints(1, 1, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 13)));

        // Lastname_Field
        lastname_field.setPreferredSize(new Dimension(200, 35));
        lastname_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        main_panel.add(lastname_field, new Constraints(1, 2, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 20, 13)));

        // Username
        username.setFont(new Font("", Font.PLAIN, 13));
        main_panel.add(username, new Constraints(0, 3, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 0, 0)));

        // Username_Field
        username_field.setPreferredSize(new Dimension(200, 35));
        username_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        main_panel.add(username_field, new Constraints(0, 4, 2, 1, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Password
        password.setFont(new Font("", Font.PLAIN, 13));
        main_panel.add(password, new Constraints(0, 5, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 0, 0)));

        // Password_Field
        password_field.setPreferredSize(new Dimension(200, 35));
        password_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        main_panel.add(password_field, new Constraints(0, 6, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Confirm Password
        confirmpass.setFont(new Font("", Font.PLAIN, 13));
        main_panel.add(confirmpass, new Constraints(1, 5, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 0)));

        // Confirm Password_Field
        confirmpass_field.setPreferredSize(new Dimension(200, 35));
        confirmpass_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        main_panel.add(confirmpass_field, new Constraints(1, 6, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 20, 0)));

        // Email
        email.setFont(new Font("", Font.PLAIN, 13));
        main_panel.add(email, new Constraints(0, 7, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 0, 0)));

        // Email_Field
        email_field.setPreferredSize(new Dimension(413, 35));
        email_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        main_panel.add(email_field, new Constraints(0, 8, 2, 1, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Submit Button
        submit.setEnabled(false);
        submit.setFont(new Font("", Font.PLAIN, 20));
        submit.setPreferredSize(new Dimension(180, 50));
        main_panel.add(submit, new Constraints(0, 10,  1, 1,
                new Insets(0, 0, 0, 0)));

        // Back Button
        back.setFont(new Font("", Font.PLAIN, 20));
        back.setPreferredSize(new Dimension(180, 50));
        main_panel.add(back, new Constraints(1, 10, 1, 1,
                new Insets(0, 0, 0, 13)));

    }

    // Accessor
    @Override
    public JPanel getPanel() {return main_panel;}

    public JTextField getFirstname_field() {
        return firstname_field;
    }

    public JTextField getLastname_field() {
        return lastname_field;
    }

    public JTextField getUsername_field() {
        return username_field;
    }

    public JPasswordField getPassword_field() {
        return password_field;
    }

    public JPasswordField getConfirmpass_field() {
        return confirmpass_field;
    }

    public JTextField getEmail_field() {
        return email_field;
    }

    public JButton getSubmit() {
        return submit;
    }

    public JButton getBack() {
        return back;
    }
}