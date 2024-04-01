package com.kmitl.pectjro.Frame.SetupPage;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.Connection.CreateTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Tools.*;

public class checkDatabase_panel extends JPanel {
    private JPanel main_panel;
    private Image_Resizer data_bar, userInfo_bar, userpro_bar, project_bar, all_bar, feed_bar, note_bar;
    private ImageIcon pass, error, wait;
    private Connection con;

    public checkDatabase_panel() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel head = new JLabel("<html><h1>Checking Database</h1><br/>Your username and password in the connection info<br/>can access to admin mode</html>");
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

        JLabel all = new JLabel("Step_info Table");
        all.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(all,
                new Constraints(0, 4, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10 , 1, 1)));

        JLabel feed = new JLabel("Feedback Table");
        feed.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(feed,
                new Constraints(0, 5, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10 , 1, 1)));

        JLabel note = new JLabel("Note_info");
        note.setFont(new Font("", Font.PLAIN, 15));
        main_panel.add(note,
                new Constraints(0, 6, 1, 1, GridBagConstraints.LINE_START, new Insets(0, 10 , 10, 1)));

        data_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(data_bar, new Constraints(1, 0, 1, 1, GridBagConstraints.LINE_END, new Insets(10, 1, 1, 10)));

        userInfo_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(userInfo_bar, new Constraints(1, 1, 1, 1, GridBagConstraints.LINE_END, new Insets(0, 1, 1, 10)));

        userpro_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(userpro_bar, new Constraints(1, 2, 1, 1, 22, new Insets(0, 1, 1, 10)));

        project_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(project_bar, new Constraints(1, 3, 1, 1, 22, new Insets(0, 1, 1, 10)));

        all_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(all_bar, new Constraints(1, 4, 1, 1, 22, new Insets(0, 1, 1, 10)));

        feed_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(feed_bar, new Constraints(1, 5, 1, 1, 22, new Insets(0, 1, 1, 10)));

        note_bar = new Image_Resizer(wait, 20, 100);
        main_panel.add(note_bar, new Constraints(1, 6, 1, 1, 22, new Insets(0, 1, 10, 10)));

    }
    public void check(ArrayList <String> info){
        SwingWorker<Void, Void> check = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                con = DBConnect.checkConnection(info);
                if (con != null) {
                    data_bar.setImage(pass);
                    check_userInfo();
                    check_UserProject();
                    check_projectInfo();
                    check_StepInfo();
                    check_Feedback();
                    check_Note();
                    create_admin(info.get(3), info.get(4));
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

    public void check_Feedback() {
        if (new CreateTable(con).createFeedbackTable()) {
            feed_bar.setImage(pass);
        } else {
            feed_bar.setImage(error);
        }
        repaint();
    }

    public void check_Note() {
        if (new CreateTable(con).createNoteTable()) {
            note_bar.setImage(pass);
        } else {
            note_bar.setImage(error);
        }
        repaint();
    }

    public void create_admin(String username, String password){
        UserTable user = new UserTable(con);
        try (InputStream in = new FileInputStream(new File("resources/Images/aunkung.jpeg"))){
            user.addUserData("admin", username, password, "admin", "admin", in, true);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean check_enable(){
        return (data_bar.getImage().equals(pass.getImage()) &&
                userInfo_bar.getImage().equals(pass.getImage()) &&
                userpro_bar.getImage().equals(pass.getImage()) &&
                project_bar.getImage().equals(pass.getImage()) &&
                all_bar.getImage().equals(pass.getImage()) &&
                feed_bar.getImage().equals(pass.getImage()) &&
                note_bar.getImage().equals(pass.getImage())
                );
    }

    public void setError(){
        data_bar.setImage(error);
        userInfo_bar.setImage(error);
        userpro_bar.setImage(error);
        project_bar.setImage(error);
        all_bar.setImage(error);
        feed_bar.setImage(error);
        note_bar.setImage(error);
        repaint();
    }

    public void clear(){
        data_bar.setImage(wait);
        userInfo_bar.setImage(wait);
        userpro_bar.setImage(wait);
        project_bar.setImage(wait);
        all_bar.setImage(wait);
        feed_bar.setImage(wait);
        note_bar.setImage(wait);
        repaint();
    }

}
