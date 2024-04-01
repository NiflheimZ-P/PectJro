package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Main_Program.home_page.home_pageController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class TaskController implements ActionListener {
	// Attribute
	private Task view;
	private TaskModel model;
	private home_pageController head_control;

	// Constructor
	public TaskController(home_pageController head_control) {
		this.head_control = head_control;
		this.view = new Task();
		this.model = new TaskModel(view, this);

		view.getCreate_pro().addActionListener(this);
		view.getRef().addActionListener(this);
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(view.getCreate_pro())){
			MainController.glassPane.setVisible(true);
			new ProjectCreate(this);
		} else if (e.getSource().equals(view.getRef())) {
			try {
				head_control.getModel().loadHome();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	// Accessor
	public Task getView() {
		return view;
	}
	public void setView(Task view) {
		this.view = view;
	}
	public TaskModel getModel() {
		return model;
	}
	public void setModel(TaskModel model) {
		this.model = model;
	}
	public home_pageController getHead_control() {
		return head_control;
	}
	public void setHead_control(home_pageController head_control) {
		this.head_control = head_control;
	}
}
