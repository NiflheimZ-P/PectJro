package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import javax.swing.*;
import java.awt.*;

public class task_view extends JPanel{

    private JPanel pl;

    public task_view(){

        pl = new JPanel();
        pl.setLayout(new GridLayout(10,1));
        for (int i = 0; i < 10; i++){
            pl.add(new task_select());
        }
        this.add(pl);
        this.setPreferredSize(new Dimension(600,1000));

        this.setVisible(true);
    }

}
