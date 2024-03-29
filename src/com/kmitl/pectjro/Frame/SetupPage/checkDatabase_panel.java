package com.kmitl.pectjro.Frame.SetupPage;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.CreateTable;
import com.kmitl.pectjro.Frame.Tools.*;

public class checkDatabase_panel extends JPanel {
    private JPanel main_panel;
    private Image_Resizer data_bar, userInfo_bar, userpro_bar, project_bar, proStep_bar, all_bar, feed_bar;
    private ImageIcon pass, error, wait;
    private Connection con;

    public checkDatabase_panel() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel head = new JLabel("<html><h1>Checking Database</h1><br/>Hello my name is Anawat wongprachanukul i want to tell you fuck you</html>");
        this.add(head);

        pass = new ImageIcon("resources/Images/Status/Pass.png"); error = new ImageIcon("resources/Images/Status/Error.png");
        wait = new ImageIcon("resources/Images/Status/Waiting.png");

        main_panel = new JPanel(new GridBagLayout());
        main_panel.setBorder(new CompoundBorder(
                new EmptyBorder(7, 0, 1, 0),
                new MatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY)
        ));
        main_panel.setPreferredSize(new Dimension(400, 310));
        this.add(main_panel);

        JLabel data = new JLabel("Database Connection");
        data.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(data,
                new Constraints(0, 0, 1, 1, GridBagConstraints.LINE_START, new Insets(10, 10, 1, 1)));

        JLabel user = new JLabel("User_info Table");
        user.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(user,
                new Constraints(0, 1, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10, 1, 1)));

        JLabel uspr = new JLabel("User_Project Table");
        uspr.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(uspr,
                new Constraints(0, 2, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10, 1, 1)));

        JLabel project = new JLabel("Project_info Table");
        project.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(project,
                new Constraints(0, 3, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10, 1, 1)));

        JLabel prost = new JLabel("Project_step Table");
        prost.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(prost,
                new Constraints(0, 4, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10, 1, 1)));

        JLabel all = new JLabel("Step_info Table");
        all.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(all,
                new Constraints(0, 5, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10 , 1, 1)));

        JLabel feed = new JLabel("Feedback Table");
        feed.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(feed,
                new Constraints(0, 6, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10 , 10, 1)));


        data_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(data_bar, new Constraints(1, 0, 1, 1, GridBagConstraints.LINE_END, new Insets(10, 1, 1, 10)));

        userInfo_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(userInfo_bar, new Constraints(1, 1, 1, 1, GridBagConstraints.LINE_END, new Insets(0, 1, 1, 10)));

        userpro_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(userpro_bar, new Constraints(1, 2, 1, 1, 22, new Insets(0, 1, 1, 10)));

        project_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(project_bar, new Constraints(1, 3, 1, 1, 22, new Insets(0, 1, 1, 10)));

        proStep_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(proStep_bar, new Constraints(1, 4, 1, 1, 22, new Insets(0, 1, 1, 10)));

        all_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(all_bar, new Constraints(1, 5, 1, 1, 22, new Insets(0, 1, 1, 10)));

        feed_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(feed_bar, new Constraints(1, 6, 1, 1, 22, new Insets(0, 1, 10, 10)));

    }
    public void check(ArrayList <String> info){
        SwingWorker check = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                con = DBConnect.checkConnection(info);
                if (con != null) {
                    data_bar.setImage(pass);
                    check_userInfo();
                    check_UserProject();
                    check_projectInfo();
                    check_ProjectStep();
                    check_StepInfo();
                    check_Feedback();
                    Main_Setup.bypass = true;
                } else {
                    setError();
                }
                Main_Setup.next.setEnabled(check_enable());
                return null;
            }
        };
        check.execute();
    }

    public void check_userInfo() {
        if (new CreateTable(con).createUserTable()){
            userInfo_bar.setImage(pass);
        } else {
            userInfo_bar.setImage(error);
        }
        repaint();
    }

    public void check_projectInfo() {
        if (new CreateTable(con).createProjectTable()) {
            project_bar.setImage(pass);
        } else {
            project_bar.setImage(error);
        }
        repaint();
    }

    public void check_StepInfo() {
        if (new CreateTable(con).createStepTable()) {
            all_bar.setImage(pass);
        } else {
            all_bar.setImage(error);
        }
        repaint();
    }

    public void check_UserProject() {
        if (new CreateTable(con).createJoinUserProject()) {
            userpro_bar.setImage(pass);
        } else {
            userpro_bar.setImage(error);
        }
        repaint();
    }

    public void check_ProjectStep() {
        if (new CreateTable(con).createJoinProjectStep()) {
            proStep_bar.setImage(pass);
        } else {
            proStep_bar.setImage(error);
        }
        repaint();
    }

    public void check_Feedback() {
        if (new CreateTable(con).createFeedbackTable()) {
            feed_bar.setImage(pass);
        } else {
            feed_bar.setImage(error);
        }
        repaint();
    }

    public boolean check_enable(){
        return (data_bar.getImage().equals(pass.getImage()) ||
                userInfo_bar.getImage().equals(pass.getImage()) ||
                userpro_bar.getImage().equals(pass.getImage()) ||
                project_bar.getImage().equals(pass.getImage()) ||
                proStep_bar.getImage().equals(pass.getImage()) ||
                all_bar.getImage().equals(pass.getImage()) ||
                feed_bar.getImage().equals(pass.getImage())
                );
    }

    public void setError(){
        data_bar.setImage(error);
        userInfo_bar.setImage(error);
        userpro_bar.setImage(error);
        project_bar.setImage(error);
        proStep_bar.setImage(error);
        all_bar.setImage(error);
        repaint();
    }
    public void clear(){
        data_bar.setImage(wait);
        userInfo_bar.setImage(wait);
        userpro_bar.setImage(wait);
        project_bar.setImage(wait);
        proStep_bar.setImage(wait);
        all_bar.setImage(wait);
        repaint();
    }
}
