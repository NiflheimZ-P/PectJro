package com.kmitl.pectjro.Frame.Main_Program.Main_Frame;

import com.kmitl.pectjro.Frame.Loading.Loading_GlassPane;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginController;
import com.kmitl.pectjro.Frame.Main_Program.home_page;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;

public class MainController implements WindowListener {
	// Attribute
	private MainView view;
	private MainModel model;
	private LoginController login;
	private AdminController admin;
	private home_page home;
	private Boolean remember;
	private User_Template cache;
	private ArrayList<Project_Template> projectIn;
	private Loading_GlassPane glassPane;

	// Constructor
	public MainController(){
		this.view = new MainView();
		this.model = new MainModel(view, this);
		login = new LoginController(this);
		admin = new AdminController(this);

		remember = false;
		view.getFrame().addWindowListener(this);
		glassPane = new Loading_GlassPane();
		view.getFrame().setGlassPane(glassPane);
	}

	// Accessor
	public MainView getView() {return this.view;}
	public MainModel getModel() {return this.model;}
	public void setRemember(Boolean stats) { remember = stats; }
	public boolean getRemember() { return remember; }
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
	public home_page getHome() {
		return home;
	}
	public void setHome(home_page home) {
		this.home = home;
	}
	public Loading_GlassPane getGlassPane() {
		return glassPane;
	}
	public void setGlassPane(Loading_GlassPane glassPane) {
		this.glassPane = glassPane;
	}

	// Listener
	@Override
	public void windowOpened(WindowEvent e) {
		File user = new File("User_Cache");
		if (user.exists()) {
			setRemember(true);
			model.loadCache();
			model.changePage(new home_page(cache));
		} else {
			model.changePage(login.getContainer());
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		File target = new File("User_Cache");
		if (!getRemember()) { target.delete(); }
	}

	@Override
	public void windowClosed(WindowEvent e) {
		File target = new File("User_Cache");
		if (!getRemember()) { target.delete(); }
	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
