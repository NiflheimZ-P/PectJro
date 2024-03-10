package com.kmitl.pectjro.Frame.Admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import com.kmitl.pectjro.Frame.Tools.*;

public abstract class Table_Page extends JInternalFrame {
	private JPanel north_panel;
	protected JButton add_new, reflash, delete;
	protected JInfoGet search;
	protected JTable table;
	protected DefaultTableModel model;
	protected JScrollPane scroll;
	public Table_Page() {
		super("", true, true, false);
		this.setLayout(new BorderLayout());
		this.setFocusable(true);
		this.requestFocus();

		add_new = new JButton("Add New");
		reflash = new JButton("Reflash");
		delete = new JButton("Delete");

		add_new.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/add_992651.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		reflash.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/refresh_2805355.png").getImage().getScaledInstance(15, 15, 1)));
		delete.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/delete_3405244.png").getImage().getScaledInstance(15, 15, 1)));

		search = new JInfoGet("Search");
		search.setPreferredSize(new Dimension((int) (this.getWidth()*0.25), 27));

		north_panel = new JPanel(new GridBagLayout());
		north_panel.add(search, new Constraints(0, 0, 1, 0, 21, new Insets(10, 10, 0 ,0)));
		north_panel.add(reflash, new Constraints(1, 0, 1, 0, 22, new Insets(10, 0, 0, 20)));
		north_panel.add(add_new, new Constraints(2, 0, 0, 0, 22, new Insets(10, 0, 0, 10)));
		north_panel.add(delete, new Constraints(3, 0, 0, 0, 22, new Insets(10, 0, 0, 10)));
		this.add(north_panel, BorderLayout.NORTH);

		table = new JTable();
		scroll = new JScrollPane();
		model = (DefaultTableModel) table.getModel();
		scroll.setViewportView(table);
		scroll.setBorder(new EmptyBorder(15, 10, 10, 10));

		this.add(scroll);
	}

}
