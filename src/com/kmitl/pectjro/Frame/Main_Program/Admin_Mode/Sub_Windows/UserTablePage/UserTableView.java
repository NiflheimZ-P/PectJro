package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;

import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Table_Page;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class UserTableView extends Table_Page {
    // Attribute
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;

    // Constructor
    public UserTableView() {
        super();
        this.setTitle("User Data");
        String[] columns = {"Id", "Username", "Gmail", "Password", "Firstname", "Lastname", "Project_Done", "Project_Expired", "Project_Ontime", "Admin"};
        this.createTable(columns);
    }

    // Accessor
    public JTable getTable() {return this.table;}
    public DefaultTableModel getModel() {return this.model;}
    public JScrollPane getScroll() {return this.scroll;}

    // Methods
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
                    case 0, 6, 7, 8 -> Integer.class;
                    case 9 -> Boolean.class;
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
}


