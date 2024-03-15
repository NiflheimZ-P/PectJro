package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.UserTable;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Groups_interface.Admin_Table_Model;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

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
	public void DeleteUser(String gmail, int row){
		SwingWorker<Void, Void> userDelete = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				Connection con = DBConnect.createConnect();
				UserTable delete = new UserTable(con);
				try {
					delete.deleteUser(gmail);
					JOptionPane.showMessageDialog(null, "Deleted account", "Successful", JOptionPane.PLAIN_MESSAGE);
					controller.getUserData().remove(row);
					view.getModel().removeRow(row);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Cannot delete this account", "Error", JOptionPane.ERROR_MESSAGE);
				}
				return null;
			}
		};
		userDelete.execute();
	}

	@Override
	public void loadData() {
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				view.getRefresh().setEnabled(false);
				view.getModel().setRowCount(0);
				Connection con = DBConnect.createConnect();
				UserTable got = new UserTable(con);
				controller.setUserData(got.load_AllUser());
				setTable();
				view.getRefresh().setEnabled(true);
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

	public void searching(){
		String word = view.getSearch().getText();
		view.getModel().setRowCount(0);
		for (User_Template i : controller.getUserData()){
			if (String.valueOf(i.id).contains(word) || i.username.contains(word) || i.gmail.contains(word) ||
			i.firstname.contains(word) || i.lastname.contains(word)){
				Object[] info = {i.id, i.username, i.gmail, i.password, i.firstname, i.lastname, i.project_done, i.project_expired, i.project_ontime, i.admin};
				view.getModel().addRow(info);
			}
		}
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
