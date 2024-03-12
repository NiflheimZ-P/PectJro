package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode;

import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Admin_controls;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage.UserTableController;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage.UserTableView;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController implements MainPage_Controller, ActionListener {
	// Attribute
	private AdminView view;
	private AdminModel model;
	private MainController main_controller;
	private Admin_controls admin_control;
	private UserTableController userTable;

	// Constructor
	public AdminController(MainController main_controller){
		this.main_controller = main_controller;
		view = new AdminView();
		model = new AdminModel(view);
		admin_control = new Admin_controls(main_controller.getView().getFrame().getWidth(),
				main_controller.getView().getFrame().getHeight()
		);
		userTable = new UserTableController(this);
		view.getView().add(admin_control.getFrame());

		admin_control.getUser().addActionListener(this);
	}

	// Accessor
	@Override
	public View_Getter getContainer() {
		return view;
	}
	public UserTableController getUserTable() {return userTable;}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(admin_control.getUser())){
			System.out.println("Press");
			view.getView().add(userTable.getView());
			userTable.getModel().setTable();
		}
	}
}
