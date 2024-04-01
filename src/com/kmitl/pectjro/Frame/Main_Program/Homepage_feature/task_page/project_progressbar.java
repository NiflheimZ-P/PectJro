package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.StepTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature.AllNoteController;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.feedback;
import com.kmitl.pectjro.Frame.Templates.Project_Template;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.Serializable;
import java.sql.Connection;
import java.time.ZoneOffset;
import java.sql.Date;
import java.util.LinkedList;

import com.kmitl.pectjro.Frame.Templates.Step_Template;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class project_progressbar extends JFrame implements ActionListener, Serializable {
    private JFrame fr;
    private JPanel upper_pmain, upper_west, upper_west_rpart, pane_for_note, panefor_close, logo_lmar, mini_west_rpart, mid_mar_rpart, psouth_main, psouth_move, psouth_add, psouth_midmar, note_bn;
    private JLabel pro_name_label;
    private JButton close_bn, add_bn, bn_finish, bn_add_mem, del_bn;
    private NewTaskGanttChart newtgc;
    private static final long serialVersionUID = 1L;
    private Project_Template info;
    private ChartPanel chartPanel;
    private TaskSeriesCollection dataset;
    private TaskSeries expected;
    private LinkedList<Step_Template> allStep;
    private DeleteTask delt;
    private TaskController controller;
    public project_progressbar(Project_Template info, TaskController controller){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.info = info;
        this.controller = controller;

        //Label
        //pro_pic = new JLabel("Project pic");
        pro_name_label = new JLabel(info.name);

        //button

        close_bn = new JButton("Note");
        add_bn = new JButton("+");
        del_bn = new JButton("-");
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
        upper_west_rpart.setLayout(new GridLayout());
        pane_for_note.setLayout(new FlowLayout(2, 40,60));
        panefor_close.setLayout(new FlowLayout(2,10,10));

        //upper_west side
        upper_west.add(logo_lmar, BorderLayout.WEST);
        logo_lmar.setPreferredSize(new Dimension(70,100));
//        upper_west.add(pro_pic, BorderLayout.CENTER);
        upper_west.add(upper_west_rpart, BorderLayout.CENTER);

        //uppper west rpart add
        upper_west_rpart.add(pro_name_label);
        pro_name_label.setFont(new Font("Sans", Font.BOLD, 40));

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
        psouth_add.add(del_bn);
        del_bn.setFont(new Font("Sans", Font.PLAIN, 14));

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
        del_bn.setBackground(new Color(43,45,49));
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
        del_bn.addActionListener(this);


        //set fr
        fr.add(upper_pmain, BorderLayout.NORTH);
        fr.add(psouth_main, BorderLayout.SOUTH);
        fr.setResizable(false);
        fr.setSize(1000, 600);
        fr.setLocationRelativeTo(controller.getHead_control().getMain_controller().getView().getFrame());

        JFreeChart chart = ChartFactory.createGanttChart("", "Task", "Time", createDataset(),
                true, true, true);

        // เพิ่ม chart เข้า chart panel
        chartPanel = new ChartPanel(chart);

        // setting size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        StandardChartTheme theme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();
        theme.setRegularFont(new Font("Sans", Font.BOLD, 12));

        theme.setChartBackgroundPaint(new Color(43,45,49));
        theme.setPlotBackgroundPaint(new Color(49, 51, 56));
        theme.setPlotOutlinePaint(new Color(88,101,242));
        theme.setLegendBackgroundPaint(new Color(43, 45, 49));
        theme.setLegendItemPaint(Color.white);
        theme.setAxisLabelPaint(Color.white);
        theme.setTickLabelPaint(Color.white);
        theme.setLabelLinkPaint(Color.white);
        theme.setShadowPaint(Color.DARK_GRAY);
        theme.setRangeGridlinePaint(Color.white);
        theme.setTitlePaint(new Color(88,101,242));

        theme.setBarPainter(new StandardBarPainter());

        BarRenderer rend = (BarRenderer) chart.getCategoryPlot().getRenderer();
        rend.setShadowVisible(true);
        rend.setShadowXOffset(2);
        rend.setShadowYOffset(0);
        rend.setShadowPaint(Color.decode( "#C0C0C0"));
        rend.setMaximumBarWidth(0.1);

        theme.apply(chart);

        // add
        fr.add(chartPanel, BorderLayout.CENTER);
    }

    private IntervalCategoryDataset createDataset() {

        dataset = new TaskSeriesCollection();
        expected = new TaskSeries("Expected Date");

        dataset.add(expected);

        return dataset;
    }

    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(add_bn)){
            if (newtgc == null) {
                newtgc = new NewTaskGanttChart(fr, this, allStep);
                newtgc.getB_create().addActionListener(this);
                newtgc.getB_back().addActionListener(this);
            } else {
                newtgc.getFr().toFront();
            }
        }
        else if(ev.getSource().equals(bn_add_mem)){
            Addpeople add = new Addpeople(info, fr);
            add.loadAllUser();
        }else if(ev.getSource().equals(bn_finish)){
            new feedback(fr, controller, info);
            fr.dispose();
        }else if (ev.getSource().equals((close_bn))){
            AllNoteController allnote = new AllNoteController(info, fr);
            allnote.loadNote(true);
        }else if (ev.getSource().equals(del_bn)){
            if (delt == null){
                delt = new DeleteTask(info, this);
                delt.getCon().addActionListener(this);
                delt.getCancel().addActionListener(this);
                try {
                    delt.loadStep();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                delt.addToCombobox();
            } else {
                delt.getFr().toFront();
            }
        }else if (ev.getActionCommand().equals("Create")){
            SwingWorker<Void, Void> add = new SwingWorker<Void, Void>() {
                private final Loading_dialog load = new Loading_dialog(fr);
                @Override
                protected Void doInBackground() throws Exception {
                    load.setVisible(true);
                    Connection con = DBConnect.createConnect();
                    StepTable step = new StepTable(con);

                    Step_Template newOne = new Step_Template();
                    newOne.owner_id = info.id;
                    newOne.step_name = newtgc.getProjectname().getText();
                    newOne.start = Date.valueOf(newtgc.getD1().getDate());
                    newOne.end = Date.valueOf(newtgc.getD2().getDate());

                    step.addStep(newOne);
                    allStep = step.getAllStep(info.id);
                    return null;
                }

                @Override
                protected void done() {
                    expected.add(new Task(newtgc.getProjectname().getText(), Date.from(newtgc.getD1().getDate().atStartOfDay().toInstant(ZoneOffset.ofHours(+7))), Date.from(newtgc.getD2().getDate().atStartOfDay().toInstant(ZoneOffset.ofHours(+7)))));

                    newtgc.getFr().dispose();
                    load.dispose();
                }
            };
            add.execute();

        }else if (ev.getActionCommand().equals("Confirm")){
            SwingWorker<Void, Void> delete = new SwingWorker<Void, Void>() {
                private final Loading_dialog load = new Loading_dialog(fr);
                @Override
                protected Void doInBackground() throws Exception {
                    load.setVisible(true);
                    Step_Template check = new Step_Template();
                    for (int i = 0; i < allStep.size(); i++){
                        if (allStep.get(i).step_name.contains(String.valueOf(delt.getTasksel().getSelectedItem()))){
                            check = allStep.get(i);
                        }
                    }
                    expected.remove(new Task(check.step_name, Date.from(check.start.toLocalDate().atStartOfDay().toInstant(ZoneOffset.ofHours(+7))), Date.from(check.end.toLocalDate().atStartOfDay().toInstant(ZoneOffset.ofHours(+7)))));

                    Connection con = DBConnect.createConnect();
                    StepTable step = new StepTable(con);
                    step.deleteStep(check.id);

                    return null;
                }

                @Override
                protected void done() {
                    delt.getTasksel().removeItem(String.valueOf(delt.getTasksel().getSelectedItem()));
                    delt.getFr().dispose();
                    fr.revalidate();
                    fr.repaint();

                    load.dispose();
                }
            };
            delete.execute();
        }else if (ev.getActionCommand().equals("Cancel")){
            delt.getFr().dispose();
        }else if (ev.getActionCommand().equals("Back")){
            newtgc.getFr().dispose();
        }
    }

    public void loadStep() throws Exception {
        Connection con = DBConnect.createConnect();
        StepTable step = new StepTable(con);
        allStep = step.getAllStep(info.id);
    }

    public void setUpChart() {
        for (Step_Template i: allStep) {
            expected.add(new Task(i.step_name, Date.from(i.start.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC)), Date.from(i.end.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC))));
        }
    }

    // Accessor
    public JFrame getFr() {
        return fr;
    }
    public void setFr(JFrame fr) {
        this.fr = fr;
    }
    public NewTaskGanttChart getNewtgc() {
        return newtgc;
    }
    public void setNewtgc(NewTaskGanttChart newtgc) {
        this.newtgc = newtgc;
    }
    public DeleteTask getDelt() {
        return delt;
    }
    public void setDelt(DeleteTask delt) {
        this.delt = delt;
    }
    public ChartPanel getChartPanel() {
        return chartPanel;
    }
    public void setChartPanel(ChartPanel chartPanel) {
        this.chartPanel = chartPanel;
    }
}
