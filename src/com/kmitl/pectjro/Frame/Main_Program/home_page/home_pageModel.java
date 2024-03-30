package com.kmitl.pectjro.Frame.Main_Program.home_page;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.ProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserProjectTable;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class home_pageModel {
	// Attribute
	private home_page view;
	private home_pageController controller;

	// Constructor
	public home_pageModel(home_page view, home_pageController controller) {
		this.view = view;
		this.controller = controller;
	}

	// Methods
	public void getProject() throws SQLException {
		Connection con = DBConnect.createConnect();
		UserProjectTable allPro = new UserProjectTable(con);
		ArrayList<Integer> inPro = allPro.getProject(controller.getCache().id);

		ProjectTable project = new ProjectTable(con);
		controller.setProjectIn(project.getProjectData(inPro));
	}

	public void loadHome() throws SQLException {
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				controller.getMain_controller().getGlassPane().setVisible(true);
				controller.getMain_controller().getGlassPane().setLoading(true);

				loadCache();
				getProject();

				return null;
			}

			@Override
			protected void done() {
				controller.getProfile().getModel().setProfile();
				controller.getMain_controller().getGlassPane().setVisible(false);
				controller.getMain_controller().getGlassPane().setLoading(false);
			}
		};
		load.execute();
	}

	public void loadCache(){
		try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(new File("User_Cache")))){
			controller.setCache((User_Template) ob.readObject());
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Cannot access file 'User_Cache'", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}
