package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature;

import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.project_progressbar;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.NoteTable;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.project_progressbar;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.project_progressbar;
import com.kmitl.pectjro.Frame.Templates.Note_Template;
import com.kmitl.pectjro.Frame.Templates.Project_Template;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class NoteBox extends JPanel implements MouseListener, ActionListener {
    private JPanel pl, pforname, west_mar, south_mar, mid_fsouth, gap_north;
    private JLabel name, desc, start, end;
    private JButton noteb;
    private Note note;
    private project_progressbar pro_pro;
    private Note_Template note_info;

    //private Task task;
    //private TaskController tskc;


    public NoteBox() {
        pl = new JPanel();
        pforname =  new JPanel();
        west_mar = new JPanel();
        south_mar = new JPanel();
        mid_fsouth = new JPanel();
        gap_north = new JPanel();
        this.note_info = note_info;

        //Label

        name = new JLabel("Note");
        //desc = new JLabel(info.description);


        pl.setLayout(new BorderLayout());
        this.add(pl);
        pforname.setLayout(new FlowLayout(FlowLayout.CENTER));
        pforname.add(name);
        pforname.setPreferredSize(new Dimension(750, 200));
        pl.add(pforname, BorderLayout.CENTER);

        gap_north = new JPanel();
        gap_north.setPreferredSize(new Dimension(750, 70));
        pl.add(gap_north, BorderLayout.NORTH);

        //add to pforname
        // west_mar.setPreferredSize(new Dimension(60, 200));
        // pl.add(west_mar, BorderLayout.WEST);
        // south_mar.setPreferredSize(new Dimension(1, 40));
        // south_mar.setLayout(new GridLayout(1,3));

        // south_mar.add(mid_fsouth);

        // pl.add(south_mar, BorderLayout.SOUTH);

        name.setFont(new Font("Sans", Font.BOLD, 50));
        //pl.add(desc, BorderLayout.CENTER);
        //desc.setFont(new Font("Sans", Font.PLAIN, 14));
        pl.setBorder(new LineBorder(new Color(30,31,34)));
        this.setBackground(new Color(49,51,56));

        pl.setPreferredSize(new Dimension(750,200));
        pl.addMouseListener(this);

        this.setVisible(true);
    }


    public JLabel getNamea() {
        return name;
    }

    public JPanel getFrame(){
        return pl;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(pl)){
//            note = new Note(note_info);
//            note.getSave().addActionListener(this);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(pl)) {
            pforname.setBackground(new Color(88,101,242));
            gap_north.setBackground(new Color(88,101,242));
            pl.setBackground(new Color(88,101,242));
            name.setForeground(Color.black);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(pl)) {
            pforname.setBackground(new Color(30,31,34));
            gap_north.setBackground(new Color(30,31,34));
            pl.setBackground(new Color(30,31,34));
            name.setForeground(Color.white);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(note.getSave())){
            this.name.setText(note.getTextField().getText());
            note.getFr().setTitle(note.getTextField().getText());

            Connection con = DBConnect.createConnect();
            NoteTable notetab = new NoteTable(con);
//            try{
//                notetab.UpdateNote(note.getFr().getTitle(), note.getTextArea().getText());
//            }catch ()
        }
    }
//    public void loadData() {
//        SwingWorker<Void, Void> getFeed = new SwingWorker<Void, Void>() {
//            private Loading_dialog loading = new Loading_dialog(pl);
//            @Override
//            protected Void doInBackground() throws Exception {
//                loading.setVisible(true);
//                name.removeAll();
//                desc.removeAll();
//
//                task.getRef().setEnabled(false);
//                Connection con = DBConnect.createConnect();
//
//                task.getRef().setEnabled(true);
////                if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
////                    search();
////                }
////                return null;
////            }
//
////            @Override
////            protected void done() {
////                loading.dispose();
////            }
////        };
////        getFeed.execute();
//        }
}