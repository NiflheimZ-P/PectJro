package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.kmitl.pectjro.Frame.Main_Program.home_page.home_pageController;

public class TaskController {
	// Attribute
	private Task view;
	private TaskModel model;
	private home_pageController head_control;

	// Constructor
	public TaskController(home_pageController head_control) {
		this.head_control = head_control;
		this.view = new Task();
		this.model = new TaskModel(view, this);
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
