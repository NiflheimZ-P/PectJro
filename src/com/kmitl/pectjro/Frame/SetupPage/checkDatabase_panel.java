package com.kmitl.pectjro.Frame.SetupPage;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import com.kmitl.pectjro.Frame.Tools.Constraints;

public class checkDatabase_panel extends JPanel {
    private JPanel main_panel;
    public checkDatabase_panel() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel head = new JLabel("<html><h1>Checking Database</h1><br/>Hello my name is Anawat wongprachanukul i want to tell you fuck you</html>");
        this.add(head);

        main_panel = new JPanel(new GridBagLayout());
        main_panel.setBorder(new CompoundBorder(
                new EmptyBorder(7, 0, 1, 0),
                new MatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY)
        ));
        main_panel.setPreferredSize(new Dimension(413, 310));
        this.add(main_panel);

        JLabel data = new JLabel("Database Connection");
        data.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(data,
                new Constraints(0, 0, 1, 1, GridBagConstraints.LINE_START, new Insets(10, 10, 1, 1)));

        JLabel user = new JLabel("User_info");
        user.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(user,
                new Constraints(0, 1, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10, 1, 1)));

        JLabel uspr = new JLabel("User_Project");
        uspr.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(uspr,
                new Constraints(0, 2, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10, 1, 1)));

        JLabel project = new JLabel("Project_info");
        project.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(project,
                new Constraints(0, 3, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10, 1, 1)));

        JLabel prost = new JLabel("Project_step");
        prost.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(prost,
                new Constraints(0, 4, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10, 1, 1)));

        JLabel all = new JLabel("All_step");
        all.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(all,
                new Constraints(0, 5, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10 , 10, 1)));
    }

}
