package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.ProjectTable;
import com.kmitl.pectjro.Database.UserTable;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

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
			@Override
			protected Void doInBackground() throws Exception {
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
		};
		data.execute();
	}

	public void DeleteUser(int id, int row){
		SwingWorker<Void, Void> userDelete = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				Connection con = DBConnect.createConnect();
				ProjectTable delete = new ProjectTable(con);
				try {
					delete.deleteProject(id);
					JOptionPane.showMessageDialog(null, "Deleted account", "Successful", JOptionPane.PLAIN_MESSAGE);
					controller.getProjectInfo().remove(row);
					view.getModel().removeRow(row);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Cannot delete this account", "Error", JOptionPane.ERROR_MESSAGE);
				}
				return null;
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
