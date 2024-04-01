package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.NoteTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.Note_Template;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

public class AllNoteController implements ActionListener {
	private AllNote view;
	private ArrayList<Note_Template> allNote;
	private Project_Template info;
	private Container owner;

	public AllNoteController(Project_Template info, Container owner) {
		this.owner = owner;
		this.info = info;
		view = new AllNote(owner);

		view.getPlus().addActionListener(this);
		view.getRef().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(view.getPlus())){
			SwingWorker<Void, Void> add = new SwingWorker<Void, Void>() {
				private final Loading_dialog load = new Loading_dialog(view.getFr());
				@Override
				protected Void doInBackground() throws Exception {
					String inputValue = JOptionPane.showInputDialog(null,"Insert note name here.", "Note name", JOptionPane.QUESTION_MESSAGE);

					load.setVisible(true);
					Connection con = DBConnect.createConnect();
					NoteTable note = new NoteTable(con);
					note.addNote(info.id, inputValue, "");

					return null;
				}

				@Override
				protected void done() {
					loadNote(false);

					load.dispose();
				}
			};
			add.execute();
		} else if (e.getSource().equals(view.getRef())) {
			loadNote(true);
		}
	}

	public void loadNote(boolean loading) {
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			private final Loading_dialog load = new Loading_dialog(owner);
			@Override
			protected Void doInBackground() throws Exception {
				view.getCenter().removeAll();
				view.getCenter().revalidate();
				view.getCenter().repaint();

				load.setVisible(loading);

				Connection con = DBConnect.createConnect();
				NoteTable note = new NoteTable(con);
				allNote = note.getAllNote(info.id);

				return null;
			}

			@Override
			protected void done() {
				setUpNote();
				view.getFr().setVisible(true);
				load.dispose();
			}

		};
		load.execute();
	}

	public void setUpNote() {
		view.getCenter().removeAll();
		for (int i = 0; i < allNote.size(); i++) {
			NoteBox note = new NoteBox(allNote.get(i), view.getFr(), this);
			if (i != allNote.size() - 1) {
				view.getCenter().add(note, new Constraints(i, 0, 0, 1, new Insets(0, 5, 0, 5)));
			} else {
				view.getCenter().add(note, new Constraints(i, 0, 1, 1, 21, new Insets(0, 5, 0, 5)));
			}
		}
		view.getCenter().revalidate();
		view.getCenter().repaint();
	}

	public AllNote getView() {
		return view;
	}

	public void setView(AllNote view) {
		this.view = view;
	}

	public ArrayList<Note_Template> getAllNote() {
		return allNote;
	}

	public void setAllNote(ArrayList<Note_Template> allNote) {
		this.allNote = allNote;
	}
}
