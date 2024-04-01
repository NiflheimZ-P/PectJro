package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.StepTable;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Templates.Step_Template;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import com.kmitl.pectjro.Frame.Tools.LgoodDatePicker_Setting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class DeleteTask implements WindowListener{
    public JButton getCon() {
        return con;
    }

    public JButton getCancel() {
        return cancel;
    }

    private JFrame fr;
    private JPanel pmain, psouth, west_mar, east_mar;
    private JComboBox tasksel;
    private JLabel txt;
    private JButton con, cancel;
    private LinkedList<Step_Template> allStepName;
    private Project_Template info;
    private project_progressbar controller;
    public DeleteTask(Project_Template info, project_progressbar controller){
        this.controller = controller;

        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.info = info;


        //pmain
        pmain = new JPanel();
        psouth = new JPanel();
        west_mar = new JPanel();
        east_mar = new JPanel();

        //label
        txt = new JLabel("Select Task to Delete.");
        //combo
        tasksel = new JComboBox();

        //button
        con = new JButton("Confirm");
        cancel = new JButton("Cancel");

        //add
        pmain.setLayout(new FlowLayout());
        west_mar.setPreferredSize(new Dimension(20,0));
        east_mar.setPreferredSize(new Dimension(20,0));
        pmain.add(txt);

        //
        psouth.setLayout(new FlowLayout(1,0,15));
        psouth.add(con); psouth.add(cancel);

        //add to fr
        fr.add(west_mar, BorderLayout.WEST);
        fr.add(east_mar, BorderLayout.EAST);
        fr.add(pmain, BorderLayout.NORTH);
        fr.add(tasksel, BorderLayout.CENTER);
        fr.add(psouth, BorderLayout.SOUTH);

        //set visible size
        fr.setSize(350,150);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

//    public static void main(String[] args) throws UnsupportedLookAndFeelException {
//        UIManager.setLookAndFeel( new FlatMacDarkLaf() );
//        SwingUtilities.invokeLater(() -> {new DeleteTask();});
//    }
    public JComboBox getTasksel() {
        return tasksel;
    }

    public JFrame getFr() {
        return fr;
    }
    public void loadStep() throws Exception {
        Connection con = DBConnect.createConnect();
        StepTable step = new StepTable(con);
        allStepName = step.getAllStep(info.id);
    }
    public void addToCombobox() {
        for (Step_Template i : allStepName) {
            tasksel.addItem(i.step_name);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        controller.setDelt(null);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        controller.setDelt(null);
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
}
