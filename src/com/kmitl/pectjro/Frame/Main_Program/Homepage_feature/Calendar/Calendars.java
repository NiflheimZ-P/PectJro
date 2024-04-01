package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Calendar;

import com.kmitl.pectjro.Frame.Templates.Project_Template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneOffset;
import java.util.*;

public class Calendars implements ActionListener {
    private JPanel frame;
    private JButton left, right, previousMonth, nextMonth;
    private JPanel pn, calendarPanel, p_left, p_right, changepanel, teadline;
    private Calendar cal;
    private JLabel label, monthLb, dayLabel, numberLabel, spaceLabel;
    private int month, year, daysInMonth, firstDayOfWeek;
    private String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private JTextArea ta;
    private ArrayList<Project_Template> pt;

    public JPanel getFrame() {
        return frame;
    }

    public Calendars() {
        frame = new JPanel();
        left = new JButton("<");
        right = new JButton(">");

        pn = new JPanel();
        pn.setLayout(new BorderLayout());
        p_left = new JPanel();
        p_right = new JPanel();
        label = new JLabel("Calendar");
        monthLb = new JLabel();

        previousMonth = new JButton("<<");
        nextMonth = new JButton(">>");

        previousMonth.addActionListener(this);
        nextMonth.addActionListener(this);

        p_left.add(label);
        p_right.add(previousMonth);
        p_right.add(nextMonth);
        pn.add(p_left, BorderLayout.WEST);
        pn.add(monthLb, BorderLayout.CENTER);
        pn.add(p_right, BorderLayout.EAST);

        cal = Calendar.getInstance();
        // Set the calendar to the first day of the current month
        cal.set(Calendar.DAY_OF_MONTH, 1);

        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        // 0 rows, 7 columns
        calendarPanel = new JPanel(new GridLayout(0, 7));

        frame.setLayout(new BorderLayout());
        frame.add(pn, BorderLayout.NORTH);
        frame.add(calendarPanel, BorderLayout.CENTER);

        // Set color and set border button
        left.setFont(new Font("Sans", Font.PLAIN, 12));
        right.setFont(new Font("Sans", Font.PLAIN, 12));
        label.setFont(new Font("Sans", Font.BOLD, 18));
        monthLb.setFont(new Font("Sans", Font.PLAIN, 18));
        pn.setBackground(new Color(49, 51, 56));
        p_left.setBackground(new Color(49, 51, 56));
        p_right.setBackground(new Color(49, 51, 56));
        calendarPanel.setBackground(new Color(43, 45, 49));

        label.setForeground(new Color(88, 101, 242));

        updateCalendar();

        frame.setSize(1000, 600);
        frame.setVisible(true);
    }

    private void updateCalendar() {
        calendarPanel.removeAll();

        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        cal.set(Calendar.DAY_OF_MONTH, 1);

        // Get the number of days in the month
        daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Get the day of the week for the first day of the month
        firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // Add weekday labels
        for (String weekday : weekdays) {
            dayLabel = new JLabel(weekday, SwingConstants.CENTER);
            dayLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            calendarPanel.add(dayLabel);

        }

        // Add empty labels for the days before the first day of the month
        for (int i = 1; i < firstDayOfWeek; i++) {
            spaceLabel = new JLabel("");
            spaceLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            calendarPanel.add(spaceLabel);

        }

        // Add JTextArea for each day of the month
        for (int day = 1; day <= daysInMonth; day++) {
            changepanel = new JPanel();
            numberLabel = new JLabel(Integer.toString(day));
            changepanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            changepanel.add(numberLabel);
            calendarPanel.add(changepanel, BorderLayout.NORTH);

//            if((LocalDate.of(year, month, day)).equals((LocalDate.of(year, month, 01)))){
//                changepanel.setBackground(Color.cyan);
//                changepanel = new JPanel();
//                numberLabel = new JLabel(Integer.toString(day));
//                changepanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//                changepanel.add(numberLabel);
//                calendarPanel.add(changepanel);
//            }



        }

        // Set the month label
        SimpleDateFormat sdf = new SimpleDateFormat("MM yyyy");
        monthLb.setText(sdf.format(cal.getTime()));

        // Repaint the calendar panel
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousMonth) {
            cal.add(Calendar.MONTH, -1);
            updateCalendar();
        } else if (e.getSource() == nextMonth) {
            cal.add(Calendar.MONTH, 1);
            updateCalendar();
        }
    }

    public static void main(String[] args) {
        new Calendars();
    }
}