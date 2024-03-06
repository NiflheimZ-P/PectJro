package com.kmitl.pectjro.Frame.SetupPage;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.io.*;

public class Main_Setup implements ActionListener {
    private JFrame frame = new JFrame("PectJro Setup");
    private JPanel south, west, center;
    public static JButton next, back, cancel;
    private JPanel[] page = {new default_panel(), new connect_panel(), new checkDatabase_panel()};
    private CardLayout page_manage = new CardLayout();
    private JLabel warn = new JLabel("!!Please insert all the info");

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

        center.add(page[0], "0");
        center.add(page[1], "1");
        center.add(page[2], "2");
        center.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 10));

        frame.add(south, BorderLayout.SOUTH);
        frame.add(west, BorderLayout.WEST);
        frame.add(center);

        warn.setForeground(Color.RED);
        warn.setFont(new Font("", Font.BOLD, 13));

        page_manage.show(center, "2");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getNext() {
        return this.next;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if (command.equals("Next >")) {
            back.setEnabled(true);
            page_manage.last(center);
            next.setText("Finish");
            next.setEnabled(false);
        }
        if (command.equals("< Back")) {
            back.setEnabled(false);
            page_manage.first(center);
            next.setText("Next >");
            next.setEnabled(true);
        }
        if (command.equals("Cancel")) {
            System.exit(0);
        }
        if (command.equals("Finish")) {
            Setting_Template storage = new Setting_Template();
            ArrayList<String> data = connect_panel.getData();
            if (data.contains("")) {
                JOptionPane.showMessageDialog(null, "Please insert all the info", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                storage.host = data.get(0);
                storage.port = data.get(1);
                storage.database_name = data.get(2);
                storage.username = data.get(3);
                storage.password = data.get(4);

                File info = new File("Database_Setting.dat");
                try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(info))){
                    info.createNewFile();
                    write.writeObject(storage);
                } catch (IOException ex){
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel( new FlatMacLightLaf() );
        SwingUtilities.invokeLater(() -> { new Main_Setup(); });
    }
}
