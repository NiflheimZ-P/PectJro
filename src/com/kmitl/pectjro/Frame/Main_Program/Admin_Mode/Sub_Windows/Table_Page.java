package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import com.kmitl.pectjro.Frame.Tools.*;

public abstract class Table_Page extends JInternalFrame {
	private final JPanel north_panel;
	protected final JButton add_new, refresh, delete;
	protected JInfoGet search;
	protected final JTable table;
	protected DefaultTableModel model;
	protected final JScrollPane scroll;
	public Table_Page() {
		super("", true, true, false);
		this.setLayout(new BorderLayout());
		this.setFocusable(true);
		this.requestFocus();
		this.setSize(750, 450);

		add_new = new JButton("Add New");
		refresh = new JButton("Refresh");
		delete = new JButton("Delete");

		add_new.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/add_992651.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		refresh.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/refresh_2805355.png").getImage().getScaledInstance(15, 15, 1)));
		delete.setIcon(new ImageIcon(new ImageIcon("resources/Images/Icons/delete_3405244.png").getImage().getScaledInstance(15, 15, 1)));

		search = new JInfoGet("Search");
		search.setPreferredSize(new Dimension((int) (this.getWidth()*0.25), 27));

		north_panel = new JPanel(new GridBagLayout());
		north_panel.add(search, new Constraints(0, 0, 1, 0, 21, new Insets(10, 10, 0 ,0)));
		north_panel.add(refresh, new Constraints(1, 0, 1, 0, 22, new Insets(10, 0, 0, 20)));
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
	public abstract void addNew();
	public abstract void delete();
	public abstract void refresh();
}