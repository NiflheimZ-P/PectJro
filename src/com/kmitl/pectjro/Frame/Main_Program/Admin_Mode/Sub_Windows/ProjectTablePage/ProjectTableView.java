package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Table_Page;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ProjectTableView extends Table_Page {
	// Attribute
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;

	// Constructor
	public ProjectTableView() {
		super(700, 500);
		this.setTitle("Project Data");
		String[] columns = {"Id", "Name", "Description", "Start", "End"};
		this.createTable(columns);
		view.setText("Edit");
	}

	// Listener
	@Override
	public void createTable(String[] columns) {
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return switch (columnIndex) {
					case 0 -> Integer.class;
					default -> String.class;
				};
			}
		};
		scroll = new JScrollPane();
		model = (DefaultTableModel) table.getModel();

		for (String name : columns) {
			model.addColumn(name);
		}

		table.getColumnModel().getColumn(2).setPreferredWidth(200);

		scroll.setViewportView(table);
		scroll.setBorder(new EmptyBorder(15, 10, 10, 10));
		this.add(scroll);
	}

	// Accessor
	public JTable getTable() {return this.table;}
	public DefaultTableModel getModel() {return this.model;}
	public JScrollPane getScroll() {return this.scroll;}
}
