package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Frame.Cache_Templates.User_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.Image_Resizer;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class UserEdit {
	// Attribute
	private JInternalFrame frame;
	private JPanel main_panel, south_panel;
	private JProgressBar percent;
	private Image_Resizer image;
	private JTextField first, last, username, pass, gmail;
	private JButton save, cancel;

	// Constructor
	public UserEdit(User_Template user) {
		frame = new JInternalFrame("User", true, true, false);
		main_panel = new JPanel(new GridBagLayout());
		frame.setSize(400, 550);

		image = new Image_Resizer(new ImageIcon(user.image), 130, 130);
		image.setBorder(new MatteBorder(1, 1, 1, 1, Color.gray));
		first = new JTextField(user.firstname, 13); first.setPreferredSize(new Dimension(50, 30));
		last = new JTextField(user.lastname, 13); last.setPreferredSize(new Dimension(50, 30));
		username = new JTextField(user.username, 13); username.setPreferredSize(new Dimension(50, 30));
		pass = new JTextField(user.password, 13); pass.setPreferredSize(new Dimension(50, 30));
		gmail = new JTextField(user.gmail, 29); gmail.setPreferredSize(new Dimension(50, 30));
		gmail.setEditable(false); gmail.setBackground(Color.white);
		gmail.setToolTipText("You can't edit this.");

		int allPercent;
		try { allPercent = ((user.project_ontime * 100) / user.project_done);} catch (ArithmeticException e) { allPercent = 0; }
		percent = new JProgressBar();
		percent.setPreferredSize(new Dimension(330, 40));
		percent.setValue(allPercent);
		percent.setForeground(new Color(0, 153, 0));

		main_panel.add(image, new Constraints(0, 0, 2, 1, 1, 1, new Insets(0, 0, 0, 0)));

		main_panel.add(new JLabel("Firstname"), new Constraints(0, 1, 1, 0, 21, new Insets(0, 0, 0, 0)));
		main_panel.add(first, new Constraints(0, 2, 1, 0, 21, new Insets(0, 0, 20, 0)));

		main_panel.add(new JLabel("Lastname"), new Constraints(1, 1, 1, 0, 21, new Insets(0, 0, 0, 0)));
		main_panel.add(last, new Constraints(1, 2, 1, 0, 21, new Insets(0, 0, 20, 0)));

		main_panel.add(new JLabel("Username"), new Constraints(0, 3, 1, 0, 21, new Insets(0, 0, 0, 0)));
		main_panel.add(username, new Constraints(0, 4, 1, 0, 21, new Insets(0, 0, 20, 0)));

		main_panel.add(new JLabel("Password"), new Constraints(1, 3, 1, 0, 21, new Insets(0, 0, 0, 0)));
		main_panel.add(pass, new Constraints(1, 4, 1, 0, 21, new Insets(0, 0, 20, 0)));

		main_panel.add(new JLabel("Gmail"), new Constraints(0, 5, 2, 1, 1, 0, 21, new Insets(0, 0, 0, 0)));
		main_panel.add(gmail, new Constraints(0, 6, 2, 1, 1, 0, 21, new Insets(0, 0, 20, 0)));

		main_panel.add(new JLabel("Punctuality rate"), new Constraints(0, 7, 2, 1, 1, 0, 21, new Insets(0, 0, 5, 0)));
		main_panel.add(percent, new Constraints(0, 8, 2, 1, 1, 0, 21, new Insets(0, 0, 20, 0)));

		main_panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

		south_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		save = new JButton("Save"); cancel = new JButton("Cancel");
		south_panel.add(cancel);
		south_panel.add(save);
		main_panel.add(south_panel, new Constraints(0, 9, 2, 1, 1, 0, 22, new Insets(0, 0, 20, 0)));

		frame.add(main_panel);
		frame.setVisible(true);
	}

	// Accessor
	public JInternalFrame getFrame() {
		return frame;
	}
	public Image_Resizer getImage() {
		return image;
	}
	public JTextField getFirst() {
		return first;
	}
	public JTextField getLast() {
		return last;
	}
	public JTextField getUsername() {
		return username;
	}
	public JTextField getPass() {
		return pass;
	}
	public JTextField getGmail() {
		return gmail;
	}
}
