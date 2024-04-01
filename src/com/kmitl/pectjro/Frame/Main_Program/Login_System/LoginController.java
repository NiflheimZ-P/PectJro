package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage.Login_Page;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage.Register_Page;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		view.getMain_panel().add(login.getPanel(), "login");
		view.getMain_panel().add(regis.getPanel(), "register");

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
	public CardLayout getPage_manage() {
		return page_manage;
	}
	public void setPage_manage(CardLayout page_manage) {
		this.page_manage = page_manage;
	}
	public LoginView getView() {
		return view;
	}
	public void setView(LoginView view) {
		this.view = view;
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sign up")) {
			page_manage.show(view.getMain_panel(), "register");
		} else if (e.getActionCommand().equals("Back")) {
			page_manage.show(view.getMain_panel(), "login");
		} else if (e.getActionCommand().equals("Submit")) {
			model.creatingAccount();
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
