package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

public class TaskModel {
	// Attribute
	private TaskController controller;
	private Task view;

	// Constructor
	public TaskModel(Task view, TaskController controller) {
		this.controller = controller;
		this.view = view;
	}
}
