package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Calendars implements ActionListener {
    private JFrame frame;
    private JButton left, right, previousMonth, nextMonth;
    private JPanel pn, calendarPanel, p_left, p_right;
    private Calendar cal;
    private JLabel label;
    private int month, year, daysInMonth, firstDayOfWeek;

    public Calendars() {
        // Add Button
        frame = new JFrame();
        left = new JButton("<");
        right = new JButton(">");
        // Add Button on Panel
        pn = new JPanel();
        pn.setLayout(new BorderLayout());
        p_left = new JPanel();
        p_right = new JPanel();
        label = new JLabel("Deadline Calendar");

        // Add Button on Panel for changing months
        previousMonth = new JButton("<<");
        nextMonth = new JButton(">>");

        // Add Action Listeners for changing months
        previousMonth.addActionListener(this);
        nextMonth.addActionListener(this);

        // Add buttons to the panel
        p_left.add(label);
        pn.add(p_left, BorderLayout.WEST);
        p_right.add(previousMonth);
        p_right.add(nextMonth);
        pn.add(p_right, BorderLayout.EAST);

        // Create a calendar instance
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1); // Set the calendar to the first day of the current month

        // Get the current month and year
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        // Create the panel with GridLayout
        calendarPanel = new JPanel(new GridLayout(0, 7)); // 0 rows, 7 columns

        // Add the calendar panel to the frame
        frame.setLayout(new BorderLayout());
        frame.add(pn, BorderLayout.NORTH);
        frame.add(calendarPanel, BorderLayout.CENTER);


        // Set color and set border button
        left.setFont(new Font("Sans", Font.PLAIN, 12));
        right.setFont(new Font("Sans", Font.PLAIN, 12));
        label.setFont(new Font("Sans", Font.PLAIN, 18));
        pn.setBackground(new Color(49, 51, 56));
        p_left.setBackground(new Color(49, 51, 56));
        p_right.setBackground(new Color(49, 51, 56));
        calendarPanel.setBackground(new Color(43, 45, 49));

        // Display the calendar
        updateCalendar();

        frame.setSize(1000, 600);
        frame.setVisible(true);
    }

    private void updateCalendar() {
        // Clear existing calendar panel
        calendarPanel.removeAll();

        // Update calendar instance
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        // Set the calendar to the first day of the month
        cal.set(Calendar.DAY_OF_MONTH, 1);

        // Get the number of days in the month
        daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Get the day of the week for the first day of the month
        firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // Add weekday labels
        String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String weekday : weekdays) {
            JLabel dayLabel = new JLabel(weekday, SwingConstants.CENTER);
            calendarPanel.add(dayLabel);
        }

        // Add empty buttons for the days before the first day of the month
        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        // Add buttons for each day of the month
        for (int day = 1; day <= daysInMonth; day++) {
            JButton button = new JButton(Integer.toString(day));
            calendarPanel.add(button);
        }

        // Repaint the calendar panel
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousMonth) {
            cal.add(Calendar.MONTH, -1); // Move to previous month
            updateCalendar(); // Update calendar display
        } else if (e.getSource() == nextMonth) {
            cal.add(Calendar.MONTH, 1); // Move to next month
            updateCalendar(); // Update calendar display
        }
    }

   //public JPanel getFrame() {
        //return frame;
    public static void main(String[] args) {
        new Calendars();
    }
}
