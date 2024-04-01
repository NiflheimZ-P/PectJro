
package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.NoteTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.Note_Template;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class Note implements ActionListener{
    private JFrame fr;
    private JTextArea textArea;
    private JPanel mainPanel;
    private JTextField textField;
    private JMenuBar m;
    private JMenu edit;
    private JMenuItem save, reset, delete;
    private AllNoteController controller;
    private Note_Template note_info;

    public JTextArea getTextArea() {
        return textArea;
    }
    public JFrame getFr() {
        return fr;
    }
    public JTextField getTextField() {
        return textField;
    }
    public JMenuItem getReset() {
        return reset;
    }
    public JMenuItem getSave() {
        return save;
    }
    public JMenuItem getDelete() {
        return delete;
    }
    public void setDelete(JMenuItem delete) {
        this.delete = delete;
    }

    public Note(Note_Template note, AllNoteController controller) {
        this.note_info = note;
        this.controller = controller;
        fr = new JFrame("Note");
        mainPanel = new JPanel();
        m = new JMenuBar();
        edit = new JMenu("Edit");
        textArea = new JTextArea(note.note);
        textField = new JTextField(note.name);
        save = new JMenuItem("Save");
        reset = new JMenuItem("Reset");
        delete = new JMenuItem("Delete");

        //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setJMenuBar(m);
        m.add(edit);

        edit.add(save);
        edit.add(reset);
        edit.add(delete);

        fr.add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(textField, BorderLayout.NORTH);
        textField.setPreferredSize(new Dimension(800, 50));
        textField.setFont(new Font("Tahoma", Font.BOLD, 20));

        textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        textArea.setBorder(new EmptyBorder(7, 7, 7, 7));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        save.addActionListener(this);
        reset.addActionListener(this);
        delete.addActionListener(this);

        fr.setSize(800, 600);
        fr.setVisible(true);
        fr.setLocationRelativeTo(controller.getView().getFr());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(save)) {
            int check = JOptionPane.showConfirmDialog(fr, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                SwingWorker<Void, Void> save = new SwingWorker<Void, Void>() {
                    private final Loading_dialog load = new Loading_dialog(fr);

                    @Override
                    protected Void doInBackground() throws Exception {
                        load.setVisible(true);
                        Connection con = DBConnect.createConnect();
                        NoteTable note = new NoteTable(con);
                        note.UpdateNote(note_info.id, textField.getText(), textArea.getText());
                        return null;
                    }

                    @Override
                    protected void done() {
                        fr.dispose();
                        load.dispose();

                        controller.loadNote(true);
                    }
                };
                save.execute();
            }
        } else if (e.getSource().equals(reset)) {
            int check = JOptionPane.showConfirmDialog(fr, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                textArea.setText("");
            }
        } else if (e.getSource().equals(delete)) {
            int check = JOptionPane.showConfirmDialog(fr, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                SwingWorker<Void, Void> delete = new SwingWorker<Void, Void>() {
                    private final Loading_dialog load = new Loading_dialog(fr);
                    @Override
                    protected Void doInBackground() throws Exception {
                        load.setVisible(true);
                        Connection con = DBConnect.createConnect();
                        NoteTable note = new NoteTable(con);
                        note.deleteNote(note_info.id);

                        return null;
                    }

                    @Override
                    protected void done() {
                        load.dispose();
                        fr.dispose();
                        controller.loadNote(true);
                    }
                };
                delete.execute();
            }
        }
    }
}

