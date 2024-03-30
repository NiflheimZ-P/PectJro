package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;

import com.kmitl.pectjro.Frame.Main_Program.home_page.home_pageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ProfileController implements ActionListener {
	// Attribute
	private Profile view;
	private ProfileModel model;
	private home_pageController head_control;

	// Constructor
	public ProfileController(home_pageController head_control) {
		this.head_control = head_control;
		this.view = new Profile();
		this.model = new ProfileModel(view, this);

		view.getBn_select_photo().addActionListener(this);
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(view.getBn_select_photo())) {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(view.getFr());
			File f = fc.getSelectedFile();
			view.setIm_profile(new ImageIcon(f.getAbsolutePath()).getImage());
			Image newImage = view.getIm_profile().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
			ImageIcon ic_image = new ImageIcon(newImage);
			view.getIcon().setIcon(ic_image);
			Image tmp = view.getIm_profile().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon imttmp = new ImageIcon(tmp);
			head_control.getView().getBn_profile().setIcon(imttmp);
			head_control.getView().getPaneforsearch().setVisible(false);
		}
	}

	// Accessor
	public Profile getView() {
		return view;
	}
	public void setView(Profile view) {
		this.view = view;
	}
	public ProfileModel getModel() {
		return model;
	}
	public void setModel(ProfileModel model) {
		this.model = model;
	}
	public home_pageController getHead_control() {
		return head_control;
	}
	public void setHead_control(home_pageController head_control) {
		this.head_control = head_control;
	}
}
