package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.kmitl.pectjro.Frame.Tools.Constraints;

import java.awt.*;

public class TaskModel {
	// Attribute
	private TaskController controller;
	private Task view;

	// Constructor
	public TaskModel(Task view, TaskController controller) {
		this.controller = controller;
		this.view = view;
	}

	// Methods
	public void loadProject() {
		view.getPl().setLayout(new GridBagLayout());
		for (int i = 0; i < controller.getHead_control().getProjectIn().size(); i++){
			if (i != controller.getHead_control().getProjectIn().size() - 1) {
				view.getPl().add(new task_select(controller.getHead_control().getProjectIn().get(i)),
						new Constraints(0, i, 0, 0, 21, new Insets(0, 0, 0, 0)));
			} else {
				view.getPl().add(new task_select(controller.getHead_control().getProjectIn().get(i)),
						new Constraints(0, i, 1, 1, GridBagConstraints.FIRST_LINE_START, new Insets(0, 0, 0, 0)));
			}
		}
	}
}
