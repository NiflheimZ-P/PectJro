package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature.AllNote;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.Addpeople;
import com.kmitl.pectjro.Frame.Templates.Project_Template;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class project_progressbar extends JFrame implements ActionListener {
    private JFrame fr;
    private JPanel upper_pmain, upper_west, upper_west_rpart, pane_for_note, panefor_close, logo_lmar, mini_west_rpart, mid_mar_rpart, psouth_main, psouth_move, psouth_add, psouth_midmar, note_bn;
    private JLabel pro_pic, team_label, pro_name_label;
    private JButton close_bn, add_bn, lmove_arrow, bn_finish, bn_add_mem;
    private NewTaskGanttChart newtgc;
    private static final long serialVersionUID = 1L;
    private Project_Template info;
    public project_progressbar(String applicationTitle, String chartTitle, Project_Template info){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.info = info;

        //Label
        //pro_pic = new JLabel("Project pic");
        team_label = new JLabel("Member: ");
        pro_name_label = new JLabel("Project Name");

        //button

        close_bn = new JButton("Note");
        add_bn = new JButton("+");
        //lmove_arrow = new JButton("<");
        bn_finish = new JButton("Finish!");
        bn_add_mem = new JButton("Add Member");

        //panel
        note_bn = new JPanel();
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
        logo_lmar.setPreferredSize(new Dimension(70,100));
//        upper_west.add(pro_pic, BorderLayout.CENTER);
        upper_west.add(upper_west_rpart, BorderLayout.CENTER);

        //uppper west rpart add
        mini_west_rpart.setLayout(new GridLayout(3,1,50,5));
        mini_west_rpart.add(pro_name_label);
        pro_name_label.setFont(new Font("Sans", Font.BOLD, 26));
        mini_west_rpart.add(mid_mar_rpart);
        mini_west_rpart.add(team_label);
        team_label.setFont(new Font("Sans", Font.PLAIN, 18));
        upper_west_rpart.add(mini_west_rpart, BorderLayout.CENTER);

        //upper part
        upper_pmain = new JPanel();
        upper_pmain.setLayout(new GridLayout(1,3));
        upper_pmain.add(upper_west);
        pane_for_note.add(note_bn);
        upper_pmain.add(pane_for_note);
        panefor_close.add(bn_add_mem);
        bn_add_mem.setBorder(BorderFactory.createEmptyBorder());
        bn_add_mem.setPreferredSize(new Dimension(110, 45));
        panefor_close.add(close_bn);
        close_bn.setBorder(BorderFactory.createEmptyBorder());
        close_bn.setFont(new Font("Sans", Font.PLAIN, 16));
        close_bn.setPreferredSize(new Dimension(70, 45));
        upper_pmain.add(panefor_close);
        upper_pmain.setPreferredSize(new Dimension(1000, 100));

        //south part
        psouth_main = new JPanel();
        psouth_add.add(add_bn);
        add_bn.setFont(new Font("Sans", Font.PLAIN, 14));

        //psouth_move add
        // psouth_move.add(lmove_arrow);
        // lmove_arrow.setFont(new Font("Sans", Font.PLAIN, 14));
        psouth_move.add(bn_finish);
        bn_finish.setFont(new Font("Sans", Font.PLAIN, 14));

        // psouth_main add
        psouth_main.add(psouth_add);
        psouth_main.add(psouth_midmar);
        psouth_main.add(psouth_move);

        //south part setting
        psouth_main.setLayout(new GridLayout(1,3));
        psouth_move.setLayout(new FlowLayout(2));
        psouth_add.setLayout(new FlowLayout(0));

        //set color
        upper_pmain.setBackground(new Color(30,31,34));
        upper_west.setBackground(new Color(30,31,34));
        upper_west_rpart.setBackground(new Color(30,31,34));
        pane_for_note.setBackground(new Color(30,31,34));
        panefor_close.setBackground(new Color(30,31,34));
        logo_lmar.setBackground(new Color(30,31,34));
        mini_west_rpart.setBackground(new Color(30,31,34));
        mid_mar_rpart.setBackground(new Color(30,31,34));
        psouth_main.setBackground(new Color(30,31,34));
        psouth_move.setBackground(new Color(30,31,34));
        psouth_add.setBackground(new Color(30,31,34));
        psouth_midmar.setBackground(new Color(30,31,34));
        note_bn.setBackground(new Color(30,31,34));
        add_bn.setBackground(new Color(43,45,49));
        //lmove_arrow.setBackground(new Color(43,45,49));
        bn_add_mem.setBackground(new Color(43, 45, 49));
        bn_finish.setBackground(new Color(43,45,49));
        close_bn.setBackground(new Color(43,45,49));
        pro_name_label.setForeground(new Color(88,101,242));


        //addActionListener
        add_bn.addActionListener(this);
        bn_add_mem.addActionListener(this);
        close_bn.addActionListener(this);
        bn_finish.addActionListener(this);


        //set fr
        fr.add(upper_pmain, BorderLayout.NORTH);
        fr.add(psouth_main, BorderLayout.SOUTH);
        fr.setLocationRelativeTo(null);
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
        expected.add(new Task("Analysis", Date.from(info.start.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC)), Date.from(info.end.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC))));

        expected.add(new Task("Design", Date.from(info.start.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC)), Date.from(info.end.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC))));

        expected.add(new Task("Development", Date.from(info.start.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC)), Date.from(info.end.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC))));

        expected.add(new Task("Testing", Date.from(info.start.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC)), Date.from(info.end.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC))));

        dataset.add(expected);

//        for (RecipeDates data : recipeDateList){
//            TaskSeries taskSeries = new TaskSeries(dates.name);
//            dataset<>
//        }

        return dataset;
    }
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(add_bn)){
            newtgc = new NewTaskGanttChart();
            newtgc.getB_create().addActionListener(this);
        }
        else if(ev.getSource().equals(bn_add_mem)){
            new Addpeople();
        } else if(ev.getSource().equals(bn_finish)){
            new feedback();
            fr.dispose();
        }else if (ev.getSource().equals((close_bn))){
            new AllNote();
        }else if (ev.getSource().equals(newtgc.getB_create())){
            CreateExpectedTask(newtgc.getProjectname().getText());
        }
    }

    public void CreateExpectedTask(String task){

    }
}