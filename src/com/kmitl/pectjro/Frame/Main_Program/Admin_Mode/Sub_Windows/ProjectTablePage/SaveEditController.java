package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.ProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserProjectTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.Project_Template;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;

public class SaveEditController implements ActionListener {
	// Attribute
	private ProjectTableModel model;
	private ProjectEdit edit;

	// Constructor
	public SaveEditController(ProjectTableModel model, ProjectEdit edit) {
		this.edit = edit;
		this.model = model;
		edit.getSave().addActionListener(this);
		edit.getCancel().addActionListener(this);
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(edit.getCancel())) {
			edit.getFrame().dispose();
		} else {
			SwingWorker<Void, Void> update = new SwingWorker<Void, Void>() {
				private final Loading_dialog loading = new Loading_dialog(edit.getFrame());
				@Override
				protected Void doInBackground() throws Exception {
					loading.setVisible(true);
					Connection con = DBConnect.createConnect();
					ProjectTable project = new ProjectTable(con);

					Project_Template editing = edit.getInfo();
					editing.name = edit.getName().getText();
					editing.description = edit.getDescription().getText();
					editing.start = Date.valueOf(edit.getStart().getDate());
					editing.end = Date.valueOf(edit.getEnd().getDate());
					project.updateProject(editing);

					UserProjectTable collaborators = new UserProjectTable(con);
					for (int i: edit.getAddNew()) {
						collaborators.addCollaborator(i, editing.id);
					}

					for (int j: edit.getDelete()) {
						collaborators.deleteCollaborator(j, editing.id);
					}

					return null;
				}

				@Override
				protected void done() {
					loading.dispose();
					edit.getFrame().dispose();
					model.loadData();
				}
			};
			update.execute();
		}
	}
}
