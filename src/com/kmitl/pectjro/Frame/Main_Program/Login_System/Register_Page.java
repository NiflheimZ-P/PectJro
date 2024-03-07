package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame;
import com.kmitl.pectjro.Frame.Tools.*;
import com.kmitl.pectjro.Database.DB_Command;

public class Register_Page extends JPanel implements DocumentListener {
    private JLabel regis, firstname, lastname, username, password, confirmpass, email;
    private JTextField firstname_field, lastname_field, username_field, email_field;
    private JPasswordField password_field, confirmpass_field;
    private JButton submit, back;
    private String status = "Missing";
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

        firstname_field = new JTextField(); lastname_field = new JTextField(); username_field = new JTextField(); password_field = new JPasswordField();
        confirmpass_field = new JPasswordField(); email_field = new JTextField();

        firstname_field.getDocument().addDocumentListener(this); lastname_field.getDocument().addDocumentListener(this); username_field.getDocument().addDocumentListener(this);
        password_field.getDocument().addDocumentListener(this); confirmpass_field.getDocument().addDocumentListener(this); email_field.getDocument().addDocumentListener(this);

        submit = new JButton("Submit"); back = new JButton("Back"); back.addActionListener(frame);
        submit.setToolTipText("Missing some information");
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
        password_field.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(password_field, new Constraints(0, 6, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 30, 20, 0)));

        // Confirm Password
        confirmpass.setFont(new Font("", Font.PLAIN, 13));
        this.add(confirmpass, new Constraints(1, 5, 0, 0, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 0)));

        // Confirm Password_Field
        confirmpass_field.setPreferredSize(new Dimension(200, 35));
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
        submit.setEnabled(false);
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
        {
            try {
                DB_Command.addUserData(user, gmail, pass, first, last);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "this email is already in use", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            JOptionPane.showMessageDialog(null, "Your account has been created", "Created", JOptionPane.PLAIN_MESSAGE);
            return true;
        }
    }

    public void setEmpty() {
        username_field.setText("");
        email_field.setText("");
        password_field.setText("");
        confirmpass_field.setText("");
        firstname_field.setText("");
        lastname_field.setText("");
    }

    public boolean checkEmpty(){
        return (username_field.getText().isEmpty() ||
                email_field.getText().isEmpty() ||
                String.valueOf(password_field.getPassword()).isEmpty() ||
                String.valueOf(confirmpass_field).isEmpty() ||
                firstname_field.getText().isEmpty() ||
                lastname_field.getText().isEmpty()
        );
    }

    public boolean checkPass(){
        return (String.valueOf(password_field.getPassword()).equals(String.valueOf(confirmpass_field.getPassword())));
    }

    public boolean checkGmail(){
        return (email_field.getText().contains("@") && email_field.getText().contains("."));
    }

    public void updateSubmit(){
        if (!checkEmpty() && checkPass() && checkGmail()){
            submit.setEnabled(true);
            submit.setToolTipText("");
        } else if (!checkPass()) {
            submit.setEnabled(false);
            submit.setToolTipText("password and confirm password validation");
        } else if (checkEmpty()){
            submit.setEnabled(false);
            submit.setToolTipText("Missing some information");
        } else if (!checkGmail()){
            submit.setEnabled(false);
            submit.setToolTipText("Email must contain character '@'");
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater(() -> { updateSubmit(); });
    }



    @Override
    public void removeUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater(() -> { updateSubmit(); });
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater(() -> { updateSubmit(); });
    }
}