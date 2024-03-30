package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode;

import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Admin_controls;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Feedback_Page.FeedbackController;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage.ProjectTableController;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage.UserTableController;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage.UserTableView;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminController implements MainPage_Controller, ActionListener, InternalFrameListener {
	// Attribute
	private AdminView view;
	private AdminModel model;
	private MainController main_controller;
	private Admin_controls admin_control;
	private UserTableController userTable;
	private ProjectTableController projectTable;
	private ArrayList<JInternalFrame> opened;
	private FeedbackController feedback;

	// Constructor
	public AdminController(MainController main_controller){
		this.opened = new ArrayList<>();
		this.main_controller = main_controller;
		view = new AdminView();
		model = new AdminModel(view, this);
		admin_control = new Admin_controls(main_controller.getView().getFrame().getWidth(),
				main_controller.getView().getFrame().getHeight()
		);

		userTable = new UserTableController(this);

		feedback = new FeedbackController(this);

		projectTable = new ProjectTableController(this);

		view.getView().add(admin_control.getFrame());
		admin_control.getUser().addActionListener(this);
		admin_control.getFeedback().addActionListener(this);
		admin_control.getProject().addActionListener(this);
		admin_control.getExit().addActionListener(this);
	}

	// Methods
	public void addNew(JInternalFrame add){
		getContainer().getView().add(add);
		add.setLocation(
				(getContainer().getView().getWidth() - add.getWidth()) / 2,
				(getContainer().getView().getHeight() - add.getHeight()) / 2);
		add.setVisible(true);
	}

	// Accessor
	@Override
	public View_Getter getContainer() {
		return view;
	}
	public UserTableController getUserTable() {return userTable;}
	public ArrayList<JInternalFrame> getOpened() {return opened;}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(admin_control.getUser())){
			if (!opened.contains(userTable.getView())) {
				opened.add(userTable.getView());
				userTable.getView().setLocation(
						(main_controller.getView().getFrame().getWidth() - userTable.getView().getWidth()) / 2,
						(main_controller.getView().getFrame().getHeight() - userTable.getView().getHeight()) / 2
				);
				userTable.getView().setVisible(true);
				view.getView().add(userTable.getView());
				userTable.getView().moveToFront();
				userTable.getModel().loadData();
			} else { userTable.getView().toFront(); }
		} else if (e.getSource().equals(admin_control.getFeedback())){
			if (!opened.contains(feedback.getView().getFrame())) {
				opened.add(feedback.getView().getFrame());
				feedback.getView().getFrame().setLocation(
						(main_controller.getView().getFrame().getWidth() - feedback.getView().getFrame().getWidth()) / 2,
						(main_controller.getView().getFrame().getHeight() - feedback.getView().getFrame().getHeight()) / 2
				);
				feedback.getView().getFrame().setVisible(true);
				view.getView().add(feedback.getView().getFrame());
				feedback.getView().getFrame().moveToFront();
				feedback.getModel().loadData();
			} else { feedback.getView().getFrame().toFront(); }
		} else if (e.getSource().equals(admin_control.getProject())){
			if (!opened.contains(projectTable.getView())) {
				opened.add(projectTable.getView());
				projectTable.getView().setLocation(
						(main_controller.getView().getFrame().getWidth() - feedback.getView().getFrame().getWidth()) / 2,
						(main_controller.getView().getFrame().getHeight() - feedback.getView().getFrame().getHeight()) / 2
				);
				projectTable.getView().setVisible(true);
				view.getView().add(projectTable.getView());
				projectTable.getView().moveToFront();
				projectTable.getModel().loadData();
			} else { projectTable.getView().toFront(); }
		} else if (e.getSource().equals(admin_control.getExit())) {
			main_controller.getModel().createHome();
		}
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		getOpened().remove(e.getInternalFrame());
		getContainer().getView().remove(e.getInternalFrame());
		getContainer().getView().repaint();
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
}
