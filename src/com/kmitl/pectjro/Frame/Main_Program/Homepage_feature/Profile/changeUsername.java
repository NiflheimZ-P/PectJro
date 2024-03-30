package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;


import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLOutput;
public class changeUsername implements ActionListener, DocumentListener, WindowListener {
    private JDialog fr;
    private JPanel pmain, top_mar, west_mar, east_mar;
    private JButton submit, cancel;
    private JTextField user;
    private JLabel txt;
    private ProfileController controller;

    public changeUsername(ProfileController controller){
        this.controller = controller;
        fr = new JDialog();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.addWindowListener(this);

        //panel
        pmain = new JPanel();
        pmain.setLayout(new FlowLayout(2));
        top_mar = new JPanel();
        top_mar.setLayout(new FlowLayout(0));
        east_mar = new JPanel();
        west_mar = new JPanel();

        //Jlabel
        txt = new JLabel("    Change Username");

        //button
        submit = new JButton("Done"); submit.addActionListener(this); submit.setEnabled(false);
        cancel = new JButton("Cancel"); cancel.addActionListener(this);

        //txtfield
        user = new JTextField(); user.getDocument().addDocumentListener(this);

        //pmain
        pmain.add(submit); pmain.add(cancel);

        //set user
        pmain.setPreferredSize(new Dimension(400, 40));

        //set top
        top_mar.add(txt);
        top_mar.setPreferredSize(new Dimension(0, 35));

        east_mar.setPreferredSize(new Dimension(15, 0));
        west_mar.setPreferredSize(new Dimension(15, 0));

        //add to frame
        fr.add(top_mar, BorderLayout.NORTH);
        fr.add(east_mar, BorderLayout.EAST);
        fr.add(west_mar, BorderLayout.WEST);
        fr.add(user, BorderLayout.CENTER);
        fr.add(pmain, BorderLayout.SOUTH);

        //set visible and size
        fr.setAlwaysOnTop(true);
        fr.setSize(400, 150);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    public JButton getSubmit() {
        return submit;
    }
    public JTextField getUser() {
        return user;
    }
    public JButton getCancel() {
        return cancel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submit)) {
            fr.dispose();
            controller.getModel().saveName(user.getText());
        } else {
            fr.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        MainController.glassPane.setVisible(false);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (!user.getText().isEmpty()){
            submit.setEnabled(true);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (!user.getText().isEmpty()){
            submit.setEnabled(true);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (!user.getText().isEmpty()){
            submit.setEnabled(true);
        }
    }
}
