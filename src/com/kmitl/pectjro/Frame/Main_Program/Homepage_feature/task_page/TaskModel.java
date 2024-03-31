package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.ProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserProjectTable;
import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;

public class TaskModel {
	// Attribute
	private TaskController controller;
	private Task view;

	// Constructor
	public TaskModel(Task view, TaskController controller) {
		this.controller = controller;
		this.view = view;
	}

	// Methods
	public void loadProject(ArrayList<Project_Template> info) {
		view.getPl().removeAll();
		for (int i = 0; i < info.size(); i++){
			if (i != info.size() - 1) {
				view.getPl().add(new task_select(info.get(i), controller),
						new Constraints(0, i, 0, 0, new Insets(0, 0, 30, 0)));
			} else {
				view.getPl().add(new task_select(info.get(i), controller),
						new Constraints(0, i, 1, 1, GridBagConstraints.PAGE_START, new Insets(0, 0, 0, 0)));
			}
		}
		view.getFr().revalidate();
		view.getFr().repaint();
	}

	public void addProject(Project_Template newProject) {
		SwingWorker<Void, Void> add = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				MainController.glassPane.setLoading(true);

				Connection con = DBConnect.createConnect();
				ProjectTable pro = new ProjectTable(con);
				pro.addProjectData(controller.getHead_control().getCache().id, newProject.name, newProject.description, newProject.start, newProject.end);

				controller.getHead_control().getModel().getProject();
				return null;
			}

			@Override
			protected void done(){
				loadProject(controller.getHead_control().getProjectIn());

				MainController.glassPane.setVisible(false);
				MainController.glassPane.setLoading(false);
			}
		};
		add.execute();
	}

	public void refresh() {
		SwingWorker<Void, Void> reload = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				MainController.glassPane.setVisible(true);
				MainController.glassPane.setLoading(true);
				view.getPl().removeAll();

				Connection con = DBConnect.createConnect();
				ProjectTable pro = new ProjectTable(con);
				controller.getHead_control().getModel().getProject();

				return null;
			}

			@Override
			protected void done(){
				loadProject(controller.getHead_control().getProjectIn());

				MainController.glassPane.setVisible(false);
				MainController.glassPane.setLoading(false);
			}
		};
		reload.execute();
	}
}
