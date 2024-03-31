package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;

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

    public task_select(Project_Template info){
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
        south_mar.add(end, new Constraints(1, 0, 1, 0, 22, new Insets(0, 0, 0, 0)));
        this.add(south_mar, BorderLayout.SOUTH);


        name.setFont(new Font("Sans", Font.BOLD, 18));
        this.add(desc, BorderLayout.CENTER);
        desc.setFont(new Font("Sans", Font.PLAIN, 14));
        this.setBorder(new CompoundBorder(new LineBorder(new Color(30,31,34)),
            new EmptyBorder(20, 20, 20, 20)));

        this.setVisible(true);
        this.setPreferredSize(new Dimension(750,200));
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(this)){
            new project_progressbar(info);
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
        pforname.setBackground(new Color(36,48,65,255));
        south_mar.setBackground(new Color(36,48,65,255));
        this.setBackground(new Color(36,48,65,255));
        this.setBorder(new CompoundBorder(new LineBorder (new Color(47,79,125,255)),
                new EmptyBorder(20, 20, 20, 20)));
        this.revalidate(); this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        pforname.setBackground(new Color(30,30,30,255));
        south_mar.setBackground(new Color(30,30,30,255));
        this.setBackground(new Color(30,30,30,255));
        this.setBorder(new CompoundBorder(new LineBorder(new Color(30,31,34)),
                new EmptyBorder(20, 20, 20, 20)));
        this.revalidate(); this.repaint();
    }
}