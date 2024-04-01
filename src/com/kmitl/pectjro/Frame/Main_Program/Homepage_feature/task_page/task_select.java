package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Main;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class task_select extends JPanel implements MouseListener {
    private JPanel pforname, south_mar;
    private JLabel name, desc, start, end;
    private Project_Template info;
    private TaskController controller;
    private project_progressbar newone;

    public task_select(Project_Template info, TaskController controller){
        this.controller = controller;
        pforname =  new JPanel();
        south_mar = new JPanel();
        this.info = info;

        //Label
        name = new JLabel(info.name);
        desc = new JLabel(info.description);
        start = new JLabel("Start : "+ info.start.toString());
        end = new JLabel("End :  "+ info.end.toString());

        this.setLayout(new BorderLayout());
        pforname.add(name);
        this.add(pforname, BorderLayout.NORTH);

        //add to pforname
        south_mar.setLayout(new GridBagLayout());
        south_mar.add(start, new Constraints(0, 0, 1, 0, 21, new Insets(0, 0, 0, 0)));
        start.setForeground(Color.white);
        south_mar.add(end, new Constraints(1, 0, 1, 0, 22, new Insets(0, 0, 0, 0)));
        end.setForeground(Color.white);
        this.add(south_mar, BorderLayout.SOUTH);


        name.setFont(new Font("Sans", Font.BOLD, 26));
        name.setForeground(new Color(88,101,242));
        this.add(desc, BorderLayout.CENTER);
        desc.setFont(new Font("Sans", Font.PLAIN, 14));
        desc.setForeground(Color.white);
        this.setBorder(new CompoundBorder(new LineBorder(new Color(30,31,34)),
            new EmptyBorder(20, 20, 20, 20)));

        this.setVisible(true);
        this.setPreferredSize(new Dimension(750,200));
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(this)){
            SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    MainController.glassPane.setVisible(true);
                    MainController.glassPane.setLoading(true);

                    newone = new project_progressbar(info, controller);
                    newone.loadStep();
                    newone.setUpChart();
                    return null;
                }

                @Override
                protected void done(){
                    newone.getFr().setVisible(true);

                    MainController.glassPane.setVisible(false);
                    MainController.glassPane.setLoading(false);
                }
            };
            load.execute();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        name.setForeground(Color.white);
        desc.setForeground(Color.black);
        start.setForeground(Color.black);
        end.setForeground(Color.black);
        pforname.setBackground(new Color(88,101,242,255));
        south_mar.setBackground(new Color(88,101,242,255));
        this.setBackground(new Color(88,101,242,255));
        this.setBorder(new CompoundBorder(new LineBorder (new Color(88,101,242,255)),
                new EmptyBorder(20, 20, 20, 20)));
        this.revalidate(); this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        name.setForeground(new Color(88,101,242));
        desc.setForeground(Color.white);
        start.setForeground(Color.white);
        end.setForeground(Color.white);
        pforname.setBackground(new Color(30,30,30,255));
        south_mar.setBackground(new Color(30,30,30,255));
        this.setBackground(new Color(30,30,30,255));
        this.setBorder(new CompoundBorder(new LineBorder(new Color(30,31,34)),
                new EmptyBorder(20, 20, 20, 20)));
        this.revalidate(); this.repaint();
    }
}