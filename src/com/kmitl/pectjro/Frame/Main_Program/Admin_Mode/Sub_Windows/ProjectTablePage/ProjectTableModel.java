package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.ProjectTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.Project_Template;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class ProjectTableModel {
	// Attribute
	private ProjectTableView view;
	private ProjectTableController controller;

	// Constructor
	public ProjectTableModel(ProjectTableView view, ProjectTableController controller) {
		this.view = view;
		this.controller = controller;
	}

	public void setTable(){
		view.getModel().setRowCount(0);
		for (int i = 0; i < controller.getProjectInfo().size(); i++) {
			Project_Template project = controller.getProjectInfo().get(i);
			Object[] info = {project.id, project.name, project.description, project.start, project.end};
			view.getModel().addRow(info);
		}
		view.repaint();
	}

	public void loadData(){
		SwingWorker<Void, Void> data = new SwingWorker<Void, Void>() {
			private Loading_dialog loading = new Loading_dialog(view);
			@Override
			protected Void doInBackground() throws Exception {
				loading.setVisible(true);
				view.getRefresh().setEnabled(false);
				view.getModel().setRowCount(0);
				Connection con = DBConnect.createConnect();
				ProjectTable project = new ProjectTable(con);
				controller.setProjectInfo(project.getProjectData());
				setTable();
				if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
					searching();
				}
				view.getRefresh().setEnabled(true);
				return null;
			}

			@Override
			protected void done(){
				loading.dispose();
			}
		};
		data.execute();
	}

	public void DeleteUser(int id, int row){
		SwingWorker<Void, Void> userDelete = new SwingWorker<Void, Void>() {
			private Loading_dialog loading = new Loading_dialog(view);
			@Override
			protected Void doInBackground() throws Exception {
				loading.setVisible(true);
				Connection con = DBConnect.createConnect();
				ProjectTable delete = new ProjectTable(con);
				try {
					delete.deleteProject(id);
					controller.getProjectInfo().remove(row);
					view.getModel().removeRow(row);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Cannot delete this account", "Error", JOptionPane.ERROR_MESSAGE);
				}
				return null;
			}

			@Override
			protected void done() {
				loading.dispose();
			}
		};
		userDelete.execute();
	}

	public void searching(){
		String word = view.getSearch().getText().toLowerCase();
		view.getModel().setRowCount(0);
		for (Project_Template i : controller.getProjectInfo()){
			if (String.valueOf(i.id).contains(word) || i.name.toLowerCase().contains(word) || i.description.toLowerCase().contains(word) ||
					String.valueOf(i.start).toLowerCase().contains(word) || String.valueOf(i.end).toLowerCase().contains(word)){
				Object[] info = {i.id, i.name, i.description, i.start, i.end};
				view.getModel().addRow(info);
			}
		}
	}
}
