package com.kmitl.pectjro.Frame.SetupPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.kmitl.pectjro.Frame.Tools.*;

public class connect_panel extends JPanel implements DocumentListener, ActionListener {
    private JLabel info;
    private JPanel connection_info;
    private static JTextField hostname, port, username, database;
    private static JPasswordField password;
    private JCheckBox allow;
    public connect_panel() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        info = new JLabel();
        info.setText("<html><h1>Database connection</h1><br/>You can create your own database and insert it here.<br/></html>");
        this.add(info);

        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(200, 20));
        this.add(space);

        connection_info = new JPanel(new GridBagLayout());
        connection_info.setBorder(BorderFactory.createCompoundBorder(
                new TitledBorder("Connection info"),
                new EmptyBorder(5, 5, 5, 5)));

        hostname = new JTextField("", 15); port = new JTextField(""); database = new JTextField("", 26);
        username = new JTextField("", 26); password = new JPasswordField("", 26);
        allow = new JCheckBox("Allow this app to create your database connection and table.");


        hostname.getDocument().addDocumentListener(this); allow.addActionListener(this); port.getDocument().addDocumentListener(this);
        database.getDocument().addDocumentListener(this); username.getDocument().addDocumentListener(this); password.getDocument().addDocumentListener(this);

        this.add(connection_info);

        // GridBag Component
        connection_info.add(new JLabel("Hostname"), new Constraints(0, 0, 0, 0, GridBagConstraints.LINE_START, new Insets(5, 5, 5, 5)));
        connection_info.add(hostname, new Constraints(1, 0, new Insets(5, 5, 5, 15)));
        connection_info.add(new JLabel("Port"), new Constraints(2, 0, new Insets(5, 5, 5, 5)));
        connection_info.add(port, new Constraints(3, 0, new Insets(5, 5, 5, 5)));
        connection_info.add(new JLabel("Database"), new Constraints(0, 1, new Insets(5, 5, 30, 5)));
        connection_info.add(database, new Constraints(1, 1, 3, 1, 0, 0, new Insets(5, 5, 30, 5)));
        connection_info.add(new JLabel("Username"), new Constraints(0, 2, new Insets(5, 5, 5, 5)));
        connection_info.add(username, new Constraints(1, 2, 3, 1, 0, 0, new Insets(5, 5, 5, 5)));
        connection_info.add(new JLabel("Password"), new Constraints(0, 3, new Insets(5, 5, 5, 5)));
        connection_info.add(password, new Constraints(1, 3, 3, 1, 0, 0, new Insets(5, 5, 5, 5)));

        allow.setMargin(new Insets(10, 0, 0, 0));
        this.add(allow);
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(hostname.getText().trim());
        data.add(port.getText().trim());
        data.add(database.getText().trim());
        data.add(username.getText().trim());
        data.add(String.valueOf(password.getPassword()));
        return data;
    }

    public boolean checkInfo(){
        Main_Setup.bypass = false;
        return (!username.getText().trim().isEmpty() & !hostname.getText().trim().isEmpty() & !port.getText().trim().isEmpty() &
                !database.getText().trim().isEmpty() & !String.valueOf(password.getPassword()).isEmpty() & allow.isSelected());
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        Main_Setup.next.setEnabled(checkInfo());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        Main_Setup.next.setEnabled(checkInfo());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        Main_Setup.next.setEnabled(checkInfo());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main_Setup.next.setEnabled(checkInfo());}
}
