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
        super(1100, 500);
        this.setTitle("User Data");
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
                return (column == 5 || column == 6 || column == 7 || column == 8);
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0, 5, 6, 7 -> Integer.class;
                    case 8 -> Boolean.class;
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


