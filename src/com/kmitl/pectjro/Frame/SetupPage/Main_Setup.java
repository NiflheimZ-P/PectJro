package com.kmitl.pectjro.Frame.SetupPage;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Templates.Setting_Template;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;

public class Main_Setup implements ActionListener {
    private JFrame frame = new JFrame("PectJro Setup");
    private JPanel south, west, center;
    public static JButton next, back, cancel;
    private JPanel[] page = new JPanel[3];
    private CardLayout page_manage = new CardLayout();
    private JLabel warn = new JLabel("!!Please insert all the info");
    private int current_page = 0;
    private ArrayList<String> info;
    public static boolean bypass = false;

    public Main_Setup() {
        south = new JPanel(new FlowLayout(FlowLayout.RIGHT)); west = new JPanel(); center = new JPanel(page_manage);
        next = new JButton("Next >"); back = new JButton("< Back"); cancel = new JButton("Cancel");
        next.addActionListener(this); back.addActionListener(this); cancel.addActionListener(this);
        south.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(1, 0, 0, 0, Color.gray),
                new EmptyBorder(3, 3, 3, 3)
        ));
        south.add(back);
        back.setEnabled(false);
        south.add(next);
        south.add(new JPanel());
        south.add(cancel);

        ImageIcon icon = new ImageIcon("resources/Images/life-13.jpg");
        west.add(new JLabel(icon));
        west.setPreferredSize(new Dimension(250, 0));

        page = new JPanel[]{new default_panel(), new connect_panel(), new checkDatabase_panel()};
        center.add(page[0], "0");
        center.add(page[1], "1");
        center.add(page[2], "2");
        center.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 10));

        frame.add(south, BorderLayout.SOUTH);
        frame.add(west, BorderLayout.WEST);
        frame.add(center);

        warn.setForeground(Color.RED);
        warn.setFont(new Font("", Font.BOLD, 13));

        //page_manage.show(center, "2");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if (command.equals("Next >")) {
            back.setEnabled(true);
            current_page += 1;

            if (current_page == 1 && !bypass){ next.setEnabled(false); }
            else if (current_page == 2) {
                next.setEnabled(false);
                page_manage.show(center, String.valueOf(current_page));
                info = ((connect_panel) page[1]).getData();
                ((checkDatabase_panel) page[2]).check(info);
                next.setText("Finish");
                return;
            }

            page_manage.show(center, String.valueOf(current_page));
        }
        else if (command.equals("< Back")) {
            current_page -= 1;
            next.setEnabled(true);
            if (current_page == 0){ back.setEnabled(false);}
            else if (current_page == 1){
                next.setText("Next >");
                ((checkDatabase_panel)page[2]).clear();
            }
            page_manage.show(center, String.valueOf(current_page));
        }
        else if (command.equals("Cancel")) {
            System.exit(0);
        }
        else if (command.equals("Finish")) {
            SwingWorker<Void, Void> done = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    Setting_Template storage = new Setting_Template();
                    storage.setData(info);

                    Connection con = DBConnect.checkConnection(info);
                    UserTable user = new UserTable(con);
                    try (InputStream in = new FileInputStream(new File("resources/Images/aunkung.jpeg"))){
                        user.addUserData("admin", info.get(3), info.get(4), "admin", "admin", in, true);
                    } catch (IOException | SQLException e) {
                        e.printStackTrace();
                    }

                    File info = new File("Database_Setting.dat");
                    try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(info))){
                        write.writeObject(storage);
                    } catch (IOException ex){
                        ex.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void done() {
                    System.exit(0);
                }
            };
            done.execute();
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel( new FlatMacLightLaf() );
        SwingUtilities.invokeLater(() -> { new Main_Setup(); });
    }

}

