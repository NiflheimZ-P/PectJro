package com.kmitl.pectjro.Frame.Main_Program.home_page;

import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Calendar.CalendarController;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile.ProfileController;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Stats;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.ProjectCreate;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.TaskController;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class home_pageController implements MainPage_Controller, ActionListener {
	// Attribute
	private home_page view;
	private home_pageModel model;
	private MainController main_controller;
	private User_Template cache;
	private ArrayList<Project_Template> projectIn;
	CardLayout page = new CardLayout();
	private Stats Statss;
	private ProfileController profile;
	private CalendarController calen;
	private TaskController task;

	// Constructor
	public home_pageController(MainController main_controller) {
		this.view = new home_page();
		this.model = new home_pageModel(view, this);
		this.main_controller = main_controller;

		//feature create
		Statss = new Stats();
		profile = new ProfileController(this);
		calen = new CalendarController(this);
		task = new TaskController(this);


		view.getCenter_part().setLayout(page);

		//add to centerPart
		view.getCenter_part().add(task.getView().getFrame(), "0");
		view.getCenter_part().add(Statss.getFrame(),"2");
		//view.getCenter_part().add(calen.getView().getFrame(), "1");
		//view.getCenter_part().add(Statss.getFr(),"2");
		view.getCenter_part().add(profile.getView().getFr(), "3");

		view.getBn_new().addActionListener(this);
		view.getBn_task().addActionListener(this);
		view.getBn_appraisement().addActionListener(this);
		view.getBn_calendar().addActionListener(this);
		view.getBn_profile().addActionListener(this);
		view.getBn_admin().addActionListener(this);
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(view.getBn_new())){
			new ProjectCreate();
		}else if (e.getSource().equals(view.getBn_task())){
			page.show(view.getCenter_part(), "0");
			view.getMain_panel().add(view.getPn_east(), BorderLayout.EAST);
			view.getPaneforsearch().setVisible(true);
		}else if (e.getSource().equals(view.getBn_calendar())) {
			page.show(view.getCenter_part(), "1");
			view.getMain_panel().remove(view.getPn_east());
			view.getPaneforsearch().setVisible(false);
		}else if (e.getSource().equals(view.getBn_appraisement())){
			page.show(view.getCenter_part(), "2");
			view.getMain_panel().remove(view.getPn_east());
			view.getPaneforsearch().setVisible(false);
		}else if (e.getSource().equals(view.getBn_profile())) {
			page.show(view.getCenter_part(), "3");
			view.getMain_panel().remove(view.getPn_east());
			view.getPaneforsearch().setVisible(false);
		}else if (e.getSource().equals(view.getBn_admin())) {
			int selectedOption = JOptionPane.showConfirmDialog(null,
					"Are you sure?",
					"Choose",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				model.loadAdmin();
			}
		}
	}


	// Accessor
	public home_page getView() {
		return view;
	}
	public void setView(home_page view) {
		this.view = view;
	}
	public home_pageModel getModel() {
		return model;
	}
	public void setModel(home_pageModel model) {
		this.model = model;
	}
	public MainController getMain_controller() {
		return main_controller;
	}
	public void setMain_controller(MainController main_controller) {
		this.main_controller = main_controller;
	}
	public User_Template getCache(){ return this.cache; }
	public void setCache(User_Template cache) {
		this.cache = cache;
	}
	public ArrayList<Project_Template> getProjectIn() {
		return projectIn;
	}
	public void setProjectIn(ArrayList<Project_Template> projectIn) {
		this.projectIn = projectIn;
	}
	public ProfileController getProfile() {
		return profile;
	}
	public void setProfile(ProfileController profile) {
		this.profile = profile;
	}
	public TaskController getTask() {
		return task;
	}
	public void setTask(TaskController task) {
		this.task = task;
	}

	@Override
	public View_Getter getContainer() {
		return view;
	}

}
