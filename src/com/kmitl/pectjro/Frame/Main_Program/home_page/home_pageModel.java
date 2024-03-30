package com.kmitl.pectjro.Frame.Main_Program.home_page;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.ProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class home_pageModel {
	// Attribute
	private home_page view;
	private home_pageController controller;
	private Connection con;

	// Constructor
	public home_pageModel(home_page view, home_pageController controller) {
		this.view = view;
		this.controller = controller;
	}

	// Methods
	public void getProject() throws SQLException {
		UserProjectTable allPro = new UserProjectTable(con);
		ArrayList<Integer> inPro = allPro.getProject(controller.getCache().id);

		if (!inPro.isEmpty()) {
			ProjectTable project = new ProjectTable(con);
			controller.setProjectIn(project.getProjectData(inPro));
		} else {
			controller.setProjectIn(new ArrayList<>());
		}
	}

	public void loadHome() throws SQLException {
		SwingWorker<Boolean, Void> load = new SwingWorker<Boolean, Void>() {
			@Override
			protected Boolean doInBackground() throws Exception {
				controller.getMain_controller().getGlassPane().setVisible(true);
				controller.getMain_controller().getGlassPane().setLoading(true);

				con = DBConnect.createConnect();

				loadCache();
				getProject();

				controller.getTask().getModel().loadProject();

				return checkAdmin();
			}

			@Override
			protected void done() {
				controller.getProfile().getModel().setProfile();
				try {
					if (get()) {
						view.getBn_admin().setVisible(true);
						view.getBn_profile().setIcon(new ImageIcon(new ImageIcon(controller.getCache().image).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					}
				} catch (InterruptedException | ExecutionException e) {
					throw new RuntimeException(e);
				}

				controller.getMain_controller().getGlassPane().setVisible(false);
				controller.getMain_controller().getGlassPane().setLoading(false);
			}
		};
		load.execute();
	}

	public void loadCache(){
		try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(new File("User_Cache.dat")))){
			controller.setCache((User_Template) ob.readObject());
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Cannot access file 'User_Cache'", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public boolean checkAdmin() throws SQLException{
		UserTable user = new UserTable(con);
		return user.getUserData(controller.getCache().id).admin;
	}

	public void loadAdmin() {
		controller.getMain_controller().setAdmin(new AdminController(controller.getMain_controller()));
		controller.getMain_controller().getModel().changePage(controller.getMain_controller().getAdmin().getContainer());
	}
}
