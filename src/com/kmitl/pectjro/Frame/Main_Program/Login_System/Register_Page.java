package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame;
import com.kmitl.pectjro.Frame.Tools.*;
import com.kmitl.pectjro.Database.DB_Command;

public class Register_Page extends JPanel implements FocusListener {
    private JLabel regis, firstname, lastname, username, password, confirmpass, email;
    private JTextField firstname_field, lastname_field, username_field, password_field, confirmpass_field, email_field;
    private JButton submit, back;
    public Register_Page(Main_Frame frame) {
        super();
        this.setBackground(Color.white);
        this.setBorder(new CompoundBorder(
                new EmptyBorder(5, 5, 5, 5),
                new MatteBorder(1, 1, 1, 1, Color.gray)
        ));
        this.setPreferredSize(new Dimension(480, 610));
        this.setLayout(new GridBagLayout());

        regis = new JLabel("Register"); firstname = new JLabel("Firstname"); lastname = new JLabel("Lastname"); username = new JLabel("Username");
        password = new JLabel("Password"); confirmpass = new JLabel("Confirm Password"); email = new JLabel("Email");

        firstname_field = new JTextField(); lastname_field = new JTextField(); username_field = new JTextField(); password_field = new JTextField();
        confirmpass_field = new JTextField(); email_field = new JTextField();

        submit = new JButton("Submit"); back = new JButton("Back"); back.addActionListener(frame);

        // Register
        regis.setFont(new Font("", Font.BOLD, 40));
        this.add(regis, new Constraints(0, 0, 2, 1, 1, 1,
                new Insets(0, 0, 0, 0)));

        // Firstname
        firstname.setFont(new Font("", Font.PLAIN, 13));
        this.add(firstname, new Constraints(0, 1, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 0, 0)));

        // Firstname_Field
        firstname_field.setPreferredSize(new Dimension(200, 35));
        firstname_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(firstname_field, new Constraints(0, 2, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Lastname
        lastname.setFont(new Font("", Font.PLAIN, 13));
        this.add(lastname, new Constraints(1, 1, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 13)));

        // Lastname_Field
        lastname_field.setPreferredSize(new Dimension(200, 35));
        lastname_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(lastname_field, new Constraints(1, 2, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 20, 13)));

        // Username
        username.setFont(new Font("", Font.PLAIN, 13));
        this.add(username, new Constraints(0, 3, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 0, 0)));

        // Username_Field
        username_field.setPreferredSize(new Dimension(200, 35));
        username_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(username_field, new Constraints(0, 4, 2, 1, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Password
        password.setFont(new Font("", Font.PLAIN, 13));
        this.add(password, new Constraints(0, 5, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 0, 0)));

        // Password_Field
        password_field.setPreferredSize(new Dimension(200, 35));
        password_field.addFocusListener(this);
        password_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(password_field, new Constraints(0, 6, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Confirm Password
        confirmpass.setFont(new Font("", Font.PLAIN, 13));
        this.add(confirmpass, new Constraints(1, 5, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 0)));

        // Confirm Password_Field
        confirmpass_field.setPreferredSize(new Dimension(200, 35));
        confirmpass_field.addFocusListener(this);
        confirmpass_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(confirmpass_field, new Constraints(1, 6, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 20, 0)));

        // Email
        email.setFont(new Font("", Font.PLAIN, 13));
        this.add(email, new Constraints(0, 7, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 0, 0)));

        // Email_Field
        email_field.setPreferredSize(new Dimension(413, 35));
        email_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(email_field, new Constraints(0, 8, 2, 1, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Submit Button
        submit.addActionListener(frame);
        submit.setFont(new Font("", Font.PLAIN, 20));
        submit.setPreferredSize(new Dimension(180, 50));
        this.add(submit, new Constraints(0, 10,  1, 1,
                new Insets(0, 0, 0, 0)));

        // Back Button
        back.setFont(new Font("", Font.PLAIN, 20));
        back.setPreferredSize(new Dimension(180, 50));
        this.add(back, new Constraints(1, 10, 1, 1,
                new Insets(0, 0, 0, 13)));

    }

    public boolean creatingAccount() {
        String user = username_field.getText();
        String gmail = email_field.getText();
        String pass = password_field.getText();
        String first = firstname_field.getText();
        String last = lastname_field.getText();
        if (user.trim().equals("") | gmail.trim().equals("") | pass.trim().equals("") |
                first.trim().equals("") | last.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert all the info", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                DB_Command.addUserData(user, gmail, pass, first, last);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "this email is already in use", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Your account has been created", "Created", JOptionPane.PLAIN_MESSAGE);
        return true;
    }

    public void setEmpty() {
        username_field.setText("");
        email_field.setText("");
        password_field.setText("");
        firstname_field.setText("");
        lastname_field.setText("");
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource().equals(confirmpass_field))
            if (!password_field.getText().equals(confirmpass_field.getText())) {
                confirmpass_field.setFont(new Font("", Font.ITALIC, 13));
                confirmpass_field.setForeground(Color.RED);
                submit.setEnabled(false);
            } else {
                confirmpass_field.setFont(new Font("Dialog", Font.PLAIN, 13));
                confirmpass_field.setForeground(Color.BLACK);
                submit.setEnabled(true);
            }
        else {
            if (password_field.getText().equals(confirmpass_field.getText())) {
                confirmpass_field.setFont(new Font("Dialog", Font.PLAIN, 13));
                confirmpass_field.setForeground(Color.BLACK);
                submit.setEnabled(true);
            }
        }
    }
}