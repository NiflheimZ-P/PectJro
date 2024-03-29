package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;
import com.kmitl.pectjro.Frame.Main_Program.home_page;

import java.awt.*;
import javax.swing.*;

public class Task {
    private JPanel fr, p, margin_p;
    private JButton ref;

    public JPanel getFrame() {
        return fr;
    }


    public Task(){
        fr = new JPanel();
        ref = new JButton("Refresh");
        ref.setEnabled(false);

        p = new JPanel();
        margin_p = new JPanel();

        fr.setLayout(new BorderLayout(20, 20));
        fr.setBackground(new Color(49,51,56));
        fr.add(new task_view());
        fr.add(p, BorderLayout.WEST);

        p.setBackground(new Color(49,51,56));
        p.setLayout(new BorderLayout());
        p.add(margin_p, BorderLayout.SOUTH);
        margin_p.setBackground(new Color(49,51,56));
        margin_p.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        margin_p.add(ref);



        fr.setSize(1000,600);
        fr.setVisible(true);

    }

    public JButton getRef() {
        return ref;
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        SwingUtilities.invokeLater(() -> {new Profile(); });
    }

}
