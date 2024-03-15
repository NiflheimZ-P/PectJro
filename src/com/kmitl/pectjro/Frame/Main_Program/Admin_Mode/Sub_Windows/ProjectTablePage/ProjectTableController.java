package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectTableController implements ActionListener {
	// Attribute
	private ProjectTableView view;
	private ProjectTableModel model;
	private AdminController head_control;

	// Constructor
	public ProjectTableController(AdminController head_control) {
		view = new ProjectTableView();
		model = new ProjectTableModel(view, this);
		this.head_control = head_control;

		view.addInternalFrameListener(head_control);
		view.getAdd_new().addActionListener(this);
	}

	// Accessor
	public ProjectTableView getView() {return view;}
	public ProjectTableModel getModel() {return model;}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add New")) {
			ProjectAdd add = new ProjectAdd();
			add.getFrame().addInternalFrameListener(head_control);
			head_control.addNew(add.getFrame());
		}
	}
}
