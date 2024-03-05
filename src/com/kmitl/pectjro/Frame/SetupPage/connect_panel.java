package com.kmitl.pectjro.Frame.SetupPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import com.kmitl.pectjro.Frame.Tools.*;

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
        username = new JTextField("zt8wkxjqbn95hf7we6fg", 26); password = new JPasswordField("pscale_pw_NHBpwE674vJkMIl8jcJymBBD29T5RHgkZ0asTH0UFUK", 26);

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
