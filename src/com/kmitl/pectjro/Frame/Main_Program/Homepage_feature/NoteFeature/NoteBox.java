package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature;

import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
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
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class NoteBox extends JPanel implements MouseListener, WindowListener {
    private JPanel pl, pforname, west_mar, south_mar, mid_fsouth, gap_north;
    private JLabel name, desc, start, end;
    private JButton noteb;
    private project_progressbar pro_pro;
    private Note_Template note_info;
    private Container owner;
    private AllNoteController controller;


    public NoteBox(Note_Template note, Container owner, AllNoteController controller) {
        this.controller = controller;
        this.owner = owner;
        pl = new JPanel();
        pforname =  new JPanel();
        west_mar = new JPanel();
        south_mar = new JPanel();
        mid_fsouth = new JPanel();
        this.note_info = note;

        //Label
        name = new JLabel(note.name);

        pl.setLayout(new GridBagLayout());
        this.add(pl);
        pforname.setLayout(new FlowLayout(FlowLayout.CENTER));
        pforname.add(name);
        pforname.setPreferredSize(new Dimension(750, 200));
        pl.add(pforname);

        name.setFont(new Font("Sans", Font.BOLD, 50));
        pl.setBorder(new LineBorder(new Color(30,31,34)));
        this.setBackground(new Color(49,51,56));

        pl.setPreferredSize(new Dimension(400,500));
        pl.addMouseListener(this);

        this.setVisible(true);
    }

    public JLabel getNamea() {
        return name;
    }

    public JPanel getFrame(){
        return pl;
    }
    public void createNote() {
        Note open = new Note(note_info, controller);
        open.getFr().addWindowListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(pl)){
            SwingWorker<Boolean, Void> request = new SwingWorker<Boolean, Void>() {
                private final Loading_dialog load = new Loading_dialog(owner);
                @Override
                protected Boolean doInBackground() throws Exception {
                    load.setVisible(true);
                    Connection con = DBConnect.createConnect();
                    NoteTable note = new NoteTable(con);
                    if (note.getAccess(note_info.id)) {
                        note.updateAccess(note_info.id, false);
                        note_info = note.getNote(note_info.id);
                        return true;
                    } else {
                        return false;
                    }
                }

                @Override
                protected void done(){
					try {
						if (get()) {
                            createNote();
                        } else {
                            load.dispose();
                            JOptionPane.showMessageDialog(null, "Someone is using this note, Please try again later.", "Can not access", JOptionPane.ERROR_MESSAGE);
                        }
					} catch (InterruptedException | ExecutionException ex) {
						throw new RuntimeException(ex);
					}

					load.dispose();
                }
            };
            request.execute();
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
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pforname.setBackground(new Color(88,101,242));
            pl.setBackground(new Color(88,101,242));
            name.setForeground(Color.black);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(pl)) {
            pforname.setBackground(new Color(30,31,34));
            pl.setBackground(new Color(30,31,34));
            name.setForeground(Color.white);
        }
    }
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        SwingWorker<Void, Void> change = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Connection con = DBConnect.createConnect();
                NoteTable note = new NoteTable(con);
                note.updateAccess(note_info.id, true);
                return null;
            }
        };
        change.execute();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        SwingWorker<Void, Void> change = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Connection con = DBConnect.createConnect();
                NoteTable note = new NoteTable(con);
                note.updateAccess(note_info.id, true);
                return null;
            }
        };
        change.execute();
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