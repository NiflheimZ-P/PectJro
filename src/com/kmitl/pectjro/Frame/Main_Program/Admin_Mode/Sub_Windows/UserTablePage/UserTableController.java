package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

public class UserTableController implements TableModelListener, ActionListener, DocumentListener {
	// Attribute
	private UserTableView view;
	private UserTableModel model;
	private AdminController head_control;
	private ArrayList<User_Template> userData;


	// Constructor
	public UserTableController(AdminController head_controll) {
		this.head_control = head_controll;
		this.view = new UserTableView();
		this.model = new UserTableModel(this, view);

	}

	// Accessor
	public UserTableView getView() {return view;}
	public UserTableModel getModel() {return model;}
	public ArrayList<User_Template> getUserData() {return userData;}
	public void setUserData(ArrayList<User_Template> data) {this.userData = data;}
	public AdminController getHead_control() {
		return head_control;
	}
	public void setHead_control(AdminController head_control) {
		this.head_control = head_control;
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("Delete")){
				model.DeleteUser(String.valueOf(view.getModel().getValueAt(view.getTable().getSelectedRow(), 2)), view.getTable().getSelectedRow());
			} else if (e.getActionCommand().equals("Add New")){
				UserAdd add = new UserAdd(this);
				add.getFrame().addInternalFrameListener(head_control);
				head_control.addNew(add.getFrame());
			} else if (e.getActionCommand().equals("Refresh")) {model.loadData();}
			else if (e.getActionCommand().equals("View")){
				UserView add = new UserView(userData.get(view.getTable().getSelectedRow()));
				head_control.addNew(add.getFrame());
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Please select user first.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		if (view.getTable().getSelectedRow() != -1) {
			SwingWorker<Void, Void> update = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					Connection con = DBConnect.createConnect();
					UserTable update = new UserTable(con);
					int i = view.getTable().getSelectedRow();
					switch (e.getColumn()) {
						case 5:
							userData.get(i).project_done = (int) view.getModel().getValueAt(i, 5);
							update.updateUserData("Project_Done", String.valueOf(view.getModel().getValueAt(i, 5)), String.valueOf(view.getModel().getValueAt(i, 0)));
							break;
						case 6:
							userData.get(i).project_expired = (int) view.getModel().getValueAt(i, 6);
							update.updateUserData("Project_Expired", String.valueOf(view.getModel().getValueAt(i, 6)), String.valueOf(view.getModel().getValueAt(i, 0)));
							break;
						case 7:
							userData.get(i).project_ontime = (int) view.getModel().getValueAt(i, 7);
							update.updateUserData("Project_Ontime", String.valueOf(view.getModel().getValueAt(i, 7)), String.valueOf(view.getModel().getValueAt(i, 0)));
							break;
						case 8:
							userData.get(i).admin = (boolean) view.getModel().getValueAt(i, 8);
							update.updateUserData("Admin", String.valueOf(view.getModel().getValueAt(i, 8)), String.valueOf(view.getModel().getValueAt(i, 0)));
							break;
					}
					return null;
				}
			};
			update.execute();
		}
	}
}
