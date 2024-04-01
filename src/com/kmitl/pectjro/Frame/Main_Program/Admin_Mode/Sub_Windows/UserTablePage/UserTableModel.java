package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Groups_interface.Admin_Table_Model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class UserTableModel implements Admin_Table_Model {
	// Attribute
	private UserTableView view;
	private UserTableController controller;

	// Constructor
	public UserTableModel(UserTableController controller, UserTableView view){
		this.controller = controller;
		this.view = view;
	}

	// Methods
	public void DeleteUser(String gmail, int row){
		SwingWorker<Void, Void> userDelete = new SwingWorker<Void, Void>() {
			private final Loading_dialog loading = new Loading_dialog(view);
			@Override
			protected Void doInBackground() throws Exception {
				loading.setVisible(true);
				Connection con = DBConnect.createConnect();
				UserTable delete = new UserTable(con);
				try {
					delete.deleteUser(gmail);
					controller.getUserData().remove(row);
					view.getModel().removeRow(row);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Cannot delete this account", "Error", JOptionPane.ERROR_MESSAGE);
				}
				return null;
			}

			@Override
			protected void done(){
				loading.dispose();
			}
		};
		userDelete.execute();
	}

	@Override
	public void loadData() {
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			private final Loading_dialog loading = new Loading_dialog(view);
			@Override
			protected Void doInBackground() throws Exception {
				loading.setVisible(true);
				view.getRefresh().setEnabled(false);
				view.getModel().setRowCount(0);
				Connection con = DBConnect.createConnect();
				UserTable got = new UserTable(con);
				controller.setUserData(got.load_AllUser());
				setTable();
				if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
					searching();
				}
				view.getRefresh().setEnabled(true);
				return null;
			}

			@Override
			protected void done() {
				loading.dispose();
			}
		};
		load.execute();
	}
	public void setTable(){
		view.getModel().setRowCount(0);
		for (int i = 0; i < controller.getUserData().size(); i++) {
			User_Template user = controller.getUserData().get(i);
			Object[] info = {user.id, user.username, user.gmail, user.firstname, user.lastname, user.project_done, user.project_expired, user.project_ontime, user.admin};
			view.getModel().addRow(info);
		}
		view.repaint();
	}

	public void searching(){
		String word = view.getSearch().getText().toLowerCase();
		view.getModel().setRowCount(0);
		for (User_Template i : controller.getUserData()){
			if (String.valueOf(i.id).contains(word) || i.username.toLowerCase().contains(word) || i.gmail.toLowerCase().contains(word) ||
					i.firstname.toLowerCase().contains(word) || i.lastname.toLowerCase().contains(word)){
				Object[] info = {i.id, i.username, i.gmail, i.firstname, i.lastname, i.project_done, i.project_expired, i.project_ontime, i.admin};
				view.getModel().addRow(info);
			}
		}
	}

	public void setUpProgram() {
		view.addInternalFrameListener(controller.getHead_control());
		view.getDelete().addActionListener(controller);
		view.getAdd_new().addActionListener(controller);
		view.getSearch().getDocument().addDocumentListener(controller);
		view.getRefresh().addActionListener(controller);
		view.getView().addActionListener(controller);
		view.getModel().addTableModelListener(controller);
	}
}
