package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

public class Calendars {
    private JPanel frame;
    private JTable table;
    private JButton left, right, cancel;
    private JPanel pn;
    private DefaultTableModel model;
    private DefaultTableCellRenderer centerRenderer;
    private String[] columns = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private Object[][] data;
    private Calendar cal;
    private int month, year, daysInMonth, firstDayOfWeek, row, col;
    private JProgressBar jb;

    public Calendars() {
        // Add Button
        frame = new JPanel();
        left = new JButton("<");
        right = new JButton(">");
        cancel = new JButton("X");

        jb = new JProgressBar();
        jb.setStringPainted(true);
        // Add Button on Panel
        pn = new JPanel();


        pn.setLayout(new FlowLayout());
        pn.add(jb);
        pn.add(cancel);
        pn.add(left);
        pn.add(right);


        // Create a table model
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true; // Enable cell editing
            }
        };

        // Add columns to the model
        for (String column : columns) {
            model.addColumn(column);
        }

        // Create a calendar instance
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1); // Set the calendar to the first day of the current month

        // Get the current month and year
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        // Get the number of days in the month
        daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Get the day of the week for the first day of the month
        firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // Create the table with appropriate rows and columns
        data = new Object[6][7]; // 6 rows, 7 columns
        row = 0;
        col = firstDayOfWeek - 1;

        // Add data to the model
        for (int day = 1; day <= daysInMonth; day++) {
            cal.set(Calendar.DAY_OF_MONTH, day);
            int currentDay = cal.get(Calendar.DAY_OF_MONTH);
            int currentMonth = cal.get(Calendar.MONTH);

            // Check if the current day is in the current month
            if (currentMonth == month) {
                data[row][col] = currentDay; // Add day to cell
            } else {
                data[row][col] = ""; // Leave cells empty
            }

            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }

        // Add data to the model
        for (Object[] rowData : data) {
            model.addRow(rowData);
        }

        // Create the JTable with the model
        table = new JTable(model);
        table.setCellSelectionEnabled(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // Disable column reordering
        table.getTableHeader().setReorderingAllowed(false);


        // Set cell rendering alignment
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        // Set row height
        table.setRowHeight(150);

        // Add the table directly to the frame
        frame.add(pn, BorderLayout.NORTH);
        frame.add(table.getTableHeader(), BorderLayout.CENTER); // Add table header
        frame.add(table, BorderLayout.SOUTH); // Add table itself

        // Set frame size and make it visible
        frame.setSize(400, 600);
        frame.setVisible(true);
    }

    public JPanel getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        new Calendars();
    }
}
