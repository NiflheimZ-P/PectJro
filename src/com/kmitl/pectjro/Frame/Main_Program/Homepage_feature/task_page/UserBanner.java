package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Tools.Image_Resizer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserBanner extends JPanel {
	private Image_Resizer image;
	private JLabel name;
	private User_Template user;
	public UserBanner(User_Template user, int width, int height) {
		name = new JLabel(user.username);
		this.user = user;

		this.setSize(width, height);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		image = new Image_Resizer(new ImageIcon(user.image), (int) (height * 0.7), (int) (height * 0.7));
		this.add(image);
		this.add(name);
		this.setBackground(new Color(30,31,34));
		name.setFont(new Font("", Font.BOLD, (int) (height * 0.3)));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	public User_Template getUser() {
		return user;
	}
	public void setUser(User_Template user) {
		this.user = user;
	}
}
