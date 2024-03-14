package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.UpdateTable;
import com.kmitl.pectjro.Frame.Cache_Templates.User_Template;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

public class UserTableController implements TableModelListener, InternalFrameListener, ActionListener, DocumentListener {
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

		view.addInternalFrameListener(this);
		view.getDelete().addActionListener(this);
		view.getAdd_new().addActionListener(this);
		view.getSearch().getDocument().addDocumentListener(this);
		view.getRefresh().addActionListener(this);
		view.getView().addActionListener(this);
		view.getModel().addTableModelListener(this);
	}

	// Accessor
	public UserTableView getView() {return view;}
	public UserTableModel getModel() {return model;}
	public ArrayList<User_Template> getUserData() {return userData;}
	public void setUserData(ArrayList<User_Template> data) {this.userData = data;}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("Delete")){
				model.DeleteUser(String.valueOf(view.getModel().getValueAt(view.getTable().getSelectedRow(), 2)), view.getTable().getSelectedRow());
			} else if (e.getActionCommand().equals("Add New")){
				UserAdd add = new UserAdd(this);
				add.getFrame().addInternalFrameListener(this);
				head_controll.getContainer().getView().add(add.getFrame());
				add.getFrame().setVisible(true);
			} else if (e.getActionCommand().equals("Refresh")) {model.loadData();}
			else if (e.getActionCommand().equals("View")){
				model.setCount(0);
				UserView profile = new UserView(userData.get(view.getTable().getSelectedRow()));
				profile.getFrame().setLocation(
						(head_controll.getContainer().getView().getWidth() - profile.getFrame().getWidth()) / 2,
						(head_controll.getContainer().getView().getHeight() - profile.getFrame().getHeight()) / 2
				);
				head_controll.getContainer().getView().add(profile.getFrame());
				profile.getFrame().toFront();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		e.getInternalFrame().setLocation((int) ((head_controll.getContainer().getView().getWidth() - e.getInternalFrame().getWidth()) / 2),
				(int) ((head_controll.getContainer().getView().getHeight() - e.getInternalFrame().getHeight()) / 2));
		e.getInternalFrame().setFocusable(true);
		e.getInternalFrame().requestFocus();
		e.getInternalFrame().toFront();
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		head_controll.getOpened().remove(e.getInternalFrame());
		head_controll.getContainer().getView().remove(e.getInternalFrame());
		head_controll.getContainer().getView().repaint();
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {

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
		SwingWorker<Void, Void> update = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				Connection con = DBConnect.createConnect();
				UpdateTable update = new UpdateTable(con);
				int i = view.getTable().getSelectedRow();
				switch (e.getColumn()){
					case 6:
						userData.get(i).project_done = (int) view.getModel().getValueAt(i, 6);
						update.updateUserData("Project_Done", String.valueOf(view.getModel().getValueAt(i, 6)), String.valueOf(view.getModel().getValueAt(i, 0)));
						break;
					case 7:
						userData.get(i).project_expired = (int) view.getModel().getValueAt(i, 7);
						update.updateUserData("Project_Expired", String.valueOf(view.getModel().getValueAt(i, 7)), String.valueOf(view.getModel().getValueAt(i, 0)));
						break;
					case 8:
						userData.get(i).project_ontime = (int) view.getModel().getValueAt(i, 8);
						update.updateUserData("Project_Ontime", String.valueOf(view.getModel().getValueAt(i, 8)), String.valueOf(view.getModel().getValueAt(i, 0)));
						break;
					case 9:
						userData.get(i).admin = (boolean) view.getModel().getValueAt(i, 9);
						update.updateUserData("Admin", String.valueOf(view.getModel().getValueAt(i, 9)), String.valueOf(view.getModel().getValueAt(i, 0)));
						break;
				}
				return null;
			}
		};
		update.execute();
	}
}
