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
	private int count;
	private int row;

	// Constructor
	public UserTableModel(UserTableController controller, UserTableView view){
		count = 0;
		row = -1;
		this.controller = controller;
		this.view = view;
	}

	// Methods

	@Override
	public void loadData() {
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				view.getModel().setRowCount(0);
				Connection con = DBConnect.createConnect();
				GetInfomation got = new GetInfomation(con);
				controller.setUserData(got.load_AllUser());
				setTable();
				return null;
			}
		};
		load.execute();
	}
	public void setTable(){
		view.getModel().setRowCount(0);
		for (int i = 0; i < controller.getUserData().size(); i++) {
			User_Template user = controller.getUserData().get(i);
			Object[] info = {user.id, user.username, user.gmail, user.password, user.firstname, user.lastname, user.project_done, user.project_expired, user.project_ontime, user.admin};
			view.getModel().addRow(info);
		}
		view.repaint();
	}

	public boolean checkDoubleClick(int row){
		if (this.row != row){count = 0;}
		this.row = row;
		count += 1;
		return count == 2;
	}

	// Accessor
	public int getRow() {
		return row;
	}
	public int getCount() {
		return count;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
