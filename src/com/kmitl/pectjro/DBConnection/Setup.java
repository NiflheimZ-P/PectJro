package com.kmitl.pectjro.DBConnection;

import com.kmitl.pectjro.DBConnection.Setting_Template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Setup implements ActionListener{
    private JFrame frame;
    private JPanel main_panel, center_panel;
    private JTextField[] field = new JTextField[5];
    private JButton finish;
    private Setting_Template storage= new Setting_Template();

    public Setup(){
        finish = new JButton("Finish");
        finish.addActionListener(this);
        frame = new JFrame();
        main_panel = new JPanel();
        center_panel = new JPanel();
        main_panel.setLayout(new BorderLayout() {
            {
                this.setVgap(10);
            }
        });
        String[] text = {"Sever Host", "Port", "Username", "Password", "Database Name"};
        for (int i = 0; i < 5; i++){
            field[i] = new JTextField();
        }

        main_panel.add(new JPanel(), BorderLayout.WEST);
        main_panel.add(new JPanel(), BorderLayout.EAST);
        main_panel.add(new JPanel() {
            {
                this.add(finish);
            }
        }, BorderLayout.SOUTH);
        main_panel.add(new JPanel() {
            {
                JLabel text = new JLabel("Host sever info.");
                text.setFont(new Font("", Font.PLAIN, 30));
                this.add(text);
            }
        }, BorderLayout.NORTH);
        main_panel.add(center_panel);
        center_panel.setLayout(new GridLayout(5, 1){});
        for (int i = 0; i < 5; i++){
            int show = i;
            center_panel.add(new JPanel() {
                {
                    this.setLayout(new BorderLayout() {
                        {
                            this.setVgap(-30);
                        }
                    });
                    this.add(new JLabel(text[show]), BorderLayout.WEST);
                    this.add(field[show], BorderLayout.SOUTH);
                }
            });
        }

        frame.add(main_panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        storage.host = field[0].getText();
        storage.port = field[1].getText();
        storage.username = field[2].getText();
        storage.password = field[3].getText();
        storage.database_name = field[4].getText();
        if (storage.check()){
            File info = new File("Database_Setting.dat");
            try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(info))){
                info.createNewFile();
                write.writeObject(storage);
            } catch (IOException ex){
                ex.printStackTrace();
            }
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Someone forgot to enter something.", "Something doesn't seem right.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
