package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;

import com.kmitl.pectjro.Frame.Main_Program.home_page.home_pageController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
			fc.setFileFilter(filter);
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				model.changePicture(fc.getSelectedFile().getAbsolutePath());
			}
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
