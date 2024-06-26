package com.kmitl.pectjro.Frame.Main_Program.home_page;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.ProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
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
	public void getProject() throws Exception {
		ProjectTable project = new ProjectTable(con);
		controller.setProjectIn(project.getProjectData(controller.getCache().id));
	}

	public void loadHome() throws SQLException {
		SwingWorker<Boolean, Void> load = new SwingWorker<Boolean, Void>() {
			@Override
			protected Boolean doInBackground() throws Exception {
				controller.getMain_controller().getGlassPane().setVisible(true);
				controller.getMain_controller().getGlassPane().setLoading(true);

				con = DBConnect.createConnect();

				loadCache();
				try {
					loadNewCache();
				} catch (SQLException ex) {
					MainController.glassPane.setLoading(false);
					File delete = new File("User_Cache.dat");
					delete.delete();

					JOptionPane.showMessageDialog(null, "Can't find your user", "Error", JOptionPane.YES_OPTION);
					System.exit(0);
				}
				getProject();

				controller.getTask().getModel().loadProject(controller.getProjectIn());
				controller.getStats().setStats();

				return checkAdmin();
			}

			@Override
			protected void done() {
				controller.getProfile().getModel().setProfile();
				view.getBn_profile().setIcon(new ImageIcon(new ImageIcon(controller.getCache().image).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				warning();
				try {
					if (get()) {
						view.getBn_admin().setVisible(true);
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
			MainController.glassPane.setLoading(false);
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

	public void loadNewCache() throws SQLException {
		Connection con = DBConnect.createConnect();
		UserTable user = new UserTable(con);
		User_Template output = new User_Template();
		output = user.getUserData(controller.getCache().id);

		controller.setCache(output);
		try(ObjectOutputStream getIn = new ObjectOutputStream(new FileOutputStream("User_Cache.dat"))) {
			getIn.writeObject(output);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void warning() {
		view.getPn_west().removeAll();
		view.getPn_west().add(view.getBn_task());
		view.getPn_west().add(view.getBn_calendar());
		view.getPn_west().add(view.getBn_appraisement());
		view.getPn_west().add(view.getCtn_pn_deadline());
		ArrayList<Project_Template> near = new ArrayList<>();
		int check = 0;
		for (Project_Template i: controller.getProjectIn()) {
			if (compareTimeNow(i.end)) {
				check += 1;
				near.add(i);
			}
			if (check >= 6) {
				break;
			}
		}

		for (int i = 0; i < near.size(); i++) {
			int finalI = i;
			view.getPn_west().add(new JPanel() {
				{
					this.add(new DeadLine(near.get(finalI), controller));
				}
			});
		}
	}

	public boolean compareTimeNow(Date date) {
		long space = date.getTime() - System.currentTimeMillis();
		return space < 604800000L;
	}
}
