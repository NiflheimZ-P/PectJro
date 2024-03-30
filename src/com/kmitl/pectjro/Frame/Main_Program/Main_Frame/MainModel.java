package com.kmitl.pectjro.Frame.Main_Program.Main_Frame;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.ProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserProjectTable;
import com.kmitl.pectjro.Frame.Main_Program.home_page.home_page;
import com.kmitl.pectjro.Frame.Main_Program.home_page.home_pageController;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainModel {
	// Attribute
	private boolean theme;
	private MainController controller;
	private MainView view;
	// Constructor
	public MainModel(MainView view, MainController controller) {
		this.controller = controller;
		this.view = view;
		theme = true;
	}

	// Methods
	public void changeTheme(){
		theme = !theme;
		try {
			if (theme) {
				UIManager.setLookAndFeel(new FlatMacLightLaf());
			} else {
				UIManager.setLookAndFeel(new FlatMacDarkLaf());
			}
		} catch (Exception e) { e.printStackTrace(); }
		SwingUtilities.updateComponentTreeUI(view.getFrame());
	}
	public void changePage(View_Getter page){
		view.getFrame().setContentPane(page.getView());
		view.getFrame().repaint();
		view.getFrame().revalidate();
	}

	public void createHome() {
		controller.setHome(new home_pageController(controller));
		changePage(controller.getHome().getView());
		try {
			controller.getHome().getModel().loadHome();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Can't access to your profile", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
