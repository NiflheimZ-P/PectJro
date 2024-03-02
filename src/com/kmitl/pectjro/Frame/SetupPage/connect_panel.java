package com.kmitl.pectjro.Frame.SetupPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class connect_panel extends JPanel {
    private JLabel info;
    private JPanel connection_info;
    private static JTextField hostname, port, username, database;
    private static JPasswordField password;
    public connect_panel() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        info = new JLabel();
        info.setText("<html><h1>Database connection</h1><br/>You can create your own database and insert it here, or you can<br/> use our default database<br/></html>");
        this.add(info);

        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(100, 20));
        this.add(space);

        connection_info = new JPanel(new GridBagLayout());
        connection_info.setBorder(BorderFactory.createCompoundBorder(
                new TitledBorder("Connection info"),
                new EmptyBorder(5, 5, 5, 5)));
        GridBagConstraints manage = new GridBagConstraints();

        hostname = new JTextField("aws.connect.psdb.cloud", 15); port = new JTextField("3306"); database = new JTextField("pectjro", 26);
        username = new JTextField("xvxoe83rvsqzbc17w6ei", 26); password = new JPasswordField("pscale_pw_7gnJ1oQeReoFSUd5mOu8Q3EIYr5N4PXzJs93Ecz2PUy", 26);

        manage.insets = new Insets(5, 5, 5, 5);
        manage.anchor = GridBagConstraints.LINE_START;
        manage.gridx = 0;
        manage.gridy = 0;
        connection_info.add(new JLabel("Hostname"), manage);

        manage.insets = new Insets(5, 5, 5, 15);
        manage.gridx = 1;
        connection_info.add(hostname, manage);

        manage.insets = new Insets(5, 5, 5, 5);
        manage.gridx = 2;
        connection_info.add(new JLabel("Port"), manage);

        manage.gridx = 3;
        connection_info.add(port, manage);

        manage.insets = new Insets(5, 5, 30, 5);
        manage.gridy = 1;
        manage.gridx = 0;
        connection_info.add(new JLabel("Database"), manage);

        manage.gridx = 1;
        manage.gridwidth = 3;
        connection_info.add(database, manage);

        manage.insets = new Insets(5, 5, 5, 5);
        manage.gridwidth = 1;
        manage.gridx = 0;
        manage.gridy = 2;
        connection_info.add(new JLabel("Username"), manage);

        manage.gridx = 1;
        manage.gridwidth = 3;
        connection_info.add(username, manage);

        manage.gridwidth = 1;
        manage.gridx = 0;
        manage.gridy = 3;
        connection_info.add(new JLabel("Password"), manage);

        manage.gridwidth = 3;
        manage.gridx = 1;
        connection_info.add(password, manage);

        this.add(connection_info);
    }

    public static ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(hostname.getText().trim());
        data.add(port.getText().trim());
        data.add(database.getText().trim());
        data.add(username.getText().trim());
        String pass = "";
        for (Character i : password.getPassword()) {
            pass += i;
        }
        data.add(pass);
        return data;
    }
}
