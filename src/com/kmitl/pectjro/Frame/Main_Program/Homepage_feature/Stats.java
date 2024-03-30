package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
import javax.swing.*;
import java.awt.*;

public class Stats {
    private JFrame pn;
    private JPanel mainPanel, statsPanel, projectPanel;
    private JLabel titleLabel;
    private JLabel userLabel;
    private JLabel projectLabel;
    private JComboBox<String> statusComboBox;


    public Stats() {
        pn = new JFrame();
        mainPanel = new JPanel(new BorderLayout());
        statsPanel = new JPanel(new GridLayout(3, 1));
        projectPanel = new JPanel(new GridLayout(3, 1));

        userLabel = new JLabel("Username: ");
        projectLabel = new JLabel("Project Status: ");
        titleLabel = new JLabel("Your Stats");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        statusComboBox = new JComboBox<>();
        statusComboBox.addItem("Completed");
        statusComboBox.addItem("In Progress");
        statusComboBox.addItem("Incomplete");

        // Add components to the Panel
        statsPanel.add(titleLabel);
        statsPanel.add(userLabel);

        projectPanel.add(projectLabel);
        projectPanel.add(statusComboBox);

        mainPanel.add(statsPanel, BorderLayout.NORTH);
        mainPanel.add(projectPanel, BorderLayout.CENTER);

        pn.add(mainPanel);
        pn.setResizable(false);
        pn.setSize(400, 300);
        pn.setVisible(true);

    }

    public static void main(String[] args) {
        new Stats();
    }
    //public JPanel getFrame(){ return pn; }
}

