package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage.Login_Page;
import com.kmitl.pectjro.Frame.Main_Program.Login_System.LoginPage.Register_Page;
import com.kmitl.pectjro.Frame.Tools.JPanelBG;

import javax.swing.*;
import java.awt.*;

public class LoginView implements View_Getter {
	private JPanelBG loginview;
	private JPanel main_panel;

	public LoginView(Login_Page login, Register_Page regis, CardLayout page_manage) {
		this.loginview = new JPanelBG(new ImageIcon("resources/Images/kmitl_it_data_science_01.jpg").getImage());
		loginview.setLayout(new GridBagLayout());

		GridBagConstraints manage = new GridBagConstraints();

		main_panel = new JPanel(page_manage);

		loginview.add(main_panel, manage);

		loginview.setFocusable(true);
		loginview.requestFocusInWindow();
	}
	// Accessor
	@Override
	public Container getView() {
		return loginview;
	}
	public JPanel getMain_panel() { return main_panel; }
}

