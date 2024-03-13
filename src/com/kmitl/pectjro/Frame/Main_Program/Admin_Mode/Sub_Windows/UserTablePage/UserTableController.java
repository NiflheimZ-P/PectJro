package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Frame.Cache_Templates.User_Template;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UserTableController implements MouseListener, InternalFrameListener, ActionListener, DocumentListener {
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


		view.getTable().addMouseListener(this);
		view.addInternalFrameListener(this);
		view.getDelete().addActionListener(this);
		view.getAdd_new().addActionListener(this);
		view.getSearch().getDocument().addDocumentListener(this);

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
				UserAdd add = new UserAdd();
				add.getFrame().addInternalFrameListener(this);
				head_controll.getContainer().getView().add(add.getFrame());
				add.getFrame().setVisible(true);
			}
		} catch (Exception ex) {
			System.out.println("can't delete");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (model.checkDoubleClick(view.getTable().getSelectedRow())){
			model.setCount(0);
			UserEdit profile = new UserEdit(userData.get(view.getTable().getSelectedRow()));
			profile.getFrame().setLocation(
					(head_controll.getContainer().getView().getWidth() - profile.getFrame().getWidth()) / 2,
					(head_controll.getContainer().getView().getHeight() - profile.getFrame().getHeight()) / 2
			);
			head_controll.getContainer().getView().add(profile.getFrame());
			profile.getFrame().toFront();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		System.out.println(e.getInternalFrame().getTitle());
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
		if (!view.getSearch().getText().isEmpty() && !view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().isEmpty() && !view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().isEmpty() && !view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.searching();
		}
	}
}
