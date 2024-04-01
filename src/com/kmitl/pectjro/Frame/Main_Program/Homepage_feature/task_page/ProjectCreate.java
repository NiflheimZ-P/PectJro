package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Insi
 */
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import com.kmitl.pectjro.Frame.Tools.LgoodDatePicker_Setting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProjectCreate implements ActionListener, DocumentListener, WindowListener, DateChangeListener {
    private JDialog fr;
    private JPanel p_main, p_zone1, p_zone2, p_zone11, p_zone12, p_zone21, p_zone22, p_zone23, p_zone221, p_zone222;
    private JButton b_create, b_back;
    private JLabel l1, l2, l3, l4, l5;
    private JInfoGet projectname, description;
    private DatePicker d1, d2;
    private TaskController controller;
    public ProjectCreate(TaskController controller){
        this.controller = controller;
        fr = new JDialog();
        p_main = new JPanel();
        p_zone1 = new JPanel();
        p_zone2 = new JPanel();
        p_zone11 = new JPanel();
        p_zone12 = new JPanel();
        p_zone21 = new JPanel();
        p_zone22 = new JPanel();
        p_zone23 = new JPanel();
        p_zone221 = new JPanel();
        p_zone222 = new JPanel();

        b_create = new JButton("Create");
        b_back = new JButton("Back");

        l1 = new JLabel("New Project");
        l2 = new JLabel("Enter your ProjectName");
        l3 = new JLabel("Start");
        l4 = new JLabel("End");
        l5 = new JLabel("Enter your Description");
        projectname = new JInfoGet("ProjectName");
        description = new JInfoGet("Description");

        d1 = new DatePicker(new LgoodDatePicker_Setting().getSettings());
        d2 = new DatePicker(new LgoodDatePicker_Setting().getSettings());

        fr.add(p_main);
        p_main.setLayout(new BorderLayout());
        p_main.add(p_zone1, BorderLayout.WEST);
        p_zone1.setPreferredSize(new Dimension(50, 300));
        p_main.add(p_zone2, BorderLayout.CENTER);
        p_main.add(p_zone12, BorderLayout.EAST);
        p_zone12.setPreferredSize(new Dimension(50, 100));

        p_zone1.setLayout(new BorderLayout());
        p_zone1.add(p_zone11, BorderLayout.CENTER);
        p_zone11.setPreferredSize(new Dimension(200, 200));


        p_zone2.setLayout(new BorderLayout());
        p_zone2.add(p_zone21, BorderLayout.NORTH);
        p_zone21.setPreferredSize(new Dimension(400, 160));
        p_zone2.add(p_zone22, BorderLayout.CENTER);
        p_zone22.setPreferredSize(new Dimension(400, 130));
        p_zone2.add(p_zone23, BorderLayout.SOUTH);
        p_zone23.setPreferredSize(new Dimension(400, 50));

        p_zone21.setLayout(new GridLayout(5,1));
        JPanel p_top = new JPanel();
        p_top.setLayout(new FlowLayout());
        p_top.add(l1);
        p_zone21.add(p_top);
        p_zone21.add(l2);
        p_zone21.add(projectname);
        p_zone21.add(l5);
        p_zone21.add(description);

        p_zone22.setLayout(new GridLayout(1,2));
        p_zone22.add(p_zone221);
        p_zone221.setLayout(new GridLayout(2,1));
        p_zone221.add(l3);
        p_zone221.add(d1);
        p_zone22.add(p_zone222);
        p_zone222.setLayout(new GridLayout(2,1));
        p_zone222.add(l4);
        p_zone222.add(d2);

        p_zone23.setLayout(new FlowLayout());
        p_zone23.add(b_create);
        b_create.setBorder(BorderFactory.createEmptyBorder());
        b_create.setFont(new Font("Sans", Font.PLAIN, 16));
        b_create.setPreferredSize(new Dimension(140, 40));
        p_zone23.add(b_back);
        b_back.setBorder(BorderFactory.createEmptyBorder());
        b_back.setFont(new Font("Sans", Font.PLAIN, 16));
        b_back.setPreferredSize(new Dimension(140, 40));

        //set color and font
        p_main.setBackground(new Color(49,51,56));
        p_top.setBackground(new Color(49,51,56));
        p_zone1.setBackground(new Color(49,51,56));
        p_zone2.setBackground(new Color(49,51,56));
        p_zone11.setBackground(new Color(49,51,56));
        p_zone12.setBackground(new Color(49,51,56));
        p_zone21.setBackground(new Color(49,51,56));
        p_zone22.setBackground(new Color(49,51,56));
        p_zone23.setBackground(new Color(49,51,56));
        p_zone221.setBackground(new Color(49,51,56));
        p_zone222.setBackground(new Color(49,51,56));
        d1.setBackground(new Color(49,51,56));
        d2.setBackground(new Color(49,51,56));

        b_create.setBackground(new Color(30,31,34));
        b_create.setForeground(Color.white);
        b_back.setBackground(new Color(30,31,34));
        b_back.setForeground(Color.white);
        d1.setDateToToday();
        d2.setDateToToday();

        l1.setSize(30, 50);
        l1.setFont(new Font("Sans", Font.BOLD, 18));
        l1.setForeground(Color.white);
        l2.setSize(30, 50);
        l2.setFont(new Font("Sans", Font.PLAIN, 12));
        l2.setForeground(Color.white);
        l3.setSize(30, 50);
        l3.setFont(new Font("Sans", Font.PLAIN, 12));
        l3.setForeground(Color.white);
        l4.setSize(30, 50);
        l4.setFont(new Font("Sans", Font.PLAIN, 12));
        l4.setForeground(Color.white);

        b_create.addActionListener(this); b_create.setEnabled(false);
        b_back.addActionListener(this);
        projectname.getDocument().addDocumentListener(this);
        description.getDocument().addDocumentListener(this);
        fr.addWindowListener(this);
        d1.addDateChangeListener(this);
        d2.addDateChangeListener(this);

        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setAlwaysOnTop(true);
        fr.setResizable(false);
        fr.setSize(600,300);
        fr.setLocationRelativeTo(controller.getHead_control().getMain_controller().getView().getFrame());
        fr.setVisible(true);
    }

    // Methods
    public boolean check() {
        return (!projectname.getText().isEmpty() &&
                !description.getText().isEmpty() &&
				d2.getDate().isAfter(d1.getDate()));
    }

    // Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b_create)) {
            Project_Template addNew = new Project_Template();
            addNew.name = projectname.getText();
            addNew.description = description.getText();
            addNew.start = Date.valueOf(d1.getDate());
            addNew.end = Date.valueOf(d2.getDate());
            controller.getModel().addProject(addNew);
			fr.dispose();
        } else {
            fr.dispose();
        }
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
		b_create.setEnabled(check());
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
		b_create.setEnabled(check());
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
		b_create.setEnabled(check());
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
    public void dateChanged(DateChangeEvent dateChangeEvent) {
        b_create.setEnabled(check());
    }

    // Accessor
    public JDialog getFr() {
        return fr;
    }
    public void setFr(JDialog fr) {
        this.fr = fr;
    }
    public JInfoGet getProjectname() {
        return projectname;
    }
    public void setProjectname(JInfoGet projectname) {
        this.projectname = projectname;
    }
    public JInfoGet getDescription() {
        return description;
    }
    public void setDescription(JInfoGet description) {
        this.description = description;
    }
    public DatePicker getD1() {
        return d1;
    }
    public void setD1(DatePicker d1) {
        this.d1 = d1;
    }
    public DatePicker getD2() {
        return d2;
    }
    public void setD2(DatePicker d2) {
        this.d2 = d2;
    }
}
