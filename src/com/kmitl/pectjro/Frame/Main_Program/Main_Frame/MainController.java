package com.kmitl.pectjro.Frame.Main_Program.Main_Frame;

import com.kmitl.pectjro.Frame.Loading.Loading_GlassPane;
import com.kmitl.pectjro.Frame.Main_Program.home_page.home_pageController;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginController;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class MainController implements WindowListener {
	// Attribute
	private MainView view;
	private MainModel model;
	private LoginController login;
	private AdminController admin;
	private home_pageController home;
	private Boolean remember;
	public static final Loading_GlassPane glassPane = new Loading_GlassPane();

	// Constructor
	public MainController(){
		this.view = new MainView();
		this.model = new MainModel(view, this);
		login = new LoginController(this);
		admin = new AdminController(this);

		remember = false;
		view.getFrame().addWindowListener(this);
		view.getFrame().setGlassPane(glassPane);
	}

	// Accessor
	public MainView getView() {return this.view;}
	public MainModel getModel() {return this.model;}
	public void setRemember(Boolean stats) { remember = stats; }
	public boolean getRemember() { return remember; }
	public home_pageController getHome() {
		return home;
	}
	public void setHome(home_pageController home) {
		this.home = home;
	}
	public Loading_GlassPane getGlassPane() {
		return glassPane;
	}
	public AdminController getAdmin() {
		return admin;
	}
	public void setAdmin(AdminController admin) {
		this.admin = admin;
	}
	public LoginController getLogin() {
		return login;
	}
	public void setLogin(LoginController login) {
		this.login = login;
	}

	// Listener
	@Override
	public void windowOpened(WindowEvent e) {
		File user = new File("User_Cache.dat");
		if (user.exists()) {
			setRemember(true);
			model.createHome();
		} else {
			model.changePage(login.getContainer());
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		File target = new File("User_Cache.dat");
		if (!getRemember()) { target.delete(); }
	}

	@Override
	public void windowClosed(WindowEvent e) {
		File target = new File("User_Cache.dat");
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
