package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile.Profile;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.ProjectCreate;
import com.kmitl.pectjro.Frame.Tools.Constraints;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Task implements ActionListener {
    private JPanel fr, p, margin_p,pl, pl_but;
    private JButton ref, create_pro;
    private JScrollPane scroll;
    public JPanel getFrame() {
        return fr;
    }


    public Task(){
        fr = new JPanel(); pl_but= new JPanel(new GridBagLayout());
        ref = new JButton("Refresh"); create_pro = new JButton("+");
        //ref.setEnabled(false);
        pl = new JPanel();
        p = new JPanel();
        margin_p = new JPanel();
        fr.setLayout(new BorderLayout(20, 20));


        pl.setLayout(new GridLayout(10,1));
        for (int i = 0; i < 10; i++){
            pl.add(new task_select());
        }
        fr.add(pl);

        pl.setMaximumSize(pl.getPreferredSize() );

        ///scroll
        scroll = new JScrollPane(pl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(10);

        javax.swing.SwingUtilities.invokeLater(() -> scroll.getVerticalScrollBar().setValue(0));
        scroll.setAutoscrolls(false);
        fr.add(scroll);


        ////but
        create_pro.setLocation(20,20);
        fr.add(pl_but, BorderLayout.SOUTH);
        create_pro.setPreferredSize(new Dimension(40,40));
        create_pro.setForeground(Color.white) ; create_pro.setBackground(new Color(43,45,49));
        create_pro.setFont(new Font("Sans", Font.PLAIN,24));
        pl_but.setBackground(new Color(49,51,56));
        pl_but.add(ref, new Constraints(0,0,1,1,21, new Insets(0,10,0,0)));
        pl_but.add(create_pro, new Constraints(1,0,1,1,22, new Insets(10,0,10,10)));
        ref.setBackground(new Color(43,45,49));
        ref.setForeground(Color.white);
        fr.setBackground(new Color(49,51,56));
        create_pro.addActionListener(this);


        fr.add(p, BorderLayout.WEST);

        p.setBackground(new Color(49,51,56));
        p.setLayout(new BorderLayout());
        p.add(margin_p, BorderLayout.SOUTH);
        margin_p.setBackground(new Color(49,51,56));
        margin_p.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        //margin_p.add(ref);



        fr.setSize(1000,600);
        fr.setVisible(true);

    }

    public JButton getRef() {
        return ref;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(create_pro)){
            new ProjectCreate();
        }
    }
}
