package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProjectTableController implements ActionListener, DocumentListener {
	// Attribute
	private ProjectTableView view;
	private ProjectTableModel model;
	private AdminController head_control;
	private ArrayList<Project_Template> projectInfo;

	// Constructor
	public ProjectTableController(AdminController head_control) {
		view = new ProjectTableView();
		model = new ProjectTableModel(view, this);
		this.head_control = head_control;

		view.addInternalFrameListener(head_control);
		view.getAdd_new().addActionListener(this);
		view.getRefresh().addActionListener(this);
		view.getDelete().addActionListener(this);
		view.getSearch().getDocument().addDocumentListener(this);
		view.getView().addActionListener(this);
	}

	// Accessor
	public ProjectTableView getView() {
		return view;
	}
	public ProjectTableModel getModel() {
		return model;
	}
	public void setProjectInfo(ArrayList<Project_Template> project) {
		this.projectInfo = project;
	}
	public ArrayList<Project_Template> getProjectInfo() {
		return projectInfo;
	}
	public AdminController getHead_control() {
		return head_control;
	}
	public void setHead_control(AdminController head_control) {
		this.head_control = head_control;
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("Add New")) {
				ProjectAdd add = new ProjectAdd(this);
				add.getFrame().addInternalFrameListener(head_control);
				head_control.addNew(add.getFrame());
			} else if (e.getActionCommand().equals("Delete")) {
				model.DeleteUser(Integer.parseInt(String.valueOf(view.getModel().getValueAt(view.getTable().getSelectedRow(), 0))), view.getTable().getSelectedRow());
			} else if (e.getActionCommand().equals("Refresh")) {
				model.loadData();
			} else if (e.getActionCommand().equals("Edit")) {
				ProjectEdit edit = new ProjectEdit(projectInfo.get(view.getTable().getSelectedRow()));
				new SaveEditController(model, edit);
				edit.getFrame().addInternalFrameListener(head_control);

				SwingWorker<Void, Void> loadEdit = new SwingWorker<Void, Void>() {
					private final Loading_dialog loading = new Loading_dialog(view);
					@Override
					protected Void doInBackground() throws Exception {
						loading.setVisible(true);
						edit.loadCon();
						edit.setUser(edit.getInfo().people);
						edit.loadNote();
						return null;
					}

					@Override
					protected void done() {
						loading.dispose();
						head_control.addNew(edit.getFrame());
						edit.chooseOutput();
					}
				};

				loadEdit.execute();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Please select user first.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}
}
