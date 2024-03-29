package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class task_select extends JPanel{
    private JPanel pl;
    private JLabel name, desc;
    public task_select(){
        pl = new JPanel();

        name = new JLabel("   "+"Project Name");
        desc = new JLabel("  - "+"Cum ar thi buy");

        pl.setLayout(new GridLayout(2,1));
        this.add(pl);
        pl.add(name);
        name.setFont(new Font("Sans", Font.BOLD, 18));
        pl.add(desc);
        desc.setFont(new Font("Sans", Font.PLAIN, 14));
        pl.setBorder(new LineBorder(new Color(30,31,34)));
        this.setBackground(new Color(49,51,56));
        this.setVisible(true);
        pl.setPreferredSize(new Dimension(550,80));
    }
}
