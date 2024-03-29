package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.UserTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage.Login_Page;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage.Register_Page;
import com.kmitl.pectjro.Frame.Main_Program.home_page;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginModel {
	// Attribute
	private LoginController controller;
	private Login_Page login;
	private Register_Page regis;

	// Constructor
	public LoginModel(Login_Page login, Register_Page regis, LoginController controller){
		this.login = login;
		this.regis = regis;
		this.controller = controller;
	}

	// Methods
	public void loginSystem() {
		SwingWorker<Void, Void> getIn = new SwingWorker<Void, Void>() {
			private final Loading_dialog load = new Loading_dialog(controller.getMain_controller().getView().getFrame());

			@Override
			protected Void doInBackground() throws Exception {
				load.setVisible(true);
				String gmail = login.getEmail().getText();
				String pass = login.getPass().getMyPass();

				File remember = new File("User_Cache");
				try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(remember))) {
					Connection con = DBConnect.createConnect();
					UserTable data = new UserTable(con);
					User_Template thisGmail = data.getUserData(gmail);

					if(!pass.equals(thisGmail.password)){
						JOptionPane.showMessageDialog(null, "Password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
						return null;
					} else {
						controller.getMain_controller().setRemember(login.getCheck().isSelected());
					}

					remember.createNewFile();
					write.writeObject(thisGmail);
					controller.getMain_controller().setCache(thisGmail);
				} catch (SQLException ex) {
					load.dispose();
					JOptionPane.showMessageDialog(null, "The email address doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (IOException ex) {
					load.dispose();
					JOptionPane.showMessageDialog(null, "Cannot access file 'User_Cache'", "Error", JOptionPane.ERROR_MESSAGE);
				}
				return null;
			}

			@Override
			protected void done() {
				load.dispose();
				controller.getMain_controller().getModel().createHome();
			}
		};
		getIn.execute();
	}

	public void creatingAccount() {
		SwingWorker<Void, Void> create = new SwingWorker<Void, Void>() {
			private final Loading_dialog load = new Loading_dialog(controller.getView().getView());
			@Override
			protected Void doInBackground() throws Exception {
				load.setVisible(true);
				String user = regis.getUsername_field().getText();
				String gmail = regis.getEmail_field().getText();
				String pass = String.valueOf(regis.getPassword_field().getPassword());
				String first = regis.getFirstname_field().getText();
				String last = regis.getLastname_field().getText();
				try {
					Connection con = DBConnect.createConnect();
					UserTable add = new UserTable(con);
					add.addUserData(user, gmail, pass, first, last);
					controller.getPage_manage().show(controller.getView().getMain_panel(), "login");
					setEmpty();
				} catch (SQLException ex) {
					load.dispose();
					JOptionPane.showMessageDialog(null, "this email is already in use", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (FileNotFoundException e) {
					load.dispose();
					e.printStackTrace();
				}
				load.dispose();
				JOptionPane.showMessageDialog(null, "Your account has been created", "Created", JOptionPane.PLAIN_MESSAGE);
				return null;
			}
		};
		create.execute();
	}

	public void updateSubmit(){
		if (!checkEmpty() && checkPass() && checkGmail()){
			regis.getSubmit().setEnabled(true);
			regis.getSubmit().setToolTipText("");
		} else if (!checkPass()) {
			regis.getSubmit().setEnabled(false);
			regis.getSubmit().setToolTipText("password and confirm password validation");
		} else if (checkEmpty()){
			regis.getSubmit().setEnabled(false);
			regis.getSubmit().setToolTipText("Missing some information");
		} else if (!checkGmail()){
			regis.getSubmit().setEnabled(false);
			regis.getSubmit().setToolTipText("Email must contain character '@'");
		}
	}

	public boolean checkEmpty(){
		return (regis.getUsername_field().getText().isEmpty() ||
				regis.getEmail_field().getText().isEmpty() ||
				String.valueOf(regis.getPassword_field().getPassword()).isEmpty() ||
				String.valueOf(regis.getConfirmpass_field()).isEmpty() ||
				regis.getFirstname_field().getText().isEmpty() ||
				regis.getLastname_field().getText().isEmpty()
		);
	}

	public void setEmpty() {
		regis.getUsername_field().setText("");
		regis.getEmail_field().setText("");
		regis.getPassword_field().setText("");
		regis.getConfirmpass_field().setText("");
		regis.getFirstname_field().setText("");
		regis.getLastname_field().setText("");
	}

	public boolean checkPass(){
		return (String.valueOf(regis.getPassword_field().getPassword()).equals(String.valueOf(regis.getConfirmpass_field().getPassword())));
	}

	public boolean checkGmail(){
		return (regis.getEmail_field().getText().contains("@") && regis.getEmail_field().getText().contains("."));
	}
}
