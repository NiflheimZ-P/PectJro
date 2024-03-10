package com.kmitl.pectjro.Frame.Admin;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.SetupPage.Main_Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminManagement extends JFrame implements ActionListener {
    private JDesktopPane desktopPane;
    private JMenuItem viewUserMenuItem;
    private JMenuItem mainMenuItem; // เพิ่มเมนูหลัก

    public AdminManagement() {
        setTitle("Admin Management");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu userMenu = new JMenu("User");
        viewUserMenuItem = new JMenuItem("View User");
        viewUserMenuItem.addActionListener(this);
        userMenu.add(viewUserMenuItem);

        // Create Main Menu Item
        mainMenuItem = new JMenuItem("Main Menu");
        mainMenuItem.addActionListener(this);
        menuBar.add(mainMenuItem);

        menuBar.add(userMenu);
        setJMenuBar(menuBar);

        // Create DesktopPane
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewUserMenuItem) {
            // Create and show new internal frame for viewing user data
            JInternalFrame viewUserFrame = new JInternalFrame("View User", true, true, true, true);
            // Add components for viewing user data
            // For example:
            JPanel viewUserPanel = new JPanel();
            viewUserPanel.add(new JLabel("User Data"));
            JTextArea userDataTextArea = new JTextArea(10, 30);
            // Fetch user data from database or any source and set it to the text area
            userDataTextArea.setText("User data fetched from database will be displayed here");
            viewUserPanel.add(userDataTextArea);
            viewUserFrame.add(viewUserPanel);
            desktopPane.add(viewUserFrame);
            viewUserFrame.setSize(400, 300);
            viewUserFrame.setVisible(true);
        } else if (e.getSource() == mainMenuItem) {
            // Create and show main menu window
            JFrame mainMenuFrame = new JFrame("Main Menu");
            // Add components for main menu window
            // For example:
            JPanel mainMenuPanel = new JPanel();
            mainMenuPanel.add(new JLabel("Main Menu Content"));
            mainMenuFrame.add(mainMenuPanel);
            mainMenuFrame.setSize(300, 200);
            mainMenuFrame.setLocationRelativeTo(null);
            mainMenuFrame.setVisible(true);
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

