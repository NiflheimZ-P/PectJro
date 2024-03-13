package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.Image_Resizer;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import com.kmitl.pectjro.Frame.Tools.JPassGet;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class UserAdd {
    // Attribute
    private JInternalFrame frame;
    private JPanel main_panel, west_panel, center, south_panel;
    private Image_Resizer image;
    private JButton chooser, save, cancel;
    private JInfoGet first, last, username, gmail;
    private JPassGet pass, confirm_pass;
    private JCheckBox admin;

    // Constructor
    public UserAdd() {
        frame = new JInternalFrame("Add new user", true, true, false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        main_panel = new JPanel(new BorderLayout());
        west_panel = new JPanel(new GridBagLayout());
        south_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        center = new JPanel(new GridBagLayout());

        west_panel.add(new JLabel("Profile picture"), new Constraints(0, 0, 1, 1, GridBagConstraints.PAGE_END, new Insets(0, 20, 0, 20)));

        image = new Image_Resizer(new ImageIcon("resources/Images/aunkung.jpeg"), 125, 125);
        west_panel.add(image, new Constraints(0, 1, 1, 0, new Insets(20, 20, 20, 20)));

        chooser = new JButton("Choose image");
        west_panel.add(chooser, new Constraints(0, 2, 1, 1, GridBagConstraints.PAGE_START, new Insets(0, 20, 0, 20)));

        first = new JInfoGet("Firstname"); last = new JInfoGet("Lastname");
        gmail = new JInfoGet("Gmail");
        username = new JInfoGet("Username");
        pass = new JPassGet("Password"); confirm_pass = new JPassGet("Confirm Password");
        admin = new JCheckBox("This user can access admin mode?");

        first.setPreferredSize(new Dimension(185, 40)); last.setPreferredSize(new Dimension(185, 40));
        gmail.setPreferredSize(new Dimension(380, 40)); username.setPreferredSize(new Dimension(185, 40));
        pass.setPreferredSize(new Dimension(185, 40)); confirm_pass.setPreferredSize(new Dimension(185, 40));

        center.setBorder(new CompoundBorder(
                new EmptyBorder(10, 10, 0, 10),
                new TitledBorder("User Information")
        ));
        center.add(first, new Constraints(0, 0, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(last, new Constraints(1, 0, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(gmail, new Constraints(0, 1, 2, 1, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(username, new Constraints(0, 3, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(pass, new Constraints(0, 4, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(confirm_pass, new Constraints(1, 4, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(admin, new Constraints(0, 5, 2, 1, 1, 1, 21, new Insets(0, 5, 0, 0)));

        save = new JButton("Save");
        cancel = new JButton("Cancel");

        south_panel.add(save);
        south_panel.add(cancel);

        main_panel.add(west_panel, BorderLayout.WEST);
        main_panel.add(center);
        main_panel.add(south_panel, BorderLayout.SOUTH);

        frame.add(main_panel);
    }

    // Accessor
    public JInternalFrame getFrame() {
        return frame;
    }
}
