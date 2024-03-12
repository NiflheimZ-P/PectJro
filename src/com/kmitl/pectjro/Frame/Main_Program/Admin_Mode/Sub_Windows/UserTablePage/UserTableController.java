package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Frame.Cache_Templates.User_Template;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;

import java.util.ArrayList;

public class UserTableController {
	// Attribute
	private UserTableView view;
	private UserTableModel model;
	private AdminController head_controll;
	private ArrayList<User_Template> userData;

	// Constructor
	public UserTableController(AdminController head_controll) {
		this.head_controll = head_controll;
		this.view = new UserTableView();
		this.model = new UserTableModel(this, view);
	}

	// Accessor
	public UserTableView getView() {return view;}
	public UserTableModel getModel() {return model;}
	public ArrayList<User_Template> getUserData() {return userData;}
	public void setUserData(ArrayList<User_Template> data) {this.userData = data;}
}
