package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;

import javax.swing.*;
import java.awt.*;

public class ProfileModel {
	// Attribute
	private ProfileController controller;
	private Profile view;

	// Constructor
	public ProfileModel(Profile view, ProfileController controller){
		this.view = view;
		this.controller = controller;
	}

	// Methods
	public void setProfile() {
		Image picture = new ImageIcon(controller.getHead_control().getCache().image).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		view.getIcon().setIcon(new ImageIcon(picture));
		view.getL_name().setText(view.getL_name().getText() + "  "+ controller.getHead_control().getCache().username);
		view.getL_email().setText(view.getL_email().getText() + "  "+ controller.getHead_control().getCache().gmail);
	}
}
