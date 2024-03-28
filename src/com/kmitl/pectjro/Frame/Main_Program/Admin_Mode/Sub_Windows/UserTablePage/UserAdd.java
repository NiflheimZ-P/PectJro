package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.UserTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.Image_Resizer;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import com.kmitl.pectjro.Frame.Tools.JPassGet;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class UserAdd implements DocumentListener, ActionListener {
    // Attribute
    private JInternalFrame frame;
    private JPanel main_panel, west_panel, center, south_panel;
    private Image_Resizer image;
    private JButton chooser, save, cancel;
    private JInfoGet first, last, username, gmail;
    private JPassGet pass, confirm_pass;
    private JCheckBox admin;
    private String path;
    private UserTableController controller;

    // Constructor
    public UserAdd(UserTableController controller){
        this.controller = controller;
        path = "resources/Images/aunkung.jpeg";

        frame = new JInternalFrame("Add new user", true, true, false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        main_panel = new JPanel(new BorderLayout());
        west_panel = new JPanel(new GridBagLayout());
        south_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        center = new JPanel(new GridBagLayout());

        west_panel.add(new JLabel("Profile picture"), new Constraints(0, 0, 1, 1, GridBagConstraints.PAGE_END, new Insets(0, 20, 0, 20)));

        image = new Image_Resizer(new ImageIcon("resources/Images/aunkung.jpeg"), 125, 125);
        west_panel.add(image, new Constraints(0, 1, 1, 0, new Insets(20, 20, 20, 20)));

        chooser = new JButton("Choose image");
        chooser.addActionListener(this);
        west_panel.add(chooser, new Constraints(0, 2, 1, 1, GridBagConstraints.PAGE_START, new Insets(0, 20, 0, 20)));

        first = new JInfoGet("Firstname"); last = new JInfoGet("Lastname");
        gmail = new JInfoGet("Gmail");
        username = new JInfoGet("Username");
        pass = new JPassGet("Password"); confirm_pass = new JPassGet("Confirm Password");
        admin = new JCheckBox("This user can access admin mode?");

        first.setPreferredSize(new Dimension(185, 40)); last.setPreferredSize(new Dimension(185, 40));
        gmail.setPreferredSize(new Dimension(380, 40)); username.setPreferredSize(new Dimension(185, 40));
        pass.setPreferredSize(new Dimension(185, 40)); confirm_pass.setPreferredSize(new Dimension(185, 40));

        first.getDocument().addDocumentListener(this); last.getDocument().addDocumentListener(this); gmail.getDocument().addDocumentListener(this);
        username.getDocument().addDocumentListener(this); pass.getDocument().addDocumentListener(this); confirm_pass.getDocument().addDocumentListener(this);

        center.setBorder(new CompoundBorder(
                new EmptyBorder(10, 10, 0, 10),
                new TitledBorder("User Information")
        ));
        center.add(first, new Constraints(0, 0, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(last, new Constraints(1, 0, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(gmail, new Constraints(0, 1, 2, 1, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(username, new Constraints(0, 3, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(pass, new Constraints(0, 4, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(confirm_pass, new Constraints(1, 4, 1, 1, 21, new Insets(0, 5, 0, 0)));
        center.add(admin, new Constraints(0, 5, 2, 1, 1, 1, 21, new Insets(0, 5, 0, 0)));

        save = new JButton("Save");
        save.setEnabled(false);
        save.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);

        south_panel.add(save);
        south_panel.add(cancel);

        main_panel.add(west_panel, BorderLayout.WEST);
        main_panel.add(center);
        main_panel.add(south_panel, BorderLayout.SOUTH);

        frame.add(main_panel);
    }

    // Accessor
    public JInternalFrame getFrame() {
        return frame;
    }

    // Methods
    public boolean checkEmpty(){
        return (first.getText().isEmpty() && last.getText().isEmpty() && gmail.getText().isEmpty() && username.getText().isEmpty()
        && pass.getMyPass().isEmpty() && confirm_pass.getMyPass().isEmpty());
    }

    public boolean checkPass(){
        return (pass.getMyPass().equals(confirm_pass.getMyPass()));
    }

    public boolean checkGmail(){
        return (gmail.getText().contains("@") && gmail.getText().contains("."));
    }

    public void checkSave(){
		save.setEnabled(!checkEmpty() && checkPass() && checkGmail());
    }

    public void adduser() {
        SwingWorker<Void, Void> saveUser = new SwingWorker<Void, Void>() {
            private Loading_dialog loading = new Loading_dialog(frame);
            @Override
            protected Void doInBackground() throws Exception {
                loading.setVisible(true);
                try (InputStream pic = new FileInputStream(path)){
                    Connection con = DBConnect.createConnect();
                    UserTable addUser = new UserTable(con);
                    addUser.addUserData(username.getText(), gmail.getText(), pass.getMyPass(), first.getText(), last.getText(), pic, admin.isSelected());
                    controller.getModel().loadData();
                    frame.dispose();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException io) {
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ed) {
                    JOptionPane.showMessageDialog(null, "this email is already in use", "Error", JOptionPane.ERROR_MESSAGE);
                }
                return null;
            }

            @Override
            protected void done() {
                loading.dispose();
            }
        };
        saveUser.execute();
    }

    // Listener
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Save")) {
            adduser();
        } else if (e.getActionCommand().equals("Cancel")) {
            frame.dispose();
        } else if (e.getActionCommand().equals("Choose image")) {
            JFileChooser choose = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".IMAGE", "jpg", "gif", "png");
            choose.addChoosableFileFilter(filter);
            if (choose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                path = choose.getSelectedFile().getAbsolutePath();
                image.setImage(new ImageIcon(path));
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkSave();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkSave();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkSave();
    }
}
