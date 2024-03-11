package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.GetInfomation;
import com.kmitl.pectjro.Frame.Cache_Templates.User_Template;
import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage.Login_Page;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage.Register_Page;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Main_Program.home_page;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController implements MainPage_Controller, ActionListener, DocumentListener {
	// Attribute
	private LoginView view;
	private LoginModel model;
	private MainController main_controller;
	private Login_Page login;
	private Register_Page regis;
	private CardLayout page_manage;


	// Constructor
	public LoginController(MainController main_controller){
		this.main_controller = main_controller;
		page_manage = new CardLayout();
		login = new Login_Page();
		regis = new Register_Page();
		view = new LoginView(login, regis, page_manage);
		model = new LoginModel(login, regis, this);

		login.getSign().addActionListener(this);
		login.getLogin().addActionListener(this);

		regis.getFirstname_field().getDocument().addDocumentListener(this);
		regis.getLastname_field().getDocument().addDocumentListener(this);
		regis.getUsername_field().getDocument().addDocumentListener(this);
		regis.getPassword_field().getDocument().addDocumentListener(this);
		regis.getConfirmpass_field().getDocument().addDocumentListener(this);
		regis.getEmail_field().getDocument().addDocumentListener(this);

		regis.getBack().addActionListener(this);
		regis.getSubmit().addActionListener(this);
	}

	// Accessor
	@Override
	public View_Getter getContainer() {
		return view;
	}
	public LoginModel getModel() {
		return model;
	}

	public MainController getMain_controller() {
		return main_controller;
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sign up")) {
			page_manage.show(view.getView(), "register");
		} else if (e.getActionCommand().equals("Back")) {
			page_manage.show(view.getView(), "login");
		} else if (e.getActionCommand().equals("Submit")) {
			if (model.creatingAccount()) {
				page_manage.show(view.getView(), "login");
				model.setEmpty();
			}
		} else {
			model.loginSystem();
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {model.updateSubmit();}

	@Override
	public void removeUpdate(DocumentEvent e) {model.updateSubmit();}

	@Override
	public void changedUpdate(DocumentEvent e) {model.updateSubmit();}

}
