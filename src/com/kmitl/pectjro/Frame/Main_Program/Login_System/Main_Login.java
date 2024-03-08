package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import com.kmitl.pectjro.Database.DB_Performance;
import com.kmitl.pectjro.Frame.Groups_interface.Changeable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Login extends JPanel implements ActionListener, Changeable {
	private JPanel main_panel;
	private CardLayout page_manage = new CardLayout();
	private Login_Page login;
	private Register_Page regis;
	private static Boolean remember;

	public Main_Login() {
		DB_Performance.createBackground();
		this.setLayout(new GridBagLayout());

		GridBagConstraints manage = new GridBagConstraints();
		login = new Login_Page(this);
		regis = new Register_Page(this);

		main_panel = new JPanel(page_manage);
		main_panel.add(login.getMain_panel(), "login");
		main_panel.add(regis.getMain_panel(), "register");

		this.add(main_panel, manage);

		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	public static void setRemember(Boolean stats) { remember = stats; }
	public static boolean getRemember() { return remember; }

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Sign up")) {
			page_manage.show(main_panel, "register");
		} else if (e.getActionCommand().equals("Back")){
			page_manage.show(main_panel, "login");
		} else if (e.getActionCommand().equals("Submit")){
			if (regis.creatingAccount()){
				page_manage.show(main_panel, "login");
				regis.setEmpty();
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon("resources/Images/kmitl_it_data_science_01.jpg").getImage();

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

