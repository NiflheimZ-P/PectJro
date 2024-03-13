package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import java.awt.*;
import javax.swing.*;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class project_progressbar extends JFrame{
    private JFrame fr;
    private JPanel upper_pmain, upper_west, upper_west_rpart, pane_for_note, panefor_close, logo_lmar, mini_west_rpart, mid_mar_rpart, psouth_main, psouth_move, psouth_add, psouth_midmar;
    private JLabel pro_pic, team_label, pro_name_label;
    private JButton note_bn, close_bn, add_bn, lmove_arrow, rmove_arrow;
    private static final long serialVersionUID = 1L;
    public project_progressbar(String applicationTitle, String chartTitle){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Label
        pro_pic = new JLabel("Project pic");
        team_label = new JLabel("Team: ");
        pro_name_label = new JLabel("Project Name");

        //button
        note_bn = new JButton("Note");
        close_bn = new JButton("X");
        add_bn = new JButton("+");
        lmove_arrow = new JButton("<");
        rmove_arrow = new JButton(">");

        //panel
        upper_west_rpart = new JPanel();
        mid_mar_rpart = new JPanel();
        mini_west_rpart = new JPanel();
        upper_west = new JPanel();
        pane_for_note = new JPanel();
        panefor_close = new JPanel();
        logo_lmar = new JPanel();
        psouth_add = new JPanel();
        psouth_midmar = new JPanel();
        psouth_move = new JPanel();
        upper_west.setLayout(new BorderLayout());
        upper_west_rpart.setLayout(new BorderLayout());
        pane_for_note.setLayout(new FlowLayout(2, 40,60));
        panefor_close.setLayout(new FlowLayout(2,10,10));

        //upper_west side
        upper_west.add(logo_lmar, BorderLayout.WEST);
        logo_lmar.setBackground(Color.lightGray);
        logo_lmar.setPreferredSize(new Dimension(70,100));
        upper_west.add(pro_pic, BorderLayout.CENTER);
        upper_west.add(upper_west_rpart, BorderLayout.EAST);
        upper_west.setBackground(Color.lightGray);

        //uppper west rpart add
        mini_west_rpart.setLayout(new GridLayout(3,1,50,5));
        mini_west_rpart.add(pro_name_label);
        mini_west_rpart.add(mid_mar_rpart);
        mini_west_rpart.add(team_label);
        mid_mar_rpart.setBackground(Color.lightGray);
        mini_west_rpart.setBackground(Color.lightGray);
        upper_west_rpart.add(mini_west_rpart, BorderLayout.CENTER);
        upper_west_rpart.setBackground(Color.lightGray);

        //upper part
        upper_pmain = new JPanel();
        upper_pmain.setLayout(new GridLayout(1,3));
        upper_pmain.setBackground(Color.lightGray);
        upper_pmain.add(upper_west);
        pane_for_note.add(note_bn);
        pane_for_note.setBackground(Color.lightGray);
        upper_pmain.add(pane_for_note);
        panefor_close.add(close_bn);
        panefor_close.setBackground(Color.lightGray);
        upper_pmain.add(panefor_close);
        upper_pmain.setPreferredSize(new Dimension(1000, 100));

        //south part
        psouth_main = new JPanel();
        psouth_add.add(add_bn);

        //psouth_move add
        psouth_move.add(lmove_arrow);
        psouth_move.add(rmove_arrow);

        // psouth_main add
        psouth_main.add(psouth_add);
        psouth_main.add(psouth_midmar);
        psouth_main.add(psouth_move);

        //south part setting
        psouth_main.setLayout(new GridLayout(1,3));
        psouth_move.setLayout(new FlowLayout(2));
        psouth_add.setLayout(new FlowLayout(0));
        psouth_main.setBackground(Color.lightGray);
        psouth_add.setBackground(Color.lightGray);
        psouth_midmar.setBackground(Color.lightGray);
        psouth_move.setBackground(Color.lightGray);


        //set fr
        fr.add(upper_pmain, BorderLayout.NORTH);
        fr.add(psouth_main, BorderLayout.SOUTH);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setSize(1000, 600);


        JFreeChart chart = ChartFactory.createGanttChart(chartTitle, "Development", "Time", createDataset(),
                true, true, true);

        // เพิ่ม chart เข้า chart panel
        ChartPanel chartPanel = new ChartPanel(chart);

        // setting size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 100));

        // add
        fr.add(chartPanel, BorderLayout.CENTER);
    }
    private IntervalCategoryDataset createDataset() {

        TaskSeriesCollection dataset = new TaskSeriesCollection();
        TaskSeries expected = new TaskSeries("Expected Date");
        expected.add(new Task("Analysis", Date.from(LocalDate.of(2018, 9, 5).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2018, 9, 8).atStartOfDay().toInstant(ZoneOffset.UTC))));

        expected.add(new Task("Design", Date.from(LocalDate.of(2018, 9, 12).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2018, 9, 16).atStartOfDay().toInstant(ZoneOffset.UTC))));

        expected.add(
                new Task("Development", Date.from(LocalDate.of(2018, 9, 19).atStartOfDay().toInstant(ZoneOffset.UTC)),
                        Date.from(LocalDate.of(2018, 9, 23).atStartOfDay().toInstant(ZoneOffset.UTC))));

        expected.add(new Task("Testing", Date.from(LocalDate.of(2018, 9, 26).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2018, 9, 29).atStartOfDay().toInstant(ZoneOffset.UTC))));

        dataset.add(expected);

        TaskSeries actual = new TaskSeries("Actual Date");
        actual.add(
                new Task("Analysis", Date.from(LocalDate.of(2018, 9, 5).atStartOfDay().toInstant(ZoneOffset.UTC)),
                        Date.from(LocalDate.of(2018, 9, 7).atStartOfDay().toInstant(ZoneOffset.UTC))));

        actual.add(new Task("Design", Date.from(LocalDate.of(2018, 9, 8).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2018, 9, 19).atStartOfDay().toInstant(ZoneOffset.UTC))));

        actual.add(new Task("Development", Date.from(LocalDate.of(2018, 9, 20).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2018, 9, 28).atStartOfDay().toInstant(ZoneOffset.UTC))));

        actual.add(new Task("Testing", Date.from(LocalDate.of(2018, 9, 28).atStartOfDay().toInstant(ZoneOffset.UTC)),
                Date.from(LocalDate.of(2018, 10, 3).atStartOfDay().toInstant(ZoneOffset.UTC))));
        dataset.add(actual);


        return dataset;

    }
    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SwingUtilities.invokeLater(() -> {new project_progressbar("Gnatt Chart", "Your Task Progress");
        });

    }
}
