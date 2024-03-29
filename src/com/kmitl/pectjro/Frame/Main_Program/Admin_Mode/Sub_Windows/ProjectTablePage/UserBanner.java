package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.Image_Resizer;

import javax.swing.*;
import java.awt.*;

public class UserBanner extends JPanel {
	// Attribute
	private User_Template user;

	// Constructor
	public UserBanner(User_Template user) {
		super();
		this.user = user;
		this.setLayout(new GridBagLayout());
		this.add(new Image_Resizer(new ImageIcon(user.image), 27, 27), new Constraints(0, 0, 0, 0, 21, new Insets(10, 10, 10, 10)));
		JLabel username = new JLabel(user.username); username.setFont(new Font("", Font.BOLD, 15));
		this.add(username, new Constraints(1, 0, 0, 0, 21, new Insets(10, 15, 10, 10)));
		JLabel fullName = new JLabel(user.firstname + " " + user.lastname);
		fullName.setFont(new Font("", Font.PLAIN, 13));
		fullName.setForeground(Color.lightGray);
		this.add(fullName, new Constraints(2, 0, 1, 0, 21, new Insets(10, 15, 10, 10)));
		this.setPreferredSize(new Dimension(570, 50));
	}

	// Accessor
	public User_Template getUser() {
		return user;
	}
	public void setUser(User_Template user) {
		this.user = user;
	}
}
