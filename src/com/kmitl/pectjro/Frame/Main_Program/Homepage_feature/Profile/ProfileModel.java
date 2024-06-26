package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginController;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class ProfileModel {
	// Attribute
	private ProfileController controller;
	private Profile view;

	// Constructor
	public ProfileModel(Profile view, ProfileController controller){
		this.view = view;
		this.controller = controller;
	}

	// Methods
	public void setProfile() {
		Image picture = new ImageIcon(controller.getHead_control().getCache().image).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		view.getIcon().setIcon(new ImageIcon(picture));
		view.getL_firstn().setText("Firstname : " + controller.getHead_control().getCache().firstname);
		view.getL_lastn().setText("Lastname : " + controller.getHead_control().getCache().lastname);
		view.getL_name().setText("Username : " + controller.getHead_control().getCache().username);
		view.getL_email().setText("Email : " + controller.getHead_control().getCache().gmail);
	}


	public void changePicture(String path) {
		SwingWorker<Boolean, Void> change = new SwingWorker<Boolean, Void>() {
			@Override
			protected Boolean doInBackground() throws Exception {
				MainController.glassPane.setVisible(true);
				MainController.glassPane.setLoading(true);

				try (InputStream pic = new FileInputStream(path)) {
					Connection con = DBConnect.createConnect();
					UserTable user = new UserTable(con);
					user.changeUserPicture(controller.getHead_control().getCache().id, pic);
				} catch (SQLException ex) {
					return false;
				}

				controller.getHead_control().getCache().image = Files.readAllBytes(new File(path).toPath());

				try (ObjectOutputStream update = new ObjectOutputStream(new FileOutputStream("User_Cache.dat"))) {
					update.writeObject(controller.getHead_control().getCache());
				}
				return true;
			}

			@Override
			protected void done() {
				try {
					if (get()) {
						controller.getHead_control().getStats().setImage(new ImageIcon(controller.getHead_control().getCache().image));
						controller.getHead_control().getView().getBn_profile().setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
						view.getIcon().setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT)));
					} else {
						JOptionPane.showMessageDialog(null, "Sorry, We can't change your profile picture right now", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (InterruptedException | ExecutionException e) {
					throw new RuntimeException(e);
				}
				MainController.glassPane.setVisible(false);
				MainController.glassPane.setLoading(false);
			}
		};
		change.execute();
	}

	public void loadLogin() {
		controller.getHead_control().getMain_controller().setLogin(new LoginController(controller.getHead_control().getMain_controller()));
		controller.getHead_control().getMain_controller().getModel().changePage(controller.getHead_control().getMain_controller().getLogin().getContainer());

		File delete = new File("User_Cache.dat");
		delete.delete();
	}

	public void saveName(String name) {
		SwingWorker<Void, Void> save = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				MainController.glassPane.setLoading(true);

				Connection con = DBConnect.createConnect();
				UserTable user = new UserTable(con);
				user.updateName(controller.getHead_control().getCache().id, name);

				controller.getHead_control().getCache().username = name;
				try (ObjectOutputStream newone = new ObjectOutputStream(new FileOutputStream(new File("User_Cache.dat")))){
					newone.writeObject(controller.getHead_control().getCache());
				}
				return null;
			}

			@Override
			protected void done() {
				view.getL_name().setText("Username :  "+ name);
				controller.getHead_control().getStats().setStats();


				MainController.glassPane.setVisible(false);
				MainController.glassPane.setLoading(false);
			}
		};
		save.execute();
	}

	public void savePass(String pass) {
		SwingWorker<Void, Void> save = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				MainController.glassPane.setLoading(true);

				Connection con = DBConnect.createConnect();
				UserTable user = new UserTable(con);
				user.updatePassword(controller.getHead_control().getCache().id, pass);

				controller.getHead_control().getCache().password = pass;
				try (ObjectOutputStream newone = new ObjectOutputStream(new FileOutputStream(new File("User_Cache.dat")))){
					newone.writeObject(controller.getHead_control().getCache());
				}

				return null;
			}

			@Override
			protected void done() {
				MainController.glassPane.setVisible(false);
				MainController.glassPane.setLoading(false);
			}
		};
		save.execute();
	}
}
