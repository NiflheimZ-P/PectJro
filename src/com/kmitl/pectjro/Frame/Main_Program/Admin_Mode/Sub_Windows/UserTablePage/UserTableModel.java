package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.GetInfomation;
import com.kmitl.pectjro.Frame.Cache_Templates.User_Template;
import com.kmitl.pectjro.Frame.Groups_interface.Admin_Table_Model;
import javax.swing.*;
import java.sql.Connection;

public class UserTableModel implements Admin_Table_Model {
	// Attribute
	private UserTableView view;
	private UserTableController controller;

	// Constructor
	public UserTableModel(UserTableController controller, UserTableView view){
		this.controller = controller;
		this.view = view;
	}
	@Override
	public void loadData() {
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				view.getModel().setRowCount(0);
				Connection con = DBConnect.createConnect();
				GetInfomation got = new GetInfomation(con);
				controller.setUserData(got.load_AllUser());

				return null;
			}
		};
		load.execute();
	}

	public void setTable(){
		for (int i = 0; i < controller.getUserData().size(); i++) {
			User_Template user = controller.getUserData().get(i);
			Object[] info = {user.id, user.username, user.gmail, user.password, user.firstname, user.lastname, user.project_done, user.project_expired, user.project_ontime, user.admin};
			view.getModel().addRow(info);
		}
	}
}
