package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.FeedbackTable;
import com.kmitl.pectjro.Database.DatabaseTable.ProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.TaskController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;


public class feedback implements ActionListener {
    private JFrame fr;
    private JPanel pn_north, pn_center, pn_south, ctn_center;
    private JLabel l_topic, l_subTopic;
    private JTextArea ta_feedback;
    private JButton bn_send;
    private int id_user, id_project;
    private TaskController controller;
    private Project_Template info;

    public feedback(Container owner, TaskController controller, Project_Template info){
        fr = new JFrame();

        this.id_user = controller.getHead_control().getCache().id;
        this.controller = controller;
        this.id_project = info.id;
        this.info = info;

        pn_north = new JPanel();
        pn_center = new JPanel();
        pn_south = new JPanel();
        ctn_center = new JPanel();

        l_topic = new JLabel("Feedback!");
        l_subTopic = new JLabel("Please leave your feedback below :");

        ta_feedback = new JTextArea(4,45);

        bn_send = new JButton("Send");


        //north part
        fr.setLayout(new BorderLayout());
        fr.add(pn_north, BorderLayout.NORTH);
        pn_north.setLayout(new FlowLayout());
        pn_north.add(l_topic);

        //center part
        fr.add(pn_center, BorderLayout.CENTER);
        ctn_center.setLayout(new GridLayout(2, 1));
        ctn_center.add(l_subTopic);
        ctn_center.add(ta_feedback);
        ta_feedback.setLineWrap(true);
        pn_center.add(ctn_center);

        //south part
        fr.add(pn_south, BorderLayout.SOUTH);
        pn_south.setLayout(new FlowLayout());
        pn_south.add(bn_send);
        bn_send.setPreferredSize(new Dimension(100, 40));


        //set color and font
         fr.setBackground(new Color(49, 51, 56));
         pn_north.setBackground(new Color(49,51,56));
         pn_center.setBackground(new Color(49,51,56));
         pn_south.setBackground(new Color(49,51,56));
         ctn_center.setBackground(new Color(49,51,56));

        l_topic.setForeground(new Color(88,101,242));
        l_subTopic.setForeground(Color.white);

        l_topic.setFont(new Font("Sans", Font.BOLD, 30));
        l_subTopic.setFont(new Font("Sans", Font.PLAIN, 14));

        // add listener
        bn_send.addActionListener(this);

        //show
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setResizable(false);
        fr.setSize(600, 250);
        fr.setVisible(true);
        fr.setLocationRelativeTo(owner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingWorker<Void, Void> add = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Connection con = DBConnect.createConnect();
                FeedbackTable feed = new FeedbackTable(con);
                feed.addFeedback(ta_feedback.getText(), id_user);
                fr.dispose();

                ProjectTable project = new ProjectTable(con);
                project.deleteProject(id_project);

                UserTable user = new UserTable(con);
                if (checkDate()) {
                    controller.getHead_control().getCache().project_ontime += 1;
                    user.updateUserData("Project_Ontime", String.valueOf(controller.getHead_control().getCache().project_ontime), String.valueOf(controller.getHead_control().getCache().id));
                } else {
                    controller.getHead_control().getCache().project_expired += 1;
                    user.updateUserData("Project_Expired", String.valueOf(controller.getHead_control().getCache().project_expired), String.valueOf(controller.getHead_control().getCache().id));

                }
                controller.getHead_control().getCache().project_done += 1;
                user.updateUserData("Project_Done", String.valueOf(controller.getHead_control().getCache().project_done), String.valueOf(controller.getHead_control().getCache().id));

                controller.getHead_control().getModel().loadHome();
                return null;
            }
        };
        add.execute();
    }

    public boolean checkDate() {
        return (info.end.getTime() - System.currentTimeMillis()) > 0;
    }
}
