package com.kmitl.pectjro.Frame.Admin;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.SetupPage.Main_Setup;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminManagement extends JFrame implements ActionListener {
    private JDesktopPane desktopPane;
    private JMenuItem newUserMenuItem, viewUserMenuItem, editUserMenuItem;

    public AdminManagement() {
        setTitle("Admin Management");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu userMenu = new JMenu("User");
        newUserMenuItem = new JMenuItem("New User");
        viewUserMenuItem = new JMenuItem("View User");
        editUserMenuItem = new JMenuItem("Edit User");
        newUserMenuItem.addActionListener(this);
        viewUserMenuItem.addActionListener(this);
        editUserMenuItem.addActionListener(this);
        userMenu.add(newUserMenuItem);
        userMenu.add(viewUserMenuItem);
        userMenu.add(editUserMenuItem);
        menuBar.add(userMenu);
        setJMenuBar(menuBar);

        // Create DesktopPane
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newUserMenuItem) {
            JInternalFrame newUserFrame = new JInternalFrame("New User", true, true, true, true);
            // Add components for new user frame
            // For example:
            JPanel newUserPanel = new JPanel();
            newUserPanel.add(new JLabel("Username:"));
            newUserPanel.add(new JTextField(20));
            newUserPanel.add(new JLabel("Password:"));
            newUserPanel.add(new JPasswordField(20));
            newUserFrame.add(newUserPanel);
            desktopPane.add(newUserFrame);
            newUserFrame.setSize(300, 200);
            newUserFrame.setVisible(true);
        } else if (e.getSource() == viewUserMenuItem) {
            // Add code for viewing user
            // For example:
            JOptionPane.showMessageDialog(this, "View User clicked");
        } else if (e.getSource() == editUserMenuItem) {
            // Add code for editing user
            // For example:
            JOptionPane.showMessageDialog(this, "Edit User clicked");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new AdminManagement());
    }
}

