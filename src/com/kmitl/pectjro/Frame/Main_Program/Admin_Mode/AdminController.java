package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode;

import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Admin_controls;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;

import java.awt.*;

public class AdminController implements MainPage_Controller {
	// Attribute
	private AdminView view;
	private AdminModel model;
	private MainController main_controller;
	private Admin_controls admin_control;

	// Constructor
	public AdminController(MainController main_controller){
		this.main_controller = main_controller;
		view = new AdminView();
		model = new AdminModel(view);
		admin_control = new Admin_controls(main_controller.getView().getFrame().getWidth(),
				main_controller.getView().getFrame().getHeight()
		);
	}

	// Accessor
	@Override
	public View_Getter getContainer() {
		return view;
	}
}
