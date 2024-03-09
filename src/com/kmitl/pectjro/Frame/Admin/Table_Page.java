package com.kmitl.pectjro.Frame.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.kmitl.pectjro.Frame.Tools.*;

public abstract class Table_Page extends JInternalFrame {
	private JPanel north_panel;
	protected JButton add_new, reflash, delete;
	public Table_Page() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		add_new = new JButton("Add New");
		ImageIcon icon = new ImageIcon("resources/Images/Icons/add_992651.png");
		//add_new.setIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

		north_panel = new JPanel(new GridBagLayout());
	}
}
