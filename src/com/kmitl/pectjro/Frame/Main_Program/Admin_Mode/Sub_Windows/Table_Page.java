package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import com.kmitl.pectjro.Frame.Tools.*;

public abstract class Table_Page extends JInternalFrame {
	private final JPanel north_panel;
	protected final JButton add_new, refresh, delete, view;
	protected JInfoGet search;
	protected DefaultTableModel model;
	public Table_Page(int width, int height) {
		super("", true, true, false);
		this.setLayout(new BorderLayout());
		this.setFocusable(true);
		this.requestFocus();
		this.setSize(width, height);

		add_new = new JButton("Add New");
		refresh = new JButton("Refresh"); refresh.setEnabled(false);
		delete = new JButton("Delete");
		view = new JButton("View");

		add_new.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/add_992651.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		refresh.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/refresh_2805355.png").getImage().getScaledInstance(15, 15, 1)));
		delete.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/delete_3405244.png").getImage().getScaledInstance(15, 15, 1)));

		search = new JInfoGet("Search");
		search.setPreferredSize(new Dimension((int) (this.getWidth()*0.25), 27));

		north_panel = new JPanel(new GridBagLayout());
		north_panel.add(search, new Constraints(0, 0, 1, 0, 21, new Insets(10, 10, 0 ,0)));
		north_panel.add(refresh, new Constraints(1, 0, 1, 0, 22, new Insets(10, 0, 0, 5)));
		north_panel.add(view, new Constraints(2, 0, 0, 0, 22, new Insets(10, 0, 0, 20)));
		north_panel.add(add_new, new Constraints(3, 0, 0, 0, 22, new Insets(10, 0, 0, 5)));
		north_panel.add(delete, new Constraints(4, 0, 0, 0, 22, new Insets(10, 0, 0, 10)));
		this.add(north_panel, BorderLayout.NORTH);
	}

	public JButton getDelete() {
		return delete;
	}

	public JButton getAdd_new() {
		return add_new;
	}

	public JButton getRefresh() {
		return refresh;
	}
	public JInfoGet getSearch() {
		return search;
	}
	public JButton getView() {
		return view;
	}

	public abstract void createTable(String[] columns);
}
